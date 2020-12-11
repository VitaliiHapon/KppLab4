package catalogueStatisticCalculation;


import util.Helper;
import java.io.File;
import java.time.Clock;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Pattern;

public class StatisticTaskThreads implements StatisticTask {
    private File catalogue;
    private AtomicLong countByMin= new AtomicLong();
    private AtomicLong countByPat= new AtomicLong();
    private AtomicLong sizeByMin= new AtomicLong();
    private AtomicLong sizeByPat= new AtomicLong();

    private AtomicLong totalCats= new AtomicLong();
    private AtomicLong totalFiles= new AtomicLong();
    private AtomicLong totalSize = new AtomicLong();
    private AtomicBoolean running = new AtomicBoolean();

    private Pattern pattern;
    private long minSize;

    private AtomicLong waiting = new AtomicLong();
    private AtomicLong done = new AtomicLong();
    private long startTime = 0;
    private long endTime = -1;

    private List<Thread> threads;

    private ConcurrentLinkedDeque files = new ConcurrentLinkedDeque();

    public StatisticTaskThreads(File catalogue, String pattern, long minSize, long threads){
        this.catalogue = catalogue;
        this.pattern = Pattern.compile(pattern);
        this.minSize = minSize;
        this.running.set(true);

        this.threads = new ArrayList<Thread>();

        for(int i = 0; i < threads; i++){
            this.threads.add(new Thread(()->{
                //while(done.get() == 0) Thread.yield();

                do{
                    try {
                        File file = (File) files.remove();
                        inspectCatalogue(file);
                        done.incrementAndGet();
                    }
                    catch (Throwable e){}


                }while(done.get() != waiting.get());
                stop();
            }));

            //this.threads.get(i).start();
        }

    }

    private void inspectCatalogue(File file){

        if(!running.get() || file == null || !file.exists()) {
            if(done.get() == waiting.get())
                stop();
            return;
        }

        if(file.isDirectory()){
            totalCats.incrementAndGet();
            for(var f : file.listFiles()) {
                waiting.incrementAndGet();
                files.add(f);
            }
        }
        else if(file.isFile()){
            var fileSize = file.length();
            if(fileSize >= minSize){
                countByMin.incrementAndGet();
                sizeByMin.addAndGet(fileSize);
            }

            if(Helper.checkNamePattern(pattern, file)){
                countByPat.incrementAndGet();
                sizeByPat.addAndGet(fileSize);
            }

            totalFiles.incrementAndGet();
            totalSize.addAndGet(fileSize);
        }
    }

    @Override
    public void start() {
        running.set(true);

        Clock clock = Clock.systemDefaultZone();
        startTime = clock.millis();

        inspectCatalogue(catalogue);

        for(var t: threads){
            t.start();
        }

    }

    @Override
    public void stop() {
        running.set(false);

        Clock clock = Clock.systemDefaultZone();
        endTime = clock.millis();
    }

    @Override
    public List<String> getThreadsInfo() {
        List<String> list = new ArrayList<>();
        for(var t: threads){
            list.add(t.getName() + ", priority: " + t.getPriority() + ", state: " + t.getState() +", is alive: " + t.isAlive());
        }
        return list;
    }

    @Override
    public boolean isRunning() {
        return running.get();
    }

    @Override
    public long getCountByMinSize() {
        return countByMin.get();
    }

    @Override
    public long getCountByPattern() {
        return countByPat.get();
    }

    @Override
    public long getSizeByMinSize() {
        return sizeByMin.get();
    }

    @Override
    public long getSizeByPattern() {
        return sizeByPat.get();
    }

    @Override
    public long getTotalSubcatalogues() {
        return totalCats.get();
    }

    @Override
    public long getTotalFilesCount() {
        return totalFiles.get();
    }

    @Override
    public long getTotalSize() {
        return totalSize.get();
    }

    @Override
    public long getTimeTaken() {
        if(endTime == -1)
            return -1;
        return endTime - startTime;
    }
}

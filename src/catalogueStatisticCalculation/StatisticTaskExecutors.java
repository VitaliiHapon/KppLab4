package catalogueStatisticCalculation;

import util.Helper;

import java.io.File;
import java.time.Clock;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Pattern;



public class StatisticTaskExecutors implements StatisticTask {
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

    ExecutorService executor;

    public StatisticTaskExecutors(File catalogue, String pattern, long minSize, long threads){
        this.catalogue = catalogue;
        this.pattern = Pattern.compile(pattern);
        this.minSize = minSize;
        this.running.set(true);

        executor = Executors.newFixedThreadPool((int) threads);

    }

    private void inspectCatalogue(File file){

        if(!running.get() || file == null || !file.exists()) {
            if(done.get() == waiting.get())
                stop();
            return;
        }

        if(file.isDirectory()){
            totalCats.incrementAndGet();
            List<Runnable> tasks = new ArrayList<>();
            for(var f : file.listFiles()) {
                waiting.incrementAndGet();

                executor.execute(() ->{
                    inspectCatalogue(f);
                    if(done.get() == waiting.get())
                        stop();
                });
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
        done.incrementAndGet();
        if(done.get() == waiting.get())
            stop();
    }

    @Override
    public void start() {
        running.set(true);

        Clock clock = Clock.systemDefaultZone();
        startTime = clock.millis();

        inspectCatalogue(catalogue);


    }

    @Override
    public void stop() {
        running.set(false);

        Clock clock = Clock.systemDefaultZone();
        endTime = clock.millis();
        executor.shutdownNow();
    }

    @Override
    public List<String> getThreadsInfo() {
        return Arrays.asList("<executors service");

        //executor.
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

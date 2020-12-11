package catalogueStatisticCalculation;

import util.Helper;

import java.io.File;
import java.time.Clock;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Pattern;

public class StatisticTaskNonParallel implements StatisticTask {
    File catalogue;
    AtomicLong countByMin= new AtomicLong();
    AtomicLong countByPat= new AtomicLong();
    AtomicLong sizeByMin= new AtomicLong();
    AtomicLong sizeByPat= new AtomicLong();

    AtomicLong totalCats= new AtomicLong();
    AtomicLong totalFiles= new AtomicLong();
    AtomicLong totalSize = new AtomicLong();
    AtomicBoolean running = new AtomicBoolean();

    Pattern pattern;
    long minSize;

    long counter = 0;
    long startTime = 0;
    long endTime = -1;

    public StatisticTaskNonParallel(File catalogue, String pattern, long minSize){
        this.catalogue = catalogue;
        this.pattern = Pattern.compile(pattern);
        this.minSize = minSize;
        this.running.set(true);


    }

    private void inspectCatalogue(File file){
        counter++;
        if(!running.get() || file == null || !file.exists()) {
            counter--;
            if(counter == 0){
                stop();
            }
            return;
        }

        if(file.isDirectory()){
            totalCats.incrementAndGet();
            for(var f :file.listFiles()){
                inspectCatalogue(f);
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
        counter--;

        if(counter == 0){
            stop();
        }
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
    }

    @Override
    public List<String> getThreadsInfo() {
        return Arrays.asList("<non parallel algorithm>");
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

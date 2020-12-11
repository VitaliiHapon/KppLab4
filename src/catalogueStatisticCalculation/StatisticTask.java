package catalogueStatisticCalculation;

import java.util.List;

public interface StatisticTask {
    void start();
    void stop();

    List<String> getThreadsInfo();

    boolean isRunning();

    long getCountByMinSize();
    long getCountByPattern();

    long getSizeByMinSize();
    long getSizeByPattern();

    long getTotalSubcatalogues();
    long getTotalFilesCount();
    long getTotalSize();

    long getTimeTaken();
}

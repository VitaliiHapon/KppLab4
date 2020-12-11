package com.lab4kpp;

import catalogueStatisticCalculation.StatisticTask;
import catalogueStatisticCalculation.StatisticTaskExecutors;
import catalogueStatisticCalculation.StatisticTaskNonParallel;
import catalogueStatisticCalculation.StatisticTaskThreads;
import gui.AppGui;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;


public class Main{

    static AppGui gui;
    public static void main(String[] args) {

        JFrame.setDefaultLookAndFeelDecorated(true);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch(Exception ignored){}

        javax.swing.SwingUtilities.invokeLater(() ->
        {
            gui = new AppGui();

            gui.setOnRunClicked(() ->{
                StatisticTask task= null;

                if(gui.getMinSize() < 0){
                    gui.showError("Incorrect minimal file size!");
                    return;
                }

                if(gui.getThreadType() == AppGui.ThreadType.NON_PARALLEL)
                    task = new StatisticTaskNonParallel(gui.getSelectedFile(),gui.getPatter(), gui.getMinSize());
                else if(gui.getThreadType() == AppGui.ThreadType.EXECUTOR)
                    task = new StatisticTaskExecutors(gui.getSelectedFile(),gui.getPatter(), gui.getMinSize(), gui.getThreadCount());
                else if(gui.getThreadType() == AppGui.ThreadType.REGULAR)
                    task = new StatisticTaskThreads(gui.getSelectedFile(),gui.getPatter(), gui.getMinSize(), gui.getThreadCount());

                final var t = task;
                gui.setOnStopClicked(() ->{
                    t.stop();
                });

                new Thread(()-> {

                    t.start();
                    setGuiFromTask(t, gui);
                }).start();

                new Thread(()->{

                    do {
                        setGuiFromTask(t, gui);
                        gui.setStatus(t.isRunning(), t.getThreadsInfo());
                        try {
                            Thread.sleep(80);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }while(t.isRunning());

                    setGuiFromTask(t, gui);
                    gui.setStatus(t.isRunning(), t.getThreadsInfo());

                }).start();


            });
        });
    }

    private static void setGuiFromTask(StatisticTask task, AppGui gui){
        gui.setCountByMin(task.getCountByMinSize());
        gui.setCountByPat(task.getCountByPattern());
        gui.setTotalSizeByMin(task.getSizeByMinSize());
        gui.setTotalSizeByPat(task.getSizeByPattern());

        gui.setTotalSize(task.getTotalSize());
        gui.setCatCount(task.getTotalSubcatalogues());
        gui.setFilesCount(task.getTotalFilesCount());

        gui.setTimeTaken(task.getTimeTaken());
    }
}
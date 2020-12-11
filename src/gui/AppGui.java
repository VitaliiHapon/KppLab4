package gui;

import util.Helper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class AppGui extends AbstractAppGui {


    public enum ThreadType{
        REGULAR,
        EXECUTOR,
        NON_PARALLEL
    }

    public interface GuiAction {
        void action();
    }

    public interface OnEditAction{
        void action(String text);
    }

    private GuiAction onRunClicked;
    private GuiAction onStopClicked;
    private GuiAction onCatalogueSelected;

    private long timeTaken = -1;

    File selectedFile;


    public void setOnCatalogueSelected(GuiAction onCatalogueSelected) {
        this.onCatalogueSelected = onCatalogueSelected;
    }

    public void setOnRunClicked(GuiAction onRunClicked) {
        this.onRunClicked = onRunClicked;
    }

    public void setOnStopClicked(GuiAction onStopClicked) {
        this.onStopClicked = onStopClicked;
    }

    public AppGui(){
        super();
        minSizeField.setText("10 Kb");
        patSizeField.setText(".+");
        threadsField.setText("10");
        timeTakenLabel.setText("-");
        minCountLabel.setText("-");
        patCountLabel.setText("-");

        minTotalSizeLabel.setText("-");
        patTotalSizeLabel.setText("-");

        totalCatLabel.setText("-");
        totalFilesLabel.setText("-");
        totalSizeLabel.setText("-");

        stopButton.setEnabled(false);


        aRadio.addActionListener(e -> {
            aRadio.setSelected(true);
            bRadio.setSelected(false);
        });

        bRadio.addActionListener(e -> {
            bRadio.setSelected(true);
            aRadio.setSelected(false);
        });

        checkBox.addActionListener(e -> {
            setThreadControlActive(!checkBox.isSelected());
        });

        runButton.addActionListener(e ->{
            if(onRunClicked != null){
                onRunClicked.action();
            }
        });

        stopButton.addActionListener(e ->{
            if(onStopClicked != null){
                onStopClicked.action();
            }
        });

        selectCatButton.addActionListener(e->{
            JFileChooser chooser = new JFileChooser();
            chooser.setDialogTitle("Choose catalogue!");
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

            if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                selectedFile = chooser.getSelectedFile();
            }
        });
    }

    public ThreadType getThreadType(){
        if(checkBox.isSelected())
            return ThreadType.NON_PARALLEL;

        if(aRadio.isSelected())
            return ThreadType.REGULAR;


        return ThreadType.EXECUTOR;
    }

    public synchronized void setStatus(boolean isRunning, List<String> threadsStatus){
        threadsListModel.removeAllElements();
        int pos = 0;
        for(var s: threadsStatus) {
            threadsListModel.addElement(s);
        }

        minSizeField.setEnabled(!isRunning);
        patSizeField.setEnabled(!isRunning);
        threadsField.setEnabled(!isRunning);
        runButton.setEnabled(!isRunning);
        stopButton.setEnabled(isRunning);
        checkBox.setEnabled(!isRunning);
        selectCatButton.setEnabled(!isRunning);
        aRadio.setEnabled(!isRunning);
        bRadio.setEnabled(!isRunning);

        boolean active = !checkBox.isSelected();
        threadsField.setEnabled(active);
        aRadio.setEnabled(active);
        bRadio.setEnabled(active);

        if(isRunning){
            timeTakenLabel.setText("(Running)");
        }
        else if(timeTaken > 0){
            timeTakenLabel.setText(String.format("%.2f",timeTaken/ 1000.0) + " sec.");
        }
        else{
            timeTakenLabel.setText("-");
        }

    }

    private void setThreadControlActive(boolean active){
        threadsField.setEnabled(active);
        aRadio.setEnabled(active);
        bRadio.setEnabled(active);
    }

    public File getSelectedFile() {
        return selectedFile;
    }

    public void setCountByMin(long count){
        minCountLabel.setText(String.valueOf(count));
    }

    public void setCountByPat(long count){
        patCountLabel.setText(String.valueOf(count));
    }

    public void setTotalSizeByMin(long size){
        minTotalSizeLabel.setText(Helper.bytesSizeToString(size));
    }

    public void setTotalSizeByPat(long size){
        patTotalSizeLabel.setText(Helper.bytesSizeToString(size));
    }

    public void setTotalSize(long size){
        totalSizeLabel.setText(Helper.bytesSizeToString(size));
    }

    public void setFilesCount(long count){
        totalFilesLabel.setText(String.valueOf(count));
    }

    public void setCatCount(long count){
        totalCatLabel.setText(String.valueOf(count));
    }

    public void setTimeTaken(long time){
        timeTaken = time;
    }

    public String getPatter(){
        var result = patSizeField.getText();

        try{
            Pattern pat = Pattern.compile(result);
        }
        catch(Throwable t){
            result = ".+";
        }
        if(result.isEmpty()){
            result = ".+";
        }

        patSizeField.setText(result);
        return result;
    }

    public long getMinSize(){
        var result = Helper.stringToSizeInBytes(minSizeField.getText());
        if(result >= 0)
            minSizeField.setText(Helper.bytesSizeToString(result));
        return  result;
    }

    public void showError(String error){
        JOptionPane.showMessageDialog(this, error);
    }

    public long getThreadCount(){
        long result = 2;
        try{
            result = Long.valueOf(threadsField.getText());
        }
        catch (Throwable e){
            result = 2;
        }
        if(result < 2 )
            result = 2;

        threadsField.setText(String.valueOf(result));
        return result;
    }
}

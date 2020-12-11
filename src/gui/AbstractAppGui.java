package gui;


import java.awt.*;
import javax.swing.*;

public class AbstractAppGui extends JFrame {
        public AbstractAppGui() {
            initComponents();
        }

        private void initComponents() {

            panel8 = new JPanel();
            vSpacer2 = new JPanel(null);
            panel2 = new JPanel();
            label1 = new JLabel();
            minSizeField = new JTextField();
            label2 = new JLabel();
            patSizeField = new JTextField();
            panel3 = new JPanel();
            label3 = new JLabel();
            minCountLabel = new JLabel();
            label4 = new JLabel();
            minTotalSizeLabel = new JLabel();
            label5 = new JLabel();
            patCountLabel = new JLabel();
            label6 = new JLabel();
            patTotalSizeLabel = new JLabel();
            panel4 = new JPanel();
            checkBox = new JCheckBox();
            label10 = new JLabel();
            threadsField = new JTextField();
            vSpacer1 = new JPanel(null);
            label11 = new JLabel();
            aRadio = new JRadioButton();
            bRadio = new JRadioButton();
            panel1 = new JPanel();
            label7 = new JLabel();
            totalCatLabel = new JLabel();
            label8 = new JLabel();
            totalFilesLabel = new JLabel();
            label9 = new JLabel();
            totalSizeLabel = new JLabel();
            hSpacer1 = new JPanel(null);
            panel7 = new JPanel();
            selectCatButton = new JButton();
            runButton = new JButton();
            stopButton = new JButton();
            panel6 = new JPanel();
            label12 = new JLabel();
            scrollPane1 = new JScrollPane();
            threadsList = new JList(threadsListModel);
            label13 = new JLabel();
            timeTakenLabel = new JLabel();
            hSpacer2 = new JPanel(null);
            vSpacer3 = new JPanel(null);

            //======== this ========
            setResizable(false);
            Container contentPane = getContentPane();
            contentPane.setLayout(new GridBagLayout());
            ((GridBagLayout)contentPane.getLayout()).columnWidths = new int[] {0, 0, 0};
            ((GridBagLayout)contentPane.getLayout()).rowHeights = new int[] {0, 0, 0};
            ((GridBagLayout)contentPane.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0E-4};
            ((GridBagLayout)contentPane.getLayout()).rowWeights = new double[] {0.0, 0.0, 1.0E-4};

            //======== panel8 ========
            {
                panel8.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax.
                        swing. border. EmptyBorder( 0, 0, 0, 0) , "", javax. swing. border
                        . TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog"
                        ,java .awt .Font .BOLD ,12 ), java. awt. Color. red) ,panel8. getBorder
                        ( )) ); panel8. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java
                                                                                                                                                             .beans .PropertyChangeEvent e) {if ("bord\u0065r" .equals (e .getPropertyName () )) throw new RuntimeException
                    ( ); }} );
                panel8.setLayout(new GridBagLayout());
                ((GridBagLayout)panel8.getLayout()).columnWidths = new int[] {0, 0, 0, 0};
                ((GridBagLayout)panel8.getLayout()).rowHeights = new int[] {0, 69, 0, 0, 0};
                ((GridBagLayout)panel8.getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 1.0E-4};
                ((GridBagLayout)panel8.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 1.0E-4};
                panel8.add(vSpacer2, new GridBagConstraints(1, 0, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 7, 0), 0, 0));

                //======== panel2 ========
                {
                    panel2.setLayout(new GridBagLayout());
                    ((GridBagLayout)panel2.getLayout()).columnWidths = new int[] {0, 120, 0};
                    ((GridBagLayout)panel2.getLayout()).rowHeights = new int[] {0, 0, 0};
                    ((GridBagLayout)panel2.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0E-4};
                    ((GridBagLayout)panel2.getLayout()).rowWeights = new double[] {0.0, 0.0, 1.0E-4};

                    //---- label1 ----
                    label1.setText("File minimal size:");
                    panel2.add(label1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                            GridBagConstraints.BASELINE_TRAILING, GridBagConstraints.NONE,
                            new Insets(0, 0, 7, 7), 0, 0));
                    panel2.add(minSizeField, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                            GridBagConstraints.BASELINE, GridBagConstraints.HORIZONTAL,
                            new Insets(0, 0, 7, 0), 0, 0));

                    //---- label2 ----
                    label2.setText("File name pattern:");
                    panel2.add(label2, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                            GridBagConstraints.BASELINE_TRAILING, GridBagConstraints.NONE,
                            new Insets(0, 0, 0, 7), 0, 0));
                    panel2.add(patSizeField, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                            GridBagConstraints.BASELINE, GridBagConstraints.HORIZONTAL,
                            new Insets(0, 0, 0, 0), 0, 0));
                }
                panel8.add(panel2, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                        GridBagConstraints.BASELINE, GridBagConstraints.HORIZONTAL,
                        new Insets(0, 0, 7, 7), 0, 0));

                //======== panel3 ========
                {
                    panel3.setLayout(new GridBagLayout());
                    ((GridBagLayout)panel3.getLayout()).columnWidths = new int[] {0, 72, 0, 0, 0, 0};
                    ((GridBagLayout)panel3.getLayout()).rowHeights = new int[] {0, 0, 0};
                    ((GridBagLayout)panel3.getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};
                    ((GridBagLayout)panel3.getLayout()).rowWeights = new double[] {0.0, 0.0, 1.0E-4};

                    //---- label3 ----
                    label3.setText("count:");
                    panel3.add(label3, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                            GridBagConstraints.BASELINE_TRAILING, GridBagConstraints.NONE,
                            new Insets(0, 0, 7, 7), 0, 0));

                    //---- minCountLabel ----
                    minCountLabel.setText("43");
                    panel3.add(minCountLabel, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                            GridBagConstraints.BASELINE, GridBagConstraints.HORIZONTAL,
                            new Insets(0, 0, 7, 7), 0, 0));

                    //---- label4 ----
                    label4.setText("total size:");
                    panel3.add(label4, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0,
                            GridBagConstraints.BASELINE_TRAILING, GridBagConstraints.NONE,
                            new Insets(0, 0, 7, 7), 0, 0));

                    //---- minTotalSizeLabel ----
                    minTotalSizeLabel.setText(" 434 mb");
                    panel3.add(minTotalSizeLabel, new GridBagConstraints(4, 0, 1, 1, 0.0, 0.0,
                            GridBagConstraints.BASELINE, GridBagConstraints.HORIZONTAL,
                            new Insets(0, 0, 7, 0), 0, 0));

                    //---- label5 ----
                    label5.setText("count:");
                    panel3.add(label5, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                            GridBagConstraints.BASELINE_TRAILING, GridBagConstraints.NONE,
                            new Insets(0, 0, 0, 7), 0, 0));

                    //---- patCountLabel ----
                    patCountLabel.setText("55");
                    panel3.add(patCountLabel, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                            GridBagConstraints.BASELINE, GridBagConstraints.HORIZONTAL,
                            new Insets(0, 0, 0, 7), 0, 0));

                    //---- label6 ----
                    label6.setText("total size: ");
                    panel3.add(label6, new GridBagConstraints(3, 1, 1, 1, 0.0, 0.0,
                            GridBagConstraints.BASELINE_TRAILING, GridBagConstraints.NONE,
                            new Insets(0, 0, 0, 7), 0, 0));

                    //---- patTotalSizeLabel ----
                    patTotalSizeLabel.setText("434 mb");
                    panel3.add(patTotalSizeLabel, new GridBagConstraints(4, 1, 1, 1, 0.0, 0.0,
                            GridBagConstraints.BASELINE, GridBagConstraints.HORIZONTAL,
                            new Insets(0, 0, 0, 0), 0, 0));
                }
                panel8.add(panel3, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0,
                        GridBagConstraints.BASELINE_TRAILING, GridBagConstraints.NONE,
                        new Insets(0, 0, 7, 0), 0, 0));

                //======== panel4 ========
                {
                    panel4.setLayout(new GridBagLayout());
                    ((GridBagLayout)panel4.getLayout()).columnWidths = new int[] {46, 137, 0};
                    ((GridBagLayout)panel4.getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0};
                    ((GridBagLayout)panel4.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0E-4};
                    ((GridBagLayout)panel4.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

                    //---- checkBox ----
                    checkBox.setText("use non parallel algorithm");
                    panel4.add(checkBox, new GridBagConstraints(0, 0, 2, 1, 0.0, 0.0,
                            GridBagConstraints.BASELINE, GridBagConstraints.HORIZONTAL,
                            new Insets(0, 0, 7, 0), 0, 0));

                    //---- label10 ----
                    label10.setText("Threads count:");
                    panel4.add(label10, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                            GridBagConstraints.BASELINE, GridBagConstraints.HORIZONTAL,
                            new Insets(0, 0, 7, 7), 0, 0));
                    panel4.add(threadsField, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                            GridBagConstraints.BASELINE, GridBagConstraints.HORIZONTAL,
                            new Insets(0, 0, 7, 0), 0, 0));
                    panel4.add(vSpacer1, new GridBagConstraints(0, 2, 2, 1, 0.0, 0.0,
                            GridBagConstraints.BASELINE, GridBagConstraints.HORIZONTAL,
                            new Insets(0, 0, 7, 0), 0, 0));

                    //---- label11 ----
                    label11.setText("Threads type:");
                    panel4.add(label11, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
                            GridBagConstraints.BASELINE, GridBagConstraints.HORIZONTAL,
                            new Insets(0, 0, 7, 7), 0, 0));

                    //---- aRadio ----
                    aRadio.setText("Regular threads");
                    aRadio.setSelected(true);
                    panel4.add(aRadio, new GridBagConstraints(0, 4, 2, 1, 0.0, 0.0,
                            GridBagConstraints.BASELINE, GridBagConstraints.HORIZONTAL,
                            new Insets(0, 0, 7, 0), 0, 0));

                    //---- bRadio ----
                    bRadio.setText("Executors");
                    panel4.add(bRadio, new GridBagConstraints(0, 5, 2, 1, 0.0, 0.0,
                            GridBagConstraints.BASELINE, GridBagConstraints.HORIZONTAL,
                            new Insets(0, 0, 0, 0), 0, 0));
                }
                panel8.add(panel4, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
                        GridBagConstraints.BASELINE_LEADING, GridBagConstraints.NONE,
                        new Insets(0, 0, 7, 7), 0, 0));

                //======== panel1 ========
                {
                    panel1.setLayout(new GridBagLayout());
                    ((GridBagLayout)panel1.getLayout()).columnWidths = new int[] {162, 0, 0};
                    ((GridBagLayout)panel1.getLayout()).rowHeights = new int[] {0, 0, 0, 0};
                    ((GridBagLayout)panel1.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0E-4};
                    ((GridBagLayout)panel1.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 1.0E-4};

                    //---- label7 ----
                    label7.setText("Total subcatalogues:");
                    panel1.add(label7, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                            GridBagConstraints.BASELINE_TRAILING, GridBagConstraints.NONE,
                            new Insets(0, 0, 7, 7), 0, 0));

                    //---- totalCatLabel ----
                    totalCatLabel.setText("3");
                    panel1.add(totalCatLabel, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                            GridBagConstraints.BASELINE, GridBagConstraints.HORIZONTAL,
                            new Insets(0, 0, 7, 0), 0, 0));

                    //---- label8 ----
                    label8.setText("Total files:");
                    panel1.add(label8, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                            GridBagConstraints.BASELINE_TRAILING, GridBagConstraints.NONE,
                            new Insets(0, 0, 7, 7), 0, 0));

                    //---- totalFilesLabel ----
                    totalFilesLabel.setText("3");
                    panel1.add(totalFilesLabel, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                            GridBagConstraints.BASELINE, GridBagConstraints.HORIZONTAL,
                            new Insets(0, 0, 7, 0), 0, 0));

                    //---- label9 ----
                    label9.setText("Total size:");
                    panel1.add(label9, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                            GridBagConstraints.BASELINE_TRAILING, GridBagConstraints.NONE,
                            new Insets(0, 0, 0, 7), 0, 0));

                    //---- totalSizeLabel ----
                    totalSizeLabel.setText("2");
                    panel1.add(totalSizeLabel, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
                            GridBagConstraints.BASELINE, GridBagConstraints.HORIZONTAL,
                            new Insets(0, 0, 0, 0), 0, 0));
                }
                panel8.add(panel1, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0,
                        GridBagConstraints.BASELINE_TRAILING, GridBagConstraints.NONE,
                        new Insets(0, 0, 7, 0), 0, 0));
                panel8.add(hSpacer1, new GridBagConstraints(0, 1, 1, 3, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 7), 0, 0));

                //======== panel7 ========
                {
                    panel7.setLayout(new GridBagLayout());
                    ((GridBagLayout)panel7.getLayout()).columnWidths = new int[] {238, 0};
                    ((GridBagLayout)panel7.getLayout()).rowHeights = new int[] {0, 0, 0, 0};
                    ((GridBagLayout)panel7.getLayout()).columnWeights = new double[] {0.0, 1.0E-4};
                    ((GridBagLayout)panel7.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 1.0E-4};

                    //---- selectCatButton ----
                    selectCatButton.setText("Select catalogue");
                    panel7.add(selectCatButton, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                            GridBagConstraints.BASELINE, GridBagConstraints.HORIZONTAL,
                            new Insets(0, 0, 7, 0), 0, 0));

                    //---- runButton ----
                    runButton.setText("Run");
                    panel7.add(runButton, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                            GridBagConstraints.BASELINE, GridBagConstraints.HORIZONTAL,
                            new Insets(0, 0, 7, 0), 0, 0));

                    //---- stopButton ----
                    stopButton.setText("Stop");
                    panel7.add(stopButton, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                            GridBagConstraints.BASELINE, GridBagConstraints.HORIZONTAL,
                            new Insets(0, 0, 0, 0), 0, 0));
                }
                panel8.add(panel7, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
                        GridBagConstraints.BASELINE, GridBagConstraints.NONE,
                        new Insets(0, 0, 0, 7), 0, 0));

                //======== panel6 ========
                {
                    panel6.setLayout(new GridBagLayout());
                    ((GridBagLayout)panel6.getLayout()).columnWidths = new int[] {237, 0, 0};
                    ((GridBagLayout)panel6.getLayout()).rowHeights = new int[] {0, 0, 0, 0};
                    ((GridBagLayout)panel6.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0E-4};
                    ((GridBagLayout)panel6.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 1.0E-4};

                    //---- label12 ----
                    label12.setText("Threads status:");
                    panel6.add(label12, new GridBagConstraints(0, 0, 2, 1, 0.0, 0.0,
                            GridBagConstraints.BASELINE, GridBagConstraints.HORIZONTAL,
                            new Insets(0, 0, 7, 0), 0, 0));

                    //======== scrollPane1 ========
                    {
                        scrollPane1.setViewportView(threadsList);
                    }
                    panel6.add(scrollPane1, new GridBagConstraints(0, 1, 2, 1, 0.0, 0.0,
                            GridBagConstraints.BASELINE, GridBagConstraints.HORIZONTAL,
                            new Insets(0, 0, 7, 0), 0, 0));

                    //---- label13 ----
                    label13.setText("Time taken:");
                    panel6.add(label13, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                            GridBagConstraints.BASELINE_TRAILING, GridBagConstraints.NONE,
                            new Insets(0, 0, 0, 7), 0, 0));

                    //---- label19 ----
                    timeTakenLabel.setText("(Running)");
                    panel6.add(timeTakenLabel, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
                            GridBagConstraints.BASELINE, GridBagConstraints.HORIZONTAL,
                            new Insets(0, 0, 0, 0), 0, 0));
                }
                panel8.add(panel6, new GridBagConstraints(2, 3, 1, 1, 0.0, 0.0,
                        GridBagConstraints.BASELINE_TRAILING, GridBagConstraints.NONE,
                        new Insets(0, 0, 0, 0), 0, 0));
            }
            contentPane.add(panel8, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                    new Insets(0, 0, 7, 7), 0, 0));
            contentPane.add(hSpacer2, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.BASELINE, GridBagConstraints.HORIZONTAL,
                    new Insets(0, 0, 7, 0), 0, 0));
            contentPane.add(vSpacer3, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                    new Insets(0, 0, 0, 7), 0, 0));
            pack();
            setLocationRelativeTo(getOwner());
            setVisible(true);
        }

        private JPanel panel8;
        private JPanel vSpacer2;
        private JPanel panel2;
        private JLabel label1;
        protected JTextField minSizeField;
        private JLabel label2;
        protected JTextField patSizeField;
        private JPanel panel3;
        private JLabel label3;
        protected JLabel minCountLabel;
        private JLabel label4;
        protected JLabel minTotalSizeLabel;
        private JLabel label5;
        protected JLabel patCountLabel;
        private JLabel label6;
        protected JLabel patTotalSizeLabel;
        private JPanel panel4;
        protected JCheckBox checkBox;
        private JLabel label10;
        protected JTextField threadsField;
        private JPanel vSpacer1;
        private JLabel label11;
        protected JRadioButton aRadio;
        protected JRadioButton bRadio;
        private JPanel panel1;
        private JLabel label7;
        protected JLabel totalCatLabel;
        private JLabel label8;
        protected JLabel totalFilesLabel;
        private JLabel label9;
        protected JLabel totalSizeLabel;
        private JPanel hSpacer1;
        private JPanel panel7;
        protected JButton selectCatButton;
        protected JButton runButton;
        protected JButton stopButton;
        private JPanel panel6;
        private JLabel label12;
        private JScrollPane scrollPane1;
        protected JList<String> threadsList;
        private JLabel label13;
        protected JLabel timeTakenLabel;
        private JPanel hSpacer2;
        private JPanel vSpacer3;

        DefaultListModel threadsListModel = new DefaultListModel();
    }
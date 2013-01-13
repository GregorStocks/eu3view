package com.buttware.eu3view;

import editor.mapmode.CountryMode;
import editor.mapmode.CtryReligionMode;
import editor.mapmode.CustomMode;
import editor.mapmode.DiscreteScalingMapMode;
import editor.mapmode.MapMode;
import editor.mapmode.OwnerControllerMode;
import editor.mapmode.ReligionMode;
import eug.parser.EUGFileIO;
import eug.parser.ParserSettings;
import eug.shared.GenericObject;
import eug.specific.eu3.EU3SaveGame;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.NumberFormat;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;

public class EU3View extends javax.swing.JFrame {
    private String startYear = "1399";
    private String endYear = "1820";
    private EU3SaveGame save = null;
    
    private static final ParserSettings defaultSettings =
            ParserSettings.getNoCommentSettings().setPrintTimingInfo(false);

    public EU3View() {
        initComponents();
        if (new File(Main.filenameResolver.resolveFilename("common/faction.txt")).exists()) {
            // DW
            jComboBox1.setSelectedIndex(2); // bigger map
        }
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loadFromField = new javax.swing.JTextField();
        loadBrowseButton = new javax.swing.JButton();
        modeComboBox = new javax.swing.JComboBox();
        showBordersCheckbox = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        startYearField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        endYearField = new javax.swing.JTextField();
        resetButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        yearIntervalField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        frameDelayField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        renderToField = new javax.swing.JTextField();
        renderBrowseButton = new javax.swing.JButton();
        renderButton = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        showDateCheckbox = new javax.swing.JCheckBox();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("EU3View 1.1");

        loadFromField.setText(Main.filenameResolver.getModDirName() + "save games");

        loadBrowseButton.setText("Browse");
        loadBrowseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadBrowseButtonActionPerformed(evt);
            }
        });

        modeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Country", "Owner/Controller", "Religion", "State religion", "Tax value", "Manpower", "Population", "Native size", "Centers of trade" }));

        showBordersCheckbox.setText("Show borders");

        jLabel1.setText("Scale:");

        jLabel3.setText("Years:");

        startYearField.setEditable(false);
        startYearField.setText("1399");

        jLabel4.setText("to");

        endYearField.setEditable(false);
        endYearField.setText("1820");

        resetButton.setText("Reset");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });

        jLabel5.setText("Year interval:");

        yearIntervalField.setText("1");

        jLabel6.setText("Frame delay:");

        frameDelayField.setText("200");

        jLabel8.setText("Render to:");

        renderBrowseButton.setText("Browse");
        renderBrowseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                renderBrowseButtonActionPerformed(evt);
            }
        });

        renderButton.setText("Render");
        renderButton.setEnabled(false);
        renderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                renderButtonActionPerformed(evt);
            }
        });

        jComboBox1.setEditable(true);
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "6.25%", "12.5%", "25%", "33.333%", "50%", "66.666%", "100%", "200%", "400%" }));
        jComboBox1.setSelectedIndex(4);
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel2.setText("milliseconds");

        showDateCheckbox.setSelected(true);
        showDateCheckbox.setText("Show date");

        jMenu1.setText("Help");

        jMenuItem1.setText("About");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(showDateCheckbox)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(modeComboBox, 0, 199, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(showBordersCheckbox)
                                .addGap(33, 33, 33))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(loadFromField, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(loadBrowseButton))
                    .addComponent(jLabel8)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(renderToField, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(renderBrowseButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(renderButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(yearIntervalField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                                    .addComponent(frameDelayField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE))
                                .addGap(7, 7, 7))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBox1, 0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(startYearField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(3, 3, 3)
                                        .addComponent(jLabel4)
                                        .addGap(4, 4, 4)
                                        .addComponent(endYearField, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(resetButton))
                        .addGap(151, 151, 151)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loadBrowseButton)
                    .addComponent(loadFromField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(showBordersCheckbox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(resetButton)
                    .addComponent(jLabel4)
                    .addComponent(startYearField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(endYearField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(yearIntervalField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(frameDelayField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(showDateCheckbox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(renderButton)
                    .addComponent(renderBrowseButton)
                    .addComponent(renderToField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        startYearField.setText(startYear);
        endYearField.setText(endYear);
}//GEN-LAST:event_resetButtonActionPerformed

    private void renderBrowseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_renderBrowseButtonActionPerformed
        JFileChooser f = new JFileChooser(renderToField.getText());
        File fi = new File(renderToField.getText());
        if(fi.isDirectory()) {
            f.setCurrentDirectory(fi);
        }
        else {
            f.setSelectedFile(fi);
        }
        f.setDialogTitle("Render To File");
        class GIFFileFilter extends FileFilter {
            public boolean accept(File f) {
                if (f.isDirectory()) return true;
                return f.getName().toLowerCase().endsWith("gif");
            }
            public String getDescription()
            {
                return "GIF files";
            }
        }
        f.addChoosableFileFilter(new GIFFileFilter());
        f.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int result = f.showSaveDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            fi = f.getSelectedFile();
            String s = fi.getPath();
            if(!s.equals("")) {
                if (!s.endsWith(".gif")) {
                    s = s + ".gif";
                }
                renderToField.setText(s);
            }
        }
    }//GEN-LAST:event_renderBrowseButtonActionPerformed

    private void renderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_renderButtonActionPerformed
        try {
            if (save == null) {
                JOptionPane.showMessageDialog(null, "nothing loaded", "nothing loaded", JOptionPane.ERROR_MESSAGE);
                return;
            }
            int start = Integer.parseInt(startYearField.getText());
            if(start < Integer.parseInt(startYear)) {
                JOptionPane.showMessageDialog(null, "too early", "too early", JOptionPane.ERROR_MESSAGE);
                return; 
            }
            int end = Integer.parseInt(endYearField.getText());
            if(end > Integer.parseInt(endYear)) {
                JOptionPane.showMessageDialog(null, "too late", "too late", JOptionPane.ERROR_MESSAGE);
                return; 
            }
            int interval = Integer.parseInt(yearIntervalField.getText());
            if(interval <= 0) {
                JOptionPane.showMessageDialog(null, "too small of an interval", "too small of an interval", JOptionPane.ERROR_MESSAGE);
                return; 
            }
            int delay = Integer.parseInt(frameDelayField.getText());
            if(delay <= 0) {
                JOptionPane.showMessageDialog(null, "too small of a delay", "too small of a delay", JOptionPane.ERROR_MESSAGE);
                return; 
            }
            
            String sc = jComboBox1.getSelectedItem().toString();
            double scale = NumberFormat.getPercentInstance().parse(sc).doubleValue();
            boolean showBorders = showBordersCheckbox.isSelected();
            String renderTo = renderToField.getText();
            MapMode m = new CountryMode();
            Object s = modeComboBox.getSelectedItem();
            if(s.equals("Religion")) {
                m = new ReligionMode();
            } else if(s.equals("State religion")) {
                m = new CtryReligionMode();
            } else if(s.equals("Owner/Controller")) {
                m = new OwnerControllerMode();
            } else if(s.equals("Tax value")) {
                m = new DiscreteScalingMapMode("base_tax", 0, 18, 1);
            } else if(s.equals("Manpower")) {
                m = new DiscreteScalingMapMode("manpower", 0, 10, 1);
            } else if(s.equals("Population")) {
                m = new DiscreteScalingMapMode("citysize", 0, 900000, 20000);
            } else if(s.equals("Native size")) {
                m = new DiscreteScalingMapMode("native_size", 0, 100, 1);
            } else if(s.equals("Centers of trade")) {
                m = new CustomMode("cot", "yes");
                System.out.println("OM");
            }
            boolean showDate = showDateCheckbox.isSelected();
            Render.render(save, start, end, interval, delay, showBorders, renderTo, m, scale, showDate);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
                
    }//GEN-LAST:event_renderButtonActionPerformed

    private void loadBrowseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadBrowseButtonActionPerformed
        JFileChooser f = new JFileChooser(loadFromField.getText());
        File fi = new File(loadFromField.getText());
        if(fi.isDirectory()) {
            f.setCurrentDirectory(fi);
        }
        else {
            f.setSelectedFile(fi);
        }
        class SaveGameFileFilter extends javax.swing.filechooser.FileFilter {
            public boolean accept(File f) {
                return f.isDirectory() || f.getName().toLowerCase().endsWith(".eu3");
            }
            
            public String getDescription() {
                return "Europa Universalis 3 saved game files";
            }
        }
        f.addChoosableFileFilter(new SaveGameFileFilter());
        f.setDialogTitle("Open File");
        f.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int result = f.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            fi = f.getSelectedFile();
            loadFromField.setText(fi.getPath());
            
            save = EU3SaveGame.loadSaveGame(fi.getPath(), Main.filenameResolver);
            
            //get date stuff
            String[] date = save.getDate().split("\\.");
            endYear = date[0];
            endYearField.setText(endYear);
            endYearField.setEditable(true);
            
            GenericObject defines =
                    EUGFileIO.load(Main.filenameResolver.resolveFilename("common/defines.txt"), defaultSettings);
            if(defines.contains("start_date")) {
                String sd = defines.getString("start_date");
                int dotpos = sd.indexOf("."); // dates are in format 1399.10.14
                startYear = sd.substring(0, dotpos);
            } else if (defines.containsChild("start_date")) {
                startYear = Integer.toString(defines.getChild("start_date").getInt("year"));
            } else { //not In Nomine
                startYear = "1453";
            }

            startYearField.setText(startYear);
            startYearField.setEditable(true);
            
            renderButton.setEnabled(true);
        }
    }//GEN-LAST:event_loadBrowseButtonActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        new AboutDialog().setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EU3View().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField endYearField;
    private javax.swing.JTextField frameDelayField;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JButton loadBrowseButton;
    private javax.swing.JTextField loadFromField;
    private javax.swing.JComboBox modeComboBox;
    private javax.swing.JButton renderBrowseButton;
    private javax.swing.JButton renderButton;
    private javax.swing.JTextField renderToField;
    private javax.swing.JButton resetButton;
    private javax.swing.JCheckBox showBordersCheckbox;
    private javax.swing.JCheckBox showDateCheckbox;
    private javax.swing.JTextField startYearField;
    private javax.swing.JTextField yearIntervalField;
    // End of variables declaration//GEN-END:variables
    
}

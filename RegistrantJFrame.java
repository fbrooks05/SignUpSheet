/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package SEED;

import javax.swing.JOptionPane;

/**
 *
 * @author Fisher
 */
public class RegistrantJFrame extends javax.swing.JFrame {

    /**
     * Creates new form RegistrantJFrame
     */
    public RegistrantJFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SignUpJButton = new javax.swing.JButton();
        SignInJButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        EventNameJText = new javax.swing.JTextField();
        ClearJButton = new javax.swing.JButton();
        registrantJPanel = new SEED.RegistrantJPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        SignUpJButton.setText("SignUp");
        SignUpJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SignUpJButtonActionPerformed(evt);
            }
        });

        SignInJButton.setText("SignIn");
        SignInJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SignInJButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("EventName");

        ClearJButton.setText("Clear");
        ClearJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(EventNameJText, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(registrantJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(SignUpJButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(SignInJButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ClearJButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(registrantJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EventNameJText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SignUpJButton)
                    .addComponent(SignInJButton)
                    .addComponent(ClearJButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SignUpJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SignUpJButtonActionPerformed
        // TODO add your handling code here:
        
        String ID = this.registrantJPanel.returnID();
        java.io.File activeFolder = new java.io.File("C:\\Users\\Fisher\\Documents\\SEED\\Active");
        activeFolder.mkdirs();
        
        java.io.File outputFile = new java.io.File(activeFolder.getAbsolutePath() + "\\" + ID + ".txt");
        
        boolean resultsActive = FileExistsActive();
        
        if (resultsActive == true) {
            // VIN folder already exists
            JOptionPane.showMessageDialog(rootPane, "Student already exists!", "File Error", JOptionPane.ERROR_MESSAGE);
        } else {
        java.io.FileWriter outputFileWriter;

    //        outputFileName = "RegistrantInfo.txt";

            try {
                this.registrantJPanel.updateUnderlyingObject();

    //            outputFile = new java.io.File(outputFileName);
                outputFileWriter = new java.io.FileWriter(outputFile);

                outputFileWriter.write( this.registrantJPanel.getRegistrant().exportCustom());

                outputFileWriter.close();

            } catch ( java.lang.Exception ex ) {
                System.out.println( ex.toString() );
            }
        }
        
    }//GEN-LAST:event_SignUpJButtonActionPerformed

    private void SignInJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SignInJButtonActionPerformed
        // TODO add your handling code here:
        
        String ID = this.registrantJPanel.returnID();
        java.io.File eventFolder = new java.io.File("C:\\Users\\Fisher\\Documents\\SEED\\Events\\" + EventNameJText.getText());
        eventFolder.mkdirs();
        
        java.io.File outputFile = new java.io.File(eventFolder.getAbsolutePath() + "\\" + ID + ".txt");
        
        boolean resultsEvent = FileExistsEvent();
        
        if (resultsEvent == true) {
            // VIN folder already exists
            JOptionPane.showMessageDialog(rootPane, "Student already exists!", "File Error", JOptionPane.ERROR_MESSAGE);
        } else {
        
        java.io.FileWriter outputFileWriter;

    //        outputFileName = "RegistrantInfo.txt";

            try {
                this.registrantJPanel.updateUnderlyingObject();

    //            outputFile = new java.io.File(outputFileName);
                outputFileWriter = new java.io.FileWriter(outputFile);

                outputFileWriter.write( this.registrantJPanel.getRegistrant().exportCustom());

                outputFileWriter.close();

            } catch ( java.lang.Exception ex ) {
                System.out.println( ex.toString() );
            }
        }
        
    }//GEN-LAST:event_SignInJButtonActionPerformed

    private void ClearJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearJButtonActionPerformed
        // TODO add your handling code here:
        this.registrantJPanel.clearControls();
    }//GEN-LAST:event_ClearJButtonActionPerformed

    public boolean FileExistsActive() {
        boolean results = false;
        
        String ID = this.registrantJPanel.returnID();
        
        java.io.File activeFolder = new java.io.File("C:\\Users\\Fisher\\Documents\\SEED\\Active");
        activeFolder.mkdirs();
        
        java.io.File outputFile = new java.io.File(activeFolder.getAbsolutePath() + "\\" + ID + ".txt");
        
        if ( outputFile.exists() == true ) {
            results = true;
        } else {
            
        }
        
        return( results );
    }
    
    public boolean FileExistsEvent() {
        boolean results = false;
        
        String ID = this.registrantJPanel.returnID();
        
        java.io.File eventFolder = new java.io.File("C:\\Users\\Fisher\\Documents\\SEED\\Events\\" + EventNameJText.getText());
        eventFolder.mkdirs();
        
        java.io.File outputFile = new java.io.File(eventFolder.getAbsolutePath() + "\\" + ID + ".txt");
        
        if ( outputFile.exists() == true ) {
            results = true;
        } else {
            
        }
        
        return( results );
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RegistrantJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrantJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrantJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrantJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrantJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ClearJButton;
    private javax.swing.JTextField EventNameJText;
    private javax.swing.JButton SignInJButton;
    private javax.swing.JButton SignUpJButton;
    private javax.swing.JLabel jLabel1;
    private SEED.RegistrantJPanel registrantJPanel;
    // End of variables declaration//GEN-END:variables
}
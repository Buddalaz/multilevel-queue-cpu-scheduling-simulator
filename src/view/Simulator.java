/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.SimulatorController;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.ProcessSimulator;

/**
 *
 * @author ASUS
 */
public class Simulator extends javax.swing.JFrame {

    /**
     * Creates new form MLQCPUSchedulingView
     */
    public Simulator() {
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        cmbMultiSimulates = new javax.swing.JComboBox<>();
        btnSimulate = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"a",  new Integer(0),  new Integer(3),  new Integer(3),  new Integer(0),  new Integer(3)},
                {"b",  new Integer(2),  new Integer(2),  new Integer(5),  new Integer(1),  new Integer(3)},
                {"c",  new Integer(3),  new Integer(4),  new Integer(9),  new Integer(2),  new Integer(6)}
            },
            new String [] {
                "Process", "Arrival", "Burst", "Complete", "Waiting", "Turnaround"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 18, 504, 359));

        jLabel1.setText("Average Turn Around Time :");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 100, -1, 43));

        jLabel2.setText("Average Waiting Time :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 40, -1, 43));

        jTextField1.setText("3.166666665");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 50, 180, -1));

        jTextField2.setText("7.166666666666667");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 110, 177, -1));

        cmbMultiSimulates.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "FCFS", "SJF", "SRTF", "RR" }));
        jPanel1.add(cmbMultiSimulates, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 170, 100, 30));

        btnSimulate.setText("Simulate");
        btnSimulate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimulateActionPerformed(evt);
            }
        });
        jPanel1.add(btnSimulate, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 170, 95, 32));

        jTextField3.setText("a    b     c    d    e      f\n0    3     5    9    12    17   24 ");
        jPanel1.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 220, 280, 130));

        jButton2.setText("Add");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 360, 80, -1));

        jButton3.setText("Remove");
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 360, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 915, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSimulateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimulateActionPerformed
        // TODO add your handling code here:
        String multiQLMethod = cmbMultiSimulates.getSelectedItem().toString();
        System.out.println("Selected Item is: " + multiQLMethod);

        // Get data from the table
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        List<ProcessSimulator> processes = new ArrayList<>();

        for (int i = 0; i < model.getRowCount(); i++) {
            String processId = (String) model.getValueAt(i, 0);
            int arrivalTime = (int) model.getValueAt(i, 1);
            int burstTime = (int) model.getValueAt(i, 2);
            processes.add(new ProcessSimulator(processId, arrivalTime, burstTime));
        }

        for (ProcessSimulator proList : processes) {
            System.out.println("Process" + proList.getProcessId() + "Arrival" + proList.getArrivalTime() + "Brust" + proList.getBurstTime());
        }
        
        System.out.println("--------------------After-------------------------");
        
        
        switch (multiQLMethod) {
            case "FCFS":
                System.out.println("The CPU schedule Method is: " + multiQLMethod);
                // Call FCFS method in controller
                SimulatorController.calculateFCFS(processes);
                break;
            case "SJF":
                System.out.println("The CPU schedule Method is: " + multiQLMethod);
                // Call SJF method in controller
                SimulatorController.calculateSJF(processes);
                break;
            case "SRTF":
                System.out.println("The CPU schedule Method is: " + multiQLMethod);
                // Call SRTF method in controller
                SimulatorController.calculateSRTF(processes);
                break;
            case "RR":
                System.out.println("The CPU schedule Method is: " + multiQLMethod);
                break;
            default:
                throw new AssertionError();
        }

    }//GEN-LAST:event_btnSimulateActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

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
            java.util.logging.Logger.getLogger(Simulator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Simulator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Simulator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Simulator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Simulator().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSimulate;
    private javax.swing.JComboBox<String> cmbMultiSimulates;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}

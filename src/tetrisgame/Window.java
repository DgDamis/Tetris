package tetrisgame;

import java.awt.Dimension;
import javax.swing.DefaultListModel;

/**
 *
 * @author Adam Šmehýl
 */
public class Window extends javax.swing.JFrame {

    private final Dimension preferredSize = new Dimension(800, 900);
    private Playground pg;
    DefaultListModel model = new DefaultListModel();
    Cube cube;

    /**
     * Creates new form NewJFrame
     */
    public Window() {
        pg = new Playground(this, model);
        this.setPreferredSize(preferredSize);
        initComponents();
        myInitComponents();
    }

    private void myInitComponents() {
        playgroundPanel.add(pg);
        playgroundPanel.setOpaque(Boolean.FALSE);
        GOText.setVisible(Boolean.FALSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        score = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        playgroundPanel = new javax.swing.JPanel();
        GOText = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 900));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("Skóre");

        score.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        score.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        score.setAlignmentX(5.0F);
        score.setAlignmentY(5.0F);
        score.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scoreActionPerformed(evt);
            }
        });

        jButton1.setText("Start");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        playgroundPanel.setBackground(new java.awt.Color(255, 51, 51));
        playgroundPanel.setToolTipText("Herní plocha");
        playgroundPanel.setAlignmentX(50.0F);
        playgroundPanel.setAlignmentY(50.0F);
        playgroundPanel.setMaximumSize(new java.awt.Dimension(1000, 900));
        playgroundPanel.setMinimumSize(new java.awt.Dimension(1000, 900));

        GOText.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        GOText.setText("GAME OVER");

        javax.swing.GroupLayout playgroundPanelLayout = new javax.swing.GroupLayout(playgroundPanel);
        playgroundPanel.setLayout(playgroundPanelLayout);
        playgroundPanelLayout.setHorizontalGroup(
            playgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(playgroundPanelLayout.createSequentialGroup()
                .addGap(143, 143, 143)
                .addComponent(GOText)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        playgroundPanelLayout.setVerticalGroup(
            playgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(playgroundPanelLayout.createSequentialGroup()
                .addGap(359, 359, 359)
                .addComponent(GOText)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(playgroundPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(score, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jLabel1)))
                .addContainerGap(89, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(score, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(playgroundPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 836, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void setGameOver(Boolean status) {
        GOText.setVisible(true);
    }

    public void setSkore(int skore) {
        score.setText(Integer.toString(skore));
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        pg.timer.start();
        pg.addObject();
        pg.skore = 0;
    }//GEN-LAST:event_jButton1ActionPerformed

    private void scoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scoreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_scoreActionPerformed

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
            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Window().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel GOText;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel playgroundPanel;
    private javax.swing.JTextField score;
    // End of variables declaration//GEN-END:variables
}

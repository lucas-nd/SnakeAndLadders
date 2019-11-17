/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import board.Board;
import box.Ladder;
import box.Snake;
import java.util.ArrayList;
import model.Dice;
import model.Player;
import snake.and.ladders.CriaCasasTabuleiro;
import strategy.MoveBox;
import strategy.MoveEnginner;
import strategy.MoveLadder;
import strategy.MoveSnake;

/**
 *
 * @author lucas
 */
public class screenGame extends javax.swing.JFrame {
        Dice d = new Dice();
        
        Player p = new Player();
        
        feedBoard f = new feedBoard();
        
        
        
    /**
     * Creates new form teste
     */
    public screenGame() {
        initComponents();
        feedBoard f = new feedBoard();
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
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(200, 500));
        setPreferredSize(new java.awt.Dimension(950, 700));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setPreferredSize(new java.awt.Dimension(950, 700));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/j1.jpeg"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 570, 40, 60));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/tab2.jpeg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, -1, 600));

        jButton1.setText("Rolar dados");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 570, 90, 30));

        jLabel3.setText("Cobras e Escadas");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 660));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        CriaCasasTabuleiro c = new CriaCasasTabuleiro();
        Board.getInstance().setBoxes(c.criaCasasTabuleiro());
        
        int temp = p.getPosicao()+d.rollDice();
        
        if(Board.getInstance().getBox(temp) instanceof Snake){
            MoveEnginner enginner = new MoveEnginner(new MoveSnake());
            enginner.move(Board.getInstance().getBox(temp), p);
        }else if(Board.getInstance().getBox(temp) instanceof Ladder){
            MoveEnginner enginner = new MoveEnginner(new MoveLadder());
            enginner.move(Board.getInstance().getBox(temp), p);
        }else{
            MoveEnginner enginner = new MoveEnginner(new MoveBox());
            enginner.move(Board.getInstance().getBox(temp), p);
        }
        
        jLabel2.setLocation(f.getX(p), f.getY(p));

        System.out.println(temp);
        System.out.println(p.getPosicao() + " " + p.getEixoX() + " " + p.getEixoY());     
        System.out.println(Board.getInstance().getBox(p.getPosicao()));     
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public void main(String args[]) {
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
            java.util.logging.Logger.getLogger(screenGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(screenGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(screenGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(screenGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new screenGame().setVisible(true);
            }
        });
        
        
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}

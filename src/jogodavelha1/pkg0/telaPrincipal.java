/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodavelha1.pkg0;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.util.Random;

/**
 *
 * @author Usuário
 */
public class telaPrincipal extends javax.swing.JFrame {
    
    JButton b = null;    
    String tipoJogada = null;
    int velha = 0;
    boolean endGame;

    /**
     * Creates new form telaPrincipal
     */
    public telaPrincipal() {
        initComponents();
        setResizable(false);
        setSize(290, 360);
        setTitle("Jogo da Velha 1.0");
        setLocationRelativeTo(null);
        this.getContentPane().setBackground( new Color(51,51,51) );
        b1.setEnabled(false);
        b2.setEnabled(false);
        b3.setEnabled(false);
        b4.setEnabled(false);
        b5.setEnabled(false);
        b6.setEnabled(false);
        b7.setEnabled(false);
        b8.setEnabled(false);
        b9.setEnabled(false);
        
        /*//teste randon
        Random random = new Random();        
        
        int numero2 = 0;
        
        int max, min;
        min = 1;
        max = 9;
        
        while(numero2 != 9){            

            numero2 = random.nextInt(max-min+1)+min;
            System.out.println(numero2);
            
        }*/
    }
    
    private void testdeTexto(String a, String b, String c){
        if(!a.equals("") && !b.equals("") && !c.equals("")){
            
            if((a.equals(b)) && (b.equals(c))){
                
                endGame = true;
                encerrar("Fim do jogo: ("+a+") Ganhou");
                
            }
        }
    }
    
    private void testarCondicao(){

        String tb1 = b1.getText();
        String tb2 = b2.getText();
        String tb3 = b3.getText();
        String tb4 = b4.getText();
        String tb5 = b5.getText();
        String tb6 = b6.getText();
        String tb7 = b7.getText();
        String tb8 = b8.getText();
        String tb9 = b9.getText();

        testdeTexto(tb1,tb2,tb3);
        testdeTexto(tb4,tb5,tb6);
        testdeTexto(tb7,tb8,tb9);
        testdeTexto(tb1,tb4,tb7);
        testdeTexto(tb2,tb5,tb8);
        testdeTexto(tb3,tb6,tb9);
        testdeTexto(tb1,tb5,tb9);
        testdeTexto(tb3,tb5,tb7);
     
    }
    
    private void jogada(ActionEvent event){
        
        JButton quemChamou = (javax.swing.JButton)event.getSource();
        
        if(quemChamou.getText().equals("")){
            
            quemChamou.setText(tipoJogada);
            tipoJogada = "O";
            velha++;
            testarCondicao();
            
        }

        if(velha > 8 && !endGame){
            
            endGame = true;            
            encerrar("Deu velha! Tente de novo!");
            btn.setText("Novo Jogo");
        
        } else {            
        
            if(tipoJogada.equals("O") && !endGame){
                cliqueArtificial();       
            }
        }
    }
    
    private void encerrar(String cond){
        
        if(endGame){

            b1.setEnabled(false);
            b2.setEnabled(false);
            b3.setEnabled(false);
            b4.setEnabled(false);
            b5.setEnabled(false);
            b6.setEnabled(false);
            b7.setEnabled(false);
            b8.setEnabled(false);
            b9.setEnabled(false);
        }

        if(!cond.equals("")){
            
            JOptionPane.showMessageDialog(null, cond);            

            btn.setText("Novo Jogo");
            
        } else {
        
            int opt = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?", "Atenção", JOptionPane.YES_NO_OPTION);
            if(opt == JOptionPane.YES_OPTION){

                b1.setEnabled(false);
                b2.setEnabled(false);
                b3.setEnabled(false);
                b4.setEnabled(false);
                b5.setEnabled(false);
                b6.setEnabled(false);
                b7.setEnabled(false);
                b8.setEnabled(false);
                b9.setEnabled(false);

                btn.setText("Novo Jogo");

            }
        }
    }
    
    private void iniciar(){
        
        velha = 0;
        endGame = false;
        tipoJogada = "X";
        
        JOptionPane.showMessageDialog(null, "Jogo iniciado. \nBotões Iniciados");
        
        b1.setEnabled(true);
        b2.setEnabled(true);
        b3.setEnabled(true);
        b4.setEnabled(true);
        b5.setEnabled(true);
        b6.setEnabled(true);
        b7.setEnabled(true);
        b8.setEnabled(true);
        b9.setEnabled(true);
        
        b1.setText("");
        b2.setText("");
        b3.setText("");
        b4.setText("");
        b5.setText("");
        b6.setText("");
        b7.setText("");
        b8.setText("");
        b9.setText("");
        
        btn.setText("Encerrar Jogo");       
        
        //click artificial no jbutton
        //b2.doClick();
    }
    
    private JButton selecionarBotao(int num){       
        
        switch (num){
            case 1:                
                b = b1;
                break;
            case 2:
                b = b2;
                break;
            case 3:
                b = b3;
                break;
            case 4:
                b = b4;
                break;
            case 5:
                b = b5;
                break;
            case 6:
                b = b6;
                break;
            case 7:
                b = b7;
                break;
            case 8:
                b = b8;
                break;
            case 9:
                b = b9;
                break;
            case 0:
                b = b1;
                break;
        }
        return b;
    }
    
    private void cliqueArtificial() {
        
        Random random = new Random();
        
        int max, min;            
        min = 1;
        max = 9;
         
        int numero = random.nextInt(max-min+1)+min;
        
        b = selecionarBotao(numero);
               
        if(b.getText().equals("")){
            
            int ameaca = machineCalculation("X");
            
            int ameacaMaquina = machineCalculation("O");
            
            System.out.println(
                    "ameaça: " + ameaca +
                    " numero aleatorio: " + numero +
                    " numero maquina: " + ameacaMaquina 
            );
            
            if(ameacaMaquina != -1){
                
                b = selecionarBotao(ameacaMaquina);
                
                //marcar botao
                b.setText(tipoJogada);
                tipoJogada = "X";
                velha++;
                testarCondicao();
            
            } else {
            
                if((ameaca == numero) || (ameaca == -1)){

                    //marcar botao
                    b.setText(tipoJogada);
                    tipoJogada = "X";
                    velha++;
                    testarCondicao();

                } else {

                    b = selecionarBotao(ameaca);
                    
                    //marcar botao
                    b.setText(tipoJogada);
                    tipoJogada = "X";
                    velha++;
                    testarCondicao();
                }
            }

        } else {

            cliqueArtificial();
        }        
    }



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn = new javax.swing.JButton();
        b3 = new javax.swing.JButton();
        b1 = new javax.swing.JButton();
        b2 = new javax.swing.JButton();
        b6 = new javax.swing.JButton();
        b4 = new javax.swing.JButton();
        b5 = new javax.swing.JButton();
        b7 = new javax.swing.JButton();
        b8 = new javax.swing.JButton();
        b9 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btn.setText("Novo Jogo");
        btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActionPerformed(evt);
            }
        });

        b3.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
        b3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b3ActionPerformed(evt);
            }
        });

        b1.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
        b1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b1ActionPerformed(evt);
            }
        });

        b2.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
        b2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b2ActionPerformed(evt);
            }
        });

        b6.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
        b6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b6ActionPerformed(evt);
            }
        });

        b4.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
        b4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b4ActionPerformed(evt);
            }
        });

        b5.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
        b5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b5ActionPerformed(evt);
            }
        });

        b7.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
        b7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b7ActionPerformed(evt);
            }
        });

        b8.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
        b8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b8ActionPerformed(evt);
            }
        });

        b9.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
        b9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(b1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(b2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(b3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(b4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(b5, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(b6, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(b7, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(b8, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(b9, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(b3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(b2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b6, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b5, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b9, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b8, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b7, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActionPerformed
       
        if(btn.getText().equals("Novo Jogo" )){iniciar();}
        else {encerrar("");}
    }//GEN-LAST:event_btnActionPerformed

    private void b1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b1ActionPerformed
        jogada(evt);
    }//GEN-LAST:event_b1ActionPerformed

    private void b2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b2ActionPerformed
        jogada(evt);
    }//GEN-LAST:event_b2ActionPerformed

    private void b4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b4ActionPerformed
        jogada(evt);
    }//GEN-LAST:event_b4ActionPerformed

    private void b3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b3ActionPerformed
        jogada(evt);
    }//GEN-LAST:event_b3ActionPerformed

    private void b5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b5ActionPerformed
        jogada(evt);
    }//GEN-LAST:event_b5ActionPerformed

    private void b6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b6ActionPerformed
        jogada(evt);
    }//GEN-LAST:event_b6ActionPerformed

    private void b7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b7ActionPerformed
        jogada(evt);
    }//GEN-LAST:event_b7ActionPerformed

    private void b8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b8ActionPerformed
        jogada(evt);
    }//GEN-LAST:event_b8ActionPerformed

    private void b9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b9ActionPerformed
        jogada(evt);
    }//GEN-LAST:event_b9ActionPerformed

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
            java.util.logging.Logger.getLogger(telaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(telaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(telaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(telaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new telaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b1;
    private javax.swing.JButton b2;
    private javax.swing.JButton b3;
    private javax.swing.JButton b4;
    private javax.swing.JButton b5;
    private javax.swing.JButton b6;
    private javax.swing.JButton b7;
    private javax.swing.JButton b8;
    private javax.swing.JButton b9;
    private javax.swing.JButton btn;
    // End of variables declaration//GEN-END:variables

    private int machineCalculation(String letter) {
        
        String tb1 = b1.getText();
        String tb2 = b2.getText();
        String tb3 = b3.getText();
        String tb4 = b4.getText();
        String tb5 = b5.getText();
        String tb6 = b6.getText();
        String tb7 = b7.getText();
        String tb8 = b8.getText();
        String tb9 = b9.getText();
        
        if( tb1.equals(tb2) && tb1.equals(letter) && tb3.equals("")){
            return 3;
        
        } else if(tb4.equals(tb5) && tb4.equals(letter) && tb6.equals("")){
            return 6;
        
        } else if(tb7.equals(tb8) && tb7.equals(letter) && tb9.equals("")){
            return 9;
        
        } else if(tb2.equals(tb3) && tb2.equals(letter) && tb1.equals("")){
            return 1;
        
        } else if(tb5.equals(tb6) && tb5.equals(letter) && tb4.equals("")){
            return 4;
        
        } else if(tb8.equals(tb9) && tb8.equals(letter) && tb7.equals("")){
            return 7;
        
        } else if(tb1.equals(tb4) && tb1.equals(letter) && tb7.equals("")){
            return 7;
        
        } else if(tb2.equals(tb5) && tb2.equals(letter) && tb8.equals("")){
            return 8;
        
        } else if(tb3.equals(tb6) && tb3.equals(letter) && tb9.equals("")){
            return 9;
        
        } else if(tb4.equals(tb7) && tb4.equals(letter) && tb1.equals("")){
            return 1;
        
        } else if(tb5.equals(tb8) && tb5.equals(letter) && tb2.equals("")){
            return 2;
        
        } else if(tb6.equals(tb9) && tb6.equals(letter) && tb3.equals("")){
            return 3;
        
        } else if(tb1.equals(tb5) && tb1.equals(letter) && tb9.equals("")){
            return 9;
        
        } else if(tb9.equals(tb5) && tb9.equals(letter) && tb1.equals("")){
            return 1;
        
        } else if(tb3.equals(tb5) && tb3.equals(letter) && tb7.equals("")){
            return 7;
        
        } else if(tb5.equals(tb7) && tb5.equals(letter) && tb3.equals("")){
            return 3;
        
        } else if(tb1.equals(tb3) && tb1.equals(letter) && tb2.equals("")){
            return 2;
        
        } else if(tb4.equals(tb6) && tb4.equals(letter) && tb5.equals("")){
            return 5;
        
        } else if(tb7.equals(tb9) && tb7.equals(letter) && tb8.equals("")){
            return 8;
        
        } else if(tb1.equals(tb7) && tb1.equals(letter) && tb4.equals("")){
            return 4;
        
        } else if(tb2.equals(tb8) && tb2.equals(letter) && tb5.equals("")){
            return 5;
        
        } else if(tb3.equals(tb9) && tb3.equals(letter) && tb6.equals("")){
            return 6;
        
        } else {
            return -1;
        }
    }
}


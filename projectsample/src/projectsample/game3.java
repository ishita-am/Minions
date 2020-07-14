/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectsample;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.Timer;

/**
 *
 * @author Jagruti
 */
public class game3 extends javax.swing.JFrame {
int round=1, quiz_score=0,pause=0;
 Timer time = new Timer(1000, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            pause++;
            //L2.setIcon(new ImageIcon("C:\\memorygame\\level1\\2.jpg"));
            if (pause == 2) {
                time.stop();
                quizz(round);
            }
            System.out.println("hi" + pause);

        }
    }); 

public void quizz(int round)
            
    {
 switch (round)
{
    case 1: RB1.setSelected(false);
            RB2.setSelected(false);
            RB3.setSelected(false);
            RB4.setSelected(false);
            Quiz_question1.setText("The Minions say the word ");
            Quiz_question2.setText("\"Gelato\", but what does this ");
            Quiz_question3.setText("mean??");
            A.setText("Ham");
            B.setText("Latte");
            C.setText("Ice-cream");
            D.setText("Jelly");
            time.start();
            if(RB3.isSelected()==true)
           {
               //time.start();
              quiz_score+=10;
              QScore.setText(""+quiz_score);
               System.out.println(quiz_score);
               round++;
           }
           else
           {
               //think of what can highlighy the correct answer
           }
               break;
     case 2:  RB1.setSelected(false);
            RB2.setSelected(false);
            RB3.setSelected(false);
            RB4.setSelected(false);
            Quiz_question1.setText("In which other Universal Pictures");
            Quiz_question2.setText("film does a Minion make a snaeky ");
            Quiz_question3.setText("appearence");
            A.setText("Hop");
            B.setText("Pitch Perfect");
            C.setText("The Lorax");
            D.setText("Jurassic World");
            if(RB3.isSelected()==true)
            {
              quiz_score+=10;
              QScore.setText(""+quiz_score);
              System.out.println(quiz_score);
            }
           else
           {
               //think of what can highlighy the correct answer
           }
               break;         
    case 3:  RB1.setSelected(false);
            RB2.setSelected(false);
            RB3.setSelected(false);
            RB4.setSelected(false);
            Quiz_question1.setText("The Minions are the official");
            Quiz_question2.setText("masscot for which company? ");
               Quiz_question3.setText("");
            A.setText("Universal Studios");
            B.setText("Universal Animtion Studios");
            C.setText("Illumination Entertainment");
            D.setText("Working Title Films");
           if(RB3.isSelected())
           {
              quiz_score+=10;
              QScore.setText(""+quiz_score);
               System.out.println(quiz_score);
           }
           else
           {
               //think of what can highlighy the correct answer
           }
               break;
      case 4: RB1.setSelected(false);
            RB2.setSelected(false);
            RB3.setSelected(false);
            RB4.setSelected(false);
            Quiz_question1.setText("How many fingers do the minions");
            Quiz_question2.setText("have in each hand?");
            Quiz_question3.setText("");
            A.setText("5");
            B.setText("3");
            C.setText("4");
            D.setText("6");
           if(RB2.isSelected())
           {
              quiz_score+=10;
              QScore.setText(""+quiz_score);
               System.out.println(quiz_score);
           }
           else
           {
               //think of what can highlighy the correct answer
           }
               break;     
    case 5:  RB1.setSelected(false);
            RB2.setSelected(false);
            RB3.setSelected(false);
            RB4.setSelected(false);
        Quiz_question1.setText("The Minions say the word");
            Quiz_question2.setText("\"Kanpai\", but what does this ");
            Quiz_question3.setText("mean??");
            A.setText("Can we start?");
            B.setText("Hello");
            C.setText("Party");
            D.setText("Cheers");
           if(RB4.isSelected())
           {
              quiz_score+=10;
              QScore.setText(""+quiz_score);
               System.out.println(quiz_score);
           }
           else
           {
               //think of what can highlighy the correct answer
           }
               break; 
    case 6:  RB1.setSelected(false);
            RB2.setSelected(false);
            RB3.setSelected(false);
            RB4.setSelected(false);
            Quiz_question1.setText("In what strange way were the");
            Quiz_question2.setText("Minions used to promote the");
            Quiz_question3.setText("second film?");
            A.setText("A mininon truck toured the US");
            B.setText("500 people dressed as Minions toured the US");
            C.setText("Minion themed parachutes were used in air shows");
            D.setText("a Minion shaped blimp toured the US");
           if(RB4.isSelected())
           {
              quiz_score+=10;
              QScore.setText(""+quiz_score);
              //round++;
               System.out.println(quiz_score);
           }
           else
           {
               //think of what can highlighy the correct answer
           }
               break;
       case 7: RB1.setSelected(false);
            RB2.setSelected(false);
            RB3.setSelected(false);
            RB4.setSelected(false);
            Quiz_question1.setText("What is the reason for Minions");
            Quiz_question2.setText("being so small?");
               Quiz_question3.setText("");
            A.setText("Budget restraints meant animators to scale them down");
            B.setText("They were easier to draw that way");
            C.setText("The director based the on his pet  pug");
            D.setText("There was a miscommunication about the size");
           if(RB4.isSelected())
         {
              quiz_score+=10;
              QScore.setText(""+quiz_score);
              //round++;
               System.out.println(quiz_score);
           }
           else
           {
               //think of what can highlighy the correct answer
           }
               break;   
              
   case 8:  RB1.setSelected(false);
            RB2.setSelected(false);
            RB3.setSelected(false);
            RB4.setSelected(false);
            Quiz_question1.setText("What did Chiquita Bananas do ");
            Quiz_question2.setText("to promote the release of");
            Quiz_question3.setText("Despicible Me 2?");
            A.setText("Made a 50 ft statue out of bananas");
            B.setText("Created over 1 million themed stickers");
            C.setText("Dyed their bananas to look like Minions");
            D.setText("Gave away free bananas to get get kids to eat fruit");
           if(RB2.isSelected())
         {
              quiz_score+=10;
              QScore.setText(""+quiz_score);
               System.out.println(quiz_score);
           
           }
           else
           {
               //think of what can highlighy the correct answer
           }
               break; 
   case 9:  RB1.setSelected(false);
            RB2.setSelected(false);
            RB3.setSelected(false);
            RB4.setSelected(false);
            Quiz_question1.setText("How many natural hairstyles do the");
            Quiz_question2.setText("minions have?");
              Quiz_question3.setText("");
            
            A.setText("4");
            B.setText("1");
            C.setText("3");
            D.setText("5");
           if(RB4.isSelected())
         {
              quiz_score+=10;
              QScore.setText(""+quiz_score);
              System.out.println(quiz_score);
           }
           else
           {
               //think of what can highlighy the correct answer
           }
               break;  
  case 10:  RB1.setSelected(false);
            RB2.setSelected(false);
            RB3.setSelected(false);
            RB4.setSelected(false);
            Quiz_question1.setText("Minions speak a mixture of");
               Quiz_question2.setText("");
                  Quiz_question3.setText("");
            A.setText("Spanish, English, French");
            B.setText("additional elements of Russian and Korean");
            C.setText("Spanish, English, French, Russian, Italain,Korean");
            D.setText("Spanish, Russain, Korean");
           if(RB3.isSelected())
         {
              quiz_score+=10;
              QScore.setText(""+quiz_score);
              System.out.println(quiz_score);
           }
           else
           {
               //think of what can highlighy the correct answer
           }
               //high scores
//           QUIZZ.setVisible(false);
//           gamehome.setVisible(true);
}       
    }
    /**
     * Creates new form game3
     */
    public game3() {
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

        jPanel22 = new javax.swing.JPanel();
        A = new javax.swing.JLabel();
        B = new javax.swing.JLabel();
        C = new javax.swing.JLabel();
        D = new javax.swing.JLabel();
        RB4 = new javax.swing.JRadioButton();
        RB3 = new javax.swing.JRadioButton();
        RB2 = new javax.swing.JRadioButton();
        RB1 = new javax.swing.JRadioButton();
        Quiz_question1 = new javax.swing.JLabel();
        Quiz_question2 = new javax.swing.JLabel();
        Quiz_question3 = new javax.swing.JLabel();
        QScore = new javax.swing.JLabel();
        jButton38 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));
        jPanel22.setToolTipText("");
        jPanel22.setMinimumSize(new java.awt.Dimension(700, 400));
        jPanel22.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        A.setFont(new java.awt.Font("Gill Sans Ultra Bold Condensed", 0, 18)); // NOI18N
        jPanel22.add(A, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, 720, 50));

        B.setFont(new java.awt.Font("Gill Sans Ultra Bold Condensed", 0, 18)); // NOI18N
        jPanel22.add(B, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, 720, 50));

        C.setFont(new java.awt.Font("Gill Sans Ultra Bold Condensed", 0, 18)); // NOI18N
        jPanel22.add(C, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, 720, 50));

        D.setFont(new java.awt.Font("Gill Sans Ultra Bold Condensed", 0, 18)); // NOI18N
        jPanel22.add(D, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 400, 720, 50));

        RB4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel22.add(RB4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 20, -1));

        RB3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel22.add(RB3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 20, -1));

        RB2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel22.add(RB2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 20, -1));

        RB1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel22.add(RB1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 20, -1));

        Quiz_question1.setFont(new java.awt.Font("Gill Sans Ultra Bold Condensed", 0, 36)); // NOI18N
        jPanel22.add(Quiz_question1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 829, 50));

        Quiz_question2.setFont(new java.awt.Font("Gill Sans Ultra Bold Condensed", 0, 36)); // NOI18N
        jPanel22.add(Quiz_question2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 829, 50));

        Quiz_question3.setFont(new java.awt.Font("Gill Sans Ultra Bold Condensed", 0, 36)); // NOI18N
        jPanel22.add(Quiz_question3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 829, 50));

        QScore.setText("ss");
        jPanel22.add(QScore, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 230, 120, 70));

        jButton38.setText("Next");
        jButton38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton38ActionPerformed(evt);
            }
        });
        jPanel22.add(jButton38, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 420, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1049, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, 1029, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 547, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton38ActionPerformed
        round++;
        quizz(round);
        if (round>=10)// TODO add your handling code here:
        {
//            QUIZZ.setVisible(false) ;
//            gamehome.setVisible(true);
            round=0;quiz_score=0;
        }
    }//GEN-LAST:event_jButton38ActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
      quizz(round);   // TODO add your handling code here:
    }//GEN-LAST:event_formWindowActivated

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
            java.util.logging.Logger.getLogger(game3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(game3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(game3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(game3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new game3().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel A;
    private javax.swing.JLabel B;
    private javax.swing.JLabel C;
    private javax.swing.JLabel D;
    private javax.swing.JLabel QScore;
    private javax.swing.JLabel Quiz_question1;
    private javax.swing.JLabel Quiz_question2;
    private javax.swing.JLabel Quiz_question3;
    private javax.swing.JRadioButton RB1;
    private javax.swing.JRadioButton RB2;
    private javax.swing.JRadioButton RB3;
    private javax.swing.JRadioButton RB4;
    private javax.swing.JButton jButton38;
    private javax.swing.JPanel jPanel22;
    // End of variables declaration//GEN-END:variables
}

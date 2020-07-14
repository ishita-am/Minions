/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectsample;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.Timer;
import javax.swing.table.*;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
/**
 *
 * @author dell 3542
 */
public class main extends javax.swing.JFrame {
    FileInputStream homepagesound=null,gamebg=null,gamehomesound=null,congratssound=null;
AudioStream as1=null,as2=null,as3=null,as4=null;int qno;

boolean sound=true;

    String nickname,username,nickname1;
    Connection con = null;
    ResultSet rs = null;
    Statement st = null;
    int i = 0;
    String sqlnickname;
    int r = 0;
    int mg1,mg2,mg3,st1,st2,st3,q1;

//for progress timer(t)
    /* Timer t = new Timer(1000, new ActionListener(){
        public void actionPerformed(ActionEvent e){
             i=i+1;
             pp1.setValue(r+1);
progress.setText((r+1)+"%");
r=pp1.getValue();
String s=progress.getText();
if(s.equals("101%")){
t.stop();
    System.out.println("stopped");
jFrame1.setVisible(true);
loading.setVisible(false);}


             }  });
     */
    //loading timer starts
    int y = 0;
    int a = 0;
    Timer l = new Timer(500, new ActionListener() {
        public void actionPerformed(ActionEvent e) {

            if (a == 0) {
                loadlabel.setText("Loading");
            } else if (a == 1) {
                loadlabel.setText("Loading.");
            } else if (a == 2) {
                loadlabel.setText("Loading..");
            } else if (a == 3) {
                loadlabel.setText("Loading...");
                a = 0;
                y = y + 1;
            }
            a = a + 1;
            if (y == 3) {
                l.stop();
                loading.setVisible(false);
                gamehome.setVisible(true);
            }
        }
    } );//loading timer ends

//main game stuff LEVEL1
    int count = 0, score = 0;

    public void back2basic() {
        L1.setIcon(new ImageIcon("C:\\memorygame\\yellow.jpg"));
        L2.setIcon(new ImageIcon("C:\\memorygame\\yellow.jpg"));
        L3.setIcon(new ImageIcon("C:\\memorygame\\yellow.jpg"));
        L4.setIcon(new ImageIcon("C:\\memorygame\\yellow.jpg"));
        L5.setIcon(new ImageIcon("C:\\memorygame\\yellow.jpg"));
        L6.setIcon(new ImageIcon("C:\\memorygame\\yellow.jpg"));
        l1 = false;
        l2 = false;
        l3 = false;
        l4 = false;
        l5 = false;
        l6 = false;
        count = 0;
        pause = 0;
    }

    boolean l1, l2, l3, l4, l5, l6;
    int s = 0;
    int m = 0;int pause = 0;
    Timer StopWatch = new Timer(1000, new ActionListener() {
        public void actionPerformed(ActionEvent e) {

            s = s + 1;
            if (s == 60) {
                s = 0;
                m = m + 1;

            }

            Time1.setText(m + "");
            Time2.setText(s + "");

        }
    });
    Timer T1A = new Timer(500, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            pause++;
            L1.setIcon(new ImageIcon("C:\\memorygame\\level1\\1.jpg"));
            if (pause == 2) {
                T1A.stop();
                back2basic();
            }
            System.out.println("hi" + pause);

        }
    });
    Timer T2A = new Timer(500, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            pause++;
            L2.setIcon(new ImageIcon("C:\\memorygame\\level1\\2.jpg"));
            if (pause == 2) {
                T2A.stop();
                back2basic();
            }
            System.out.println("hi" + pause);

        }
    });
    Timer T3A = new Timer(500, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            pause++;
            L3.setIcon(new ImageIcon("C:\\memorygame\\level1\\1.jpg"));
            if (pause == 2) {
                T3A.stop();
                back2basic();
            }
            System.out.println("hi" + pause);

        }
    });
    Timer T4A = new Timer(500, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            pause++;
            L4.setIcon(new ImageIcon("C:\\memorygame\\level1\\3.jpg"));
            if (pause == 2) {
                T4A.stop();
                back2basic();
            }
            System.out.println("hi" + pause);

        }
    });
    Timer T5A = new Timer(500, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            pause++;
            L5.setIcon(new ImageIcon("C:\\memorygame\\level1\\3.jpg"));
            if (pause == 2) {
                T5A.stop();
                back2basic();
            }
            System.out.println("hi" + pause);

        }
    });
    Timer T6A = new Timer(500, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            pause++;
            L6.setIcon(new ImageIcon("C:\\memorygame\\level1\\2.jpg"));
            if (pause == 2) {
                T6A.stop();
                back2basic();
            }
            System.out.println("hi" + pause);

        }
    });
    Timer T1B = new Timer(500, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            pause++;
            L1.setIcon(new ImageIcon("C:\\memorygame\\level1\\1.jpg"));
            L3.setIcon(new ImageIcon("C:\\memorygame\\level1\\1.jpg"));
            if (pause == 2) {
                T1B.stop();
                L1.setVisible(false);
                L3.setVisible(false);
                pause = 0;
                plus_one();
            }
            System.out.println("hi" + pause);
//MGL1score
        }
    });
    Timer T2B = new Timer(500, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            pause++;
            L2.setIcon(new ImageIcon("C:\\memorygame\\level1\\2.jpg"));
            L6.setIcon(new ImageIcon("C:\\memorygame\\level1\\2.jpg"));
            if (pause == 2) {
                T2B.stop();
                L2.setVisible(false);
                L6.setVisible(false);
                pause = 0;
                plus_one();
            }
            System.out.println("hi" + pause);

        }
    });
    Timer T4B = new Timer(500, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            pause++;
            L4.setIcon(new ImageIcon("C:\\memorygame\\level1\\3.jpg"));
            L5.setIcon(new ImageIcon("C:\\memorygame\\level1\\3.jpg"));
            if (pause == 2) {
                T4B.stop();
                L4.setVisible(false);
                L5.setVisible(false);
                pause = 0;
                plus_one();
            }
            System.out.println("hi" + pause);

        }
    });

    public void plus_one() {
        score++;
        Score.setText("" + score);
        System.out.println(score);

        count = 0;
        System.out.println(count);
        if (score == 3) {
            StopWatch.stop();
            double i = (Double.parseDouble(Time1.getText()) * 60.0) + (Double.parseDouble(Time2.getText()));
            System.out.println(i);
            MGL1.setVisible(false);
            MGL1score.setVisible(true);
            MGL1score.setSize(500, 410);
            congratss.setText("Congrats, you have completed in " + i + " secs");
            if (i <= 10) {
                sc.setText((score + 2) + "");
                Sl1.setIcon(new ImageIcon("C:\\memorygame\\star.jpg"));
                Sl2.setIcon(new ImageIcon("C:\\memorygame\\star.jpg"));
                Sl3.setIcon(new ImageIcon("C:\\memorygame\\star.jpg"));
            } else if (i <= 12) {
                sc.setText((score + 1) + "");
                Sl1.setIcon(new ImageIcon("C:\\memorygame\\star.jpg"));
                Sl2.setIcon(new ImageIcon("C:\\memorygame\\star.jpg"));
            } else {
                sc.setText(score + "");
            }
            Sl1.setIcon(new ImageIcon("C:\\memorygame\\star.jpg"));

        }
    }

//main game stuff LEVEL2
    int count2 = 0, score2 = 0, pause2 = 0;
    boolean l21, l22, l23, l24, l25, l26, l27, l28, l29, l210, l211, l212;

    public void plus_one_level2() {
        score2++;
        Score2.setText("hi");
        Score2.setText("" + score2);
        count2 = 0;
        if (score2 == 6) {
            StopWatch2.stop();
            System.out.println("stopwatch2 stopped");
            double i = (Double.parseDouble(time21.getText()) * 60.0) + (Double.parseDouble(time22.getText()));
            System.out.println(i);
            MGL2.setVisible(false);
            MGL2score.setVisible(true);
            MGL2score.setSize(480, 400);
            Congrats1.setText("Congrats, you have completed in " + i + " secs");
            if (i <= 30) {
                sc2.setText((score2 + 2) + "");
                S21.setIcon(new ImageIcon("C:\\memorygame\\star.jpg"));
                S22.setIcon(new ImageIcon("C:\\memorygame\\star.jpg"));
                S23.setIcon(new ImageIcon("C:\\memorygame\\star.jpg"));
            } else if (i <= 35) {
                sc2.setText((score2 + 1) + "");
                S21.setIcon(new ImageIcon("C:\\memorygame\\star.jpg"));
                S22.setIcon(new ImageIcon("C:\\memorygame\\star.jpg"));
            } else {
                sc2.setText(score2 + "");
            }
            S21.setIcon(new ImageIcon("C:\\memorygame\\star.jpg"));

        }
    }

    public void back2basic2() {
        L21.setIcon(new ImageIcon("C:\\memorygame\\yellow.jpg"));
        L22.setIcon(new ImageIcon("C:\\memorygame\\yellow.jpg"));
        L23.setIcon(new ImageIcon("C:\\memorygame\\yellow.jpg"));
        L24.setIcon(new ImageIcon("C:\\memorygame\\yellow.jpg"));
        L25.setIcon(new ImageIcon("C:\\memorygame\\yellow.jpg"));
        L26.setIcon(new ImageIcon("C:\\memorygame\\yellow.jpg"));
        L27.setIcon(new ImageIcon("C:\\memorygame\\yellow.jpg"));
        L28.setIcon(new ImageIcon("C:\\memorygame\\yellow.jpg"));
        L29.setIcon(new ImageIcon("C:\\memorygame\\yellow.jpg"));
        L210.setIcon(new ImageIcon("C:\\memorygame\\yellow.jpg"));
        L211.setIcon(new ImageIcon("C:\\memorygame\\yellow.jpg"));
        L212.setIcon(new ImageIcon("C:\\memorygame\\yellow.jpg"));
        l21 = false;
        l22 = false;
        l23 = false;
        l24 = false;
        l25 = false;
        l26 = false;
        l27 = false;
        l28 = false;
        l29 = false;
        l210 = false;
        l211 = false;
        l212 = false;
        count2 = 0;
        pause2 = 0;
    }
    int s2 = 0, m2 = 0;
    Timer StopWatch2 = new Timer(1000, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            System.out.println("inside timer");

            s2 = s2 + 1;
            if (s2 == 60) {
                s2 = 0;
                m2 = m2 + 1;

            }

            time21.setText(m2 + "");
            time22.setText(s2 + "");

        }
    });
    Timer T21A = new Timer(500, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            pause2++;
            L21.setIcon(new ImageIcon("C:\\memorygame\\level2\\1.jpg"));
            if (pause2 == 2) {
                back2basic2();
                T21A.stop();

            }
        }
    });
    Timer T22A = new Timer(500, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            pause2++;
            L22.setIcon(new ImageIcon("C:\\memorygame\\level2\\2.jpg"));
            if (pause2 == 2) {
                T22A.stop();
                back2basic2();
            }
        }
    });
    Timer T23A = new Timer(500, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            pause2++;
            L23.setIcon(new ImageIcon("C:\\memorygame\\level2\\3.jpg"));
            if (pause2 == 2) {
                T23A.stop();
                back2basic2();
            }
        }
    });
    Timer T24A = new Timer(500, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            pause2++;
            L24.setIcon(new ImageIcon("C:\\memorygame\\level2\\4.jpg"));
            if (pause2 == 2) {
                T24A.stop();
                back2basic2();
            }
        }
    });
    Timer T25A = new Timer(500, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            pause2++;
            L25.setIcon(new ImageIcon("C:\\memorygame\\level2\\3.jpg"));
            if (pause2 == 2) {
                T25A.stop();
                back2basic2();
            }
        }
    });
    Timer T26A = new Timer(500, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            pause2++;
            L26.setIcon(new ImageIcon("C:\\memorygame\\level2\\6.jpg"));
            if (pause2 == 2) {
                T26A.stop();
                back2basic2();
            }
        }
    });
    Timer T27A = new Timer(500, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            pause2++;
            L27.setIcon(new ImageIcon("C:\\memorygame\\level2\\1.jpg"));
            if (pause2 == 2) {
                T27A.stop();
                back2basic2();
            }
        }
    });
    Timer T28A = new Timer(500, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            pause2++;
            L28.setIcon(new ImageIcon("C:\\memorygame\\level2\\4.jpg"));
            if (pause2 == 2) {
                T28A.stop();
                back2basic2();
            }
        }
    });
    Timer T29A = new Timer(500, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            pause2++;
            L29.setIcon(new ImageIcon("C:\\memorygame\\level2\\5.jpg"));
            if (pause2 == 2) {
                T29A.stop();
                back2basic2();
            }
        }
    });
    Timer T210A = new Timer(500, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            pause2++;
            L210.setIcon(new ImageIcon("C:\\memorygame\\level2\\5.jpg"));
            if (pause2 == 2) {
                T210A.stop();
                back2basic2();
            }
        }
    });
    Timer T211A = new Timer(500, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            pause2++;
            L211.setIcon(new ImageIcon("C:\\memorygame\\level2\\6.jpg"));
            if (pause2 == 2) {
                T211A.stop();
                back2basic2();
            }
        }
    });
    Timer T212A = new Timer(500, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            pause2++;
            L212.setIcon(new ImageIcon("C:\\memorygame\\level2\\2.jpg"));
            if (pause2 == 2) {
                T212A.stop();
                back2basic2();
            }
        }
    });
    Timer T21B = new Timer(500, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            pause2++;
            L21.setIcon(new ImageIcon("C:\\memorygame\\level2\\1.jpg"));
            L27.setIcon(new ImageIcon("C:\\memorygame\\level2\\1.jpg"));
            if (pause2 == 2) {
                T21B.stop();
                L21.setVisible(false);
                L27.setVisible(false);
                pause2 = 0;
                plus_one_level2();
            }
        }
    });
    Timer T22B = new Timer(500, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            pause2++;
            L22.setIcon(new ImageIcon("C:\\memorygame\\level2\\2.jpg"));
            L212.setIcon(new ImageIcon("C:\\memorygame\\level2\\2.jpg"));
            if (pause2 == 2) {
                T22B.stop();
                L22.setVisible(false);
                L212.setVisible(false);
                pause2 = 0;
                plus_one_level2();
            }
        }
    });
    Timer T23B = new Timer(500, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            pause2++;
            L23.setIcon(new ImageIcon("C:\\memorygame\\level2\\3.jpg"));
            L25.setIcon(new ImageIcon("C:\\memorygame\\level2\\3.jpg"));
            if (pause2 == 2) {
                T23B.stop();
                L23.setVisible(false);
                L25.setVisible(false);
                pause2 = 0;
                plus_one_level2();
            }
        }
    });
    Timer T24B = new Timer(500, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            pause2++;
            L24.setIcon(new ImageIcon("C:\\memorygame\\level2\\4.jpg"));
            L28.setIcon(new ImageIcon("C:\\memorygame\\level2\\4.jpg"));
            if (pause2 == 2) {
                T24B.stop();
                L24.setVisible(false);
                L28.setVisible(false);
                pause2 = 0;
                plus_one_level2();
            }
        }
    });
    Timer T26B = new Timer(500, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            pause2++;
            L26.setIcon(new ImageIcon("C:\\memorygame\\level2\\6.jpg"));
            L211.setIcon(new ImageIcon("C:\\memorygame\\level2\\6.jpg"));
            if (pause2 == 2) {
                T26B.stop();
                L26.setVisible(false);
                L211.setVisible(false);
                pause2 = 0;
                plus_one_level2();
            }
        }
    });
    Timer T29B = new Timer(500, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            pause2++;
            L29.setIcon(new ImageIcon("C:\\memorygame\\level2\\5.jpg"));
            L210.setIcon(new ImageIcon("C:\\memorygame\\level2\\5.jpg"));
            if (pause2 == 2) {
                T29B.stop();
                L29.setVisible(false);
                L210.setVisible(false);
                pause2 = 0;
                plus_one_level2();
            }
        }
    });

    //mg3
    boolean l31=false,l32=false,l33=false,l34=false,l35=false,l36=false,l37=false,l38=false,l39=false,l310=false,l311=false,l312=false,l313=false,l314=false,l315=false,l316=false,l317=false,l318=false,l319=false,l320=false;
     int count3=0; int score3=0;
     int pause3=0;
    public void back2basic3() {
        L31.setIcon(new ImageIcon("C:\\memorygame\\yellow.jpg"));
        L32.setIcon(new ImageIcon("C:\\memorygame\\yellow.jpg"));
        L33.setIcon(new ImageIcon("C:\\memorygame\\yellow.jpg"));
        L34.setIcon(new ImageIcon("C:\\memorygame\\yellow.jpg"));
        L35.setIcon(new ImageIcon("C:\\memorygame\\yellow.jpg"));
        L36.setIcon(new ImageIcon("C:\\memorygame\\yellow.jpg"));
        L37.setIcon(new ImageIcon("C:\\memorygame\\yellow.jpg"));
        L38.setIcon(new ImageIcon("C:\\memorygame\\yellow.jpg"));
        L39.setIcon(new ImageIcon("C:\\memorygame\\yellow.jpg"));
        L310.setIcon(new ImageIcon("C:\\memorygame\\yellow.jpg"));
        L311.setIcon(new ImageIcon("C:\\memorygame\\yellow.jpg"));
        L312.setIcon(new ImageIcon("C:\\memorygame\\yellow.jpg"));
        L313.setIcon(new ImageIcon("C:\\memorygame\\yellow.jpg"));
        L314.setIcon(new ImageIcon("C:\\memorygame\\yellow.jpg"));
        L315.setIcon(new ImageIcon("C:\\memorygame\\yellow.jpg"));
        L316.setIcon(new ImageIcon("C:\\memorygame\\yellow.jpg"));
        L317.setIcon(new ImageIcon("C:\\memorygame\\yellow.jpg"));
        L318.setIcon(new ImageIcon("C:\\memorygame\\yellow.jpg"));
        L319.setIcon(new ImageIcon("C:\\memorygame\\yellow.jpg"));
        L320.setIcon(new ImageIcon("C:\\memorygame\\yellow.jpg"));
        l31 = false;
        l32 = false;
        l33 = false;
        l34 = false;
        l35 = false;
        l36 = false;
        l37 = false;
        l38 = false;
        l39 = false;
        l310= false;
        l311= false;
        l312= false;
        l313= false;
        l314= false;
        l315= false;
        l316= false;
        l317= false;
        l318= false;
        l319= false;
        l320= false;
       count3 = 0;
        pause3= 0;
    }
    public void plus_one_level3() {
        score3++;
        
        Score3.setText("" + score3);
        count3 = 0;
        if (score3 == 10) {
            StopWatch3.stop();
            double i = (Double.parseDouble(time31.getText()) * 60.0) + (Double.parseDouble(time32.getText()));
            MGL3.setVisible(false);
            MGL3score.setVisible(true);
            MGL3score.setSize(500, 410);
            Congrats5.setText("Congrats, you have completed in " + i + " secs");
            if (i <= 60) {
                sc5.setText((score3 + 2) + "");
                S31.setIcon(new ImageIcon("C:\\memorygame\\star.jpg"));
                S32.setIcon(new ImageIcon("C:\\memorygame\\star.jpg"));
                S33.setIcon(new ImageIcon("C:\\memorygame\\star.jpg"));
            } else if (i <= 50) {
                sc3.setText((score3 + 1) + "");
                S31.setIcon(new ImageIcon("C:\\memorygame\\star.jpg"));
                S32.setIcon(new ImageIcon("C:\\memorygame\\star.jpg"));
            } else {
                sc3.setText(score3 + "");
            }
            S31.setIcon(new ImageIcon("C:\\memorygame\\star.jpg"));

        }
    }    
    Timer StopWatch3 = new Timer(1000, new ActionListener() {
        public void actionPerformed(ActionEvent e) {

            s = s + 1;
            if (s == 60) {
                s = 0;
                m = m + 1;

            }

            time31.setText(m + "");
            time32.setText(s + "");

        }
    });
    Timer T31A = new Timer(500, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            pause3++;
            L31.setIcon(new ImageIcon("C:\\memorygame\\level3\\1.jpg"));
            if (pause3 == 2) {
                back2basic3();
                T31A.stop();

            }
        }
    });
    Timer T32A = new Timer(500, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            pause3++;
            L32.setIcon(new ImageIcon("C:\\memorygame\\level3\\2.jpg"));
            if (pause3 == 2) {
                back2basic3();
                T32A.stop();

            }
        }
    });
    Timer T33A = new Timer(500, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            pause3++;
            L33.setIcon(new ImageIcon("C:\\memorygame\\level3\\3.jpg"));
            if (pause3 == 2) {
                back2basic3();
                T33A.stop();

            }
        }
    });
    Timer T34A = new Timer(500, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            pause3++;
            L34.setIcon(new ImageIcon("C:\\memorygame\\level3\\4.jpg"));
            if (pause3 == 2) {
                back2basic3();
                T34A.stop();

            }
        }
    });
    Timer T35A = new Timer(500, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            pause3++;
            L35.setIcon(new ImageIcon("C:\\memorygame\\level3\\5.jpg"));
            if (pause3 == 2) {
                back2basic3();
                T35A.stop();

            }
        }
    });
    Timer T36A = new Timer(500, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            pause3++;
            L36.setIcon(new ImageIcon("C:\\memorygame\\level3\\1.jpg"));
            if (pause3 == 2) {
                back2basic3();
                T36A.stop();

            }
        }
    });
    Timer T37A = new Timer(500, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            pause3++;
            L37.setIcon(new ImageIcon("C:\\memorygame\\level3\\5.jpg"));
            if (pause3 == 2) {
                back2basic3();
                T37A.stop();

            }
        }
    });
    Timer T38A = new Timer(500, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            pause3++;
            L38.setIcon(new ImageIcon("C:\\memorygame\\level3\\6.jpg"));
            if (pause3 == 2) {
                back2basic3();
                T38A.stop();

            }
        }
    });
    Timer T39A = new Timer(500, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            pause3++;
            L39.setIcon(new ImageIcon("C:\\memorygame\\level3\\7.jpg"));
            if (pause3 == 2) {
                back2basic3();
                T39A.stop();

            }
        }
    });
    Timer T310A = new Timer(500, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            pause3++;
            L310.setIcon(new ImageIcon("C:\\memorygame\\level3\\8.jpg"));
            if (pause3 == 2) {
                back2basic3();
                T310A.stop();

            }
        }
    });
    Timer T311A = new Timer(500, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            pause3++;
            L311.setIcon(new ImageIcon("C:\\memorygame\\level3\\4.jpg"));
            if (pause3 == 2) {
                back2basic3();
                T311A.stop();

            }
        }
    });
    Timer T312A = new Timer(500, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            pause3++;
            L312.setIcon(new ImageIcon("C:\\memorygame\\level3\\6.jpg"));
            if (pause3 == 2) {
                back2basic3();
                T312A.stop();

            }
        }
    });
    Timer T313A = new Timer(500, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            pause3++;
            L313.setIcon(new ImageIcon("C:\\memorygame\\level3\\9.png"));
            if (pause3 == 2) {
                back2basic3();
                T313A.stop();

            }
        }
    });
    Timer T314A = new Timer(500, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            pause3++;
            L314.setIcon(new ImageIcon("C:\\memorygame\\level3\\2.jpg"));
            if (pause3 == 2) {
                back2basic3();
                T314A.stop();

            }
        }
    });
    Timer T315A = new Timer(500, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            pause3++;
            L315.setIcon(new ImageIcon("C:\\memorygame\\level3\\10.jpg"));
            if (pause3 == 2) {
                back2basic3();
                T315A.stop();

            }
        }
    });
    Timer T316A = new Timer(500, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            pause3++;
            L316.setIcon(new ImageIcon("C:\\memorygame\\level3\\3.jpg"));
            if (pause3 == 2) {
                back2basic3();
                T316A.stop();

            }
        }
    });
    Timer T317A = new Timer(500, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            pause3++;
            L317.setIcon(new ImageIcon("C:\\memorygame\\level3\\7.jpg"));
            if (pause3 == 2) {
                back2basic3();
                T317A.stop();

            }
        }
    });
    Timer T318A = new Timer(500, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            pause3++;
            L318.setIcon(new ImageIcon("C:\\memorygame\\level3\\10.jpg"));
            if (pause3 == 2) {
                back2basic3();
                T318A.stop();

            }
        }
    });
    Timer T319A = new Timer(500, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            pause3++;
            L319.setIcon(new ImageIcon("C:\\memorygame\\level3\\8.jpg"));
            if (pause3 == 2) {
                back2basic3();
                T319A.stop();

            }
        }
    });
    Timer T320A = new Timer(500, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            pause3++;
            L320.setIcon(new ImageIcon("C:\\memorygame\\level3\\9.png"));
            if (pause3 == 2) {
                back2basic3();
                T320A.stop();

            }
        }
    });
    
    Timer T31B = new Timer(500, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            pause3++;
            L31.setIcon(new ImageIcon("C:\\memorygame\\level3\\1.jpg"));
            L36.setIcon(new ImageIcon("C:\\memorygame\\level3\\1.jpg"));
            if (pause3 == 2) {
                T31B.stop();
                L31.setVisible(false);
                L36.setVisible(false);
                pause3 = 0;
                plus_one_level3();
            }
        }
    });
    Timer T32B = new Timer(500, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            pause3++;
            L32.setIcon(new ImageIcon("C:\\memorygame\\level3\\2.jpg"));
            L314.setIcon(new ImageIcon("C:\\memorygame\\level3\\2.jpg"));
            if (pause3 == 2) {
                T32B.stop();
                L32.setVisible(false);
                L314.setVisible(false);
                pause3 = 0;
                plus_one_level3();
            }
        }
    });
    Timer T33B = new Timer(500, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            pause3++;
            L33.setIcon(new ImageIcon("C:\\memorygame\\level3\\3.jpg"));
            L316.setIcon(new ImageIcon("C:\\memorygame\\level3\\3.jpg"));
            if (pause3 == 2) {
                T33B.stop();
                L33.setVisible(false);
                L316.setVisible(false);
                pause3 = 0;
                plus_one_level3();
            }
        }
    });
    Timer T34B = new Timer(500, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            pause3++;
            L34.setIcon(new ImageIcon("C:\\memorygame\\level3\\4.jpg"));
            L311.setIcon(new ImageIcon("C:\\memorygame\\level3\\4.jpg"));
            if (pause3 == 2) {
                T34B.stop();
                L34.setVisible(false);
                L311.setVisible(false);
                pause3 = 0;
                plus_one_level3();
            }
        }
    });
    Timer T35B = new Timer(500, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            pause3++;
            L35.setIcon(new ImageIcon("C:\\memorygame\\level3\\5.jpg"));
            L37.setIcon(new ImageIcon("C:\\memorygame\\level3\\5.jpg"));
            if (pause3 == 2) {
                T35B.stop();
                L35.setVisible(false);
                L37.setVisible(false);
                pause3 = 0;
                plus_one_level3();
            }
        }
    });
    Timer T38B = new Timer(500, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            pause3++;
            L38.setIcon(new ImageIcon("C:\\memorygame\\level3\\6.jpg"));
            L312.setIcon(new ImageIcon("C:\\memorygame\\level3\\6.jpg"));
            if (pause3 == 2) {
                T38B.stop();
                L38.setVisible(false);
                L312.setVisible(false);
                pause3 = 0;
                plus_one_level3();
            }
        }
    });
    Timer T39B = new Timer(500, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            pause3++;
            L39.setIcon(new ImageIcon("C:\\memorygame\\level3\\7.jpg"));
            L317.setIcon(new ImageIcon("C:\\memorygame\\level3\\7.jpg"));
            if (pause3 == 2) {
                T39B.stop();
                L39.setVisible(false);
                L317.setVisible(false);
                pause3 = 0;
                plus_one_level3();
            }
        }
    });
    Timer T310B = new Timer(500, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            pause3++;
            L310.setIcon(new ImageIcon("C:\\memorygame\\level3\\8.jpg"));
            L319.setIcon(new ImageIcon("C:\\memorygame\\level3\\8.jpg"));
            if (pause3 == 2) {
                T310B.stop();
                L310.setVisible(false);
                L319.setVisible(false);
                pause3 = 0;
                plus_one_level3();
            }
        }
    });
    Timer T313B = new Timer(500, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            pause3++;
            L313.setIcon(new ImageIcon("C:\\memorygame\\level3\\9.png"));
            L320.setIcon(new ImageIcon("C:\\memorygame\\level3\\9.png"));
            if (pause3 == 2) {
                T313B.stop();
                L313.setVisible(false);
                L320.setVisible(false);
                pause3 = 0;
                plus_one_level3();
            }
        }
    });
    Timer T318B = new Timer(500, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            pause3++;
            L318.setIcon(new ImageIcon("C:\\memorygame\\level3\\10.jpg"));
            L315.setIcon(new ImageIcon("C:\\memorygame\\level3\\10.jpg"));
            if (pause3 == 2) {
                T318B.stop();
                L318.setVisible(false);
                L315.setVisible(false);
                pause3 = 0;
                plus_one_level3();
            }
        }
    });
   
    //STD
    int STD1score = 0;
    boolean STD11 = false, STD12 = false, STD13 = false, STD14 = false;
    int SL1 = 25;
    boolean STD21 = false, STD22 = false, STD23 = false, STD24 = false, STD25 = false, flag = false;
    int SL2 = 30;
    int STD2score = 0;
    boolean STD31 = false, STD32 = false, STD33 = false, STD34 = false, STD35 = false, STD36 = false, STD37 = false;
    int SL3 = 40;
    int STD3score = 0;
    Timer STD1 = new Timer(1000, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            SL1--;
            STD1t.setText("" + SL1);
            if (SL1 == 0 || STD1score == 4 || (STD11==true && STD12 ==true && STD13 ==true && STD14 ==true)) {
                STD1.stop();
                STDL1score.setVisible(true);
                STDL1.setVisible(false);
                Congrats2.setText("Congrats, you have completed in " + (25 - SL1) + " secs");
                if (STD1score == 4) {
                    sc1.setText((STD1score + 2) + "");
                    Sl6.setIcon(new ImageIcon("C:\\memorygame\\star.jpg"));
                    Sl4.setIcon(new ImageIcon("C:\\memorygame\\star.jpg"));
                    Sl5.setIcon(new ImageIcon("C:\\memorygame\\star.jpg"));
                } else if (STD1score <= 4 && STD1score >= 0) {
                    sc1.setText((STD1score + 1) + "");
                    Sl6.setIcon(new ImageIcon("C:\\memorygame\\star.jpg"));
                    Sl4.setIcon(new ImageIcon("C:\\memorygame\\star.jpg"));
                } else {
                    sc1.setText(STD1score + "");
                }
                Sl6.setIcon(new ImageIcon("C:\\memorygame\\star.jpg"));

            }

        }
    });
    Timer STD2 = new Timer(1000, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            SL2--;
            STD2t.setText("" + SL2);
            if (SL2 == 0 || STD2score == 5 ||(STD21==true && STD22 ==true && STD23 ==true && STD24 ==true && STD25 ==true)) {
                STD2.stop();
                STDL2score.setVisible(true);
                STDL2.setVisible(false);
                Congrats3.setText("Congrats, you have completed in " + (30 - SL2) + " secs");
                if (STD2score == 5) {
                    sc3.setText((STD2score + 2) + "");
                    Sl7.setIcon(new ImageIcon("C:\\memorygame\\star.jpg"));
                    Sl8.setIcon(new ImageIcon("C:\\memorygame\\star.jpg"));
                    Sl9.setIcon(new ImageIcon("C:\\memorygame\\star.jpg"));
                } else if (STD2score <= 5 && STD2score >= 0) {
                    sc3.setText((STD2score + 1) + "");
                    Sl7.setIcon(new ImageIcon("C:\\memorygame\\star.jpg"));
                    Sl8.setIcon(new ImageIcon("C:\\memorygame\\star.jpg"));
                } else {
                    sc3.setText(STD2score + "");
                }
                Sl7.setIcon(new ImageIcon("C:\\memorygame\\star.jpg"));

            }
        }
    });    
    Timer STD3 = new Timer(1000, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            if( STD31==true && STD32==true && STD33==true && STD34==true && STD35==true && STD36==true && STD37 ==true)
            {flag=true;}
            SL3--;
            STD3t.setText("" + SL3);
            if (SL3 == 0 || STD3score == 7 || flag == true) {
                STD3.stop();
                STDL3score.setVisible(true);
                STDL3.setVisible(false);
                Congrats4.setText("Congrats, you have completed in " + (40 - SL3) + " secs");
                if (STD3score == 7) {
                    sc4.setText((STD3score + 2) + "");
                    Sl10.setIcon(new ImageIcon("C:\\memorygame\\star.jpg"));
                    Sl11.setIcon(new ImageIcon("C:\\memorygame\\star.jpg"));
                    Sl12.setIcon(new ImageIcon("C:\\memorygame\\star.jpg"));
                } else if (STD3score <= 6 && STD3score >= 0) {
                    sc4.setText((STD3score + 1) + "");
                    Sl10.setIcon(new ImageIcon("C:\\memorygame\\star.jpg"));
                    Sl11.setIcon(new ImageIcon("C:\\memorygame\\star.jpg"));
                } else {
                    sc4.setText(STD3score + "");
                }
                Sl10.setIcon(new ImageIcon("C:\\memorygame\\star.jpg"));

            }
            if (STD31 == true && STD32 == true && STD33 == true && STD34 == true && STD35 == true && STD36 == true) {
                flag = true;
            }
        }
    });
    
//quiz
  int wait=0,quizscore=0;char x;
     private void check(char x){ 
        switch(x){
    case 'A':{if(A.isSelected()==true){
    A.setText(A.getText()+"(Correct answer)");
    quizscore+=10;scd.setText(quizscore+"");}
    else if(C.isSelected()==true || B.isSelected()==true || D.isSelected()==true){
    A.setSelected(true);
    A.setText(A.getText()+"(correct answer)");}}
    break;
    
    case 'B':{if(B.isSelected()==true){
    B.setText(B.getText()+"(Correct answer)");
    quizscore+=10;scd.setText(quizscore+"");}
    else if(C.isSelected()==true || A.isSelected()==true || D.isSelected()==true){
    B.setSelected(true);
    B.setText(B.getText()+"(correct answer)");}}
    break;
    
    case 'C':{if(C.isSelected()==true){
    C.setText(C.getText()+"(Correct answer)");
    quizscore+=10;scd.setText(quizscore+"");}
    else if(C.isSelected()==true || A.isSelected()==true || D.isSelected()==true){
    C.setSelected(true);
    C.setText(C.getText()+"(correct answer)");}}
    break;
    
    case 'D':{if(D.isSelected()==true){
    D.setText(D.getText()+"(Correct answer)");
    quizscore+=10;scd.setText(quizscore+"");}
    else if(C.isSelected()==true || A.isSelected()==true || B.isSelected()==true){
    D.setSelected(true);
    D.setText(D.getText()+"(correct answer)");
        }}
    
        }}
     public void quizz(int qno){
        if (qno==1 || qno==2)
            {if(qno==1){qu1.setText("Q.1.The Minions say the word ");
             qu2.setText("\"Gelato\", but what does ");
             qu3.setText("this mean??");
                
            A.setText("Ham");
            B.setText("Latte");
            C.setText("Ice-cream");
            D.setText("Jelly");}
           else if(qno==2)
            check('C');
            }
        else if(qno==3 || qno==4)
          {if(qno==3){qu1.setText("Q.2.What are the names of the ");
           qu2.setText("minions in the 2015 film ");
           qu3.setText("Minions??");
           
            A.setText("Kevin, Bob, Stuart");
            B.setText("Gareth, Bob, Stuart");
            C.setText("Kevin, Bob, Nathan");
            D.setText("Kevin, Sally, Stuart");}
          else if(qno==4) 
             check('A');
            }
        else if(qno==5 || qno==6)
           {if (qno==5){qu1.setText("Q.3.Who is the bigger sister in ");
            qu2.setText("the Despicable Me films??");
            qu3.setText("");
            
            A.setText("Edith");
            B.setText("Agnus");
            C.setText("Margo");
            D.setText("Heather");}
           else if(qno==6)
             check('C');
            }
        else if(qno==7 || qno==8)
            {if(qno==7){qu1.setText("Q.4.How many fingers do the ");
             qu2.setText("minions have in each ");
             qu3.setText("hand?");
        
            A.setText("5");
            B.setText("3");
            C.setText("4");
            D.setText("6");}
            else if(qno==8)
             check('B');  
            }
        else if (qno==9 ||qno==10)
          {if(qno==9){qu1.setText("Q.5.The Minions say the word ");
           qu2.setText("\"Kanpai\", but what does this");
           qu3.setText("mean??");
             
            A.setText("Can we start?");
            B.setText("Hello");
            C.setText("Party");
            D.setText("Cheers");}
          else if(qno==10)
            check('D');             }
        else if (qno==11 || qno==12)
            {if(qno==11){qu1.setText("Q.6.Who made the purple Minions??");
             qu2.setText("");
             qu3.setText("");
             
            A.setText("Dr.Nefario");
            B.setText("Gru");
            C.setText("Gareth");
            D.setText("El Macho");}
            else if(qno==12)
              check('D');  }            
        
        else if (qno==13 || qno==14){
            if(qno==13){qu1.setText("Q.7.Why did the Minions go to  ");
            qu2.setText("Orlando??");
            qu3.setText("");
            
            A.setText("Villian Con");
            B.setText("To fing Gru");
            C.setText("Vacation");
            D.setText("To find some Bananas");}
            else if(qno==14)
             check('A'); } 
        
        else if (qno==15 || qno==16)
        {if (qno==15){qu1.setText("Q.8.How did all the Minions arrive");
           qu2.setText(" in London??");
           qu3.setText("");
   
            A.setText("Swam");
            B.setText("A Boat");
            C.setText("The Tube");
            D.setText("An Airplane");}
        else if(qno==16)
          check('C');
        } 
        else if (qno==17 ||qno==18)
           {if(qno==17){qu1.setText("Q.9.How many natural hairstyles");
            qu2.setText("do the minions have??");
            qu3.setText("");
          
            A.setText("4");
            B.setText("3");
            C.setText("1");
            D.setText("5");}
           else if(qno==18)
            check('B'); }
        
        else if(qno==19 || qno==20)
           {if (qno==19){qu1.setText("Q.10.Minions speak a mixture of..");
            qu2.setText("");
            qu3.setText("");
            
            A.setText("3 Languages");
            B.setText("4 Languages");
            C.setText("5 Languages");
            D.setText("6 Languages");}
           else if (qno==20)
            check('D');}}
    
    

    /**
     * Creates new form main
     */
    public main() {
        initComponents();
              try
{
        try
{
    homepagesound=new FileInputStream("c:\\memorygame\\music\\homepage.wav");
    gamehomesound=new FileInputStream("c:\\memorygame\\music\\gamehome.wav");
    gamebg=new FileInputStream("c:\\memorygame\\music\\gamebg.wav");
    congratssound=new FileInputStream("c:\\memorygame\\music\\congrats.wav");
}
catch(Exception e)
{
    e.printStackTrace();
}
as1=new AudioStream(homepagesound);
as2=new AudioStream(gamehomesound);
as3=new AudioStream(gamebg);
as4=new AudioStream(congratssound);



    }
    catch(Exception e)
    {
        System.err.println(e);
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

        login = new javax.swing.JFrame();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        l_uname = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        l_pass = new javax.swing.JPasswordField();
        about = new javax.swing.JDialog();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton6 = new javax.swing.JButton();
        signup = new javax.swing.JDialog();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        s_nname = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        s_dob = new javax.swing.JTextField();
        s_uname = new javax.swing.JTextField();
        s_pass = new javax.swing.JPasswordField();
        loading = new javax.swing.JFrame();
        jPanel5 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        loadlabel = new javax.swing.JLabel();
        pp1 = new javax.swing.JProgressBar();
        progress = new javax.swing.JLabel();
        gamehome = new javax.swing.JFrame();
        hello = new javax.swing.JLabel();
        hello1 = new javax.swing.JLabel();
        jButton18 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton31 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        hi = new javax.swing.JLabel();
        Highscore = new javax.swing.JFrame();
        jLabel74 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        bg8 = new javax.swing.JLabel();
        GameHighscore = new javax.swing.JFrame();
        jScrollPane4 = new javax.swing.JScrollPane();
        t1 = new javax.swing.JTable();
        jLabel76 = new javax.swing.JLabel();
        bg7 = new javax.swing.JLabel();
        MGhome = new javax.swing.JFrame();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        jButton35 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        MGL1 = new javax.swing.JFrame();
        jPanel6 = new javax.swing.JPanel();
        L1 = new javax.swing.JLabel();
        L2 = new javax.swing.JLabel();
        L3 = new javax.swing.JLabel();
        L4 = new javax.swing.JLabel();
        L5 = new javax.swing.JLabel();
        L6 = new javax.swing.JLabel();
        Time1 = new javax.swing.JLabel();
        Score = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jlabel10 = new javax.swing.JLabel();
        Time2 = new javax.swing.JLabel();
        g1 = new javax.swing.JLabel();
        MGL1score = new javax.swing.JDialog();
        jPanel8 = new javax.swing.JPanel();
        congratss = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        Sl2 = new javax.swing.JLabel();
        Sl3 = new javax.swing.JLabel();
        Sl1 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        sc = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        bg2 = new javax.swing.JLabel();
        MGL2 = new javax.swing.JFrame();
        jPanel9 = new javax.swing.JPanel();
        L21 = new javax.swing.JLabel();
        L22 = new javax.swing.JLabel();
        L23 = new javax.swing.JLabel();
        L24 = new javax.swing.JLabel();
        L25 = new javax.swing.JLabel();
        L26 = new javax.swing.JLabel();
        L27 = new javax.swing.JLabel();
        L28 = new javax.swing.JLabel();
        L29 = new javax.swing.JLabel();
        L210 = new javax.swing.JLabel();
        L211 = new javax.swing.JLabel();
        L212 = new javax.swing.JLabel();
        time21 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        time22 = new javax.swing.JLabel();
        Score2 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        g2 = new javax.swing.JLabel();
        MGL2score = new javax.swing.JDialog();
        jPanel10 = new javax.swing.JPanel();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        Congrats1 = new javax.swing.JLabel();
        S21 = new javax.swing.JLabel();
        S22 = new javax.swing.JLabel();
        S23 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        sc2 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        bg3 = new javax.swing.JLabel();
        MGL3 = new javax.swing.JFrame();
        jPanel19 = new javax.swing.JPanel();
        L31 = new javax.swing.JLabel();
        L32 = new javax.swing.JLabel();
        L33 = new javax.swing.JLabel();
        L34 = new javax.swing.JLabel();
        L38 = new javax.swing.JLabel();
        L37 = new javax.swing.JLabel();
        L36 = new javax.swing.JLabel();
        L312 = new javax.swing.JLabel();
        L311 = new javax.swing.JLabel();
        L310 = new javax.swing.JLabel();
        L39 = new javax.swing.JLabel();
        L313 = new javax.swing.JLabel();
        L314 = new javax.swing.JLabel();
        L315 = new javax.swing.JLabel();
        L316 = new javax.swing.JLabel();
        L317 = new javax.swing.JLabel();
        L318 = new javax.swing.JLabel();
        L319 = new javax.swing.JLabel();
        L320 = new javax.swing.JLabel();
        L35 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        Score3 = new javax.swing.JLabel();
        time32 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        time31 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        g3 = new javax.swing.JLabel();
        MGL3score = new javax.swing.JFrame();
        jPanel20 = new javax.swing.JPanel();
        jButton32 = new javax.swing.JButton();
        jButton33 = new javax.swing.JButton();
        jButton34 = new javax.swing.JButton();
        Congrats5 = new javax.swing.JLabel();
        S31 = new javax.swing.JLabel();
        S32 = new javax.swing.JLabel();
        S33 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        sc5 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();
        STDhome = new javax.swing.JFrame();
        jPanel16 = new javax.swing.JPanel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jButton20 = new javax.swing.JButton();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jButton36 = new javax.swing.JButton();
        STDL1 = new javax.swing.JFrame();
        jPanel7 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        sd1score = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        STD1t = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        STDL1score = new javax.swing.JFrame();
        jPanel11 = new javax.swing.JPanel();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        Congrats2 = new javax.swing.JLabel();
        Sl4 = new javax.swing.JLabel();
        Sl5 = new javax.swing.JLabel();
        Sl6 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        sc1 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        bg1 = new javax.swing.JLabel();
        STDL2 = new javax.swing.JFrame();
        jPanel12 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        sd2score = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        STD2t = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        STDL2score = new javax.swing.JFrame();
        jPanel13 = new javax.swing.JPanel();
        jButton24 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        Congrats3 = new javax.swing.JLabel();
        Sl7 = new javax.swing.JLabel();
        Sl8 = new javax.swing.JLabel();
        Sl9 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        sc3 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        bg4 = new javax.swing.JLabel();
        STDL3 = new javax.swing.JFrame();
        jPanel14 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        sd3score = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        STD3t = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        STDL3score = new javax.swing.JFrame();
        jPanel15 = new javax.swing.JPanel();
        jButton27 = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();
        jButton29 = new javax.swing.JButton();
        Congrats4 = new javax.swing.JLabel();
        Sl10 = new javax.swing.JLabel();
        Sl11 = new javax.swing.JLabel();
        Sl12 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        sc4 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        bg5 = new javax.swing.JLabel();
        QuizHome = new javax.swing.JFrame();
        jPanel17 = new javax.swing.JPanel();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jButton30 = new javax.swing.JButton();
        jLabel72 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        Quiz = new javax.swing.JFrame();
        qu1 = new javax.swing.JLabel();
        qu2 = new javax.swing.JLabel();
        qu3 = new javax.swing.JLabel();
        B = new javax.swing.JRadioButton();
        C = new javax.swing.JRadioButton();
        D = new javax.swing.JRadioButton();
        A = new javax.swing.JRadioButton();
        jButton2 = new javax.swing.JButton();
        scd = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        hey = new javax.swing.JLabel();
        QuizScore = new javax.swing.JFrame();
        jPanel21 = new javax.swing.JPanel();
        jButton39 = new javax.swing.JButton();
        jButton40 = new javax.swing.JButton();
        jButton41 = new javax.swing.JButton();
        Congrats6 = new javax.swing.JLabel();
        Q1 = new javax.swing.JLabel();
        Q2 = new javax.swing.JLabel();
        Q3 = new javax.swing.JLabel();
        quizs = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        lm = new javax.swing.JLabel();
        jFrame1 = new javax.swing.JFrame();
        jPanel23 = new javax.swing.JPanel();
        congrats555 = new javax.swing.JLabel();
        jButton37 = new javax.swing.JButton();
        jButton42 = new javax.swing.JButton();
        jButton43 = new javax.swing.JButton();
        Sl222 = new javax.swing.JLabel();
        Sl3333 = new javax.swing.JLabel();
        Sl1111 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        scc = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        bg9 = new javax.swing.JLabel();
        jSlider1 = new javax.swing.JSlider();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();

        login.setTitle("LOGIN");
        login.setBackground(new java.awt.Color(255, 255, 255));
        login.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        login.setMinimumSize(new java.awt.Dimension(796, 456));
        login.setResizable(false);
        login.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                loginWindowActivated(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 247, 101));
        jPanel2.setMinimumSize(new java.awt.Dimension(796, 456));
        jPanel2.setPreferredSize(new java.awt.Dimension(796, 456));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projectsample/images/minions-15-hitman.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 210, 270));

        jLabel4.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 18)); // NOI18N
        jLabel4.setText("Username-");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 120, 160, 40));

        jLabel5.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 18)); // NOI18N
        jLabel5.setText("Password-");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 180, 160, 40));

        l_uname.setBackground(new java.awt.Color(255, 247, 101));
        l_uname.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(l_uname, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 120, 230, 40));

        jLabel6.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 48)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 255));
        jLabel6.setText("Login");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, 410, 60));

        jButton3.setBackground(new java.awt.Color(255, 247, 101));
        jButton3.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 24)); // NOI18N
        jButton3.setForeground(new java.awt.Color(102, 102, 255));
        jButton3.setText("Enter");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 230, 120, 50));

        jButton7.setBackground(new java.awt.Color(255, 247, 101));
        jButton7.setFont(new java.awt.Font("Gill Sans Ultra Bold", 1, 18)); // NOI18N
        jButton7.setForeground(new java.awt.Color(102, 102, 255));
        jButton7.setText("Back");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 100, 50));

        jButton8.setBackground(new java.awt.Color(255, 247, 101));
        jButton8.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 48)); // NOI18N
        jButton8.setForeground(new java.awt.Color(102, 102, 255));
        jButton8.setText("Or sign up");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 300, 390, 80));

        l_pass.setBackground(new java.awt.Color(255, 247, 101));
        l_pass.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(l_pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 180, 230, 40));

        javax.swing.GroupLayout loginLayout = new javax.swing.GroupLayout(login.getContentPane());
        login.getContentPane().setLayout(loginLayout);
        loginLayout.setHorizontalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        loginLayout.setVerticalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        about.setTitle("ABOUT");
        about.setMinimumSize(new java.awt.Dimension(504, 381));
        about.setResizable(false);

        jPanel3.setBackground(new java.awt.Color(102, 102, 255));

        jLabel3.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(254, 228, 116));
        jLabel3.setText("About");

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(102, 102, 255));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 24)); // NOI18N
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText("Hey there! Welcome to ourgame. If you love the \nMINIONS you've come to \nthe right place.Here you'll find three amazing \nfun-filled games. \nSo enjoy!");
        jTextArea1.setAutoscrolls(false);
        jTextArea1.setBorder(null);
        jScrollPane1.setViewportView(jTextArea1);

        jButton6.setBackground(new java.awt.Color(102, 102, 255));
        jButton6.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 24)); // NOI18N
        jButton6.setForeground(new java.awt.Color(254, 228, 116));
        jButton6.setText("Close");
        jButton6.setBorder(null);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout aboutLayout = new javax.swing.GroupLayout(about.getContentPane());
        about.getContentPane().setLayout(aboutLayout);
        aboutLayout.setHorizontalGroup(
            aboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        aboutLayout.setVerticalGroup(
            aboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        signup.setTitle("SIGN UP");
        signup.setMinimumSize(new java.awt.Dimension(559, 388));
        signup.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                signupWindowActivated(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(255, 247, 101));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Gill Sans Ultra Bold", 1, 48)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 255));
        jLabel7.setText("Sign up...");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 340, 50));

        jButton5.setBackground(new java.awt.Color(255, 247, 101));
        jButton5.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 24)); // NOI18N
        jButton5.setForeground(new java.awt.Color(102, 102, 255));
        jButton5.setText("submit");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 270, 190, 70));

        s_nname.setBackground(new java.awt.Color(255, 247, 101));
        s_nname.setForeground(new java.awt.Color(102, 102, 255));
        s_nname.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        s_nname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s_nnameActionPerformed(evt);
            }
        });
        jPanel4.add(s_nname, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 220, 160, 30));

        jLabel8.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 18)); // NOI18N
        jLabel8.setText("Username");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 130, 40));

        jLabel9.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 18)); // NOI18N
        jLabel9.setText("Password");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, -1, -1));

        jLabel10.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 18)); // NOI18N
        jLabel10.setText("Date of Birth");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, -1, -1));

        jLabel11.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 18)); // NOI18N
        jLabel11.setText("Nickname");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, -1, -1));

        s_dob.setBackground(new java.awt.Color(255, 247, 101));
        s_dob.setForeground(new java.awt.Color(102, 102, 255));
        s_dob.setText("YYYY-MM-DD");
        s_dob.setToolTipText("");
        s_dob.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        s_dob.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                s_dobFocusGained(evt);
            }
        });
        s_dob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s_dobActionPerformed(evt);
            }
        });
        jPanel4.add(s_dob, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 180, 160, 30));

        s_uname.setBackground(new java.awt.Color(255, 247, 101));
        s_uname.setForeground(new java.awt.Color(102, 102, 255));
        s_uname.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        s_uname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s_unameActionPerformed(evt);
            }
        });
        jPanel4.add(s_uname, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 100, 160, 30));

        s_pass.setBackground(new java.awt.Color(255, 247, 101));
        s_pass.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel4.add(s_pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 140, 160, 30));

        javax.swing.GroupLayout signupLayout = new javax.swing.GroupLayout(signup.getContentPane());
        signup.getContentPane().setLayout(signupLayout);
        signupLayout.setHorizontalGroup(
            signupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 559, Short.MAX_VALUE)
        );
        signupLayout.setVerticalGroup(
            signupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
        );

        loading.setTitle("LOADING");
        loading.setMinimumSize(new java.awt.Dimension(490, 311));
        loading.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                loadingWindowActivated(evt);
            }
        });
        loading.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(242, 234, 194));
        jPanel5.setMinimumSize(new java.awt.Dimension(497, 276));
        jPanel5.setPreferredSize(new java.awt.Dimension(497, 276));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projectsample/images/giphynew.gif"))); // NOI18N
        jLabel12.setText("jLabel12");
        jLabel12.setMaximumSize(new java.awt.Dimension(500, 214));
        jLabel12.setPreferredSize(new java.awt.Dimension(500, 214));
        jPanel5.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 214));

        loadlabel.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 36)); // NOI18N
        loadlabel.setText("Loading...");
        loadlabel.setToolTipText("Patience...");
        jPanel5.add(loadlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 270, 70));

        loading.getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 290));

        progress.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 12)); // NOI18N
        progress.setText("0%");

        gamehome.setTitle("GAMEHOME");
        gamehome.setMinimumSize(new java.awt.Dimension(920, 520));
        gamehome.setPreferredSize(new java.awt.Dimension(920, 520));
        gamehome.setResizable(false);
        gamehome.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                gamehomeWindowActivated(evt);
            }
        });
        gamehome.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        hello.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 36)); // NOI18N
        hello.setText("Choose The Game You Want To Play.");
        gamehome.getContentPane().add(hello, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 820, 70));

        hello1.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 36)); // NOI18N
        gamehome.getContentPane().add(hello1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 820, 70));

        jButton18.setBackground(new java.awt.Color(255, 240, 14));
        jButton18.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 24)); // NOI18N
        jButton18.setForeground(new java.awt.Color(51, 0, 153));
        jButton18.setText("Spot The Differences");
        jButton18.setBorder(null);
        jButton18.setOpaque(false);
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });
        gamehome.getContentPane().add(jButton18, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 300, 320, 50));

        jButton9.setBackground(new java.awt.Color(255, 240, 14));
        jButton9.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 24)); // NOI18N
        jButton9.setForeground(new java.awt.Color(51, 0, 153));
        jButton9.setText("Memory Game");
        jButton9.setBorder(null);
        jButton9.setOpaque(false);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        gamehome.getContentPane().add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 270, 50));

        jButton31.setBackground(new java.awt.Color(255, 240, 14));
        jButton31.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 24)); // NOI18N
        jButton31.setForeground(new java.awt.Color(51, 0, 153));
        jButton31.setText("Quiz");
        jButton31.setBorder(null);
        jButton31.setOpaque(false);
        jButton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton31ActionPerformed(evt);
            }
        });
        gamehome.getContentPane().add(jButton31, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 200, 190, 50));

        jButton14.setFont(new java.awt.Font("Gill Sans Ultra Bold", 1, 24)); // NOI18N
        jButton14.setForeground(new java.awt.Color(204, 0, 102));
        jButton14.setText("Highscores");
        jButton14.setOpaque(false);
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        gamehome.getContentPane().add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 410, 270, 70));

        hi.setBackground(new java.awt.Color(0, 153, 153));
        hi.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        gamehome.getContentPane().add(hi, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, 510));

        Highscore.setTitle("HIGHSCORE");
        Highscore.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                HighscoreWindowActivated(evt);
            }
        });
        Highscore.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel74.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 48)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(255, 51, 102));
        jLabel74.setText("Highscore");
        Highscore.getContentPane().add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, 310, 100));

        jScrollPane3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Username", "Nickname", "MG Level 1", "MG Level 2", "MG Level 3", "STD Level 1", "STD Level 2", "STD Level 3", "QUIZ "
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(20);
        jScrollPane3.setViewportView(jTable1);

        Highscore.getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 810, 130));

        bg8.setMaximumSize(new java.awt.Dimension(830, 420));
        bg8.setMinimumSize(new java.awt.Dimension(830, 420));
        bg8.setPreferredSize(new java.awt.Dimension(830, 420));
        Highscore.getContentPane().add(bg8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 420));

        GameHighscore.setTitle("GAME HIGHSCORE");
        GameHighscore.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                GameHighscoreWindowActivated(evt);
            }
        });
        GameHighscore.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        t1.setAutoCreateRowSorter(true);
        t1.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 24)); // NOI18N
        t1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "username", "Nickname", "Level 1 ", "Level 2 ", "Level 3 "
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        t1.setRowHeight(20);
        jScrollPane4.setViewportView(t1);

        GameHighscore.getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 600, 140));

        jLabel76.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 48)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(255, 51, 102));
        jLabel76.setText("Highscore");
        GameHighscore.getContentPane().add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, 310, 100));

        bg7.setMaximumSize(new java.awt.Dimension(760, 420));
        bg7.setMinimumSize(new java.awt.Dimension(760, 420));
        bg7.setPreferredSize(new java.awt.Dimension(760, 420));
        GameHighscore.getContentPane().add(bg7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 420));

        MGhome.setTitle("MEMORY GAME");
        MGhome.setMinimumSize(new java.awt.Dimension(780, 440));
        MGhome.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                MGhomeWindowActivated(evt);
            }
        });
        MGhome.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel63.setFont(new java.awt.Font("Gill Sans Ultra Bold Condensed", 1, 24)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(0, 51, 255));
        jLabel63.setText("and +1 for every correct pair.");
        MGhome.getContentPane().add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 540, 30));

        jLabel64.setFont(new java.awt.Font("Gill Sans Ultra Bold Condensed", 1, 24)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(0, 51, 255));
        jLabel64.setText("Click on the cards to unfold.");
        MGhome.getContentPane().add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 570, 30));

        jLabel65.setFont(new java.awt.Font("Gill Sans Ultra Bold Condensed", 1, 36)); // NOI18N
        jLabel65.setText("HOW DO I PLAY?");
        MGhome.getContentPane().add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 330, 50));

        jLabel66.setFont(new java.awt.Font("Gill Sans Ultra Bold Condensed", 1, 24)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(0, 51, 255));
        jLabel66.setText("Try to find its correct pair in the race against time");
        MGhome.getContentPane().add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 650, 40));

        jPanel18.setBackground(new java.awt.Color(254, 228, 116));
        jPanel18.setMaximumSize(new java.awt.Dimension(780, 440));
        jPanel18.setMinimumSize(new java.awt.Dimension(780, 440));
        jPanel18.setPreferredSize(new java.awt.Dimension(780, 440));
        jPanel18.setRequestFocusEnabled(false);
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel67.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projectsample/images/despicable-me-Minions.jpg"))); // NOI18N
        jLabel67.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel18.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, -1, 170));

        jButton35.setFont(new java.awt.Font("Gill Sans Ultra Bold Condensed", 0, 18)); // NOI18N
        jButton35.setText("Memory Game Highscore");
        jButton35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton35ActionPerformed(evt);
            }
        });
        jPanel18.add(jButton35, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 330, 240, 50));

        jButton19.setFont(new java.awt.Font("Gill Sans Ultra Bold Condensed", 0, 24)); // NOI18N
        jButton19.setText("Lets Play");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });
        jPanel18.add(jButton19, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 250, 179, 52));

        MGhome.getContentPane().add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 440));

        MGL1.setTitle("LEVEL 1");
        MGL1.setMinimumSize(new java.awt.Dimension(790, 500));
        MGL1.setResizable(false);
        MGL1.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                MGL1WindowActivated(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 102)));
        jPanel6.setMinimumSize(new java.awt.Dimension(790, 495));
        jPanel6.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanel6ComponentShown(evt);
            }
        });
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        L1.setBackground(new java.awt.Color(255, 255, 153));
        L1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)));
        L1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                L1MouseClicked(evt);
            }
        });
        jPanel6.add(L1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, 100, 100));

        L2.setBackground(new java.awt.Color(255, 255, 153));
        L2.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)));
        L2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                L2MouseClicked(evt);
            }
        });
        jPanel6.add(L2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 60, 100, 100));

        L3.setBackground(new java.awt.Color(255, 255, 153));
        L3.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)));
        L3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                L3MouseClicked(evt);
            }
        });
        L3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                L3KeyPressed(evt);
            }
        });
        jPanel6.add(L3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 170, 100, 100));

        L4.setBackground(new java.awt.Color(255, 255, 153));
        L4.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)));
        L4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                L4MouseClicked(evt);
            }
        });
        jPanel6.add(L4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 170, 100, 100));

        L5.setBackground(new java.awt.Color(255, 255, 153));
        L5.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)));
        L5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                L5MouseClicked(evt);
            }
        });
        jPanel6.add(L5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 290, 100, 100));

        L6.setBackground(new java.awt.Color(255, 255, 153));
        L6.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)));
        L6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                L6MouseClicked(evt);
            }
        });
        jPanel6.add(L6, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 290, 100, 100));

        Time1.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 24)); // NOI18N
        Time1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel6.add(Time1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 110, 90, 60));

        Score.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 24)); // NOI18N
        Score.setToolTipText("");
        Score.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel6.add(Score, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 280, 150, 50));

        jLabel13.setBackground(new java.awt.Color(255, 255, 102));
        jLabel13.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 36)); // NOI18N
        jLabel13.setText("Time");
        jPanel6.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 40, 150, 40));

        jLabel14.setBackground(new java.awt.Color(255, 255, 102));
        jLabel14.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 36)); // NOI18N
        jLabel14.setText("Score");
        jPanel6.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 210, 150, 40));

        jlabel10.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jlabel10.setText(":");
        jlabel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel6.add(jlabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 110, 40, 60));

        Time2.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 24)); // NOI18N
        Time2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel6.add(Time2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 110, 90, 60));

        g1.setMaximumSize(new java.awt.Dimension(790, 500));
        g1.setMinimumSize(new java.awt.Dimension(790, 500));
        g1.setPreferredSize(new java.awt.Dimension(790, 500));
        jPanel6.add(g1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 500));

        javax.swing.GroupLayout MGL1Layout = new javax.swing.GroupLayout(MGL1.getContentPane());
        MGL1.getContentPane().setLayout(MGL1Layout);
        MGL1Layout.setHorizontalGroup(
            MGL1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        MGL1Layout.setVerticalGroup(
            MGL1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        MGL1score.setTitle("SCORE");
        MGL1score.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                MGL1scoreWindowActivated(evt);
            }
        });
        MGL1score.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setMaximumSize(new java.awt.Dimension(500, 410));
        jPanel8.setMinimumSize(new java.awt.Dimension(500, 410));
        jPanel8.setName(""); // NOI18N
        jPanel8.setPreferredSize(new java.awt.Dimension(500, 410));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        congratss.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 18)); // NOI18N
        congratss.setForeground(new java.awt.Color(204, 0, 102));
        jPanel8.add(congratss, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 500, 70));

        jButton11.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 24)); // NOI18N
        jButton11.setText("Next Level");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, 210, 50));

        jButton12.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 24)); // NOI18N
        jButton12.setText("Back");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, -1, -1));

        jButton13.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 24)); // NOI18N
        jButton13.setText("Quit");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 330, -1, -1));
        jPanel8.add(Sl2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, 90, 80));
        jPanel8.add(Sl3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 170, 110, 90));
        jPanel8.add(Sl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 90, 80));

        jLabel15.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 24)); // NOI18N
        jLabel15.setText("Score");
        jPanel8.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, 90, 30));

        sc.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 24)); // NOI18N
        sc.setForeground(new java.awt.Color(204, 0, 102));
        sc.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel8.add(sc, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, 70, 50));

        jLabel19.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 24)); // NOI18N
        jLabel19.setText("LEVEL1");
        jPanel8.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        bg2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bg2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bg2.setMaximumSize(new java.awt.Dimension(500, 410));
        bg2.setMinimumSize(new java.awt.Dimension(500, 410));
        bg2.setPreferredSize(new java.awt.Dimension(500, 410));
        jPanel8.add(bg2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 410));
        bg2.getAccessibleContext().setAccessibleDescription("");

        MGL1score.getContentPane().add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        MGL2.setTitle("LEVEL 2");
        MGL2.setMinimumSize(new java.awt.Dimension(780, 560));
        MGL2.setResizable(false);
        MGL2.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                MGL2WindowActivated(evt);
            }
        });

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setMaximumSize(new java.awt.Dimension(780, 540));
        jPanel9.setMinimumSize(new java.awt.Dimension(780, 540));
        jPanel9.setPreferredSize(new java.awt.Dimension(780, 460));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        L21.setName(""); // NOI18N
        L21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                L21MouseClicked(evt);
            }
        });
        jPanel9.add(L21, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 100, 100));

        L22.setName(""); // NOI18N
        L22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                L22MouseClicked(evt);
            }
        });
        jPanel9.add(L22, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 100, 100));

        L23.setName(""); // NOI18N
        L23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                L23MouseClicked(evt);
            }
        });
        jPanel9.add(L23, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 100, 100));

        L24.setName(""); // NOI18N
        L24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                L24MouseClicked(evt);
            }
        });
        jPanel9.add(L24, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, 100, 100));

        L25.setName(""); // NOI18N
        L25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                L25MouseClicked(evt);
            }
        });
        jPanel9.add(L25, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 100, 100));

        L26.setName(""); // NOI18N
        L26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                L26MouseClicked(evt);
            }
        });
        jPanel9.add(L26, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 130, 100, 100));

        L27.setName(""); // NOI18N
        L27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                L27MouseClicked(evt);
            }
        });
        jPanel9.add(L27, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 100, 100));

        L28.setName(""); // NOI18N
        L28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                L28MouseClicked(evt);
            }
        });
        jPanel9.add(L28, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 130, 100, 100));

        L29.setName(""); // NOI18N
        L29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                L29MouseClicked(evt);
            }
        });
        jPanel9.add(L29, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 100, 100));

        L210.setName(""); // NOI18N
        L210.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                L210MouseClicked(evt);
            }
        });
        jPanel9.add(L210, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, 100, 100));

        L211.setName(""); // NOI18N
        L211.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                L211MouseClicked(evt);
            }
        });
        jPanel9.add(L211, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 250, 100, 100));

        L212.setName(""); // NOI18N
        L212.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                L212MouseClicked(evt);
            }
        });
        jPanel9.add(L212, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 250, 100, 100));

        time21.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 24)); // NOI18N
        jPanel9.add(time21, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 100, 60, 60));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel17.setText(":");
        jPanel9.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 100, -1, -1));

        time22.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 24)); // NOI18N
        jPanel9.add(time22, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 100, 60, 60));

        Score2.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 24)); // NOI18N
        jPanel9.add(Score2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 270, 90, 50));

        jLabel20.setBackground(new java.awt.Color(255, 255, 102));
        jLabel20.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 24)); // NOI18N
        jLabel20.setText("Time");
        jPanel9.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 30, 150, 40));

        jLabel21.setBackground(new java.awt.Color(255, 255, 102));
        jLabel21.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 24)); // NOI18N
        jLabel21.setText("Score");
        jPanel9.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 200, 150, 40));

        g2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        g2.setMaximumSize(new java.awt.Dimension(780, 560));
        g2.setMinimumSize(new java.awt.Dimension(780, 560));
        g2.setPreferredSize(new java.awt.Dimension(780, 560));
        g2.setRequestFocusEnabled(false);
        jPanel9.add(g2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 780, 560));

        javax.swing.GroupLayout MGL2Layout = new javax.swing.GroupLayout(MGL2.getContentPane());
        MGL2.getContentPane().setLayout(MGL2Layout);
        MGL2Layout.setHorizontalGroup(
            MGL2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        MGL2Layout.setVerticalGroup(
            MGL2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
        );

        MGL2score.setTitle("SCORE");
        MGL2score.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                MGL2scoreWindowActivated(evt);
            }
        });
        MGL2score.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel10.setBackground(new java.awt.Color(204, 255, 255));
        jPanel10.setForeground(new java.awt.Color(204, 255, 255));
        jPanel10.setMinimumSize(new java.awt.Dimension(480, 400));
        jPanel10.setPreferredSize(new java.awt.Dimension(480, 400));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton15.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 24)); // NOI18N
        jButton15.setText("Next Level");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 280, 200, 50));

        jButton16.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 24)); // NOI18N
        jButton16.setText("Back");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, -1));

        jButton17.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 24)); // NOI18N
        jButton17.setText("Quit");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton17, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 310, -1, -1));

        Congrats1.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 18)); // NOI18N
        Congrats1.setForeground(new java.awt.Color(204, 0, 51));
        Congrats1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel10.add(Congrats1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 480, 60));
        jPanel10.add(S21, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 90, 80));
        jPanel10.add(S22, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 200, 80, 70));
        jPanel10.add(S23, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 170, 80, 70));

        jLabel18.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 24)); // NOI18N
        jLabel18.setText("Score");
        jPanel10.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, 100, 30));

        sc2.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 24)); // NOI18N
        sc2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel10.add(sc2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, 100, 60));

        jLabel16.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 24)); // NOI18N
        jLabel16.setText("LEVEL 2");
        jPanel10.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        bg3.setMaximumSize(new java.awt.Dimension(480, 400));
        bg3.setMinimumSize(new java.awt.Dimension(480, 400));
        bg3.setPreferredSize(new java.awt.Dimension(480, 400));
        jPanel10.add(bg3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 400));

        MGL2score.getContentPane().add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 400));

        MGL3.setTitle("LEVEL 3");
        MGL3.setMinimumSize(new java.awt.Dimension(860, 610));
        MGL3.setResizable(false);
        MGL3.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                MGL3WindowActivated(evt);
            }
        });

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));
        jPanel19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        L31.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                L31MouseClicked(evt);
            }
        });
        jPanel19.add(L31, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, 100, 100));

        L32.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                L32MouseClicked(evt);
            }
        });
        jPanel19.add(L32, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, 100, 100));

        L33.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                L33MouseClicked(evt);
            }
        });
        jPanel19.add(L33, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 20, 100, 100));

        L34.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                L34MouseClicked(evt);
            }
        });
        jPanel19.add(L34, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 20, 100, 100));

        L38.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                L38MouseClicked(evt);
            }
        });
        jPanel19.add(L38, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 130, 100, 100));

        L37.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                L37MouseClicked(evt);
            }
        });
        jPanel19.add(L37, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 130, 100, 100));

        L36.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                L36MouseClicked(evt);
            }
        });
        jPanel19.add(L36, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 130, 100, 100));

        L312.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                L312MouseClicked(evt);
            }
        });
        jPanel19.add(L312, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 240, 100, 100));

        L311.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                L311MouseClicked(evt);
            }
        });
        jPanel19.add(L311, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 240, 100, 100));

        L310.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                L310MouseClicked(evt);
            }
        });
        jPanel19.add(L310, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 240, 100, 100));

        L39.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                L39MouseClicked(evt);
            }
        });
        jPanel19.add(L39, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 240, 100, 100));

        L313.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                L313MouseClicked(evt);
            }
        });
        jPanel19.add(L313, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 350, 100, 100));

        L314.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                L314MouseClicked(evt);
            }
        });
        jPanel19.add(L314, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 350, 100, 100));

        L315.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                L315MouseClicked(evt);
            }
        });
        jPanel19.add(L315, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 350, 100, 100));

        L316.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                L316MouseClicked(evt);
            }
        });
        jPanel19.add(L316, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 350, 100, 100));

        L317.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                L317MouseClicked(evt);
            }
        });
        jPanel19.add(L317, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 460, 100, 100));

        L318.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                L318MouseClicked(evt);
            }
        });
        jPanel19.add(L318, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 460, 100, 100));

        L319.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                L319MouseClicked(evt);
            }
        });
        jPanel19.add(L319, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 460, 100, 100));

        L320.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                L320MouseClicked(evt);
            }
        });
        jPanel19.add(L320, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 460, 100, 100));

        L35.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                L35MouseClicked(evt);
            }
        });
        jPanel19.add(L35, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, 100, 100));

        jLabel80.setFont(new java.awt.Font("Gill Sans Ultra Bold", 1, 36)); // NOI18N
        jLabel80.setText("Time");
        jPanel19.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 140, 50));

        jLabel82.setFont(new java.awt.Font("Gill Sans Ultra Bold", 1, 36)); // NOI18N
        jLabel82.setText("Score");
        jPanel19.add(jLabel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 150, 50));

        Score3.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 24)); // NOI18N
        jPanel19.add(Score3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 140, 50));

        time32.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 24)); // NOI18N
        jPanel19.add(time32, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 80, 60));

        jLabel85.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 24)); // NOI18N
        jLabel85.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel85.setText(":");
        jPanel19.add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 30, 60));

        time31.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 24)); // NOI18N
        jPanel19.add(time31, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 80, 60));

        jLabel91.setMaximumSize(new java.awt.Dimension(860, 599));
        jLabel91.setMinimumSize(new java.awt.Dimension(860, 599));
        jPanel19.add(jLabel91, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 600));

        g3.setBackground(new java.awt.Color(255, 255, 255));
        g3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        g3.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        g3.setMaximumSize(new java.awt.Dimension(860, 610));
        g3.setMinimumSize(new java.awt.Dimension(860, 610));
        g3.setPreferredSize(new java.awt.Dimension(860, 610));
        g3.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jPanel19.add(g3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 610));

        javax.swing.GroupLayout MGL3Layout = new javax.swing.GroupLayout(MGL3.getContentPane());
        MGL3.getContentPane().setLayout(MGL3Layout);
        MGL3Layout.setHorizontalGroup(
            MGL3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        MGL3Layout.setVerticalGroup(
            MGL3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        MGL3score.setTitle("SCORE");
        MGL3score.setMinimumSize(new java.awt.Dimension(500, 410));
        MGL3score.setResizable(false);
        MGL3score.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                MGL3scoreWindowActivated(evt);
            }
        });

        jPanel20.setBackground(new java.awt.Color(204, 255, 255));
        jPanel20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton32.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 24)); // NOI18N
        jButton32.setText("Finish");
        jButton32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton32ActionPerformed(evt);
            }
        });
        jPanel20.add(jButton32, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 300, 170, 50));

        jButton33.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 24)); // NOI18N
        jButton33.setText("Back");
        jButton33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton33ActionPerformed(evt);
            }
        });
        jPanel20.add(jButton33, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, -1, -1));

        jButton34.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 24)); // NOI18N
        jButton34.setText("Quit");
        jButton34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton34ActionPerformed(evt);
            }
        });
        jPanel20.add(jButton34, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 330, -1, -1));

        Congrats5.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 18)); // NOI18N
        Congrats5.setForeground(new java.awt.Color(204, 0, 102));
        Congrats5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel20.add(Congrats5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 500, 60));
        jPanel20.add(S31, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, 90, 80));
        jPanel20.add(S32, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 210, 100, 80));
        jPanel20.add(S33, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 190, 90, 80));

        jLabel93.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 24)); // NOI18N
        jLabel93.setText("Score");
        jPanel20.add(jLabel93, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, 90, 30));

        sc5.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 24)); // NOI18N
        sc5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel20.add(sc5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, 100, 60));

        jLabel96.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 24)); // NOI18N
        jLabel96.setText("LEVEL3");
        jPanel20.add(jLabel96, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        bg.setMaximumSize(new java.awt.Dimension(500, 410));
        bg.setMinimumSize(new java.awt.Dimension(500, 410));
        bg.setPreferredSize(new java.awt.Dimension(500, 410));
        jPanel20.add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 410));

        javax.swing.GroupLayout MGL3scoreLayout = new javax.swing.GroupLayout(MGL3score.getContentPane());
        MGL3score.getContentPane().setLayout(MGL3scoreLayout);
        MGL3scoreLayout.setHorizontalGroup(
            MGL3scoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
            .addGroup(MGL3scoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(MGL3scoreLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        MGL3scoreLayout.setVerticalGroup(
            MGL3scoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 410, Short.MAX_VALUE)
            .addGroup(MGL3scoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(MGL3scoreLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        STDhome.setTitle("SPOT THE DIFFERENCE");
        STDhome.setMinimumSize(new java.awt.Dimension(710, 450));
        STDhome.setResizable(false);
        STDhome.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                STDhomeWindowActivated(evt);
            }
        });
        STDhome.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel16.setBackground(new java.awt.Color(200, 191, 231));
        jPanel16.setMaximumSize(new java.awt.Dimension(710, 450));
        jPanel16.setMinimumSize(new java.awt.Dimension(710, 450));
        jPanel16.setPreferredSize(new java.awt.Dimension(710, 450));
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel58.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 18)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(28, 69, 179));
        jLabel58.setText("    and -1 for every wrongly  spotted difference.");
        jPanel16.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 540, 30));

        jLabel59.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 18)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(28, 69, 179));
        jLabel59.setText("1.Click on the Differences in the second picture .");
        jPanel16.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 570, 30));

        jButton20.setBackground(new java.awt.Color(200, 191, 231));
        jButton20.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 18)); // NOI18N
        jButton20.setText("Lets Start");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });
        jPanel16.add(jButton20, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 250, 190, 60));

        jLabel60.setFont(new java.awt.Font("Gill Sans Ultra Bold", 1, 36)); // NOI18N
        jLabel60.setText("HOW DO I PLAY?");
        jPanel16.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 450, 50));

        jLabel61.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 18)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(28, 69, 179));
        jLabel61.setText("2.You will get +1 for every  correctly spotted difference");
        jPanel16.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 650, 40));

        jLabel62.setBackground(new java.awt.Color(204, 204, 255));
        jLabel62.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projectsample/images/sdh.jpg"))); // NOI18N
        jPanel16.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 210, 200));

        jButton36.setFont(new java.awt.Font("Gill Sans Ultra Bold Condensed", 0, 18)); // NOI18N
        jButton36.setText("Spot The Difference Highscore");
        jButton36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton36ActionPerformed(evt);
            }
        });
        jPanel16.add(jButton36, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 340, 290, 50));

        STDhome.getContentPane().add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 450));

        STDL1.setTitle("LEVEL 1");
        STDL1.setMinimumSize(new java.awt.Dimension(820, 550));
        STDL1.setResizable(false);
        STDL1.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                STDL1WindowActivated(evt);
            }
        });

        jPanel7.setBackground(new java.awt.Color(214, 222, 225));
        jPanel7.setForeground(new java.awt.Color(153, 0, 0));
        jPanel7.setMinimumSize(new java.awt.Dimension(750, 440));
        jPanel7.setPreferredSize(new java.awt.Dimension(750, 440));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projectsample/images/1A.jpg"))); // NOI18N
        jLabel22.setText("jLabel1");
        jLabel22.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 255)));
        jPanel7.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, 290, 210));

        sd1score.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 24)); // NOI18N
        sd1score.setForeground(new java.awt.Color(204, 0, 0));
        sd1score.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(153, 153, 153)));
        jPanel7.add(sd1score, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 440, 130, 50));

        jLabel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel23MouseClicked(evt);
            }
        });
        jPanel7.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 290, 30, 50));

        jLabel24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel24MouseClicked(evt);
            }
        });
        jPanel7.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 260, 70, 30));

        jLabel25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel25MouseClicked(evt);
            }
        });
        jPanel7.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 310, 30, 20));

        jLabel26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel26MouseClicked(evt);
            }
        });
        jPanel7.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 210, 30, 40));

        jLabel27.setBackground(new java.awt.Color(0, 0, 0));
        jLabel27.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 24)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(51, 51, 51));
        jLabel27.setText("<html><body><u>Score:</u></body></html> ");
        jPanel7.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 390, 120, 40));

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projectsample/images/1B.jpg"))); // NOI18N
        jLabel28.setText("jLabel2");
        jLabel28.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 255)));
        jLabel28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel28MouseClicked(evt);
            }
        });
        jPanel7.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 170, 290, 210));

        jLabel29.setBackground(new java.awt.Color(0, 0, 0));
        jLabel29.setFont(new java.awt.Font("Gill Sans Ultra Bold", 1, 48)); // NOI18N
        jLabel29.setText("<html><body><u >Level - 1</u></body></html>");
        jPanel7.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, 320, 120));

        jLabel32.setBackground(new java.awt.Color(0, 0, 0));
        jLabel32.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 24)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(51, 51, 51));
        jLabel32.setText("<html><body><u>Time:</u></body></html>\n");
        jPanel7.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 390, 120, 40));

        STD1t.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 24)); // NOI18N
        STD1t.setForeground(new java.awt.Color(204, 0, 0));
        STD1t.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(153, 153, 153)));
        jPanel7.add(STD1t, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 440, 120, 50));

        jLabel95.setBackground(new java.awt.Color(214, 222, 225));
        jLabel95.setForeground(new java.awt.Color(204, 0, 0));
        jLabel95.setMaximumSize(new java.awt.Dimension(820, 550));
        jLabel95.setMinimumSize(new java.awt.Dimension(820, 550));
        jLabel95.setPreferredSize(new java.awt.Dimension(820, 550));
        jPanel7.add(jLabel95, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 550));

        javax.swing.GroupLayout STDL1Layout = new javax.swing.GroupLayout(STDL1.getContentPane());
        STDL1.getContentPane().setLayout(STDL1Layout);
        STDL1Layout.setHorizontalGroup(
            STDL1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, STDL1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 820, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        STDL1Layout.setVerticalGroup(
            STDL1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, STDL1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        STDL1score.setTitle("SCORE");
        STDL1score.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                STDL1scoreWindowActivated(evt);
            }
        });
        STDL1score.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel11.setBackground(new java.awt.Color(204, 255, 255));
        jPanel11.setMaximumSize(new java.awt.Dimension(500, 410));
        jPanel11.setMinimumSize(new java.awt.Dimension(500, 410));
        jPanel11.setPreferredSize(new java.awt.Dimension(500, 410));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton21.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 24)); // NOI18N
        jButton21.setText("Next Level");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });
        jPanel11.add(jButton21, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 310, 210, 50));

        jButton22.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 24)); // NOI18N
        jButton22.setText("Back");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });
        jPanel11.add(jButton22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, -1, -1));

        jButton23.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 24)); // NOI18N
        jButton23.setText("Quit");
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });
        jPanel11.add(jButton23, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 330, -1, -1));

        Congrats2.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 18)); // NOI18N
        Congrats2.setForeground(new java.awt.Color(255, 0, 102));
        jPanel11.add(Congrats2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 500, 60));
        jPanel11.add(Sl4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 220, 90, 80));
        jPanel11.add(Sl5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 190, 100, 80));
        jPanel11.add(Sl6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 90, 80));

        jLabel30.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 24)); // NOI18N
        jLabel30.setText("Score");
        jPanel11.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, 90, 30));

        sc1.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 24)); // NOI18N
        sc1.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel11.add(sc1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 140, 70, 50));

        jLabel31.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 24)); // NOI18N
        jLabel31.setText("LEVEL1");
        jPanel11.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 130, 50));

        bg1.setMaximumSize(new java.awt.Dimension(500, 410));
        bg1.setMinimumSize(new java.awt.Dimension(500, 410));
        bg1.setPreferredSize(new java.awt.Dimension(500, 410));
        jPanel11.add(bg1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 410));

        STDL1score.getContentPane().add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 410));

        STDL2.setTitle("LEVEL 2");
        STDL2.setMinimumSize(new java.awt.Dimension(722, 576));
        STDL2.setResizable(false);
        STDL2.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                STDL2WindowActivated(evt);
            }
        });

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setMaximumSize(new java.awt.Dimension(722, 576));
        jPanel12.setMinimumSize(new java.awt.Dimension(722, 576));
        jPanel12.setPreferredSize(new java.awt.Dimension(722, 576));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projectsample/images/2A.jpg"))); // NOI18N
        jLabel33.setText("jLabel33");
        jPanel12.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 260, 330));

        jLabel35.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 36)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(0, 102, 153));
        jLabel35.setText("<html><body><u >Level -2</u></body></html>");
        jPanel12.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 370, 70));

        sd2score.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 36)); // NOI18N
        sd2score.setForeground(new java.awt.Color(0, 102, 153));
        sd2score.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel12.add(sd2score, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 460, 120, 50));

        jLabel36.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 24)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(0, 102, 153));
        jLabel36.setText("Time:");
        jPanel12.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 410, -1, -1));

        STD2t.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 36)); // NOI18N
        STD2t.setForeground(new java.awt.Color(0, 102, 153));
        STD2t.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel12.add(STD2t, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 460, 120, 50));

        jLabel37.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 24)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(0, 102, 153));
        jLabel37.setText("Score:");
        jPanel12.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 410, 120, 40));

        jLabel38.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel38MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel38MouseEntered(evt);
            }
        });
        jPanel12.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 80, 50, 50));

        jLabel39.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel39MouseClicked(evt);
            }
        });
        jPanel12.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 260, 30, 30));

        jLabel40.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel40MouseClicked(evt);
            }
        });
        jPanel12.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 280, 70, 60));

        jLabel41.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel41MouseClicked(evt);
            }
        });
        jPanel12.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 320, 50, 30));

        jLabel42.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel42MouseClicked(evt);
            }
        });
        jPanel12.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 210, 30, 30));

        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projectsample/images/2B.jpg"))); // NOI18N
        jLabel34.setText("jLabel34");
        jLabel34.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel34MouseClicked(evt);
            }
        });
        jPanel12.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 70, 250, -1));

        javax.swing.GroupLayout STDL2Layout = new javax.swing.GroupLayout(STDL2.getContentPane());
        STDL2.getContentPane().setLayout(STDL2Layout);
        STDL2Layout.setHorizontalGroup(
            STDL2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        STDL2Layout.setVerticalGroup(
            STDL2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        STDL2score.setTitle("SCORE");
        STDL2score.setMinimumSize(new java.awt.Dimension(500, 410));
        STDL2score.setResizable(false);
        STDL2score.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                STDL2scoreWindowActivated(evt);
            }
        });

        jPanel13.setBackground(new java.awt.Color(204, 255, 255));
        jPanel13.setMinimumSize(new java.awt.Dimension(500, 410));
        jPanel13.setPreferredSize(new java.awt.Dimension(500, 410));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton24.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 24)); // NOI18N
        jButton24.setText("Next Level");
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });
        jPanel13.add(jButton24, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 300, 230, 50));

        jButton25.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 24)); // NOI18N
        jButton25.setText("Back");
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });
        jPanel13.add(jButton25, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 110, -1));

        jButton26.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 24)); // NOI18N
        jButton26.setText("Quit");
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });
        jPanel13.add(jButton26, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 330, 100, -1));

        Congrats3.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 18)); // NOI18N
        Congrats3.setForeground(new java.awt.Color(204, 0, 102));
        Congrats3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel13.add(Congrats3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 490, 60));
        jPanel13.add(Sl7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 90, 80));
        jPanel13.add(Sl8, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 210, 110, 90));
        jPanel13.add(Sl9, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 190, 90, 80));

        jLabel43.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 24)); // NOI18N
        jLabel43.setText("Score");
        jPanel13.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 90, 40));

        sc3.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 24)); // NOI18N
        sc3.setForeground(new java.awt.Color(204, 0, 102));
        sc3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel13.add(sc3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, 110, 60));

        jLabel44.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 24)); // NOI18N
        jLabel44.setText("LEVEL2");
        jPanel13.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 110, 40));

        bg4.setMaximumSize(new java.awt.Dimension(500, 410));
        bg4.setMinimumSize(new java.awt.Dimension(500, 410));
        bg4.setPreferredSize(new java.awt.Dimension(500, 410));
        jPanel13.add(bg4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 410));

        javax.swing.GroupLayout STDL2scoreLayout = new javax.swing.GroupLayout(STDL2score.getContentPane());
        STDL2score.getContentPane().setLayout(STDL2scoreLayout);
        STDL2scoreLayout.setHorizontalGroup(
            STDL2scoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
            .addGroup(STDL2scoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(STDL2scoreLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        STDL2scoreLayout.setVerticalGroup(
            STDL2scoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 410, Short.MAX_VALUE)
            .addGroup(STDL2scoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(STDL2scoreLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        STDL3.setTitle("LEVEL 3");
        STDL3.setMinimumSize(new java.awt.Dimension(860, 610));
        STDL3.setResizable(false);
        STDL3.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                STDL3WindowActivated(evt);
            }
        });

        jPanel14.setBackground(new java.awt.Color(0, 102, 153));
        jPanel14.setMaximumSize(new java.awt.Dimension(860, 610));
        jPanel14.setMinimumSize(new java.awt.Dimension(860, 610));
        jPanel14.setPreferredSize(new java.awt.Dimension(860, 610));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projectsample/images/3A.jpg"))); // NOI18N
        jLabel45.setText("jLabel45");
        jLabel45.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel14.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 400, 250));

        sd3score.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 24)); // NOI18N
        sd3score.setForeground(new java.awt.Color(255, 236, 124));
        sd3score.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel14.add(sd3score, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 440, 120, 50));

        jLabel47.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 24)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(254, 228, 116));
        jLabel47.setText("Time:");
        jPanel14.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 410, -1, -1));

        STD3t.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 24)); // NOI18N
        STD3t.setForeground(new java.awt.Color(255, 236, 124));
        STD3t.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel14.add(STD3t, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 440, 120, 50));

        jLabel77.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel77MouseClicked(evt);
            }
        });
        jPanel14.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 330, 50, 30));

        jLabel48.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 24)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(254, 228, 116));
        jLabel48.setText("Score:");
        jPanel14.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 410, 110, 30));

        jLabel49.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 48)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(254, 228, 116));
        jLabel49.setText("Level - 3");
        jPanel14.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, 280, 100));

        jLabel52.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel52MouseClicked(evt);
            }
        });
        jPanel14.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 240, 60, 30));

        jLabel53.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel53MouseClicked(evt);
            }
        });
        jPanel14.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 280, 60, 30));

        jLabel54.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel54MouseClicked(evt);
            }
        });
        jPanel14.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 180, 60, 30));

        jLabel55.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel55MouseClicked(evt);
            }
        });
        jPanel14.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 310, 40, 30));

        jLabel56.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel56MouseClicked(evt);
            }
        });
        jPanel14.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 350, 50, 30));

        jLabel57.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel57MouseClicked(evt);
            }
        });
        jPanel14.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 280, 30, 30));

        jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projectsample/images/3B.jpg"))); // NOI18N
        jLabel46.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jLabel46.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel46MouseClicked(evt);
            }
        });
        jPanel14.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 130, 400, 250));

        javax.swing.GroupLayout STDL3Layout = new javax.swing.GroupLayout(STDL3.getContentPane());
        STDL3.getContentPane().setLayout(STDL3Layout);
        STDL3Layout.setHorizontalGroup(
            STDL3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        STDL3Layout.setVerticalGroup(
            STDL3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        STDL3score.setTitle("SCORE");
        STDL3score.setMinimumSize(new java.awt.Dimension(500, 410));
        STDL3score.setResizable(false);
        STDL3score.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                STDL3scoreWindowActivated(evt);
            }
        });

        jPanel15.setBackground(new java.awt.Color(204, 255, 255));
        jPanel15.setMaximumSize(new java.awt.Dimension(500, 410));
        jPanel15.setMinimumSize(new java.awt.Dimension(500, 410));
        jPanel15.setPreferredSize(new java.awt.Dimension(500, 410));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton27.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 24)); // NOI18N
        jButton27.setText("Finish");
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });
        jPanel15.add(jButton27, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 290, 170, 50));

        jButton28.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 24)); // NOI18N
        jButton28.setText("Back");
        jPanel15.add(jButton28, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, -1, -1));

        jButton29.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 24)); // NOI18N
        jButton29.setText("Quit");
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton29ActionPerformed(evt);
            }
        });
        jPanel15.add(jButton29, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 320, -1, -1));

        Congrats4.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 18)); // NOI18N
        Congrats4.setForeground(new java.awt.Color(204, 0, 102));
        Congrats4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel15.add(Congrats4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 500, 60));
        jPanel15.add(Sl10, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, 90, 80));
        jPanel15.add(Sl11, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 200, 100, 80));
        jPanel15.add(Sl12, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 160, 90, 80));

        jLabel50.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 24)); // NOI18N
        jLabel50.setText("Score");
        jPanel15.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, 90, 30));

        sc4.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 24)); // NOI18N
        sc4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel15.add(sc4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, 100, 60));

        jLabel51.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 24)); // NOI18N
        jLabel51.setText("LEVEL3");
        jPanel15.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        bg5.setMaximumSize(new java.awt.Dimension(500, 410));
        bg5.setMinimumSize(new java.awt.Dimension(500, 410));
        bg5.setPreferredSize(new java.awt.Dimension(500, 410));
        jPanel15.add(bg5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 410));

        javax.swing.GroupLayout STDL3scoreLayout = new javax.swing.GroupLayout(STDL3score.getContentPane());
        STDL3score.getContentPane().setLayout(STDL3scoreLayout);
        STDL3scoreLayout.setHorizontalGroup(
            STDL3scoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
            .addGroup(STDL3scoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(STDL3scoreLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        STDL3scoreLayout.setVerticalGroup(
            STDL3scoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 410, Short.MAX_VALUE)
            .addGroup(STDL3scoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(STDL3scoreLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        QuizHome.setTitle("QUIZ");
        QuizHome.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                QuizHomeWindowActivated(evt);
            }
        });
        QuizHome.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));
        jPanel17.setMaximumSize(new java.awt.Dimension(710, 440));
        jPanel17.setMinimumSize(new java.awt.Dimension(710, 440));
        jPanel17.setPreferredSize(new java.awt.Dimension(710, 440));
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel69.setFont(new java.awt.Font("Gill Sans Ultra Bold", 1, 18)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(51, 74, 204));
        jLabel69.setText("Choose the correct answer from the given options.");
        jPanel17.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 660, 30));

        jLabel70.setFont(new java.awt.Font("Gill Sans Ultra Bold", 1, 36)); // NOI18N
        jLabel70.setText("HOW DO I PLAY?");
        jPanel17.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 450, 50));

        jButton30.setBackground(new java.awt.Color(51, 74, 204));
        jButton30.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 24)); // NOI18N
        jButton30.setText("Lets play");
        jButton30.setOpaque(false);
        jButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton30ActionPerformed(evt);
            }
        });
        jPanel17.add(jButton30, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 230, 180, 70));

        jLabel72.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projectsample/images/jjjj.jpg"))); // NOI18N
        jPanel17.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 230, 210));

        jLabel71.setFont(new java.awt.Font("Gill Sans Ultra Bold", 1, 18)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(51, 74, 204));
        jLabel71.setText("marking!");
        jPanel17.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 670, 40));

        jLabel73.setFont(new java.awt.Font("Gill Sans Ultra Bold", 1, 18)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(51, 74, 204));
        jLabel73.setText("Each correct answer gives a +10 and no negative ");
        jPanel17.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 670, 40));

        QuizHome.getContentPane().add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 440));

        Quiz.setTitle("QUIZ");
        Quiz.setMaximumSize(new java.awt.Dimension(1000, 490));
        Quiz.setMinimumSize(new java.awt.Dimension(1000, 490));
        Quiz.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                QuizWindowActivated(evt);
            }
        });
        Quiz.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        qu1.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 24)); // NOI18N
        qu1.setForeground(new java.awt.Color(254, 228, 116));
        qu1.setText("Q1. The minions say the word ");
        Quiz.getContentPane().add(qu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 22, 540, 40));

        qu2.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 24)); // NOI18N
        qu2.setForeground(new java.awt.Color(254, 228, 116));
        qu2.setText("'Gelato', but what does ");
        Quiz.getContentPane().add(qu2, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 68, 510, 40));

        qu3.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 24)); // NOI18N
        qu3.setForeground(new java.awt.Color(254, 228, 116));
        qu3.setText("this mean??");
        Quiz.getContentPane().add(qu3, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 114, 510, 40));

        buttonGroup1.add(B);
        B.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 24)); // NOI18N
        B.setText("Latte");
        B.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        B.setOpaque(false);
        Quiz.getContentPane().add(B, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 470, 40));

        buttonGroup1.add(C);
        C.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 24)); // NOI18N
        C.setText("Ice-Cream");
        C.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        C.setOpaque(false);
        C.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CActionPerformed(evt);
            }
        });
        Quiz.getContentPane().add(C, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 470, 40));

        buttonGroup1.add(D);
        D.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 24)); // NOI18N
        D.setText("Jelly");
        D.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        D.setOpaque(false);
        D.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DActionPerformed(evt);
            }
        });
        Quiz.getContentPane().add(D, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 470, 40));

        buttonGroup1.add(A);
        A.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 24)); // NOI18N
        A.setText("Ham");
        A.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        A.setOpaque(false);
        A.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AActionPerformed(evt);
            }
        });
        Quiz.getContentPane().add(A, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 470, 40));

        jButton2.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 36)); // NOI18N
        jButton2.setForeground(new java.awt.Color(60, 88, 135));
        jButton2.setText("Next");
        jButton2.setOpaque(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        Quiz.getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 40, 160, 60));

        scd.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 36)); // NOI18N
        scd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Quiz.getContentPane().add(scd, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 80, 160, 80));

        jLabel81.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 36)); // NOI18N
        jLabel81.setForeground(new java.awt.Color(60, 88, 135));
        jLabel81.setText("Score");
        Quiz.getContentPane().add(jLabel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 20, 160, 40));
        Quiz.getContentPane().add(hey, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 1000, 490));

        QuizScore.setTitle("SCORE");
        QuizScore.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                QuizScoreWindowActivated(evt);
            }
        });

        jPanel21.setBackground(new java.awt.Color(204, 255, 255));
        jPanel21.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton39.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 24)); // NOI18N
        jButton39.setText("Finish");
        jButton39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton39ActionPerformed(evt);
            }
        });
        jPanel21.add(jButton39, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 290, 170, 50));

        jButton40.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 24)); // NOI18N
        jButton40.setText("Back");
        jButton40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton40ActionPerformed(evt);
            }
        });
        jPanel21.add(jButton40, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, -1, -1));

        jButton41.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 24)); // NOI18N
        jButton41.setText("Quit");
        jButton41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton41ActionPerformed(evt);
            }
        });
        jPanel21.add(jButton41, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 320, -1, -1));

        Congrats6.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 24)); // NOI18N
        Congrats6.setForeground(new java.awt.Color(204, 0, 102));
        Congrats6.setText("Congrats!");
        jPanel21.add(Congrats6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 500, 60));
        jPanel21.add(Q1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, 90, 80));
        jPanel21.add(Q2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 200, 100, 80));
        jPanel21.add(Q3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 160, 90, 80));

        quizs.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 36)); // NOI18N
        jPanel21.add(quizs, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 130, 60, 50));

        jLabel78.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 24)); // NOI18N
        jLabel78.setText("Score");
        jPanel21.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 90, 40));

        lm.setMaximumSize(new java.awt.Dimension(500, 410));
        lm.setMinimumSize(new java.awt.Dimension(500, 410));
        lm.setPreferredSize(new java.awt.Dimension(500, 410));
        jPanel21.add(lm, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 410));

        javax.swing.GroupLayout QuizScoreLayout = new javax.swing.GroupLayout(QuizScore.getContentPane());
        QuizScore.getContentPane().setLayout(QuizScoreLayout);
        QuizScoreLayout.setHorizontalGroup(
            QuizScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
            .addGroup(QuizScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(QuizScoreLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        QuizScoreLayout.setVerticalGroup(
            QuizScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 410, Short.MAX_VALUE)
            .addGroup(QuizScoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(QuizScoreLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jFrame1.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                jFrame1WindowActivated(evt);
            }
        });

        jPanel23.setBackground(new java.awt.Color(255, 255, 255));
        jPanel23.setMaximumSize(new java.awt.Dimension(500, 410));
        jPanel23.setName(""); // NOI18N
        jPanel23.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        congrats555.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 18)); // NOI18N
        congrats555.setForeground(new java.awt.Color(204, 0, 102));
        jPanel23.add(congrats555, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 500, 70));

        jButton37.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 24)); // NOI18N
        jButton37.setText("Next Level");
        jButton37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton37ActionPerformed(evt);
            }
        });
        jPanel23.add(jButton37, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 310, 210, 50));

        jButton42.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 24)); // NOI18N
        jButton42.setText("Back");
        jButton42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton42ActionPerformed(evt);
            }
        });
        jPanel23.add(jButton42, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, -1, -1));

        jButton43.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 24)); // NOI18N
        jButton43.setText("Quit");
        jButton43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton43ActionPerformed(evt);
            }
        });
        jPanel23.add(jButton43, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 340, -1, -1));
        jPanel23.add(Sl222, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 220, 90, 80));
        jPanel23.add(Sl3333, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 180, 110, 90));
        jPanel23.add(Sl1111, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 90, 80));

        jLabel68.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 24)); // NOI18N
        jLabel68.setText("Score");
        jPanel23.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, 90, 30));

        scc.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 24)); // NOI18N
        scc.setForeground(new java.awt.Color(204, 0, 102));
        scc.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel23.add(scc, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 140, 70, 50));

        jLabel75.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 24)); // NOI18N
        jLabel75.setText("LEVEL1");
        jPanel23.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        bg9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bg9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projectsample/images/confetti.gif"))); // NOI18N
        bg9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bg9.setMaximumSize(new java.awt.Dimension(500, 410));
        bg9.setMinimumSize(new java.awt.Dimension(500, 410));
        bg9.setPreferredSize(new java.awt.Dimension(500, 410));
        jPanel23.add(bg9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 410));

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
            .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jFrame1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 410, Short.MAX_VALUE)
            .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jFrame1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jTextArea2.setText("1-6\t2-14\t3-16\n4-11\t5-7\t8-12\n9-17\t10-19   13-20\n18-15");
        jScrollPane2.setViewportView(jTextArea2);

        setTitle("HOMEPAGE");
        setBackground(new java.awt.Color(255, 255, 255));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projectsample/images/Untitled.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, -1));

        jButton1.setBackground(new java.awt.Color(255, 247, 101));
        jButton1.setFont(new java.awt.Font("Gill Sans Ultra Bold", 1, 36)); // NOI18N
        jButton1.setForeground(new java.awt.Color(102, 102, 255));
        jButton1.setText("Let's Play...!!!!");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(215, 385, 442, 59));

        jButton4.setBackground(new java.awt.Color(255, 247, 101));
        jButton4.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(102, 102, 255));
        jButton4.setText("About");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, 110, 40));

        jButton10.setBackground(new java.awt.Color(255, 247, 101));
        jButton10.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 14)); // NOI18N
        jButton10.setForeground(new java.awt.Color(102, 102, 255));
        jButton10.setText("The Song");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 490, 190, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        login.setVisible(true);
// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        about.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
hey.setIcon(new ImageIcon("C:\\memorygame\\quiz.jpg"));
hi.setIcon(new ImageIcon("C:\\memorygame\\gamehome.jpg"));
bg.setIcon(new ImageIcon("C:\\memorygame\\confetti.gif"));
bg1.setIcon(new ImageIcon("C:\\memorygame\\confetti.gif"));
bg2.setIcon(new ImageIcon("C:\\memorygame\\confetti.gif"));
bg3.setIcon(new ImageIcon("C:\\memorygame\\confetti.gif"));
bg4.setIcon(new ImageIcon("C:\\memorygame\\confetti.gif"));
bg5.setIcon(new ImageIcon("C:\\memorygame\\confetti.gif"));
lm.setIcon(new ImageIcon("C:\\memorygame\\confetti.gif"));
bg7.setIcon(new ImageIcon("C:\\memorygame\\confetti.gif"));
bg8.setIcon(new ImageIcon("C:\\memorygame\\confetti.gif"));
g1.setIcon(new ImageIcon("C:\\memorygame\\mg1.jpg"));
g2.setIcon(new ImageIcon("C:\\memorygame\\mg2.jpg"));
g3.setIcon(new ImageIcon("C:\\memorygame\\mg3.jpg"));
        
        AudioPlayer.player.start(as1);
    
        
              // TODO add your handling code here:
    }//GEN-LAST:event_formWindowActivated

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        AudioPlayer.player.stop(as1);
        String uname = l_uname.getText();
        String pass = l_pass.getText();

        try {
            Class.forName("java.sql.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/12thbproject", "root", "1234");
            st = con.createStatement();
            String sql = "select * from login where uname='" + uname + "' && pass='" + pass + "';";
            ResultSet rs = st.executeQuery(sql);
            rs.first();
            nickname = rs.getString(4);
            mg1=rs.getInt(5);
            mg2=rs.getInt(6);
            mg3=rs.getInt(7);
            st1=rs.getInt(8);
            st2=rs.getInt(9);
            st3=rs.getInt(10);
            q1=rs.getInt(11);
            
            System.out.println(nickname);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        loading.setVisible(true);
        login.setVisible(false);
// TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void s_nnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s_nnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s_nnameActionPerformed

    private void s_dobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s_dobActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s_dobActionPerformed

    private void s_unameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s_unameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s_unameActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        String uname = s_uname.getText();
        String pass = s_pass.getText();
        String dob = s_dob.getText();
        String nickname = s_nname.getText();

        try {
            Class.forName("java.sql.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/12thbproject", "root", "1234");
            st = con.createStatement();
            String sql = "insert into login values('" + uname + "','" + pass + "','" + dob + "','" + nickname + "',0,0,0,0,0,0,0);";
            System.out.println(sql);
            st.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            
        }
        signup.setVisible(false);       // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void loginWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_loginWindowActivated
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_loginWindowActivated

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        main obj = new main();
        obj.setVisible(true);
        login.setVisible(false);// TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        about.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        signup.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void loadingWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_loadingWindowActivated
        //t.start(); 
        l.start();

// TODO add your handling code here:
    }//GEN-LAST:event_loadingWindowActivated

    private void signupWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_signupWindowActivated
        // TODO add your handling code here:
    }//GEN-LAST:event_signupWindowActivated

    private void s_dobFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_s_dobFocusGained
        s_dob.setText(" ");        // TODO add your handling code here:
    }//GEN-LAST:event_s_dobFocusGained

    private void gamehomeWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_gamehomeWindowActivated
AudioPlayer.player.start(as2);        
hello1.setText("Hey " + nickname.toUpperCase()+",");// TODO add your handling code here:
    }//GEN-LAST:event_gamehomeWindowActivated

    private void L1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L1MouseClicked
        ++count;
        L1.setIcon(new ImageIcon("C:\\memorygame\\level1\\1.jpg"));
        if (count == 2 && l1 == true) {
            back2basic();
        } else if (count == 2 && l3 == true) {

            T1B.start();

        } else if (count == 2 && l3 != true) {
            T1A.start();
        } else if (count >= 3) {
            back2basic();
        } else if (count == 1) {
            System.out.println(count);
            l1 = true;
        }
    }//GEN-LAST:event_L1MouseClicked

    private void L2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L2MouseClicked
        count++;
        L2.setIcon(new ImageIcon("C:\\memorygame\\level1\\2.jpg"));
        if (count == 2 && l2 == true) {
            back2basic();
        } else if (count == 2 && l6 == true) {
            T2B.start();

        } else if (count == 2 && l6 != true) {
            T2A.start();
        } else if (count >= 3) {
            back2basic();
        } else if (count == 1) {
            System.out.println(count);
            l2 = true;
        }
    }//GEN-LAST:event_L2MouseClicked

    private void L3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L3MouseClicked
        count++;
        L3.setIcon(new ImageIcon("C:\\memorygame\\level1\\1.jpg"));

        if (count == 2 && l3 == true) {
            back2basic();
        } else if (count == 2 && l1 == true) {
            T1B.start();

        } else if (count == 2 && l1 != true && l3 != true) {
            T3A.start();
        } else if (count >= 3) {
            back2basic();
        } else if (count == 1) {
            System.out.println(count);
            l3 = true;
        }
    }//GEN-LAST:event_L3MouseClicked

    private void L3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_L3KeyPressed

    }//GEN-LAST:event_L3KeyPressed

    private void L4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L4MouseClicked
        count++;
        L4.setIcon(new ImageIcon("C:\\memorygame\\level1\\3.jpg"));
        if (count == 2 && l4 == true)//L4 clicked twice
        {
            back2basic();
        } else if (count == 2 && l5 == true)//both L4 and L5 clicked=score
        {
            T4B.start();

        } else if (count == 2 && l5 != true)//wrong try
        {
            T4A.start();
        } else if (count >= 3) {
            back2basic();
        } else//first attemp
        if (count == 1) {
            l4 = true;
        }
    }//GEN-LAST:event_L4MouseClicked

    private void L5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L5MouseClicked
        count++;
        L5.setIcon(new ImageIcon("C:\\memorygame\\level1\\3.jpg"));
        if (count == 2 && l5 == true) {

            back2basic();
        } else if (count == 2 && l4 == true) {
            T4B.start();

        } else if (count == 2 && l4 != true) {
            T5A.start();
        } else if (count >= 3) {
            back2basic();
        } else if (count == 1) {
            l5 = true;
        }        // TODO add your handling code here:
    }//GEN-LAST:event_L5MouseClicked

    private void L6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L6MouseClicked
        count++;
        L6.setIcon(new ImageIcon("C:\\memorygame\\level1\\2.jpg"));
        if (count == 2 && l6 == true) {
            back2basic();
        } else if (count == 2 && l2 == true) {
            T2B.start();

        } else if (count == 2 && l2 != true) {
            T6A.start();
        } else if (count >= 3) {
            back2basic();

        } else if (count == 1) {
            l6 = true;
        }
    }//GEN-LAST:event_L6MouseClicked

    private void jPanel6ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel6ComponentShown
        L21.setIcon(new ImageIcon("C:\\memorygame\\yellow.jpg"));
    }//GEN-LAST:event_jPanel6ComponentShown

    private void L21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L21MouseClicked
        count2++;
        L21.setIcon(new ImageIcon("C:\\memorygame\\level2\\1.jpg"));
        if (count2 == 2 && l21 == true) {
            back2basic2();
        } else if (count2 == 2 && l27 == true) {
            T21B.start();

        } else if (count2 == 2 && l27 != true) {
            T21A.start();
        } else if (count2 >= 3) {
            back2basic2();

        } else if (count2 == 1) {
            l21 = true;
        }
    }//GEN-LAST:event_L21MouseClicked

    private void MGL2WindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_MGL2WindowActivated
AudioPlayer.player.start(as3);
back2basic2();
        StopWatch2.start();
        System.out.println("actionperformed");        m = 0;
        s = 0;        // TODO add your handling code here:
    }//GEN-LAST:event_MGL2WindowActivated

    private void L22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L22MouseClicked
        count2++;
        L22.setIcon(new ImageIcon("C:\\memorygame\\level2\\2.jpg"));
        if (count2 == 2 && l22 == true) {
            back2basic2();
        } else if (count2 == 2 && l212 == true) {
            T22B.start();

        } else if (count2 == 2 && l212 != true) {
            T22A.start();
        } else if (count2 >= 3) {
            back2basic2();

        } else if (count2 == 1) {
            l22 = true;
        }
    }//GEN-LAST:event_L22MouseClicked

    private void L23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L23MouseClicked
        count2++;
        L23.setIcon(new ImageIcon("C:\\memorygame\\level2\\3.jpg"));
        if (count2 == 2 && l23 == true) {
            back2basic2();
        } else if (count2 == 2 && l25 == true) {
            T23B.start();

        } else if (count2 == 2 && l25 != true) {
            T23A.start();
        } else if (count2 >= 3) {
            back2basic2();

        } else if (count2 == 1) {
            l23 = true;
        }
    }//GEN-LAST:event_L23MouseClicked

    private void L24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L24MouseClicked
        count2++;
        L24.setIcon(new ImageIcon("C:\\memorygame\\level2\\4.jpg"));
        if (count2 == 2 && l24 == true) {
            back2basic2();
        } else if (count2 == 2 && l28 == true) {
            T24B.start();
        } else if (count2 == 2 && l28 != true) {
            T24A.start();
        } else if (count2 >= 3) {
            back2basic2();

        } else if (count2 == 1) {
            l24 = true;
        }
    }//GEN-LAST:event_L24MouseClicked

    private void L25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L25MouseClicked
        count2++;
        L25.setIcon(new ImageIcon("C:\\memorygame\\level2\\3.jpg"));
        if (count2 == 2 && l25 == true) {
            back2basic2();
        } else if (count2 == 2 && l23 == true) {
            T23B.start();

        } else if (count2 == 2 && l23 != true) {
            T25A.start();
        } else if (count2 >= 3) {
            back2basic2();

        } else if (count2 == 1) {
            l25 = true;
        }
    }//GEN-LAST:event_L25MouseClicked

    private void L26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L26MouseClicked
        count2++;
        L26.setIcon(new ImageIcon("C:\\memorygame\\level2\\6.jpg"));
        if (count2 == 2 && l26 == true) {
            back2basic2();
        } else if (count2 == 2 && l211 == true) {
            T26B.start();

        } else if (count2 == 2 && l211 != true) {
            T26A.start();
        } else if (count2 >= 3) {
            back2basic2();

        } else if (count2 == 1) {
            l26 = true;
        }
    }//GEN-LAST:event_L26MouseClicked

    private void L27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L27MouseClicked
        count2++;
        L27.setIcon(new ImageIcon("C:\\memorygame\\level2\\1.jpg"));
        if (count2 == 2 && l27 == true) {
            back2basic2();
        } else if (count2 == 2 && l21 == true) {
            T21B.start();

        } else if (count2 == 2 && l21 != true) {
            T27A.start();
        } else if (count2 >= 3) {
            back2basic2();

        } else if (count2 == 1) {
            l27 = true;
        }
    }//GEN-LAST:event_L27MouseClicked

    private void L28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L28MouseClicked
        count2++;
        L28.setIcon(new ImageIcon("C:\\memorygame\\level2\\4.jpg"));
        if (count2 == 2 && l28 == true) {
            back2basic2();
        } else if (count2 == 2 && l24 == true) {
            T24B.start();

        } else if (count2 == 2 && l24 != true) {
            T28A.start();
        } else if (count2 >= 3) {
            back2basic2();

        } else if (count2 == 1) {
            l28 = true;
        }
    }//GEN-LAST:event_L28MouseClicked

    private void L29MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L29MouseClicked
        count2++;
        L29.setIcon(new ImageIcon("C:\\memorygame\\level2\\5.jpg"));
        if (count2 == 2 && l29 == true) {
            back2basic2();
        } else if (count2 == 2 && l210 == true) {
            T29B.start();

        } else if (count2 == 2 && l210 != true) {
            T29A.start();
        } else if (count2 >= 3) {
            back2basic2();

        } else if (count2 == 1) {
            l29 = true;
        }
    }//GEN-LAST:event_L29MouseClicked

    private void L210MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L210MouseClicked
        count2++;
        L210.setIcon(new ImageIcon("C:\\memorygame\\level2\\5.jpg"));
        if (count2 == 2 && l210 == true) {
            back2basic2();
        } else if (count2 == 2 && l29 == true) {
            T29B.start();
        } else if (count2 == 2 && l29 != true) {
            T210A.start();
        } else if (count2 >= 3) {
            back2basic2();

        } else if (count2 == 1) {
            l210 = true;
        }
    }//GEN-LAST:event_L210MouseClicked

    private void L211MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L211MouseClicked
        count2++;
        L211.setIcon(new ImageIcon("C:\\memorygame\\level2\\6.jpg"));
        if (count2 == 2 && l211 == true) {
            back2basic2();
        } else if (count2 == 2 && l26 == true) {
            T26B.start();
        } else if (count2 == 2 && l26 != true) {
            T211A.start();
        } else if (count2 >= 3) {
            back2basic2();

        } else if (count2 == 1) {
            l211 = true;
        }
    }//GEN-LAST:event_L211MouseClicked

    private void L212MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L212MouseClicked
        count2++;
        L212.setIcon(new ImageIcon("C:\\memorygame\\level2\\2.jpg"));
        if (count2 == 2 && l212 == true) {
            back2basic2();
        } else if (count2 == 2 && l22 == true) {
            T22B.start();

        } else if (count2 == 2 && l22 != true) {
            T212A.start();
        } else if (count2 >= 3) {
            back2basic2();

        } else if (count2 == 1) {
            l212 = true;
        }
    }//GEN-LAST:event_L212MouseClicked

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
MGL3.setVisible(true);
MGL2score.setVisible(false);// TODO add your handling code here:
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
AudioPlayer.player.stop(as1);
MGL1.setVisible(true);
       gamehome.setVisible(false);// TODO add your handling code here:
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
AudioPlayer.player.stop(as1);
STDL1.setVisible(true);
        STD1.start();
        STDhome.setVisible(false);    // TODO add your handling code here:
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jLabel23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseClicked
        if (STD12 == false) {
            STD1score++;
            sd1score.setText(STD1score + "");
            STD12 = true;
        }     // TODO add your handling code here:
    }//GEN-LAST:event_jLabel23MouseClicked

    private void jLabel24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseClicked
        if (STD11 == false) {
            STD1score++;
            sd1score.setText(STD1score + "");
            STD11 = true;
        }    // TODO add your handling code here:
    }//GEN-LAST:event_jLabel24MouseClicked

    private void jLabel25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel25MouseClicked
        if (STD13 == false) {
            STD1score++;
            sd1score.setText(STD1score + "");
            STD13 = true;
        }  // TODO add your handling code here:
    }//GEN-LAST:event_jLabel25MouseClicked

    private void jLabel26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel26MouseClicked
        if (STD14 == false) {
            STD1score++;
            sd1score.setText(STD1score + "");
            STD14 = true;
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel26MouseClicked

    private void jLabel28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseClicked
        STD1score--;
        sd1score.setText(STD1score + "");
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel28MouseClicked

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        STDL2.setVisible(true);
        STD2.start();
        STDL1score.setVisible(false);
// TODO add your handling code here:
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        STDL3.setVisible(true);
        STD3.start();
        STDL2score.setVisible(false);    // TODO add your handling code here:
    }//GEN-LAST:event_jButton24ActionPerformed

    private void jLabel38MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel38MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel38MouseEntered

    private void jLabel38MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel38MouseClicked
        if (STD21 == false) {
            STD2score++;
            sd2score.setText(STD2score + "");
            STD21 = true;
        }    // TODO add your handling code here:
    }//GEN-LAST:event_jLabel38MouseClicked

    private void jLabel40MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel40MouseClicked
        if (STD22 == false) {
            STD2score++;
            sd2score.setText(STD2score + "");
            STD22 = true;
        }         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel40MouseClicked

    private void jLabel42MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel42MouseClicked
        if (STD23 == false) {
            STD2score++;
            sd2score.setText(STD2score + "");
            STD23 = true;
        }         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel42MouseClicked

    private void jLabel41MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel41MouseClicked
        if (STD24 == false) {
            STD2score++;
            sd2score.setText(STD2score + "");
            STD24 = true;
        }         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel41MouseClicked

    private void jLabel39MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel39MouseClicked
        if (STD25 == false) {
            STD2score++;
            sd2score.setText(STD2score + "");
            STD25 = true;
        }         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel39MouseClicked

    private void jLabel34MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel34MouseClicked
        STD2score--;
        sd2score.setText(STD2score + ""); // TODO add your handling code here:
    }//GEN-LAST:event_jLabel34MouseClicked

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
gamehome.setVisible(true);
STDL3score.setVisible(false);// TODO add your handling code here:
    }//GEN-LAST:event_jButton27ActionPerformed

    private void jLabel54MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel54MouseClicked
        if (STD31 == false) {
            STD3score++;
            sd3score.setText(STD3score + "");
            STD31 = true;
        }         // TODO add your handling code here:
    }//GEN-LAST:event_jLabel54MouseClicked

    private void jLabel52MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel52MouseClicked
        if (STD32 == false) {
            STD3score++;
            sd3score.setText(STD3score + "");
            STD32 = true;
        }    // TODO add your handling code here:
    }//GEN-LAST:event_jLabel52MouseClicked

    private void jLabel57MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel57MouseClicked
        if (STD33 == false) {
            STD3score++;
            sd3score.setText(STD3score + "");
            STD33 = true;
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel57MouseClicked

    private void jLabel56MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel56MouseClicked
        if (STD34 == false) {
            STD3score++;
            sd3score.setText(STD3score + "");
            STD34 = true;
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel56MouseClicked

    private void jLabel53MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel53MouseClicked
        if (STD35 == false) {
            STD3score++;
            sd3score.setText(STD3score + "");
            STD35 = true;
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel53MouseClicked

    private void jLabel55MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel55MouseClicked
        if (STD36 == false) {
            STD3score++;
            sd3score.setText(STD3score + "");
            STD36 = true;
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel55MouseClicked

    private void jLabel46MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel46MouseClicked
        STD3score--;
        sd3score.setText(STD3score + "");     // TODO add your handling code here:
    }//GEN-LAST:event_jLabel46MouseClicked

    private void MGL2scoreWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_MGL2scoreWindowActivated
 AudioPlayer.player.stop(as3);
  AudioPlayer.player.start(as4);
  int score=Integer.parseInt(sc2.getText());
        if(score>mg2)  {try {
            Class.forName("java.sql.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/12thbproject", "root", "1234");
            st = con.createStatement();
            String sql = "update login set mgs2="+score+" where nickname='"+nickname+"';";
             st.executeUpdate(sql);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        }    // TODO add your handling code here:
    }//GEN-LAST:event_MGL2scoreWindowActivated

    private void STDL1scoreWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_STDL1scoreWindowActivated
  STDL1score.setSize(500,410);
  AudioPlayer.player.stop(as3);
  AudioPlayer.player.start(as4);
int score=Integer.parseInt(sc1.getText());
        if(score>st1)  {try {
            Class.forName("java.sql.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/12thbproject", "root", "1234");
            st = con.createStatement();
            String sql = "update login set stds1="+score+" where nickname='"+nickname+"';";
             st.executeUpdate(sql);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        }        // TODO add your handling code here:
    }//GEN-LAST:event_STDL1scoreWindowActivated

    private void STDL2scoreWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_STDL2scoreWindowActivated
 AudioPlayer.player.stop(as3);
  AudioPlayer.player.start(as4);
  int score=Integer.parseInt(sc3.getText());
        if(score>st2)  {try {
            Class.forName("java.sql.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/12thbproject", "root", "1234");
            st = con.createStatement();
            String sql = "update login set stds2="+score+" where nickname='"+nickname+"';";
             st.executeUpdate(sql);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        }        // TODO add your handling code here:
    }//GEN-LAST:event_STDL2scoreWindowActivated

    private void STDL3scoreWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_STDL3scoreWindowActivated
AudioPlayer.player.stop(as3);
AudioPlayer.player.start(as4);
  int score=Integer.parseInt(sc4.getText());
        if(score>st3)  {try {
            Class.forName("java.sql.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/12thbproject", "root", "1234");
            st = con.createStatement();
            String sql = "update login set stds3="+score+" where nickname='"+nickname+"';";
             st.executeUpdate(sql);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        }        // TODO add your handling code here:
    }//GEN-LAST:event_STDL3scoreWindowActivated

    private void MGL1WindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_MGL1WindowActivated

        AudioPlayer.player.start(as3);
        MGhome.setVisible(false);
        StopWatch.start();
        back2basic();        // TODO add your handling code here:
    }//GEN-LAST:event_MGL1WindowActivated

    private void L31MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L31MouseClicked
 count3++;
        L31.setIcon(new ImageIcon("C:\\memorygame\\level3\\1.jpg"));
        if (count3 == 2 && l31 == true) {
            back2basic3();
        } else if (count3 == 2 && l36 == true) {
            T31B.start();

        } else if (count3 == 2 && l36 != true) {
            T31A.start();
        } else if (count3 >= 3) {
            back2basic3();

        } else if (count3 == 1) {
            l31 = true;
        }
                                    // TODO add your handling code here:
    }//GEN-LAST:event_L31MouseClicked

    private void jButton32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton32ActionPerformed
gamehome.setVisible(true);
MGL3score.setVisible(false);

// TODO add your handling code here:
    }//GEN-LAST:event_jButton32ActionPerformed

    private void L32MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L32MouseClicked
    count3++;
        L32.setIcon(new ImageIcon("C:\\memorygame\\level3\\2.jpg"));
        if (count3 == 2 && l32 == true) {
            back2basic3();
        } else if (count3 == 2 && l314 == true) {
            T32B.start();

        } else if (count3 == 2 && l314 != true) {
            T32A.start();
        } else if (count3 >= 3) {
            back2basic3();

        } else if (count3 == 1) {
            l32 = true;
        }    // TODO add your handling code here:
    }//GEN-LAST:event_L32MouseClicked

    private void L33MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L33MouseClicked
    count3++;
        L33.setIcon(new ImageIcon("C:\\memorygame\\level3\\3.jpg"));
        if (count3 == 2 && l33 == true) {
            back2basic3();
        } else if (count3 == 2 && l316 == true) {
            T33B.start();

        } else if (count3 == 2 && l316 != true) {
            T33A.start();
        } else if (count3 >= 3) {
            back2basic3();

        } else if (count3 == 1) {
            l33 = true;
        }      // TODO add your handling code here:
    }//GEN-LAST:event_L33MouseClicked

    private void L34MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L34MouseClicked
count3++;
        L34.setIcon(new ImageIcon("C:\\memorygame\\level3\\4.jpg"));
        if (count3 == 2 && l34 == true) {
            back2basic3();
        } else if (count3 == 2 && l311 == true) {
            T34B.start();

        } else if (count3 == 2 && l311 != true) {
            T34A.start();
        } else if (count3 >= 3) {
            back2basic3();

        } else if (count3 == 1) {
            l34 = true;
        }          // TODO add your handling code here:
    }//GEN-LAST:event_L34MouseClicked

    private void L35MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L35MouseClicked
count3++;
        L35.setIcon(new ImageIcon("C:\\memorygame\\level3\\5.jpg"));
        if (count3 == 2 && l35 == true) {
            back2basic3();
        } else if (count3 == 2 && l37 == true) {
            T35B.start();

        } else if (count3 == 2 && l37 != true) {
            T35A.start();
        } else if (count3 >= 3) {
            back2basic3();

        } else if (count3 == 1) {
            l35 = true;
        }          // TODO add your handling code here:
    }//GEN-LAST:event_L35MouseClicked

    private void L36MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L36MouseClicked
count3++;
        L36.setIcon(new ImageIcon("C:\\memorygame\\level3\\1.jpg"));
        if (count3 == 2 && l36 == true) {
            back2basic3();
        } else if (count3 == 2 && l31 == true) {
            T31B.start();

        } else if (count3 == 2 && l31 != true) {
            T36A.start();
        } else if (count3 >= 3) {
            back2basic3();

        } else if (count3 == 1) {
            l36 = true;
        }          // TODO add your handling code here:
    }//GEN-LAST:event_L36MouseClicked

    private void L37MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L37MouseClicked
count3++;
        L37.setIcon(new ImageIcon("C:\\memorygame\\level3\\5.jpg"));
        if (count3 == 2 && l37 == true) {
            back2basic3();
        } else if (count3 == 2 && l35 == true) {
            T35B.start();

        } else if (count3 == 2 && l35 != true) {
            T37A.start();
        } else if (count3 >= 3) {
            back2basic3();

        } else if (count3 == 1) {
            l37 = true;
        }          // TODO add your handling code here:
    }//GEN-LAST:event_L37MouseClicked

    private void L38MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L38MouseClicked
count3++;
        L38.setIcon(new ImageIcon("C:\\memorygame\\level3\\6.jpg"));
        if (count3 == 2 && l38 == true) {
            back2basic3();
        } else if (count3 == 2 && l312 == true) {
            T38B.start();

        } else if (count3 == 2 && l312 != true) {
            T38A.start();
        } else if (count3 >= 3) {
            back2basic3();

        } else if (count3 == 1) {
            l38 = true;
        }          // TODO add your handling code here:
    }//GEN-LAST:event_L38MouseClicked

    private void L39MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L39MouseClicked
count3++;
        L39.setIcon(new ImageIcon("C:\\memorygame\\level3\\7.jpg"));
        if (count3 == 2 && l39 == true) {
            back2basic3();
        } else if (count3 == 2 && l317 == true) {
            T39B.start();

        } else if (count3 == 2 && l317 != true) {
            T39A.start();
        } else if (count3 >= 3) {
            back2basic3();

        } else if (count3 == 1) {
            l39 = true;
        }          // TODO add your handling code here:
    }//GEN-LAST:event_L39MouseClicked

    private void L310MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L310MouseClicked
    count3++;
        L310.setIcon(new ImageIcon("C:\\memorygame\\level3\\8.jpg"));
        if (count3 == 2 && l310 == true) {
            back2basic3();
        } else if (count3 == 2 && l319 == true) {
            T310B.start();

        } else if (count3 == 2 && l319 != true) {
            T310A.start();
        } else if (count3 >= 3) {
            back2basic3();

        } else if (count3 == 1) {
            l310 = true;
        }       // TODO add your handling code here:
    }//GEN-LAST:event_L310MouseClicked

    private void L311MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L311MouseClicked
count3++;
        L311.setIcon(new ImageIcon("C:\\memorygame\\level3\\4.jpg"));
        if (count3 == 2 && l311 == true) {
            back2basic3();
        } else if (count3 == 2 && l34 == true) {
            T34B.start();

        } else if (count3 == 2 && l34 != true) {
            T311A.start();
        } else if (count3 >= 3) {
            back2basic3();

        } else if (count3 == 1) {
            l311 = true;
        }           // TODO add your handling code here:
    }//GEN-LAST:event_L311MouseClicked

    private void L312MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L312MouseClicked
count3++;
        L312.setIcon(new ImageIcon("C:\\memorygame\\level3\\6.jpg"));
        if (count3 == 2 && l312 == true) {
            back2basic3();
        } else if (count3 == 2 && l38 == true) {
            T38B.start();

        } else if (count3 == 2 && l38 != true) {
            T312A.start();
        } else if (count3 >= 3) {
            back2basic3();

        } else if (count3 == 1) {
            l312 = true;
        }           // TODO add your handling code here:
    }//GEN-LAST:event_L312MouseClicked

    private void L313MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L313MouseClicked
    count3++;
        L313.setIcon(new ImageIcon("C:\\memorygame\\level3\\9.png"));
        if (count3 == 2 && l313 == true) {
            back2basic3();
        } else if (count3 == 2 && l320 == true) {
            T313B.start();

        } else if (count3 == 2 && l320 != true) {
            T313A.start();
        } else if (count3 >= 3) {
            back2basic3();

        } else if (count3 == 1) {
            l313 = true;
        }            // TODO add your handling code here:
    }//GEN-LAST:event_L313MouseClicked

    private void L314MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L314MouseClicked
count3++;
        L314.setIcon(new ImageIcon("C:\\memorygame\\level3\\2.jpg"));
        if (count3 == 2 && l314 == true) {
            back2basic3();
        } else if (count3 == 2 && l32 == true) {
            T32B.start();

        } else if (count3 == 2 && l32 != true) {
            T314A.start();
        } else if (count3 >= 3) {
            back2basic3();

        } else if (count3 == 1) {
            l314 = true;
        }                // TODO add your handling code here:
    }//GEN-LAST:event_L314MouseClicked

    private void L315MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L315MouseClicked
count3++;
        L315.setIcon(new ImageIcon("C:\\memorygame\\level3\\10.jpg"));
        if (count3 == 2 && l315 == true) {
            back2basic3();
        } else if (count3 == 2 && l318 == true) {
            T318B.start();

        } else if (count3 == 2 && l318 != true) {
            T315A.start();
        } else if (count3 >= 3) {
            back2basic3();

        } else if (count3 == 1) {
            l315 = true;
        }                // TODO add your handling code here:
    }//GEN-LAST:event_L315MouseClicked

    private void L316MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L316MouseClicked
count3++;
        L316.setIcon(new ImageIcon("C:\\memorygame\\level3\\3.jpg"));
        if (count3 == 2 && l316 == true) {
            back2basic3();
        } else if (count3 == 2 && l33 == true) {
            T33B.start();

        } else if (count3 == 2 && l33 != true) {
            T316A.start();
        } else if (count3 >= 3) {
            back2basic3();

        } else if (count3 == 1) {
            l316 = true;
        }                // TODO add your handling code here:
    }//GEN-LAST:event_L316MouseClicked

    private void L317MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L317MouseClicked
count3++;
        L317.setIcon(new ImageIcon("C:\\memorygame\\level3\\7.jpg"));
        if (count3 == 2 && l317 == true) {
            back2basic3();
        } else if (count3 == 2 && l39 == true) {
            T39B.start();

        } else if (count3 == 2 && l39 != true) {
            T317A.start();
        } else if (count3 >= 3) {
            back2basic3();

        } else if (count3 == 1) {
            l317 = true;
        }                // TODO add your handling code here:
    }//GEN-LAST:event_L317MouseClicked

    private void L318MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L318MouseClicked
    count3++;
        L318.setIcon(new ImageIcon("C:\\memorygame\\level3\\10.jpg"));
        if (count3 == 2 && l318 == true) {
            back2basic3();
        } else if (count3 == 2 && l315 == true) {
            T318B.start();

        } else if (count3 == 2 && l315 != true) {
            T318A.start();
        } else if (count3 >= 3) {
            back2basic3();

        } else if (count3 == 1) {
            l318 = true;
        }            // TODO add your handling code here:
    }//GEN-LAST:event_L318MouseClicked

    private void L319MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L319MouseClicked
count3++;
        L319.setIcon(new ImageIcon("C:\\memorygame\\level3\\8.jpg"));
        if (count3 == 2 && l319 == true) {
            back2basic3();
        } else if (count3 == 2 && l310 == true) {
            T310B.start();

        } else if (count3 == 2 && l310 != true) {
            T319A.start();
        } else if (count3 >= 3) {
            back2basic3();

        } else if (count3 == 1) {
            l319 = true;
        }                // TODO add your handling code here:
    }//GEN-LAST:event_L319MouseClicked

    private void L320MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L320MouseClicked
count3++;
        L320.setIcon(new ImageIcon("C:\\memorygame\\level3\\9.png"));
        if (count3 == 2 && l320 == true) {
            back2basic3();
        } else if (count3 == 2 && l313 == true) {
            T313B.start();

        } else if (count3 == 2 && l313 != true) {
            T320A.start();
        } else if (count3 >= 3) {
            back2basic3();

        } else if (count3 == 1) {
            l320 = true;
        }                // TODO add your handling code here:
    }//GEN-LAST:event_L320MouseClicked

    private void MGL3WindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_MGL3WindowActivated
AudioPlayer.player.start(as3);
back2basic3();
StopWatch3.start();// TODO add your handling code here:
    }//GEN-LAST:event_MGL3WindowActivated

    private void jButton31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton31ActionPerformed
        gamehome.setVisible(false);
        QuizHome.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_jButton31ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        STDhome.setVisible(true);
        gamehome.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        MGhome.setVisible(true);
        gamehome.setVisible(false);// TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
AudioPlayer.player.stop(as1);
        String song="c:\\memorygame\\happy.mp4";
        File f=new File(song);
        try {
            Desktop.getDesktop().open(f);
            // TODO add your handling code here:
        } catch (IOException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
Highscore.setSize(830, 420);
        Highscore.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton14ActionPerformed

    private void HighscoreWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_HighscoreWindowActivated
Highscore.setSize(830, 420);
        try {
            Class.forName("java.sql.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/12thbproject", "root", "1234");
            st = con.createStatement();
            String sql = "select uname,nickname,mgs1,mgs2,mgs3,stds1,stds2,stds3,quizs from login ;";
            ResultSet rs = st.executeQuery(sql);
            DefaultTableModel dtm=(DefaultTableModel)jTable1.getModel();
            dtm.setRowCount(0);      
            
            while (rs.next())
            {
            username=rs.getString(1);
            nickname1 = rs.getString(2);
            mg1=rs.getInt(3);
            mg2=rs.getInt(4);
            mg3=rs.getInt(5);
            st1=rs.getInt(6);
            st2=rs.getInt(7);
            st3=rs.getInt(8);
            q1=rs.getInt(9);
            
                Object arr[]={username,nickname1,mg1,mg2,mg3,st1,st2,st3,q1
            };
            dtm.addRow(arr);
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }    // TODO add your handling code here:
    }//GEN-LAST:event_HighscoreWindowActivated

    private void jButton35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton35ActionPerformed
      
        GameHighscore.setVisible(true);
        try {
            Class.forName("java.sql.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/12thbproject", "root", "1234");
            st = con.createStatement();
            String sql = "select uname,nickname,mgs1,mgs2,mgs3 from login ;";
            ResultSet rs = st.executeQuery(sql);
           DefaultTableModel dtm=(DefaultTableModel)t1.getModel();
             dtm.setRowCount(0);      
            System.out.println(username);
            while (rs.next())
            {
            username=rs.getString(1);
            nickname1 = rs.getString(2);
            mg1=rs.getInt(3);
            mg2=rs.getInt(4);
            mg3=rs.getInt(5);
            
                Object arr[]={username,nickname1,mg1,mg2,mg3
            };
            dtm.addRow(arr);
            }
            System.out.println(nickname);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }    // TODO add your handling code here:
    }//GEN-LAST:event_jButton35ActionPerformed

    private void jButton36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton36ActionPerformed
GameHighscore.setVisible(true);    
try {
            Class.forName("java.sql.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/12thbproject", "root", "1234");
            st = con.createStatement();
            String sql = "select uname,nickname,stds1,stds2,stds3 from login ;";
            ResultSet rs = st.executeQuery(sql);
           DefaultTableModel dtm=(DefaultTableModel)t1.getModel();
             dtm.setRowCount(0);      
            System.out.println(username);
            while (rs.next())
            {
            username=rs.getString(1);
            nickname1 = rs.getString(2);
            st1=rs.getInt(3);
            st2=rs.getInt(4);
            st3=rs.getInt(5);
            
                Object arr[]={username,nickname1,st1,st2,st3
            };
            dtm.addRow(arr);
            }
            System.out.println(nickname);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } // TODO add your handling code here:
    }//GEN-LAST:event_jButton36ActionPerformed

    private void jButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton30ActionPerformed
AudioPlayer.player.stop(as1);
Quiz.setVisible(true) ;
QuizHome.setVisible(false);
qno=1;
//QScore.setText(""+quiz_score);
    

    }//GEN-LAST:event_jButton30ActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
gamehome.setVisible(true);
STDL2score.setVisible(false);// TODO add your handling code here:
    }//GEN-LAST:event_jButton25ActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton26ActionPerformed

    private void jButton39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton39ActionPerformed
gamehome.setVisible(true);
QuizScore.setVisible(false);
// TODO add your handling code here:
    }//GEN-LAST:event_jButton39ActionPerformed

    private void jButton41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton41ActionPerformed
QuizScore.setVisible(false);   // TODO add your handling code here:
    }//GEN-LAST:event_jButton41ActionPerformed

    private void jButton40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton40ActionPerformed
QuizHome.setVisible(true);
QuizScore.setVisible(false);// TODO add your handling code here:
    }//GEN-LAST:event_jButton40ActionPerformed

    private void QuizScoreWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_QuizScoreWindowActivated

if(quizscore>=90){
    quizs.setText(((quizscore/10)+2) + "");
    Q1.setIcon(new ImageIcon("C:\\memorygame\\star.jpg"));
    Q2.setIcon(new ImageIcon("C:\\memorygame\\star.jpg"));
    Q3.setIcon(new ImageIcon("C:\\memorygame\\star.jpg"));
}
else if(quizscore>=60 && quizscore<=80){
    quizs.setText(((quizscore/10)+1) + "");
    Q1.setIcon(new ImageIcon("C:\\memorygame\\star.jpg"));
    Q2.setIcon(new ImageIcon("C:\\memorygame\\star.jpg"));
}
else if(quizscore<60){
    quizs.setText(((quizscore/10))+ "");
    Q1.setIcon(new ImageIcon("C:\\memorygame\\star.jpg"));
}
AudioPlayer.player.stop(as3);
  AudioPlayer.player.start(as4); 
    Congrats6.setText("Congrats, you did great!");
int qs=Integer.parseInt(quizs.getText());
if(qs>q1){
try {
            Class.forName("java.sql.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/12thbproject", "root", "1234");
            st = con.createStatement();
            String sql = "update login set quizs="+qs+" where nickname='"+nickname+"';";
             st.executeUpdate(sql);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }}
// TODO add your handling code here:
    }//GEN-LAST:event_QuizScoreWindowActivated

    private void MGhomeWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_MGhomeWindowActivated
AudioPlayer.player.start(as1);        // TODO add your handling code here:
    }//GEN-LAST:event_MGhomeWindowActivated

    private void STDhomeWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_STDhomeWindowActivated
AudioPlayer.player.start(as1);        // TODO add your handling code here:
    }//GEN-LAST:event_STDhomeWindowActivated

    private void QuizHomeWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_QuizHomeWindowActivated
QuizHome.setSize(710, 440);
        AudioPlayer.player.start(as1);        // TODO add your handling code here:
    }//GEN-LAST:event_QuizHomeWindowActivated

    private void MGL3scoreWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_MGL3scoreWindowActivated
bg.setIcon(new ImageIcon("C:\\memorygame\\confetti.gif"));
        AudioPlayer.player.stop(as3);
  AudioPlayer.player.start(as4);        // TODO add your handling code here:
    }//GEN-LAST:event_MGL3scoreWindowActivated

    private void STDL1WindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_STDL1WindowActivated
AudioPlayer.player.start(as3);        // TODO add your handling code here:
    }//GEN-LAST:event_STDL1WindowActivated

    private void STDL2WindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_STDL2WindowActivated
AudioPlayer.player.start(as3);        // TODO add your handling code here:
    }//GEN-LAST:event_STDL2WindowActivated

    private void STDL3WindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_STDL3WindowActivated
AudioPlayer.player.start(as3);        // TODO add your handling code here:
    }//GEN-LAST:event_STDL3WindowActivated

    private void jButton37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton37ActionPerformed
MGL2.setVisible(true);
        MGL1score.setVisible(false);
jFrame1.setVisible(false);//        // TODO add your handling code here:
    }//GEN-LAST:event_jButton37ActionPerformed

    private void jButton43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton43ActionPerformed
dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton43ActionPerformed

    private void jFrame1WindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_jFrame1WindowActivated
AudioPlayer.player.stop(as3);
  AudioPlayer.player.start(as4);
        int score=Integer.parseInt(sc.getText());
        if(score>mg1)  {try {
            Class.forName("java.sql.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/12thbproject", "root", "1234");
            st = con.createStatement();
            String sql = "update login set mgs1="+score+" where nickname='"+nickname+"';";
             st.executeUpdate(sql);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        }      // TODO add your handling code here:
        // TODO add your handling code here:
    }//GEN-LAST:event_jFrame1WindowActivated

    private void jButton42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton42ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton42ActionPerformed

    private void MGL1scoreWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_MGL1scoreWindowActivated
MGL1score.setSize(510,420);
AudioPlayer.player.stop(as3);
        AudioPlayer.player.start(as4);
        int score=Integer.parseInt(sc.getText());
        if(score>mg1)  {try {
            Class.forName("java.sql.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/12thbproject", "root", "1234");
            st = con.createStatement();
            String sql = "update login set mgs1="+score+" where nickname='"+nickname+"';";
            st.executeUpdate(sql);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        }      // TODO add your handling code here:
    }//GEN-LAST:event_MGL1scoreWindowActivated
   
    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        MGL1score.setVisible(false); // TODO add your handling code here:
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
     MGL1score.setVisible(false);
     gamehome.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        MGL2.setVisible(true);
        MGL1score.setVisible(false);// TODO add your handling code here:
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
MGL2score.setVisible(false);
gamehome.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
MGL2score.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton33ActionPerformed
MGL3score.setVisible(false);
gamehome.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_jButton33ActionPerformed

    private void jButton34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton34ActionPerformed
MGL3score.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton34ActionPerformed

    private void jLabel77MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel77MouseClicked
    if (STD37 == false) {
            STD3score++;
            sd3score.setText(STD3score + "");
            STD37 = true;
        }     // TODO add your handling code here:
    }//GEN-LAST:event_jLabel77MouseClicked

    private void AActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AActionPerformed

    private void DActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
if(qno<=20){qno++;quizz(qno);}
else {
Quiz.setVisible(false);                                                         
               QuizScore.setVisible(true);}// TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
    STDL1score.setVisible(false);
gamehome.setVisible(true);
// TODO add your handling code here:
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
    STDL1score.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton23ActionPerformed

    private void CActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CActionPerformed

    private void QuizWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_QuizWindowActivated
Quiz.setSize(1000, 490);        // TODO add your handling code here:
    }//GEN-LAST:event_QuizWindowActivated

    private void GameHighscoreWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_GameHighscoreWindowActivated
GameHighscore.setSize(730,430);        // TODO add your handling code here:
    }//GEN-LAST:event_GameHighscoreWindowActivated

    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed
    STDL3score.setVisible(false);
    // TODO add your handling code here:
    }//GEN-LAST:event_jButton29ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new main().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton A;
    private javax.swing.JRadioButton B;
    private javax.swing.JRadioButton C;
    private javax.swing.JLabel Congrats1;
    private javax.swing.JLabel Congrats2;
    private javax.swing.JLabel Congrats3;
    private javax.swing.JLabel Congrats4;
    private javax.swing.JLabel Congrats5;
    private javax.swing.JLabel Congrats6;
    private javax.swing.JRadioButton D;
    private javax.swing.JFrame GameHighscore;
    private javax.swing.JFrame Highscore;
    private javax.swing.JLabel L1;
    private javax.swing.JLabel L2;
    private javax.swing.JLabel L21;
    private javax.swing.JLabel L210;
    private javax.swing.JLabel L211;
    private javax.swing.JLabel L212;
    private javax.swing.JLabel L22;
    private javax.swing.JLabel L23;
    private javax.swing.JLabel L24;
    private javax.swing.JLabel L25;
    private javax.swing.JLabel L26;
    private javax.swing.JLabel L27;
    private javax.swing.JLabel L28;
    private javax.swing.JLabel L29;
    private javax.swing.JLabel L3;
    private javax.swing.JLabel L31;
    private javax.swing.JLabel L310;
    private javax.swing.JLabel L311;
    private javax.swing.JLabel L312;
    private javax.swing.JLabel L313;
    private javax.swing.JLabel L314;
    private javax.swing.JLabel L315;
    private javax.swing.JLabel L316;
    private javax.swing.JLabel L317;
    private javax.swing.JLabel L318;
    private javax.swing.JLabel L319;
    private javax.swing.JLabel L32;
    private javax.swing.JLabel L320;
    private javax.swing.JLabel L33;
    private javax.swing.JLabel L34;
    private javax.swing.JLabel L35;
    private javax.swing.JLabel L36;
    private javax.swing.JLabel L37;
    private javax.swing.JLabel L38;
    private javax.swing.JLabel L39;
    private javax.swing.JLabel L4;
    private javax.swing.JLabel L5;
    private javax.swing.JLabel L6;
    private javax.swing.JFrame MGL1;
    private javax.swing.JDialog MGL1score;
    private javax.swing.JFrame MGL2;
    private javax.swing.JDialog MGL2score;
    private javax.swing.JFrame MGL3;
    private javax.swing.JFrame MGL3score;
    private javax.swing.JFrame MGhome;
    private javax.swing.JLabel Q1;
    private javax.swing.JLabel Q2;
    private javax.swing.JLabel Q3;
    private javax.swing.JFrame Quiz;
    private javax.swing.JFrame QuizHome;
    private javax.swing.JFrame QuizScore;
    private javax.swing.JLabel S21;
    private javax.swing.JLabel S22;
    private javax.swing.JLabel S23;
    private javax.swing.JLabel S31;
    private javax.swing.JLabel S32;
    private javax.swing.JLabel S33;
    private javax.swing.JLabel STD1t;
    private javax.swing.JLabel STD2t;
    private javax.swing.JLabel STD3t;
    private javax.swing.JFrame STDL1;
    private javax.swing.JFrame STDL1score;
    private javax.swing.JFrame STDL2;
    private javax.swing.JFrame STDL2score;
    private javax.swing.JFrame STDL3;
    private javax.swing.JFrame STDL3score;
    private javax.swing.JFrame STDhome;
    private javax.swing.JLabel Score;
    private javax.swing.JLabel Score2;
    private javax.swing.JLabel Score3;
    private javax.swing.JLabel Sl1;
    private javax.swing.JLabel Sl10;
    private javax.swing.JLabel Sl11;
    private javax.swing.JLabel Sl1111;
    private javax.swing.JLabel Sl12;
    private javax.swing.JLabel Sl2;
    private javax.swing.JLabel Sl222;
    private javax.swing.JLabel Sl3;
    private javax.swing.JLabel Sl3333;
    private javax.swing.JLabel Sl4;
    private javax.swing.JLabel Sl5;
    private javax.swing.JLabel Sl6;
    private javax.swing.JLabel Sl7;
    private javax.swing.JLabel Sl8;
    private javax.swing.JLabel Sl9;
    private javax.swing.JLabel Time1;
    private javax.swing.JLabel Time2;
    private javax.swing.JDialog about;
    private javax.swing.JLabel bg;
    private javax.swing.JLabel bg1;
    private javax.swing.JLabel bg2;
    private javax.swing.JLabel bg3;
    private javax.swing.JLabel bg4;
    private javax.swing.JLabel bg5;
    private javax.swing.JLabel bg7;
    private javax.swing.JLabel bg8;
    private javax.swing.JLabel bg9;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel congrats555;
    private javax.swing.JLabel congratss;
    private javax.swing.JLabel g1;
    private javax.swing.JLabel g2;
    private javax.swing.JLabel g3;
    private javax.swing.JFrame gamehome;
    private javax.swing.JLabel hello;
    private javax.swing.JLabel hello1;
    private javax.swing.JLabel hey;
    private javax.swing.JLabel hi;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton36;
    private javax.swing.JButton jButton37;
    private javax.swing.JButton jButton39;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton40;
    private javax.swing.JButton jButton41;
    private javax.swing.JButton jButton42;
    private javax.swing.JButton jButton43;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JLabel jlabel10;
    private javax.swing.JPasswordField l_pass;
    private javax.swing.JTextField l_uname;
    private javax.swing.JLabel lm;
    private javax.swing.JFrame loading;
    private javax.swing.JLabel loadlabel;
    private javax.swing.JFrame login;
    private javax.swing.JProgressBar pp1;
    private javax.swing.JLabel progress;
    private javax.swing.JLabel qu1;
    private javax.swing.JLabel qu2;
    private javax.swing.JLabel qu3;
    private javax.swing.JLabel quizs;
    private javax.swing.JTextField s_dob;
    private javax.swing.JTextField s_nname;
    private javax.swing.JPasswordField s_pass;
    private javax.swing.JTextField s_uname;
    private javax.swing.JLabel sc;
    private javax.swing.JLabel sc1;
    private javax.swing.JLabel sc2;
    private javax.swing.JLabel sc3;
    private javax.swing.JLabel sc4;
    private javax.swing.JLabel sc5;
    private javax.swing.JLabel scc;
    private javax.swing.JLabel scd;
    private javax.swing.JLabel sd1score;
    private javax.swing.JLabel sd2score;
    private javax.swing.JLabel sd3score;
    private javax.swing.JDialog signup;
    private javax.swing.JTable t1;
    private javax.swing.JLabel time21;
    private javax.swing.JLabel time22;
    private javax.swing.JLabel time31;
    private javax.swing.JLabel time32;
    // End of variables declaration//GEN-END:variables
}

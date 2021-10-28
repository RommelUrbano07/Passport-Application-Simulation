package Simulation;

/**
 *
 * @author Asus
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class OFFICE extends JFrame {

    public static final int x = 16;
    public static final int y = 30;
    public static JPanel[][] lbl = new JPanel[y][x];
    public static int map[][] = new int[y][x];
    public static int n1 = 25; //25-29
    public static int n2 = 0;  //0-5
    public static int s1 = 25; //25-29
    public static int s2 = 10;  //10-15
    static String normalPersonImg="C:\\Users\\Asus\\Downloads\\Algorithm\\Algorithm\\src\\Simulation\\normal1.png";
    static String specialPersonImg="C:\\Users\\Asus\\Downloads\\Algorithm\\Algorithm\\src\\Simulation\\pwd5.png";

    public OFFICE(String title) throws InterruptedException {

        this.setTitle(title);
        this.setSize(375, 625);
        this.setLocationRelativeTo(null);

        JPanel panel = (JPanel) this.getContentPane();
        panel.setLayout(new GridLayout(y, x));

        //FRAME LAYOUT
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
//                JLabel label = new JLabel(i + "," + j);
                lbl[i][j] = new JPanel();
//                lbl[i][j].add(label);
                lbl[i][j].setBackground(Color.decode("#c5e9e7"));
//                lbl[i][j].setBorder(new LineBorder(Color.BLACK));
                lbl[i][j].setSize(10, 10);
                lbl[i][j].setOpaque(true);
                panel.add(lbl[i][j]);
//                lbl[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            }
        }

        //Lanes Layout
        for (int i = 0; i < y; i++) {
            lbl[i][7].setBackground(Color.GRAY);
            lbl[i][8].setBackground(Color.GRAY);

        }
        for (int i = 4; i <= 11; i++) {
            lbl[1][i].setBackground(Color.GRAY);
            lbl[2][i].setBackground(Color.GRAY);
            lbl[7][i].setBackground(Color.GRAY);
            lbl[8][i].setBackground(Color.GRAY);
            lbl[13][i].setBackground(Color.GRAY);
            lbl[14][i].setBackground(Color.GRAY);
        }

        //Room 5
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 3; j++) {
                lbl[i][j].setBackground(Color.decode("#57b400"));
            }
        }

        //Room 6
        for (int i = 0; i <= 3; i++) {
            for (int j = 12; j <= 15; j++) {
                lbl[i][j].setBackground(Color.decode("#57b400"));
            }
        }

        //Room 3
        for (int i = 6; i <= 9; i++) {
            for (int j = 0; j <= 3; j++) {
                lbl[i][j].setBackground(Color.decode("#57b400"));
            }
        }

        //Room 4
        for (int i = 6; i <= 9; i++) {
            for (int j = 12; j <= 15; j++) {
                lbl[i][j].setBackground(Color.decode("#57b400"));
            }
        }

        //Room 1
        for (int i = 12; i <= 15; i++) {
            for (int j = 0; j <= 3; j++) {
                lbl[i][j].setBackground(Color.decode("#57b400"));
            }
        }

        //Room 2
        for (int i = 12; i <= 15; i++) {
            for (int j = 12; j <= 15; j++) {
                lbl[i][j].setBackground(Color.decode("#57b400"));
            }
        }

        //Admission Office
        for (int i = 18; i <= 22; i++) {
            for (int j = 4; j <= 11; j++) {
                lbl[i][j].setBackground(Color.decode("#57b400"));
            }
        }

        //Regular Lane
        for (int i = 25; i <= 29; i++) {
            for (int j = 0; j <= 5; j++) {
                lbl[i][j].setBackground(Color.decode("#0f52ba"));
//                lbl[i][j].setBorder(new LineBorder(Color.BLACK));
            }
        }

        //Special Lane
        for (int i = 25; i <= 29; i++) {
            for (int j = 10; j <= 15; j++) {
                lbl[i][j].setBackground(Color.decode("#0f52ba"));
//                lbl[i][j].setBorder(new LineBorder(Color.BLACK));
            }
        }

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    /**
     * Pathway algorithm from Normal Customer to Room 1
     * @param time
     * @throws IOException 
     */
    public void pathway_Normal_To_Room1(long time) throws IOException {
        Marker var = new Marker(normalPersonImg);
        Thread thread1;
        thread1 = new Thread() {
            @Override
            public void run() {
                int[][] a = {{17, 7}, {16, 7}, {15, 7}, {14, 7}, {14, 6}, {14, 5}, {14, 4}};

                for (int i = 0; i < a.length; i++) {
                    if ((i < a.length - 1)) {
                        System.out.println(i + "," + 7);
                        lbl[a[i][0]][a[i][1]].setBackground(Color.decode("#ff6666"));
                        lbl[a[i][0]][a[i][1]].add(var, BorderLayout.LINE_START);
                        lbl[a[i][0]][a[i][1]].revalidate();
                        lbl[a[i][0]][a[i][1]].repaint();

                        if (i == 0) {
                            lbl[a[i][0]][a[i][1]].setBackground(Color.decode("#ff6666"));
                        } else if (i > a.length) {
                            lbl[a[i][0]][a[i][1]].setBackground(Color.decode("#ff6666"));
                            lbl[a[i - 1][0]][a[i][1]].setBackground(Color.gray);
                        } else if (i == a.length) {
                            lbl[a[i - 1][0]][a[i][1]].setBackground(Color.gray);
                        }
                        try {
                            Thread.sleep(500);
                        } catch (Exception e) {
                        }
                        lbl[a[i][0]][a[i][1]].setBackground(Color.gray);
                        lbl[a[i][0]][a[i][1]].remove(var);
                        lbl[a[i][0]][a[i][1]].revalidate();
                        lbl[a[i][0]][a[i][1]].repaint();
                    }
                }
                for (int j = 12; j <= 15; j++) {
                    for (int k = 0; k <= 3; k++) {
                        lbl[j][k].setBackground(Color.decode("#b91819"));
                    }
                }
                try {
                    Thread.sleep(time);
                } catch (InterruptedException ex) {
                }
                for (int j = 12; j <= 15; j++) {
                    for (int k = 0; k <= 3; k++) {
                        lbl[j][k].setBackground(Color.decode("#57b400"));
                    }
                }
                try {
                    pathway_Normal_To_Room1_Out();
                } catch (IOException ex) {
                    Logger.getLogger(OFFICE.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        };
        thread1.start();
    }
    /**
     * Pathway algorithm from Special Customer to Room 2
     * @param time
     * @throws IOException 
     */
    public void pathway_Special_To_Room2(long time) throws IOException {
        Marker var = new Marker(specialPersonImg);
        Thread thread1;
        thread1 = new Thread() {
            @Override
            public void run() {
                int[][] b = {{17, 8}, {16, 8}, {15, 8}, {14, 8}, {14, 9}, {14, 10}, {14, 11}};

                for (int i = 0; i < b.length; i++) {
                    System.out.println(i + "," + 7);
                    lbl[b[i][0]][b[i][1]].setBackground(Color.decode("#ff6666"));
                    lbl[b[i][0]][b[i][1]].add(var, BorderLayout.LINE_START);
                    lbl[b[i][0]][b[i][1]].revalidate();
                    lbl[b[i][0]][b[i][1]].repaint();

                    if (i == 0) {
                        lbl[b[i][0]][b[i][1]].setBackground(Color.decode("#ff6666"));
                    } else if (i > b.length) {
                        lbl[b[i][0]][b[i][1]].setBackground(Color.decode("#ff6666"));
                        lbl[b[i - 1][0]][b[i][1]].setBackground(Color.gray);
                    } else if (i == b.length) {
                        lbl[b[i - 1][0]][b[i][1]].setBackground(Color.gray);
                    }

                    try {
                        Thread.sleep(500);
                    } catch (Exception e) {
                    }
                    lbl[b[i][0]][b[i][1]].setBackground(Color.gray);
                    lbl[b[i][0]][b[i][1]].remove(var);
                    lbl[b[i][0]][b[i][1]].revalidate();
                    lbl[b[i][0]][b[i][1]].repaint();
                }
                for (int j = 12; j <= 15; j++) {
                    for (int k = 12; k <= 15; k++) {
                        lbl[j][k].setBackground(Color.decode("#b91819"));
                    }
                }
                try {
                    Thread.sleep(time);
                } catch (InterruptedException ex) {
                }
                for (int j = 12; j <= 15; j++) {
                    for (int k = 12; k <= 15; k++) {
                        lbl[j][k].setBackground(Color.decode("#57b400"));
                    }
                }
                try {
                    pathway_Special_To_Room2_Out();
                } catch (IOException ex) {
                    Logger.getLogger(OFFICE.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        };
        thread1.start();
    }
    /**
     * Pathway algorithm from Normal Customer to Room 3
     * @param time
     * @throws IOException 
     */
    public void pathway_Normal_To_Room3(long time) throws IOException {
        Marker var = new Marker(normalPersonImg);
        Thread thread1;
        thread1 = new Thread() {
            @Override
            public void run() {
                int[][] d = {{17, 7}, {16, 7}, {15, 7}, {14, 7}, {13, 7}, {12, 7}, {11, 7}, {10, 7}, {9, 7}, {8, 7}, {8, 6}, {8, 5}, {8, 4}};

                for (int i = 0; i < d.length; i++) {
                    System.out.println(i + "," + 7);
                    lbl[d[i][0]][d[i][1]].setBackground(Color.decode("#ff6666"));
                    lbl[d[i][0]][d[i][1]].add(var, BorderLayout.LINE_START);
                    lbl[d[i][0]][d[i][1]].revalidate();
                    lbl[d[i][0]][d[i][1]].repaint();

                    if (i == 0) {
                        lbl[d[i][0]][d[i][1]].setBackground(Color.decode("#ff6666"));
                    } else if (i > d.length) {
                        lbl[d[i][0]][d[i][1]].setBackground(Color.decode("#ff6666"));
                        lbl[d[i - 1][0]][d[i][1]].setBackground(Color.gray);
                    } else if (i == d.length) {
                        lbl[d[i - 1][0]][d[i][1]].setBackground(Color.gray);
                    }

                    try {
                        Thread.sleep(500);
                    } catch (Exception e) {
                    }
                    lbl[d[i][0]][d[i][1]].setBackground(Color.gray);
                    lbl[d[i][0]][d[i][1]].remove(var);
                    lbl[d[i][0]][d[i][1]].revalidate();
                    lbl[d[i][0]][d[i][1]].repaint();
                }
                for (int j = 6; j <= 9; j++) {
                    for (int k = 0; k <= 3; k++) {
                        lbl[j][k].setBackground(Color.decode("#b91819"));
                    }
                }
                try {
                    Thread.sleep(time);
                } catch (InterruptedException ex) {
                }
                for (int j = 6; j <= 9; j++) {
                    for (int k = 0; k <= 3; k++) {
                        lbl[j][k].setBackground(Color.decode("#57b400"));
                    }
                }
                try {
                    pathway_Normal_To_Room3_Out();
                } catch (IOException ex) {
                    Logger.getLogger(OFFICE.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        };
        thread1.start();
    }
    /**
     * Pathway algorithm from Special Customer to Room 4
     * @param time
     * @throws IOException 
     */
    public void pathway_Special_To_Room4(long time) throws IOException {
        Marker var = new Marker(specialPersonImg);
        Thread thread1;
        thread1 = new Thread() {
            @Override
            public void run() {
                int[][] c = {{17, 8}, {16, 8}, {15, 8}, {14, 8}, {13, 8}, {12, 8}, {11, 8}, {10, 8}, {9, 8}, {8, 8}, {8, 9}, {8, 10}, {8, 11}};

                for (int i = 0; i < c.length; i++) {
                    System.out.println(i + "," + 7);
                    lbl[c[i][0]][c[i][1]].setBackground(Color.decode("#ff6666"));
                    lbl[c[i][0]][c[i][1]].add(var, BorderLayout.LINE_START);
                    lbl[c[i][0]][c[i][1]].revalidate();
                    lbl[c[i][0]][c[i][1]].repaint();

                    if (i == 0) {
                        lbl[c[i][0]][c[i][1]].setBackground(Color.decode("#ff6666"));
                    } else if (i > c.length) {
                        lbl[c[i][0]][c[i][1]].setBackground(Color.decode("#ff6666"));
                        lbl[c[i - 1][0]][c[i][1]].setBackground(Color.gray);
                    } else if (i == c.length) {
                        lbl[c[i - 1][0]][c[i][1]].setBackground(Color.gray);
                    }

                    try {
                        Thread.sleep(500);
                    } catch (Exception e) {
                    }
                    lbl[c[i][0]][c[i][1]].setBackground(Color.gray);
                    lbl[c[i][0]][c[i][1]].remove(var);
                    lbl[c[i][0]][c[i][1]].revalidate();
                    lbl[c[i][0]][c[i][1]].repaint();
                }
                for (int j = 6; j <= 9; j++) {
                    for (int k = 12; k <= 15; k++) {
                        lbl[j][k].setBackground(Color.decode("#b91819"));
                    }
                }
                try {
                    Thread.sleep(time);
                } catch (InterruptedException ex) {
                }
                for (int j = 6; j <= 9; j++) {
                    for (int k = 12; k <= 15; k++) {
                        lbl[j][k].setBackground(Color.decode("#57b400"));
                    }
                }
                try {
                    pathway_Special_To_Room4_Out();
                } catch (IOException ex) {
                    Logger.getLogger(OFFICE.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        };
        thread1.start();
    }
    /**
     * Pathway algorithm from Normal Customer to Room 5
     * @param time
     * @throws IOException 
     */
    public void pathway_Normal_To_Room5(long time) throws IOException {
        Marker var = new Marker(normalPersonImg);
        Thread thread1;
        thread1 = new Thread() {
            @Override
            public void run() {
                int[][] d = {{17, 7}, {16, 7}, {15, 7}, {14, 7}, {13, 7}, {12, 7}, {11, 7}, {10, 7}, {9, 7}, {8, 7}, {7, 7}, {6, 7}, {5, 7}, {4, 7}, {3, 7}, {2, 7}, {2, 6}, {2, 5}, {2, 4}};
                for (int i = 0; i < d.length; i++) {
                    System.out.println(i + "," + 7);
                    lbl[d[i][0]][d[i][1]].setBackground(Color.decode("#ff6666"));
                    lbl[d[i][0]][d[i][1]].add(var, BorderLayout.LINE_START);
                    lbl[d[i][0]][d[i][1]].revalidate();
                    lbl[d[i][0]][d[i][1]].repaint();

                    if (i == 0) {
                        lbl[d[i][0]][d[i][1]].setBackground(Color.decode("#ff6666"));
                    } else if (i > d.length) {
                        lbl[d[i][0]][d[i][1]].setBackground(Color.decode("#ff6666"));
                        lbl[d[i - 1][0]][d[i][1]].setBackground(Color.gray);
                    } else if (i == d.length) {
                        lbl[d[i - 1][0]][d[i][1]].setBackground(Color.gray);
                    }

                    try {
                        Thread.sleep(500);
                    } catch (Exception e) {
                    }
                    lbl[d[i][0]][d[i][1]].setBackground(Color.gray);
                    lbl[d[i][0]][d[i][1]].remove(var);
                    lbl[d[i][0]][d[i][1]].revalidate();
                    lbl[d[i][0]][d[i][1]].repaint();
                }
                for (int j = 0; j <= 3; j++) {
                    for (int k = 0; k <= 3; k++) {
                        lbl[j][k].setBackground(Color.decode("#b91819"));
                    }
                }
                try {
                    Thread.sleep(time);
                } catch (InterruptedException ex) {
                }
                for (int j = 0; j <= 3; j++) {
                    for (int k = 0; k <= 3; k++) {
                        lbl[j][k].setBackground(Color.decode("#57b400"));
                    }
                }
                try {
                    pathway_Normal_To_Room5_Out();
                } catch (IOException ex) {
                    Logger.getLogger(OFFICE.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        };
        thread1.start();
    }
    /**
     * Pathway algorithm from Special Customer to Room 6
     * @param time
     * @throws IOException 
     */
    public void pathway_Special_To_Room6(long time) throws IOException {
        Marker var = new Marker(specialPersonImg);
        Thread thread1;
        thread1 = new Thread() {
            @Override
            public void run() {
                int[][] f = {{17, 8}, {16, 8}, {15, 8}, {14, 8}, {13, 8}, {12, 8}, {11, 8}, {10, 8}, {9, 8}, {8, 8}, {7, 8},
                {6, 8}, {5, 8}, {4, 8}, {3, 8}, {2, 8}, {2, 9}, {2, 10}, {2, 11}};

                for (int i = 0; i < f.length; i++) {
                    System.out.println(i + "," + 7);
                    lbl[f[i][0]][f[i][1]].setBackground(Color.decode("#ff6666") );
                    lbl[f[i][0]][f[i][1]].add(var, BorderLayout.LINE_START);
                    lbl[f[i][0]][f[i][1]].revalidate();
                    lbl[f[i][0]][f[i][1]].repaint();

                    if (i == 0) {
                        lbl[f[i][0]][f[i][1]].setBackground(Color.decode("#ff6666"));
                    } else if (i > f.length) {
                        lbl[f[i][0]][f[i][1]].setBackground(Color.decode("#ff6666"));
                        lbl[f[i - 1][0]][f[i][1]].setBackground(Color.gray);
                    } else if (i == f.length) {
                        lbl[f[i - 1][0]][f[i][1]].setBackground(Color.gray);
                    }
                    try {
                        Thread.sleep(500);
                    } catch (Exception e) {
                    }
                    lbl[f[i][0]][f[i][1]].setBackground(Color.gray);
                    lbl[f[i][0]][f[i][1]].remove(var);
                    lbl[f[i][0]][f[i][1]].revalidate();
                    lbl[f[i][0]][f[i][1]].repaint();
                }

                for (int j = 0; j <= 3; j++) {
                    for (int k = 12; k <= 15; k++) {
                        lbl[j][k].setBackground(Color.decode("#b91819"));
                    }
                }
                try {
                    Thread.sleep(time);
                } catch (InterruptedException ex) {
                }
                for (int j = 0; j <= 3; j++) {
                    for (int k = 12; k <= 15; k++) {
                        lbl[j][k].setBackground(Color.decode("#57b400"));
                    }
                }
                try {
                    pathway_Special_To_Room6_Out();
                } catch (IOException ex) {
                    Logger.getLogger(OFFICE.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        };
        thread1.start();
    }
    /**
     * Pathway algorithm from Room 1 out to end of GUI
     * @throws IOException 
     */
    public void pathway_Normal_To_Room1_Out() throws IOException {
        Marker var = new Marker(normalPersonImg);
        Thread thread1;
        thread1 = new Thread() {
            @Override
            public void run() {
                int[][] a
                        = {{13, 4}, {13, 5}, {13, 6}, {13, 7}, {12, 7}, {11, 7}, {10, 7}, {9, 7}, {8, 7}, {7, 7}, {6, 7}, {5, 7}, {4, 7}, {3, 7}, {2, 7}, {1, 7}, {0, 7}};

                for (int i = 0; i < a.length; i++) {
                    System.out.println(i + "," + 7);
                    lbl[a[i][0]][a[i][1]].setBackground(Color.decode("#57b400"));
                    lbl[a[i][0]][a[i][1]].add(var, BorderLayout.LINE_START);
                    lbl[a[i][0]][a[i][1]].revalidate();
                    lbl[a[i][0]][a[i][1]].repaint();

                    if (i == 0) {
//                        lbl[a[i][0]][a[i][1]].setBackground(Color.blue);
                    } else if (i > a.length) {
//                        lbl[a[i][0]][a[i][1]].setBackground(Color.blue);
                        lbl[a[i - 1][0]][a[i][1]].setBackground(Color.gray);
                    } else if (i == a.length) {
                        lbl[a[i - 1][0]][a[i][1]].setBackground(Color.gray);
                    }
                    try {
                        Thread.sleep(500);
                    } catch (Exception e) {
                    }
                    lbl[a[i][0]][a[i][1]].setBackground(Color.gray);
                    lbl[a[i][0]][a[i][1]].remove(var);
                    lbl[a[i][0]][a[i][1]].revalidate();
                    lbl[a[i][0]][a[i][1]].repaint();
                }

            }

        };
        thread1.start();
    }
    /**
     * Pathway algorithm from Room 2 out to end of GUI
     * @throws IOException 
     */
    public void pathway_Special_To_Room2_Out() throws IOException {
        Marker var = new Marker(specialPersonImg);
        Thread thread1;
        thread1 = new Thread() {
            @Override
            public void run() {
                int[][] b = {{13, 11},
                {13, 10}, {13, 9}, {13, 8}, {12, 8}, {11, 8}, {10, 8}, {9, 8}, {8, 8},
                {7, 8}, {6, 8}, {5, 8}, {4, 8}, {3, 8}, {2, 8}, {1, 8}, {0, 8}};

                for (int i = 0; i < b.length; i++) {
                    System.out.println(i + "," + 7);
                    lbl[b[i][0]][b[i][1]].setBackground(Color.decode("#57b400"));
                    lbl[b[i][0]][b[i][1]].add(var, BorderLayout.LINE_START);
                    lbl[b[i][0]][b[i][1]].revalidate();
                    lbl[b[i][0]][b[i][1]].repaint();

                    if (i == 0) {
                        lbl[b[i][0]][b[i][1]].setBackground(Color.decode("#57b400"));
                    } else if (i > b.length) {
                        lbl[b[i][0]][b[i][1]].setBackground(Color.decode("#57b400"));
                        lbl[b[i - 1][0]][b[i][1]].setBackground(Color.gray);
                    } else if (i == b.length) {
                        lbl[b[i - 1][0]][b[i][1]].setBackground(Color.gray);
                    }
                    try {
                        Thread.sleep(500);
                    } catch (Exception e) {
                    }
                    lbl[b[i][0]][b[i][1]].setBackground(Color.gray);
                    lbl[b[i][0]][b[i][1]].remove(var);
                    lbl[b[i][0]][b[i][1]].revalidate();
                    lbl[b[i][0]][b[i][1]].repaint();
                }

            }

        };
        thread1.start();
    }
    /**
     * Pathway algorithm from Room 3 out to end of GUI
     * @throws IOException 
     */
    public void pathway_Normal_To_Room3_Out() throws IOException {
        Marker var = new Marker(normalPersonImg);
        Thread thread1;
        thread1 = new Thread() {
            @Override
            public void run() {
                int[][] d = {{7, 4}, {7, 5}, {7, 6}, {7, 7},
                {6, 7}, {5, 7}, {4, 7}, {3, 7}, {2, 7}, {1, 7}, {0, 7}};

                for (int i = 0; i < d.length; i++) {
                    System.out.println(i + "," + 7);
                    lbl[d[i][0]][d[i][1]].setBackground(Color.decode("#57b400"));
                    lbl[d[i][0]][d[i][1]].add(var, BorderLayout.LINE_START);
                    lbl[d[i][0]][d[i][1]].revalidate();
                    lbl[d[i][0]][d[i][1]].repaint();

                    if (i == 0) {
                        lbl[d[i][0]][d[i][1]].setBackground(Color.decode("#57b400"));
                    } else if (i > 17) {
                        lbl[d[i][0]][d[i][1]].setBackground(Color.decode("#57b400"));
                        lbl[d[i - 1][0]][d[i][1]].setBackground(Color.gray);
                    } else if (i == d.length) {
                        lbl[d[i - 1][0]][d[i][1]].setBackground(Color.gray);
                    }

                    try {
                        Thread.sleep(500);
                    } catch (Exception e) {
                    }
                    lbl[d[i][0]][d[i][1]].setBackground(Color.gray);
                    lbl[d[i][0]][d[i][1]].remove(var);
                    lbl[d[i][0]][d[i][1]].revalidate();
                    lbl[d[i][0]][d[i][1]].repaint();
                }
            }
        };
        thread1.start();
    }
    /**
     * Pathway algorithm from Room 4 out to end of GUI
     * @throws IOException 
     */
    public void pathway_Special_To_Room4_Out() throws IOException {
        Marker var = new Marker(specialPersonImg);
        Thread thread1;
        thread1 = new Thread() {
            @Override
            public void run() {
                int[][] c = {{7, 11}, {7, 10}, {7, 9}, {7, 8}, {6, 8}, {5, 8}, {4, 8}, {3, 8}, {2, 8}, {1, 8}, {0, 8}};

                for (int i = 0; i < c.length; i++) {
                    System.out.println(i + "," + 7);
                    lbl[c[i][0]][c[i][1]].setBackground(Color.decode("#57b400"));
                    lbl[c[i][0]][c[i][1]].add(var, BorderLayout.LINE_START);
                    lbl[c[i][0]][c[i][1]].revalidate();
                    lbl[c[i][0]][c[i][1]].repaint();
                    if (i == 0) {
                        lbl[c[i][0]][c[i][1]].setBackground(Color.decode("#57b400"));
                    } else if (i > 17) {
                        lbl[c[i][0]][c[i][1]].setBackground(Color.decode("#57b400"));
                        lbl[c[i - 1][0]][c[i][1]].setBackground(Color.gray);
                    } else if (i == c.length) {
                        lbl[c[i - 1][0]][c[i][1]].setBackground(Color.gray);
                    }
                    try {
                        Thread.sleep(500);
                    } catch (Exception e) {
                    }
                    lbl[c[i][0]][c[i][1]].setBackground(Color.gray);
                    lbl[c[i][0]][c[i][1]].remove(var);
                    lbl[c[i][0]][c[i][1]].revalidate();
                    lbl[c[i][0]][c[i][1]].repaint();
                }

            }

        };
        thread1.start();
    }
    /**
     * Pathway algorithm from Room 5 out to end of GUI
     * @throws IOException 
     */
    public void pathway_Normal_To_Room5_Out() throws IOException {
        Marker var = new Marker(normalPersonImg);
        Thread thread1;
        thread1 = new Thread() {
            @Override
            public void run() {
                int[][] f = {{1, 4}, {1, 5}, {1, 6}, {1, 7}, {0, 7}};
                for (int i = 0; i < f.length; i++) {
                    System.out.println(i + "," + 7);
                    lbl[f[i][0]][f[i][1]].setBackground(Color.decode("#57b400"));
                    lbl[f[i][0]][f[i][1]].add(var, BorderLayout.LINE_START);
                    lbl[f[i][0]][f[i][1]].revalidate();
                    lbl[f[i][0]][f[i][1]].repaint();

                    if (i == 0) {
                        lbl[f[i][0]][f[i][1]].setBackground(Color.decode("#57b400"));
                    } else if (i > f.length) {
                        lbl[f[i][0]][f[i][1]].setBackground(Color.decode("#57b400"));
                        lbl[f[i - 1][0]][f[i][1]].setBackground(Color.gray);
                    } else if (i == f.length) {
                        lbl[f[i - 1][0]][f[i][1]].setBackground(Color.gray);
                    }
                    try {
                        Thread.sleep(500);
                    } catch (Exception e) {
                    }
                    lbl[f[i][0]][f[i][1]].setBackground(Color.gray);
                    lbl[f[i][0]][f[i][1]].remove(var);
                    lbl[f[i][0]][f[i][1]].revalidate();
                    lbl[f[i][0]][f[i][1]].repaint();
                }
            }

        };
        thread1.start();
    }
    /**
     * Pathway algorithm from Room 6 out to end of GUI
     * @throws IOException 
     */
    public void pathway_Special_To_Room6_Out() throws IOException {
        Marker var = new Marker(specialPersonImg);
        Thread thread1;
        thread1 = new Thread() {
            @Override
            public void run() {
                int[][] f = {{1, 11}, {1, 10}, {1, 9}, {1, 8}, {0, 8}};
                for (int i = 0; i < f.length; i++) {
                    System.out.println(i + "," + 7);
                    lbl[f[i][0]][f[i][1]].setBackground(Color.decode("#57b400"));
                    lbl[f[i][0]][f[i][1]].add(var, BorderLayout.LINE_START);
                    lbl[f[i][0]][f[i][1]].revalidate();
                    lbl[f[i][0]][f[i][1]].repaint();

                    if (i == 0) {
                        lbl[f[i][0]][f[i][1]].setBackground(Color.decode("#57b400"));
                    } else if (i > f.length) {
                        lbl[f[i][0]][f[i][1]].setBackground(Color.decode("#57b400"));
                        lbl[f[i - 1][0]][f[i][1]].setBackground(Color.gray);
                    } else if (i == f.length) {
                        lbl[f[i - 1][0]][f[i][1]].setBackground(Color.gray);
                    }
                    try {
                        Thread.sleep(500);
                    } catch (Exception e) {
                    }
                    lbl[f[i][0]][f[i][1]].setBackground(Color.gray);
                    lbl[f[i][0]][f[i][1]].remove(var);
                    lbl[f[i][0]][f[i][1]].revalidate();
                    lbl[f[i][0]][f[i][1]].repaint();
                }
            }

        };
        thread1.start();
    }
    /**
     * Pathway algorithm from Normal Customer to Room 2
     * @param time
     * @throws IOException 
     */
    public void pathway_Normal_To_Room2(long time) throws IOException {
        Marker var = new Marker(normalPersonImg);
        Thread thread1;
        thread1 = new Thread() {
            @Override
            public void run() {
                int[][] b = {{17, 7}, {16, 7}, {15, 7}, {14, 7}, {14, 8}, {14, 9}, {14, 10}, {14, 11}};

                for (int i = 0; i < b.length; i++) {
                    System.out.println(i + "," + 7);
                    lbl[b[i][0]][b[i][1]].setBackground(Color.decode("#ff6666"));
                    lbl[b[i][0]][b[i][1]].add(var, BorderLayout.LINE_START);
                    lbl[b[i][0]][b[i][1]].revalidate();
                    lbl[b[i][0]][b[i][1]].repaint();

                    if (i == 0) {
                        lbl[b[i][0]][b[i][1]].setBackground(Color.decode("#ff6666"));
                    } else if (i > b.length) {
                        lbl[b[i][0]][b[i][1]].setBackground(Color.decode("#ff6666"));
                        lbl[b[i - 1][0]][b[i][1]].setBackground(Color.gray);
                    } else if (i == b.length) {
                        lbl[b[i - 1][0]][b[i][1]].setBackground(Color.gray);
                    }

                    try {
                        Thread.sleep(500);
                    } catch (Exception e) {
                    }
                    lbl[b[i][0]][b[i][1]].setBackground(Color.gray);
                    lbl[b[i][0]][b[i][1]].remove(var);
                    lbl[b[i][0]][b[i][1]].revalidate();
                    lbl[b[i][0]][b[i][1]].repaint();
                }
                for (int j = 12; j <= 15; j++) {
                    for (int k = 12; k <= 15; k++) {
                        lbl[j][k].setBackground(Color.decode("#b91819"));
                    }
                }
                try {
                    Thread.sleep(time);
                } catch (InterruptedException ex) {
                }
                for (int j = 12; j <= 15; j++) {
                    for (int k = 12; k <= 15; k++) {
                        lbl[j][k].setBackground(Color.decode("#57b400"));

                    }
                }
                try {
                    pathway_Normal_To_Room2_Out();
                } catch (IOException ex) {
                    Logger.getLogger(OFFICE.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        };
        thread1.start();
    }
    /**
     * Pathway algorithm from Room 2 out to end of GUI
     * @throws IOException 
     */
    public void pathway_Normal_To_Room2_Out() throws IOException {
        Marker var = new Marker(normalPersonImg);
        Thread thread1;
        thread1 = new Thread() {
            @Override
            public void run() {
                int[][] b = {{13, 11},
                {13, 10}, {13, 9}, {13, 8}, {12, 8}, {11, 8}, {10, 8}, {9, 8}, {8, 8},
                {7, 8}, {6, 8}, {5, 8}, {4, 8}, {3, 8}, {2, 8}, {1, 8}, {0, 8}};

                for (int i = 0; i < b.length; i++) {
                    System.out.println(i + "," + 7);
                    lbl[b[i][0]][b[i][1]].setBackground(Color.decode("#57b400"));
                    lbl[b[i][0]][b[i][1]].add(var, BorderLayout.LINE_START);
                    lbl[b[i][0]][b[i][1]].revalidate();
                    lbl[b[i][0]][b[i][1]].repaint();

                    if (i == 0) {
                        lbl[b[i][0]][b[i][1]].setBackground(Color.decode("#57b400"));
                    } else if (i > b.length) {
                        lbl[b[i][0]][b[i][1]].setBackground(Color.decode("#57b400"));
                        lbl[b[i - 1][0]][b[i][1]].setBackground(Color.gray);
                    } else if (i == b.length) {
                        lbl[b[i - 1][0]][b[i][1]].setBackground(Color.gray);
                    }
                    try {
                        Thread.sleep(500);
                    } catch (Exception e) {
                    }
                    lbl[b[i][0]][b[i][1]].setBackground(Color.gray);
                    lbl[b[i][0]][b[i][1]].remove(var);
                    lbl[b[i][0]][b[i][1]].revalidate();
                    lbl[b[i][0]][b[i][1]].repaint();
                }

            }

        };
        thread1.start();
    }
    /**
     * Pathway algorithm from Normal Customer to Room 4
     * @param time
     * @throws IOException 
     */
    public void pathway_Normal_To_Room4(long time) throws IOException {
        Marker var = new Marker(normalPersonImg);
        Thread thread1;
        thread1 = new Thread() {
            @Override
            public void run() {
                int[][] x = {{16, 7}, {15, 7}, {14, 7}, {13, 7}, {13, 7}, {12, 7}, {11, 7}, {10, 7}, {9, 7}, {8, 7}, {8, 8}, {8, 9}, {8, 10}, {8, 11}};

                for (int i = 0; i < x.length; i++) {
                    System.out.println(i + "," + 7);
                    lbl[x[i][0]][x[i][1]].setBackground(Color.decode("#ff6666"));
                    lbl[x[i][0]][x[i][1]].add(var, BorderLayout.LINE_START);
                    lbl[x[i][0]][x[i][1]].revalidate();
                    lbl[x[i][0]][x[i][1]].repaint();

                    if (i == 0) {
                        lbl[x[i][0]][x[i][1]].setBackground(Color.decode("#ff6666"));
                    } else if (i > x.length) {
                        lbl[x[i][0]][x[i][1]].setBackground(Color.decode("#ff6666"));
                        lbl[x[i - 1][0]][x[i][1]].setBackground(Color.gray);
                    } else if (i == x.length) {
                        lbl[x[i - 1][0]][x[i][1]].setBackground(Color.gray);
                    }

                    try {
                        Thread.sleep(500);
                    } catch (Exception e) {
                    }
                    lbl[x[i][0]][x[i][1]].setBackground(Color.gray);
                    lbl[x[i][0]][x[i][1]].remove(var);
                    lbl[x[i][0]][x[i][1]].revalidate();
                    lbl[x[i][0]][x[i][1]].repaint();
                }
                for (int j = 6; j <= 9; j++) {
                    for (int k = 12; k <= 15; k++) {
                        lbl[j][k].setBackground(Color.decode("#b91819"));
                    }
                }
                try {
                    Thread.sleep(time);
                } catch (InterruptedException ex) {
                }
                for (int j = 6; j <= 9; j++) {
                    for (int k = 12; k <= 15; k++) {
                        lbl[j][k].setBackground(Color.decode("#57b400"));
                    }
                }
                try {
                    pathway_Normal_To_Room4_Out();
                } catch (IOException ex) {
                    Logger.getLogger(OFFICE.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        thread1.start();
    }
    /**
     * Pathway algorithm from Room 4 out to end of GUI
     * @throws IOException 
     */
    public void pathway_Normal_To_Room4_Out() throws IOException {
        Marker var = new Marker(normalPersonImg);
        Thread thread1;
        thread1 = new Thread() {
            @Override
            public void run() {
                int[][] c = {{7, 11}, {7, 10}, {7, 9}, {7, 8}, {6, 8}, {5, 8}, {4, 8}, {3, 8}, {2, 8}, {1, 8}, {0, 8}};

                for (int i = 0; i < c.length; i++) {
                    System.out.println(i + "," + 7);
                    lbl[c[i][0]][c[i][1]].setBackground(Color.decode("#57b400"));
                    lbl[c[i][0]][c[i][1]].add(var, BorderLayout.LINE_START);
                    lbl[c[i][0]][c[i][1]].revalidate();
                    lbl[c[i][0]][c[i][1]].repaint();
                    if (i == 0) {
                        lbl[c[i][0]][c[i][1]].setBackground(Color.decode("#57b400"));
                    } else if (i > 17) {
                        lbl[c[i][0]][c[i][1]].setBackground(Color.decode("#57b400"));
                        lbl[c[i - 1][0]][c[i][1]].setBackground(Color.gray);
                    } else if (i == c.length) {
                        lbl[c[i - 1][0]][c[i][1]].setBackground(Color.gray);
                    }
                    try {
                        Thread.sleep(500);
                    } catch (Exception e) {
                    }
                    lbl[c[i][0]][c[i][1]].setBackground(Color.gray);
                    lbl[c[i][0]][c[i][1]].remove(var);
                    lbl[c[i][0]][c[i][1]].revalidate();
                    lbl[c[i][0]][c[i][1]].repaint();
                }

            }

        };
        thread1.start();
    }
    /**
     * Pathway algorithm from Normal Customer to Room 6
     * @param time
     * @throws IOException 
     */
    public void pathway_Normal_To_Room6(long time) throws IOException {
        Marker var = new Marker(normalPersonImg);
        Thread thread1;
        thread1 = new Thread() {
            @Override
            public void run() {
                int[][] x = {{17, 7}, {16, 7}, {15, 7}, {14, 7}, {13, 7}, {12, 7}, {11, 7}, {10, 7}, {9, 7}, {8, 7}, {7, 7}, {6, 7}, {5, 7}, {4, 7}, {3, 7}, {2, 7},
                {2, 8}, {2, 9}, {2, 10}, {2, 11}};

                for (int i = 0; i < x.length; i++) {
                    System.out.println(i + "," + 7);
                    lbl[x[i][0]][x[i][1]].setBackground(Color.decode("#ff6666"));
                    lbl[x[i][0]][x[i][1]].add(var, BorderLayout.LINE_START);
                    lbl[x[i][0]][x[i][1]].revalidate();
                    lbl[x[i][0]][x[i][1]].repaint();

                    if (i == 0) {
                        lbl[x[i][0]][x[i][1]].setBackground(Color.decode("#ff6666"));
                    } else if (i > x.length) {
                        lbl[x[i][0]][x[i][1]].setBackground(Color.decode("#ff6666"));
                        lbl[x[i - 1][0]][x[i][1]].setBackground(Color.gray);
                    } else if (i == x.length) {
                        lbl[x[i - 1][0]][x[i][1]].setBackground(Color.gray);
                    }

                    try {
                        Thread.sleep(500);
                    } catch (Exception e) {
                    }
                    lbl[x[i][0]][x[i][1]].setBackground(Color.gray);
                    lbl[x[i][0]][x[i][1]].remove(var);
                    lbl[x[i][0]][x[i][1]].revalidate();
                    lbl[x[i][0]][x[i][1]].repaint();

                }
                for (int j = 0; j <= 3; j++) {
                    for (int k = 12; k <= 15; k++) {
                        lbl[j][k].setBackground(Color.decode("#b91819"));
                    }
                }
                try {
                    Thread.sleep(time);
                } catch (InterruptedException ex) {
                }
                for (int j = 0; j <= 3; j++) {
                    for (int k = 12; k <= 15; k++) {
                        lbl[j][k].setBackground(Color.decode("#57b400"));
                    }
                }
                try {
                    pathway_Normal_To_Room6_Out();
                } catch (IOException ex) {
                    Logger.getLogger(OFFICE.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        };
        thread1.start();
    }
    /**
     * Pathway algorithm from Room 6 out to end of GUI
     * @throws IOException 
     */
    public void pathway_Normal_To_Room6_Out() throws IOException {
        Marker var = new Marker(normalPersonImg);
        Thread thread1;
        thread1 = new Thread() {
            @Override
            public void run() {
                int[][] f = {{1, 11}, {1, 10}, {1, 9}, {1, 8}, {0, 8}};
                for (int i = 0; i < f.length; i++) {
                    System.out.println(i + "," + 7);
                    lbl[f[i][0]][f[i][1]].setBackground(Color.decode("#57b400"));
                    lbl[f[i][0]][f[i][1]].add(var, BorderLayout.LINE_START);
                    lbl[f[i][0]][f[i][1]].revalidate();
                    lbl[f[i][0]][f[i][1]].repaint();

                    if (i == 0) {
                        lbl[f[i][0]][f[i][1]].setBackground(Color.decode("#57b400"));
                    } else if (i > f.length) {
                        lbl[f[i][0]][f[i][1]].setBackground(Color.decode("#57b400"));
                        lbl[f[i - 1][0]][f[i][1]].setBackground(Color.gray);
                    } else if (i == f.length) {
                        lbl[f[i - 1][0]][f[i][1]].setBackground(Color.gray);
                    }
                    try {
                        Thread.sleep(500);
                    } catch (Exception e) {
                    }
                    lbl[f[i][0]][f[i][1]].setBackground(Color.gray);
                    lbl[f[i][0]][f[i][1]].remove(var);
                    lbl[f[i][0]][f[i][1]].revalidate();
                    lbl[f[i][0]][f[i][1]].repaint();
                }
            }

        };
        thread1.start();
    }
    /**
     * Pathway algorithm from Special Customer to Room 1
     * @param time
     * @throws IOException 
     */
    public void pathway_Special_To_Room1(long time) throws IOException {
        Marker var = new Marker(specialPersonImg);
        Thread thread1;
        thread1 = new Thread() {
            @Override
            public void run() {
                int[][] b = {{17, 8}, {16, 8}, {15, 8}, {14, 8}, {14, 7}, {14, 6}, {14, 5}, {14, 4}};

                for (int i = 0; i < b.length; i++) {
                    System.out.println(i + "," + 7);
                    lbl[b[i][0]][b[i][1]].setBackground(Color.decode("#ff6666"));
                    lbl[b[i][0]][b[i][1]].add(var, BorderLayout.LINE_START);
                    lbl[b[i][0]][b[i][1]].revalidate();
                    lbl[b[i][0]][b[i][1]].repaint();

                    if (i == 0) {
                        lbl[b[i][0]][b[i][1]].setBackground(Color.decode("#ff6666"));
                    } else if (i > b.length) {
                        lbl[b[i][0]][b[i][1]].setBackground(Color.decode("#ff6666"));
                        lbl[b[i - 1][0]][b[i][1]].setBackground(Color.gray);
                    } else if (i == b.length) {
                        lbl[b[i - 1][0]][b[i][1]].setBackground(Color.gray);
                    }

                    try {
                        Thread.sleep(500);
                    } catch (Exception e) {
                    }
                    lbl[b[i][0]][b[i][1]].setBackground(Color.gray);
                    lbl[b[i][0]][b[i][1]].remove(var);
                    lbl[b[i][0]][b[i][1]].revalidate();
                    lbl[b[i][0]][b[i][1]].repaint();
                }
                for (int j = 12; j <= 15; j++) {
                    for (int k = 0; k <= 3; k++) {
                        lbl[j][k].setBackground(Color.decode("#b91819") );
                    }
                }
                try {
                    Thread.sleep(time);
                } catch (InterruptedException ex) {
                }
                for (int j = 12; j <= 15; j++) {
                    for (int k = 0; k <= 3; k++) {
                        lbl[j][k].setBackground(Color.decode("#57b400") );
                    }
                }
                try {
                    pathway_Special_To_Room1Out();
                } catch (IOException ex) {
                    Logger.getLogger(OFFICE.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        };
        thread1.start();
    }
    /**
     * Pathway algorithm from Room 1 out to end of GUI
     * @throws IOException 
     */
    public void pathway_Special_To_Room1Out() throws IOException {
        Marker var = new Marker(specialPersonImg);
        Thread thread1;
        thread1 = new Thread() {
            @Override
            public void run() {
                int[][] a
                        = {{13, 4}, {13, 5}, {13, 6}, {13, 7}, {13, 8}, {12, 8}, {11, 8}, {10, 8}, {9, 8}, {8, 8},
                        {7, 8}, {6, 8}, {5, 8}, {4, 8}, {3, 8}, {2, 8}, {1, 8}, {0, 8}};

                for (int i = 0; i < a.length; i++) {
                    System.out.println(i + "," + 7);
                    lbl[a[i][0]][a[i][1]].setBackground(Color.decode("#57b400"));
                    lbl[a[i][0]][a[i][1]].add(var, BorderLayout.LINE_START);
                    lbl[a[i][0]][a[i][1]].revalidate();
                    lbl[a[i][0]][a[i][1]].repaint();

                    if (i == 0) {
                        lbl[a[i][0]][a[i][1]].setBackground(Color.decode("#57b400"));
                    } else if (i > a.length) {
                        lbl[a[i][0]][a[i][1]].setBackground(Color.decode("#57b400"));
                        lbl[a[i - 1][0]][a[i][1]].setBackground(Color.gray);
                    } else if (i == a.length) {
                        lbl[a[i - 1][0]][a[i][1]].setBackground(Color.gray);
                    }
                    try {
                        Thread.sleep(500);
                    } catch (Exception e) {
                    }
                    lbl[a[i][0]][a[i][1]].setBackground(Color.gray);
                    lbl[a[i][0]][a[i][1]].remove(var);
                    lbl[a[i][0]][a[i][1]].revalidate();
                    lbl[a[i][0]][a[i][1]].repaint();
                }

            }

        };
        thread1.start();
    }
    /**
     * Pathway algorithm from Special Customer to Room 3
     * @param time
     * @throws IOException 
     */
    public void pathway_Special_To_Room3(long time) throws IOException {
        Marker var = new Marker(specialPersonImg);
        Thread thread1;
        thread1 = new Thread() {
            @Override
            public void run() {
                int[][] c = {{17, 8}, {16, 8}, {15, 8}, {14, 8}, {13, 8}, {12, 8}, {11, 8}, {10, 8}, {9, 8}, {8, 8}, {8, 7}, {8, 6}, {8, 5}, {8, 4}};

                for (int i = 0; i < c.length; i++) {
                    System.out.println(i + "," + 7);
                    lbl[c[i][0]][c[i][1]].setBackground(Color.decode("#ff6666"));
                    lbl[c[i][0]][c[i][1]].add(var, BorderLayout.LINE_START);
                    lbl[c[i][0]][c[i][1]].revalidate();
                    lbl[c[i][0]][c[i][1]].repaint();

                    if (i == 0) {
                        lbl[c[i][0]][c[i][1]].setBackground(Color.decode("#ff6666"));
                    } else if (i > c.length) {
                        lbl[c[i][0]][c[i][1]].setBackground(Color.decode("#ff6666"));
                        lbl[c[i - 1][0]][c[i][1]].setBackground(Color.gray);
                    } else if (i == c.length) {
                        lbl[c[i - 1][0]][c[i][1]].setBackground(Color.gray);
                    }

                    try {
                        Thread.sleep(500);
                    } catch (Exception e) {
                    }
                    lbl[c[i][0]][c[i][1]].setBackground(Color.gray);
                    lbl[c[i][0]][c[i][1]].remove(var);
                    lbl[c[i][0]][c[i][1]].revalidate();
                    lbl[c[i][0]][c[i][1]].repaint();
                }
                for (int j = 6; j <= 9; j++) {
                    for (int k = 0; k <= 3; k++) {
                        lbl[j][k].setBackground(Color.decode("#b91819"));
                    }
                }
                try {
                    Thread.sleep(time);
                } catch (InterruptedException ex) {
                }
                for (int j = 6; j <= 9; j++) {
                    for (int k = 0; k <= 3; k++) {
                        lbl[j][k].setBackground(Color.decode("#57b400") );
                    }
                }
                try {
                    pathway_Special_To_Room3_Out();
                } catch (IOException ex) {
                    Logger.getLogger(OFFICE.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        };
        thread1.start();
    }
    /**
     * Pathway algorithm from Room 3 out to end of GUI
     * @throws IOException 
     */
    public void pathway_Special_To_Room3_Out() throws IOException {
        Marker var = new Marker(specialPersonImg);
        Thread thread1;
        thread1 = new Thread() {
            @Override
            public void run() {
                int[][] d = {{7, 4}, {7, 5}, {7, 6}, {7, 7},
                {7, 8}, {6, 8}, {5, 8}, {4, 8}, {3, 8}, {2, 8}, {1, 8}, {0, 8}};

                for (int i = 0; i < d.length; i++) {
                    System.out.println(i + "," + 7);
                    lbl[d[i][0]][d[i][1]].setBackground(Color.decode("#57b400"));
                    lbl[d[i][0]][d[i][1]].add(var, BorderLayout.LINE_START);
                    lbl[d[i][0]][d[i][1]].revalidate();
                    lbl[d[i][0]][d[i][1]].repaint();

                    if (i == 0) {
                        lbl[d[i][0]][d[i][1]].setBackground(Color.decode("#57b400"));
                    } else if (i > 17) {
                        lbl[d[i][0]][d[i][1]].setBackground(Color.decode("#57b400"));
                        lbl[d[i - 1][0]][d[i][1]].setBackground(Color.gray);
                    } else if (i == d.length) {
                        lbl[d[i - 1][0]][d[i][1]].setBackground(Color.gray);
                    }

                    try {
                        Thread.sleep(500);
                    } catch (Exception e) {
                    }
                    lbl[d[i][0]][d[i][1]].setBackground(Color.gray);
                    lbl[d[i][0]][d[i][1]].remove(var);
                    lbl[d[i][0]][d[i][1]].revalidate();
                    lbl[d[i][0]][d[i][1]].repaint();
                }
            }
        };
        thread1.start();
    }
    /**
     * Pathway algorithm from Special Customer to Room 5
     * @param time
     * @throws IOException 
     */
    public void pathway_Special_To_Room5(long time) throws IOException {
        Marker var = new Marker(specialPersonImg);
        Thread thread1;
        thread1 = new Thread() {
            @Override
            public void run() {
                int[][] f = {{17, 8}, {16, 8}, {15, 8}, {14, 8}, {13, 8}, {12, 8}, {11, 8}, {10, 8}, {9, 8}, {8, 8}, {7, 8},
                {6, 8}, {5, 8}, {4, 8}, {3, 8}, {2, 8}, {2, 7}, {2, 6}, {2, 5}, {2, 4}};

                for (int i = 0; i < f.length; i++) {
                    System.out.println(i + "," + 7);
                    lbl[f[i][0]][f[i][1]].setBackground(Color.decode("#ff6666"));
                    lbl[f[i][0]][f[i][1]].add(var, BorderLayout.LINE_START);
                    lbl[f[i][0]][f[i][1]].revalidate();
                    lbl[f[i][0]][f[i][1]].repaint();

                    if (i == 0) {
                        lbl[f[i][0]][f[i][1]].setBackground(Color.decode("#ff6666"));
                    } else if (i > f.length) {
                        lbl[f[i][0]][f[i][1]].setBackground(Color.decode("#ff6666"));
                        lbl[f[i - 1][0]][f[i][1]].setBackground(Color.gray);
                    } else if (i == f.length) {
                        lbl[f[i - 1][0]][f[i][1]].setBackground(Color.gray);
                    }
                    try {
                        Thread.sleep(500);
                    } catch (Exception e) {
                    }
                    lbl[f[i][0]][f[i][1]].setBackground(Color.gray);
                    lbl[f[i][0]][f[i][1]].remove(var);
                    lbl[f[i][0]][f[i][1]].revalidate();
                    lbl[f[i][0]][f[i][1]].repaint();
                }

                for (int j = 0; j <= 3; j++) {
                    for (int k = 0; k <= 3; k++) {
                        lbl[j][k].setBackground(Color.decode("#b91819"));
                    }
                }
                try {
                    Thread.sleep(time);
                } catch (InterruptedException ex) {
                }
                for (int j = 0; j <= 3; j++) {
                    for (int k = 0; k <= 3; k++) {
                        lbl[j][k].setBackground(Color.decode("#57b400"));
                    }
                }
                try {
                    pathway_Special_To_Room5_Out();
                } catch (IOException ex) {
                    Logger.getLogger(OFFICE.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        thread1.start();
    }
    /**
     * Pathway algorithm from Room 5 out to end of GUI
     * @throws IOException 
     */
    public void pathway_Special_To_Room5_Out() throws IOException {
        Marker var = new Marker(specialPersonImg);
        Thread thread1;
        thread1 = new Thread() {
            @Override
            public void run() {
                int[][] f = {{1, 4}, {1, 5}, {1, 6}, {1, 7}, {1, 8}, {0, 8}};
                for (int i = 0; i < f.length; i++) {
                    System.out.println(i + "," + 7);
                    lbl[f[i][0]][f[i][1]].setBackground(Color.decode("#57b400"));
                    lbl[f[i][0]][f[i][1]].add(var, BorderLayout.LINE_START);
                    lbl[f[i][0]][f[i][1]].revalidate();
                    lbl[f[i][0]][f[i][1]].repaint();

                    if (i == 0) {
                        lbl[f[i][0]][f[i][1]].setBackground(Color.decode("#57b400"));
                    } else if (i > f.length) {
                        lbl[f[i][0]][f[i][1]].setBackground(Color.decode("#57b400"));
                        lbl[f[i - 1][0]][f[i][1]].setBackground(Color.gray);
                    } else if (i == f.length) {
                        lbl[f[i - 1][0]][f[i][1]].setBackground(Color.gray);
                    }
                    try {
                        Thread.sleep(500);
                    } catch (Exception e) {
                    }
                    lbl[f[i][0]][f[i][1]].setBackground(Color.gray);
                    lbl[f[i][0]][f[i][1]].remove(var);
                    lbl[f[i][0]][f[i][1]].revalidate();
                    lbl[f[i][0]][f[i][1]].repaint();
                }
            }

        };
        thread1.start();
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        OFFICE var = new OFFICE("");
        while (true) {
            var.pathway_Normal_To_Room1(1000);
            Thread.sleep(1000);
        }
    }
}

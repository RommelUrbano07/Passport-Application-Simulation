/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm;

import Simulation.Marker;
import Simulation.OFFICE;
import java.awt.BorderLayout;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nikki
 */
public class Algorithm {

    static Queue<String> Normal_Lane = new LinkedList();
    static Queue<String> Special_Lane = new LinkedList();
    static LinkedList<String> roomNameList = new LinkedList();
    static long timerModes[] = {100, 200, 300, 400, 500, 600, 700, 800, 900, 1000};
    //Timer for adding of queues
    static long holdModes[] = {8000, 9000, 10000, 11000};
    //Timer for meeting time
    static int rooms[] = {0, 0, 0, 0, 0, 0};
    //Rooms to be checked
    private static int index = -1;
    //Initial Value for room checking
    public static int NormalLaneSize = 0;
    //Size of Normal Queue
    public static int SpecialLaneSize = 0;
    //Size of Special Queue
    static String normalPersonImg="C:\\Users\\Asus\\Downloads\\Algorithm\\Algorithm\\src\\Simulation\\normal1.png";
    //Pathway of Normal Image
    static String specialPersonImg="C:\\Users\\Asus\\Downloads\\Algorithm\\Algorithm\\src\\Simulation\\pwd5.png";
    //Pathway of Normal Image
    
    
    /**
     * Adding of Normal Customers in Normal Lane
     * @param temp 
     */
    public static void NormalQueue(OFFICE temp) {
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                try {
                    while (true) {
                        Thread.sleep(timerModes[new Random().nextInt(timerModes.length)]);
                        Marker var = new Marker(normalPersonImg);
                        //Marker contains the image for the customer icon
                        if (Normal_Lane.size() < NormalLaneSize) {
                            Normal_Lane.add("Normal Customer");
                            System.out.println("Normal Customer Added");
                            if (OFFICE.n2 < 6) {
                                OFFICE.lbl[OFFICE.n1][OFFICE.n2].add(var, BorderLayout.LINE_START);
                                OFFICE.lbl[OFFICE.n1][OFFICE.n2].revalidate();
                                OFFICE.lbl[OFFICE.n1][OFFICE.n2].repaint();
                                OFFICE.n2++;
                            } else {
                                OFFICE.n2 = 0;
                                OFFICE.n1++;
                                OFFICE.lbl[OFFICE.n1][OFFICE.n2].add(var, BorderLayout.LINE_START);
                                OFFICE.lbl[OFFICE.n1][OFFICE.n2].revalidate();
                                OFFICE.lbl[OFFICE.n1][OFFICE.n2].repaint();
                                OFFICE.n2++;
                            }
                        } else {
                            System.out.println("Normal Queue Full");
//                            break;
                        }

                        Thread.sleep(timerModes[new Random().nextInt(timerModes.length)]);
                        removeNormalLane(temp);
//                        Thread.sleep(500);
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        };
        thread1.start();
    }
    
    
    /**
     * Adding of Special Customers in Special Lane
     * @param temp 
     */
    public static void SpecialQueue(OFFICE temp) {
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                try {
                    while (true) {
                        Thread.sleep(timerModes[new Random().nextInt(timerModes.length)]);
                        Marker var = new Marker(specialPersonImg);
                        //Marker contains the image for the customer icon
                        if (Special_Lane.size() < SpecialLaneSize) {
                            Special_Lane.add("Special Customer");
                            System.out.println("Special Customer Added");
                            if (OFFICE.s2 < 16) {
                                OFFICE.lbl[OFFICE.s1][OFFICE.s2].add(var, BorderLayout.LINE_START);
                                OFFICE.lbl[OFFICE.s1][OFFICE.s2].revalidate();
                                OFFICE.lbl[OFFICE.s1][OFFICE.s2].repaint();
                                OFFICE.s2++;
                            } else {
                                OFFICE.s2 = 10;
                                OFFICE.s1++;
                                OFFICE.lbl[OFFICE.s1][OFFICE.s2].add(var, BorderLayout.LINE_START);
                                OFFICE.lbl[OFFICE.s1][OFFICE.s2].revalidate();
                                OFFICE.lbl[OFFICE.s1][OFFICE.s2].repaint();
                                OFFICE.s2++;
                            }
                        } else {
                            System.out.println("Special Queue Full");
//                            break;
                        }

                        Thread.sleep(timerModes[new Random().nextInt(timerModes.length)]);
//                        Thread.sleep(100);
                        removeSpecialLane(temp);
                        removeSpecialLane(temp);
                    }
                } catch (Exception e) {
                    System.out.println("Special Queue Full");
                }
            }
        };
        thread1.start();
    }

    /**
     * Method of checking room availability
     * @return 
     */
    public static int findRoom() {
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                boolean temp = false;
                for (int i = 0; i < rooms.length; i++) {
//            if (rooms[i] == 0) {
//                return i;
//            }
                    if (rooms[i] == 0) {
                        index = i;
                        temp = false;
                        break;
                    } else {
                        temp = true;
                    }
                }
//        return -1;
                if (temp) {
                    index = -1;
                }
            }
        };
        thread1.start();
        return index;
    }
    
    /**
     * Identification of Normal Room Pathways
     * @param var
     * @param room
     * @param hold
     * @throws IOException 
     */
    public static void IdentifyPathNormal(OFFICE var, int room, long hold) throws IOException {
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                if (room == 0) {
                    try {
                        var.pathway_Normal_To_Room1(hold);
                    } catch (IOException ex) {
                        Logger.getLogger(Algorithm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (room == 1) {
                    try {
                        var.pathway_Normal_To_Room2(hold);
                    } catch (IOException ex) {
                        Logger.getLogger(Algorithm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (room == 2) {
                    try {
                        var.pathway_Normal_To_Room3(hold);
                    } catch (IOException ex) {
                        Logger.getLogger(Algorithm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (room == 3) {
                    try {
                        var.pathway_Normal_To_Room4(hold);
                    } catch (IOException ex) {
                        Logger.getLogger(Algorithm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (room == 4) {
                    try {
                        var.pathway_Normal_To_Room5(hold);
                    } catch (IOException ex) {
                        Logger.getLogger(Algorithm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (room == 5) {
                    try {
                        var.pathway_Normal_To_Room6(hold);
                    } catch (IOException ex) {
                        Logger.getLogger(Algorithm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
        thread1.start();

    }

    /**
     * Identification of Special Room Pathway
     * @param var
     * @param room
     * @param hold
     * @throws IOException 
     */
    public static void IdentifyPathSpecial(OFFICE var, int room, long hold) throws IOException {
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                if (room == 0) {
                    try {
                        var.pathway_Special_To_Room1(hold);
                    } catch (IOException ex) {
                        Logger.getLogger(Algorithm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (room == 1) {
                    try {
                        var.pathway_Special_To_Room2(hold);
                    } catch (IOException ex) {
                        Logger.getLogger(Algorithm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (room == 2) {
                    try {
                        var.pathway_Special_To_Room3(hold);
                    } catch (IOException ex) {
                        Logger.getLogger(Algorithm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (room == 3) {
                    try {
                        var.pathway_Special_To_Room4(hold);
                    } catch (IOException ex) {
                        Logger.getLogger(Algorithm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (room == 4) {
                    try {
                        var.pathway_Special_To_Room5(hold);
                    } catch (IOException ex) {
                        Logger.getLogger(Algorithm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (room == 5) {
                    try {
                        var.pathway_Special_To_Room6(hold);
                    } catch (IOException ex) {
                        Logger.getLogger(Algorithm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
        thread1.start();

    }
    
    /**
     * Removal of Normal Queue when room is available
     * @param var 
     */
    public static void removeNormalLane(OFFICE var) {
        //Marker contains the image for the customer icon
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                int temp = findRoom();
                if (temp == -1) {
                    System.out.println("Rooms Full");
                } else {
                    try {
                        long hold = holdModes[new Random().nextInt(holdModes.length)];
                        if (Normal_Lane.size() > 0) {
                            if (OFFICE.n1 > 24) {
                                Normal_Lane.remove();
                                System.out.println("Normal Customer Release");
                                rooms[temp] = 1;
                                if (OFFICE.n2 == 0) {
                                    OFFICE.n1--;
                                    OFFICE.n2 = 6;
                                }
                                OFFICE.lbl[25][0].removeAll();
                                OFFICE.lbl[25][0].repaint();
                                OFFICE.lbl[25][0].revalidate();
                                System.out.println(OFFICE.n2);
                                System.out.println(OFFICE.n1);
                                IdentifyPathNormal(var, temp, hold);
                                index = -1;
                                Thread.sleep(500);
                                OFFICE.n2--;
                                OFFICE.lbl[OFFICE.n1][OFFICE.n2].removeAll();
                                OFFICE.lbl[OFFICE.n1][OFFICE.n2].repaint();
                                OFFICE.lbl[OFFICE.n1][OFFICE.n2].revalidate();
                                if (OFFICE.n2 != 0) {
                                    OFFICE.lbl[25][0].add(new Marker(normalPersonImg));
                                    OFFICE.lbl[25][0].repaint();
                                    OFFICE.lbl[25][0].revalidate();
                                }
                                Thread.sleep(hold);
//                            Thread.sleep(100);
                                System.out.println("Room Clear");
                                rooms[temp] = 0;
                            }
                        }
                    } catch (Exception e) {
                        System.out.println("No Normal Customer Found");
                        removeSpecialLane(var);
                    }
                }
            }
        };
        thread1.start();
    }
    
    /**
     * Removal of Special Queue when room is available
     * @param var 
     */
    public static void removeSpecialLane(OFFICE var) {
        //Marker contains the image for the customer icon
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                int temp = findRoom();
                if (temp == -1) {
                    System.out.println("Rooms Full");
                } else {
                    try {
                        long hold = holdModes[new Random().nextInt(holdModes.length)];
                        if (Special_Lane.size() > 0) {
                            if (OFFICE.s1 > 24) {
                                Special_Lane.remove();
                                System.out.println("Special Customer Release");
                                rooms[temp] = 1;
                                if (OFFICE.s2 == 10) {
                                    OFFICE.s1--;
                                    OFFICE.s2 = 16;
                                }
                                OFFICE.lbl[25][10].removeAll();
                                OFFICE.lbl[25][10].repaint();
                                OFFICE.lbl[25][10].revalidate();
                                System.out.println(OFFICE.s2);
                                System.out.println(OFFICE.s1);
                                IdentifyPathSpecial(var, temp, hold);
                                index = -1;
                                Thread.sleep(500);
                                OFFICE.s2--;
                                OFFICE.lbl[OFFICE.s1][OFFICE.s2].removeAll();
                                OFFICE.lbl[OFFICE.s1][OFFICE.s2].repaint();
                                OFFICE.lbl[OFFICE.s1][OFFICE.s2].revalidate();
                                if (OFFICE.s2 != 10) {
                                    OFFICE.lbl[25][10].add(new Marker(specialPersonImg));
                                    OFFICE.lbl[25][10].repaint();
                                    OFFICE.lbl[25][10].revalidate();
                                }
                                Thread.sleep(hold);
//                            Thread.sleep(100);
                                System.out.println("Room Clear");
                                rooms[temp] = 0;

                            }
                        }
                    } catch (Exception e) {
                        System.out.println("No Special Customer Found");
                        removeNormalLane(var);
                    }
                }
            }
        };
        thread1.start();
    }

    public static void run() throws InterruptedException, IOException {
        OFFICE var = new OFFICE("DEPARTMENT OF FOREIGN AFFAIRS PASSPORT SIMULATION");
        Algorithm.NormalQueue(var);
        Algorithm.SpecialQueue(var);
    }
}

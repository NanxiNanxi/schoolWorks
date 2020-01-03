/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab8_threads;

/**
 *
 * @author zhou6718
 */
import java.util.Scanner;
import java.util.concurrent.*;
import jdk.nashorn.internal.codegen.CompilerConstants;

public class Track {

    static Horse[] horses = new Horse[6];
    static Scanner k = new Scanner(System.in);

    public static void main(String[] args) {
        horses[0] = new Horse("h1");
        horses[0].setFrontrunner(true);
        horses[0].setMudder(true);
        horses[1] = new Horse("h2");
        horses[1].setBobbler(true);
        horses[2] = new Horse("h3");
        horses[2].setFalterer(true);
        horses[2].setMudder(true);
        horses[3] = new Horse("h4");
        horses[3].setFrontrunner(true);
        horses[3].setFalterer(true);
        horses[4] = new Horse("h5");
        horses[4].setSleepy(true);
        horses[5] = new Horse("h6");
        horses[5].setHopped(true);

        ExecutorService race = Executors.newFixedThreadPool(6);
        for (int i = 0; i < horses.length; i++) {
            race.execute(horses[i]);
        }
    }
}

class Horse extends Thread implements Runnable {

    public static volatile int[] position = new int[4]; // 1 0 0 0 2 0 0 0 1100 
    private String horseName;
    private boolean frontrunner = false;  //fast out of the gate
    private boolean bobbler = false; //slow out of the gate
    private boolean mudder = false; //runs well in the mud
    private boolean falterer = false; //slows at the end of a race
    private boolean sleepy = false; //falls asleep on the track sometimes
    private boolean hopped = false; //on steroids 

    public Horse(String name) {
        this.horseName = name;

    }

    public String getHorseName() {
        return this.horseName;
    }

    public void setHorseName(String name) {
        this.horseName = name;
    }

    public boolean isFrontrunner() {
        return frontrunner;
    }

    public void setFrontrunner(boolean frontrunner) {
        if (this.bobbler == false) {
            this.frontrunner = frontrunner;
        }

    }

    public boolean isBobbler() {
        return bobbler;
    }

    public void setBobbler(boolean bobbler) {
        if (this.frontrunner == false) {
            this.bobbler = bobbler;
        }

    }

    public boolean isMudder() {
        return mudder;
    }

    public void setMudder(boolean mudder) {
        this.mudder = mudder;
    }

    public boolean isFalterer() {
        return falterer;
    }

    public void setFalterer(boolean falterer) {
        this.falterer = falterer;
    }

    public boolean isSleepy() {
        return sleepy;
    }

    public void setSleepy(boolean sleepy) {
        this.sleepy = sleepy;
    }

    public boolean isHopped() {
        return hopped;
    }

    public void setHopped(boolean hopped) {
        this.hopped = hopped;
    }

    public int incrementPosition(int leg) {//valu of leg 0 1 2 or 3
        return position[leg]++;
    }

    public int getPosition(int leg) {
        return position[leg];
    }

    public void getSleep() {
        if (this.isSleepy()) {
            int x = (int) (Math.random() * 10) + 1;
            if (x <= 2) {
                System.out.println("\nOh no! "
                        + this.horseName + " is asleep on the track!");
                try {
                    Thread.sleep(500);
                    System.out.println("\n"
                            + this.horseName + " is now awake and back in the race!\n");
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public void run() {
        if (this.isHopped()) {
            setPriority(8);
            System.out.println(this.horseName + " seems full of energy today\n");
        }
        System.out.println(this.horseName + " is out of the gate");
        //1st leg
        getSleep();
        if (this.frontrunner) {
            for (int i = 0; i < 200000000; i++);
        } else if (this.frontrunner == false && this.bobbler == false) {
            for (int i = 0; i < 200000000; i++);
        } else if (this.bobbler) {
            for (int i = 0; i < 200000000; i++);
        }
        incrementPosition(0);
        System.out.println(this.getHorseName() + " is finished the first leg at position " + getPosition(0) + "!");

        //2nd leg
        getSleep();
        if (this.mudder) {
            for (int i = 0; i < 120000000; i++);
        } else if (this.mudder == false) {
            for (int i = 0; i < 200000000; i++);
        }
        incrementPosition(1);
        System.out.println(this.getHorseName() + " is finished the second leg at position " + getPosition(1) + "!");

        //3nd leg
        getSleep();
        if (this.falterer) {
            for (int i = 0; i < 250000000; i++);
        } else if (this.falterer == false) {
            for (int i = 0; i < 200000000; i++);
        }
        incrementPosition(2);
        System.out.println(this.getHorseName() + " is finished the third leg at position " + getPosition(2) + "!");

        //4th leg
        getSleep();
        if (this.falterer) {
            for (int i = 0; i < 300000000; i++);
        } else if (this.falterer == false) {
            for (int i = 0; i < 200000000; i++);
        }
        incrementPosition(3);
        System.out.println(this.getHorseName() + " is finished the race at position " + getPosition(3) + "!");
    }
}

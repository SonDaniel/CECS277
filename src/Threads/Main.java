/*
    Daniel Son
    April 25, 2016
    Purpose: There are two classes within Main. The purpose of this file is to create 3 or more animals
    with a speed and rest factor. They all get their own thread to work with and will execute and finish
    a race. The purpose of this assignment is to show the behavior of Threads.
    Inputs: Hardcode values. no input from user.
    Output: Console output of the progress of the race.
 */

package Threads;

/**
 * The main class serves as the start of the program. It will initialize variables and start threads.
 */
public class Main{
    //create a global private variable
    private static int count; //count variable is mainly used for rank

    /**
     * The main function is the start of the program.
     * @param args allows arguments to pass by.
     */
    public static void main(String[] args){
        //initialize variables
        count = 0;
        double length = 100;
        int laps = 2;

        //create objects for the animals and pass hardcode data
        Animals animal_1 = new Animals("dog", 14.5, 400,length, laps);
        Animals animal_2 = new Animals("cat", 20.3, 1000,length, laps);
        Animals animal_3 = new Animals("lizard", 15.9, 430,length, laps);

        //make objects into thread objects
        Thread one = new Thread(animal_1);
        Thread two = new Thread(animal_2);
        Thread three = new Thread(animal_3);

        //start threads
        one.start();
        two.start();
        three.start();

        while(one.isAlive() || two.isAlive() || three.isAlive()){
            //wait until threads are done
        }
        System.out.println("The race is over.");
    }

    /**
     * The class Animals implements Runnable. The class animal holds the traits of the animal in the race.
     * The Runnable implementation gives the animal thread capabilities.
     */
    static class Animals implements Runnable{
        private String name;
        private double speed;
        private long rest;
        private double total;
        private int laps;
        private int lapsCount;
        private double length;
        private boolean done;
        private int rank;

        /**
         * The Animals constructor takes in parameters and initializes variables
         * @param name the name of the animal
         * @param speed the speed of the animal
         * @param rest the thread sleep factor
         * @param length the length of the race
         * @param laps how many laps the animal needs to complete
         */
        public Animals(String name, double speed, long rest, double length, int laps){
            this.name = name;
            this.speed = speed;
            this.rest = rest;
            this.total = 0.0;
            this.laps = 0;
            this.length = length;
            this.laps = laps;
            this.lapsCount = 0;
            this.done = false;
            this.rank = 0;
        }

        /**
         * The function addDistance adds the speed to the total distance the animal ran
         */
        public void addDistance(){
            total += speed;
        }

        /**
         * The function addLap adds a lap for the animal
         */
        public void addLap(){
            lapsCount++;
        }

        /**
         * The function setRank sets the finish rank of the animal
         * @param count the rank of the animal
         */
        public void setRank(int count){
            rank = count;
        }

        @Override
        /**
         * The run function is created because Animal implements Runnable. The function is used for the Thread.
         * It is the main part of the race algorithm.
         */
        public void run(){
            //loops until animal completes the race
            while(!done){
                try{
                    //checks to see if the animal is done with the race
                    if(total >= length && laps == lapsCount){
                        count++; //increments counter value
                        setRank(count);
                        System.out.println(name + " has finished at " + count + " place.");
                        Thread.currentThread().interrupt();
                    }
                    else{
                        //adding distance for the animal
                        this.addDistance();
                        if(total >= length){
                            if(laps != lapsCount){
                                addLap();
                                total = 0;
                            }
                        }
                        System.out.println(name + " is at " + total + " out of " + length + " on lap " + lapsCount + " out of " + laps);
                    }
                    //rest factor
                    Thread.sleep(rest);
                }catch(InterruptedException io){
                    done = true;
                }
            }

        }
    }
}

/**
 * Paragraph on finding:
 * I found that when starting all the threads, there is no order to what thread executes. The threads have
 * their own timing and all. If a thread is finished executing, the other thread will continue to execute
 * until it is caught up. The rest factor plays also a big roll. In this example, the cat had a huge rest
 * factor and seeing in the console, you can see that the dog and lizard still execute while the cat's thread
 * sleeps. So the main thing i learned is that threads do not have a order they execute and the other threads
 * will still continue even when another thread sleeps.
 */
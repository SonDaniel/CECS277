//package Threads;
//
//public class Animals implements Runnable{
//    private String name;
//    private double speed;
//    private long rest;
//    private double total;
//    private int laps;
//    private int lapsCount;
//    private double length;
//    private boolean done;
//    private int rank;
//
//    public Animals(String name, double speed, long rest, double length, int laps){
//        this.name = name;
//        this.speed = speed;
//        this.rest = rest;
//        this.total = 0.0;
//        this.laps = 0;
//        this.length = length;
//        this.laps = laps;
//        this.lapsCount = 0;
//        this.done = false;
//        this.rank = 0;
//    }
//
//    public void setName(String name){
//        this.name = name;
//    }
//
//    public void setSpeed(double speed){
//        this.speed = speed;
//    }
//
//    public void setRest(long rest){
//        this.rest = rest;
//    }
//
//    public void addDistance(){
//        total += speed;
//    }
//
//    public void addLap(){
//        lapsCount++;
//    }
//
//    public void setRank(int count){
//        rank = count;
//    }
//
//    public int getRank(){
//        return rank;
//    }
//
//    public double getTotal(){
//        return total;
//    }
//
//    @Override
//    public void run(){
//        while(!done){
//            try{
//                if(total >= length && laps == lapsCount){
//                    System.out.println(name + " has finished at " + Thread.activeCount() + " place.");
//                    Thread.currentThread().interrupt();
//                }
//                else{
//                    this.addDistance();
//                    if(total >= length){
//                        if(laps != lapsCount){
//                            addLap();
//                            total = 0;
//                        }
//                    }
//                    System.out.println(name + " is at " + total + " out of " + length + " on lap " + lapsCount + " out of " + laps);
//                }
//                Thread.sleep(rest);
//            }catch(InterruptedException io){
//                done = true;
//            }
//        }
//
//    }
//}

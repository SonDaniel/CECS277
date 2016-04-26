package Lab;

import java.util.Scanner;

public class TestThreadMany implements Runnable {

    private static Thread thread;

    public static void main(String[] args) throws InterruptedException{
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter the number of threads you would like to create: ");
        int num = in.nextInt();

        for(int ii = 1; ii <= num; ii++) {
            Runnable run = new TestThreadMany();
            thread = new Thread(run);
            thread.start();
        }

    }

    public void run() {
        for(int ii=0; ii < 100;ii++){

            System.out.println("Hello I am " + thread.currentThread().getName());
            try{
                thread.sleep(1);
            }catch(InterruptedException io){
                io.printStackTrace();
            }
        }
    }
}

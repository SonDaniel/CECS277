package Finals;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FileReader {
    static int count;
    static Lock locker;
    static Thread thread;

    public static void main(String[] args) {

        Runnable process1 = new Process("hhgi10.txt");
        Runnable process2 = new Process("eliot-silas-242.txt");
        Runnable process3 = new Process("dracula.txt");
        Runnable process4 = new Process("badge10.txt");

        Stack<Runnable> stack = new Stack<>();
        stack.add(process1);
        stack.add(process2);
        stack.add(process3);
        stack.add(process4);

        locker = new ReentrantLock();

        for(int ii = 0; ii < 4; ii++){
            thread = new Thread(stack.pop());
            thread.start();
        }
    }

    static class Process implements Runnable{
        Scanner file;
        String fileName;
        public Process(String fileName){
            this.fileName = fileName;
            try{
                file = new Scanner(new File(fileName));
            }catch(FileNotFoundException io){
                io.printStackTrace();
            }
        }

        @Override
        public void run() {
            for(int ii = 0; ii < 2; ii++){
                int fileCount = 0;
                if(!file.hasNext()){
                    try{
                        file = new Scanner(new File(fileName));
                    }catch(FileNotFoundException io){
                        io.printStackTrace();
                    }
                }
                while(file.hasNext()){
                    fileCount++;
                    locker.lock();
                    count++;
                }
                System.out.println(fileName + ": " + fileCount);
                System.out.println("You have read " + count + " words so far.");
                locker.unlock();

                try{
                    thread.sleep(3000);
                }catch(InterruptedException interrupt){
                    interrupt.printStackTrace();
                }
            }
        }
    }

}
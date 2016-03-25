package Lab;

import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;

public class Midterm1 {
    public static void main(String[] args){

        try{
            String[] boysArray = new String[1000];
            String[] girlsArray = new String[1000];
            int counter = 0;

            File boyNames = new File("boyNames.txt");
            File girlNames = new File("girlNames.txt");
            File input = new File("babynames.txt");

            Scanner in = new Scanner(input);

            PrintWriter boyWrite = new PrintWriter(boyNames);
            PrintWriter girlWrite = new PrintWriter(girlNames);

            while(in.hasNext())
            {
                String rank = in.next();
                String boyName = in.next();
                String commonBoy = in.next();
                String boyPercentage = in.next();
                boysArray[counter] = boyName;

                String girlName = in.next();
                String commonGirl = in.next();
                String girlPercentage = in.next();
                in.nextLine();
                girlsArray[counter] = girlName;

                counter++;

                boyWrite.println(rank + " " + boyName + " " + commonBoy + " " + boyPercentage);

                girlWrite.println(rank + " " + girlName + " " + commonGirl + " " + girlPercentage);

            }

            boyWrite.close();
            girlWrite.close();
            in.close();

            System.out.println("Names of both boy and girls:");

            for(int ii = 0; ii < 1000; ii++)
            {
                for(int jj = 0; jj < 1000; jj++)
                {
                    if(boysArray[ii].equals(girlsArray[jj]))
                    {
                        System.out.println(boysArray[ii]);
                    }
                }
            }
        }
        catch(IOException file) {
            file.printStackTrace();
        }
        finally
        {
            System.out.println("exiting program...");
        }



    }

}

package Lab;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileIO {
    public static void main(String[] args) {

        try
        {
            java.io.File file = new java.io.File("ziptable.txt");
            java.io.File file2 = new java.io.File("result.txt");
            if (file2.exists()) {
                System.out.println("File already exists");
                System.out.println("Code will terminate.");
                System.exit(0);
            }


            Scanner in = new Scanner(file);

            java.io.PrintWriter output = new java.io.PrintWriter(file2);

            while(in.hasNextLine()){
                String line = in.nextLine();
                output.println(line);
            }

            System.out.println("Code has finished running.");
            output.close();
            in.close();
        }
        catch(FileNotFoundException notFound)
        {
            notFound.printStackTrace();
        }

    }
}

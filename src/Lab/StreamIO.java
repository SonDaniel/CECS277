package Lab;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class StreamIO {

    public static void main(String[] args) throws IOException{

        FileInputStream inputStream = new FileInputStream("labchapter20.docx");
        PrintWriter outputStream = new PrintWriter("streamIOLab.dat");
        int counter = 0;
        int inputSize = inputStream.available();
        for(int ii = 0; ii < inputSize; ii++){
            int next = inputStream.read();
            outputStream.print((char) next);
            if(next >= 32 && next <= 126){
                outputStream.print((char) next);
                counter++;
                if(counter % 64 == 0){
                    counter = 0;
                    outputStream.println();
                }
            }
        }

        inputStream.close();
        outputStream.close();
    }
}

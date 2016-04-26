package Lab;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import java.util.Date;
import javax.swing.JOptionPane;

public class Lab_ch10{
    public static void main(String[] args){

        CurrentTimePrinter time = new CurrentTimePrinter();
        testClass time2 = new testClass();
        Timer timing2 = new Timer(1000, time2);
        Timer timing = new Timer(1000, time);
        timing.start();
        timing2.start();

        JOptionPane.showMessageDialog(null, "Quit?");
        System.exit(0);
    }

    public static class CurrentTimePrinter implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            System.out.println(new Date());
        }
    }

    public static class testClass implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Test");
        }
    }

}


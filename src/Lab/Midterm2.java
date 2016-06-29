package Lab;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Midterm2 {
    private static final int MAIN_WIDTH = 200;
    private static final int MAIN_HEIGHT = 300;

    public static void main(String[] args){
        //creating frame object
        JFrame main = new JFrame();
        //setting frame dimensions
        main.setSize(MAIN_WIDTH,MAIN_HEIGHT);
        //creating the mouse listener
        MouseListener listener = new CursorListener();
        //adding mouse listener to frame
        main.addMouseListener(listener);

        //setting frame title, exit command, and visibility as true
        main.setTitle("Midterm 2");
        main.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        main.setVisible(true);

    }

    private static class CursorListener implements MouseListener{

        public void mouseEntered(MouseEvent event){
            System.out.println("Mouse Entered");
        }
        public void mouseExited(MouseEvent event){
            System.out.println("Mouse Exited");
        }

        //mousePressed, mouseReleased, mouseClicked not needed
        public void mousePressed(MouseEvent event){}
        public void mouseReleased(MouseEvent event){}
        public void mouseClicked(MouseEvent event){}
    }
}

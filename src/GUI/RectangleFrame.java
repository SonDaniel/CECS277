/*
    Daniel Son
    March 21, 2016
    Purpose: This class contains the properties of the game frame. It will create and show the score for the user.
    It will initiate a java panel for the image to reside in.
    Inputs: The user's click.
    Output: The score and the image that user chooses.
 */

package GUI;

//library imports
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.imageio.ImageIO;
import java.awt.event.MouseEvent;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.awt.event.MouseListener;

/**
 * The RectangleFrame extends JFrame and will create the Jpanel for the image to reside in, a score display and menu.
 */
public class RectangleFrame extends JFrame{
    private static final int FRAME_WIDTH = 600;
    private static final int FRAME_HEIGHT = 500;
    private static int score = 0;
    private Image image;
    private JLabel scoreLabel;
    private RectangleComponent scene;
    private static int delay = 1000;
    private static Timer t;

    /**
     * The RectangleFrame function is the constructor that creates the game interface. It will make image 1 as default.
     * The constructor will add a menu bar to the main frame as well as a score bar that is updated.
     */
    public RectangleFrame(){
        try{
            //image 1 on default start
            image = ImageIO.read(new File("src/GUI/image1.jpg"));
            //scene is the image of the game
            scene = new RectangleComponent(image);

            //jpanel that is for the image to reside in
            Container pane = getContentPane();
            pane.add(scene);
            setContentPane(pane);
            //creating a menu bar for the main frame
            MyMenuBar menu = new MyMenuBar();
            menu.add(menu.getMenu());

            //creating a score bar for the main frame
            scoreLabel = new JLabel("Score: 0");
            scoreLabel.setHorizontalAlignment(JLabel.CENTER);

            //adding the score bar, image, and menu bar. setting frame size.
            setLayout(new BorderLayout(2,1));
            add(scoreLabel, BorderLayout.SOUTH);
            add(scene, BorderLayout.CENTER);
            add(menu, BorderLayout.NORTH);
            setSize(FRAME_WIDTH, FRAME_HEIGHT);

            //creating listeners for the mouse clicks and timer.
            ActionListener listener = new TimerListener();
            MouseListener scoreKeeper = new ScoreListener();

            //giving image a click listener
            scene.addMouseListener(scoreKeeper);

            //creating a timer and starting.
            t = new Timer(delay, listener);
            t.start();

        }catch(IOException io){
            io.printStackTrace(); //printing out any io errors.
        }

    }

    /**
     * The function checkScore will check to see if the score is greater than 15, 10 or 5.
     * If score is greater than these set values, the image will generate faster.
     */
    public static void checkScore(){
        if(score >= 15){
            delay = 10;
            t.setDelay(delay);
        }
        else if(score >= 10){
            delay = 100;
            t.setDelay(delay);
        }
        else if(score >= 5){
            delay = 500;
            t.setDelay(delay);
        }

    }

    /**
     * The class TimeListener implements the ActionListener. As the timer goes, the image is repainted in the Jpanel.
     */
    class TimerListener implements ActionListener {
        /**
         * The actionPerformed function will get the timer and generate the image each time the timer ticks.
         * @param event The event of the action of the timer.
         */
        public void actionPerformed(ActionEvent event){
            scene.repaint(); //regenerating the image in the panel.
        }
    }

    /**
     * The class ScoreListener implements the MouseListener. When mouse click is detected, function will execute and
     * calculate to see if click is within image. If it is, score is incremented and updated.
     */
    class ScoreListener implements  MouseListener{
        /**
         * The mousePressed function will execute when mouse is clicked and check to see if mouse is within image.
         * If click is within image, score in incremented, checked, updated.
         * @param event The event of the action of the mouse clicked.
         */
        public void mousePressed(MouseEvent event){
            if(event.getX() <= (scene.getDimensionX() + scene.getPositionX()) && event.getX() >= scene.getPositionX()) {
                if(event.getY() <= (scene.getDimensionY() + scene.getPositionY()) && event.getY() >= scene.getPositionY()){
                    score++;
                    checkScore(); //checks to see if score is greater than 5,10,15.
                    scoreLabel.setText("Score: " + score);
                    scene.repaint(); //repaint image so user cannot double click image.
                }
            }
        }

        /**
         * The functions mouseReleased, mouseClicked, mouseEntered, and mouseExited is not used but declared to
         * implement MouseListener.
         * @param event The action of the mouse.
         */
        public void mouseReleased(MouseEvent event){}
        public void mouseClicked(MouseEvent event){}
        public void mouseEntered(MouseEvent event){}
        public void mouseExited(MouseEvent event){}
    }

    /**
     * The MyMenuBar class extends JMenuBar. The class will create a menu bar of three options. The three options will
     * display the images of each choice.
     */
    public class MyMenuBar extends JMenuBar{

        private JMenu menu;
        private JMenuItem image1;
        private JMenuItem image2;
        private JMenuItem image3;

        /**
         * The MyMenuBar function is a constructor that creates the three options and gives them images to display.
         */
        public MyMenuBar(){
            //initialize menu and menuItems
            menu = new JMenu("Menu");
            image1 = new JMenuItem("Image 1");
            image2 = new JMenuItem("Image 2");
            image3 = new JMenuItem("Image 3");

            MenuListener listener = new MenuListener();

            //adding action listeners to menu items
            image1.addActionListener(listener);
            image2.addActionListener(listener);
            image3.addActionListener(listener);

            //initialize imageIcon
            ImageIcon icon1 = new ImageIcon();
            ImageIcon icon2 = new ImageIcon();
            ImageIcon icon3 = new ImageIcon();

            try{
                //get image from directory
                Image pic1 = ImageIO.read(new File("src/GUI/image1.jpg"));
                Image pic2 = ImageIO.read(new File("src/GUI/image2.jpg"));
                Image pic3 = ImageIO.read(new File("src/GUI/image3.jpg"));

                //resize images to fit menu bar
                Image scaled1 = pic1.getScaledInstance(50,60, Image.SCALE_DEFAULT);
                Image scaled2 = pic2.getScaledInstance(50,60, Image.SCALE_DEFAULT);
                Image scaled3 = pic3.getScaledInstance(50,60, Image.SCALE_DEFAULT);

                //set imageIcon to resized images
                icon1.setImage(scaled1);
                icon2.setImage(scaled2);
                icon3.setImage(scaled3);

                //set menuItems to imageIcons
                image1.setIcon(icon1);
                image2.setIcon(icon2);
                image3.setIcon(icon3);

                //add menuItems to menu
                menu.add(image1);
                menu.add(image2);
                menu.add(image3);

            }catch(IOException io){
                io.printStackTrace(); //print out the io error.
            }
        }

        /**
         * The getMenu function will return the menu that was constructed.
         * @return the menu of the game
         */
        public JMenu getMenu(){
            return menu;
        }

        /**
         * The MenuListener class implements ActionListener. When an option is selected, the listener will execute
         * the function actionPerformed and choose the image and switch the current image with the selected image.
         */
        class MenuListener implements ActionListener{
            /**
             * The function actionPerformed is executed when menu option is selected. It will replace the current image
             * for the selected image.
             * @param e action of choosing a menu option.
             */
            public void actionPerformed(ActionEvent e){
                String command = e.getActionCommand();
                if(command.equals("Image 1")){
                    try{
                        image = ImageIO.read(new File("src/GUI/image1.jpg"));
                        scene.setImage(image);
                    }
                    catch(IOException io){
                        io.printStackTrace();
                    }
                    }
                else if(command.equals("Image 2")){
                    try{
                        image = ImageIO.read(new File("src/GUI/image2.jpg"));
                        scene.setImage(image);
                    }
                    catch(IOException io){
                        io.printStackTrace();
                    }
                }
                else{
                    try{
                        image = ImageIO.read(new File("src/GUI/image3.jpg"));
                        scene.setImage(image);
                    }
                    catch(IOException io){
                        io.printStackTrace();
                    }
                }
            }
        }
    }
}

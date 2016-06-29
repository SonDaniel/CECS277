/*
    Daniel Son
    March 21, 2016
    Purpose: This class contains the properties of the image in the JPanel. It will repaint the image in the JPanel.
             Also return the x and y coordinates of the image.
    Inputs: There is no inputs.
    Output: The image of the game.
 */
package GUI;

import java.awt.*;
import javax.swing.*;
import java.awt.Image;
import java.util.Random;

/**
 * The RectangleComponent class extends JPanel. The class holds the information of the image within the JPanel and
 * repaints the image when called.
 */
public class RectangleComponent extends JPanel{
    private static int positionX = 2;
    private static int positionY = 2;
    private static int dimensionX = 100;
    private static int dimensionY = 150;
    private static Random generate;
    private Image box;

    /**
     * The RectangleComponent function is a constructor and will store the image passed in and initialize the Random generator.
     * @param img The image that will be stored
     */
    public RectangleComponent(Image img){
        box = img;
        generate = new Random();
    }

    /**
     * The function paintComponent will paint the image in the JPanel and also generate a random spot for the image to reside.
     * @param g
     */
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        if(box != null){
            generateRandom(); //creates random spot for image
            g.drawImage(box, positionX, positionY,dimensionX,dimensionY, this); //draws image
        }
        else{
            System.out.println("null"); //makes sure image is present
        }

    }

    /**
     * The generateRandom function will create a random position for the image.
     */
    public void generateRandom(){
        positionX = generate.nextInt(this.getWidth() - dimensionX);
        positionY = generate.nextInt(this.getHeight() - dimensionY);
    }

    /**
     * The getDimensionX will return the width of the image
     * @return an int value of the width
     */
    public int getDimensionX(){
        return dimensionX;
    }

    /**
     * The getDimensionY will return the height of the image
     * @return an int value of the height
     */
    public int getDimensionY(){
        return dimensionY;
    }

    /**
     * The getPositionX will return the x axis position of the image
     * @return an int value of the x position of the image
     */
    public int getPositionX(){
        return positionX;
    }

    /**
     * The getPositionY will return the y axis position of the image
     * @return an int value of the x position of the image
     */
    public int getPositionY(){
        return positionY;
    }

    /**
     * The setImage function will allow the program to change the image to the input image.
     * @param image the image that will change the current image
     */
    public void setImage(Image image){
        box = image;
    }
}

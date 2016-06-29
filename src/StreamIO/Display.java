/*
    Daniel Son
    April 17, 2016
    Purpose: The purpose of this file is to draw the ice cream components into the main JFrame.
    Inputs: AdvancedIceCreamCone object that is given by main frame
    Output: The ice cream gui drawn components
 */
package StreamIO;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * Display class extends JPanel. The class is used for drawing the display for the user.
 */
public class Display extends JPanel {

    private AdvancedIceCreamCone userIceCream;
    private int[] regularConeXPoints = {200,210,220,220,270,270,280,290};
    private int[] regularConeYPoints = {200,230,230,270,270,230,230,200};
    private int[] sugarConeXPoints = {200,245,245,290};
    private int[] sugarConeYPoints = {200,290,290,200};

    /**
     * Constructor that takes in AdvancedIceCreamCone object to save initially
     * @param userIceCream
     */
    public Display(AdvancedIceCreamCone userIceCream){
        this.userIceCream = userIceCream;

    }

    /**
     * The paintComponent is needed for repainting the JPanel
     * @param g
     */
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        //switch case to check to see what cone user wanted and then draw component
        String cone = userIceCream.getTypeOfCone();
        switch(cone){
            case "regular":
                g.setColor(Color.ORANGE);
                g.fillPolygon(regularConeXPoints,regularConeYPoints, regularConeXPoints.length);
                break;
            case "sugar":
                g.setColor(Color.ORANGE);
                g.fillPolygon(sugarConeXPoints,sugarConeYPoints,sugarConeXPoints.length);
                break;
            case "waffle":
                g.setColor(new Color(210,105,30));
                g.fillPolygon(sugarConeXPoints,sugarConeYPoints,sugarConeXPoints.length);
                g.setColor(new Color(210,140,30));
                g.drawLine(200,200,285,210);
                g.drawLine(205,205,283,215);
                g.drawLine(207,210,280,220);
                g.drawLine(209,215,277,225);
                g.drawLine(211,220,274,230);
                g.drawLine(213,225,271,235);
                g.drawLine(215,230,269,240);
                g.drawLine(217,235,266,245);
                g.drawLine(219,240,263,250);
                g.drawLine(225,245,260,255);
                g.drawLine(229,250,256,260);
                g.drawLine(231,255,257,265);
                g.drawLine(233,260,255,270);
                g.drawLine(235,265,253,275);
                g.drawLine(238,270,250,280);

                break;

            default:
                //should be nothing due to case padding
                break;
        }

        //checks to see what flavor user chooses and then draws
        String flavor = userIceCream.getFlavor();
        switch(flavor){
            case "vanilla":
                if(userIceCream.getNumberOfScoops() > 1){
                    int yPoint = 150;
                    g.setColor(Color.WHITE);
                    g.fillArc(200,yPoint,90,100,0,180);
                    for(int ii = 1; ii < userIceCream.getNumberOfScoops(); ii++){
                        yPoint -= 50;
                        g.fillArc(200,yPoint,90,100,-45,270);
                    }
                }
                else{
                    g.setColor(Color.WHITE);
                    g.fillArc(200,150,90,100,0,180);
                }

                break;
            case "chocolate":
                if(userIceCream.getNumberOfScoops() > 1){
                    int yPoint = 150;
                    g.setColor(new Color(156, 93, 82));
                    g.fillArc(200,yPoint,90,100,0,180);
                    for(int ii = 1; ii < userIceCream.getNumberOfScoops(); ii++){
                        yPoint -= 50;
                        g.fillArc(200,yPoint,90,100,-45,270);
                    }
                }
                else{
                    g.setColor(new Color(156, 93, 82));
                    g.fillArc(200,150,90,100,0,180);
                }

                break;

            case "strawberry":
                if(userIceCream.getNumberOfScoops() > 1){
                    int yPoint = 150;
                    g.setColor(Color.PINK);
                    g.fillArc(200,yPoint,90,100,0,180);
                    for(int ii = 1; ii < userIceCream.getNumberOfScoops(); ii++){
                        yPoint -= 50;
                        g.fillArc(200,yPoint,90,100,-45,270);
                    }
                }
                else{
                    g.setColor(Color.PINK);
                    g.fillArc(200,150,90,100,0,180);
                }
                break;
            default:
                //should be nothing due to case padding
                break;
        }

        //creating random num generator for toppings
        Random randomNum = new Random();

        //check to see if user selected Sprinkles and if so, then draw the component
        if(userIceCream.getSprinkleColor() != null){
            g.setColor(userIceCream.getSprinkleColor());
            if(userIceCream.getNumberOfScoops() == 3){
                for(int ii=0; ii < 10; ii++){
                    int x = randomNum.nextInt(80) + 200;
                    int y = randomNum.nextInt(50) + 50;
                    g.fillOval(x,y,3,8);
                }
            }
            else if(userIceCream.getNumberOfScoops() == 2){
                for(int ii=0; ii < 10; ii++){
                    int x = randomNum.nextInt(80) + 200;
                    int y = randomNum.nextInt(50) + 100;
                    g.fillOval(x,y,3,8);
                }
            }
            else{
                for(int ii=0; ii < 10; ii++){
                    int x = randomNum.nextInt(80) + 200;
                    int y = randomNum.nextInt(50) + 150;
                    g.fillOval(x,y,3,8);
                }
            }
        }

        //check to see if user choosed topping for chocolate chips
        if(userIceCream.getToppings().contains("Chocolate Chips")){
            g.setColor(new Color(156, 93, 122));
            if(userIceCream.getNumberOfScoops() == 3){
                for(int ii=0; ii < 10; ii++){
                    int x = randomNum.nextInt(80) + 200;
                    int y = randomNum.nextInt(50) + 50;
                    g.fillOval(x,y,4,4);
                }
            }
            else if(userIceCream.getNumberOfScoops() == 2){
                for(int ii=0; ii < 10; ii++){
                    int x = randomNum.nextInt(80) + 200;
                    int y = randomNum.nextInt(50) + 100;
                    g.fillOval(x,y,4,4);
                }
            }
            else{
                for(int ii=0; ii < 10; ii++){
                    int x = randomNum.nextInt(80) + 200;
                    int y = randomNum.nextInt(50) + 150;
                    g.fillOval(x,y,4,4);
                }
            }
        }
        //checks to see if user choosed peanuts and draws component
        if(userIceCream.getToppings().contains("Peanuts")){
            g.setColor(new Color(255,178,102));
            if(userIceCream.getNumberOfScoops() == 3){
                for(int ii=0; ii < 10; ii++){
                    int x = randomNum.nextInt(80) + 200;
                    int y = randomNum.nextInt(50) + 50;
                    g.fillOval(x,y,4,5);
                }
            }
            else if(userIceCream.getNumberOfScoops() == 2){
                for(int ii=0; ii < 10; ii++){
                    int x = randomNum.nextInt(80) + 200;
                    int y = randomNum.nextInt(50) + 100;
                    g.fillOval(x,y,4,5);
                }
            }
            else{
                for(int ii=0; ii < 10; ii++){
                    int x = randomNum.nextInt(80) + 200;
                    int y = randomNum.nextInt(50) + 150;
                    g.fillOval(x,y,4,5);
                }
            }
        }

        //checks to see if user choosed mochi and draws component
        if(userIceCream.getToppings().contains("Mochi")){
            g.setColor(Color.LIGHT_GRAY);
            if(userIceCream.getNumberOfScoops() == 3){
                for(int ii=0; ii < 10; ii++){
                    int x = randomNum.nextInt(80) + 200;
                    int y = randomNum.nextInt(50) + 50;
                    g.fillOval(x,y,7,7);
                }
            }
            else if(userIceCream.getNumberOfScoops() == 2){
                for(int ii=0; ii < 10; ii++){
                    int x = randomNum.nextInt(80) + 200;
                    int y = randomNum.nextInt(50) + 100;
                    g.fillOval(x,y,7,7);
                }
            }
            else{
                for(int ii=0; ii < 10; ii++){
                    int x = randomNum.nextInt(80) + 200;
                    int y = randomNum.nextInt(50) + 150;
                    g.fillOval(x,y,7,7);
                }
            }
        }


    }

    /**
     * storeUserPreference method is used to store a userIceCream object for display to use
     * as a data reference
     * @param userIceCream The userIceCream object that will be saved
     */
    public void storeUserPreference(AdvancedIceCreamCone userIceCream){
        this.userIceCream = userIceCream;
    }

}

/*
    Daniel Son
    April 17, 2016
    Purpose: AdvancedIceCreamCone is used as a data storage. It is used as an object to hold properties
    of the users ice cream.
    Inputs: data like: flavor, number of scoops, sprinkle colors, etc.
    Output: nothing is output.
 */

/* This class is used to model the properties and behaviors of an ice cream cone.
   There are currently restriction on the construction of the cone: only one
   flavor of ice cream is allowed and up to five toppings. You can only add scoops, you
   cannot remove them. */
package StreamIO;

import java.awt.*;
import java.io.Serializable;
import java.util.*;

public class AdvancedIceCreamCone implements Serializable {
    private int numberOfScoops;
    private String flavor;
    private String typeOfCone;
    private Color sprinkleColor;
    private ArrayList<String> toppings = new ArrayList<String>();


    //the default constructor creates a one scoop, vanilla ice cream cone using the regular type of cone and no toppings
    public AdvancedIceCreamCone() {
        numberOfScoops=1;
        flavor="vanilla";
        typeOfCone="regular";
        sprinkleColor = null;
    }
    /*this constructor lets you create an ice cream code to your liking. It takes in three parameters:
      the number of scoops, the flavor of the ice cream and the type of cone */
    public AdvancedIceCreamCone(int ns,String flv,String cone) {
        numberOfScoops=ns;
        flavor=flv;
        typeOfCone=cone;
    }
    //this method returns the number of scoops in the cone
    public int getNumberOfScoops () {
        return numberOfScoops;
    }
    //this method returns the ice cream flavor
    public String getFlavor() {
        return flavor;
    }
    //this method returns the type of cone
    public String getTypeOfCone() {
        return typeOfCone;
    }

    public void setNumberOfScoops(int num){
        numberOfScoops = num;
    }
    //this method allows you to change the ice cream flavor
    public void setFlavor(String flv) {
        flavor=flv;
    }
    //this method allows you to change the type of cone
    public void setTypeOfCone(String cone) {
        typeOfCone=cone;
    }
    //this method allows you to add  toppings
    public void addToppings(String top) {
        toppings.add(top);
    }

    public void removeTopping(String top){
        toppings.remove(top);
    }

    //this method returns a String with a list of the toppings
    public ArrayList<String> getToppings () {
        return toppings;
    }

    public void reset(){
        numberOfScoops=1;
        flavor="vanilla";
        typeOfCone="regular";
        toppings.clear();

    }

    public Color getSprinkleColor(){
        return sprinkleColor;
    }

    public void setSprinkleColor(Color color){
        sprinkleColor = color;
    }

    //this method overrides the inherited toString()
    public String toString() {
        return ("The number of scoops is " + numberOfScoops + ". The flavor is " +
                flavor + ". And the type of cone is " + typeOfCone + " and the toppings are: " + getToppings());
    }

}
/*
    Daniel Son
    February 14, 2016
    Purpose: This class takes GeometricObject as its parent. It is designed to represent a rectangle which
    can give its area as well as perimeter.
    Inputs: There is no inputs
    Output: will output the width, height, area, and perimeter if toString method is called.
 */

package IPI;

/**
 * This class rectangle takes GeometricObject as its parent. It has a default that makes
 * the width and height a default value of 1.0
 */
public class Rectangle extends GeometricObject{

    private double width;
    private double height;

    /**
     * Constructor that makes a default value of width and height 1.0
     */
    public Rectangle(){
        width = 1.0; //set default value to 1.0
        height = 1.0; //set default value to 1.0
    }

    /**
     * Constructor that sets the width and height by the given parameters
     * @param widthData data given to set width
     * @param heightData data given to set height
     */
    public Rectangle(double widthData, double heightData){
        width = widthData;
        height = heightData;
    }

    /**
     * setWidth function used to set or change the width of the object
     * @param widthData data given to set width
     */
    public void setWidth(double widthData){
        width = widthData;
    }

    /**
     * setHeight function used to set or change the height of the object
     * @param heightData data given to set height
     */
    public void setHeight(double heightData){
        height = heightData;
    }

    /**
     * getWidth function used to return the objects width
     * @return a double value of the width
     */
    public double getWidth(){
        return width;
    }

    /**
     * getHeight function used to return the objects height
     * @return a double value of the height
     */
    public double getHeight(){
        return height;
    }

    /**
     * getArea function used to return the objects area
     * @return a double value of the area of the object
     */
    public double getArea(){
        return width * height;
    }

    /**
     * getPerimeter function used to return the objects perimeter
     * @return a double value of the perimeter of the object
     */
    public double getPerimeter(){
        return (width * 2) + (height * 2);
    }

    /**
     * toString function used to return the data information of the object
     * @return a String that evokes the data of the object
     */
    public String toString(){
        return "Your width is: " + getWidth() + " and your height is: " + getHeight() + " with an area of: " + getArea() +
                " and with a perimeter of: " + getPerimeter();
    }
}

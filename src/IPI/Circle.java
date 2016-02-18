/*
    Daniel Son
    February 14, 2016
    Purpose: This class takes GeometricObject as its parent. It is designed to represent a circle which
    can give its area as well as perimeter.
    Inputs: There is no inputs
    Output: will output the radius, diameter, area, and perimeter if toString method is called.
 */

package IPI;

import java.lang.Math;

/**
 * This class Circle takes GeometricObject as its parent. It has a default that makes
 * the radius a default value of 1.0
 */
public class Circle extends GeometricObject {

    private double radius;

    /**
     * Constructor that makes radius default 1.0
     */
    public Circle(){
        radius = 1.0; //set default value to 1.0
    }

    /**
     * Constructor that takes the param and sets radius to its value
     * @param radiusData data given to set radius value
     */
    public Circle(double radiusData){
        radius = radiusData;
    }

    /**
     * setRadius function takes the param and sets/changes its value
     * @param radiusData data given to set radius value
     */
    public void setRadius(double radiusData){
        radius = radiusData;
    }

    /**
     * getRadius function returns the Circle objects radius
     * @return a double value of the radius of the circle object
     */
    public double getRadius(){
        return radius;
    }

    /**
     * getArea function computes the area of the circle object
     * @return a double value that represents the area of the circle object
     */
    public double getArea(){
        return Math.PI * Math.pow(radius,2);
    }

    /**
     * getPerimeter function computes the perimeter of the circle object
     * @return a double value that represents the perimeter of the circle object
     */
    public double getPerimeter(){
        return Math.PI * (radius * 2);
    }

    /**
     * getDiameter function computes the diameter of the circle object
     * @return a double value that represents the diameter of the cirlce object
     */
    public double getDiameter(){
        return radius * 2;
    }

    /**
     * toString function evokes the data of the circle object
     * @return a string with the details of the circle object
     */
    public String toString(){
        return "Your radius is: " + getRadius() +  " and Diameter is: " + getDiameter() +
                ". Your area is: " + getArea() + " and perimeter is: " + getPerimeter();
    }
}

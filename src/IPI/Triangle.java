/*
    Daniel Son
    February 14, 2016
    Purpose: This class takes GeometricObject as its parent. It is designed to represent a triangle which
    can give its area as well as perimeter.
    Inputs: There is no inputs
    Output: will output the three sides length, area, and perimeter if toString method is called.
 */

package IPI;

import java.lang.Math;

/**
 * This class Triangle takes GeometricObject as its parent. It has a default that makes
 * the three sides a default value of 1.0
 */
public class Triangle extends GeometricObject {

    private double side1;
    private double side2;
    private double side3;

    /**
     * Constructor that sets all three sides a default of 1.0
     */
    public Triangle(){
        side1 = 1.0; //set default value to 1.0
        side2 = 1.0; //set default value to 1.0
        side3 = 1.0; //set default value to 1.0
    }

    /**
     * Constructor that sets each side to its respective data from param
     * @param side1Data data given to set side 1
     * @param side2Data data given to set side 2
     * @param side3Data data given to set side 3
     */
    public Triangle(double side1Data, double side2Data, double side3Data){
        side1 = side1Data;
        side2 = side2Data;
        side3 = side3Data;
    }

    /**
     * getSide1 function returns the objects side 1
     * @return a double value of side 1
     */
    public double getSide1(){
        return side1;
    }

    /**
     * getSide2 function returns the objects side 2
     * @return a double value of side 2
     */
    public double getSide2(){
        return side2;
    }

    /**
     * getSide3 function returns the objects side 3
     * @return a double value of side 3
     */
    public double getSide3(){
        return side3;
    }

    /**
     * setSide1 takes the param value and sets the objects side 1
     * @param side1Data data given to set side 1
     */
    public void setSide1(double side1Data){
        side1 = side1Data;
    }

    /**
     * setSide2 takes the param value and sets the objects side 2
     * @param side2Data data given to set side 2
     */
    public void setSide2(double side2Data){
        side2 = side2Data;
    }

    /**
     * setSide3 takes the param value and sets the objects side 3
     * @param side3Data data given to set side 3
     */
    public void setSide3(double side3Data){
        side3 = side3Data;
    }

    /**
     * getArea function computes the triangle objects area
     * @return a double value of the area of the object
     */
    public double getArea(){
        double s = getPerimeter() / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    /**
     * getPerimeter function computes the triangle objects perimeter
     * @return a double value of the perimeter of the object
     */
    public double getPerimeter(){
        return side1 + side2 + side3;
    }

    /**
     * toString function evokes all the data of the triangle object
     * @return a string that has the details of the triangle object
     */
    public String toString(){
        return "Side 1 is: " + getSide1() + " and side 2 is: " + getSide2() + " and side 3 is: " + getSide3() + ". Your" +
                " area is: " + getArea() + " and perimeter is: " + getPerimeter();
    }

}

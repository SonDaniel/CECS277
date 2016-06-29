/*
    Daniel Son
    February 14, 2016
    Purpose: This class is used to test the three shape objects methods and verify their use of interface as well as inheritance.
    Inputs: There is no inputs given. All hard coded for testing purposes.
    Output: The value of the hardcoded values given to the different shapes. Computing their area.
 */
package IPI;

import java.util.ArrayList;
import java.util.Collections;

/**
 * The Class Assignment2 is the starting class for our assignment.
 */
public class Assignment2 {

    /**
     * The main class function is the start of the program. This function's main goal is to test and show the three
     * shapes methods and check to see if their interface works.
     * @param args Allows to pass arguments through program
     */
    public static void main(String[] args){
        Rectangle testRec = new Rectangle(4.0, 2.0); //testing Rectangle constructor with param
        Rectangle testRec2 = new Rectangle(); //testing Rectangle constructor without param

        System.out.println("Testing Rectangle Class: "); //display class data
        System.out.println(testRec);
        System.out.println(testRec2);

        testRec2.setHeight(5.0); //testing setHeight function
        testRec2.setWidth(3.0); //testing setWidth function

        System.out.println("Check change in testRec2:"); //display class data
        System.out.println(testRec2);

        System.out.println("");

        Triangle testTri = new Triangle(3.0, 5.0, 3.0); //testing Triangle constructor with param
        Triangle testTri2 = new Triangle(); //testing Triangle constructor without param

        System.out.println("Testing Triangle Class: "); //display class data
        System.out.println(testTri);
        System.out.println(testTri2);

        testTri2.setSide1(4.0); //testing setSide1 function
        testTri2.setSide2(5.0); //testing setSide2 function
        testTri2.setSide3(6.0); //testing setSide3 function

        System.out.println("Check change in testTri2:"); //display class data
        System.out.println(testTri2);

        System.out.println("");

        Circle testCir = new Circle(4.0);
        Circle testCir2 = new Circle();

        System.out.println("Testing Circle Class: "); //display class data
        System.out.println(testCir);
        System.out.println(testCir2);

        testCir2.setRadius(7.0); //testing setRadius function

        System.out.println("Check change in testCir2:"); //display class data
        System.out.println(testCir2);

        System.out.println("");
        System.out.println("################################################################");

        //creating ArrayList with Rectangle within
        ArrayList<GeometricObject> myList = new ArrayList<>();
        Rectangle rect1 = new Rectangle(4.0, 3.0);
        Rectangle rect2 = new Rectangle(5.0, 5.0);
        Rectangle rect3 = new Rectangle(10.0, 3.0);
        Rectangle rect4 = new Rectangle(4.0, 5.0);
        myList.add(rect1);
        myList.add(rect2);
        myList.add(rect3);
        myList.add(rect4);

        System.out.println("Rectangles ArrayList");
        System.out.println("Before Sort:"); //display ArrayList content
        for(int ii = 0; ii < myList.size(); ii++)
        {
            System.out.println(myList.get(ii).toString());
        }

        System.out.println("");
        Collections.sort(myList); //sort myList

        System.out.println("After Sort: "); //display ArrayList content after sort

        for(int ii = 0; ii < myList.size(); ii++)
        {
            System.out.println(myList.get(ii).toString());
        }

        System.out.println("");
        System.out.println("The max is: " + GeometricObject.max(myList)); //display max by area

        ArrayList<GeometricObject> myList2 = new ArrayList<>();
        Triangle Tri1 = new Triangle(4.0, 4.0, 5.0);
        Triangle Tri2 = new Triangle(5.0, 5.0, 6.0);
        Triangle Tri3 = new Triangle(2.0, 3.0, 2.0);
        Triangle Tri4 = new Triangle(4.0, 5.0, 2.0);
        myList2.add(Tri1);
        myList2.add(Tri2);
        myList2.add(Tri3);
        myList2.add(Tri4);

        System.out.println("################################################################");
        System.out.println("Triangle ArrayList");
        System.out.println("Before Sort:"); //display ArrayList content
        for(int ii = 0; ii < myList2.size(); ii++)
        {
            System.out.println(myList2.get(ii).toString());
        }

        System.out.println("");
        Collections.sort(myList2); //sorting myList2

        System.out.println("After Sort: "); //display ArrayList content after sort
        for(int ii = 0; ii < myList2.size(); ii++)
        {
            System.out.println(myList2.get(ii).toString());
        }

        System.out.println("");
        System.out.println("The max is: " + GeometricObject.max(myList2)); //display max by area

        ArrayList<GeometricObject> myList3 = new ArrayList<>();
        Circle circle1 = new Circle(4.0);
        Circle circle2 = new Circle(5.0);
        Circle circle3 = new Circle(2.0);
        Circle circle4 = new Circle(3.0);
        myList3.add(circle1);
        myList3.add(circle2);
        myList3.add(circle3);
        myList3.add(circle4);

        System.out.println("################################################################");
        System.out.println("Circle ArrayList");
        System.out.println("Before Sort:"); //display ArrayList content
        for(int ii = 0; ii < myList3.size(); ii++)
        {
            System.out.println(myList3.get(ii).toString());
        }

        System.out.println("");
        Collections.sort(myList3); //sort myList3

        System.out.println("After Sort: "); //display ArrayList content after sort
        for(int ii = 0; ii < myList3.size(); ii++)
        {
            System.out.println(myList3.get(ii).toString());
        }

        System.out.println("");
        System.out.println("The max is: " + GeometricObject.max(myList3)); //display max by area
    }
}

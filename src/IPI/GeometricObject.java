/*
    Daniel Son
    February 14, 2016
    Purpose: This class is a tool given to us to test the interface Comparable. The class will use the interface
    to compare two object's area and return the max or greatest area.
    Inputs: There are no inputs
    Outputs: There are no outputs
 */
package IPI;

import java.util.ArrayList;

public abstract class GeometricObject implements Comparable {
  private String color = "white";
  private boolean filled;
  private java.util.Date dateCreated;
  private String name = "noname";

    public abstract double getArea();
    public abstract double getPerimeter();

 /** Construct a default geometric object */
  public GeometricObject() {
	dateCreated = new java.util.Date();
}

/** Construct a geometric object with the specified color
	*  and filled value */
 public GeometricObject(String color, boolean filled, String name) {
 	dateCreated = new java.util.Date();
	this.color = color;
	this.filled = filled;
	this.name = name;
   }

/** Return color */
 public String getColor() {
 return color;
   }

/** Set a new color */
 public void setColor(String color) {
 this.color = color;
   }

/** Return filled. Since filled is boolean,
	its get method is named isFilled */
 public boolean isFilled() {
 return filled;
   }

/** Set a new filled */
 public void setFilled(boolean filled) {
 this.filled = filled;
   }

/** Get dateCreated */
 public java.util.Date getDateCreated() {
 return dateCreated;
   }

/** Return name */
 public String getName() {
 return name;
   }

   /** Set a new name */
    public void setName(String name) {
    this.name = name;
   }

    /** Return a string representation of this object */
    public String toString() {
        return "created on " + dateCreated + "\ncolor: " + color +
                " and filled: " + filled;
    }

    /**
     * This class max is used to find the biggest area between two objects.
     * @param myList An ArrayList of geometric objects
     * @return the object that's area is the biggest
     */
    public static GeometricObject max(ArrayList<GeometricObject> myList){
        int counter = 0;
        GeometricObject max = myList.get(counter);

        do
        {
            counter++; //increment counter

            if(max.compareTo(myList.get(counter)) == -1){
                max = myList.get(counter);
            }
            else if(max.compareTo(myList.get(counter)) == 1){
                //do nothing because max is greater
            }
            else
            {
                max = myList.get(counter);
            }
        }while(counter < myList.size() - 1);

        return max;
    }

    /**
     * This class compareTo is an interface that compares two objects.
     * @param obj An object that is used to compare.
     * @return a integer value of either -1, 1, or 0.
     */
    public int compareTo(Object obj){
        GeometricObject obj2 = (GeometricObject) obj;

        if(getArea() < obj2.getArea()){
            return -1;
        }
        else if (getArea() > obj2.getArea())
        {
            return 1;
        }
        else{
            return 0;
        }
    }
 }
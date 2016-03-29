/*
    Daniel Son
    March 1, 2016
    Purpose: The Class Measurable is created to be a Generic class that implements Comparable. The class will
    have a method that finds the highestGrade using Measurable and have a function CompareTo to test the Generic Comparable.
    Inputs: No input
    Output: No output
 */
package Generic;

import java.util.ArrayList;

/**
 * The Generic Measurable class implements a generic Comparable class and will compute the highestGrade
 * and do a compareTo method.
 * @param <T> A generic parameter that takes in any generic class
 */
public abstract class Measurable<T> implements Comparable<Measurable>
{
   public abstract double getMeasure();

    /**
     * The highestGrade function will calculate the highestGrade within an ArrayList
     * @param list An ArrayList of any generic class
     * @param <T> Any generic class
     * @return The largest generic class
     */
    public static <T extends Measurable> T highestGrade(ArrayList<T> list)
    {
        T largest = null;
        boolean firstTime = true;

        for (T obj: list) {
            if(firstTime)
            {
                largest = obj;
                firstTime = false;
            }
            else
            {
                if(obj.getMeasure() < largest.getMeasure())
                {
                    largest = obj;
                }
            }
        }
        return largest;
    }

    /**
     * The compareTo method is required for Comparable and will compare two objects.
     * @param obj1 A Measurable object
     * @return An integer of -1, 1, or 0
     */
    public int compareTo(Measurable obj1)
    {
        if(getMeasure() < obj1.getMeasure())
        {
            return -1;
        }
        else if(getMeasure() > obj1.getMeasure())
        {
            return 1;
        }
        else
        {
            return 0;
        }

    }

}

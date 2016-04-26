/*
    Daniel Son
    March 1, 2016
    Purpose: The GradeTester class is programmed to test the generic class Measurable that implements Comparable.
    This class will create a test case and use the class Grades to test the generic class Measurable.
    Inputs: Hard coding test variables into objects within an ArrayList
    Output: Before sort output, after sort output and the highest grade output
 */
package Generic;

import java.util.ArrayList;
import java.util.Collections;

/**
 * The GradeTester class is the main start of the program and will test the Grades class which extends Measurable.
 * Measurable implements Comparable and this class will test to see if measurable and comparable are correct.
 */
public class GradeTester {
    /**
     * Main is the start of the program and will test the class and it's functionality.
     * @param args Allows arguments to pass
     */
    public static void main(String[] args){
        System.out.println("This program will test the functionality of the class Grade which extends to " +
                "Measurable which implements Comparable.");
        System.out.println("");

        //inputting data in arrayList
        ArrayList<Grades> list = new ArrayList<>();
        Grades person1 = new Grades("Daniel", "Son", 'B');
        Grades person5 = new Grades("Timmy", "tim", 'F');
        Grades person2 = new Grades("Bill", "Lee", 'A');
        Grades person3 = new Grades("Chris", "Sharma", 'D');
        Grades person4 = new Grades("Alex", "Honold", 'C');
        list.add(person1); //adds to arrayList
        list.add(person5); //adds to arrayList
        list.add(person2); //adds to arrayList
        list.add(person3); //adds to arrayList
        list.add(person4); //adds to arrayList

        //listing the list before the sort
        System.out.println("Before sort: ");
        for(int ii = 0; ii < list.size(); ii++)
        {
            System.out.println(list.get(ii));
        }

        //sorting list
        System.out.println("");
        Collections.sort(list);

        //testing to get largest grade using measurable
        Measurable largestGrade = Measurable.highestGrade(list);

        //listing the list after the sort
        System.out.println("After sort: ");
        for(int ii = 0; ii < list.size(); ii++)
        {
            System.out.println(list.get(ii));
        }

        //evoking the highest grade.
        System.out.println("");
        System.out.println("The highest grade in the list: ");
        System.out.println(largestGrade); //prints largest grade
    }
}

/*
    Daniel Son
    March 1, 2016
    Purpose: This class is designed to record a person's first and last name and store their grade. The class
    extends to measurable which evokes getMeasure and returns grade.
    Inputs: No inputs
    Output: No outputs
 */
package Generic;

/**
 * The class Grades inherits a generic Measurable. This class will store a person's first and last name.
 * It will store their grade and allow to set the grade, set the person's last name or first name and also return
 * the stored values.
 */
public class Grades extends Measurable<Grades> {
    private Character grade;
    private String firstName;
    private String lastName;

    /**
     * Constructor with no parameters that sets everything to a default.
     */
    public Grades(){
        grade = ' ';
        firstName = "";
        lastName = "";
    }

    /**
     * Constructor with parameters that sets each storage with the data given
     * @param firstNameData A string given and set firstName
     * @param lastNameData A string given and set lastName
     * @param gradeData A character that is given and set grade
     */
    public Grades(String firstNameData,String lastNameData, char gradeData){
        firstName = firstNameData;
        lastName = lastNameData;
        grade = gradeData;
    }

    /**
     * The setGrade function will get data from the program and set the grade to it.
     * @param gradeData A character that is given and set grade
     */
    public void setGrade(char gradeData){
        grade = gradeData;
    }

    /**
     * The setFirstName function will get data from the program and set the first name to it.
     * @param name A string that is given and set to firstName
     */
    public void setFirstName(String name){
        firstName = name;
    }

    /**
     * The setLastName function will get data from the program and set the last name to it.
     * @param name A string that is given and set to lastName
     */
    public void setLastName(String name){
        lastName = name;
    }

    /**
     * The getFirstName function will return the stored first name.
     * @return A string that was stored in firstName
     */
    public String getFirstName(){
        return firstName;
    }

    /**
     * The getLastName function will return the stored last name.
     * @return A string that was stored in lastName
     */
    public String getLastName(){
        return lastName;
    }

    /**
     * The getGrade function will return the stored grade.
     * @return A character that was stored in grade.
     */
    public Character getGrade(){
        return grade;
    }

    /**
     * The getMeasure function is required for Measurable.
     * @return A double value of grade
     */
    public double getMeasure(){
        return grade;
    }

    /**
     * The toString method will return a string of all the data within the grade class
     * @return a string of all the data
     */
    public String toString() {
        return firstName + " " + lastName + " grade is an " + grade;
    }


}

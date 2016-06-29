/*
package Lab;

public class Person implements Measurable, Comparable {
    private String lastName;
    private String firstName;
    private int age;

    public Person(String inLastName, String inFirstName, int inAge) {
        lastName =inLastName;
        firstName =inFirstName;
        age=inAge;
    }

    public int compareTo(Object person1){

        Person person2 = (Person) person1;
        if(firstName.compareTo(person2.firstName) < 0)
        {
            return -1;
        }
        else if (firstName.compareTo(person2.firstName) > 0)
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }

    public double getMeasure() {
        return age;
    }

    public String toString() {
        return firstName + "'" + lastName + " is " + age + " years old.";
    }
}
*/
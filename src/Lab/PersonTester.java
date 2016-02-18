package Lab;
import java.util.Arrays;

public class PersonTester {
    public static void main(String[] args)
    {
        Measurable[] person = new Measurable[4];
        person[0] = new Person("son","daniel",4);
        person[1] = new Person("lee", "bob",10);
        person[2] = new Person("cat","meow",30);
        person[3] = new Person("moo","cow",45);

        System.out.println("Before Sort:");
        for(int ii = 0; ii < person.length; ii++)
        {
            System.out.println(person[ii].toString());
        }

        Arrays.sort(person);
        System.out.println("");

        System.out.println("After Sort:");
        for(int ii = 0; ii < person.length; ii++)
        {
            System.out.println(person[ii].toString());
        }

        Measurable smallestAge = Data.smallestAge(person);

        System.out.println("");
        System.out.println("The smallest age: " + smallestAge);
    }
}

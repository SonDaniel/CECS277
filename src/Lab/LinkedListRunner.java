package Lab;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LinkedListRunner {
    public static void main(String[] args){
        LinkedList<String> list = new LinkedList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        list.add("ddd");
        list.add("eee");
        list.add("fff");
        list.add("ggg");
        list.add("hhh");
        list.add("iii");
        ListIterator<String> iterator = list.listIterator();

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("");

        String regex = "[aeiou]+";
        while(iterator.hasPrevious()){
            String value = iterator.previous();
            if(value.matches(regex)){
                iterator.remove();
            }
            else
            {
                System.out.println(value);
            }
        }
    }
}

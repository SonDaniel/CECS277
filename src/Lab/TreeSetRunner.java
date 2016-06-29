package Lab;

import java.util.TreeSet;

public class TreeSetRunner {
    public static void main(String[] args){
        TreeSet<String> set = new TreeSet<>();
        for(int ii = 0; ii < 2; ii++){
            set.add("iii");
            set.add("hhh");
            set.add("ggg");
            set.add("fff");
            set.add("eee");
            set.add("ddd");
            set.add("ccc");
            set.add("bbb");
            set.add("aaa");
        }

        for(String i : set){
            System.out.println(i);
        }
    }
}

/**
 * The tree set only displays the set once because each elements are unique. It also displays the set in order rather than backwards.
 */
package Lab;

public class StackRunner
{
    public static void main(String[] args)
    {
        Stack<Character> stk1 = new Stack<Character>();
        stk1.push('a');
        stk1.push('b');
        stk1.push('c');
        stk1.push('d');
        while (!stk1.empty())
        {
            System.out.println(stk1.pop());
        }
    }
}

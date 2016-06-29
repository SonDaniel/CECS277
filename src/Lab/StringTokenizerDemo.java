package Lab;

import java.util.StringTokenizer;

public class StringTokenizerDemo
{
   public static void main(String[] args)
   {
      String sentence = "it's,fleece,was,white,as,snow";
      StringTokenizer mystery = new StringTokenizer(sentence, ",");
      System.out.println(mystery.countTokens());
      System.out.println(mystery.nextToken());
      System.out.println(mystery.nextToken());
   }
}

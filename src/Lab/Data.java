package Lab;

public class Data
{
   /**
      Computes the average of the measures of the given objects.
      @param objects an array of Measurable objects
      @return the average of the measures
   */
   public static double average(Measurable[] objects)
   {
      double sum = 0;
      for (Measurable obj : objects)
      {
         sum = sum + obj.getMeasure();
      }
      if (objects.length > 0) { return sum / objects.length; }
      else { return 0; }
   }

   public static Measurable smallestAge(Measurable[] objects) {
      boolean firstTime = true;
      Measurable smallestAge = objects[0];

      for (Measurable obj: objects) {
         if(firstTime)
         {
            smallestAge = obj;
            firstTime = false;
         }
         else
         {
            Measurable compareTo = obj;
            if(compareTo.getMeasure() < smallestAge.getMeasure())
            {
               smallestAge = compareTo;
            }
         }
      }

      return smallestAge;
   }
}

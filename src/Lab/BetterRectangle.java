package Lab;

import java.awt.Rectangle;

public class BetterRectangle extends Rectangle {

    public BetterRectangle(int width, int height){
        super(width, height);
    }

    public int getPerimeter(){
        return (int)((super.getWidth() + super.getWidth()) + (super.getHeight() + super.getHeight()));
    }

    public int getArea(){
        return (int)(super.getWidth() * super.getHeight());
    }

    public static void main(String[] args){
        //creating object with input values
        BetterRectangle betterRectangle = new BetterRectangle(5, 9);
        //evoking functions
        System.out.println("Test values input for width: 5 and height: 9");
        System.out.println("Your perimeter is: " + betterRectangle.getPerimeter());
        System.out.println("Your area is: " + betterRectangle.getArea());

        //creating object with input values
        BetterRectangle betterRectangle2 = new BetterRectangle(10, 20);
        //evoking functions
        System.out.println("Test values input for width: 10 and height: 20");
        System.out.println("Your perimeter is: " + betterRectangle2.getPerimeter());
        System.out.println("Your area is: " + betterRectangle2.getArea());

    }
}

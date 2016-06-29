package Finals;

import java.io.*;

public class BinaryTester {
    private static FileOutputStream fileOutputStream;
    private static ObjectOutputStream objectOutputStream;
    private static FileInputStream fileInputStream;
    private static ObjectInputStream objectInputStream;

    public static void main(String[] args){
        try{
            BinarySearchTree tree = new BinarySearchTree();
            tree.add("Daniel"); //populate tree
            tree.add("Bob");
            tree.add("Billy");
            tree.add("Joe");
            tree.add("Danny");
            tree.add("rachel");
            tree.add("becky");
            tree.add("Pedro");
            tree.add("Justin");
            tree.add("Madre");
            System.out.println("Old tree:");
            tree.print();
            System.out.println("");
            //writing object to text file
            fileOutputStream = new FileOutputStream("src/Finals/BinarySearchTree.txt");
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(tree);
            objectOutputStream.close();
            fileOutputStream.close();
            //getting object from text file
            fileInputStream = new FileInputStream("src/Finals/BinarySearchTree.txt");
            objectInputStream = new ObjectInputStream(fileInputStream);
            //create new BinarySearchTree object
            BinarySearchTree newTree = (BinarySearchTree) objectInputStream.readObject();

            fileInputStream.close();
            objectInputStream.close();
            //display object content
            System.out.println("New Tree:");
            newTree.print();

        }catch(IOException io){
            io.printStackTrace();
        }catch(ClassNotFoundException cl){
            cl.printStackTrace();
        }
    }
}

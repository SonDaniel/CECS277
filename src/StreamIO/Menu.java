/*
    Daniel Son
    April 17, 2016
    Purpose: This file purpose is to create the main frame. The main frame will consist of
    the option menu, drawn gui, and price of the ice cream.
    Inputs: User choice of different options for constructing their ice cream.
    Output: A color chooser, a option to get previous setting or new setting and the Main frame
 */

package StreamIO;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.DecimalFormat;
//import java.util.Scanner;

/**
 * Menu class extends JFrame. The menu class is used to create the GUI of the Ice Cream menu.
 * Menu will do all the algorithms and listeners for the GUI.
 */
public class Menu extends JFrame {
    //declaring global variables
    private JDialog askFrame;
    private final int FRAME_WIDTH = 800;
    private final int FRAME_HEIGHT = 400;
    private Display display;
    private String stringTotal;
    private AdvancedIceCreamCone userIceCream;
    private JColorChooser colorChooser;
    private JFrame colorChoose;
    private JComboBox coneList,flavorList;
    private JSpinner numScoopUI;
    private JCheckBox sprinkles,chocolateChip,peanuts,mochi;
    private final double REGULAR = 3.00;
    private final double SUGAR = 4.00;
    private final double WAFFLE = 5.00;
    private final double SCOOP = 2.00;
    private final double TOPPING = 0.50;
    private double total;
    private JLabel cost;
    private FileOutputStream writer;
    private ObjectOutputStream printWriter;
    //private Scanner reader;

    /**
     * Menu function is a constructor that initiates the GUI components and creates all the parts for the program.
     */
    public Menu() {

        colorChoose = new JFrame(); //creating JFrame for the color chooser
        colorChoose.setSize(450,450); //setting size for the color chooser
        colorChooser = new JColorChooser(); //creating colorchooser component
        JButton okButton = new JButton("OK"); //creating ok button when finished choosing color
        colorChoose.setLayout(new FlowLayout()); //set flowlayout for color chooser Jframe
        colorChoose.add(colorChooser); //add components to JFrame
        colorChoose.add(okButton);
        okButton.addActionListener(new ActionListener() { //creating actionlistener for okbutton
            public void actionPerformed(ActionEvent e) {
                Color colorChoosed = colorChooser.getColor(); //getting color
                userIceCream.setSprinkleColor(colorChoosed); //setting color in object
                userIceCream.addToppings("Sprinkles"); //adding that topping was added
                display.storeUserPreference(userIceCream); //pass object to save in display to paint
                display.repaint(); //repainter
                colorChoose.dispose(); //close color chooser Jframe
            }
        }); //end of Action listener

        //creating userIceCream object
        userIceCream = new AdvancedIceCreamCone();

        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        total = 0.00;
        stringTotal = decimalFormat.format(total);
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        display = new Display(userIceCream); //create display for drawing
        display.setBackground(Color.lightGray);
        display.repaint();

        //creating component for user options
        sprinkles = new JCheckBox("Sprinkles");
        chocolateChip = new JCheckBox("Chocolate Chips");
        peanuts = new JCheckBox("Peanuts");
        mochi = new JCheckBox("Mochi");
        JLabel choiceTitle = new JLabel(" Toppings:");
        JLabel flavorTitle = new JLabel(" Flavors:");
        JLabel numScoopTitle = new JLabel(" Number of Scoops(Max is 3):");

        //creating listeners and adding to components
        ItemListener sprinkleListener = new SprinkleListener();
        ItemListener toppingListener = new ToppingListener();
        sprinkles.addItemListener(sprinkleListener);
        chocolateChip.addItemListener(toppingListener);
        peanuts.addItemListener(toppingListener);
        mochi.addItemListener(toppingListener);

        //creaing comboBoxes
        String[] coneStrings = {"Regular Cone", "Sugar Cone", "Waffle Cone"};

        coneList = new JComboBox(coneStrings);
        coneList.setSelectedIndex(0);

        String[] flavorStrings = {"Vanilla Flavor", "Chocolate Flavor", "Strawberry Flavor"};

        flavorList = new JComboBox(flavorStrings);
        flavorList.setSelectedIndex(0);

        //adding listeners to combo box
        ActionListener listListener = new ComboBoxListener();
        coneList.addActionListener(listListener);
        flavorList.addActionListener(listListener);

        SpinnerModel numScoopModel = new SpinnerNumberModel(userIceCream.getNumberOfScoops(),1,3,1);
        numScoopUI = new JSpinner(numScoopModel);

        ChangeListener scoopListener = new ScoopListener();
        numScoopUI.addChangeListener(scoopListener);

        //adding all the components to a Jpanel as a choicemenu
        JPanel choiceMenu = new JPanel();
        choiceMenu.setLayout(new GridLayout(10,1));
        choiceMenu.add(coneList); //add the combo box
        choiceMenu.add(flavorTitle);
        choiceMenu.add(flavorList);
        choiceMenu.add(numScoopTitle);
        choiceMenu.add(numScoopUI);
        choiceMenu.add(choiceTitle);
        choiceMenu.add(sprinkles);
        choiceMenu.add(chocolateChip);
        choiceMenu.add(peanuts);
        choiceMenu.add(mochi);
        Container pane = getContentPane();
        pane.add(choiceMenu);
        setContentPane(pane);

        //adding Jpanel as bottom for reset and order
        JPanel bottomPanel = new JPanel();
        Button reset = new Button("Reset");
        Button order = new Button("Order");
        cost = new JLabel("Total: $" + stringTotal);
        bottomPanel.setLayout(new FlowLayout());
        bottomPanel.add(reset);
        bottomPanel.add(order);
        bottomPanel.add(cost);

        //creating listeners for buttons
        ActionListener buttonListener = new ButtonListener();
        order.addActionListener(buttonListener);
        reset.addActionListener(buttonListener);

        setLayout(new BorderLayout());
        add(choiceMenu, BorderLayout.WEST);
        add(display, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        //creating frame for after order to either use previous setting or new setting
        askFrame = new JDialog(this, "", Dialog.ModalityType.DOCUMENT_MODAL);
        askFrame.setSize(300,200);
        askFrame.setResizable(false);
        askFrame.setLocationRelativeTo(this);
        askFrame.setLayout(new FlowLayout());
        JButton importer = new JButton("Import Previous Setting");
        JButton newer = new JButton("New Setting");
        askFrame.add(importer);
        askFrame.add(newer);
        ActionListener selectionListener = new OptionListener();
        importer.addActionListener(selectionListener);
        newer.addActionListener(selectionListener);

//        WindowListener windowListener = new MainListener();
//        this.addWindowListener(windowListener);

        //setting main frame relative to screen
        setLocationRelativeTo(this);
        askFrame.setVisible(true);
    }

    /**
     * Class MainListener implements WindowListener. The Class is mainly to close the writer
     * so that the file saving will be saved.
     */
    /*
    private class MainListener implements WindowListener{
        public void windowClosing(WindowEvent e) {
            try{
                writer.close();
                printWriter.close();
            }catch(IOException io){
                io.printStackTrace();
            }
        }

        //The rest of the functions are not needed
        public void windowActivated(WindowEvent e) {}
        public void windowDeactivated(WindowEvent e){}
        public void windowClosed(WindowEvent e) {}
        public void windowDeiconified(WindowEvent e) {}
        public void windowIconified(WindowEvent e) {}
        public void windowOpened(WindowEvent e) {}
    }
    */
    /**
     * The class OptionListener implements ActionListener. The class is used to check to see if user
     * chooses to keep the previous settings of the ice cream program or reset the program.
     */
    private class OptionListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            if(button.getText().charAt(0) == 'I'){
                resetAll();
                readSettings(); //test function to read saved file
            }
            else{
                resetAll(); //resets the gui components
            }

            askFrame.dispose(); //closes the dialog

        }
    }

    /**
     * The resetAll function will reset all the components of the program.
     * Every value will go back to default.
     */
    private void resetAll(){
        userIceCream.reset();
        coneList.setSelectedIndex(0);
        flavorList.setSelectedIndex(0);
        numScoopUI.setValue(1);
        sprinkles.setSelected(false);
        chocolateChip.setSelected(false);
        peanuts.setSelected(false);
        mochi.setSelected(false);
        total = 0.00;
        cost.setText("Total is: $" + total);
        display.storeUserPreference(userIceCream);
        display.repaint();
    }

    /**
     * The calculateOrder function will calculate the price of every selected item.
     */
    private void calculateOrder(){
        if(userIceCream.getTypeOfCone().equals("regular")){
            total = REGULAR + (SCOOP * userIceCream.getNumberOfScoops()) + (TOPPING * userIceCream.getToppings().size());
        }
        else if(userIceCream.getTypeOfCone().equals("sugar")){
            total = SUGAR + (SCOOP * userIceCream.getNumberOfScoops()) + (TOPPING * userIceCream.getToppings().size());
        }
        else{
            total = WAFFLE + (SCOOP * userIceCream.getNumberOfScoops()) + (TOPPING * userIceCream.getToppings().size());
        }
        cost.setText("Total is: $" + total); //sets the text for the JLabel to display to user

    }

    /**
     * The save function will write the object to a text file. Then will display a Dialog for user next choice.
     */
    private void save(){

        //initalizing writer to save user order when finished
        try{
            writer = new FileOutputStream("iceCreamFile.txt");
            printWriter = new ObjectOutputStream(writer);
            printWriter.writeObject(userIceCream);
            writer.close();
            printWriter.close();
        }catch(IOException io) {
            io.printStackTrace();
        }
            askFrame.setVisible(true); //display the dialog for user.
    }

    /**
     * The ComboBoxListener class implements ActionListener.
     * The class checks to see what comboBox is selected and saves the selection.
     */
    private class ComboBoxListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            JComboBox cb = (JComboBox)e.getSource();
            String choice = (String) cb.getSelectedItem();
            //checks to see what type of cone was selected
            if(choice.equals("Regular Cone")){
                userIceCream.setTypeOfCone("regular");
            }
            else if(choice.equals("Sugar Cone")){
                userIceCream.setTypeOfCone("sugar");
            }
            else if(choice.equals("Waffle Cone")){
                userIceCream.setTypeOfCone("waffle");
            }
            //checks to see what flavor was selected
            if(choice.equals("Vanilla Flavor")){
                userIceCream.setFlavor("vanilla");
            }
            else if(choice.equals("Chocolate Flavor")){
                userIceCream.setFlavor("chocolate");
            }
            else if(choice.equals("Strawberry Flavor")){
                userIceCream.setFlavor("strawberry");
            }
            display.storeUserPreference(userIceCream);
            display.repaint();
        }
    }

    /**
     * The ScoopListener implements ChangeListener.
     * This class is used to check how many scoops user wants.
     */
    private class ScoopListener implements ChangeListener{
        public void stateChanged(ChangeEvent e) {
            JSpinner spinner = (JSpinner) e.getSource();
            Integer value = (Integer) spinner.getValue();
            userIceCream.setNumberOfScoops(value);
            display.storeUserPreference(userIceCream);
            display.repaint();
        }
    }

    /**
     * The ButtonListener implements Action Listener.
     * Class is used to see if user clicked reset or order.
     */
    private class ButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().equals("Reset")){
                resetAll();
            }
            else if(e.getActionCommand().equals("Order")){
                calculateOrder();
                save();
            }
        }
    }

    /**
     * The SprinkleListener implements ItemListener.
     * The class is used to see if sprinkle was added.
     */
    private class SprinkleListener implements ItemListener{
        public void itemStateChanged(ItemEvent e){
            if(e.getStateChange() == ItemEvent.SELECTED){
                colorChoose.setVisible(true);
            }
            else{
                userIceCream.setSprinkleColor(null);
                userIceCream.removeTopping("Sprinkles");
            }
            display.storeUserPreference(userIceCream);
            display.repaint();
        }
    }

    /**
     * The ToppingListener class implements ItemListener.
     * The class checks to see if any topping was added and then saved
     */
    private class ToppingListener implements ItemListener{
        public void itemStateChanged(ItemEvent e) {
            JCheckBox box = (JCheckBox) e.getSource();
            if(e.getStateChange() == ItemEvent.SELECTED){
                userIceCream.addToppings(box.getText());
            }
            else{
                userIceCream.removeTopping(box.getText());
            }
            display.storeUserPreference(userIceCream);
            display.repaint();
        }
    }
    private void readSettings(){
        try{
            FileInputStream input = new FileInputStream("iceCreamFile.txt");
            ObjectInputStream objOut = new ObjectInputStream(input);
            userIceCream = (AdvancedIceCreamCone) objOut.readObject();
            display.storeUserPreference(userIceCream);
            display.repaint();
            System.out.println(userIceCream);

            input.close();
            objOut.close();

        }catch(FileNotFoundException io){
            io.printStackTrace();
        }catch(IOException io){
            io.printStackTrace();
        }catch(ClassNotFoundException io){
            io.printStackTrace();
        }
    }

}

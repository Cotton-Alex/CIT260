/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.util.Scanner;

/**
 *
 * @author Mike Minassian
 */
public abstract class View implements ViewInterface {

    protected String display;
    private String menu;

    public View() {
    }

    public View(String message) {
        this.display= message;
    }

//    @Override
//    public void display() {
//        boolean done = false;    // set flag to not done
//        do {
//            // prompt for and get players name
//            String menuOption = this.getMenuOption();
//            if (menuOption.toUpperCase().equals("Q"))      // user want to quit
//                return;                                    // exit the game
//
//            // do the requested action and display the next view
//            done = this.doAction(menuOption);
//        } while (!done);
//    }
    
//  AC 06-17-17 -   I commented out the function above and added the the function
//                  below. The top one uses menuOption and the bottom uses getInput
//                  the bottom is copied from teh assignment but I'm wasn't sure
//                  it'd work... I kept the top one in case we need to go back.
    
    @Override
    public void display() {
        boolean done = false;    // set flag to not done
        do {
            // prompt for and get players name
            String value = this.getInput();
            if (value.toUpperCase().equals("Q")) // user want to quit
            {
                return;                                    // exit the game
            }
            // do the requested action and display the next view
            done = this.doAction(value);
        } while (!done);
    }

    @Override
    public String getInput() {
        Scanner keyboard = new Scanner(System.in);                              // get infile for keyboard
        boolean valid = false;                                                  // value to be returned
        String value = null;                                                    // initialize to not valid

        while (!valid) {
            System.out.println("\n" + this.display);
            value = keyboard.nextLine();                                        // get next line typed on keyboard
            value = value.trim();                                               // trim off leading and trailing blanks

            if (value.length() < 1) {
                System.out.println("\nInvalid value: value can not be blank");
                continue;
            }
            break;                                                              // end the loop
        }
        return value;                                                           // return the value entered
    }

//    @Override
//    public boolean doAction(String choice) {
//
//        choice = choice.toUpperCase();                                          // convert choice to upper case
//    }
    
//  AC 06-17-17 -   I commented out the function above and added @Override to the
//                  doAction function in the MainMenuView class.
    
}
/**
 * @file CLI
 * @version 1.0.0
 * @type java
 * @data 2020-04-30
 * @author Matteo Brosolo
 * @email hexatech016@gmail.com
 * @license MIT
 */

package HexaTech.Client;

import HexaTech.ControllerPresenter.Controller;
import HexaTech.ControllerPresenter.Presenter;

import java.io.IOException;
import java.util.Scanner;

/**
 * Class used to show output messages to user and receive input actions.
 */
public class CLI implements MyObserver {
    Controller controller;
    Presenter presenter;

    /**
     * CLI class constructor.
     * @param newController Controller - controller class parameter value.
     * @param newPresenter Presenter - presenter class parameter value.
     */
    public CLI(Controller newController, Presenter newPresenter){
        controller=newController;
        presenter=newPresenter;
        presenter.addObserver(this);
    }

    /**
     * Shows to user which action he could do with this software.
     * @throws IOException if the specified file path doesn't exist.
     */
    public void useCase() throws IOException{
        String temp;
        while (true){
            System.out.println("Use case: \n 1: Add a Gherkin  \n 2: Extract BAL \n 3: Exit");
            Scanner scan = new Scanner(System.in);
            temp = scan.nextLine();
            switch (temp) {
                /*case ("1"):
                    controller.addBDLController();
                    break;*/
                case ("1"):
                    controller.addGherkinController();
                    break;
                case ("2"):
                    controller.createBALController();
                    break;
                case ("3"):
                    System.out.println("Esci");
                    System.exit(0);
            }//switch
        }//while
    }//useCase

    /**
     * Receives presenter's message status and show it to user.
     */
    @Override
    public void notifyMe() {
        System.out.println(presenter.getS());
    }

}//CLI

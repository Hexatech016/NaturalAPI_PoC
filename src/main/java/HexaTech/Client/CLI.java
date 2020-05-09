/**
 * @file CLI
 * @version 1.0.0
 * @type java
 * @data 2020-04-25
 * @author Alessio Barbiero
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
     * @param controller Controller - controller class parameter value.
     * @param presenter Presenter - presenter class parameter value.
     */
    public CLI(Controller controller, Presenter presenter){
        this.controller=controller;
        this.presenter=presenter;
        this.presenter.addObservers(this);
    }


    /**
     * Shows to user which actions he could do with this software.
     * @throws IOException if the specified file path doesn't exist.
     */
    public void useCase() throws IOException {
        String firstCase;
        while (true) {
            System.out.println("Use Case: \n 1: Check if there are saved documents \n 2: Add a document  " +
                    "\n 3: Extract BDL \n 4: Exit");
            Scanner firstScanner = new Scanner(System.in);
            firstCase = firstScanner.nextLine();
            switch (firstCase) {
                case ("1"):
                    controller.checkThereAreDoc();
                    if(notifyFlag()){
                        System.out.println("There's a saved document. Do you want to load it? (Y/N)");
                    Scanner secondScanner = new Scanner(System.in);
                    String secondCase = secondScanner.nextLine();
                    if (secondCase.equalsIgnoreCase("y")) {
                        controller.restoreDocController();
                    }else if (secondCase.equalsIgnoreCase("n")){
                        controller.deleteDocController(".\\Discover\\temp.txt");
                        }else{
                            System.out.println("Please type Y or N");
                            break;
                        }//if_else
                    }//if_else
                    else
                        System.out.println("There are no saved documents");
                    break;
                case ("2"):
                    controller.addDocController();
                    break;
                case ("3"):
                    controller.checkThereAreDoc();
                    if(notifyFlag())
                    controller.createBDL();
                    else
                        System.out.println("There are no loaded documents to extract BDL");
                    break;
                case ("4"):
                    System.out.println("Bye!");
                    System.exit(0);
            }//switch
        }//while
    }//useCase

    /**
     * Receives presenter's message status and show it to user.
     */
    @Override
    public void notifyMe() {
        System.out.println(presenter.getPresenter());
    }

    /**
     * Receives presenter's flag status and return it.
     * @return boolean - presenter's flag.
     */
    @Override
    public boolean notifyFlag() {
        return presenter.isFlag();
    }

}//CLI

/**
 * @file CLI
 * @version 1.0.0
 * @type java
 * @data 2020-04-30
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
    private final Controller controller;
    private final Presenter presenter;

    /**
     * CLI class constructor.
     * @param controller Controller - controller class parameter value.
     * @param presenter Presenter - presenter class parameter value.
     */
    public CLI(Controller controller, Presenter presenter) {
        this.controller=controller;
        this.presenter=presenter;
        presenter.addObserver(this);
    }//CLI

    /**
     * Asks to user if he wants to reload an existing backup file.
     * @return boolean - true if user decide to reload a backup file; false if user doesn't want to reload it.
     * @throws IOException if the document path specified in backup is not valid anymore.
     */
    public boolean existsBackUp() throws IOException {
        System.out.println("A document is already stored. Do you want to load it? (Y/N)");
        Scanner scan = new Scanner(System.in);
        String risp = scan.nextLine();
        if (risp.equalsIgnoreCase("y")) {
            controller.restoreDocController();
            return true;
        }else if (risp.equalsIgnoreCase("n")){
            controller.deleteDocController(".\\Develop\\temp.txt");
            return false;
        }else{
            System.out.println("Please insert Y or N.");
            return existsBackUp();
        }//if_else
    }//existsBackup

    /**
     * Shows to user which actions he could do with this software.
     * @param condition boolean - true if there's a loaded BAL file, false if not.
     * @throws IOException if the specified file path doesn't exist.
     */
    public void useCase(boolean condition) throws IOException {
        String temp;
        if (!condition) {
            System.out.println("Use case: \n 1: Add a new BAL \n 2: Exit");
            Scanner scan = new Scanner(System.in);
            temp = scan.nextLine();
            switch (temp) {
                case ("1"):
                    controller.addDocController();
                    if(!notifyMeDone())
                        System.out.println("Please select a .json file.");
                    useCase(notifyMeDone());
                    break;
                case ("2"):
                    System.out.println("Bye!");
                    System.exit(0);
                default:
                    useCase(condition);
            }//switch
        }else{
            System.out.println("Use case: \n 1: Generate API \n 2: Exit");
            Scanner scan = new Scanner(System.in);
            temp = scan.nextLine();
            switch (temp) {
                case ("1"):
                    useCasePLA();
                    break;
                case ("2"):
                    System.out.println("Bye!");
                    System.exit(0);
                default:
                    useCase(condition);
            }//switch
        }//if_else
    }//useCase

    /**
     * Asks the user which programming language he want for the output file. He also can load a PLA file.
     * @throws IOException if the specified PLA file path doesn't exist.
     */
    public void useCasePLA() throws IOException {
        String temp;
        System.out.println("In which programming language do you want to generate API? \n 1: Java \n 2: JavaScript \n 3: Generate from an external PLA \n 4: Exit");
        Scanner scan = new Scanner(System.in);
        temp = scan.nextLine();
        switch(temp){
            case ("1"):
                controller.refreshPLAController(".\\src\\main\\resources\\java.pla");
                controller.createAPIController();
                checkUseCase(notifyMeError());
            case ("2"):
                controller.refreshPLAController(".\\src\\main\\resources\\js.pla");
                controller.createAPIController();
                checkUseCase(notifyMeError());
            case("3"):
                controller.addPLAController();
                if(notifyMeDone()){
                    controller.createAPIController();
                    checkUseCase(notifyMeError());
                }else
                    System.out.println("Please select a .pla file.");
                useCasePLA();
            case ("4"):
                System.out.println("Bye!");
                System.exit(0);
            default:
                useCasePLA();
        }//switch
    }//useCasePLA

    /**
     * Shows different errors messages in case of problems and redirect the user to the correct corrective action.
     * @param code integer - error code.
     * @throws IOException propagation of the exception.
     */
    public void checkUseCase(int code) throws IOException {
        switch(code){
            case(0):
                useCasePLA();
            case(1):
                System.out.println("Add a PLA or choose a programming language.");
                useCasePLA();
            case(2):
                System.out.println("Add a BAL.");
                useCase(false);
            case(3):
                System.out.println("Add a valid BAL.");
                useCase(false);
            case(4):
                System.out.println("Add a valid PLA.");
                useCasePLA();
        }//switch
    }//checkUseCase

    /**
     * Receives presenter's message status and show it to user.
     */
    @Override
    public void notifyMe(){
        System.out.println(presenter.getMessage());
    }

    /**
     * Receives presenter's error code status.
     * @return integer - error code.
     */
    public int notifyMeError(){
        return presenter.getCode();
    }

    /**
     * Receives presenter's boolean status.
     * @return boolean - presenter status.
     */
    public boolean notifyMeDone(){
        return presenter.isDone();
    }

}//CLI

/**
 * @file CLI
 * @version 0.0.1
 * @type java
 * @data 2020-04-25
 * @author Alessio Barbiero
 * @email hexatech016@gmail.com
 * @license
 * @changeLog
 */

package HexaTech.Client;

import HexaTech.ControllerPresenter.Controller;
import HexaTech.ControllerPresenter.Presenter;

import java.io.IOException;
import java.util.Scanner;

public class CLI implements MyObserver {
    Controller controller;
    Presenter presenter;

    public CLI(Controller controller, Presenter presenter){
        this.controller=controller;
        this.presenter=presenter;
        this.presenter.addObservers(this);
    }
    public void useCase() throws IOException {
        String firstCase;
        while (true) {
            System.out.println("Use Case: \n 1: Check if there are documents saved \n 2: Add a document  " +
                    "\n 3: Extract BDL \n 4: Exit");
            Scanner firstScanner = new Scanner(System.in);
            firstCase = firstScanner.nextLine();
            switch (firstCase) {
                case ("1"):
                    controller.checkThereAreDoc();
                    if(notifyFlag()){
                        System.out.println("There is a document saved. Do you want to load it? (Y/N)");
                    Scanner secondScanner = new Scanner(System.in);
                    String secondCase = secondScanner.nextLine();
                    if (secondCase.equalsIgnoreCase("y")) {
                        controller.restoreDocController();
                    }
                    else if (secondCase.equalsIgnoreCase("n")){
                        controller.deleteDocController(".\\temp.txt");
                    }
                    else{
                        System.out.println("Only Y/N");
                        break;
                    }
                    }
                    else
                        System.out.println("There are no documents saved");
                    break;
                case ("2"):
                    controller.addDocController();
                    break;
                case ("3"):
                    controller.checkThereAreDoc();
                    if(notifyFlag())
                    controller.createBDL();
                    else
                        System.out.println("There are no documents loaded to extract BDL");
                    break;
                case ("4"):
                    System.out.println("Exit");
                    System.exit(0);

            }
        }
    }

    @Override
    public void notifyMe() {
        System.out.println(presenter.getPresenter());
    }

    @Override
    public boolean notifyFlag() {
        return presenter.isFlag();
    }
}

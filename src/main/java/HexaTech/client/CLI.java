package HexaTech.client;

import HexaTech.ControllerPresenter.Controller;
import HexaTech.ControllerPresenter.Presenter;

import java.io.IOException;
import java.util.Scanner;

public class CLI implements myObserver{
    Controller controller;
    Presenter presenter;

    public CLI(Controller c, Presenter p){
        controller=c;
        presenter=p;
        presenter.addobss(this);
    }
    public void useCase() throws IOException {
        String temp;
        while (true) {
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
                    controller.createBAL();
                    break;
                case ("3"):
                    System.out.println("Esci");
                    System.exit(0);

            }
        }
    }
//System.out.println("Use case: \n 1: Add a BDL \n 2: Add a Gherkin  \n 3: Extract BAL \n 4: Exit");
    @Override
    public void notifyme() {
        System.out.println(presenter.getS());
    }
}

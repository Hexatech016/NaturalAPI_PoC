package HexaTech.ControllerPresenter;

import HexaTech.PortInterface.AddBDLInputPort;
import HexaTech.PortInterface.AddGherkinInputPort;
import HexaTech.PortInterface.CreateBALInputPort;

import java.io.IOException;


public class Controller {
    AddBDLInputPort addBdl;
    AddGherkinInputPort addGherkin;
    CreateBALInputPort createBAL;

    public Controller(AddBDLInputPort addB, AddGherkinInputPort addD, CreateBALInputPort crBAL){
        addBdl=addB;
        addGherkin=addD;
        createBAL=crBAL;
    }

    public void addBDLController() throws IOException {
        addBdl.addBussinessDomainLanguage();
    }

    public void addGherkinController() throws IOException {
        addGherkin.addFeature();
    }

    public void createBAL() throws IOException {
        createBAL.createBussinessApplicationLanguage();
    }
}

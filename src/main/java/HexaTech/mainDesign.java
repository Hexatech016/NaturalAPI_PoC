package HexaTech;

import HexaTech.ControllerPresenter.Controller;
import HexaTech.ControllerPresenter.Presenter;
import HexaTech.Filesystem.fileSystem;
import HexaTech.Interactor.AddBDL;
import HexaTech.Interactor.AddGherkin;
import HexaTech.Interactor.CreateBAL;
import HexaTech.Model.Model;
import HexaTech.Repo.Repo;
import HexaTech.Stanford.Stanford;
import HexaTech.client.CLI;

import java.io.IOException;


public class mainDesign {
    public static void main(String[] args) throws IOException {
        Presenter presenter=new Presenter();
        fileSystem fileS=new fileSystem();
        Repo repo=new Repo(fileS);
        Stanford nlp=new Stanford();
        Model model=new Model(nlp);
        AddBDL bidiel=new AddBDL(presenter,repo);
        AddGherkin gherkin=new AddGherkin(presenter,repo,model);
        CreateBAL bal=new CreateBAL(presenter,repo,model);
        Controller controller=new Controller(bidiel,gherkin,bal);
        CLI cliente=new CLI(controller,presenter);
        //if(fileS.esisteDoc(".\\temp.txt"))
            //cliente.existsBackUp();
        cliente.useCase();
    }
}


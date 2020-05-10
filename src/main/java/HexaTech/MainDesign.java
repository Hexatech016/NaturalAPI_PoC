/**
 * @file MainDesign
 * @version 2.0.0
 * @type java
 * @data 2020-04-26
 * @author Gerardo Kokoshari
 * @email hexatech016@gmail.com
 * @license MIT
 */

package HexaTech;

import HexaTech.ControllerPresenter.Controller;
import HexaTech.ControllerPresenter.Presenter;
import HexaTech.FileSystem.FileSystem;
import HexaTech.Interactor.AddBDL;
import HexaTech.Interactor.AddGherkin;
import HexaTech.Interactor.CreateBAL;
import HexaTech.Model.Model;
import HexaTech.Repo.Repo;
import HexaTech.Stanford.Stanford;
import HexaTech.Client.CLI;

import java.io.IOException;

/**
 * Class used to manage the flow of program execution.
 */
public class MainDesign {
    public static void main(String[] args) throws IOException {
        Presenter presenter=new Presenter();
        FileSystem fileSystem=new FileSystem();
        Repo repo=new Repo(fileSystem);
        Stanford nlp=new Stanford();
        Model model=new Model(nlp);
        AddBDL bdl=new AddBDL(presenter,repo);
        AddGherkin gherkin=new AddGherkin(presenter,repo,model);
        CreateBAL bal=new CreateBAL(presenter,repo,model);
        Controller controller=new Controller(bdl,gherkin,bal);
        CLI client=new CLI(controller,presenter);
        client.useCase();
    }//main

}//MainDesign


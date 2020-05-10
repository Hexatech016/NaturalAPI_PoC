/**
 * @file MainDiscover
 * @version 2.0.0
 * @type java
 * @data 2020-04-26
 * @author Alessio Barbiero
 * @email hexatech016@gmail.com
 * @license MIT
 */

package HexaTech;

import HexaTech.ControllerPresenter.Controller;
import HexaTech.ControllerPresenter.Presenter;
import HexaTech.Filesystem.FileSystem;
import HexaTech.Interactor.AddDocToParse;
import HexaTech.Interactor.CheckThereAreDoc;
import HexaTech.Interactor.CreateBDL;
import HexaTech.Interactor.DeleteDoc;
import HexaTech.Model.Model;
import HexaTech.Repo.Repo;
import HexaTech.Stanford.Stanford;
import HexaTech.Client.CLI;

import java.io.IOException;

/**
 * Class used to manage the flow of program execution.
 */
public class MainDiscover {
    public static void main(String[] args) throws IOException {
        Presenter presenter=new Presenter();
        FileSystem fileSystem=new FileSystem();
        Repo repo=new Repo(fileSystem);
        Stanford stanford=new Stanford();
        Model model=new Model(stanford);
        AddDocToParse addDocToParse=new AddDocToParse(presenter,repo);
        DeleteDoc deleteDoc=new DeleteDoc(presenter,repo);
        CreateBDL createBDL=new CreateBDL(presenter,repo,model);
        CheckThereAreDoc checkThereAreDoc=new CheckThereAreDoc(presenter,repo);
        Controller controller=new Controller(addDocToParse,createBDL,deleteDoc,checkThereAreDoc);
        CLI client=new CLI(controller,presenter);
        client.useCase();
    }//main

}//MainDiscover


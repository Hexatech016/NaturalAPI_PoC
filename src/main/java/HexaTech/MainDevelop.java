/**
 * @file main
 * @version 1.0.0
 * @type java
 * @data 2020-05-01
 * @author Jacopo Battilana
 * @email hexatech016@gmail.com
 * @license
 * @changeLog
 */

package HexaTech;

import HexaTech.Client.CLI;
import HexaTech.Interactor.AddDocument;
import HexaTech.Interactor.CreateAPI;
import HexaTech.Interactor.RemoveDocument;
import HexaTech.Model.Model;
import HexaTech.Repo.Repo;
import HexaTech.Swagger.Swagger;
import HexaTech.ControllerPresenter.Controller;
import HexaTech.ControllerPresenter.Presenter;
import HexaTech.FileSystem.FileSystem;

import java.io.IOException;

/**
 * Class used to manage the flow of program execution.
 */
public class MainDevelop {
    public static void main(String[] args) throws IOException {
        Presenter presenter=new Presenter();
        FileSystem fileSystem=new FileSystem();
        Repo repo=new Repo(fileSystem);
        Swagger swagger=new Swagger();
        Model model=new Model(swagger);
        AddDocument addDocument=new AddDocument(presenter,repo);
        RemoveDocument removeDocument=new RemoveDocument(presenter,repo);
        CreateAPI createAPI=new CreateAPI(presenter,repo,model);
        Controller controller=new Controller(addDocument,createAPI,removeDocument);
        CLI client=new CLI(controller,presenter);
        boolean choice=false;
        if(fileSystem.existsDoc(".\\temp.txt"))
            choice=client.existsBackUp();
        client.useCase(choice);
    }
}

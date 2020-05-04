/**
 * @file Controller
 * @version 0.0.1
 * @type java
 * @data 2020-04-25
 * @author Eduard Serban
 * @email hexatech016@gmail.com
 * @license MIT
 */

package HexaTech.ControllerPresenter;

import HexaTech.PortInterface.AddDocToParseInputPort;
import HexaTech.PortInterface.CheckThereAreDocInputPort;
import HexaTech.PortInterface.CreateBDLInputPort;
import HexaTech.PortInterface.DeleteDocInputPort;

import java.io.IOException;

/**
 * Class used to invoke methods to perform, based on input actions.
 */
public class Controller {
    AddDocToParseInputPort addDocToParseInputPort;
    CreateBDLInputPort createBDLInputPort;
    DeleteDocInputPort deleteDocInputPort;
    CheckThereAreDocInputPort checkThereAreDocInputPort;

    /**
     * Controller class constructor.
     * @param addDocToParseInputPort AddDocToParseInputPort - used to communicate with AddDocToParse interactor.
     * @param createBDLInputPort CreateBDLInputPort - used to communicate with CreateBDL interactor.
     * @param deleteDocInputPort DeleteDocInputPort - used to communicate with DeleteDoc interactor.
     * @param checkThereAreDocInputPort CheckThereAreDocInputPort - used to communicate with CheckThereAreDoc interactor.
     */
    public Controller(AddDocToParseInputPort addDocToParseInputPort, CreateBDLInputPort createBDLInputPort,
                      DeleteDocInputPort deleteDocInputPort, CheckThereAreDocInputPort checkThereAreDocInputPort) {
        this.addDocToParseInputPort = addDocToParseInputPort;
        this.createBDLInputPort = createBDLInputPort;
        this.deleteDocInputPort = deleteDocInputPort;
        this.checkThereAreDocInputPort = checkThereAreDocInputPort;
    }

    /**
     * Invokes AddDocToParse method to add a new document.
     * @throws IOException if the document to add doesn't exist.
     */
    public void addDocController() throws IOException {
        addDocToParseInputPort.addDocument();
    }

    /**
     * Invokes AddDocToParse method to restore a backup file.
     * @throws IOException if the backup file doesn't exist.
     */
    public void restoreDocController() throws IOException {
        addDocToParseInputPort.loadBackUp();
    }

    /**
     * Invokes CreateBDL method to create a new BDL object;
     * @throws IOException if BDL can't be created from repo's stored document.
     */
    public void createBDL() throws IOException {
        createBDLInputPort.createBdl();
    }

    /**
     * Invokes DeleteDoc method to delete a document.
     * @param path string - path to the file to be removed.
     */
    public void deleteDocController(String path){
        deleteDocInputPort.deleteDocs(path);
    }

    /**
     * Invokes CheckThereAreDoc method to check the presence of a stored document.
     */
    public void checkThereAreDoc() {
        checkThereAreDocInputPort.checkThereAreDoc();
    }
}

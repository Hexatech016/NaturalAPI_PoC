/**
 * @file Controller
 * @version 2.0.0
 * @type java
 * @data 2020-04-30
 * @author Luca Marcon
 * @email hexatech016@gmail.com
 * @license MIT
 */

package HexaTech.ControllerPresenter;

import HexaTech.Interactor.AddDocumentInputPort;
import HexaTech.Interactor.CreateAPIInputPort;
import HexaTech.Interactor.RemoveDocumentInputPort;

import java.io.IOException;

/**
 * Class used to invoke methods to perform, based on input actions.
 */
public class Controller{
    private final AddDocumentInputPort addDocumentInputPort;
    private final CreateAPIInputPort createAPIInputPort;
    private final RemoveDocumentInputPort removeDocumentInputPort;

    /**
     * Controller class constructor.
     * @param addDocumentInputPort AddDocumentInputPort - used to communicate with AddDocument interactor.
     * @param createAPIInputPort CreateAPIInputPort - used to communicate with CreateAPI interactor.
     * @param removeDocumentInputPort RemoveDocumentInputPort - used to communicate with RemoveDocument interactor.
     */
    public Controller(AddDocumentInputPort addDocumentInputPort, CreateAPIInputPort createAPIInputPort,
                      RemoveDocumentInputPort removeDocumentInputPort) {
        this.addDocumentInputPort=addDocumentInputPort;
        this.createAPIInputPort=createAPIInputPort;
        this.removeDocumentInputPort=removeDocumentInputPort;
    }//Controller

    /**
     * Invokes AddDocument method to add a new document.
     * @throws IOException if the document to add doesn't exist.
     */
    public void addDocController() throws IOException {
        addDocumentInputPort.addDocument();
    }

    /**
     * Invokes AddDocument method to restore backup.
     * @throws IOException if the document to restore doesn't exist.
     */
    public void restoreDocController() throws IOException{
        addDocumentInputPort.loadBackUp();
    }

    /**
     * Invokes DeleteDocument method to delete a document.
     * @param path string - path to the file to be removed.
     */
    public void deleteDocController(String path){
        removeDocumentInputPort.removeDoc(path);
    }

    /**
     * Invokes CreateAPI method to create a new API object;
     * @throws IOException if API can't be created to repo's stored document.
     */
    public void createAPIController() throws IOException {
        createAPIInputPort.createAPI();
    }

    /**
     * Invokes AddDocument method to add a PLA file.
     * @throws IOException if the specified file doesn't exist.
     */
    public void addPLAController() throws IOException{
        addDocumentInputPort.addPLA();
    }

    /**
     * Invokes AddDocument method to change PLA file source.
     * @param path string - PLA source file path.
     * @throws IOException if the specified path doesn't exist.
     */
    public void refreshPLAController(String path) throws IOException{
        addDocumentInputPort.updatePLA(path);
    }

}//Controller

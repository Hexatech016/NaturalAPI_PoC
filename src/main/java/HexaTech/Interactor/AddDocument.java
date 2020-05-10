/**
 * @file AddDocument
 * @version 2.0.0
 * @type java
 * @data 2020-04-30
 * @author Luca Marcon
 * @email hexatech016@gmail.com
 * @license MIT
 */

package HexaTech.Interactor;

import HexaTech.Repo.RepoInterface;

import java.io.IOException;

/**
 * Class used to manage a document insertion.
 */
public class AddDocument implements AddDocumentInputPort {
    AddDocumentOutputPort addDocumentOutputPort;
    RepoInterface repoInterface;

    /**
     * Add document standard constructor.
     * @param addDocumentOutputPort AddDocumentOutputPort - used to send output notifications.
     * @param repoInterface RepoInterface - used to communicate with Repo.
     */
    public AddDocument(AddDocumentOutputPort addDocumentOutputPort, RepoInterface repoInterface) {
        this.addDocumentOutputPort=addDocumentOutputPort;
        this.repoInterface=repoInterface;
    }

    /**
     * Loads a new document.
     * @throws IOException if an error occurs during loading process.
     */
    public void addDocument() throws IOException {
        boolean loaded=repoInterface.setBALPath();
        if(loaded) {
            addDocumentOutputPort.showAddedDocument("BAL loaded");
            addDocumentOutputPort.showDone(true);
        }else
            addDocumentOutputPort.showDone(false);
    }//addDocument

    /**
     * Loads a new PLA.
     * @throws IOException if an error occurs during loading process.
     */
    public void addPLA() throws IOException{
        boolean loaded=repoInterface.setPLAPath();
        if(loaded) {
            addDocumentOutputPort.showAddedDocument("PLA loaded");
            addDocumentOutputPort.showDone(true);
        }else
            addDocumentOutputPort.showDone(false);
    }//addPLA

    /**
     * Updates PLA's reference.
     * @param path string - new PLA's path.
     * @throws IOException if the specified document doesn't exist.
     */
    public void updatePLA(String path) throws IOException{
        repoInterface.setPLA(path);
    }

    /**
     * Load a backup file.
     * @throws IOException if the file doesn't exist.
     */
    public void loadBackUp() throws IOException {
        repoInterface.loadBackUp();
        addDocumentOutputPort.showRestoredBackUp("Backup restored");
    }

}//AddDocument

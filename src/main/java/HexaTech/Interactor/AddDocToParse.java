/**
 * @file AddDocToParse
 * @version 2.0.0
 * @type java
 * @data 2020-04-25
 * @author Eduard Serban
 * @email hexatech016@gmail.com
 * @license MIT
 */

package HexaTech.Interactor;

import HexaTech.PortInterface.AddDocToParseInputPort;
import HexaTech.PortInterface.AddDocToParseOutputPort;
import HexaTech.Repo.RepoInterface;

import java.io.IOException;

/**
 * Class used to manage a document insertion.
 */
public class AddDocToParse implements AddDocToParseInputPort {
    AddDocToParseOutputPort addDocToParseOutputPort;
    RepoInterface repoInterface;

    /**
     * AddDocuToParse standard constructor.
     * @param addDocToParseOutputPort AddDocToParseOutputPort - used to send output notifications.
     * @param repoInterface RepoInterface - used to communicate with Repo.
     */
    public AddDocToParse(AddDocToParseOutputPort addDocToParseOutputPort, RepoInterface repoInterface) {
        this.addDocToParseOutputPort = addDocToParseOutputPort;
        this.repoInterface = repoInterface;
    }

    /**
     * Loads a new document.
     * @throws IOException if an error occurs during loading process.
     */
    public void addDocument() throws IOException {
        repoInterface.returnPath();
        addDocToParseOutputPort.showAddDocument("Document added");
    }

    /**
     * Load a backup file.
     * @throws IOException if the file doesn't exist.
     */
    public void loadBackUp() throws IOException {
        repoInterface.loadBackUp();
        addDocToParseOutputPort.showBackUpRestored("Backup loaded");
    }

}//AddDocToParse

/**
 * @file DeleteDoc
 * @version 2.0.0
 * @type java
 * @data 2020-04-25
 * @author Luca Marcon
 * @email hexatech016@gmail.com
 * @license MIT
 */

package HexaTech.Interactor;

import HexaTech.PortInterface.DeleteDocInputPort;
import HexaTech.PortInterface.DeleteDocOutputPort;
import HexaTech.Repo.RepoInterface;

/**
 * Class used to manage a file deletion.
 */
public class DeleteDoc implements DeleteDocInputPort {
    DeleteDocOutputPort deleteDocOutputPort;
    RepoInterface repoInterface;

    /**
     * DeleteDoc standard constructor.
     * @param deleteDocOutputPort DeleteDocOutputPort - used to send output notifications.
     * @param repoInterface RepoInterface - used to communicate with Repo.
     */
    public DeleteDoc(DeleteDocOutputPort deleteDocOutputPort, RepoInterface repoInterface) {
        this.deleteDocOutputPort = deleteDocOutputPort;
        this.repoInterface = repoInterface;
    }

    /**
     * Delete the specified document.
     * @param path string - document to be deleted.
     */
    public void deleteDocs(String path){
        if(repoInterface.delete(path))
        deleteDocOutputPort.showDeletedDoc("Document deleted");
    }

}//DeleteDoc

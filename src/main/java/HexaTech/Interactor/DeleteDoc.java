/**
 * @file DeleteDoc
 * @version 0.0.1
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

public class DeleteDoc implements DeleteDocInputPort {
    DeleteDocOutputPort deleteDocOutputPort;
    RepoInterface repoInterface;

    public DeleteDoc(DeleteDocOutputPort deleteDocOutputPort, RepoInterface repoInterface) {
        this.deleteDocOutputPort = deleteDocOutputPort;
        this.repoInterface = repoInterface;
    }

    public void deleteDocs(String s){
        if(repoInterface.delete(s))
        deleteDocOutputPort.showDeletedDoc("Documents deleted");
    }
}

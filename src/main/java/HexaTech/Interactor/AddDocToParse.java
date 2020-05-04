/**
 * @file AddDocToParse
 * @version 0.0.1
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

public class AddDocToParse implements AddDocToParseInputPort {
    AddDocToParseOutputPort addDocToParseOutputPort;
    RepoInterface repoInterface;

    public AddDocToParse(AddDocToParseOutputPort addDocToParseOutputPort, RepoInterface repoInterface) {
        this.addDocToParseOutputPort = addDocToParseOutputPort;
        this.repoInterface = repoInterface;
    }

    public void addDocument() throws IOException {
        repoInterface.returnPath();
        addDocToParseOutputPort.showAddDocument("Document added");
    }
    public void loadBackUp() throws IOException {
        repoInterface.loadBackUp();
        addDocToParseOutputPort.showBackUpRestored("Backup loaded");
    }
}

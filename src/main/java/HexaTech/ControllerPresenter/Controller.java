/**
 * @file Controller
 * @version 0.0.1
 * @type java
 * @data 2020-04-25
 * @author Eduard Serban
 * @email hexatech016@gmail.com
 * @license
 * @changeLog
 */

package HexaTech.ControllerPresenter;

import HexaTech.PortInterface.AddDocToParseInputPort;
import HexaTech.PortInterface.CheckThereAreDocInputPort;
import HexaTech.PortInterface.CreateBDLInputPort;
import HexaTech.PortInterface.DeleteDocInputPort;

import java.io.IOException;

public class Controller {
    AddDocToParseInputPort addDocToParseInputPort;
    CreateBDLInputPort createBDLInputPort;
    DeleteDocInputPort deleteDocInputPort;
    CheckThereAreDocInputPort checkThereAreDocInputPort;

    public Controller(AddDocToParseInputPort addDocToParseInputPort, CreateBDLInputPort createBDLInputPort,
                      DeleteDocInputPort deleteDocInputPort, CheckThereAreDocInputPort checkThereAreDocInputPort) {
        this.addDocToParseInputPort = addDocToParseInputPort;
        this.createBDLInputPort = createBDLInputPort;
        this.deleteDocInputPort = deleteDocInputPort;
        this.checkThereAreDocInputPort = checkThereAreDocInputPort;
    }

    public void addDocController() throws IOException {
        addDocToParseInputPort.addDocument();
    }

    public void restoreDocController() throws IOException {
        addDocToParseInputPort.loadBackUp();
    }

    public void createBDL() throws IOException {
        createBDLInputPort.createBdl();
    }

    public void deleteDocController(String path){
        deleteDocInputPort.deleteDocs(path);
    }

    public void checkThereAreDoc() {
        checkThereAreDocInputPort.checkThereAreDoc();
    }
}

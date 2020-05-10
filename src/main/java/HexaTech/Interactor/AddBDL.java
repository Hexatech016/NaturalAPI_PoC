/**
 * @file AddBDL
 * @version 2.0.0
 * @type java
 * @data 2020-04-25
 * @author Matteo Brosolo
 * @email hexatech016@gmail.com
 * @license MIT
 */

package HexaTech.Interactor;

import HexaTech.PortInterface.AddBDLInputPort;
import HexaTech.PortInterface.AddBDLOutputPort;
import HexaTech.Repo.RepoInterface;

import java.io.IOException;

/**
 * Class used to manage a BDL insertion.
 */
public class AddBDL implements AddBDLInputPort {

    AddBDLOutputPort addBDLOutputPort;
    RepoInterface repoInterface;

    /**
     * AddBDL class constructor.
     * @param addBDLOutputPort AddBDLOutputPort - used to send output notifications.
     * @param repoInterface RepoInterface - used to communicate with repo.
     */
    public AddBDL(AddBDLOutputPort addBDLOutputPort, RepoInterface repoInterface){
        this.addBDLOutputPort=addBDLOutputPort;
        this.repoInterface=repoInterface;
    }

    /**
     * Loads a new BDL.
     * @throws IOException if an error occurs during loading process.
     */
    @Override
    public void addBDL() throws IOException {
        repoInterface.setBDLPath();
        addBDLOutputPort.showAddedBDL("BDL added.");
    }

}//AddBDL

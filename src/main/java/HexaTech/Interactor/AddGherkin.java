/**
 * @file AddGherkin
 * @version 1.0.0
 * @type java
 * @data 2020-04-25
 * @author Gerardo Kokoshari
 * @email hexatech016@gmail.com
 * @license MIT
 */

package HexaTech.Interactor;

import HexaTech.Model.ModelInterface;
import HexaTech.PortInterface.AddGherkinInputPort;
import HexaTech.PortInterface.AddGherkinOutputPort;
import HexaTech.Repo.RepoInterface;

import java.io.IOException;

/**
 * Class used to manage a Gherkin insertion.
 */
public class AddGherkin implements AddGherkinInputPort {

    AddGherkinOutputPort addGherkinOutputPort;
    RepoInterface repoInterface;
    ModelInterface modelInterface;

    /**
     * AddGherkin class constructor.
     * @param addGherkinOutputPort AddGherkinOutputPort - used to send output notifications.
     * @param repoInterface RepoInterface - used to communicate with repo.
     * @param modelInterface ModelInterface - used to communicate with model.
     */
    public AddGherkin(AddGherkinOutputPort addGherkinOutputPort, RepoInterface repoInterface, ModelInterface modelInterface){
        this.addGherkinOutputPort=addGherkinOutputPort;
        this.repoInterface=repoInterface;
        this.modelInterface=modelInterface;
    }

    /**
     * Loads a new Gherkin scenario.
     * @throws IOException if an error occurs during loading process.
     */
    @Override
    public void addGherkin() throws IOException {
        repoInterface.setGherkinPath();
        addGherkinOutputPort.showAddedGherkin("Scenario added.");
    }

}//AddGherkin

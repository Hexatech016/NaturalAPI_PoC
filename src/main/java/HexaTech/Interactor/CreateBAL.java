/**
 * @file CreateBAL
 * @version 0.0.1
 * @type java
 * @data 2020-04-25
 * @author
 * @email hexatech016@gmail.com
 * @license MIT
 */

package HexaTech.Interactor;

import HexaTech.Model.ModelInterface;
import HexaTech.PortInterface.CreateBALInputPort;
import HexaTech.PortInterface.CreateBALOutputPort;
import HexaTech.Repo.RepoInterface;
import HexaTech.Entities.BAL;

import java.io.IOException;

/**
 * Class used to manage a BAL creation.
 */
public class CreateBAL implements CreateBALInputPort {
    CreateBALOutputPort createBALOutputPort;
    RepoInterface repoInterface;
    ModelInterface modelInterface;

    /**
     * CreateBAL class constructor.
     * @param createBALOutputPort CreateBALOutputPort - used to send output notifications.
     * @param repoInterface RepoInterface - used to communicate with repo.
     * @param modelInterface ModelInterface - used to communicate with model.
     */
    public CreateBAL(CreateBALOutputPort createBALOutputPort, RepoInterface repoInterface, ModelInterface modelInterface) {
        this.createBALOutputPort = createBALOutputPort;
        this.repoInterface = repoInterface;
        this.modelInterface = modelInterface;
    }

    /**
     * Create a new BAL object.
     * @throws IOException if an error occurs during loading process.
     */
    @Override
    public void createBAL() throws IOException {
        for (String path: repoInterface.getList()) {
            String document = repoInterface.returnDocumentContent(path);
            BAL Bal=modelInterface.setBALFromGherkin(document);
            repoInterface.saveBAL(Bal);
        }//for
        createBALOutputPort.showCreatedBAL("BAL has been created.");
    }//createBAL

}//CreateBAL

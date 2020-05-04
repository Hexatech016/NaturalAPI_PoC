/**
 * @file CheckThereAreDoc
 * @version 0.0.1
 * @type java
 * @data 2020-04-25
 * @author Luca Marcon
 * @email hexatech016@gmail.com
 * @license MIT
 */

package HexaTech.Interactor;

import HexaTech.PortInterface.CheckThereAreDocInputPort;
import HexaTech.PortInterface.CheckThereAreDocOutputPort;
import HexaTech.Repo.RepoInterface;

/**
 * Class used to manage a file search.
 */
public class CheckThereAreDoc implements CheckThereAreDocInputPort {
    CheckThereAreDocOutputPort checkThereAreDocOP;
    RepoInterface repoInterface;

    /**
     * CheckThereAreDoc standard constructor.
     * @param checkThereAreDocOP CheckThereAreDocOutputPort - used to send output notifications.
     * @param repo RepoInterface - used to communicate with Repo.
     */
    public CheckThereAreDoc(CheckThereAreDocOutputPort checkThereAreDocOP, RepoInterface repo) {
        this.checkThereAreDocOP = checkThereAreDocOP;
        this.repoInterface = repo;
    }

    /**
     * Verifies if there are any loaded documents.
     */
    @Override
    public void checkThereAreDoc() {
        checkThereAreDocOP.thereAreDoc(repoInterface.checkThereAreDoc());
    }

}//CheckThereAreDoc

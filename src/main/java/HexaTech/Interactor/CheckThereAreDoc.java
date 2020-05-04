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

public class CheckThereAreDoc implements CheckThereAreDocInputPort {
    CheckThereAreDocOutputPort checkThereAreDocOP;
    RepoInterface repoInterface;

    public CheckThereAreDoc(CheckThereAreDocOutputPort checkThereAreDocOP, RepoInterface repo) {
        this.checkThereAreDocOP = checkThereAreDocOP;
        this.repoInterface = repo;
    }

    @Override
    public void checkThereAreDoc() {
        checkThereAreDocOP.thereAreDoc(repoInterface.checkThereAreDoc());
    }
}

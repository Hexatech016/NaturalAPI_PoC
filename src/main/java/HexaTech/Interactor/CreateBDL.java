/**
 * @file CreateBDL
 * @version 0.0.1
 * @type java
 * @data 2020-04-25
 * @author Alessio Barbiero
 * @email hexatech016@gmail.com
 * @license MIT
 */

package HexaTech.Interactor;

import HexaTech.Model.ModelInterface;
import HexaTech.PortInterface.CreateBDLInputPort;
import HexaTech.PortInterface.CreateBDLOutputPort;
import HexaTech.Repo.RepoInterface;
import HexaTech.Entities.BDL;

import java.io.IOException;

public class CreateBDL implements CreateBDLInputPort {
    CreateBDLOutputPort createBDLOutputPort;
    RepoInterface repoInterface;
    ModelInterface modelInterface;

    public CreateBDL(CreateBDLOutputPort output, RepoInterface repo, ModelInterface model) {
        this.createBDLOutputPort = output;
        this.repoInterface = repo;
        this.modelInterface = model;
    }

    public void createBdl() throws IOException {
        BDL bdl=new BDL();
        for(String path: repoInterface.getLista()) {
            String document = repoInterface.returnContentFromTxt(path);
            BDL bdlToMerge=modelInterface.extractBDL(document);
            bdl.mergeBDL(bdlToMerge);
        }
        repoInterface.saveBDL(bdl);
        repoInterface.delete(".\\temp.txt");
        createBDLOutputPort.showCreateBdl("BDL created in Discover");
    }

}

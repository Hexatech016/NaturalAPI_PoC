/**
 * @file CreateBDL
 * @version 1.0.0
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

/**
 * Class used to manage a BDL object's creation.
 */
public class CreateBDL implements CreateBDLInputPort {
    CreateBDLOutputPort createBDLOutputPort;
    RepoInterface repoInterface;
    ModelInterface modelInterface;

    /**
     * CreateBDL standard constructor.
     * @param output CreateBDLOutputPort - used to send output notifications.
     * @param repo RepoInterface - used to communicate with Repo.
     * @param model ModelInterface - used to communicate with Model.
     */
    public CreateBDL(CreateBDLOutputPort output, RepoInterface repo, ModelInterface model) {
        this.createBDLOutputPort = output;
        this.repoInterface = repo;
        this.modelInterface = model;
    }

    /**
     * Creates a new BDL object.
     * @throws IOException if an error occurs while loading or parsing any file.
     */
    public void createBDL() throws IOException {
        BDL bdl=new BDL();
        for(String path: repoInterface.getLista()) {
            String document = repoInterface.returnContentFromTxt(path);
            BDL bdlToMerge=modelInterface.extractBDL(document);
            bdl.mergeBDL(bdlToMerge);
        }//for
        repoInterface.saveBDL(bdl);
        repoInterface.delete(".\\Discover\\temp.txt");
        createBDLOutputPort.showCreateBdl("BDL created into folder: Discover");
    }//createBDL

}//CreateBDL

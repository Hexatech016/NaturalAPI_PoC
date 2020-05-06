package HexaTech.Interactor;

import HexaTech.Model.iModel;
import HexaTech.PortInterface.AddGherkinInputPort;
import HexaTech.PortInterface.AddGherkinOutputPort;
import HexaTech.Repo.iRepo;

import java.io.IOException;

public class AddGherkin implements AddGherkinInputPort {

    AddGherkinOutputPort addGherkin;
    iRepo repo;
    iModel model;

    public AddGherkin(AddGherkinOutputPort addGout, iRepo rep, iModel mod){
        addGherkin=addGout;
        repo=rep;
        model=mod;
    }

    @Override
    public void addFeature() throws IOException {
        repo.ritornaPathOfGherkin();
        addGherkin.showAddGherkin("Added scenario");
    }
}

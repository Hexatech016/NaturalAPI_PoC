package HexaTech.Interactor;

import HexaTech.PortInterface.AddBDLInputPort;
import HexaTech.PortInterface.AddBDLOutputPort;
import HexaTech.Repo.iRepo;

import java.io.IOException;

public class AddBDL implements AddBDLInputPort {

    AddBDLOutputPort addBDLout;
    iRepo repo;

    public AddBDL(AddBDLOutputPort Addout, iRepo rep){
        addBDLout=Addout;
        repo=rep;
    }
    @Override
    public void addBussinessDomainLanguage() throws IOException {
        repo.ritornaPathOfBDL();
        addBDLout.showAddBDL("Ho fatto le cose con successo");
    }
}

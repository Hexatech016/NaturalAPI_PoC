package HexaTech.Interactor;

import HexaTech.Model.iModel;
import HexaTech.PortInterface.CreateBALInputPort;
import HexaTech.PortInterface.CreateBALOutputPort;
import HexaTech.Repo.iRepo;
import HexaTech.entities.BAL;

import java.io.IOException;

public class CreateBAL implements CreateBALInputPort {
    CreateBALOutputPort createCreateOutput;
    iRepo repo;
    iModel model;

    public CreateBAL(CreateBALOutputPort createCreateOutput, iRepo repo, iModel model) {
        this.createCreateOutput = createCreateOutput;
        this.repo = repo;
        this.model = model;
    }

    @Override
    public void createBussinessApplicationLanguage() throws IOException {

        for (String path: repo.getLista()) {
            String document = repo.returnContentFromTxt(path);
            BAL Bal=model.provaGherkin(document);
            repo.saveBAL(Bal);
        }
        createCreateOutput.showCreateBAL("Ho fatto le cose con successo");
    }
}

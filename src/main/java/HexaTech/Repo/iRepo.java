package HexaTech.Repo;

import HexaTech.entities.BAL;
import HexaTech.entities.BDL;

import java.io.IOException;
import java.util.List;

public interface iRepo {
    void ritornaPath() throws IOException;

    void ritornaPathOfBDL() throws IOException;

    void ritornaPathOfGherkin() throws IOException;

    void salvaDocumento() throws IOException;

    void caricaBackUp() throws IOException;

    List<String> getLista();

    boolean elimina(String doc);

    String returnContentFromTxt(String path) throws IOException;

    void salvaBDL(BDL bdl) throws IOException;

    void saveBAL(BAL bal) throws IOException;

    void saveGherkin() throws IOException;
}
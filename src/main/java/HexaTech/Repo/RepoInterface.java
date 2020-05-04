/**
 * @file RepoInterface
 * @version 0.0.1
 * @type java
 * @data 2020-04-25
 * @author Luca Marcon
 * @email hexatech016@gmail.com
 * @license
 * @changeLog
 */

package HexaTech.Repo;

import HexaTech.Entities.BDL;

import java.io.IOException;
import java.util.List;

public interface RepoInterface {
    void returnPath() throws IOException;

    void saveDoc() throws IOException;

    void loadBackUp() throws IOException;

    List<String> getLista();

    boolean delete(String doc);

    String returnContentFromTxt(String path) throws IOException;

    void saveBDL(BDL bdl) throws IOException;

    void getBDLFromContentPath() throws IOException;

    boolean checkThereAreDoc();
}
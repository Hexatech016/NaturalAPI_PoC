package HexaTech.Filesystem;

import java.io.IOException;

public interface iFileSystem{
    String importPath();
    String importPathOfBDL();
    String importPathOfGherkin();
    String getContenutoFromPath(String path) throws IOException;
    void saveDoc(String documento, String path) throws IOException;
    boolean esisteDoc(String document);
    boolean eliminaDoc(String doc);
}

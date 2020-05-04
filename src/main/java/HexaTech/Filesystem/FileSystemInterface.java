/**
 * @file FileSystemInterface
 * @version 0.0.1
 * @type java
 * @data 2020-04-25
 * @author Luca Marcon
 * @email hexatech016@gmail.com
 * @license
 * @changeLog
 */

package HexaTech.Filesystem;

import java.io.IOException;

public interface FileSystemInterface {
    String importPath();

    String getContentFromPath(String path) throws IOException;

    void saveDoc(String documento, String path) throws IOException;

    boolean existsDoc(String document);

    boolean deleteDoc(String doc);
}

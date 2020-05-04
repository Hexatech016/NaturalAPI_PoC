/**
 * @file FileSystemInterface
 * @version 0.0.1
 * @type java
 * @data 2020-04-25
 * @author Luca Marcon
 * @email hexatech016@gmail.com
 * @license MIT
 */

package HexaTech.Filesystem;

import java.io.IOException;

/**
 * File system class interface.
 */
public interface FileSystemInterface {

    /**
     * Imports a document's path from disk.
     * @return string - document path. Empty string if an error occurs.
     */
    String importPath();

    /**
     * Extrapolates content from a document.
     * @param path string - document's path.
     * @return string - document's content.
     * @throws IOException if the specified document doesn't exist.
     */
    String getContentFromPath(String path) throws IOException;

    /**
     * Saves the specified content into a new document at the specified path.
     * @param doc string - new document's content.
     * @param path string - new document's path.
     * @throws IOException if occurs an error while creating the file or writing into it.
     */
    void saveDoc(String doc, String path) throws IOException;

    /**
     * Verifies if the specified document exists.
     * @param doc string - path to the document to be searched.
     * @return boolean - true if the document exists, false if not.
     */
    boolean existsDoc(String doc);

    /**
     * Deletes the specified document.
     * @param doc string - path to the document to be deleted.
     */
    boolean deleteDoc(String doc);
}

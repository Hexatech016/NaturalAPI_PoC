/**
 * @file FileSystemInterface
 * @version 2.0.0
 * @type java
 * @data 2020-04-30
 * @author Alessio Barbiero
 * @email hexatech016@gmail.com
 * @license MIT
 */

package HexaTech.FileSystem;

import java.io.IOException;

/**
 * File System interface
 */
public interface FileSystemInterface{

    /**
     * Imports a new BAL.
     * @return string - new BAL's path.
     */
    String importPathBAL();

    /**
     * Imports a new PLA.
     * @return string new PLA's path.
     */
    String importPathPLA();

    /**
     * Gets document's content.
     * @param path string - document path.
     * @return string - document content.
     * @throws IOException if the document doesn't exist.
     */
    String getContentFromPath(String path) throws IOException;

    /**
     * Gets PLA required extension.
     * @param PLA string - PLA's path.
     * @return string - required output extension.
     * @throws IOException if the PAL doesn't exist.
     */
    String getExtensionFromPLA(String PLA) throws IOException;

    /**
     * Saves the document's content into the specified path.
     * @param doc string - document's content.
     * @param path string - document's path.
     * @throws IOException if an error occurs while document's saving process.
     */
    void saveDoc(String doc, String path) throws IOException;

    /**
     * Verifies if the documents exists.
     * @param doc string - document's path.
     * @return boolean - true if document exists, false if not.
     */
    boolean existsDoc(String doc);

    /**
     * Verifies if the specified document exists into JAR archive.
     * @param doc string - path to the document to be searched.
     * @return boolean - true if the document exists, false if not.
     */
    boolean existsDocJar(String doc);

    /**
     * Delete the specified document.
     * @param doc string - path to the document to be deleted.
     */
    void deleteDoc(String doc);

}//FileSystemInterface
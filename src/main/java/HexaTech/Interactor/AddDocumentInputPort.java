/**
 * @file AddDocumentInputPort
 * @version 2.0.0
 * @type java
 * @data 2020-04-30
 * @author Luca Marcon
 * @email hexatech016@gmail.com
 * @license MIT
 */
package HexaTech.Interactor;

import java.io.IOException;

/**
 * AddDocument input interface.
 */
public interface AddDocumentInputPort {

    /**
     * Loads a new document.
     * @throws IOException if an error occurs during loading process.
     */
    void addDocument() throws IOException;

    /**
     * Loads a new PLA.
     * @throws IOException if an error occurs during loading process.
     */
    void addPLA() throws IOException;

    /**
     * Updates PLA's reference.
     * @param path string - new PLA's path.
     * @throws IOException if the specified document doesn't exist.
     */
    void updatePLA(String path) throws IOException;

    /**
     * Load a backup file.
     * @throws IOException if the file doesn't exist.
     */
    void loadBackUp() throws IOException;

}//AddDocumentInputPort

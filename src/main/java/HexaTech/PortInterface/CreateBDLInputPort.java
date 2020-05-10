/**
 * @file CreateBDLInputPort
 * @version 2.0.0
 * @type java
 * @data 2020-04-25
 * @author Eduard Serban
 * @email hexatech016@gmail.com
 * @license MIT
 */

package HexaTech.PortInterface;

import java.io.IOException;

/**
 * CreateBDL input interface.
 */
public interface CreateBDLInputPort {

    /**
     * Creates a new BDL object.
     * @throws IOException if an error occurs while loading or parsing any file.
     */
    void createBDL() throws IOException;

}//CreateBDLInputPort

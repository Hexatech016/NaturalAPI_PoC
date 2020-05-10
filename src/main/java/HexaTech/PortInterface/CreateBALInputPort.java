/**
 * @file CreateBALInputPort
 * @version 2.0.0
 * @type java
 * @data 2020-04-25
 * @author Denis Salviato
 * @email hexatech016@gmail.com
 * @license MIT
 */

package HexaTech.PortInterface;

import java.io.IOException;

/**
 * CreateBAL input interface.
 */
public interface CreateBALInputPort {

    /**
     * Create a new BAL object.
     * @throws IOException if an error occurs during loading process.
     */
    void createBAL() throws IOException;

}//CreateBALInputPort

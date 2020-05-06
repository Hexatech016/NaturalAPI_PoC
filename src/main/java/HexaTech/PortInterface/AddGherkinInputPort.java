/**
 * @file AddGherkinInputPort
 * @version 0.0.1
 * @type java
 * @data 2020-04-25
 * @author
 * @email hexatech016@gmail.com
 * @license MIT
 */

package HexaTech.PortInterface;

import java.io.IOException;

/**
 * AddGherkin input interface.
 */
public interface AddGherkinInputPort {

    /**
     * Loads a new Gherkin scenario.
     * @throws IOException if an error occurs during loading process.
     */
    void addGherkin() throws IOException;

}//AddGherkinInputInterface

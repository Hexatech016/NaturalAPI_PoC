/**
 * @file AddDocToParseInputPort
 * @version 0.0.1
 * @type java
 * @data 2020-04-25
 * @author Eduard Serban
 * @email hexatech016@gmail.com
 * @license MIT
 */

package HexaTech.PortInterface;

import java.io.IOException;

public interface AddDocToParseInputPort {
    void addDocument() throws IOException;

    void loadBackUp() throws IOException;
}

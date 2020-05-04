/**
 * @file ModelInterface
 * @version 0.0.1
 * @type java
 * @data 2020-04-25
 * @author Alessio Barbiero
 * @email hexatech016@gmail.com
 * @license MIT
 */

package HexaTech.Model;

import HexaTech.Entities.BDL;

/**
 * Model class interface.
 */
public interface ModelInterface {

    /**
     * Fills BDL object with content found into specified documents.
     * @param text string - documents' content.
     * @return BDL - new BDL object.
     */
    BDL extractBDL(String text);

}//ModelInterface

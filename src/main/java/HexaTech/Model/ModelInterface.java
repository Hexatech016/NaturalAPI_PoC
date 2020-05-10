/**
 * @file ModelInterface
 * @version 2.0.0
 * @type java
 * @data 2020-04-25
 * @author Eduard Serban
 * @email hexatech016@gmail.com
 * @license MIT
 */

package HexaTech.Model;

import HexaTech.Entities.BAL;
import HexaTech.Entities.BDL;

public interface ModelInterface {
    //BDL extract(String text);

    /**
     * Fills a BAL object with the given text parsed elements.
     * @param text string - text to be parsed.
     * @return BAL - filled BAL object.
     */
    BAL setBALFromGherkin(String text);

}//ModelInterface

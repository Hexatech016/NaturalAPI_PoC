/**
 * @file ModelInterface
 * @version 0.0.1
 * @type java
 * @data 2020-04-25
 * @author Alessio Barbiero
 * @email hexatech016@gmail.com
 * @license
 * @changeLog
 */

package HexaTech.Model;

import HexaTech.Entities.BDL;

public interface ModelInterface {
    BDL extractBDL(String text);
}

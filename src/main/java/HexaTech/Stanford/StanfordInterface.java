/**
 * @file StanfordInterface
 * @version 0.0.1
 * @type java
 * @data 2020-04-25
 * @author Eduard Serban
 * @email hexatech016@gmail.com
 * @license
 * @changeLog
 */

package HexaTech.Stanford;

import HexaTech.Entities.DoubleStruct;

import java.util.List;

public interface StanfordInterface {
    List<DoubleStruct> extract(String text);
}

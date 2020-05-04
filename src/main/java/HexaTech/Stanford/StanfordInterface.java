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

/**
 * Stanford class interface.
 */
public interface StanfordInterface {

    /**
     * Fills a list with elements found while parsing the given text.
     * @param content string - document's content to analyze.
     * @return List<DoubleStruct> - list of found elements.
     */
    List<DoubleStruct> extract(String content);

}//StanfordInterface

/**
 * @file StanfordInterface
 * @version 1.0.0
 * @type java
 * @data 2020-04-30
 * @author Matteo Brosolo
 * @email hexatech016@gmail.com
 * @license MIT
 */

package HexaTech.Stanford;

import HexaTech.Entities.Gherkin;

/**
 * Stanford class interface.
 */
public interface StanfordInterface{

   /**
    * Extracts Gherkin elements from given text.
    * @param text string - text to be analyzed.
    * @return Gherkin - content extracted by the method.
    */
   Gherkin extractGherkin(String text);

}//StandardInterface

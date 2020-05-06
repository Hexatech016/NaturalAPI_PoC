/**
 * @file AddGherkinOutputPort
 * @version 0.0.1
 * @type java
 * @data 2020-04-25
 * @author
 * @email hexatech016@gmail.com
 * @license MIT
 */

package HexaTech.PortInterface;

/**
 * AddGherkin output interface.
 */
public interface AddGherkinOutputPort {

    /**
     * Notifies the message from Gherkin addiction.
     * @param result string - message text.
     */
    void showAddedGherkin(String result);

}//AddGherkinOutputPort

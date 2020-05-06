/**
 * @file CreateBALOutputPort
 * @version 0.0.1
 * @type java
 * @data 2020-04-25
 * @author
 * @email hexatech016@gmail.com
 * @license MIT
 */

package HexaTech.PortInterface;

/**
 * CreateBAL output interface.
 */
public interface CreateBALOutputPort {

    /**
     * Notifies the message from BAL creation.
     * @param result string - message text.
     */
    void showCreatedBAL(String result);

}//CreateBAL

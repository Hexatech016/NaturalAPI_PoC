/**
 * @file CreateBALOutputPort
 * @version 2.0.0
 * @type java
 * @data 2020-04-25
 * @author Denis Salviato
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

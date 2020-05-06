/**
 * @file AddBDLOutputPort
 * @version 0.0.1
 * @type java
 * @data 2020-04-25
 * @author
 * @email hexatech016@gmail.com
 * @license MIT
 */

package HexaTech.PortInterface;

/**
 * AddBDL output interface.
 */
public interface AddBDLOutputPort {

    /**
     * Notifies the message from BDL addiction.
     * @param result string - message text.
     */
    void showAddedBDL(String result);

}//AddBDLOutputPort

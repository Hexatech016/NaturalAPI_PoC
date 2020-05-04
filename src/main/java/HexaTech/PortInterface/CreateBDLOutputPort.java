/**
 * @file CreateBDLOutputPort
 * @version 0.0.1
 * @type java
 * @data 2020-04-25
 * @author Eduard Serban
 * @email hexatech016@gmail.com
 * @license MIT
 */

package HexaTech.PortInterface;

/**
 * CreateBDL output interface.
 */
public interface CreateBDLOutputPort {

    /**
     * Notifies the message from creating BDL action.
     * @param result string - message text.
     */
    void showCreateBdl(String result);

}//CreateBDLOutputPort

/**
 * @file CheckThereAreDocOutputPort
 * @version 0.0.1
 * @type java
 * @data 2020-04-25
 * @author Luca Marcon
 * @email hexatech016@gmail.com
 * @license MIT
 */

package HexaTech.PortInterface;

/**
 * CheckThereAreDoc output interface.
 */
public interface CheckThereAreDocOutputPort {

    /**
     * Notifies the flag from document search action.
     * @param flag boolean - true if backup was found, false if not.
     */
    void thereAreDoc(boolean flag);

}//CheckThereAreDocOutputPort

/**
 * @file AddDocToParseOutputPort
 * @version 0.0.1
 * @type java
 * @data 2020-04-25
 * @author Eduard Serban
 * @email hexatech016@gmail.com
 * @license MIT
 */

package HexaTech.PortInterface;

/**
 * AddDocument output interface.
 */
public interface AddDocToParseOutputPort {

    /**
     * Notifies the message from adding document action.
     * @param result string - message text.
     */
    void showAddDocument(String result);

    /**
     * Notifies the message from restoring backup action.
     * @param result string - message text.
     */
    void showBackUpRestored(String result);

}//AddDocToParseOutputPort

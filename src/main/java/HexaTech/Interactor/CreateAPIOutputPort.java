/**
 * @file CreateAPIOutputPort
 * @version 0.0.1
 * @type java
 * @data 2020-04-30
 * @author Alessio Barbiero
 * @email hexatech016@gmail.com
 * @license MIT
 */

package HexaTech.Interactor;

/**
 * CreateAPI output interface.
 */
public interface CreateAPIOutputPort {

    /**
     * Notifies the message from API creation.
     * @param result string - message text.
     */
    void showCreatedAPI(String result);

    /**
     * Notifies the error code if something went wrong during API creation.
     * @param error int - error code.
     */
    void showErrorCodeAPI(int error);

    /**
     * Notifies the message from removing document action.
     * @param result string - message text.
     */
    void showErrorTextAPI(String result);
}

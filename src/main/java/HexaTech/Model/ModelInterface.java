/**
 * @file ModelInterface
 * @version 2.0.0
 * @type java
 * @data 2020-05-01
 * @author Jacopo Battilana
 * @email hexatech016@gmail.com
 * @license MIT
 */

package HexaTech.Model;

import HexaTech.Entities.API;

/**
 * Model interface.
 */
public interface ModelInterface{

    /**
     * Fills API object with Swagger found arguments into the specified PLA.
     * @param path string - PLA's path.
     * @return API - new API object.
     */
    API setAPI(String path);

}//ModelInterface

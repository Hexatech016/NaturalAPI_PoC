/**
 * @file Model
 * @version 2.0.0
 * @type java
 * @data 2020-05-01
 * @author Jacopo Battilana
 * @email hexatech016@gmail.com
 * @license MIT
 */

package HexaTech.Model;

import HexaTech.Entities.API;
import HexaTech.Swagger.SwaggerInterface;

/**
 * Class used to use Swagger tools into the project.
 */
public class Model implements ModelInterface {
    SwaggerInterface swaggerInterface;

    /**
     * Model class constructor.
     * @param swaggerInterface SwaggerInterface - used to communicate with Swagger tools class.
     */
    public Model(SwaggerInterface swaggerInterface) {
        this.swaggerInterface=swaggerInterface;
    }

    /**
     * Fills API object with Swagger found arguments into the specified PLA.
     * @param path string - PLA's path.
     * @return API - new API object.
     */
     public API setAPI(String path) throws IllegalArgumentException{
        API temp=new API();
        if(swaggerInterface.extractAPIMethods(path)!=null && swaggerInterface.extractAPIStructures(path)!=null &&
                swaggerInterface.extractAPIName(path)!=null && swaggerInterface.extractAPIDescription(path)!=null){
            temp.setAPIMethods(swaggerInterface.extractAPIMethods(path));
            temp.setAPIStructures(swaggerInterface.extractAPIStructures(path));
            temp.setAPIName(swaggerInterface.extractAPIName(path));
            temp.setAPIComment(swaggerInterface.extractAPIDescription(path));
            return temp;
        }else
            return null;
    }//setAPI

}//Model

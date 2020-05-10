/**
 * @file MyObserver
 * @version 2.0.0
 * @type java
 * @data 2020-04-25
 * @author Alessio Barbiero
 * @email hexatech016@gmail.com
 * @license MIT
 */

package HexaTech.Client;

public interface MyObserver {

     /**
      * Receives presenter's message status and show it to user.
      */
     void notifyMe();

     /**
      * Receives presenter's flag status and return it.
      * @return boolean - presenter's flag.
      */
     boolean notifyFlag();

}//MyObserver

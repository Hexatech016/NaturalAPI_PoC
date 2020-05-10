/**
 * @file Subject
 * @version 2.0.0
 * @type java
 * @data 2020-04-25
 * @author Eduard Serban
 * @email hexatech016@gmail.com
 * @license MIT
 */

package HexaTech.ControllerPresenter;

import HexaTech.Client.MyObserver;

import java.util.ArrayList;
import java.util.List;

/**
 * Class used to synchronize actions and output messages.
 */
public class Subject {

    List<MyObserver> observers=new ArrayList<>();

    /**
     * Adds an observer to subject's observers list.
     * @param observer MyObserver - observer to add.
     */
    public void addObservers(MyObserver observer){
        observers.add(observer);
    }

    /**
     * Notifies all observers' message change.
     */
    public void notifySubMe(){
        for(MyObserver observer: this.observers) {
            observer.notifyMe();
        }//for
    }//notifySubMe

    /**
     * Notifies all observers' flag status.
     */
    public void notifyFlagMe(){
        for(MyObserver observer: this.observers) {
            observer.notifyFlag();
        }//for
    }//notifyFlagMe

}//Subject

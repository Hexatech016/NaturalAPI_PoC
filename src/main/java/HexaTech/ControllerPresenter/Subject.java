/**
 * @file Subject
 * @version 0.0.1
 * @type java
 * @data 2020-04-25
 * @author Eduard Serban
 * @email hexatech016@gmail.com
 * @license
 * @changeLog
 */

package HexaTech.ControllerPresenter;

import HexaTech.Client.MyObserver;

import java.util.ArrayList;
import java.util.List;

public class Subject {

    List<MyObserver> observers=new ArrayList<>();

    public void addObservers(MyObserver observer){
        observers.add(observer);
    }

    public void notifySubMe(){
        for(MyObserver observer: this.observers) {
            observer.notifyMe();
        }
    }

    public void notifyFlagMe(){
        for(MyObserver observer: this.observers) {
            observer.notifyFlag();
        }
    }

}

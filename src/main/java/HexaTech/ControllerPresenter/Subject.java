package HexaTech.ControllerPresenter;


import HexaTech.client.myObserver;

import java.util.ArrayList;
import java.util.List;

public class Subject {

    List<myObserver> obss=new ArrayList<>();

    public void addobss(myObserver observer){
        obss.add(observer);
    }

    public void notifysubme(){
        for(myObserver o: obss) {
            o.notifyme();
        }
    }

}

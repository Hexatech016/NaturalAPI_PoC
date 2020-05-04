/**
 * @file Presenter
 * @version 0.0.1
 * @type java
 * @data 2020-04-25
 * @author Eduard Serban
 * @email hexatech016@gmail.com
 * @license
 * @changeLog
 */

package HexaTech.ControllerPresenter;

import HexaTech.PortInterface.CheckThereAreDocOutputPort;
import HexaTech.PortInterface.CreateBDLOutputPort;
import HexaTech.PortInterface.AddDocToParseOutputPort;
import HexaTech.PortInterface.DeleteDocOutputPort;

public class Presenter extends Subject implements AddDocToParseOutputPort, CreateBDLOutputPort,
        DeleteDocOutputPort, CheckThereAreDocOutputPort {
    private String presenter;
    private boolean flag;

    public String getPresenter() {
        return presenter;
    }

    public boolean isFlag() {
        return flag;
    }

    @Override
    public void showAddDocument(String result) {
        this.presenter=result;
        notifySubMe();
    }
    @Override
    public void showCreateBdl(String result) {
        this.presenter=result;
        notifySubMe();
    }
    @Override
    public void showDeletedDoc(String result){
        this.presenter=result;
        notifySubMe();
    }
    @Override
    public void showBackUpRestored(String result){
        this.presenter=result;
        notifySubMe();
    }

    @Override
    public void thereAreDoc(boolean flag){
        this.flag=flag;
        notifyFlagMe();
    }
}

/**
 * @file Model
 * @version 0.0.1
 * @type java
 * @data 2020-04-25
 * @author Alessio Barbiero
 * @email hexatech016@gmail.com
 * @license
 * @changeLog
 */

package HexaTech.Model;

import HexaTech.Stanford.StanfordInterface;
import HexaTech.Entities.BDL;
import HexaTech.Entities.DoubleStruct;

import java.util.List;

public class Model implements ModelInterface {
    StanfordInterface nlp;

    public Model(StanfordInterface nlp) {
        this.nlp = nlp;
    }

    @Override
    public BDL extractBDL(String text) {
        BDL bdlToReturn =new BDL();
        List<DoubleStruct> result = nlp.extract(text);
        this.addSost(result, bdlToReturn);
        this.addVerb(result, bdlToReturn);
        this.addPred(result, bdlToReturn);
        return bdlToReturn;
    }

    public void addSost(List<DoubleStruct> list, BDL bdl){
        for(DoubleStruct doubleStruct : list){
            if(doubleStruct.getToken().contains("NN"))
                bdl.addName(doubleStruct.getLemma(),1);
        }
    }
    public void addVerb(List<DoubleStruct> list, BDL bdl){
        for(DoubleStruct doubleStruct : list){
            if(doubleStruct.getToken().contains("VB"))
                bdl.addVerb(doubleStruct.getLemma(),1);
        }
    }
    public void addPred(List<DoubleStruct> list, BDL bdl){
        for(DoubleStruct doubleStruct : list){
            if(doubleStruct.getToken().contains("obj"))
                bdl.addPredicate(doubleStruct.getLemma(),1);
        }
    }

}

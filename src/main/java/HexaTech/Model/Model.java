package HexaTech.Model;

import HexaTech.Stanford.iStanford;
import HexaTech.entities.*;

import java.util.ArrayList;
import java.util.List;

public class Model implements iModel{
    iStanford nlp;

    public Model (iStanford enelpi){
        nlp=enelpi;
    }
    @Override
    public BDL estrai(String text) {
        BDL bidiel=new BDL();
        //List<DoubleToken> result = nlp.extract(text);
        //this.addSost(result,bidiel);
        //this.addVerb(result,bidiel);
        //this.addPred(result,bidiel);
        return bidiel;
    }

    private String[] getTextSplitted(String text){
        String[] gherkinSplited;
        String delimiter = "[\n]+[\n]";
        gherkinSplited = text.split(delimiter);
        String part ="";
        return gherkinSplited;
    }

    public BAL provaGherkin(String text){

        BAL baLjSon = new BAL();
        ArrayList<MethodOfBAL> methods = new ArrayList<MethodOfBAL>();
        String[] gherkinSplit = getTextSplitted(text);

        for (String temp: gherkinSplit) {
            MethodOfBAL meth = new MethodOfBAL();
            Gherkin gherk = nlp.extract(temp);
            meth.setNome(gherk.getScenario());
            meth.setDescription(gherk.getDescription());
            meth.setTags("-");
            toReturn toRet=new toReturn();
            toRet.setDescription(gherk.getThen());
            meth.setToRet(toRet);
            ArrayList<Parameters> params = new ArrayList<Parameters>();
            for(String parameter : gherk.getWhen()){
                Parameters param = new Parameters();
                param.setDescription("Default");
                param.setName(parameter);
                param.setType("string");
                params.add(param);
            }
            meth.setParam(params);
            methods.add(meth);
        }

        baLjSon.setMethods(methods);
        return baLjSon;
    }

    public void addSost(List<DoubleToken> list, BDL bidiel){
        for(DoubleToken d: list){
            if(d.getToken().contains("NN"))
                bidiel.aggiungiSost(d.getLemma(),1);
        }
    }
    public void addVerb(List<DoubleToken> list, BDL bidiel){
        for(DoubleToken d: list){
            if(d.getToken().contains("VB"))
                bidiel.aggiungiVerb(d.getLemma(),1);
        }
    }
    public void addPred(List<DoubleToken> list, BDL bidiel){
        for(DoubleToken d: list){
            if(d.getToken().contains("obj"))
                bidiel.aggiungiPred(d.getLemma(),1);
        }
    }




}

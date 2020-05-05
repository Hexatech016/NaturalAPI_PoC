package HexaTech.Repo;

import HexaTech.Filesystem.iFileSystem;
import HexaTech.entities.BAL;
import HexaTech.entities.BDL;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Repo implements iRepo {
    List<String> lista;
    iFileSystem fileSystem;



    public List<String> getLista(){
        return lista;
    }

    public Repo(iFileSystem file){
        lista=new ArrayList<>();
        fileSystem=file;
    }

    public void ritornaPath() throws IOException {
        String temp=fileSystem.importPath();
        if(!temp.equalsIgnoreCase("")) {
            lista.add(temp);
            salvaDocumento();
        }
    }

    public void ritornaPathOfBDL() throws IOException {
        String temp=fileSystem.importPathOfBDL();
        if(!temp.equalsIgnoreCase("")) {
            lista.add(temp);
            saveBDL();
        }
    }

    public void ritornaPathOfGherkin() throws IOException {
        String temp=fileSystem.importPathOfGherkin();
        if(!temp.equalsIgnoreCase("")) {
            lista.add(temp);
            System.out.println(lista);
            saveGherkin();
        }
    }

    public void saveGherkin() throws IOException {
        StringBuilder temp= new StringBuilder();
        for(String stringa: lista)
            temp.append(stringa).append("\n");
        this.fileSystem.saveDoc(temp.toString(), ".\\GherkinsPath.txt");
    }

    public void saveBDL() throws IOException {
        StringBuilder temp= new StringBuilder();
        for(String stringa: lista)
            temp.append(stringa).append("\n");
        this.fileSystem.saveDoc(temp.toString(), ".\\tempBDL.txt");
    }

    public void salvaDocumento() throws IOException {
        StringBuilder temp= new StringBuilder();
        for(String stringa: lista)
            temp.append(stringa).append("\n");
        this.fileSystem.saveDoc(temp.toString(), ".\\temp.txt");
    }
    public void caricaBackUp() throws IOException {
        Scanner s = new Scanner(new File(".\\temp.txt"));
        while (s.hasNextLine()){
            lista.add(s.nextLine());
        }
        s.close();
    }
    public boolean elimina(String doc){
        return fileSystem.eliminaDoc(doc);
    }

    public String returnContentFromTxt(String path) throws IOException {
        return fileSystem.getContenutoFromPath(path);
    }

    public void salvaBDL(BDL bdl) throws IOException {
        fileSystem.saveDoc(bdl.toString(),".\\BDL.txt");
    }

    @Override
    public void saveBAL(BAL bal) throws IOException {
        fileSystem.saveDoc(bal.toString(),".\\provabal.bal");
    }

    /*public void getBDLFromContentPath() throws IOException {
        //Map<String,Integer> sost=new HashMap<>();
        //Gson gson = new Gson();
        ObjectMapper mapper = new ObjectMapper();
        String sosts=fileSystem.getContenutoFromPath(".\\BDLsost.txt");
        String verbs=fileSystem.getContenutoFromPath(".\\BDLverbs.txt");
        String pred=fileSystem.getContenutoFromPath(".\\BDLpred.txt");


        Map<String,Integer> sost=mapper.readValue(sosts, HashMap.class);
        Map<String,Integer> verb=mapper.readValue(verbs, HashMap.class);
        Map<String,Integer> preds=mapper.readValue(pred, HashMap.class);
        BDL BDLtoGet=new BDL(sost,verb,preds);
        System.out.println(BDLtoGet.toString());
    }*/
    /*public String getGherkinFromContentPath() throws IOException{
        return fileSystem.getContenutoFromPath(".\\gherkin.txt");
    }*/

}

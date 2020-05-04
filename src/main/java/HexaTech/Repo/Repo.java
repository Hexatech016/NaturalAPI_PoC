/**
 * @file Repo
 * @version 0.0.1
 * @type java
 * @data 2020-04-25
 * @author Luca Marcon
 * @email hexatech016@gmail.com
 * @license
 * @changeLog
 */

package HexaTech.Repo;

import HexaTech.Filesystem.FileSystemInterface;
import HexaTech.Entities.BDL;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Repo implements RepoInterface {
    List<String> list;
    FileSystemInterface fileSystem;

    public List<String> getLista(){
        return list;
    }

    public Repo(FileSystemInterface fileSystemInterface){
        list =new ArrayList<>();
        this.fileSystem=fileSystemInterface;
    }

    public void returnPath() throws IOException {
        String temp=fileSystem.importPath();
        if(!temp.equalsIgnoreCase("")) {
            list.add(temp);
            saveDoc();
        }

    }
    public void saveDoc() throws IOException {
        StringBuilder temp= new StringBuilder();
        for(String stringa: list)
            temp.append(stringa).append("\n");
        this.fileSystem.saveDoc(temp.toString(), ".\\temp.txt");
    }
    public void loadBackUp() throws IOException {
        Scanner s = new Scanner(new File(".\\temp.txt"));
        while (s.hasNextLine()){
            list.add(s.nextLine());
        }
        s.close();
    }
    public boolean delete(String doc){
        return fileSystem.deleteDoc(doc);
    }

    public String returnContentFromTxt(String path) throws IOException {
        return fileSystem.getContentFromPath(path);
    }

    public void saveBDL(BDL bdl) throws IOException {
        fileSystem.saveDoc(bdl.toString(),".\\BDLreadble.txt");
        fileSystem.saveDoc(bdl.sostToCVS(),".\\BDLsost.csv");
        fileSystem.saveDoc(bdl.verbToCVS(),".\\BDLverbs.csv");
        fileSystem.saveDoc(bdl.predToCVS(),".\\BDLpred.csv");
    }
    public void getBDLFromContentPath() throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        String sosts=fileSystem.getContentFromPath(".\\BDLsost.txt");
        String verbs=fileSystem.getContentFromPath(".\\BDLverbs.txt");
        String pred=fileSystem.getContentFromPath(".\\BDLpred.txt");

        Map<String,Integer> sost=mapper.readValue(sosts, HashMap.class);
        Map<String,Integer> verb=mapper.readValue(verbs, HashMap.class);
        Map<String,Integer> preds=mapper.readValue(pred, HashMap.class);
        BDL BDLtoGet=new BDL(sost,verb,preds);
        System.out.println(BDLtoGet.toString());
    }

    public boolean checkThereAreDoc() {
        return fileSystem.existsDoc(".\\temp.txt");
    }

}

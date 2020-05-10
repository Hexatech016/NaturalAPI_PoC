/**
 * @file Structure
 * @version 2.0.0
 * @type java
 * @data 2020-04-30
 * @author Alessio Barbiero
 * @email hexatech016@gmail.com
 * @license MIT
 */

package HexaTech.Entities;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Class used to represent a Structure content.
 */
public class Structure {
    String structureName;
    HashMap<String,String> structureParam;

    /**
     * Structure class empty constructor.
     */
    public Structure(){}

    /**
     * Structure class standard constructor.
     * @param structureName string - structure name.
     * @param structureParam Hashmap<String,String> - structure parameters list.
     *                       Key is used to store parameter's name, value to store parameter's type.
     */
    public Structure(String structureName, HashMap<String, String> structureParam) {
        this.structureName=structureName;
        this.structureParam=structureParam;
    }

    /**
     * Change structure's name.
     * @param structureName string - new structure's name.
     */
    public void setStructureName(String structureName) {
        this.structureName = structureName.substring(0,1).toUpperCase() + structureName.substring(1);
    }

    /**
     * Change structure's parameters list.
     * @param structureParam HashMap<String,String> - new structure's parameters list.
     */
    public void setStructureParam(HashMap<String, String> structureParam) {
        this.structureParam=structureParam;
    }

    /**
     * Replaces PLA's parameters with structure's values into a given string array.
     * @param PLA string[] - parametrized array to replace.
     * @param start integer - index from which to start analyzing.
     * @param end integer - index to which analyze.
     * @param types string[] - user defined types nomenclature.
     * @param typed boolean - true if output language is typed, false if it's not.
     * @return string - PLA developed structures's content.
     */
    public String replacePLA(String[] PLA,int start,int end,String[] types,boolean typed){
        String[] content=PLA;
        StringBuilder result=new StringBuilder();
        for(int temp=start;temp<end;temp++){
            content[temp]=PLA[temp];
            if(content[temp].contains("<--struct.start-->"))
                content[temp]=content[temp].replace("<--struct.start-->","");
            if(content[temp].contains("<--struct.end-->"))
                content[temp]=content[temp].replace("<--struct.end-->","");
            if(content[temp].contains("<--structName-->"))
                content[temp]=content[temp].replace("<--structName-->",structureName);
            if(content[temp].contains("<--structParamName-->")){
                content[temp]=content[temp].replace("<--structParamName-->", getStringParam(types,typed));
                content[temp]=content[temp].replace("<--structParamType-->", "");
            }else if(content[temp].contains("<--structParamType-->")){
                content[temp]=content[temp].replace("<--structParamType-->", getStringParam(types,typed));
                content[temp]=content[temp].replace("<--structParamName-->", "");
            }//if_else_if
            result.append(content[temp]).append("\n");
        }//for
        return result.toString();
    }//replacePLA

    /**
     * Returns structure's parameters.
     * @param types String[] - user-defined nomenclatures list.
     * @param typed boolean - true if the output language is typed, false if it's not.
     * @return string - structure's parameters with user-defined nomenclature.
     */
    public String getStringParam(String[] types,boolean typed){
        String intType=types[0], stringType=types[1];
        StringBuilder param=new StringBuilder();
        if(typed){
            Iterator it=structureParam.entrySet().iterator();
            while(it.hasNext()) {
                Map.Entry pair=(Map.Entry) it.next();
                String value=pair.getValue().toString();
                if(value.equals("string"))
                    value=stringType;
                if(value.equals("integer"))
                    value=intType;
                if(value.equals("string[]"))
                    value=stringType+"[]";
                if(value.equals("integer[]"))
                    value=intType+"[]";
                if(value.equals("/"))
                    param.append(pair.getKey());
                else
                    param.append(value).append(" ").append(pair.getKey());
                if(it.hasNext())
                    param.append(";\n\t");
                else
                    param.append(";");
                it.remove();
            }//while
        }else{
            Iterator it=structureParam.entrySet().iterator();
            while(it.hasNext()){
                Map.Entry pair=(Map.Entry) it.next();
                param.append(pair.getKey());
                if(it.hasNext())
                    param.append(", ");
                it.remove();
            }//while
        }//if_else
        return param.toString();
    }//getStringParam

}//Structure

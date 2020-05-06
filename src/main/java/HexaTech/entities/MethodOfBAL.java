package HexaTech.entities;

import java.util.List;

public class MethodOfBAL {
    String name="Method.nome";
    String description="Method.description";
    String tags="Method.tags";
    toReturn toRet;
    List<Parameters> param;

    public String getNome() {
        return name;
    }

    public void setNome(String nome) {
        this.name = nome;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public toReturn getToRet() {
        return toRet;
    }

    public void setToRet(toReturn toRet) {
        this.toRet = toRet;
    }

    public List<Parameters> getParam() {
        return param;
    }

    public void setParam(List<Parameters> param) {
        this.param = param;
    }

    public String toString(){
        String toReturnString=
                "		\"/"+name+"\": {\n"+
                        "			\"get\": {\n"+
                        "				\"operationId\": \""+name+"\",\n"+
                        "				\"description\": \""+description+"\",\n"+
                        "      				\"tags\": [\n"+//qua andrebbe una funzione per stampare i tags
                        "       				\""+tags+"\"\n"+
                        "    				 ],\n"+
                        "			        \"parameters\": [\n";
        int last=param.size()-1;
        int count=0;
        for(Parameters parametersIterator: param){
            toReturnString+=parametersIterator.toString();
            if (count<last){
                toReturnString+=",";
            }
            count+=1;
        }
        toReturnString+="        			],\n";
        toReturnString+="        			\"responses\":{\n";
        toReturnString+= toRet.toString();
        toReturnString+="\n}\n}\n}\n";
        return toReturnString;
    }
}

package HexaTech.entities;

import com.google.gson.Gson;

import java.util.List;

public class BAL {
    String intro="BAL.intro";
    List<MethodOfBAL> methods;

   /* public BALjSon(String casino, List<MethodOfBAL> meth) {

    }*/

    public String getIntro() {
        return intro;
    }
    public List<MethodOfBAL> getMethods() {
        return methods;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public void setMethods(List<MethodOfBAL> methods) {
        this.methods = methods;
    }

    public String BALToJson(){
       Gson gsonSost=new Gson();
       return gsonSost.toJson(this);
    }

    /**
     * Returns BAL's content into a string.
     * @return string - BAL's content.
     */
    public String toString(){
        String toRit=
                "{\n"+
                        "	\"openapi\": \"3.0.0\",\n"+
                        "	\"info\": {\n"+
                        "		\"version\": \"1.0.0\",\n"+
                        "		\"title\": \"Test\",\n"+
                        "		\"license\": {\n"+
                        "			\"name\": \"MIT\"\n	"+
                        "		}\n	"+
                        "	},\n"+
                        "	\"paths\": {\n";
        //
        int last=methods.size()-1;
        int count=0;
        for(MethodOfBAL method: this.methods){
            toRit+=method.toString();
            if (count<last){
                toRit+=",";
            }
            count+=1;
        }//for
        toRit+="}\n}";
        return toRit;
    }//toString
}

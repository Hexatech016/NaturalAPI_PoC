package HexaTech.entities;

import java.util.ArrayList;

public class Gherkin {
    String scenario;
    String description;
    String given;
    //String when;
    ArrayList<String> when= new ArrayList<String>();
    String then;

    public String getScenario() {
        return scenario;
    }

    public void setScenario(String scenario) {
        this.scenario = scenario;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGiven() {
        return given;
    }

    public void setGiven(String given) {
        this.given = given;
    }

    /*public String getWhen() {
        return when;
    }

    public void setWhen(String when) {
        this.when = when;
    }
*/
    public ArrayList<String> getWhen(){
        return when;
    }

    public void setWhen(ArrayList<String> when) {
        this.when = when;
    }

    public String getThen() {
        return then;
    }

    public void setThen(String then) {
        this.then = then;
    }
}

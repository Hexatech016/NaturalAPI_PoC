package HexaTech.entities;

import com.google.gson.Gson;

import java.util.*;

public class BDL {
    private Map<String, Integer> sostantivi = new HashMap<>();
    private Map<String, Integer> verbi = new HashMap<>();
    private Map<String, Integer> predicati = new HashMap<>();

    public BDL(){}

    public BDL(Map<String, Integer> sost, Map<String, Integer> verb, Map<String, Integer> preds) {
        sostantivi=sortMap((HashMap<String, Integer>) sost);
        verbi=sortMap((HashMap<String, Integer>) verb);
        predicati=sortMap((HashMap<String, Integer>) preds);
    }

    /*public BDL(Map<String,Integer> sost, Map<String,Integer> verb, Map<String,Integer> pred){
        sostantivi=sost;
        verbi=verb;
        predicati=pred;
    }*/ //Costruttore ridefinito mai usato

    public Map<String, Integer> getPredicati() {
        return predicati;
    }

    public Map<String, Integer> getSostantivi() {
        return sostantivi;
    }

    public Map<String, Integer> getVerbi() {
        return verbi;
    }

    public void aggiungiSost(String sosts, int freq) {
        boolean trovato = false;
        for (Map.Entry<String, Integer> sost : sostantivi.entrySet()) {
            if (sost.getKey().equalsIgnoreCase(sosts)) {
                sost.setValue(sost.getValue() + freq);
                trovato = true;
                break;
            }
        }
        if (!trovato)
            this.sostantivi.put(sosts, freq);
        sostantivi=sortMap((HashMap<String, Integer>) this.sostantivi);
    }

    public void aggiungiVerb(String verbs, int freq) {
        boolean trovato = false;
        for (Map.Entry<String, Integer> verb : verbi.entrySet()) {
            if (verb.getKey().equalsIgnoreCase(verbs)) {
                verb.setValue(verb.getValue() + freq);
                trovato = true;
                break;
            }
        }
        if (!trovato)
            this.verbi.put(verbs, freq);
        verbi=sortMap((HashMap<String, Integer>) this.verbi);
    }

    public void aggiungiPred(String preds, int freq) {
        boolean trovato = false;
        for (Map.Entry<String, Integer> pred : predicati.entrySet()) {
            if (pred.getKey().equalsIgnoreCase(preds)) {
                pred.setValue(pred.getValue() + freq);
                trovato = true;
                break;
            }
        }
        if (!trovato)
            this.predicati.put(preds, freq);
        predicati=sortMap((HashMap<String, Integer>) this.predicati);
    }

    public String toString() {
        String temp = "Sostantivi: frequenza\n\n";
        for (Map.Entry<String, Integer> sost : sostantivi.entrySet()) {
            temp += sost.getKey().substring(0,1).toUpperCase() + sost.getKey().substring(1) + ": " + sost.getValue() + "\n";
        }
        temp += "\nVerbi: frequenza\n\n";
        for (Map.Entry<String, Integer> verb : verbi.entrySet()) {
            temp += verb.getKey().substring(0,1).toUpperCase() + verb.getKey().substring(1) + ": " + verb.getValue() + "\n";
        }
        temp += "\nPredicati: frequenza\n\n";
        for (Map.Entry<String, Integer> pred : predicati.entrySet()) {
            temp += pred.getKey().substring(0,1).toUpperCase() + pred.getKey().substring(1) + ": " + pred.getValue() + "\n";
        }
        return temp;
    }

    public HashMap<String,Integer> sortMap(HashMap<String, Integer> hm) {
        List<Map.Entry<String, Integer>> list =
                new LinkedList<>(hm.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        // put data from sorted list to hashmap
        HashMap<String, Integer> temp = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
    public void mergeBDL(BDL bdl) {
        for (Map.Entry<String, Integer> sost : bdl.getSostantivi().entrySet()) {
            this.aggiungiSost(sost.getKey(),sost.getValue());
        }
        for (Map.Entry<String, Integer> verb : bdl.getVerbi().entrySet()) {
            this.aggiungiVerb(verb.getKey(),verb.getValue());
        }
        for (Map.Entry<String, Integer> pred : bdl.getPredicati().entrySet()) {
            this.aggiungiPred(pred.getKey(),pred.getValue());
        }
    }
    public String sostToJson(){
        Gson gsonSost=new Gson();
        return gsonSost.toJson(this.sostantivi);
    }
    public String verbsToJson(){
        Gson gsonSost=new Gson();
        return gsonSost.toJson(this.verbi);
    }
    public String predToJson(){
        Gson gsonSost=new Gson();
        return gsonSost.toJson(this.predicati);
    }
    public String toStringVerb(){
        String temp="Prova \n";
        for (Map.Entry<String, Integer> verb : verbi.entrySet()) {
            temp += verb.getKey().substring(0,1).toUpperCase() + verb.getKey().substring(1) + ": " + verb.getValue() + "\n";
        }
        return temp;
    }
}
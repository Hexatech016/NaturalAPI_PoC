/**
 * @file BDL
 * @version 0.0.1
 * @type java
 * @data 2020-04-25
 * @author Alessio Barbiero
 * @email hexatech016@gmail.com
 * @license
 * @changeLog
 */

package HexaTech.Entities;

import java.util.*;

public class BDL {
    private Map<String, Integer> names = new HashMap<>();
    private Map<String, Integer> verbs = new HashMap<>();
    private Map<String, Integer> predicates = new HashMap<>();

    public BDL(){}

    public BDL(Map<String, Integer> names, Map<String, Integer> verbs, Map<String, Integer> predicates) {
        this.names =sortMap((HashMap<String, Integer>) names);
        this.verbs =sortMap((HashMap<String, Integer>) verbs);
        this.predicates =sortMap((HashMap<String, Integer>) predicates);
    }

    public Map<String, Integer> getNames() {
        return names;
    }

    public Map<String, Integer> getVerbs() {
        return verbs;
    }

    public Map<String, Integer> getPredicates() {
        return predicates;
    }


    public void addName(String sosts, int frequency) {
        boolean found = false;
        for (Map.Entry<String, Integer> nameList : names.entrySet()) {
            if (nameList.getKey().equalsIgnoreCase(sosts)) {
                nameList.setValue(nameList.getValue() + frequency);
                found = true;
                break;
            }
        }
        if (!found)
            this.names.put(sosts, frequency);
        names =sortMap((HashMap<String, Integer>) this.names);
    }

    public void addVerb(String verbs, int frequency) {
        boolean found = false;
        for (Map.Entry<String, Integer> verb : this.verbs.entrySet()) {
            if (verb.getKey().equalsIgnoreCase(verbs)) {
                verb.setValue(verb.getValue() + frequency);
                found = true;
                break;
            }
        }
        if (!found)
            this.verbs.put(verbs, frequency);
        this.verbs =sortMap((HashMap<String, Integer>) this.verbs);
    }

    public void addPredicate(String preds, int frequency) {
        boolean found = false;
        for (Map.Entry<String, Integer> pred : predicates.entrySet()) {
            if (pred.getKey().equalsIgnoreCase(preds)) {
                pred.setValue(pred.getValue() + frequency);
                found = true;
                break;
            }
        }
        if (!found)
            this.predicates.put(preds, frequency);
        predicates =sortMap((HashMap<String, Integer>) this.predicates);
    }

    public String toString() {
        String toReturn = "Names: frequency\n\n";
        for (Map.Entry<String, Integer> sost : names.entrySet()) {
            toReturn += sost.getKey().substring(0,1).toUpperCase() + sost.getKey().substring(1) + ": " + sost.getValue() + "\n";
        }
        toReturn += "\nVerbs: frequency\n\n";
        for (Map.Entry<String, Integer> verb : verbs.entrySet()) {
            toReturn += verb.getKey().substring(0,1).toUpperCase() + verb.getKey().substring(1) + ": " + verb.getValue() + "\n";
        }
        toReturn += "\nPredicates: frequency\n\n";
        for (Map.Entry<String, Integer> pred : predicates.entrySet()) {
            toReturn += pred.getKey().substring(0,1).toUpperCase() + pred.getKey().substring(1) + ": " + pred.getValue() + "\n";
        }
        return toReturn;
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
        for (Map.Entry<String, Integer> sost : bdl.getNames().entrySet()) {
            this.addName(sost.getKey(),sost.getValue());
        }
        for (Map.Entry<String, Integer> verb : bdl.getVerbs().entrySet()) {
            this.addVerb(verb.getKey(),verb.getValue());
        }
        for (Map.Entry<String, Integer> pred : bdl.getPredicates().entrySet()) {
            this.addPredicate(pred.getKey(),pred.getValue());
        }
    }

    public String sostToCVS(){
        StringBuilder toReturn = new StringBuilder();
        for (Map.Entry<String, Integer> sost : names.entrySet()) {
            toReturn.append(sost.getKey().substring(0, 1).toUpperCase()).append(sost.getKey().substring(1)).append(",").append(sost.getValue()).append("\n");
        }
        return toReturn.toString();
    }

    public String verbToCVS(){
        StringBuilder toReturn = new StringBuilder();
        for (Map.Entry<String, Integer> verb : verbs.entrySet()) {
            toReturn.append(verb.getKey().substring(0, 1).toUpperCase()).append(verb.getKey().substring(1)).append(",").append(verb.getValue()).append("\n");
        }
        return toReturn.toString();
    }

    public String predToCVS(){
        StringBuilder toReturn = new StringBuilder();
        for (Map.Entry<String, Integer> pred : predicates.entrySet()) {
            toReturn.append(pred.getKey().substring(0, 1).toUpperCase()).append(pred.getKey().substring(1)).append(",").append(pred.getValue()).append("\n");
        }
        return toReturn.toString();
    }
}

/**
 * @file BDL
 * @version 0.0.1
 * @type java
 * @data 2020-04-30
 * @author
 * @email hexatech016@gmail.com
 * @license MIT
 */

package HexaTech.Entities;

import java.util.*;

/**
 * Class used to represent a BDL object.
 */
public class BDL {
    private Map<String, Integer> nouns = new HashMap<>();
    private Map<String, Integer> verbs = new HashMap<>();
    private Map<String, Integer> predicates = new HashMap<>();

    /**
     * BDL class empty constructor.
     */
    public BDL(){}

    /**
     * Returns BDL predicates' list.
     * @return Map<String, Integer> - predicates' list.
     */
    public Map<String, Integer> getPredicates() {
        return predicates;
    }

    /**
     * Returns BDL nouns' list.
     * @return Map<String, Integer> - nouns' list.
     */
    public Map<String, Integer> getNouns() {
        return nouns;
    }

    /**
     * Returns BDL verbs' list.
     * @return Map<String, Integer> - verbs' list.
     */
    public Map<String, Integer> getVerbs() {
        return verbs;
    }

    /**
     * Adds a new noun to BDL's list.
     * @param newNoun string - noun to be added.
     * @param freq integer - noun's frequency.
     */
    public void addNoun(String newNoun, int freq) {
        boolean found = false;
        for (Map.Entry<String, Integer> noun : nouns.entrySet()) {
            if (noun.getKey().equalsIgnoreCase(newNoun)) {
                noun.setValue(noun.getValue() + freq);
                found = true;
                break;
            }//if
        }//for
        if (!found)
            this.nouns.put(newNoun, freq);
        nouns=sortMap((HashMap<String, Integer>) this.nouns);
    }//addNoun

    /**
     * Adds a new verb to BDL's list.
     * @param newVerb string - verb to be added.
     * @param freq integer - verb's frequency.
     */
    public void addVerb(String newVerb, int freq) {
        boolean found = false;
        for (Map.Entry<String, Integer> verb : verbs.entrySet()) {
            if (verb.getKey().equalsIgnoreCase(newVerb)) {
                verb.setValue(verb.getValue() + freq);
                found = true;
                break;
            }//if
        }//for
        if (!found)
            this.verbs.put(newVerb, freq);
        verbs=sortMap((HashMap<String, Integer>) this.verbs);
    }//addVerb

    /**
     * Adds a new predicate to BDL's list.
     * @param newPred string - predicate to be added.
     * @param freq integer - predicate's frequency.
     */
    public void addPredicate(String newPred, int freq) {
        boolean found = false;
        for (Map.Entry<String, Integer> pred : predicates.entrySet()) {
            if (pred.getKey().equalsIgnoreCase(newPred)) {
                pred.setValue(pred.getValue() + freq);
                found = true;
                break;
            }//if
        }//for
        if (!found)
            this.predicates.put(newPred, freq);
        predicates=sortMap((HashMap<String, Integer>) this.predicates);
    }//addPredicate

    /**
     * Returns BDL's content into a string.
     * @return string - BDL's content.
     */
    public String toString() {
        StringBuilder temp =new StringBuilder("Sostantivi: frequenza\n\n");
        for (Map.Entry<String, Integer> noun : nouns.entrySet()) {
            temp.append(noun.getKey().substring(0, 1).toUpperCase()).append(noun.getKey().substring(1)).append(": ").append(noun.getValue()).append("\n");
        }//for
        temp.append("\nVerbi: frequenza\n\n");
        for (Map.Entry<String, Integer> verb : verbs.entrySet()) {
            temp.append(verb.getKey().substring(0, 1).toUpperCase()).append(verb.getKey().substring(1)).append(": ").append(verb.getValue()).append("\n");
        }//for
        temp.append("\nPredicati: frequenza\n\n");
        for (Map.Entry<String, Integer> pred : predicates.entrySet()) {
            temp.append(pred.getKey().substring(0, 1).toUpperCase()).append(pred.getKey().substring(1)).append(": ").append(pred.getValue()).append("\n");
        }//for
        return temp.toString();
    }//toString

    /**
     * Sorts map's content alphabetically.
     * @param hm HashMap<String, Integer> - map to be sorted.
     * @return HashMap<String, Integer> - sorted map.
     */
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
        }//for
        return temp;
    }//sortMap

}//BDL
/**
 * @file DoubleStruct
 * @version 0.0.1
 * @type java
 * @data 2020-04-25
 * @author Luca Marcon
 * @email hexatech016@gmail.com
 * @license
 * @changeLog
 */

package HexaTech.Entities;

public class DoubleStruct {
    String token;
    String lemma;

    public DoubleStruct(String token, String lemma)
    {
        this.token=token;
        this.lemma=lemma;
    }

    public String getLemma() {
        return lemma;
    }

    public String getToken() {
        return token;
    }

    public String toString(){
        return token+ " " + lemma;
    }

}

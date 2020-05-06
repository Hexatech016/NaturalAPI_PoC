package HexaTech.Model;

import HexaTech.entities.BAL;
import HexaTech.entities.BDL;

public interface iModel {
    BDL estrai(String text);
    BAL setBALFromGherkin(String text);
}

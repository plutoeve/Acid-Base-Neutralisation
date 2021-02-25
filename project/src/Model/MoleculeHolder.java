package Model;

import java.util.HashMap;

public class MoleculeHolder {
    HashMap<String, MoleculeModel> hashMap = new HashMap<String, MoleculeModel>();


    public MoleculeHolder() {
    MoleculeModel HydrochloricAcid = new AcidModel("HCl","Cl",36.458);

    }

    public HashMap<String, MoleculeModel> getHashMap() {
        return hashMap;
    }

    public void setHashMap(HashMap<String, MoleculeModel> hashMap) {
        this.hashMap = hashMap;
    }
}

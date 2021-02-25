package Model;

import java.util.HashMap;

public class MoleculeHolder {
    HashMap<String, MoleculeModel> hashMap = new HashMap<String, MoleculeModel>();


    public MoleculeHolder() {
    /***ACIDS***/
    MoleculeModel HydrochloricAcid = new AcidModel("HCl","Cl",36.458);
    MoleculeModel HydrobromicAcid  = new AcidModel("HBr","Br",80.91);
    MoleculeModel HydroiodicAcid   = new AcidModel("HI","I",127.911);
    MoleculeModel SulfuricAcid = new AcidModel("H2SO4","SO4",98.079);
    MoleculeModel NitricAcid  = new AcidModel("HNO3","NO3",63.01);
    MoleculeModel PerchloricAcid   = new AcidModel("HClO4","ClO4",100.46 );
    /***BASES***/
    MoleculeModel SodiumHydroxide = new BaseModel("NaOH", "Na", 39.997 );
    MoleculeModel PotassiumHydroxide = new BaseModel("KOH","K", 56.1056);
    MoleculeModel LithiumHydroxide = new BaseModel("LiOH","Li",23.95);


    }

    public HashMap<String, MoleculeModel> getHashMap() {
        return hashMap;
    }

    public void setHashMap(HashMap<String, MoleculeModel> hashMap) {
        this.hashMap = hashMap;
    }
}

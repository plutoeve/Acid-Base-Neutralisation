package Model;

import java.util.HashMap;

public class MoleculeHolder {

    public static HashMap<String, MoleculeModel> hashMap = new HashMap<String, MoleculeModel>();


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
    MoleculeModel RubidiumHydroxide = new BaseModel("RbOH","Rb",102.475 );
    MoleculeModel CesiumHydroxide = new BaseModel("CsOH","Cs",149.913 );
    MoleculeModel CalciumHydroxide = new BaseModel("Ca(OH)2","Ca",149.912 );

    /***- HashMap put Acids -***/

    hashMap.put(HydrochloricAcid.getEmpiricalFormula(),HydrochloricAcid);
    hashMap.put(HydrobromicAcid.getEmpiricalFormula(),HydrobromicAcid);
    hashMap.put(HydroiodicAcid.getEmpiricalFormula(),HydroiodicAcid);
    hashMap.put(SulfuricAcid.getEmpiricalFormula(),SulfuricAcid);
    hashMap.put(NitricAcid.getEmpiricalFormula(),NitricAcid);
    hashMap.put(PerchloricAcid.getEmpiricalFormula(),PerchloricAcid);

    /***- HashMap put Bases -***/

    hashMap.put(SodiumHydroxide.getEmpiricalFormula(),SodiumHydroxide);
    hashMap.put(PotassiumHydroxide.getEmpiricalFormula(), PotassiumHydroxide);
    hashMap.put(LithiumHydroxide.getEmpiricalFormula(), LithiumHydroxide);
    hashMap.put(RubidiumHydroxide.getEmpiricalFormula(), RubidiumHydroxide);
    hashMap.put(CesiumHydroxide.getEmpiricalFormula(), CesiumHydroxide);
    hashMap.put(CalciumHydroxide.getEmpiricalFormula(), CalciumHydroxide);
    }

    public HashMap<String, MoleculeModel> getHashMap() {
        return hashMap;
    }


}

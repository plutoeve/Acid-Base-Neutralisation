package Model;

import javafx.beans.property.SimpleStringProperty;

public class AcidModel extends MoleculeModel{
    private SimpleStringProperty sufix;

    public AcidModel(String empiricalFormula,String sufix, double molarMass) {
        super(empiricalFormula, molarMass);
        this.sufix = new SimpleStringProperty(sufix);
        super.setCompoundType("Acid");
    }

    public String getSufix() {
        return sufix.get();
    }

    public SimpleStringProperty sufixProperty() {
        return sufix;
    }

    public void setSufix(String sufix) {
        this.sufix.set(sufix);
    }
}

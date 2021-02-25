package Model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;


public class MoleculeModel {

    protected String compoundType;
    protected SimpleStringProperty empiricalFormula;
    protected SimpleDoubleProperty molarMass;

    public MoleculeModel(String empiricalFormula, double molarMass) {
        this.empiricalFormula = new SimpleStringProperty(empiricalFormula);
        this.molarMass = new SimpleDoubleProperty(molarMass);
    }

    public String getEmpiricalFormula() {
        return empiricalFormula.get();
    }

    public SimpleStringProperty empiricalFormulaProperty() {
        return empiricalFormula;
    }

    public void setEmpiricalFormula(String empiricalFormula) {
        this.empiricalFormula.set(empiricalFormula);
    }

    public void setQuantity(double quantity) {
        this.molarMass.set(quantity);
    }

    public double getQuantity() {
        return molarMass.get();
    }

    public SimpleDoubleProperty quantityProperty() {
        return molarMass;
    }

    public void setCompoundType(String compoundType) {
        this.compoundType = compoundType;
    }
}

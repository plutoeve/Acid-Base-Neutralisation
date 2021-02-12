package Model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MoleculeModel {


    private SimpleStringProperty compoundType, empiricalFormula;
    private SimpleDoubleProperty quantity;

    public MoleculeModel(String empiricalFormula, String compoundType, double quantity) {
        this.empiricalFormula = new SimpleStringProperty(empiricalFormula);
        this.compoundType = new SimpleStringProperty(compoundType);
        this.quantity = new SimpleDoubleProperty(quantity);
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

    public void setCompoundType(String compoundType) {
        this.compoundType.set(compoundType);
    }

    public void setQuantity(double quantity) {
        this.quantity.set(quantity);
    }

    public String getCompoundType() {
        return compoundType.get();
    }

    public SimpleStringProperty compoundTypeProperty() {
        return compoundType;
    }

    public double getQuantity() {
        return quantity.get();
    }

    public SimpleDoubleProperty quantityProperty() {
        return quantity;
    }
}

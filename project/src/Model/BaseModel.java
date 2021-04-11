package Model;


import javafx.beans.property.SimpleStringProperty;

public class BaseModel extends MoleculeModel{

    private SimpleStringProperty prefix;


    public BaseModel(String empiricalFormula,String prefix, double molarMass) {
        super(empiricalFormula, molarMass);
        this.prefix = new SimpleStringProperty(prefix);
    }

    public String getPrefix() {
        return prefix.get();
    }

}

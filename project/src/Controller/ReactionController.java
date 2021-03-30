package Controller;
import View.*;
import Model.*;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;


public class ReactionController {
    boolean baseAllEmpty;
    boolean acidAllEmpty;
    String error, BaseVolume, AcidVolume, BaseConcentration, AcidConcentration;
    double acidConcentration;
    double acidVolume;
    double baseConcentration;
    double baseVolume;
    AcidModel chosenAcid;
    BaseModel chosenBase;

    public ReactionController(MoleculeHolder moleculeHolder, SimulationView simulationView) {
        ControlPanelView cpv = simulationView.getPanelView();
        //get the name of the chosen reactants
        String chosenAcid = cpv.getAcidBox().getSelectionModel().toString();
        String chosenBase = cpv.getBaseBox().getSelectionModel().toString();
        //to be done
        AcidModel acid = (AcidModel) moleculeHolder.getHashMap().get(chosenAcid);
        BaseModel base = (BaseModel) moleculeHolder.getHashMap().get(chosenBase);

        EventHandler startHandler =  new EventHandler() {

            @Override
            public void handle(Event event) {

                error = "";
                int choice = PickCase(cpv);
                if(checkErrorsInput() == true){}
                else{
                switch(choice) {

                    case 1: error = "please input more than 1 parameter for it to work";

                            break;

                    case 2: if(baseAllEmpty){
                                baseVolume = acidVolume;
                                double baseConcentration = Calculations.calculateFourth(acidConcentration, acidVolume, baseVolume);

                            }else if(acidAllEmpty){
                                acidVolume = baseVolume;
                                double acidConcentration = Calculations.calculateFourth(baseConcentration, baseVolume, acidVolume);

                            }else if(AcidVolume.isEmpty()&&BaseConcentration.isEmpty()){
                                acidVolume = baseVolume;
                                double baseConcentration = Calculations.calculateFourth(acidConcentration, baseVolume, acidVolume);

                            }else if(AcidConcentration.isEmpty()&&BaseVolume.isEmpty()){
                                baseVolume = acidVolume;
                                double acidConcentration = Calculations.calculateFourth(baseConcentration, baseVolume, acidVolume);
                            }else
                                {
                                    error = "there is an error compiling the code related to the input";

                                }
                            break;

                    case 3: switch(WhatIsMissing()){
                            case "base concentration": baseConcentration = Calculations.calculateFourth(acidConcentration, acidVolume, baseVolume);
                            break;

                            case "acid concentration":acidConcentration = Calculations.calculateFourth(baseConcentration, baseVolume, acidVolume);
                            break;

                            case "base volume": baseVolume = Calculations.calculateFourth(acidConcentration, acidVolume, baseConcentration);
                            break;

                            case "acid volume": acidVolume = Calculations.calculateFourth(baseConcentration, baseVolume, acidVolume);
                            }
                            break;

                    case 4:
                        boolean balanced = Calculations.calculate(acidConcentration,acidVolume,baseConcentration,baseVolume);
                            if(balanced){
                                System.out.println("yeah it is good");
                            }else
                            {
                                error = "try to make it balanced...or leave one or two values empty"; }
                                break;
                    default: error = "nothing is there... please input something";

                            break;
                    }
                    if(!error.isEmpty())displayError(error);
                }
                System.out.println("acid concentration = " + acidConcentration + "base concentration = "
                        + baseConcentration+ "base Volume = " + baseVolume + "acid volume = " + acidVolume);

            }
        };

      simulationView.getStartButton().setOnAction(startHandler);



    }

   int PickCase(ControlPanelView controlPanelView){

           int c = 4;

           BaseVolume = controlPanelView.getVolumeBase().getText();
           AcidVolume = controlPanelView.getVolumeAcid().getText();
           BaseConcentration = controlPanelView.getConcentrationBase().getText();
           AcidConcentration = controlPanelView.getConcentrationAcid().getText();
           String[] Parameters = {AcidConcentration, BaseConcentration, AcidVolume, BaseVolume};

           if (BaseConcentration.isEmpty() && BaseVolume.isEmpty()) {
               baseAllEmpty = true;
           }
           if (AcidConcentration.isEmpty() && AcidVolume.isEmpty()) {
               acidAllEmpty = true;
           }

           for (String str : Parameters) {
               if (str.isEmpty()) {
                   c--;
               }
           }
           return c;
       }

    public String WhatIsMissing(){

        if(BaseConcentration.isEmpty()){
            return"base concentration";
        }
        else if(BaseVolume.isEmpty()){
            return"base volume";
        }
        else if(AcidConcentration.isEmpty()) {
            return "acid concentration";
        }
        else{
            return "acid volume";

        }
    }
    public void displayError(String s){
        final Stage problem = new Stage();
        problem.initModality(Modality.APPLICATION_MODAL);
        VBox ErrorBox = new VBox(21);
        ErrorBox.setAlignment(Pos.CENTER);
        Text text = new Text(s);
        text.setStyle("-fx-font-size: 14; -fx-font-weight: bold");
        ErrorBox.getChildren().add(text);
        Scene errorScene = new Scene(ErrorBox, 400, 200);
        problem.setScene(errorScene);
        problem.show();
    }

    public boolean checkErrorsInput(){
        boolean wrongInput = false;
        ArrayList<Double> values = new ArrayList<>();

        try{
            if(!AcidConcentration.isEmpty()){
                acidConcentration = Double.parseDouble(AcidConcentration);
                values.add(acidConcentration);
            }
            if(!AcidVolume.isEmpty()){
                acidVolume = Double.parseDouble(AcidVolume);
                values.add(acidVolume);
            }
            if(!BaseConcentration.isEmpty()){
                baseConcentration = Double.parseDouble(BaseConcentration);
                values.add(baseConcentration);
            }
            if(!BaseVolume.isEmpty()){
                baseVolume = Double.parseDouble(BaseVolume);
                values.add(baseVolume);
            }

            }catch(NumberFormatException numberFormatException){
            error = "Please put numbers:))";
            displayError(error);
            wrongInput = true;
            }

        try{
            for (Double n : values){
                if(n <= 0){
                    throw new NegativeInputException("Number should be positive");
                }
            }

            }
            catch (NegativeInputException negativeInputException) {
            error = "Please input anything bigger than 0";
            displayError(error);
            wrongInput = true;
            }
            catch (Exception x){
            System.err.println(x.getMessage());
            wrongInput = true;
            }

        return wrongInput;
    }


}





package Controller;
import View.*;
import Model.*;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.*;
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
                try {

                    String chosenAcid = cpv.getAcidBox().getValue().toString();
                    String chosenBase = cpv.getBaseBox().getValue().toString();
                    System.out.println(chosenAcid + chosenBase);

                    AcidModel acid = (AcidModel) moleculeHolder.getHashMap().get(chosenAcid);
                    BaseModel base = (BaseModel) moleculeHolder.getHashMap().get(chosenBase);

                    displayOutput(acidConcentration, baseConcentration, acidVolume, baseVolume, acid, base);

                }catch(NullPointerException npe){

                }catch(Exception e){

                }
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

    public void displayOutput(double acidConcentration, double baseConcentration, double acidVolume, double baseVolume, AcidModel am, BaseModel bm){

        String acidEmp = am.getEmpiricalFormula();
        String baseEmp = bm.getEmpiricalFormula();

        TextFlow output = new TextFlow();
        Text t1 = new Text("the acid that you chose is "+ acidEmp + "\nthe base that you chose is " + baseEmp);
        t1.setFill(Color.ALICEBLUE);

        Text t2 = new Text("\nThe concentration of the acid is: " + acidConcentration
                + "\nThe volume of the acid is: " + acidVolume);
        t2.setFill(Color.BLUEVIOLET);

        Text t3 = new Text("\nThe concentration of the base is: " + baseConcentration
                + "\nThe volume of the base is: " +baseVolume);
        t3.setFill(Color.CYAN);

        String str = "\n...Generating equation\nThe chemical equation is: ";

        if(baseEmp == "Ca(OH)2"){
            str = str + "2" + acidEmp + " + " + baseEmp + " = " + bm.getPrefix() + am.getSufix()  + " + 2H2O";

        }else{
            str = str + acidEmp + " + " +baseEmp + " = " + bm.getPrefix() + am.getSufix()  + " + H2O";
        }
        Text t4 = new Text(str);
        output.setTextAlignment(TextAlignment.CENTER);
        output.setPrefSize(600, 300);

        output.setLineSpacing(5.0);
        //Retrieving the observable list of the TextFlow Pane
        ObservableList list = output.getChildren();
        //Adding cylinder to the pane
        list.addAll(t1, t2, t3, t4);

        Scene scene = new Scene(output);

        Stage outputStage = new Stage();
        outputStage.setScene(scene);
        outputStage.setTitle("output");
        outputStage.show();

    }}





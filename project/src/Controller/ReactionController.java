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


public class ReactionController {
    boolean baseAllEmpty;
    boolean acidAllEmpty;
    String error,BaseVolume, AcidVolume, BaseConcentration, AcidConcentration;
    double acidConcentration = 0;
    double acidVolume = 0;
    double baseConcentration = 0;
    double baseVolume = 0;

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
                checkErrorsInput();
                switch(choice) {

                    case 1: error = "please input more than 1 parameter for it to work";

                            break;

                    case 2: if(baseAllEmpty){
                                AcidVolume = BaseVolume;
                                int baseConcentration = Calculations.calculateFourth(Integer.parseInt(AcidConcentration),Integer.parseInt(AcidVolume),Integer.parseInt(AcidVolume));
                                BaseConcentration = Integer.toString(baseConcentration);
                            }else if(acidAllEmpty){
                                AcidVolume = BaseVolume;
                                int acidConcentration = Calculations.calculateFourth(Integer.parseInt(BaseConcentration),Integer.parseInt(BaseVolume),Integer.parseInt(BaseVolume));

                            }else{


                    }
                            break;

                    case 3: switch(WhatIsMissing()){
                            case "base concentration": bconcentration = Calculations.calculateFourth(Integer.parseInt(AcidConcentration),Integer.parseInt(AcidVolume),Integer.parseInt(BaseVolume));
                            break;
                            case "acid concentration":aconcentration = Calculations.calculateFourth(Integer.parseInt(BaseConcentration),Integer.parseInt(BaseVolume),Integer.parseInt(AcidVolume));
                            break;
                            case "base volume": bvolume = Calculations.calculateFourth(Integer.parseInt(AcidConcentration),Integer.parseInt(AcidVolume),Integer.parseInt(BaseConcentration));
                            break;
                            case "acid volume": avolume = Calculations.calculateFourth(Integer.parseInt(BaseConcentration),Integer.parseInt(BaseVolume),Integer.parseInt(AcidVolume));
                            }
                            break;

                    case 4:
                        boolean balanced = Calculations.calculate(Integer.parseInt(AcidConcentration),Integer.parseInt(AcidVolume),Integer.parseInt(BaseConcentration),Integer.parseInt(BaseVolume));
                            if(balanced){
                                System.out.println("yeah it is good");
                            }else{
                                error = "try to make it balanced...or leave one or two Textfield blank"; }
                            break;
                            default: error = "nothing is there... please input something";
                            break;
                    }
                    if(!error.isEmpty())displayError(error);
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

    public void checkErrorsInput(){

        double[] inputArrDouble = {acidConcentration,acidVolume,baseConcentration,baseVolume};
        String[] inputArrString = {BaseVolume, AcidVolume, BaseConcentration, AcidConcentration};

        try{

            for(String str: inputArrString){
                if (str.isEmpty()){
                    throw new NullPointerException();
                }
            }

            acidConcentration = Double.parseDouble(AcidConcentration);
            acidVolume = Double.parseDouble(AcidVolume);
            baseConcentration = Double.parseDouble(BaseConcentration);
            baseVolume = Double.parseDouble(BaseVolume);

            }catch(NumberFormatException numberFormatException){
            System.err.println("NumberFormatException");

            }

        try{
            for (double n:inputArrDouble){

                if(n<=0){
                    throw new NegativeInputException("Number should be positive");
                }
            }

            }catch (NegativeInputException negativeInputException) {
            System.err.println("NegativeInputException");
            }
            catch (Exception x){
            System.err.println(x.getMessage());
            }

    }



}





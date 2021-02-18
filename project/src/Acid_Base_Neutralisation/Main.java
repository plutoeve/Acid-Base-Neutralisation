package Acid_Base_Neutralisation;

import View.MainView;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;

public class Main extends Application{

    public static Stage firstStage;

    public void start(Stage stage) throws Exception {
        firstStage = stage;
        stage.setTitle("Neutralisation Simulator");
        MainView mv = new MainView();

        stage.show();
    }
    public static void main(String[] arg){
        launch(arg);


    }
}

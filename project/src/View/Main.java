package View;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application{

    public static Stage firstStage;

    public void start(Stage stage) throws Exception {
        firstStage = stage;
        stage.setTitle("Neutralisation simulator");
        mainView mv = new mainView();
        stage.show();
    }
    public static void main(String[] arg){
        launch(arg);
    }
}

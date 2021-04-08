package Acid_Base_Neutralisation;

import View.MainView;
import javafx.application.Application;
import javafx.scene.media.*;
import javafx.stage.Stage;

import java.io.File;
import java.lang.reflect.InvocationTargetException;

public class Main extends Application{

    public static Stage firstStage;
    public static MediaPlayer click, water;

    public void start(Stage stage) throws Exception {

            Media clickMedia = new Media(getClass().getResource("click.wav").toExternalForm());
            Media waterMedia = new Media(getClass().getResource("water.mp3").toExternalForm());
            click = new MediaPlayer(clickMedia);
            water = new MediaPlayer(waterMedia);

        firstStage = stage;
        stage.setTitle("Neutralisation Simulator");
        MainView mv = new MainView();
        MainView.scene.getStylesheets().addAll(this.getClass().getResource("CSSBackground.css").toExternalForm());
        
        stage.show();
    }
    public static void main(String[] arg){
        launch(arg);


    }
}

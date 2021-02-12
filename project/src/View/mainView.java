
package View;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;

import javafx.scene.control.*;

public class mainView {

    GridPane pane = new GridPane();
    Scene scene = new Scene(pane, 100,100);
    Button startButton = new Button("start");
    Button resetButton = new Button("reset");

    public mainView() {

        Main.firstStage.setScene(scene);
        pane.getChildren().addAll(startButton);
        startButton.setOnAction(start);


    }

    EventHandler start = new EventHandler() {
        @Override
        public void handle(Event event) {
           Main.firstStage.setScene(simulationView.simulationScene);
        }
    };
}

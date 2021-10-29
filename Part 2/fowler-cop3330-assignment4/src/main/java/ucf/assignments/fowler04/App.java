package ucf.assignments.fowler04;

import javafx.application.Application;
import javafx.stage.Stage;

import ucf.assignments.fowler04.gui.Util;

public class App extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(Util.loadView("Test"));
        stage.show();
    }
}

package ucf.assignments.fowler04.gui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import ucf.assignments.fowler04.App;

import java.util.Objects;

public class Util {
    public static Scene loadView(String fxmlName) throws Exception {
        return new Scene(FXMLLoader.load(Objects.requireNonNull(Util.class.getResource("/views/" + fxmlName + ".fxml"))));
    }

}

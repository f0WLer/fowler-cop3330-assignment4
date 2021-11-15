package ucf.assignments.gui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.util.Objects;

public class Util {
    public static Scene loadView(String fxmlName) throws Exception {
        return new Scene(FXMLLoader.load(Objects.requireNonNull(Util.class.getResource("/views/" + fxmlName + ".fxml"))));
    }
}

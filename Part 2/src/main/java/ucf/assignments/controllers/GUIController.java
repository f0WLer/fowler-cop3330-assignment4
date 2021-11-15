package ucf.assignments.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Orientation;
import javafx.scene.control.Separator;
import javafx.scene.control.TabPane;
import javafx.scene.control.TreeView;
import javafx.scene.layout.AnchorPane;
import ucf.assignments.App;
import ucf.assignments.gui.ListEditor;
import ucf.assignments.gui.WorkspaceView;

import static ucf.assignments.gui.Util.*;

import java.io.IOException;

public class GUIController {
		@FXML
		private AnchorPane appBody;
		public TreeView<String> workspaceView;
		private TabPane listEditor;

		public void initialize() throws IOException {
				// Load the Workspace Viewer from FXML.
				FXMLLoader fxml = getFXML("views/workspaceViewer");
				this.workspaceView = fxml.load();
				// Initialize the WorkspaceView class.
				App.gui.workspaceView = new WorkspaceView(this.workspaceView, fxml.getController());

				// Load the List Editor from FXML.
				fxml = getFXML("views/listEditor");
				this.listEditor = fxml.load();
				// Initialize the ListEditor class.
				App.gui.listEditor = new ListEditor(this.listEditor, fxml.getController());

				// Create a separator to go between the two.
				Separator s = new Separator(Orientation.VERTICAL);
				s.setLayoutX(259);
				setAnchors(s, 0.0, 744.0, 0.0, 256.0);

				// Add all the elements to the GUI's body.
				appBody.getChildren().addAll(this.listEditor, s, this.workspaceView);
		}

}

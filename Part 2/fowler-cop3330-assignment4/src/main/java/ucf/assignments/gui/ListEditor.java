package ucf.assignments.gui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import ucf.assignments.App;
import ucf.assignments.controllers.ListEditorController;
import ucf.assignments.controllers.TabController;
import ucf.assignments.controllers.newListPromptController;
import ucf.assignments.todo.List;

import java.io.IOException;
import java.util.ArrayList;

import static ucf.assignments.gui.Util.getFXML;

public class ListEditor {
		public final TabPane pane;
		private final ListEditorController controller;
		public ArrayList<TabController> tabs = new ArrayList<>();

		public ListEditor(TabPane node, ListEditorController controller) {
				this.pane = node;
				this.controller = controller;

				// TODO: Add help tab.
		}

		public TabController findTab(int listIndex) {
				for (TabController t : this.tabs)
						if (t.listIndex() == listIndex)
								return t;
				return null;
		}

		public void newTab(List list, int listIndex) throws IOException {
				App.debugLog("Creating tab for list "+list.title());
				// Load new tab from FXML.
				FXMLLoader fxml = getFXML("views/tab");
				Tab tab = fxml.load();
				// Initialize Tab.
				TabController controller = fxml.getController();
				controller.init(list, listIndex);
				this.tabs.add(controller);
				// Add Tab to editor.
				this.pane.getTabs().add(tab);
				this.pane.getSelectionModel().select(this.pane.getTabs().size() - 1);
				// Prompt user for tab (list) title.
				App.gui.promptForTitle(true);
		}

}

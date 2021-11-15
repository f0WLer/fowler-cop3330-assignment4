package ucf.assignments.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.scene.control.Tab;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import ucf.assignments.App;
import ucf.assignments.todo.List;

import java.io.IOException;

import static ucf.assignments.gui.Util.getFXML;

public class TabController {
		@FXML
		public AnchorPane body;
		public Tab root;

		// listIndex property getter.
		public int listIndex() {
				return (int)root.getProperties().get("listIndex");
		}

		public void init(List list, int listIndex) throws IOException {
				// listIndex is index of this tab in App.lists().
				this.root.getProperties().put("listIndex", listIndex);

				// Set tab's title.
				this.root.setText(list.title());

				if (list.getItems().size() == 0)
						return;

				// For item in list:
				for (int i = 0; i < list.getItems().size(); i++) {
						// Create and add a new item card
						newCard(i, false);
				}
		}

		public void newCard(int itemIndex, boolean isNew) throws IOException {
				App.debugLog("Creating item card for item " + itemIndex);
				FXMLLoader cardLoader = getFXML("views/itemCard");
				Pane card = cardLoader.load();
				((ItemCardController)cardLoader.getController()).init(this, body, this.listIndex(), itemIndex, isNew);

				body.getChildren().add(card);
		}
}


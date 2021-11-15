package ucf.assignments.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import ucf.assignments.App;
import ucf.assignments.controllers.GUIController;
import ucf.assignments.controllers.TabController;
import ucf.assignments.controllers.newListPromptController;
import ucf.assignments.todo.Item;
import ucf.assignments.todo.List;

import java.io.IOException;

import static ucf.assignments.gui.Util.getFXML;

public class GUI extends Application {
		public Stage stage;
		public Scene scene;
		public GUIController controller;

		public WorkspaceView workspaceView;
		public ListEditor listEditor;

		public GUI() {}

		// Launches JavaFX Application.
		public void launch() {
				Application.launch(GUI.class);
		}

		@Override
		public void start(Stage stage) throws Exception {
				System.out.println("Application Started");
				Thread.setDefaultUncaughtExceptionHandler(App::spitError);

				this.stage = stage;
				FXMLLoader fxml = getFXML("views/AppGUI");
				this.stage.setScene(new Scene(fxml.load()));
				this.scene = this.stage.getScene();
				this.controller = fxml.getController();

				stage.show();
		}


		public void newList(List list) throws IOException {
				// Add to the App lists.
				App.lists().add(list);
				int listIndex = App.lists().size() - 1;
				// Open in the List Editor.
				listEditor.newTab(list, listIndex);
				// Add to the Workspace View.
				workspaceView.addList(list, listIndex);
		}

		public void newItem(Item item) throws IOException {
				// Get the list index of the current tab.
				int tabIndex = this.listEditor.pane.getSelectionModel().getSelectedIndex();
				int listIndex = (int)this.listEditor.pane.getTabs().get(tabIndex).getProperties().get("listIndex");
				// Add the item to the list.
				List list = App.lists().get(listIndex);
				list.addItem(item);
				// Add the new card to the list.
				int itemIndex = list.getItems().indexOf(item);
				this.listEditor.tabs.get(tabIndex).newCard(itemIndex, true);
				// Add the item to its corresponding branch in the Workspace View
				WorkspaceView.Branch branchMap = this.workspaceView.findBranch(listIndex);
				if (branchMap == null) { App.debugLog("ERROR: Branch is null!"); return; }
				this.workspaceView.addItem(branchMap, item, itemIndex);
		}

		public void removeItem(TabController tab, int listIndex, int itemIndex) {
				// Remove the corresp. item at index 'itemIndex' from list at index 'listIndex' in App.lists().
				App.lists().get(listIndex).getItems().remove(itemIndex);
				// Remove the card from the tab.
				tab.body.getChildren().remove(itemIndex);
				// Update all succeeding cards.
				for (int i = itemIndex; i < tab.body.getChildren().size(); i++) {
						// Move the card up one.
						Pane card = (Pane)tab.body.getChildren().get(i);
						Bounds bounds = card.getBoundsInParent();
						card.setLayoutY(bounds.getMinY() - card.getHeight() + card.getInsets().getTop());
						// Update the card's 'itemIndex'.
						card.getProperties().put("itemIndex", (int)card.getProperties().get("itemIndex") - 1);
				}
				// Update the Workspace View
				this.workspaceView.removeItem(listIndex, itemIndex);
				System.out.println(App.lists().get(0).toString());
		}

		public void promptForTitle(boolean newList) throws IOException {
				// Get the current tab.
				int tabIndex = this.listEditor.pane.getSelectionModel().getSelectedIndex();
				TabController tab = this.listEditor.tabs.get(tabIndex);
				int listIndex = tab.listIndex();

				// Create pop-up window.
				final Stage popUp = new Stage();
				popUp.initModality(Modality.APPLICATION_MODAL);
				popUp.initOwner(this.stage);
				// Load FXML
				FXMLLoader fxml = getFXML("views/newListPrompt");
				VBox promptBox = fxml.load();
				newListPromptController pCont = fxml.getController();
				// Initialize pop-up.
				pCont.init(listIndex, popUp, newList);
				// Display pop-up.
				Scene popUpScene = new Scene(promptBox);
				popUp.setScene(popUpScene);
				popUp.show();
		}

		public void setListTitle(int listIndex, String newTitle) {
				// Change list title.
				App.lists().get(listIndex).title(newTitle);
				// Update in List Editor.
				TabController tab = this.listEditor.findTab(listIndex);
				if (tab == null) { App.debugLog("ERROR: Tab is null!"); return; }
				tab.root.setText(newTitle);
				// Update in WorkspaceView.
				this.workspaceView.renameList(listIndex, newTitle);
		}
}

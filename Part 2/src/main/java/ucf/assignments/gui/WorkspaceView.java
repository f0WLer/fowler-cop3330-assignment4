package ucf.assignments.gui;

import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import ucf.assignments.App;
import ucf.assignments.controllers.WorkViewController;
import ucf.assignments.todo.Item;
import ucf.assignments.todo.List;

import java.util.ArrayList;

public class WorkspaceView {
		private final TreeView<String> tree;
		public final TreeItem<String> root;

		ArrayList<Branch> treeMap = new ArrayList<Branch>();

		public static class Branch {
				int id;
				ArrayList<Integer> nodes = new ArrayList<>();
		}

		public Branch findBranch(int listIndex) {
				// Search for the branch in the treeMap and return.
				for (Branch b : this.treeMap) {
						if (b.id == listIndex)
								return b;
				}
				// Not found, return null.
				return null;
		}

		public void addItem(Branch branchMap, Item item, int itemIndex) {
				App.debugLog("Adding item to Workspace View.");
				branchMap.nodes.add(itemIndex, itemIndex);
				// Get the branch from the root branch
				TreeItem<String> branch = root.getChildren().get(this.treeMap.indexOf(branchMap));
				// Create new twig.
				TreeItem<String> twig = new TreeItem<>(item.description());
				branch.getChildren().add(itemIndex, twig);
		}

		public void renameList(int listIndex, String newTitle) {
				Branch branch = findBranch(listIndex);
				if (branch == null) { App.debugLog("Branch is null!"); return; }
				this.root.getChildren().get(treeMap.indexOf(branch)).setValue(newTitle);
		}

		public void removeItem(int listIndex, int itemIndex) {
				// Find the branch map.
				Branch branchMap = findBranch(listIndex);
				// Remove the node from the map.
				branchMap.nodes.remove(itemIndex);
				// Remove the twig from the branch.
				this.root.getChildren().get(this.treeMap.indexOf(branchMap)).getChildren().remove(itemIndex);
		}

		public WorkspaceView(TreeView<String> node, WorkViewController controller) {
				this.tree = node;
				this.root = controller.root;

				tree.getProperties().put("treeMap", new ArrayList<Branch>());
		}

		public void addList(List list, int listIndex) {
				// Create Branch
				TreeItem<String> branch = new TreeItem<>(list.title());
				// Create Branch Map
				Branch branchMap = new Branch();
				branchMap.id = listIndex;

				// For item in list
				for (int i = 0; i < list.getItems().size(); i++) {
						Item item = list.getItem(i);
						App.debugLog(item.description());

						// Create Twig
						TreeItem<String> twig = new TreeItem<>(item.description());
						// Add Twig to Branch
						branch.getChildren().add(twig);
						// Add index to Branch Map
						branchMap.nodes.add(i);
				}

				// Add Branch to Tree
				this.root.getChildren().add(branch);
				// Add index to tree map
				this.treeMap.add(branchMap);
				// Set tree map back
				this.tree.getProperties().put("treeMap", this.treeMap);
		}
}

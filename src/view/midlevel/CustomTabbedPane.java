package view.midlevel;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JTabbedPane;

import com.sun.glass.ui.SystemClipboard;

import main.Core;
import view.dynamic.DynamicParameterTab;
import view.export.ExportPanel;
import view.nondynamic.ModulePanel;
import view.tree.CustomTreeNode;
import view.tree.Module;
import view.tree.Parameter;

public class CustomTabbedPane extends JTabbedPane {

	private ArrayList<CustomTreeNode> nodes;

	public CustomTabbedPane() {
		nodes = new ArrayList<>();
		setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		addChangeListener(Core.getInstance().getActionManager().getTabbedPaneChangeListener());

	}

	public void openTab(CustomTreeNode node) {
		if (!nodes.contains(node)) {
			if (node instanceof Parameter) {
				nodes.add(getTabCount(), node);
				addTab(node.getName(), new DynamicParameterTab((Parameter) node));
			} else if (node instanceof Module) {
				nodes.add(getTabCount(), node);
				addTab(node.getName(), new ModulePanel((Module) node));
			}
		}
	}

	public ArrayList<CustomTreeNode> getNodes() {
		return nodes;
	}

}

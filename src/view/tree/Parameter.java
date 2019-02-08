package view.tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Enumeration;

import model.tree.ParameterModel;
import view.dynamic.custom.CustomPreviewPanel;

public class Parameter extends CustomTreeNode implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6850789776471043815L;
	private ParameterModel model;
	private CustomPreviewPanel customPanel;

	public Parameter(String name) {
		super(name);
		model = new ParameterModel(name, null);
		setNodeModel(model);

	}

	@Override
	public boolean isLeaf() {
		return true;
	}

	@Override
	public Enumeration<CustomTreeNode> children() {
		return null;
	}

	@Override
	public void setChildren(ArrayList<CustomTreeNode> children) {
		// Ne radi nista samo je overriden
	}

	@Override
	public ParameterModel getNodeModel() {
		return (ParameterModel) super.getNodeModel();
	}

	public CustomPreviewPanel getCustomPanel() {
		return customPanel;
	}

	public void setCustomPanel(CustomPreviewPanel customPanel) {
		this.customPanel = customPanel;
	}

}

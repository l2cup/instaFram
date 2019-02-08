package view.tree;

import java.io.Serializable;

import model.tree.ModuleModel;

public class Module extends CustomTreeNode implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3693933397976002385L;
	ModuleModel model;

	public Module(String name) {
		super(name);
		model = new ModuleModel(name);
		setNodeModel(model);

	}

	@Override
	public ModuleModel getNodeModel() {
		return (ModuleModel) super.getNodeModel();
	}

}

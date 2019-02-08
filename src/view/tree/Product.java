package view.tree;

import java.io.Serializable;

import model.tree.ProductModel;

public class Product extends CustomTreeNode implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 684241924561141722L;
	ProductModel model;

	public Product(String name) {
		super(name);
		model = new ProductModel(name);
		setNodeModel(model);

	}

	@Override
	public ProductModel getNodeModel() {
		return (ProductModel) super.getNodeModel();
	}

}

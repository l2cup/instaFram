package view.tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

import model.tree.CustomNodeModel;

public class CustomTreeNode extends DefaultMutableTreeNode implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7000443373653591863L;
	private String name;
	private ArrayList<CustomTreeNode> children;
	private CustomTreeNode parent;
	private CustomNodeModel nodeModel;

	public CustomTreeNode(String name) {
		this.name = name;
		children = new ArrayList<>();
		nodeModel = new CustomNodeModel(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addNode(CustomTreeNode node) {	
		if(node.getName().equals("@arg1")) {
			children.add(node);
			node.setName(node.getClass().getSimpleName() + " " + children.size());
			node.setParent(this);
		}
		else {
			addNodeCustomName(node);
		}
	}

	public void addNodeCustomName(CustomTreeNode node) {	
		children.add(node);
		node.setParent(this);
	}

	@Override
	public TreeNode getChildAt(int childIndex) {
		return children.get(childIndex);
	}

	@Override
	public int getChildCount() {
		return children.size();
	}

	@Override
	public TreeNode getParent() {
		return parent;
	}

	@Override
	public int getIndex(TreeNode node) {
		return children.indexOf(node);
	}

	@Override
	public boolean getAllowsChildren() {
		return true;
	}

	@Override
	public boolean isLeaf() {
		return children.isEmpty();
	}

	@Override
	public Enumeration<CustomTreeNode> children() {
		return Collections.enumeration(children);
	}

	@Override
	public String toString() {
		return name;
	}

	public void setParent(CustomTreeNode parent) {
		this.parent = parent;
	}

	public void setChildren(ArrayList<CustomTreeNode> children) {
		this.children = children;
	}

	public ArrayList<CustomTreeNode> getChildrenArrayList() {
		return children;
	}

	@Override
	public void insert(MutableTreeNode child, int index) {
		addNode((CustomTreeNode) child);

	}

	@Override
	public void remove(int index) {
		children.remove(index);
	}

	@Override
	public void remove(MutableTreeNode node) {
		children.remove(node);

	}

	@Override
	public void setUserObject(Object object) {

	}

	@Override
	public void removeFromParent() {
		parent.getChildrenArrayList().remove(this);

	}

	@Override
	public void setParent(MutableTreeNode newParent) {
		parent = (CustomTreeNode) newParent;
	}

	public CustomNodeModel getNodeModel() {
		return nodeModel;
	}

	public void setNodeModel(CustomNodeModel nodeModel) {
		this.nodeModel = nodeModel;
	}

}

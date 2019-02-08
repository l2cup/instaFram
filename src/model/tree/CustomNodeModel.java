package model.tree;

import java.io.Serializable;
import java.util.Observable;
import java.util.Observer;

public class CustomNodeModel extends Observable implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2168656729848968511L;
	private String name;
	private int leafCount;
	private int childCount;

	public CustomNodeModel(String name) {
		this.name = name;
	}

	public void setLeafCount(int leafCount) {
		this.leafCount = leafCount;
		setChanged();
		notifyObservers(leafCount);
	}

	public void setChildCount(int childCount) {
		this.childCount = childCount;
		setChanged();
		notifyObservers(childCount);
	}

	public void setName(String name) {
		this.name = name;
		setChanged();
		notifyObservers(name);
	}

	public String getName() {
		return name;
	}

	public int getLeafCount() {
		return leafCount;
	}

	public int getChildCount() {
		return childCount;
	}

	@Override
	public synchronized void addObserver(Observer o) {
		super.addObserver(o);
	}

	@Override
	public synchronized void deleteObserver(Observer o) {
		super.deleteObserver(o);
	}

}

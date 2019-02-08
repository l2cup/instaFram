package model.tree;

import java.io.Serializable;
import java.util.Observer;

public class ProductModel extends CustomNodeModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4342121030325370956L;
	boolean moduleOnly = true;

	public ProductModel(String name) {
		super(name);
	}

	public boolean isModuleOnly() {
		return moduleOnly;
	}

	public void setModuleOnly(boolean moduleOnly) {
		this.moduleOnly = moduleOnly;
	}

	@Override
	public synchronized void addObserver(Observer o) {
		super.addObserver(o);
	}

	@Override
	public void notifyObservers(Object arg) {
		super.notifyObservers(arg);
	}

}

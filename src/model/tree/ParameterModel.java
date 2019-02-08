package model.tree;

import java.io.File;
import java.io.Serializable;
import java.util.Observer;

public class ParameterModel extends CustomNodeModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3845167656851545341L;
	private ParameterType type;
	private String value;
	private String URL;
	private File file;

	public ParameterModel(String name, ParameterType type) {
		super(name);
		this.type = type;
	}

	@Override
	public int getLeafCount() {
		return 0;
	}

	public ParameterType getType() {
		return type;
	}

	public void setType(ParameterType type) {
		this.type = type;
		setChanged();
		notifyObservers(type);
	}

	@Override
	public synchronized void addObserver(Observer o) {
		super.addObserver(o);
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String URL) {
		this.URL = URL;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

}

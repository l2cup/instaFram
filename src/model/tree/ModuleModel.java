package model.tree;

import java.io.File;
import java.io.Serializable;

public class ModuleModel extends CustomNodeModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1837897172536625726L;
	private String path;
	private String destinationPath;
	private File file;
	private boolean startAfterInstalation = false;
	private boolean desktopShortcut = false;

	public ModuleModel(String name) {
		super(name);
		destinationPath = "";
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	public void setDestinationPath(String destinationPath) {
		this.destinationPath = destinationPath;
		setChanged();
		notifyObservers(destinationPath);
	}
	
	public boolean isDesktopShortcut() {
		return desktopShortcut;
	}
	
	public void setDesktopShortcut(boolean desktopShortcut) {
		this.desktopShortcut = desktopShortcut;
	}
	
	public boolean isStartAfterInstalation() {
		return startAfterInstalation;
	}
	
	public void setStartAfterInstalation(boolean startAfterInstalation) {
		this.startAfterInstalation = startAfterInstalation;
	}
	
	public String getDestinationPath() {
		return destinationPath;
	}
	
	
	

}

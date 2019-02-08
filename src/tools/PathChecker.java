package tools;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import exception_handler.ExceptionType;
import main.Core;
import view.tree.CustomTreeNode;
import view.tree.Module;
import view.tree.Product;

public class PathChecker {
	
	private ArrayList<Module> modules;
	
	public boolean arePathsFilled(Product p) {
		modules = new ArrayList<>();
		for (CustomTreeNode node : p.getChildrenArrayList()) {
			if(node instanceof Module) {
				Module m = (Module)node;
				if(m.getNodeModel().getPath()==null || m.getNodeModel().getPath().equals(""))
					modules.add(m);
				}
		}
		if(!modules.isEmpty()) {
			Core.getInstance().getExceptionHandlerDialog().showDialog(ExceptionType.PATH_MISSING, modulesToString());
			return false;
		}  
		else {
			
			return true;
		}
	}
	
	private String modulesToString() {
		String modulesString = "";
		for (Module module : modules) {
			modulesString += module.getName() + "\n";
		}
		return modulesString;
	}
	
	
}

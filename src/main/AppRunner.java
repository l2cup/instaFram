package main;

import view.tree.CustomTreeNode;

public class AppRunner {

	public static void main(String[] args) {
		Core core = Core.getInstance();
		core.init();	
		core.initMainFrame();

	}

}


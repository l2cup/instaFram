package tools;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import view.tree.Module;

public class Runner {
	
	public static void Run(ArrayList<Module> modules) {
		for (Module module : modules) {
			if(Desktop.isDesktopSupported()) {
				try {
					Path path = Paths.get(module.getNodeModel().getPath());
					Desktop.getDesktop().open(new File(module.getNodeModel().getDestinationPath().concat(File.separator + path.getFileName())));
				} catch (IOException e) {
					System.out.println(e);
					//TODO ERROR FILE NOT FOUND
				}
			}
			
		}

	}

}

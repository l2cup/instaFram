package tools;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

import javafx.animation.PathTransition;
import view.tree.Module;

public class CopyHelper {
	
	public static void copy(ArrayList<Module> modules) {
		
		for (Module module : modules) {
			
			Path source = Paths.get(module.getNodeModel().getPath());
			Path destination = Paths.get(module.getNodeModel().getDestinationPath().concat(File.separator + source.getFileName()));
			
			if(module.getNodeModel().isDesktopShortcut()) {
				//TODO
			}
			
			try {
				Files.copy(source, destination,StandardCopyOption.REPLACE_EXISTING);
					
			} catch (IOException e) {
				//TODO ERROR HANDLING
				e.printStackTrace();
			}
				
			
			
		}
		
	}

}

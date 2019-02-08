package tools;

import java.awt.Component;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;

import main.Core;
import view.tree.CustomTreeNode;
import view.tree.Module;
import view.tree.Parameter;
import view.tree.Product;

public class ObjectReader {

	public static void readObject(CustomTreeNode node) {
		JFileChooser jfc = new JFileChooser();
		String suffix = getSuffix(node);
		FileNameExtensionFilter filter = new FileNameExtensionFilter("." + suffix + " Files", suffix);
		jfc.setAcceptAllFileFilterUsed(false);
		jfc.addChoosableFileFilter(filter);
		jfc.setFileFilter(filter);

		File file = null;

		if (jfc.showOpenDialog(Core.getInstance().getMainFrame()) == JFileChooser.APPROVE_OPTION)
			file = jfc.getSelectedFile();
		if (file != null) {
			try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));) {
				if (node instanceof Parameter)
					System.out.println("You can't read to a parameter");
				else if (node instanceof Module)
					((Module) node).addNodeCustomName((Parameter) ois.readObject());
				else if (node instanceof Product)
					((Product) node).addNodeCustomName((Module) ois.readObject());
				else
					node.addNodeCustomName((Product) ois.readObject());
				
				SwingUtilities.updateComponentTreeUI(Core.getInstance().getTree());

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}

	}

	private static String getSuffix(CustomTreeNode node) {
		if (node instanceof Module)
			return "param";
		else if (node instanceof Product)
			return "module";
		else
			return "prod";
	}
}

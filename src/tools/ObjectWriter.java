package tools;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.lang.model.element.Element;
import javax.naming.InsufficientResourcesException;
import javax.swing.JFileChooser;

import main.Core;
import view.tree.CustomTreeNode;
import view.tree.Module;
import view.tree.Parameter;
import view.tree.Product;

public class ObjectWriter {

	public static void writeObject(CustomTreeNode node) {
		JFileChooser jfc = new JFileChooser();
		File file = null;
		String suffix = getSuffix(node);
		if (jfc.showSaveDialog(Core.getInstance().getMainFrame()) == JFileChooser.APPROVE_OPTION) {
			if (!jfc.getSelectedFile().getName().endsWith(suffix))
				file = new File(jfc.getSelectedFile() + suffix);
			else
				file = jfc.getSelectedFile();
		}
		if (file != null) {
			try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));) {
				oos.writeObject(node);

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	private static String getSuffix(CustomTreeNode node) {
		if (node instanceof Parameter)
			return ".param";
		else if (node instanceof Module)
			return ".module";
		else if (node instanceof Product)
			return ".prod";
		else
			return ".softcomp";
	}

}

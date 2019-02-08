package view.export;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import tools.CopyHelper;
import tools.Runner;
import view.tree.CustomTreeNode;
import view.tree.Module;
import view.tree.Product;

public class ExportFrame extends JFrame {
	
	public static ExportFrame instance = null;
	private ArrayList<Module> modules;
	private ExportPanel panel;
	private int installed;
	private Product product;
	private GridBagConstraints c;
	
	private ExportFrame() {
		modules = new ArrayList<>();
		panel = null;
		installed = 0;
		setSize(new Dimension(500, 500));
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.anchor = GridBagConstraints.PAGE_START;
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 1;
		c.weighty = 1;
		setLayout(new GridBagLayout());
	}
	
	public static ExportFrame getInstance() {
		if(instance == null)
			instance = new ExportFrame();
		return instance;
	}
	
	public void startInstalation(Product p) {
		if(installed == 0) {
			fillList(p);
			install(modules.get(installed));
		}
		if(installed!=modules.size())
			install(modules.get(installed));
		else {
			CopyHelper.copy(modules);
			Runner.Run(modules);
			terminate();
		}
	}
	
	private void install(Module m) {
		if(panel!=null)
			remove(panel);
		panel = new ExportPanel(m);
		add(panel,c);
		setVisible(true);
		revalidate();
		repaint();
	}
	
	public void fillList(Product p) {
		for (CustomTreeNode ctn : p.getChildrenArrayList()) {
			if(ctn instanceof Module) {
				modules.add((Module)ctn);
				System.out.println(ctn.getName());
			}
		}
		product = p;
	}
	
	public Product getProduct() {
		return product;
	}
	
	public void incraseInstalled() {
		installed++;
	}
	
	public void terminate() {
		installed = 0;
		product = null;
		modules.clear();
		dispose();
	}
}

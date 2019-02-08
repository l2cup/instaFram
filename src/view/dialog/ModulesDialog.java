package view.dialog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.sun.javafx.collections.MappingChange.Map;

import javafx.scene.layout.Border;
import view.export.ExportFrame;
import view.tree.CustomTreeNode;
import view.tree.Module;
import view.tree.Product;

public class ModulesDialog extends JFrame {
	
	private Product temp;
	private JPanel mainPanel, checkBoxPanel,buttonPanel;
	private HashMap<Module, JCheckBox> modulesHashMap;
	private JButton btnCancel,btnInstall;
	private GridBagConstraints c;
	
	public ModulesDialog() {
		initPane();
	}
	
	
	private void initPane() {
		setSize(300, 300);
		setTitle("Choose Modules");
		modulesHashMap = new HashMap<>();
		mainPanel = new JPanel();
		c = new GridBagConstraints();
		mainPanel.setLayout(new GridBagLayout());
		checkBoxPanel = new JPanel();
		checkBoxPanel.setLayout(new BoxLayout(checkBoxPanel, BoxLayout.Y_AXIS));
		buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,20,20));
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(a -> dispose());
		btnInstall = new JButton("Install");
		btnInstall.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				startInstalation();
				dispose();
				
			}
		});
		buttonPanel.add(btnCancel);
		buttonPanel.add(btnInstall);
		c.anchor = GridBagConstraints.PAGE_START;
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 1;
		c.weighty = 1;
		mainPanel.add(checkBoxPanel,c);
		c.weightx = 0;
		c.gridy = 1;
		mainPanel.add(buttonPanel,c);
		add(mainPanel);
	}
	
	public void showDialog(Product p) {
		reset();
		fillTemp(p);	
		revalidate();
		repaint();
		setVisible(true);
	}
	
	private void fillTemp(Product p) {
		temp = new Product("Temp");
		for (CustomTreeNode c : p.getChildrenArrayList()) {
			if(c instanceof Module) {
				temp.getChildrenArrayList().add(c);
				JCheckBox checkBox = createCheckBox((Module)c);
				modulesHashMap.put((Module)c, checkBox);
				checkBoxPanel.add(checkBox);
				checkBox.setAlignmentX(CENTER_ALIGNMENT);
			}
		}
		checkBoxPanel.revalidate();
		checkBoxPanel.repaint();
	}
	
	private void startInstalation() {
		for (Entry<Module, JCheckBox> entry : modulesHashMap.entrySet()) {
		    if(!entry.getValue().isSelected())
		    	temp.getChildrenArrayList().remove(entry.getKey());
		}
		
		ExportFrame.getInstance().startInstalation(temp);
	}
	
	private void reset() {
		temp = null;
		checkBoxPanel.removeAll();
		modulesHashMap.clear();
	}
	
	private JCheckBox createCheckBox(Module m) {
		JCheckBox checkBox = new JCheckBox(m.getName());
		checkBox.setSelected(true);
		return checkBox;
	}
	
	
}

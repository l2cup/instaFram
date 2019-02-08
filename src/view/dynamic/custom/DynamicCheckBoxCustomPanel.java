package view.dynamic.custom;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import view.list.ListViewFrame;
import view.tree.Parameter;

public class DynamicCheckBoxCustomPanel extends JPanel {

	private CustomPreviewPanel preview;
	private JTextField cbNameTextField;
	private JButton btnAdd, btnRemove, btnPreview;
	private GridBagConstraints c;

	public DynamicCheckBoxCustomPanel(Parameter p) {
		initPane(p);
	}

	private void initPane(Parameter p) {
		setName("CheckBox");
		if (p.getCustomPanel() == null) {
			p.setCustomPanel(new CustomPreviewPanel());
		}
		preview = p.getCustomPanel();
		c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.anchor = GridBagConstraints.PAGE_START;
		btnAdd = new JButton("Add");
		btnPreview = new JButton("Preview");
		btnRemove = new JButton("Remove");
		cbNameTextField = new JTextField();
		add(new JLabel("Naziv:"), c);
		c.gridx = 1;
		c.weightx = 1;
		cbNameTextField.setPreferredSize(new Dimension(220, 25));
		add(cbNameTextField, c);
		c.weightx = 0;
		c.gridx = 0;
		c.gridy = 1;
		add(btnAdd, c);
		btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				addCheckBox();
				cbNameTextField.setText("");
			}
		});
		btnPreview.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CustomPreviewFrame.getInstance().showPreview(p);
			}
		});
		btnRemove.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ListViewFrame.getInstance().showPane(preview, ListViewFrame.CHECKBOX);
			}
		});
		c.gridx = 1;
		add(btnRemove, c);
		c.gridx = 2;
		add(btnPreview, c);
		setVisible(true);

	}

	private void addCheckBox() {
		if (cbNameTextField.getText() != null && cbNameTextField.getText() != "") {
			preview.addCheckBox(cbNameTextField.getText());
		}
	}

}

package view.dynamic.custom;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import view.list.ListViewFrame;
import view.tree.Parameter;

public class DynamicTextfieldCustomPanel extends JPanel {

	private CustomPreviewPanel preview;
	private JTextField textFieldName, textFieldContent;
	private JCheckBox contentCheckBox;
	private GridBagConstraints c;
	private JButton btnRemove, btnAdd, btnPreview;

	public DynamicTextfieldCustomPanel(Parameter p) {
		initPane(p);
	}

	private void initPane(Parameter p) {
		setName("TextField");
		if (p.getCustomPanel() == null) {
			p.setCustomPanel(new CustomPreviewPanel());
		}
		setLayout(new GridBagLayout());
		preview = p.getCustomPanel();
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.anchor = GridBagConstraints.PAGE_START;
		c.gridx = 0;
		c.gridy = 0;
		add(new JLabel("Field Name:"), c);
		c.gridx = 1;
		textFieldName = new JTextField();
		textFieldName.setPreferredSize(new Dimension(200, 30));
		c.weightx = 1;
		add(textFieldName, c);
		c.weightx = 0;
		c.gridx = 0;
		c.gridy = 1;
		contentCheckBox = new JCheckBox("Prompt Text");
		contentCheckBox.setSelected(false);
		textFieldContent = new JTextField();
		textFieldContent.setVisible(false);
		textFieldContent.setPreferredSize(new Dimension(200, 30));
		contentCheckBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (contentCheckBox.isSelected()) {
					textFieldContent.setVisible(true);

				} else if (!contentCheckBox.isSelected()) {
					textFieldContent.setVisible(false);
					textFieldContent.setText("");
				}

			}
		});
		add(contentCheckBox, c);
		c.gridx = 1;
		c.weightx = 1;
		add(textFieldContent, c);
		btnAdd = new JButton("Add");
		btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ListViewFrame.getInstance().showPane(preview, ListViewFrame.TEXFIELD);

			}
		});
		btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				addTextField();

			}
		});
		c.weightx = 0;
		c.gridx = 0;
		c.gridy = 2;
		add(btnAdd, c);
		c.gridx = 1;
		add(btnRemove, c);
		btnPreview = new JButton("Preview");
		btnPreview.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CustomPreviewFrame.getInstance().showPreview(p);

			}
		});
		c.gridx = 2;
		add(btnPreview, c);
		setVisible(true);
	}

	public void addTextField() {
		if (textFieldName.getText() != null && textFieldName.getText() != "") {
			JTextField temp = new JTextField();
			if (textFieldContent.getText() != null && textFieldContent.getText() != "")
				temp.setText(textFieldContent.getText());
			preview.addTextField(textFieldName.getText(), temp);

		}
		textFieldContent.setText("");
		textFieldName.setText("");
	}

}

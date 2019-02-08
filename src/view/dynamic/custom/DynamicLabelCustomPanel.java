package view.dynamic.custom;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import view.list.ListViewFrame;
import view.tree.Parameter;

public class DynamicLabelCustomPanel extends JPanel {

	private CustomPreviewPanel preview;
	private JTextField labelName;
	private GridBagConstraints c;
	private JButton btnAdd, btnRemove, btnPreview;

	public DynamicLabelCustomPanel(Parameter p) {
		initPane(p);
	}

	private void initPane(Parameter p) {
		setName("Label");
		if (p.getCustomPanel() == null)
			p.setCustomPanel(new CustomPreviewPanel());
		preview = p.getCustomPanel();
		setLayout(new GridBagLayout());
		c = new GridBagConstraints();
		labelName = new JTextField();
		labelName.setPreferredSize(new Dimension(220, 25));
		c.anchor = GridBagConstraints.PAGE_START;
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;
		add(new JLabel("Naziv label-a"), c);
		c.gridy = 1;
		c.weightx = 1;
		add(labelName, c);
		c.weightx = 0;
		btnAdd = new JButton("Add");
		btnRemove = new JButton("Remove");
		btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				addLabel();
				labelName.setText("");
			}
		});
		btnPreview = new JButton("Preview");
		btnPreview.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CustomPreviewFrame.getInstance().showPreview(p);

			}
		});
		btnRemove.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ListViewFrame.getInstance().showPane(preview, ListViewFrame.LABEL);
			}
		});
		c.gridy = 2;
		add(btnAdd, c);
		c.gridx = 1;
		add(btnRemove, c);
		c.gridx = 2;
		add(btnPreview, c);
		setVisible(true);
	}

	private void addLabel() {
		if (labelName.getText() != null && labelName.getText() != "") {
			preview.addLabel(labelName.getText());
		}
	}

}
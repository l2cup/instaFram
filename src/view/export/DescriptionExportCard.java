package view.export;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import view.tree.Parameter;

public class DescriptionExportCard extends JPanel {

	private JScrollPane scrollPane;
	private JTextArea textArea;
	private GridBagConstraints c;
	
	public DescriptionExportCard(Parameter p) {
		setName("Description");
		c = new GridBagConstraints();
		setLayout(new GridBagLayout());
		c.insets = new Insets(5, 5, 5, 5);
		c.fill = GridBagConstraints.BOTH;
		c.anchor = GridBagConstraints.PAGE_START;
		c.weightx = 1;
		c.gridx = 0;
		c.gridy = 0;
		add(new Label("Description"),c);
		c.weighty = 1;
		c.gridy = 1;
		textArea = new JTextArea(p.getNodeModel().getValue());
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		scrollPane = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		add(scrollPane, c);
		setVisible(true);
	}
}

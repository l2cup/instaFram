package view.export;

import java.awt.FlowLayout;
import java.awt.Label;

import javax.swing.JLabel;
import javax.swing.JPanel;

import view.tree.Parameter;

public class AuthorExportCard extends JPanel {

	private JLabel authorLabel;

	public AuthorExportCard(Parameter p) {
		setName("Author");
		setLayout(new FlowLayout(FlowLayout.CENTER, 30, 30));
		authorLabel = new JLabel("Author: " + p.getNodeModel().getValue());
		add(authorLabel);
		setVisible(true);
	}
}

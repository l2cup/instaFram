package view.export;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import view.tree.Parameter;

public class VersionExportCard extends JPanel {

private JLabel versionLabel;
	
	public VersionExportCard(Parameter p) {
		setName("Version");
		setLayout(new FlowLayout(FlowLayout.CENTER,30,30));
		versionLabel = new JLabel("Version: " + p.getNodeModel().getValue());
		add(versionLabel);
		setVisible(true);
	}
}

package view.export;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.xml.crypto.dsig.keyinfo.PGPData;

import view.tree.Module;
import view.tree.Parameter;

public class WelcomeExportCard extends JPanel {

	private JLabel welcomeLabel, pathLabel;
	private JCheckBox cbShortcut,cbStart;
	private JButton jfcButton;
	private JFileChooser jfc;

	public WelcomeExportCard(Module m) {
		setName("Welcome");
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		jfc = new JFileChooser();
		jfcButton = new JButton("Choose path");
		jfcButton.setAlignmentX(CENTER_ALIGNMENT);
		jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		jfcButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					m.getNodeModel().setDestinationPath(jfc.getSelectedFile().getAbsolutePath());
					pathLabel.setText(jfc.getSelectedFile().getAbsolutePath());
					pathLabel.setSize(pathLabel.getPreferredSize());
				}
			}
		});
		welcomeLabel = new JLabel("Welcome to instalation of " + m.getName());
		welcomeLabel.setAlignmentX(CENTER_ALIGNMENT);
		pathLabel = new JLabel();
		pathLabel.setAlignmentX(CENTER_ALIGNMENT);
		cbShortcut = new JCheckBox("Desktop Shortcut");
		cbShortcut.addActionListener(e -> m.getNodeModel().setDesktopShortcut(cbShortcut.isSelected()));
		cbShortcut.setAlignmentX(CENTER_ALIGNMENT);
		cbStart = new JCheckBox("Start after installation");
		cbStart.addActionListener(e -> m.getNodeModel().setStartAfterInstalation(cbStart.isSelected()));
		cbStart.setAlignmentX(CENTER_ALIGNMENT);
		add(welcomeLabel);
		add(jfcButton);
		add(pathLabel);
		add(cbShortcut);
		add(cbStart);
		setVisible(true);

	}

}

package view.nondynamic;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.tree.ModuleModel;
import view.tree.Module;

public class ModulePanel extends JPanel {

	private JFileChooser jFileChooser;
	private JLabel pathLabel;
	private JButton btnPathChooser;
	private File file = null;

	public ModulePanel(Module module) {
		setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
		jFileChooser = new JFileChooser();
		pathLabel = new JLabel();
		pathLabel.setMinimumSize(new Dimension(250, 25));
		btnPathChooser = new JButton("Choose File");
		if (module.getNodeModel().getFile() != null) {
			pathLabel.setText(module.getNodeModel().getPath());
			pathLabel.setSize(pathLabel.getPreferredSize());
		}

		btnPathChooser.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				chooseFile(module.getNodeModel());
			}
		});
		add(pathLabel);
		add(btnPathChooser);
		setVisible(true);
	}

	private void chooseFile(ModuleModel m) {
		if (jFileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			m.setFile(jFileChooser.getSelectedFile());
			m.setPath(jFileChooser.getSelectedFile().getAbsolutePath());
			pathLabel.setText(m.getPath());
			pathLabel.setSize(pathLabel.getPreferredSize());
		}
	}
}

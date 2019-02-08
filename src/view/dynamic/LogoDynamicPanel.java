package view.dynamic;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import view.tree.Parameter;

public class LogoDynamicPanel extends JPanel {

	private JLabel logo;
	private JButton btnFileChooser;
	private JFileChooser jfc;
	private File file;
	BufferedImage image = null;

	public LogoDynamicPanel(Parameter p) {
		logo = new JLabel();
		logo.setPreferredSize(new Dimension(200, 200));
		btnFileChooser = new JButton("Choose Logo");
		jfc = new JFileChooser();
		setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		if (p.getNodeModel().getFile() != null) {
			file = p.getNodeModel().getFile();
			setImage();
		}
		jfc.setFileFilter(new FileNameExtensionFilter("JPG & PNG Images", "jpg", "png"));
		btnFileChooser.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					file = jfc.getSelectedFile();
					if (setImage())
						p.getNodeModel().setFile(file);
				}

			}
		});

		add(btnFileChooser);
		add(logo);
		setVisible(true);

	}

	private boolean setImage() {
		try {
			image = ImageIO.read(file);
			if (image != null) {
				logo.setIcon(new ImageIcon(image));
				return true;
			} else {
				logo.setText("Image Not Found");
				logo.setIcon(null);
				return false;
			}
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}

	}
}

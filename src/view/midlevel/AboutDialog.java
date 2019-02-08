package view.midlevel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class AboutDialog extends JOptionPane {

	private JLabel lbName, lbIndeks, lbGit, lbImage;
	private GridBagConstraints c;

	public AboutDialog() {
		setLayout(new GridBagLayout());
		c = new GridBagConstraints();
		init();
		c.insets = new Insets(5, 5, 5, 5);
		c.gridx = 0;
		c.gridy = 0;
		c.anchor = GridBagConstraints.PAGE_START;
		c.weightx = 1;
		add(lbName, c);
		c.gridy = 1;
		add(lbIndeks, c);
		c.gridy = 2;
		add(lbGit, c);
		c.gridy = 1;
		c.gridx = 1;
		add(lbImage, c);

	}

	private void init() {
		lbName = new JLabel("Uros Nikolic");
		lbIndeks = new JLabel("RN-21/2017");
		lbGit = new JLabel("Github: l2cup");
		lbImage = new JLabel("Insert image here");
	}

}

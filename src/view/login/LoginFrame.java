package view.login;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Dialog.ModalExclusionType;

import javax.swing.JFrame;

import main.Core;

public class LoginFrame extends JFrame{
	
	private LoginPanel loginPanel;
	private GridBagConstraints c;
	public LoginFrame() {
		setSize(new Dimension(350, 150));
		loginPanel = new LoginPanel();
		c = new GridBagConstraints();
		setLayout(new GridBagLayout());
		c.fill = GridBagConstraints.BOTH;
		c.anchor = GridBagConstraints.PAGE_START;
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 1;
		c.weighty = 1;
		add(loginPanel,c);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);	
	}

}

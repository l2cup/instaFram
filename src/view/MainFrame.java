package view;

import javax.swing.JFrame;

import view.login.LoginFrame;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4497573837584910723L;

	private MainMenu menu;
	private MainPanel mainPanel;
	private LoginFrame loginFrame;

	public MainFrame(MainMenu menu, MainPanel mainPanel,LoginFrame loginFrame) {
		this.mainPanel = mainPanel;
		this.menu = menu;
		this.loginFrame = loginFrame;	
		add(mainPanel);
		setDefaults();

	}

	private void setDefaults() {
		setVisible(false);
		setSize(800, 650);
		setJMenuBar(menu);
		setLocationRelativeTo(null);
	}
	
	public LoginFrame getLoginFrame() {
		return loginFrame;
	}

}

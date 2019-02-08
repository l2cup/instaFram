package view.midlevel;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JToolBar;

import main.Core;

public class TabToolBar extends JToolBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5066891965092042151L;

	private JButton btnClose;
	private FlowLayout buttonLayout;

	public TabToolBar() {
		super(HORIZONTAL);
		setFloatable(false);
		initButtons();
		addButtons();
	}

	private void initButtons() {
		buttonLayout = new FlowLayout(LEADING, 5, 0);
		setLayout(buttonLayout);
		btnClose = new JButton(Core.getInstance().getActionManager().getCloseTabAction());

	}

	private void addButtons() {
		add(btnClose);

	}

	public TabToolBar getInstance() {
		return this;
	}

}

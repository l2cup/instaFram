package view;

import java.awt.FlowLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JToolBar;
import javax.swing.border.BevelBorder;

import model.login.User;
import view.midlevel.DateAndTimeLabel;

public class StatusBar extends JToolBar implements Observer {

	private DateAndTimeLabel dateAndTimeLabel;
	private JLabel userLabel, actionLabel, statusLabel;
	private BevelBorder buttonBorder;

	public StatusBar() {
		dateAndTimeLabel = new DateAndTimeLabel();
		buttonBorder = new BevelBorder(BevelBorder.LOWERED);
		dateAndTimeLabel.setBorder(buttonBorder);
		setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
		userLabel = new JLabel("Korisnik <Ko je prijavljen za rad>");
		userLabel.setBorder(buttonBorder);
//		actionLabel = new JLabel("Akcija: <Naziv komandne akcije>");
//		actionLabel.setBorder(buttonBorder);
		statusLabel = new JLabel("Status: <Ready>");
		statusLabel.setBorder(buttonBorder);
		add(dateAndTimeLabel);
		add(userLabel);
//		add(actionLabel);
		add(statusLabel);
		setDefaults();

	}

	private void setDefaults() {
		setFloatable(false);
	}

	public DateAndTimeLabel getDateAndTimeLabel() {
		return dateAndTimeLabel;
	}

	public void setDateAndTimeLabel(DateAndTimeLabel dateAndTimeLabel) {
		this.dateAndTimeLabel = dateAndTimeLabel;
	}

	public JLabel getUserLabel() {
		return userLabel;
	}

	public void setUserLabel(JLabel userLabel) {
		this.userLabel = userLabel;
	}

	public JLabel getActionLabel() {
		return actionLabel;
	}

	public void setActionLabel(JLabel actionLabel) {
		this.actionLabel = actionLabel;
	}

	public JLabel getStatusLabel() {
		return statusLabel;
	}

	public void setStatusLabel(JLabel statusLabel) {
		this.statusLabel = statusLabel;
	}
	
	public void setUserLabelText(String username) {
		userLabel.setText("Korisnik <" + username + ">");
//		revalidate();
//		repaint();
	}
	
	public void setStatusLabelText(String text) {
		statusLabel.setText("Status <" + text + ">");
	}

	@Override
	public void update(Observable o, Object arg) {
		setUserLabelText(((User)arg).getUsername());
		setStatusLabelText(((User)arg).isAdmin() ? "Admin" : "User");
		
	}

}

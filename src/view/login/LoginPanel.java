package view.login;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.sun.media.jfxmedia.events.NewFrameEvent;

import exception_handler.ExceptionType;
import main.Core;

public class LoginPanel extends JPanel {
	
	private GridBagConstraints c;
	private JPanel buttonPanel,usernamePanel,passwordPanel;
	private JTextField loginField;
	private JPasswordField passwordField;
	private JButton btnLogin,btnRegister;
	private JLabel lbUsername,lbPassword;
	
	public LoginPanel() {
		initPane();
		initActions();
	}
	
	private void initPane() {
		c = new GridBagConstraints();
		setLayout(new GridBagLayout());
		buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
		loginField = new JTextField();
		loginField.setPreferredSize(new Dimension(220, 25));
		passwordField = new JPasswordField();
		passwordField.setPreferredSize(new Dimension(220, 25));	
		btnLogin = new JButton("Login");
		btnRegister = new JButton("Register");
		buttonPanel.add(btnLogin);
		buttonPanel.add(btnRegister);
		c.anchor = GridBagConstraints.CENTER;
		c.fill = GridBagConstraints.BOTH;
		usernamePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 15));
		usernamePanel.add(new JLabel("Username:"));
		usernamePanel.add(loginField);
		passwordPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,15,15));
		passwordPanel.add(new JLabel("Password:"));
		passwordPanel.add(passwordField);
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 1;
		c.weighty = 1;
		add(usernamePanel,c);
		c.gridy = 1;
		add(passwordPanel, c);
		c.gridy = 2;
		add(buttonPanel, c);
		setVisible(true);
		
	}
	
	private void initActions() {
		btnLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(loginField.getText()!="" && loginField.getText()!=null &&
						passwordField.getPassword()!=null && passwordField.getPassword().length>1) {
					if(Core.getInstance().getLoginSystem().login(loginField.getText(), new String(passwordField.getPassword()))) {
						passwordField.setText("");
						loginField.setText("");
						Core.getInstance().getMainFrame().getLoginFrame().dispose();
						Core.getInstance().getMainFrame().setVisible(true);
					}
					else {
						Core.getInstance().getExceptionHandlerDialog().showDialog(ExceptionType.BAD_AUTH, null);
						passwordField.setText("");
					}
				}
				
			}
		});
		
		btnRegister.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(loginField.getText()!="" && loginField.getText()!=null &&
						passwordField.getPassword()!=null && passwordField.getPassword().length>1) {
					if(Core.getInstance().getLoginSystem().register(loginField.getText(), new String(passwordField.getPassword()))) {
						Core.getInstance().getExceptionHandlerDialog().showDialog(ExceptionType.REG_SUCCESS,null);
					}
					else {
						Core.getInstance().getExceptionHandlerDialog().showDialog(ExceptionType.USER_EXISTS,null);
					}
					passwordField.setText("");
					loginField.setText("");
				}
				
			}
		});
	}
}

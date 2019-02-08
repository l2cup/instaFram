package exception_handler;

import javax.swing.JOptionPane;

import javafx.scene.layout.ConstraintsBase;

public class ExceptionHandlerDialog {
	
	public void showDialog(ExceptionType type,Object arg) {
		switch (type) {
		case BAD_AUTH:
			JOptionPane.showMessageDialog(null, "Bad username or password", "Login failed", JOptionPane.ERROR_MESSAGE);
			break;
		case REG_SUCCESS:
			JOptionPane.showMessageDialog(null, "Succesfully registered!", "Success", JOptionPane.INFORMATION_MESSAGE);
			break;
		case USER_EXISTS:
			JOptionPane.showMessageDialog(null, "Username taken", "Error", JOptionPane.ERROR_MESSAGE);
			break;
		case PATH_MISSING:
			JOptionPane.showMessageDialog(null,
				    "These modules do not have defined paths\n"+(String)arg,
				    "Path error",
				    JOptionPane.ERROR_MESSAGE);
			break;
		case NOT_ADMIN:
			JOptionPane.showMessageDialog(null, "You need to be an administrator for that","No access", JOptionPane.ERROR_MESSAGE);
			break;
		case CHECK_NODE:
			JOptionPane.showMessageDialog(null, "Please select a node first", "No node selected", JOptionPane.ERROR_MESSAGE);
			break;
		case NODE_PARAM:
			JOptionPane.showMessageDialog(null, "Selected node is a parameter, select a non parameter node.", "Parameter selected",JOptionPane.ERROR_MESSAGE);
		default:
			break;
		}
	}
}

package view.dynamic;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import main.Core;
import view.tree.Parameter;

public class AuthorDynamicPanel extends JPanel {

	private JTextField tf;

	public AuthorDynamicPanel(Parameter p,int arg) {
		setLayout(new FlowLayout(FlowLayout.CENTER, 15, 15));
		tf = new JTextField();
		tf.setPreferredSize(new Dimension(150, 30));
		tf.getDocument().addDocumentListener(Core.getInstance().getActionManager().getParameterDocumentListener());
		add(new JLabel("Author: "));
		if(arg == 1)
			tf.setText(p.getNodeModel().getValue());
		add(tf);
		setVisible(true);
	}
}

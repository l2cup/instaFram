package view.dynamic;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import main.Core;
import view.tree.Parameter;

public class VersionDynamicPanel extends JPanel {

	JTextField tf;

	public VersionDynamicPanel(Parameter p,int arg) {
		tf = new JTextField();
		tf.setPreferredSize(new Dimension(200, 30));

		setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
		tf.setEditable(true);
		tf.getDocument().addDocumentListener(Core.getInstance().getActionManager().getParameterDocumentListener());

		add(new JLabel("Verzija modula: "));
		if(arg == 1)
			tf.setText(p.getNodeModel().getValue());
		add(tf);

	}
}

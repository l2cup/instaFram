package view.dynamic;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import main.Core;
import view.tree.Parameter;

public class TocDynamicPanel extends JPanel {

	private JTextArea textArea;
	private GridBagConstraints c;

	public TocDynamicPanel(Parameter p,int arg) {
		c = new GridBagConstraints();
		textArea = new JTextArea();
		textArea.setEditable(true);
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		c.fill = GridBagConstraints.BOTH;
		c.anchor = GridBagConstraints.PAGE_START;
		setLayout(new GridBagLayout());
		textArea.getDocument()
				.addDocumentListener(Core.getInstance().getActionManager().getParameterDocumentListener());
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 1;
		c.weighty = 1;
		if(arg == 1)
			textArea.setText(p.getNodeModel().getValue());
		add(textArea, c);
		setVisible(true);
	}
}

package view.export;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import view.tree.Parameter;

public class TocExportCard extends JPanel {

	private JCheckBox cbAgree, cbDecline;
	private ButtonGroup checkBoxGroup;
	private boolean agree,lastPanel;
	private GridBagConstraints c;
	private JTextArea textArea;
	private JScrollPane scrollPane;
	private ExportPanel senderPanel;

	public TocExportCard(Parameter p, ExportPanel senderPanel) {
		setName("TOC");
		this.senderPanel = senderPanel;
		c = new GridBagConstraints();
		setLayout(new GridBagLayout());
		agree = false;
		lastPanel = false;
		cbAgree = new JCheckBox("I agree");
		cbDecline = new JCheckBox("I decline");
		checkBoxGroup = new ButtonGroup();
		checkBoxGroup.add(cbAgree);
		checkBoxGroup.add(cbDecline);
		cbAgree.addActionListener(a -> setAgree(true));
		cbDecline.addActionListener(a -> setAgree(false));
		textArea = new JTextArea(p.getNodeModel().getValue());
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		c.anchor = GridBagConstraints.PAGE_START;
		c.fill = GridBagConstraints.BOTH;
		c.gridy = 0;
		c.gridx = 0;
		c.weightx = 1;
		c.weighty = 1;
		add(scrollPane,c);
		c.weighty = 0;
		c.gridy = 1;
		add(cbAgree, c);
		c.gridy = 2;
		add(cbDecline,c);
		

	}

	public void setAgree(boolean agree) {
		this.agree = agree;
		if(agree) {
			if(lastPanel)
				senderPanel.getBtnFinish().setEnabled(true);
			else
				senderPanel.getBtnNext().setEnabled(true);
		}
		else {
			senderPanel.getBtnFinish().setEnabled(false);
			senderPanel.getBtnNext().setEnabled(false);
		}
	}
	
	public void setLastPanel(boolean lastPanel) {
		this.lastPanel = lastPanel;
	}
}

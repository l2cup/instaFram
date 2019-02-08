package view.dynamic;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JPanel;

import org.omg.CORBA.ARG_IN;

import view.tree.Module;
import view.tree.Parameter;

public class ShortcutDynamicPanel extends JPanel {
	private JCheckBox cb;

	public ShortcutDynamicPanel(Parameter p,int arg) {

		cb = new JCheckBox("Desktop precica za " + ((Module) p.getParent()).getName());
		cb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (cb.isSelected()) {
					p.getNodeModel().setValue("true");
				} else if (!cb.isSelected()) {
					p.getNodeModel().setValue("false");
				}

			}
		});
		if(arg == 1) {
			if(p.getNodeModel().getValue().equals("true"))
				cb.setSelected(true);
			else if(p.getNodeModel().getValue().equals("false"))
				cb.setSelected(false);
		}
		setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
		add(cb);
		setVisible(true);
	}
}

package view.dynamic;

import java.awt.CardLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import view.dynamic.custom.CustomPanelType;
import view.dynamic.custom.DynamicCheckBoxCustomPanel;
import view.dynamic.custom.DynamicLabelCustomPanel;
import view.dynamic.custom.DynamicTextfieldCustomPanel;
import view.tree.Parameter;

public class DynamicCustomPanel extends JPanel {

	private JComboBox<CustomPanelType> customType;
	private JPanel cardLayoutPanel, dynamicTextfieldCustomPanel, dynamicLabelCustomPanel, dynamicCheckBoxCustomPanel;
	private GridBagConstraints c;
	private CardLayout cardLayout;

	public DynamicCustomPanel(Parameter p) {
		c = new GridBagConstraints();
		setLayout(new GridBagLayout());
		c.gridx = 0;
		c.gridy = 0;
		c.anchor = GridBagConstraints.PAGE_START;
		customType = new JComboBox<>(CustomPanelType.values());
		customType.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardLayoutPanel, customType.getSelectedItem().toString());
			}
		});
		c.weightx = 1;
		add(new JLabel("Choose a custom parameter type"), c);
		c.gridy = 1;
		add(customType, c);
		c.gridy = 2;
		c.weighty = 2;
		c.fill = GridBagConstraints.BOTH;
		dynamicTextfieldCustomPanel = new DynamicTextfieldCustomPanel(p);
		dynamicLabelCustomPanel = new DynamicLabelCustomPanel(p);
		dynamicCheckBoxCustomPanel = new DynamicCheckBoxCustomPanel(p);
		cardLayout = new CardLayout(10, 10);
		cardLayoutPanel = new JPanel(cardLayout);
		cardLayoutPanel.add(dynamicTextfieldCustomPanel, "TextField");
		cardLayoutPanel.add(dynamicLabelCustomPanel, "Label");
		cardLayoutPanel.add(dynamicCheckBoxCustomPanel, "CheckBox");
		add(cardLayoutPanel, c);

		setVisible(true);

	}
}

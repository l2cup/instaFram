package view.dynamic;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JComboBox;
import javax.swing.JPanel;

import org.omg.CORBA.ARG_IN;

import main.Core;
import model.tree.ParameterModel;
import model.tree.ParameterType;
import view.tree.Parameter;

public class DynamicParameterTab extends JPanel implements Observer {

	private GridBagConstraints c;
	private JComboBox<ParameterType> cmbType;
	private JPanel dynamicPanel;
	private Parameter parameter;
	private final int HAS_TYPE = 1;

	public DynamicParameterTab(Parameter p) {
		parameter = p;
		c = new GridBagConstraints();
		setLayout(new GridBagLayout());
		dynamicPanel = new JPanel();
		dynamicPanel.setVisible(true);
		cmbType = new JComboBox<>(ParameterType.values());
		cmbType.addItemListener(Core.getInstance().getActionManager().getTypeChangeListener());
		if (p.getNodeModel().getType() != null) {
			cmbType.setSelectedItem(p.getNodeModel().getType());
			updatePanel(p.getNodeModel().getType(),HAS_TYPE);
		}
		p.getNodeModel().addObserver(this);
		c.fill = GridBagConstraints.BOTH;
		c.anchor = GridBagConstraints.PAGE_START;
		c.gridy = 0;
		c.gridx = 0;
		c.weightx = 1;
		add(cmbType, c);
		c.weighty = 1;
		c.gridy = 1;
		add(dynamicPanel, c);

	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof ParameterModel) {
			updatePanel((ParameterType) arg,0);
		}

	}

	private void updatePanel(ParameterType type,int arg) {
		switch (type) {
		case Author:
			System.out.println("jebem li ga");
			remove(dynamicPanel);
			dynamicPanel = new AuthorDynamicPanel(parameter,arg);
			add(dynamicPanel, c);
			break;
		case TOC:
			remove(dynamicPanel);
			dynamicPanel = new TocDynamicPanel(parameter,arg);
			add(dynamicPanel, c);
			break;
		case Description:
			remove(dynamicPanel);
			dynamicPanel = new TocDynamicPanel(parameter,arg);
			add(dynamicPanel, c);
			break;
		case Version:
			remove(dynamicPanel);
			dynamicPanel = new VersionDynamicPanel(parameter,arg);
			add(dynamicPanel, c);
			break;
		case Desktop_Shortcut:
			remove(dynamicPanel);
			dynamicPanel = new ShortcutDynamicPanel(parameter,arg);
			add(dynamicPanel, c);
			break;
		case Logo:
			remove(dynamicPanel);
			dynamicPanel = new LogoDynamicPanel(parameter);
			add(dynamicPanel, c);
			break;
		case Custom:
			remove(dynamicPanel);
			dynamicPanel = new DynamicCustomPanel(parameter);
			add(dynamicPanel, c);
		default:
			break;
		}
	}

}

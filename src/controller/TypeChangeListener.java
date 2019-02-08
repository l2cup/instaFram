package controller;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;

import main.Core;
import model.tree.ParameterModel;
import model.tree.ParameterType;

public class TypeChangeListener implements ItemListener {

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED && e.getSource() instanceof JComboBox<?>) {
			JComboBox<ParameterType> jcb = (JComboBox<ParameterType>) e.getSource();
			ParameterModel model = (ParameterModel) Core.getInstance().getSelectedNode().getNodeModel();
			model.setType((ParameterType) jcb.getSelectedItem());

		}

	}

}

package view.dynamic.custom;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.Serializable;
import java.util.HashMap;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class CustomPreviewPanel extends JPanel implements Serializable {

	private HashMap<String, JTextField> textFieldMap;
	private HashMap<String, JLabel> labelMap;
	private HashMap<String, JCheckBox> checkBoxMap;
	private JScrollPane scrollPane;
	private int itemCount = 0;
	private final int MAX_COUNT = 20;

	public CustomPreviewPanel() {
		setName("Custom");
		// scrollPane = new JScrollPane(this, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
		// JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		setLayout(new GridLayout(10, 1, 15, 15));
		textFieldMap = new HashMap<>();
		labelMap = new HashMap<>();
		checkBoxMap = new HashMap<>();
		setVisible(true);
	}

	public void addTextField(String key, JTextField textField) {
		if (itemCount == MAX_COUNT)
			return;
		textField.setPreferredSize(new Dimension(220, 25));
		JLabel temp = new JLabel(key);
		temp.setPreferredSize(new Dimension(220, 25));
		labelMap.put(key, temp);
		if (!textFieldMap.containsKey(key)) {
			add(labelMap.get(key));
			add(textField);
			textFieldMap.put(key, textField);
			revalidate();
			repaint();
			itemCount += 2;
		}
	}

	public void removeTextField(String key) {
		removeLabel(key);
		if (textFieldMap.get(key) == null)
			return;
		remove(textFieldMap.get(key));
		textFieldMap.remove(key);
		revalidate();
		repaint();
		itemCount--;
	}

	public void addLabel(String key) {
		if (itemCount == MAX_COUNT)
			return;
		if (!labelMap.containsKey(key)) {
			JLabel temp = new JLabel(key);
			temp.setPreferredSize(new Dimension(220, 25));
			labelMap.put(key, temp);
			add(labelMap.get(key));
			revalidate();
			repaint();
			itemCount++;
		}

	}

	public void removeLabel(String key) {
		remove(labelMap.get(key));
		labelMap.remove(key);
		itemCount--;
		revalidate();
		repaint();
	}

	public void addCheckBox(String key) {
		if (!checkBoxMap.containsKey(key)) {
			checkBoxMap.put(key, new JCheckBox(key));
			add(checkBoxMap.get(key));
			itemCount++;
			revalidate();
			repaint();
		}

	}

	public void removeCheckBox(String key) {
		remove(checkBoxMap.get(key));
		checkBoxMap.remove(key);
		itemCount--;
		revalidate();
		repaint();
	}

	public HashMap<String, JTextField> getTextFieldMap() {
		return textFieldMap;
	}

	public void setTextFieldMap(HashMap<String, JTextField> textFieldMap) {
		this.textFieldMap = textFieldMap;
	}

	public HashMap<String, JLabel> getLabelMap() {
		return labelMap;
	}

	public void setLabelMap(HashMap<String, JLabel> labelMap) {
		this.labelMap = labelMap;
	}

	public HashMap<String, JCheckBox> getCheckBoxMap() {
		return checkBoxMap;
	}

	public void setCheckBoxMap(HashMap<String, JCheckBox> checkBoxMap) {
		this.checkBoxMap = checkBoxMap;
	}

}

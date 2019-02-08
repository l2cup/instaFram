package view.dynamic.custom;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import view.tree.Parameter;

public class CustomPreviewFrame extends JFrame {

	private static CustomPreviewFrame instance = null;
	private JPanel previewPanel, mainPanel;

	private CustomPreviewFrame() {
		setVisible(true);
		setSize(600, 600);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		previewPanel = null;
		mainPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 35, 15));
		add(mainPanel);

	}

	public static CustomPreviewFrame getInstance() {
		if (instance == null)
			instance = new CustomPreviewFrame();
		return instance;
	}

	public void showPreview(Parameter p) {
		previewPanel = p.getCustomPanel();
		if (previewPanel != null)
			mainPanel.remove(previewPanel);
		mainPanel.add(previewPanel);
		setTitle(p.getName());
		revalidate();
		repaint();
		setVisible(true);
	}

}

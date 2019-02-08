package view.list;

import javax.swing.JFrame;

import view.dynamic.custom.CustomPreviewPanel;

public class ListViewFrame extends JFrame {

	public static ListViewFrame instance = null;
	public static final int TEXFIELD = 1;
	public static final int CHECKBOX = 2;
	public static final int LABEL = 3;
	
	private ListViewPanel panel = null;

	private ListViewFrame() {
		setTitle("Close");
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setVisible(true);
		setSize(300, 300);

	}

	public static ListViewFrame getInstance() {
		if (instance == null)
			instance = new ListViewFrame();
		return instance;
	}

	public void showPane(CustomPreviewPanel panel, int arg) {
		if (this.panel != null)
			remove(this.panel);
		this.panel = new ListViewPanel(panel, arg);
		add(this.panel);
		setVisible(true);
		revalidate();
		repaint();

	}

}

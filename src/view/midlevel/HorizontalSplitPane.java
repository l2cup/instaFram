package view.midlevel;

import javax.swing.JSplitPane;

public class HorizontalSplitPane extends JSplitPane {

	private TreePanel treePanel;
	private RightHorizontalPane rightHorizontalPane;

	public HorizontalSplitPane(TreePanel tp, RightHorizontalPane rhp) {
		super(HORIZONTAL_SPLIT);
		treePanel = tp;
		rightHorizontalPane = rhp;
		add(treePanel);
		add(rightHorizontalPane);
		setDividerLocation(350);
		setTopComponent(treePanel);
		setBottomComponent(rightHorizontalPane);
	}

	public RightHorizontalPane getRightHorizontalPane() {
		return rightHorizontalPane;
	}

	public TreePanel getTreePanel() {
		return treePanel;
	}

}

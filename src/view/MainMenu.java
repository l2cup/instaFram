package view;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

import main.Core;

public class MainMenu extends JMenuBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1954102036406925562L;

	private JMenu mFile, mEdit, mTools;
	private JButton mAbout;

	public MainMenu() {
		initMenus();
		addMenus();
		addMenuItems();
	}

	private void initMenus() {
		mFile = new JMenu("File");
		mEdit = new JMenu("Edit");
		mTools = new JMenu("Tools");
		mAbout = new JButton(Core.getInstance().getActionManager().getAboutAction());

	}

	private void addMenus() {
		add(mFile);
		add(mEdit);
		add(mTools);
		add(Box.createHorizontalGlue());
		add(mAbout);
	}

	private void addMenuItems() {
		mFile.add(Core.getInstance().getActionManager().getNewNodeAction());
		mFile.add(Core.getInstance().getActionManager().getDeleteNodeAction());
		mFile.addSeparator();
		mFile.add(Core.getInstance().getActionManager().getWriteToFileAction());
		mFile.add(Core.getInstance().getActionManager().getReadFromFileAction());
		mFile.addSeparator();
		mFile.add(Core.getInstance().getActionManager().getExportAction());
		
		mEdit.add(Core.getInstance().getActionManager().getUndoAction());
		mEdit.add(Core.getInstance().getActionManager().getRedoAction());
		mEdit.addSeparator();
		mEdit.add(Core.getInstance().getActionManager().getCutAction());
		mEdit.add(Core.getInstance().getActionManager().getCopyAction());
		mEdit.add(Core.getInstance().getActionManager().getPasteAction());

	}

}

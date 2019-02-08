package view;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JToolBar;

import main.Core;

public class MainToolBar extends JToolBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5872869692855058496L;

	private JButton btnSave, btnOpen, btnNew, btnDelete, btnExport, btnUndo, btnRedo, btnCopy, btnPaste, btnCut;
	private FlowLayout buttonLayout;

	public MainToolBar() {
		super(HORIZONTAL);
		setFloatable(false);
		initButtons();
		addButtons();
	}

	private void initButtons() {
		buttonLayout = new FlowLayout(LEADING, 5, 0);
		setLayout(buttonLayout);
		btnSave = new JButton(Core.getInstance().getActionManager().getWriteToFileAction());
		btnOpen = new JButton(Core.getInstance().getActionManager().getReadFromFileAction());
		btnNew = new JButton(Core.getInstance().getActionManager().getNewNodeAction());
		btnDelete = new JButton(Core.getInstance().getActionManager().getDeleteNodeAction());
		btnExport = new JButton(Core.getInstance().getActionManager().getExportAction());
		btnUndo = new JButton(Core.getInstance().getActionManager().getUndoAction());
		btnRedo = new JButton(Core.getInstance().getActionManager().getRedoAction());
		btnCopy = new JButton(Core.getInstance().getActionManager().getCopyAction());
		btnPaste = new JButton(Core.getInstance().getActionManager().getPasteAction());
		btnCut = new JButton(Core.getInstance().getActionManager().getCutAction());
	}

	private void addButtons() {
		add(btnSave);
		add(btnOpen);
		add(btnNew);
		add(btnDelete);
		addSeparator();
		add(btnExport);
		add(btnUndo);
		add(btnRedo);
		add(btnCopy);
		add(btnPaste);
		add(btnCut);
	}

	public MainToolBar getInstance() {
		return this;
	}

}

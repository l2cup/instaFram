package controller.actions;

import controller.MousePressNodeListener;
import controller.TabbedPaneChangeListener;
import controller.TypeChangeListener;

public class ActionManager {

	private NewNodeAction newNodeAction;
	private DeleteNodeAction deleteNodeAction;
	private WriteToFileAction writeToFileAction;
	private ReadFromFileAction readFromFileAction;
	private TabbedPaneChangeListener tabbedPaneChangeListener;
	private MousePressNodeListener mousePressNodeListener;
	private CloseTabAction closeTabAction;
	private TypeChangeListener typeChangeListener;
	private AboutAction aboutAction;
	private ParameterDocumentListener parameterDocumentListener;
	private ExportAction exportAction;
	private UndoAction undoAction;
	private RedoAction redoAction;
	private CopyAction copyAction;
	private PasteAction pasteAction;
	private CutAction cutAction;

	public ActionManager() {
		newNodeAction = new NewNodeAction();
		deleteNodeAction = new DeleteNodeAction();
		writeToFileAction = new WriteToFileAction();
		readFromFileAction = new ReadFromFileAction();
		tabbedPaneChangeListener = new TabbedPaneChangeListener();
		mousePressNodeListener = new MousePressNodeListener();
		closeTabAction = new CloseTabAction();
		typeChangeListener = new TypeChangeListener();
		aboutAction = new AboutAction();
		parameterDocumentListener = new ParameterDocumentListener();
		exportAction = new ExportAction();
		undoAction = new UndoAction();
		redoAction = new RedoAction();
		copyAction = new CopyAction();
		pasteAction = new PasteAction();
		cutAction = new CutAction();
	}

	public NewNodeAction getNewNodeAction() {
		return newNodeAction;
	}

	public DeleteNodeAction getDeleteNodeAction() {
		return deleteNodeAction;
	}

	public WriteToFileAction getWriteToFileAction() {
		return writeToFileAction;
	}

	public ReadFromFileAction getReadFromFileAction() {
		return readFromFileAction;
	}

	public TabbedPaneChangeListener getTabbedPaneChangeListener() {
		return tabbedPaneChangeListener;
	}

	public MousePressNodeListener getMousePressNodeListener() {
		return mousePressNodeListener;
	}

	public CloseTabAction getCloseTabAction() {
		return closeTabAction;
	}

	public AboutAction getAboutAction() {
		return aboutAction;
	}

	public TypeChangeListener getTypeChangeListener() {
		return typeChangeListener;
	}

	public ParameterDocumentListener getParameterDocumentListener() {
		return parameterDocumentListener;
	}

	public ExportAction getExportAction() {
		return exportAction;
	}

	public UndoAction getUndoAction() {
		return undoAction;
	}

	public RedoAction getRedoAction() {
		return redoAction;
	}

	public CopyAction getCopyAction() {
		return copyAction;
	}

	public PasteAction getPasteAction() {
		return pasteAction;
	}

	public CutAction getCutAction() {
		return cutAction;
	}

}

package main;

import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.Transferable;

import org.omg.CORBA.PRIVATE_MEMBER;

import controller.actions.ActionManager;
import exception_handler.ExceptionHandlerDialog;
import login.LoginSystem;
import tools.ObjectReader;
import tools.ObjectWriter;
import tools.PathChecker;
import view.MainFrame;
import view.MainMenu;
import view.MainPanel;
import view.MainSubPanel;
import view.MainToolBar;
import view.StatusBar;
import view.dialog.ModulesDialog;
import view.login.LoginFrame;
import view.midlevel.BottomVerticalPane;
import view.midlevel.CustomTabbedPane;
import view.midlevel.HorizontalSplitPane;
import view.midlevel.RightHorizontalPane;
import view.midlevel.TabToolBar;
import view.midlevel.TreePanel;
import view.tree.CustomTree;
import view.tree.CustomTreeNode;

public class Core implements ClipboardOwner {

	private static Core instance = null;
	private boolean init = false;
	
	private Clipboard clipboard;

	private MainFrame mainFrame;
	private MainMenu mainMenu;
	private MainPanel mainPanel;
	private StatusBar statusBar;
	private MainToolBar mainToolBar;
	private MainSubPanel mainSubPanel;
	private BottomVerticalPane bottomVerticalPane;
	private HorizontalSplitPane horizontalSplitPane;
	private RightHorizontalPane rightHorizontalPane;
	private CustomTabbedPane customTabbedPane;
	private TreePanel treePanel;
	private ActionManager actionManager;
	private TabToolBar tabToolBar;
	private PathChecker pathChecker;
	private ModulesDialog modulesDialog;
	private ObjectWriter objectWriter;
	private ObjectReader objectReader;
	private LoginSystem loginSystem;
	private LoginFrame loginFrame;
	private ExceptionHandlerDialog exceptionHandlerDialog;

	private CustomTree tree;
	private CustomTreeNode selectedNode;

	private Core() {
		actionManager = new ActionManager();
	}

	public void init() {
		if (!init) {
			selectedNode = null;
			mainToolBar = new MainToolBar();
			customTabbedPane = new CustomTabbedPane();
			bottomVerticalPane = new BottomVerticalPane();
			statusBar = new StatusBar();
			tabToolBar = new TabToolBar();
			rightHorizontalPane = new RightHorizontalPane(customTabbedPane, tabToolBar);
			tree = new CustomTree();
			treePanel = new TreePanel(tree);
			horizontalSplitPane = new HorizontalSplitPane(treePanel, rightHorizontalPane);
			mainSubPanel = new MainSubPanel(mainToolBar, horizontalSplitPane);
			mainPanel = new MainPanel(mainSubPanel, statusBar);
			pathChecker = new PathChecker();
			modulesDialog = new ModulesDialog();
			objectWriter = new ObjectWriter();
			objectReader = new ObjectReader();
			loginSystem = new LoginSystem(statusBar);
			exceptionHandlerDialog = new ExceptionHandlerDialog();
			clipboard = new Clipboard("Clipboard");
		}
		init = true;
	}

	public static Core getInstance() {
		if (instance == null) {
			instance = new Core();
		}
		return instance;
	}

	public void initMainFrame() {
		mainMenu = new MainMenu();
		loginFrame = new LoginFrame();
		mainFrame = new MainFrame(mainMenu, mainPanel,loginFrame);
	}

	public ActionManager getActionManager() {
		return actionManager;
	}

	public MainFrame getMainFrame() {
		return mainFrame;
	}

	public MainMenu getMainMenu() {
		return mainMenu;
	}

	public MainPanel getMainPanel() {
		return mainPanel;
	}

	public StatusBar getStatusBar() {
		return statusBar;
	}

	public MainToolBar getMainToolBar() {
		return mainToolBar;
	}

	public MainSubPanel getMainSubPanel() {
		return mainSubPanel;
	}

	public BottomVerticalPane getBottomVerticalPane() {
		return bottomVerticalPane;
	}

	public HorizontalSplitPane getHorizontalSplitPane() {
		return horizontalSplitPane;
	}

	public RightHorizontalPane getRightHorizontalPane() {
		return rightHorizontalPane;
	}

	public CustomTabbedPane getCustomTabbedPane() {
		return customTabbedPane;
	}

	public TreePanel getTreePanel() {
		return treePanel;
	}

	public CustomTree getTree() {
		return tree;
	}

	public CustomTreeNode getSelectedNode() {
		return selectedNode;
	}

	public void setInstance(Core instance) {
		this.instance = instance;
	}

	public void setMainFrame(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	public void setMainMenu(MainMenu mainMenu) {
		this.mainMenu = mainMenu;
	}

	public void setMainPanel(MainPanel mainPanel) {
		this.mainPanel = mainPanel;
	}

	public void setStatusBar(StatusBar statusBar) {
		this.statusBar = statusBar;
	}

	public void setMainToolBar(MainToolBar mainToolBar) {
		this.mainToolBar = mainToolBar;
	}

	public void setMainSubPanel(MainSubPanel mainSubPanel) {
		this.mainSubPanel = mainSubPanel;
	}

	public void setBottomVerticalPane(BottomVerticalPane bottomVerticalPane) {
		this.bottomVerticalPane = bottomVerticalPane;
	}

	public void setHorizontalSplitPane(HorizontalSplitPane horizontalSplitPane) {
		this.horizontalSplitPane = horizontalSplitPane;
	}

	public void setRightHorizontalPane(RightHorizontalPane rightHorizontalPane) {
		this.rightHorizontalPane = rightHorizontalPane;
	}

	public void setCustomTabbedPane(CustomTabbedPane customTabbedPane) {
		this.customTabbedPane = customTabbedPane;
	}

	public void setTreePanel(TreePanel treePanel) {
		this.treePanel = treePanel;
	}

	public void setTree(CustomTree tree) {
		this.tree = tree;
	}

	public void setActionManager(ActionManager actionManager) {
		this.actionManager = actionManager;
	}

	public void setSelectedNode(CustomTreeNode selectedNode) {
		this.selectedNode = selectedNode;
	}

	public ModulesDialog getModulesDialog() {
		return modulesDialog;
	}

	public PathChecker getPathChecker() {
		return pathChecker;
	}

	public ObjectWriter getObjectWriter() {
		return objectWriter;
	}

	public ObjectReader getObjectReader() {
		return objectReader;
	}
	
	public LoginSystem getLoginSystem() {
		return loginSystem;
	}
	
	public ExceptionHandlerDialog getExceptionHandlerDialog() {
		return exceptionHandlerDialog;
	}

	@Override
	public void lostOwnership(Clipboard clipboard, Transferable contents) {
		// TODO Auto-generated method stub	
	}
	
	public Clipboard getClipboard() {
		return clipboard;
	}
}

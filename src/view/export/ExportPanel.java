package view.export;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sun.javafx.font.Disposer;

import javafx.print.PageLayout;
import main.Core;
import model.tree.ModuleModel;
import view.tree.CustomTreeNode;
import view.tree.Module;
import view.tree.Parameter;

public class ExportPanel extends JPanel implements Observer {

	private JButton btnNext, btnFinish, btnCancel, btnPrevious;
	private GridBagConstraints c;
	private CardLayout cardLayout;
	private JPanel cardsPanel, btnPanel;
	private HashMap<String, JPanel> cardsMap;
	private WelcomeExportCard welcomeCard;
	private JLabel logo;
	private int pageCount;
	private int tocCount = 0;
	private TocExportCard toc;	

	public ExportPanel(Module m) {
		initPane(m);
		initActions();
		addCards(m);
	}

	private void initPane(Module m) {
		pageCount = 0;
		m.getNodeModel().addObserver(this);
		cardsMap = new HashMap<>();
		btnNext = new JButton("Next");
		btnFinish = new JButton("Finish");
		btnCancel = new JButton("Cancel");
		btnPrevious = new JButton("Previous");
		c = new GridBagConstraints();
		cardLayout = new CardLayout(10, 10);
		cardsPanel = new JPanel();
		setLayout(new GridBagLayout());
		cardsPanel.setLayout(cardLayout);
		welcomeCard = new WelcomeExportCard(m);
		cardsPanel.add("Welcome", welcomeCard);
		logo = new JLabel();
		logo.setPreferredSize(new Dimension(75, 75));
		logo.setSize(new Dimension(75, 75));
		c.fill = GridBagConstraints.BOTH;
		c.anchor = GridBagConstraints.PAGE_START;
		c.gridx = 0;
		c.gridy = 0;
		add(logo, c);
		c.gridx = 1;
		c.weightx = 1;
		c.weighty = 1;
		c.insets = new Insets(10, 20, 10, 20);
		add(cardsPanel, c);
		c.weighty = 0;
		c.gridy = 1;
		btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,15,15));
		btnPanel.add(btnPrevious);
		btnPanel.add(btnCancel);
		btnPanel.add(btnNext);
		btnPanel.add(btnFinish);
		add(btnPanel, c);
		btnFinish.setEnabled(false);
		btnPrevious.setEnabled(false);
		btnNext.setEnabled(false);
	}

	private void initActions() {
		btnNext.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				pageCount++;
				if (pageCount != 0)
					btnPrevious.setEnabled(true);
				if (pageCount == cardsMap.size()) {
					btnNext.setEnabled(false);
					btnFinish.setEnabled(true);
				}

				if (tocCount != 0 && pageCount == tocCount) {
					btnFinish.setEnabled(false);
					btnNext.setEnabled(false);
					if(pageCount==cardsMap.size())
						toc.setLastPanel(true);
				}

				cardLayout.next(cardsPanel);
			}
		});

		btnPrevious.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				pageCount--;
				if (pageCount == 0) {
					btnPrevious.setEnabled(false);
				}
				cardLayout.previous(cardsPanel);
				if (btnFinish.isEnabled()) {
					btnFinish.setEnabled(false);
					btnNext.setEnabled(true);
				}
				if (tocCount != 0 && pageCount == tocCount) {
					btnFinish.setEnabled(false);
					btnNext.setEnabled(false);
					
				}

			}
		});

		btnFinish.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ExportFrame.getInstance().incraseInstalled();
				ExportFrame.getInstance().startInstalation(ExportFrame.getInstance().getProduct());
			}
		});
		
		btnCancel.addActionListener(a -> ExportFrame.getInstance().terminate());
	}

	private void addCards(Module m) {
		int count = 1;
		for (CustomTreeNode n : m.getChildrenArrayList()) {
			if (n instanceof Parameter) {
				Parameter p = (Parameter) n;
				try {
					JPanel panel = ExportCardFactory.exportCard(p, this);
					if (panel != null && !cardsMap.containsKey(panel.getName())) {
						cardsMap.put(panel.getName(), panel);
						cardsPanel.add(panel, panel.getName());
						if (panel.getName().equals("TOC")) {
							tocCount = count;
							toc = (TocExportCard)panel;
						}
						else
							count++;
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
		if (cardsMap.size() == 0)
			btnNext.setEnabled(false);
		cardsPanel.revalidate();
		cardsPanel.repaint();
		ExportCardFactory.resetCount();
	}

	public JLabel getLogo() {
		return logo;
	}

	public JButton getBtnNext() {
		return btnNext;
	}

	public JButton getBtnFinish() {
		return btnFinish;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		btnNext.setEnabled(true);
	}
	

}

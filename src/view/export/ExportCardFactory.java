package view.export;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import model.tree.ParameterType;
import view.tree.Parameter;

public class ExportCardFactory {
	
	private static int customCount = 0;
	
	public static JPanel exportCard(Parameter p, ExportPanel senderPanel) throws IOException {
		if(p.getNodeModel().getType()!=null) {
		if(p.getNodeModel().getType().equals(ParameterType.Author))
			return new AuthorExportCard(p);
		else if(p.getNodeModel().getType().equals(ParameterType.TOC))
			return new TocExportCard(p, senderPanel);
		else if(p.getNodeModel().getType().equals(ParameterType.Logo) && p.getNodeModel().getFile()!=null) {
			senderPanel.getLogo().setIcon(new ImageIcon(ImageIO.read(p.getNodeModel().getFile())));
			return null;
		}
		else if(p.getNodeModel().getType().equals(ParameterType.Description))
			return new DescriptionExportCard(p);
		else if(p.getNodeModel().getType().equals(ParameterType.Version))
			return new VersionExportCard(p);
		else if(p.getNodeModel().getType().equals(ParameterType.Custom) && p.getCustomPanel()!=null) {
			p.getCustomPanel().setName(p.getCustomPanel().getName() + "_" + ++customCount);
			return p.getCustomPanel();
		}
		else
			return null;
		}
		return null;
	}
	
	public static void resetCount() {
		customCount = 0;
	}
}

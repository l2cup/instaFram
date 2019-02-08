package model.tree;

import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import javax.xml.ws.AsyncHandler;

import view.tree.Parameter;

public class ParameterSelection implements Transferable, ClipboardOwner {

	static public DataFlavor parameterFlavor;
	private DataFlavor[] supportedFlavors = { parameterFlavor };
	private Parameter parameter;

	public ParameterSelection(Parameter parameter) {
		this.parameter = parameter;
	
		
		try {
			parameterFlavor = new DataFlavor(Class.forName(Parameter.class.getName()), "Parameter");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public DataFlavor[] getTransferDataFlavors() {
		return supportedFlavors;
	}

	@Override
	public boolean isDataFlavorSupported(DataFlavor flavor) {
		return (flavor.equals(parameterFlavor));
	}

	@Override
	public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
		if(flavor.equals(parameterFlavor) && parameter!=null)
			return parameter;
		return null;
	}

	@Override
	public void lostOwnership(Clipboard clipboard, Transferable contents) {
		// TODO Auto-generated method stub
		
	}
	

}

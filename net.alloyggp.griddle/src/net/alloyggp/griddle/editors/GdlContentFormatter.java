package net.alloyggp.griddle.editors;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.formatter.IContentFormatter;
import org.eclipse.jface.text.formatter.IFormattingStrategy;

public class GdlContentFormatter implements IContentFormatter {

	@Override
	public void format(IDocument document, IRegion region) {
		// TODO Auto-generated method stub
		System.out.println("Format is being called on document " + document + " and region " + region);
//		document.
	}

	@Override
	public IFormattingStrategy getFormattingStrategy(String contentType) {
		System.out.println("Asking for a formatting strategy for " + contentType + ", returning null");
		return null;
	}

}

package net.alloyggp.griddle.editors;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.formatter.IContentFormatter;
import org.eclipse.jface.text.formatter.IFormattingStrategy;

//TODO: Figure out when this gets called and what it should do
public class GdlContentFormatter implements IContentFormatter {

	@Override
	public void format(IDocument document, IRegion region) {
	}

	@Override
	public IFormattingStrategy getFormattingStrategy(String contentType) {
		return null;
	}

}

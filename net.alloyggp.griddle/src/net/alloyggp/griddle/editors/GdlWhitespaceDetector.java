package net.alloyggp.griddle.editors;

import org.eclipse.jface.text.rules.IWhitespaceDetector;

public class GdlWhitespaceDetector implements IWhitespaceDetector {

	@Override
	public boolean isWhitespace(char c) {
		return Character.isWhitespace(c);
	}
}

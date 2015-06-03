package net.alloyggp.griddle.editors;

import org.eclipse.jface.text.rules.IWhitespaceDetector;

public class GdlWhitespaceDetector implements IWhitespaceDetector {

	@Override
	public boolean isWhitespace(char c) {
		return (c == ' ' || c == '\t' || c == '\n' || c == '\r');
		//TODO: Switch this over and test
//		return Character.isWhitespace(c);
	}
}

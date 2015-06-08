package net.alloyggp.griddle.editors;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.EndOfLineRule;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.IWordDetector;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.rules.WhitespaceRule;
import org.eclipse.jface.text.rules.WordRule;
import org.eclipse.swt.graphics.RGB;

public class GdlScanner extends RuleBasedScanner {

	public GdlScanner(ColorManager manager) {
		IToken comment = createToken(GdlColorConstants.COMMENT, manager);
		IToken implies = createToken(GdlColorConstants.DATALOG, manager);
		IToken keyword = createToken(GdlColorConstants.KEYWORD, manager);
		IToken variable = createToken(GdlColorConstants.VARIABLE, manager);
		IToken normal = createToken(GdlColorConstants.DEFAULT, manager);
		IToken parens = createToken(GdlColorConstants.DEFAULT, manager);

		List<IRule> rules = new ArrayList<IRule>();

		rules.add(new EndOfLineRule(";", comment));
		// Add generic whitespace rule.
		rules.add(new WhitespaceRule(new GdlWhitespaceDetector()));

		rules.add(new WordRule(new ParensDetector(), parens));
		rules.add(new WordRule(new VariableWordDetector(), variable));

		WordRule wordRule = new WordRule(new NormalWordDetector(), normal, true);
		wordRule.addWord("<=", implies);
		wordRule.addWord("or", implies);
		wordRule.addWord("distinct", implies);
		wordRule.addWord("true", keyword);
		wordRule.addWord("init", keyword);
		wordRule.addWord("next", keyword);
		wordRule.addWord("legal", keyword);
		wordRule.addWord("does", keyword);
		wordRule.addWord("role", keyword);
		wordRule.addWord("goal", keyword);
		wordRule.addWord("terminal", keyword);
		wordRule.addWord("base", keyword);
		wordRule.addWord("input", keyword);
		rules.add(wordRule);

		IRule[] rulesArray = new IRule[rules.size()];
		setRules(rules.toArray(rulesArray));
	}

	private static class VariableWordDetector implements IWordDetector {
		@Override
		public boolean isWordStart(char c) {
			return c == '?';
		}

		@Override
		public boolean isWordPart(char c) {
			return !Character.isWhitespace(c)
					&& c != '('
					&& c != ')';
		}
	}

	private static class NormalWordDetector implements IWordDetector {
		@Override
		public boolean isWordStart(char c) {
			return c != '?'
					&& c != '('
					&& c != ')';
		}

		@Override
		public boolean isWordPart(char c) {
			return !Character.isWhitespace(c)
					&& c != '('
					&& c != ')';
		}
	}

	private static class ParensDetector implements IWordDetector {
		@Override
		public boolean isWordStart(char c) {
			return c == '('
					|| c == ')';
		}

		@Override
		public boolean isWordPart(char c) {
			return false;
		}
	}

	private static Token createToken(RGB color, ColorManager manager) {
		return new Token(new TextAttribute(
				manager.getColor(color)));
	}
}

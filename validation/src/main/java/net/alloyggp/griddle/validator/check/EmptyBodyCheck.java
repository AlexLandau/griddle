package net.alloyggp.griddle.validator.check;

import net.alloyggp.griddle.grammar.Function;
import net.alloyggp.griddle.grammar.GdlVisitor;
import net.alloyggp.griddle.grammar.Sentence;
import net.alloyggp.griddle.validator.AnalyzedGame;

public class EmptyBodyCheck implements Check {
	public static final EmptyBodyCheck INSTANCE = new EmptyBodyCheck();

	private EmptyBodyCheck() {
		//Singleton
	}

	@Override
	public void findProblems(AnalyzedGame game, final ProblemReporter reporter) {
		game.visitAll(new GdlVisitor() {
			@Override
			public void visitSentence(Sentence sentence) {
				if (sentence.getBody() != null && sentence.getBody().isEmpty()) {
					reporter.report("Sentence with unnecessary parentheses; this may confuse some players.",
							sentence.getPosition());
				}
			}
			@Override
			public void visitFunction(Function function) {
				if (function.getBody().isEmpty()) {
					reporter.report("Function with unnecessary parentheses; this may confuse some players.",
							function.getPosition());
				}
			}
		});
	}
}

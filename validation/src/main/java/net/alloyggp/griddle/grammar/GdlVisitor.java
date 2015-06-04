package net.alloyggp.griddle.grammar;

import net.alloyggp.griddle.Position;

/**
 * This visitor uses the Adapter pattern, so implementations only need to
 * implement the relevant calls.
 */
public abstract class GdlVisitor {
	public void visitConstant(String constant, Position position) {

	}
	public void visitVariable(String variable, Position position) {

	}
	public void visitFunction(Function function) {

	}
	public void visitRule(Rule rule) {

	}
	public void visitLiteral(Literal literal) {

	}
	public void visitSentence(Sentence sentence) {

	}
	public void visitNegation(Literal negation) {

	}
	public void visitDistinct(Literal distinct) {

	}
	public void visitDisjunction(Literal disjunction) {

	}
}

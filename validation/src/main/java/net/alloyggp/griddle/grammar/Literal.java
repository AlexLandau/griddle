package net.alloyggp.griddle.grammar;

import java.util.List;

import net.alloyggp.griddle.Position;

public class Literal {
	//Exactly one of these is non-null (with the two Terms for distinct
	// counted together).
	private final Sentence sentence;
	private final Literal negation;
	private final Term distinctTerm1;
	private final Term distinctTerm2;
	private final List<Literal> disjunction;

	private final Position position;

	private Literal(Sentence sentence, Literal negation, Term distinctTerm1,
			Term distinctTerm2, List<Literal> disjunction, int left, int right) {
		this.sentence = sentence;
		this.negation = negation;
		this.distinctTerm1 = distinctTerm1;
		this.distinctTerm2 = distinctTerm2;
		this.disjunction = disjunction;
		this.position = new Position(left, right);
	}

	public static Literal createOr(List<Literal> literals, int left, int right) {
		if (literals == null) {
			throw new NullPointerException();
		}
		return new Literal(null, null, null, null, literals, left, right);
	}

	public static Literal createDistinct(Term term1, Term term2, int left, int right) {
		if (term1 == null || term2 == null) {
			throw new NullPointerException();
		}
		return new Literal(null, null, term1, term2, null, left, right);
	}

	public static Literal createNot(Literal literal, int left, int right) {
		if (literal == null) {
			throw new NullPointerException();
		}
		return new Literal(null, literal, null, null, null, left, right);
	}

	public static Literal createSentence(Sentence sentence, int left, int right) {
		if (sentence == null) {
			throw new NullPointerException();
		}
		return new Literal(sentence, null, null, null, null, left, right);
	}

	public boolean isSentence() {
		return sentence != null;
	}

	public boolean isNegation() {
		return negation != null;
	}

	public boolean isDistinct() {
		return distinctTerm1 != null;
	}

	public boolean isDisjunction() {
		return disjunction != null;
	}

	public Sentence getSentence() {
		return sentence;
	}

	public Literal getNegation() {
		return negation;
	}

	public Term getDistinctTerm1() {
		return distinctTerm1;
	}

	public Term getDistinctTerm2() {
		return distinctTerm2;
	}

	public List<Literal> getDisjunction() {
		return disjunction;
	}

	public Position getPosition() {
		return position;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((disjunction == null) ? 0 : disjunction.hashCode());
		result = prime * result
				+ ((distinctTerm1 == null) ? 0 : distinctTerm1.hashCode());
		result = prime * result
				+ ((distinctTerm2 == null) ? 0 : distinctTerm2.hashCode());
		result = prime * result
				+ ((negation == null) ? 0 : negation.hashCode());
		result = prime * result
				+ ((position == null) ? 0 : position.hashCode());
		result = prime * result
				+ ((sentence == null) ? 0 : sentence.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Literal other = (Literal) obj;
		if (disjunction == null) {
			if (other.disjunction != null)
				return false;
		} else if (!disjunction.equals(other.disjunction))
			return false;
		if (distinctTerm1 == null) {
			if (other.distinctTerm1 != null)
				return false;
		} else if (!distinctTerm1.equals(other.distinctTerm1))
			return false;
		if (distinctTerm2 == null) {
			if (other.distinctTerm2 != null)
				return false;
		} else if (!distinctTerm2.equals(other.distinctTerm2))
			return false;
		if (negation == null) {
			if (other.negation != null)
				return false;
		} else if (!negation.equals(other.negation))
			return false;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		if (sentence == null) {
			if (other.sentence != null)
				return false;
		} else if (!sentence.equals(other.sentence))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Literal [sentence=" + sentence + ", negation=" + negation
				+ ", distinctTerm1=" + distinctTerm1 + ", distinctTerm2="
				+ distinctTerm2 + ", disjunction=" + disjunction
				+ ", position=" + position + "]";
	}
}

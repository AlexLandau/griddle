package net.alloyggp.griddle.grammar;

import net.alloyggp.griddle.Position;

public class TopLevelGdl {
	//Exactly one of these is non-null.
	private final Sentence sentence;
	private final Rule rule;

	private final Position position;

	private TopLevelGdl(Sentence sentence, Rule rule, int left, int right) {
		this.sentence = sentence;
		this.rule = rule;
		this.position = new Position(left, right);
	}

	public static TopLevelGdl create(Sentence sentence, int left, int right) {
		if (sentence == null) {
			throw new NullPointerException();
		}
		return new TopLevelGdl(sentence, null, left, right);
	}

	public static TopLevelGdl create(Rule rule, int left, int right) {
		if (rule == null) {
			throw new NullPointerException();
		}
		return new TopLevelGdl(null, rule, left, right);
	}

	public boolean isSentence() {
		return sentence != null;
	}

	public boolean isRule() {
		return rule != null;
	}

	public Sentence getSentence() {
		return sentence;
	}

	public Rule getRule() {
		return rule;
	}

	public Position getPosition() {
		return position;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((position == null) ? 0 : position.hashCode());
		result = prime * result + ((rule == null) ? 0 : rule.hashCode());
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
		TopLevelGdl other = (TopLevelGdl) obj;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		if (rule == null) {
			if (other.rule != null)
				return false;
		} else if (!rule.equals(other.rule))
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
		return "TopLevelGdl [sentence=" + sentence + ", rule=" + rule
				+ ", position=" + position + "]";
	}

}

package net.alloyggp.griddle.grammar;

import net.alloyggp.griddle.Position;

public class TopLevelGdl implements GdlVisitable {
	//Exactly one of these is non-null.
	private final Sentence sentence;
	private final Rule rule;

	private final Position position;

	private TopLevelGdl(Sentence sentence, Rule rule, int left, int right, int line) {
		this.sentence = sentence;
		this.rule = rule;
		this.position = new Position(left, right, line);
	}

	public static TopLevelGdl create(Sentence sentence, int left, int right, int line) {
		if (sentence == null) {
			throw new NullPointerException();
		}
		return new TopLevelGdl(sentence, null, left, right, line);
	}

	public static TopLevelGdl create(Rule rule, int left, int right, int line) {
		if (rule == null) {
			throw new NullPointerException();
		}
		return new TopLevelGdl(null, rule, left, right, line);
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

	@Override
	public void accept(GdlVisitor visitor) {
		if (sentence != null) {
			sentence.accept(visitor);
		} else {
			rule.accept(visitor);
		}
	}

}

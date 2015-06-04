package net.alloyggp.griddle.grammar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.alloyggp.griddle.Position;

public class Rule {
	private final Sentence head;
	private final List<Literal> conjuncts;

	private final Position position;

	private Rule(Sentence head, List<Literal> conjuncts, int left, int right) {
		if (head == null || conjuncts == null) {
			throw new NullPointerException();
		}
		this.head = head;
		this.conjuncts = conjuncts;
		this.position = new Position(left, right);
	}

	public static Rule create(Sentence head, List<Literal> conjuncts, int left, int right) {
		return new Rule(head,
				Collections.unmodifiableList(new ArrayList<Literal>(conjuncts)),
				left, right);
	}

	public Sentence getHead() {
		return head;
	}

	public List<Literal> getConjuncts() {
		return conjuncts;
	}

	public Position getPosition() {
		return position;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((conjuncts == null) ? 0 : conjuncts.hashCode());
		result = prime * result + ((head == null) ? 0 : head.hashCode());
		result = prime * result
				+ ((position == null) ? 0 : position.hashCode());
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
		Rule other = (Rule) obj;
		if (conjuncts == null) {
			if (other.conjuncts != null)
				return false;
		} else if (!conjuncts.equals(other.conjuncts))
			return false;
		if (head == null) {
			if (other.head != null)
				return false;
		} else if (!head.equals(other.head))
			return false;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Rule [head=" + head + ", conjuncts=" + conjuncts
				+ ", position=" + position + "]";
	}

}

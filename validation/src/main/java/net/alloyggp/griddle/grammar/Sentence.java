package net.alloyggp.griddle.grammar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.alloyggp.griddle.Position;

public class Sentence {
	private final String head;
	//Body is nullable; a null body indicates the sentence was not in parentheses.
	private final List<Term> body;

	private final Position position;

	private Sentence(String head, List<Term> body, int left, int right) {
		if (head == null) {
			throw new NullPointerException();
		}
		this.head = head;
		this.body = body;

		this.position = new Position(left, right);
	}

	public static Sentence create(String head, List<Term> body, int left, int right) {
		if (body == null) {
			throw new NullPointerException();
		}
		return new Sentence(head,
				Collections.unmodifiableList(new ArrayList<Term>(body)),
				left, right);
	}

	public static Sentence create(String head, int left, int right) {
		return new Sentence(head, null, left, right);
	}

	public String getHead() {
		return head;
	}

	/**
	 * If the sentence did not have parentheses, getBody() will return null.
	 */
	public List<Term> getBody() {
		return body;
	}

	public Position getPosition() {
		return position;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((body == null) ? 0 : body.hashCode());
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
		Sentence other = (Sentence) obj;
		if (body == null) {
			if (other.body != null)
				return false;
		} else if (!body.equals(other.body))
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
		return "Sentence [head=" + head + ", body=" + body + ", position="
				+ position + "]";
	}
}

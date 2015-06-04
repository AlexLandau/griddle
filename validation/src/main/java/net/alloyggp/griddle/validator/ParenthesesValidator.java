package net.alloyggp.griddle.validator;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

import net.alloyggp.griddle.GdlProblem;
import net.alloyggp.griddle.Position;

public class ParenthesesValidator implements Validator {
	public static final ParenthesesValidator INSTANCE = new ParenthesesValidator();

	@Override
	public Set<GdlProblem> findProblems(String gdlFile) {
		Deque<Integer> openingIndices = new ArrayDeque<Integer>();
		boolean inComment = false;
		for (int i = 0; i < gdlFile.length(); i++) {
			char curChar = gdlFile.charAt(i);
			if (inComment) {
				//Behavior when in comment:
				//end the comment if we're at EOL
				//otherwise, ignore the character
				if (curChar == '\n' || curChar == '\r') {
					inComment = false;
				}
			} else {
				//Behavior when not in comment
				if (curChar == ';') {
					inComment = true;
				} else if (curChar == '(') {
					openingIndices.addLast(i);
				} else if (curChar == ')') {
					if (openingIndices.isEmpty()) {
						return unmatchedCloseParens(i);
					}
					openingIndices.removeLast();
				}
			}
		}

		//We've reached the end of the file
		if (!openingIndices.isEmpty()) {
			return unmatchedOpenParens(openingIndices);
		}

		return Collections.emptySet();
	}

	private Set<GdlProblem> unmatchedCloseParens(int i) {
		return Collections.singleton(GdlProblem.createError("Unmatched closing parenthesis",
				new Position(i, i+1)));
	}

	private Set<GdlProblem> unmatchedOpenParens(Iterable<Integer> indices) {
		Set<GdlProblem> problems = new HashSet<GdlProblem>();
		for (int i : indices) {
			problems.add(GdlProblem.createError("Unmatched opening parenthesis",
					new Position(i, i+1)));
		}
		return problems;
	}
}

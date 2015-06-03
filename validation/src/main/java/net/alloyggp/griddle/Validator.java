package net.alloyggp.griddle;

import java.util.Set;

public interface Validator {
	Set<GdlProblem> findProblems(String gdlFile);
}

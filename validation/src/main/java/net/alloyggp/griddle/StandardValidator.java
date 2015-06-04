package net.alloyggp.griddle;

import java.io.StringReader;
import java.util.Set;

import java_cup.runtime.Symbol;
import net.alloyggp.griddle.generated.ParserHelper;

public class StandardValidator implements Validator {
	@Override
	public Set<GdlProblem> findProblems(String gdlFile) {
		try {
			Symbol symbol = ParserHelper.parse(new StringReader(gdlFile));


		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}

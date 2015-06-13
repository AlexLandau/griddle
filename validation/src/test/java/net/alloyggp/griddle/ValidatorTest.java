package net.alloyggp.griddle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashSet;
import java.util.Set;

import net.alloyggp.griddle.generated.ParserHelper;
import net.alloyggp.griddle.validator.AnalyzedGame;
import net.alloyggp.griddle.validator.ConfigurableValidator;
import net.alloyggp.griddle.validator.ParenthesesValidator;
import net.alloyggp.griddle.validator.Validators;
import net.alloyggp.griddle.validator.check.Check;
import net.alloyggp.griddle.validator.check.DatalogKeywordsNotConstantsCheck;
import net.alloyggp.griddle.validator.check.ProblemReporter;

import org.junit.Assert;
import org.junit.Test;

public class ValidatorTest extends Assert {
	@Test
	public void testParsing() throws Exception {
		//This just tests if these can run without throwing exceptions.
		ParserHelper.parse(getGameReader("ticTacToe"));

		String gameString = getGameString("ticTacToe");
		AnalyzedGame.parseAndAnalyze(gameString);

		ConfigurableValidator validator = ConfigurableValidator.create(Validators.getStandardConfiguration());
		validator.findProblems(gameString);
	}

	@Test
	public void testParensMatching() throws Exception {
		String gameString = getGameString("ticTacToe");
		Set<GdlProblem> problems = ParenthesesValidator.INSTANCE.findProblems(gameString);
		assertTrue(problems.isEmpty());
	}

	@Test
	public void testParensMatching1() throws Exception {
		String gameString = getGameString("badparens1");
		Set<GdlProblem> problems = ParenthesesValidator.INSTANCE.findProblems(gameString);
		assertTrue(problems.size() == 1);
		GdlProblem problem = problems.iterator().next();
		assertTrue(problem.isError());
		assertEquals(4, problem.getPosition().getStart());
		assertEquals(5, problem.getPosition().getEnd());
	}

	@Test
	public void testParensMatching2() throws Exception {
		String gameString = getGameString("badparens2");
		Set<GdlProblem> problems = ParenthesesValidator.INSTANCE.findProblems(gameString);
		assertTrue(problems.size() == 1);
		GdlProblem problem = problems.iterator().next();
		assertTrue(problem.isError());
		assertEquals(8, problem.getPosition().getStart());
		assertEquals(9, problem.getPosition().getEnd());
	}

	@Test
	public void testParensMatching3() throws Exception {
		String gameString = getGameString("badparens3");
		Set<GdlProblem> problems = ParenthesesValidator.INSTANCE.findProblems(gameString);
		assertTrue(problems.size() == 1);
		GdlProblem problem = problems.iterator().next();
		assertTrue(problem.isError());
		//Unfortunately, Git repo checkouts may vary in local line endings
		if (gameString.contains("\r")) {
			//Windows-style whitespace
			assertEquals(17, problem.getPosition().getStart());
			assertEquals(18, problem.getPosition().getEnd());
		} else {
			//Unix-style whitespace
			assertEquals(16, problem.getPosition().getStart());
			assertEquals(17, problem.getPosition().getEnd());
		}
	}

	@Test
	public void testConsecutiveOpenParens4() throws Exception {
		String gameString = getGameString("badparens4");
		Set<GdlProblem> problems = ParenthesesValidator.INSTANCE.findProblems(gameString);
		assertTrue(problems.size() == 1);
		GdlProblem problem = problems.iterator().next();
		assertTrue(problem.isError());
		assertEquals(3, problem.getPosition().getStart());
		assertEquals(4, problem.getPosition().getEnd());
	}

	@Test
	public void testConsecutiveOpenParens5() throws Exception {
		String gameString = getGameString("badparens5");
		Set<GdlProblem> problems = ParenthesesValidator.INSTANCE.findProblems(gameString);
		assertTrue(problems.size() == 1);
		GdlProblem problem = problems.iterator().next();
		assertTrue(problem.isError());
		assertEquals(2, problem.getPosition().getStart());
		assertEquals(3, problem.getPosition().getEnd());
	}

	@Test
	public void testMisplacedDatalogKeyword2() throws Exception {
		String gameString = getGameString("misplacedDatalogKeyword2");
		Set<GdlProblem> problems = findProblems(DatalogKeywordsNotConstantsCheck.INSTANCE, gameString);
		assertTrue(problems.size() == 1);
		GdlProblem problem = problems.iterator().next();
		assertTrue(problem.isError());
		assertEquals(5, problem.getPosition().getStart());
		assertEquals(8, problem.getPosition().getEnd());
	}

	private Set<GdlProblem> findProblems(Check check, String gameString) throws Exception {
		AnalyzedGame game = AnalyzedGame.parseAndAnalyze(gameString);
		final Set<GdlProblem> problems = new HashSet<GdlProblem>();
		check.findProblems(game, new ProblemReporter() {
			@Override
			public void report(String message, Position position) {
				problems.add(GdlProblem.createError(message, position));
			}
		});
		return problems;
	}

	private String getGameString(String gameName) throws IOException {
		//These only work in Java 7 and later...
//		Path gameFile = Paths.get("testgames", gameName + ".kif");
//		return new String(Files.readAllBytes(gameFile));
		BufferedReader in = new BufferedReader(getGameReader(gameName));
		StringBuilder sb = new StringBuilder();
		while (true) {
			int c = in.read();
			if (c == -1) {
				break;
			}
			sb.append((char) c);
		}
		in.close();
		return sb.toString();
	}

	private Reader getGameReader(String gameName) throws FileNotFoundException {
		File gameFile = new File("testgames", gameName + ".kif");
		return new FileReader(gameFile);
	}
}

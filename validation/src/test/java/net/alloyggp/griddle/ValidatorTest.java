package net.alloyggp.griddle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Set;

import net.alloyggp.griddle.generated.ParserHelper;
import net.alloyggp.griddle.grammar.TopLevelGdl;
import net.alloyggp.griddle.validator.AnalyzedGame;
import net.alloyggp.griddle.validator.ConfigurableValidator;
import net.alloyggp.griddle.validator.ParenthesesValidator;
import net.alloyggp.griddle.validator.Validators;

import org.junit.Assert;
import org.junit.Test;

public class ValidatorTest extends Assert {
	@Test
	public void testParsing() throws Exception {
		List<TopLevelGdl> game = ParserHelper.parse(getGameReader("ticTacToe"));
		//TODO: Actually check something here?
		System.out.println(game);
		String gameString = getGameString("ticTacToe");
		AnalyzedGame analyzedGame = AnalyzedGame.parseAndAnalyze(gameString);

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
		assertEquals(16, problem.getPosition().getStart());
		assertEquals(17, problem.getPosition().getEnd());
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

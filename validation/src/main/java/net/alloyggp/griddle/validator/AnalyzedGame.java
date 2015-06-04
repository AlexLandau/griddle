package net.alloyggp.griddle.validator;

import java.io.StringReader;
import java.util.List;

import net.alloyggp.griddle.generated.ParserHelper;
import net.alloyggp.griddle.grammar.GdlVisitor;
import net.alloyggp.griddle.grammar.TopLevelGdl;

public class AnalyzedGame {
	private final List<TopLevelGdl> rules;

	private AnalyzedGame(List<TopLevelGdl> rules) {
		this.rules = rules;
	}

	public static AnalyzedGame parseAndAnalyze(String gdlFile) throws Exception {
		List<TopLevelGdl> rules = ParserHelper.parse(new StringReader(gdlFile));
		return analyze(rules);
	}

	private static AnalyzedGame analyze(List<TopLevelGdl> rules) {
		return new AnalyzedGame(rules);
	}

	public List<TopLevelGdl> getRules() {
		return rules;
	}

	public void visitAll(GdlVisitor gdlVisitor) {
		for (TopLevelGdl gdl : rules) {
			gdl.accept(gdlVisitor);
		}
	}

}

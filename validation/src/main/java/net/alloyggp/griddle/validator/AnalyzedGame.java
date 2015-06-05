package net.alloyggp.griddle.validator;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import net.alloyggp.griddle.generated.ParserHelper;
import net.alloyggp.griddle.grammar.GdlVisitor;
import net.alloyggp.griddle.grammar.Literal;
import net.alloyggp.griddle.grammar.Rule;
import net.alloyggp.griddle.grammar.Sentence;
import net.alloyggp.griddle.grammar.TopLevelGdl;

public class AnalyzedGame {
	private final List<TopLevelGdl> rules;
	/**
	 * Each name that is a key depends on each name that is in its associated set.
	 */
	private final Map<String, Set<String>> sentenceNameDependencyGraph;
	/**
	 * Each name that is a key depends on each name that is in its associated set.
	 * Unlike the dependency graph, this includes indirect relations through
	 * multiple rules.
	 */
	private final Map<String, Set<String>> sentenceNameAncestorGraph;

	private AnalyzedGame(List<TopLevelGdl> rules,
			Map<String, Set<String>> sentenceNameDependencyGraph,
			Map<String, Set<String>> sentenceNameAncestorGraph) {
		this.rules = Collections.unmodifiableList(rules);
		this.sentenceNameDependencyGraph = Collections.unmodifiableMap(sentenceNameDependencyGraph);
		this.sentenceNameAncestorGraph = Collections.unmodifiableMap(sentenceNameAncestorGraph);
	}

	public static AnalyzedGame parseAndAnalyze(String gdlFile) throws Exception {
		List<TopLevelGdl> rules = ParserHelper.parse(new StringReader(gdlFile));

		return analyze(rules);
	}

	private static AnalyzedGame analyze(List<TopLevelGdl> rules) {
		Map<String, Set<String>> sentenceNameDependencyGraph = generateSentenceNameDependencyGraph(rules);
		Map<String, Set<String>> sentenceNameAncestorGraph = toAncestorGraph(sentenceNameDependencyGraph);

		return new AnalyzedGame(rules, sentenceNameDependencyGraph,
				sentenceNameAncestorGraph);
	}

	private static Map<String, Set<String>> toAncestorGraph(
			Map<String, Set<String>> dependencyGraph) {
		Map<String, Set<String>> ancestorGraph = new HashMap<String, Set<String>>();

		//Initially populate the ancestor graph: deep copy
		for (Entry<String, Set<String>> entry : dependencyGraph.entrySet()) {
			ancestorGraph.put(entry.getKey(), new HashSet<String>(entry.getValue()));
		}
		boolean addedSomething = true;
		while (addedSomething) {
			addedSomething = false;
			for (String key : ancestorGraph.keySet()) {
				for (String value : new ArrayList<String>(ancestorGraph.get(key))) {
					Set<String> nextLevelDependencies = ancestorGraph.get(value);
					addedSomething |= ancestorGraph.get(key).addAll(nextLevelDependencies);
				}
			}
		}
		return ancestorGraph;
	}

	private static Map<String, Set<String>> generateSentenceNameDependencyGraph(
			List<TopLevelGdl> rules) {
		final Map<String, Set<String>> ruleDependencyGraph = new HashMap<String, Set<String>>();
		for (TopLevelGdl gdl : rules) {
			if (gdl.isRule()) {
				Rule rule = gdl.getRule();
				final String headName = rule.getHead().getName();
				if (!ruleDependencyGraph.containsKey(headName)) {
					ruleDependencyGraph.put(headName, new HashSet<String>());
				}
				for (Literal literal : rule.getConjuncts()) {
					literal.accept(new GdlVisitor() {
						@Override
						public void visitSentence(Sentence sentence) {
							ruleDependencyGraph.get(headName).add(sentence.getName());
						}
					});
				}
			}
		}
		return ruleDependencyGraph;
	}

	public List<TopLevelGdl> getRules() {
		return rules;
	}

	public void visitAll(GdlVisitor gdlVisitor) {
		for (TopLevelGdl gdl : rules) {
			gdl.accept(gdlVisitor);
		}
	}

	public Map<String, Set<String>> getSentenceNameDependencyGraph() {
		return sentenceNameDependencyGraph;
	}

	public Map<String, Set<String>> getSentenceNameAncestorGraph() {
		return sentenceNameAncestorGraph;
	}

	public Set<String> getSentenceNameAncestors(String name) {
		return sentenceNameAncestorGraph.get(name);
	}

}

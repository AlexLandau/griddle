package net.alloyggp.griddle.validator.check;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import net.alloyggp.griddle.grammar.GdlVisitor;
import net.alloyggp.griddle.grammar.Rule;
import net.alloyggp.griddle.grammar.Sentence;
import net.alloyggp.griddle.grammar.Term;
import net.alloyggp.griddle.validator.AnalyzedGame;

public class LevelBasedRecursionRestrictionCheck implements Check {
    public static final LevelBasedRecursionRestrictionCheck INSTANCE = new LevelBasedRecursionRestrictionCheck();

    private LevelBasedRecursionRestrictionCheck() {
        //Singleton
    }

//    private static class VariableWithLevel {
//        public final String varName;
//        public final int level;
//        public VariableWithLevel(String varName, int level) {
//            this.varName = varName;
//            this.level = level;
//        }
//    }

    @Override
    public void findProblems(final AnalyzedGame game, final ProblemReporter reporter) {
//        Multimap<Pair<String, String>, Integer> levelShifts = HashMultimap.create();

        //Build up the level shifts...
        //body name -> head name -> max level shift
        final Map<String, Map<String, Integer>> levelShifts = new HashMap<String, Map<String, Integer>>();

        game.visitAll(new GdlVisitor() {
            @Override
            public void visitRule(Rule rule) {
                //For each variable in the head...
                Map<String, Set<Integer>> headVarLevels = getVariableLevels(rule.getHead());
                //Only positive conjuncts can contribute... but...
                //positive conjuncts can be in ORs

                for (Sentence conjunct : rule.getAllPositiveConjuncts()) {                    Map<String, Set<Integer>> conjunctVarLevels = getVariableLevels(conjunct);
                    for (Entry<String, Set<Integer>> conjunctEntry : conjunctVarLevels.entrySet()) {
                        String varName = conjunctEntry.getKey();
                        Set<Integer> conjunctLevels = conjunctEntry.getValue();
                        Set<Integer> headLevels = headVarLevels.get(varName);
                        //bad situation is like:
                        //(<= (foo (nested ?x))   ; level is 1
                        //    (foo ?x))           ; level is 0
                        //so we want to minimize conjunctLevel - headLevel
                        //so take max head level, min conjunct level
                        //What we're interested in is what minimizes conjunctLevel - headLevel...
                        int maxHeadLevel = Collections.max(headLevels);
                        int minConjunctLevel = Collections.min(conjunctLevels);
                        int levelShift = minConjunctLevel - maxHeadLevel;
                        if (!levelShifts.containsKey(conjunct.getName())) {
                            levelShifts.put(conjunct.getName(), new HashMap<String, Integer>());
                        }
                        if (!levelShifts.get(conjunct.getName()).containsKey(rule.getHead().getName())) {
                            levelShifts.get(conjunct.getName()).put(rule.getHead().getName(), levelShift);
                        } else {
                            int existingLevelShift = levelShifts.get(conjunct.getName()).get(rule.getHead().getName());
                            int newLevelShift = Math.min(levelShift, existingLevelShift);
                            levelShifts.get(conjunct.getName()).put(rule.getHead().getName(), newLevelShift);
                        }
                    }
                }
            }
        });
        //TODO: Possibly also add language rules? (next -> true -> 0, legal -> does -> 0)


        //TODO: Actually pinpoint things?
        //Look for cycles where sum of edges is negative
        //Use the Floyd-Warshall algorithm to detect these
        //TODO: Implement

//        game.visitAll(new GdlVisitor() {
//            @Override
//            public void visitRule(Rule rule) {
//                // Look at all the terms in each positive relation in the rule that
//                // is in a cycle with the head.
//                Set<Term> termsInNonRecursivePositiveConjuncts = getTermsInNonRecursivePositiveConjuncts(rule, game);
//
//                for (Literal conjunct : rule.getConjuncts()) {
//                    if (conjunct.isSentence()) {
//                        reportViolationsIfCyclic(game, reporter, rule,
//                                termsInNonRecursivePositiveConjuncts,
//                                conjunct.getSentence());
//                    } else if (conjunct.isDisjunction()) {
//                        //Check sentences in disjunctions
//                        for (Literal disjunct : conjunct.getDisjunction()) {
//                            if (disjunct.isSentence()) {
//                                reportViolationsIfCyclic(game, reporter, rule,
//                                        termsInNonRecursivePositiveConjuncts,
//                                        disjunct.getSentence());
//                            }
//                        }
//                    }
//                }
//            }
//
//            private void reportViolationsIfCyclic(final AnalyzedGame game,
//                    final ProblemReporter reporter, Rule rule,
//                    Set<Term> termsInNonRecursivePositiveConjuncts,
//                    Sentence sentence) {
//                String headName = rule.getHead().getName();
//                if (sentence.getName().equals(headName)
//                        || game.getSentenceNameAncestors(sentence.getName())
//                        .contains(headName)) {
//                    //This is in a cycle with the head.
//                    Set<Term> problemTerms = findProblemTerms(sentence, rule,
//                            termsInNonRecursivePositiveConjuncts);
//                    for (Term term : problemTerms) {
//                        //TODO: More informative error message?
//                        reporter.report("The term " + term.getUserFriendlyString() + " in this rule violates the Recursion Restriction.", term.getPosition());
//                    }
//                }
//            }
//        });
    }

    private static Map<String, Set<Integer>> getVariableLevels(Sentence sentence) {
        Map<String, Set<Integer>> results = new HashMap<String, Set<Integer>>();
        addVariableLevels(results, sentence.getBody(), 0);
        return results;
    }

    private static void addVariableLevels(Map<String, Set<Integer>> results,
            List<Term> body, int curLevel) {
        for (Term term : body) {
            if (term.isVariable()) {
                if (!results.containsKey(term.getVariableName())) {
                    results.put(term.getVariableName(), new HashSet<Integer>(2));
                }
                results.get(term.getVariableName()).add(curLevel);
            } else if (term.isFunction()) {
                addVariableLevels(results, term.getFunction().getBody(), curLevel + 1);
            }
        }
    }

}

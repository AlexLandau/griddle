package net.alloyggp.griddle.validator;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import net.alloyggp.griddle.GdlProblem.Level;
import net.alloyggp.griddle.validator.check.Check;
import net.alloyggp.griddle.validator.check.ContainsRoleTerminalGoalLegalCheck;
import net.alloyggp.griddle.validator.check.DatalogKeywordsNotConstantsCheck;
import net.alloyggp.griddle.validator.check.DisjunctionNotNestedCheck;
import net.alloyggp.griddle.validator.check.EmptyBodyCheck;
import net.alloyggp.griddle.validator.check.InconsistentCapitalizationCheck;
import net.alloyggp.griddle.validator.check.KeywordArityCheck;
import net.alloyggp.griddle.validator.check.KeywordsAreSentenceNamesCheck;
import net.alloyggp.griddle.validator.check.NegationContainsSentenceCheck;
import net.alloyggp.griddle.validator.check.OriginalRecursionRestrictionCheck;
import net.alloyggp.griddle.validator.check.RoleTrueDoesNotInRuleHeadCheck;
import net.alloyggp.griddle.validator.check.SentenceAndFunctionNamesDifferCheck;
import net.alloyggp.griddle.validator.check.TrueDoesAreNotStandaloneSentencesCheck;

public class ValidatorConfiguration {
	private final Map<Check, Level> checks;

	private ValidatorConfiguration(Map<Check, Level> checks) {
		this.checks = Collections.unmodifiableMap(new HashMap<Check, Level>(checks));
	}

	public static ValidatorConfiguration createStandard() {
		Map<Check, Level> checks = new HashMap<Check, Level>();

		checks.put(ContainsRoleTerminalGoalLegalCheck.INSTANCE, Level.ERROR);
		checks.put(DatalogKeywordsNotConstantsCheck.INSTANCE, Level.ERROR);
		checks.put(DisjunctionNotNestedCheck.INSTANCE, Level.WARNING);
		checks.put(EmptyBodyCheck.INSTANCE, Level.WARNING);
		checks.put(InconsistentCapitalizationCheck.INSTANCE, Level.ERROR);
		checks.put(KeywordArityCheck.INSTANCE, Level.ERROR);
		checks.put(KeywordsAreSentenceNamesCheck.INSTANCE, Level.ERROR);
		checks.put(NegationContainsSentenceCheck.INSTANCE, Level.ERROR);
		checks.put(OriginalRecursionRestrictionCheck.INSTANCE, Level.ERROR);
		checks.put(RoleTrueDoesNotInRuleHeadCheck.INSTANCE, Level.ERROR);
		checks.put(SentenceAndFunctionNamesDifferCheck.INSTANCE, Level.WARNING);
		checks.put(TrueDoesAreNotStandaloneSentencesCheck.INSTANCE, Level.ERROR);

		return new ValidatorConfiguration(checks);
	}

	public Map<Check, Level> getChecks() {
		return checks;
	}

}

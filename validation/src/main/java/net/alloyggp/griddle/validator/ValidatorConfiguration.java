package net.alloyggp.griddle.validator;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import net.alloyggp.griddle.GdlProblem.Level;
import net.alloyggp.griddle.validator.check.Check;
import net.alloyggp.griddle.validator.check.DatalogKeywordsNotConstantsCheck;
import net.alloyggp.griddle.validator.check.EmptyBodyCheck;
import net.alloyggp.griddle.validator.check.InconsistentCapitalizationCheck;
import net.alloyggp.griddle.validator.check.RoleTrueDoesNotInRuleHeadCheck;
import net.alloyggp.griddle.validator.check.TrueDoesNotAsStandaloneSentencesCheck;

public class ValidatorConfiguration {
	private final Map<Check, Level> checks;

	private ValidatorConfiguration(Map<Check, Level> checks) {
		this.checks = Collections.unmodifiableMap(new HashMap<Check, Level>(checks));
	}

	public static ValidatorConfiguration createStandard() {
		Map<Check, Level> checks = new HashMap<Check, Level>();

		checks.put(DatalogKeywordsNotConstantsCheck.INSTANCE, Level.ERROR);
		checks.put(EmptyBodyCheck.INSTANCE, Level.WARNING);
		checks.put(InconsistentCapitalizationCheck.INSTANCE, Level.ERROR);
		checks.put(RoleTrueDoesNotInRuleHeadCheck.INSTANCE, Level.ERROR);
		checks.put(TrueDoesNotAsStandaloneSentencesCheck.INSTANCE, Level.ERROR);

		return new ValidatorConfiguration(checks);
	}

	public Map<Check, Level> getChecks() {
		return checks;
	}

}

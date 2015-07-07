package net.alloyggp.griddle.editors;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.text.rules.IPredicateRule;
import org.eclipse.jface.text.rules.RuleBasedPartitionScanner;

//TODO: See if I can eliminate this class
public class GdlPartitionScanner extends RuleBasedPartitionScanner {

    public GdlPartitionScanner() {
        List<IPredicateRule> rules = new ArrayList<IPredicateRule>();

        IPredicateRule[] rulesArray = new IPredicateRule[rules.size()];
        setPredicateRules(rules.toArray(rulesArray));
    }
}

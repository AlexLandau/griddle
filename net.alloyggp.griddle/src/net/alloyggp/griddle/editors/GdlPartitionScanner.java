package net.alloyggp.griddle.editors;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.text.rules.IPredicateRule;
import org.eclipse.jface.text.rules.RuleBasedPartitionScanner;

public class GdlPartitionScanner extends RuleBasedPartitionScanner {
//	public final static String XML_COMMENT = "__xml_comment";
//	public final static String XML_TAG = "__xml_tag";
//	public final static String GDL = "__gdl";
//	public final static String GDL_COMMENT = "__gdl_comment";

	public GdlPartitionScanner() {

//		IToken xmlComment = new Token(XML_COMMENT);
//		IToken tag = new Token(XML_TAG);
//		IToken gdl = new Token(GDL);
//		IToken comment = new Token(GDL_COMMENT);

		List<IPredicateRule> rules = new ArrayList<IPredicateRule>();

		//Comments begin with ;
//		rules.add(new EndOfLineRule(";", comment));

//		rules.add()
		//TODO: Do ( and ) need their own things here?


//		rules[0] = new MultiLineRule("<!--", "-->", xmlComment);
//		rules[1] = new TagRule(tag);

		IPredicateRule[] rulesArray = new IPredicateRule[rules.size()];
		setPredicateRules(rules.toArray(rulesArray));
//		this.setDefaultReturnToken(gdl);
	}
}

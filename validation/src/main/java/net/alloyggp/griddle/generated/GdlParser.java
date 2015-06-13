
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20150326 (SVN rev 63)
//----------------------------------------------------

package net.alloyggp.griddle.generated;

import java.util.LinkedList;
import java.util.List;

import java_cup.runtime.ComplexSymbolFactory.Location;
import net.alloyggp.griddle.grammar.Function;
import net.alloyggp.griddle.grammar.Literal;
import net.alloyggp.griddle.grammar.Rule;
import net.alloyggp.griddle.grammar.Sentence;
import net.alloyggp.griddle.grammar.Term;
import net.alloyggp.griddle.grammar.TopLevelGdl;

/** CUP v0.11b 20150326 (SVN rev 63) generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class GdlParser extends java_cup.runtime.lr_parser {

 @Override
public final Class getSymbolContainer() {
    return Symbols.class;
}

  /** Default constructor. */
  @Deprecated
  public GdlParser() {super();}

  /** Constructor which sets the default scanner. */
  @Deprecated
  public GdlParser(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public GdlParser(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] =
    unpackFromStrings(new String[] {
    "\000\030\000\002\002\004\000\002\002\004\000\002\002" +
    "\002\000\002\003\003\000\002\003\003\000\002\004\007" +
    "\000\002\005\003\000\002\005\006\000\002\006\004\000" +
    "\002\006\002\000\002\007\003\000\002\007\006\000\002" +
    "\007\007\000\002\007\006\000\002\010\004\000\002\010" +
    "\002\000\002\011\003\000\002\011\003\000\002\011\003" +
    "\000\002\011\003\000\002\011\003\000\002\011\003\000" +
    "\002\011\003\000\002\012\006" });

  /** Access to production table. */
  @Override
public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table =
    unpackFromStrings(new String[] {
    "\000\051\000\010\002\uffff\005\uffff\012\uffff\001\002\000" +
    "\010\002\012\005\006\012\005\001\002\000\012\002\ufffb" +
    "\005\ufffb\006\ufffb\012\ufffb\001\002\000\006\004\013\012" +
    "\014\001\002\000\010\002\001\005\001\012\001\001\002" +
    "\000\010\002\ufffd\005\ufffd\012\ufffd\001\002\000\010\002" +
    "\ufffe\005\ufffe\012\ufffe\001\002\000\004\002\000\001\002" +
    "\000\006\005\033\012\005\001\002\000\022\004\ufff2\005" +
    "\ufff2\006\ufff2\007\ufff2\010\ufff2\011\ufff2\012\ufff2\013\ufff2" +
    "\001\002\000\022\004\025\005\021\006\017\007\024\010" +
    "\027\011\026\012\016\013\023\001\002\000\022\004\ufff1" +
    "\005\ufff1\006\ufff1\007\ufff1\010\ufff1\011\ufff1\012\ufff1\013" +
    "\ufff1\001\002\000\012\002\ufffa\005\ufffa\006\ufffa\012\ufffa" +
    "\001\002\000\022\004\ufff3\005\ufff3\006\ufff3\007\ufff3\010" +
    "\ufff3\011\ufff3\012\ufff3\013\ufff3\001\002\000\004\012\030" +
    "\001\002\000\022\004\uffef\005\uffef\006\uffef\007\uffef\010" +
    "\uffef\011\uffef\012\uffef\013\uffef\001\002\000\022\004\ufff0" +
    "\005\ufff0\006\ufff0\007\ufff0\010\ufff0\011\ufff0\012\ufff0\013" +
    "\ufff0\001\002\000\022\004\uffed\005\uffed\006\uffed\007\uffed" +
    "\010\uffed\011\uffed\012\uffed\013\uffed\001\002\000\022\004" +
    "\uffee\005\uffee\006\uffee\007\uffee\010\uffee\011\uffee\012\uffee" +
    "\013\uffee\001\002\000\022\004\uffeb\005\uffeb\006\uffeb\007" +
    "\uffeb\010\uffeb\011\uffeb\012\uffeb\013\uffeb\001\002\000\022" +
    "\004\uffec\005\uffec\006\uffec\007\uffec\010\uffec\011\uffec\012" +
    "\uffec\013\uffec\001\002\000\022\004\ufff2\005\ufff2\006\ufff2" +
    "\007\ufff2\010\ufff2\011\ufff2\012\ufff2\013\ufff2\001\002\000" +
    "\022\004\025\005\021\006\032\007\024\010\027\011\026" +
    "\012\016\013\023\001\002\000\022\004\uffea\005\uffea\006" +
    "\uffea\007\uffea\010\uffea\011\uffea\012\uffea\013\uffea\001\002" +
    "\000\004\012\014\001\002\000\010\005\ufff8\006\ufff8\012" +
    "\ufff8\001\002\000\010\005\036\006\041\012\005\001\002" +
    "\000\012\007\042\010\044\011\043\012\014\001\002\000" +
    "\010\005\ufff9\006\ufff9\012\ufff9\001\002\000\010\005\ufff7" +
    "\006\ufff7\012\ufff7\001\002\000\010\002\ufffc\005\ufffc\012" +
    "\ufffc\001\002\000\020\004\025\005\021\007\024\010\027" +
    "\011\026\012\016\013\023\001\002\000\006\005\036\012" +
    "\005\001\002\000\010\005\ufff8\006\ufff8\012\ufff8\001\002" +
    "\000\010\005\036\006\046\012\005\001\002\000\010\005" +
    "\ufff4\006\ufff4\012\ufff4\001\002\000\004\006\050\001\002" +
    "\000\010\005\ufff6\006\ufff6\012\ufff6\001\002\000\020\004" +
    "\025\005\021\007\024\010\027\011\026\012\016\013\023" +
    "\001\002\000\004\006\053\001\002\000\010\005\ufff5\006" +
    "\ufff5\012\ufff5\001\002" });

  /** Access to parse-action table. */
  @Override
public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table =
    unpackFromStrings(new String[] {
    "\000\051\000\004\002\003\001\001\000\010\003\006\004" +
    "\010\005\007\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\004\005\033\001\001\000\004\010\014" +
    "\001\001\000\006\011\017\012\021\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\004" +
    "\010\030\001\001\000\006\011\017\012\021\001\001\000" +
    "\002\001\001\000\002\001\001\000\004\006\034\001\001" +
    "\000\006\005\037\007\036\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\006" +
    "\011\050\012\021\001\001\000\006\005\037\007\046\001" +
    "\001\000\004\006\044\001\001\000\006\005\037\007\036" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\006\011\051\012\021\001\001\000\002\001\001" +
    "\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  @Override
public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$GdlParser$actions action_obj;

  /** Action encapsulation object initializer. */
  @Override
protected void init_actions()
    {
      action_obj = new CUP$GdlParser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  @Override
public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$GdlParser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  @Override
public int start_state() {return 0;}
  /** Indicates start production. */
  @Override
public int start_production() {return 1;}

  /** <code>EOF</code> Symbol index. */
  @Override
public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  @Override
public int error_sym() {return 1;}






/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$GdlParser$actions {
  private final GdlParser parser;

  /** Constructor */
  CUP$GdlParser$actions(GdlParser parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$GdlParser$do_action_part00000000(
    int                        CUP$GdlParser$act_num,
    java_cup.runtime.lr_parser CUP$GdlParser$parser,
    java.util.Stack            CUP$GdlParser$stack,
    int                        CUP$GdlParser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$GdlParser$result;

      /* select the action based on the action number */
      switch (CUP$GdlParser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // game ::= game toplevel
            {
              List<TopLevelGdl> RESULT =null;
		Location gxleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$GdlParser$stack.elementAt(CUP$GdlParser$top-1)).xleft;
		Location gxright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$GdlParser$stack.elementAt(CUP$GdlParser$top-1)).xright;
		List<TopLevelGdl> g = (List<TopLevelGdl>)((java_cup.runtime.Symbol) CUP$GdlParser$stack.elementAt(CUP$GdlParser$top-1)).value;
		Location tlxleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$GdlParser$stack.peek()).xleft;
		Location tlxright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$GdlParser$stack.peek()).xright;
		TopLevelGdl tl = (TopLevelGdl)((java_cup.runtime.Symbol) CUP$GdlParser$stack.peek()).value;
		 g.add(tl); RESULT = g;
              CUP$GdlParser$result = parser.getSymbolFactory().newSymbol("game",0, ((java_cup.runtime.Symbol)CUP$GdlParser$stack.elementAt(CUP$GdlParser$top-1)), ((java_cup.runtime.Symbol)CUP$GdlParser$stack.peek()), RESULT);
            }
          return CUP$GdlParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // $START ::= game EOF
            {
              Object RESULT =null;
		Location start_valxleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$GdlParser$stack.elementAt(CUP$GdlParser$top-1)).xleft;
		Location start_valxright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$GdlParser$stack.elementAt(CUP$GdlParser$top-1)).xright;
		List<TopLevelGdl> start_val = (List<TopLevelGdl>)((java_cup.runtime.Symbol) CUP$GdlParser$stack.elementAt(CUP$GdlParser$top-1)).value;
		RESULT = start_val;
              CUP$GdlParser$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$GdlParser$stack.elementAt(CUP$GdlParser$top-1)), ((java_cup.runtime.Symbol)CUP$GdlParser$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$GdlParser$parser.done_parsing();
          return CUP$GdlParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // game ::=
            {
              List<TopLevelGdl> RESULT =null;
		 RESULT = new LinkedList<TopLevelGdl>();
              CUP$GdlParser$result = parser.getSymbolFactory().newSymbol("game",0, ((java_cup.runtime.Symbol)CUP$GdlParser$stack.peek()), RESULT);
            }
          return CUP$GdlParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // toplevel ::= rule
            {
              TopLevelGdl RESULT =null;
		Location rxleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$GdlParser$stack.peek()).xleft;
		Location rxright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$GdlParser$stack.peek()).xright;
		Rule r = (Rule)((java_cup.runtime.Symbol) CUP$GdlParser$stack.peek()).value;
		 RESULT = TopLevelGdl.create(r, rxleft, rxright);
              CUP$GdlParser$result = parser.getSymbolFactory().newSymbol("toplevel",1, ((java_cup.runtime.Symbol)CUP$GdlParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$GdlParser$stack.peek()), RESULT);
            }
          return CUP$GdlParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // toplevel ::= sentence
            {
              TopLevelGdl RESULT =null;
		Location sxleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$GdlParser$stack.peek()).xleft;
		Location sxright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$GdlParser$stack.peek()).xright;
		Sentence s = (Sentence)((java_cup.runtime.Symbol) CUP$GdlParser$stack.peek()).value;
		 RESULT = TopLevelGdl.create(s, sxleft, sxright);
              CUP$GdlParser$result = parser.getSymbolFactory().newSymbol("toplevel",1, ((java_cup.runtime.Symbol)CUP$GdlParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$GdlParser$stack.peek()), RESULT);
            }
          return CUP$GdlParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // rule ::= POPEN IMPLIES sentence literallist PCLOSE
            {
              Rule RESULT =null;
		Location plxleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$GdlParser$stack.elementAt(CUP$GdlParser$top-4)).xleft;
		Location plxright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$GdlParser$stack.elementAt(CUP$GdlParser$top-4)).xright;
		Object pl = (Object)((java_cup.runtime.Symbol) CUP$GdlParser$stack.elementAt(CUP$GdlParser$top-4)).value;
		Location sxleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$GdlParser$stack.elementAt(CUP$GdlParser$top-2)).xleft;
		Location sxright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$GdlParser$stack.elementAt(CUP$GdlParser$top-2)).xright;
		Sentence s = (Sentence)((java_cup.runtime.Symbol) CUP$GdlParser$stack.elementAt(CUP$GdlParser$top-2)).value;
		Location lsxleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$GdlParser$stack.elementAt(CUP$GdlParser$top-1)).xleft;
		Location lsxright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$GdlParser$stack.elementAt(CUP$GdlParser$top-1)).xright;
		List<Literal> ls = (List<Literal>)((java_cup.runtime.Symbol) CUP$GdlParser$stack.elementAt(CUP$GdlParser$top-1)).value;
		Location prxleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$GdlParser$stack.peek()).xleft;
		Location prxright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$GdlParser$stack.peek()).xright;
		Object pr = (Object)((java_cup.runtime.Symbol) CUP$GdlParser$stack.peek()).value;
		 RESULT = Rule.create(s, ls, plxleft, prxright);
              CUP$GdlParser$result = parser.getSymbolFactory().newSymbol("rule",2, ((java_cup.runtime.Symbol)CUP$GdlParser$stack.elementAt(CUP$GdlParser$top-4)), ((java_cup.runtime.Symbol)CUP$GdlParser$stack.peek()), RESULT);
            }
          return CUP$GdlParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // sentence ::= CONSTANT
            {
              Sentence RESULT =null;
		Location cxleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$GdlParser$stack.peek()).xleft;
		Location cxright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$GdlParser$stack.peek()).xright;
		String c = (String)((java_cup.runtime.Symbol) CUP$GdlParser$stack.peek()).value;
		 RESULT = Sentence.create(c, cxleft, cxright);
              CUP$GdlParser$result = parser.getSymbolFactory().newSymbol("sentence",3, ((java_cup.runtime.Symbol)CUP$GdlParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$GdlParser$stack.peek()), RESULT);
            }
          return CUP$GdlParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // sentence ::= POPEN CONSTANT termlist PCLOSE
            {
              Sentence RESULT =null;
		Location plxleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$GdlParser$stack.elementAt(CUP$GdlParser$top-3)).xleft;
		Location plxright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$GdlParser$stack.elementAt(CUP$GdlParser$top-3)).xright;
		Object pl = (Object)((java_cup.runtime.Symbol) CUP$GdlParser$stack.elementAt(CUP$GdlParser$top-3)).value;
		Location cxleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$GdlParser$stack.elementAt(CUP$GdlParser$top-2)).xleft;
		Location cxright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$GdlParser$stack.elementAt(CUP$GdlParser$top-2)).xright;
		String c = (String)((java_cup.runtime.Symbol) CUP$GdlParser$stack.elementAt(CUP$GdlParser$top-2)).value;
		Location tsxleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$GdlParser$stack.elementAt(CUP$GdlParser$top-1)).xleft;
		Location tsxright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$GdlParser$stack.elementAt(CUP$GdlParser$top-1)).xright;
		List<Term> ts = (List<Term>)((java_cup.runtime.Symbol) CUP$GdlParser$stack.elementAt(CUP$GdlParser$top-1)).value;
		Location prxleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$GdlParser$stack.peek()).xleft;
		Location prxright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$GdlParser$stack.peek()).xright;
		Object pr = (Object)((java_cup.runtime.Symbol) CUP$GdlParser$stack.peek()).value;
		 RESULT = Sentence.create(c, cxleft, cxright, ts, plxleft, prxright);
              CUP$GdlParser$result = parser.getSymbolFactory().newSymbol("sentence",3, ((java_cup.runtime.Symbol)CUP$GdlParser$stack.elementAt(CUP$GdlParser$top-3)), ((java_cup.runtime.Symbol)CUP$GdlParser$stack.peek()), RESULT);
            }
          return CUP$GdlParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // literallist ::= literallist literal
            {
              List<Literal> RESULT =null;
		Location lsxleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$GdlParser$stack.elementAt(CUP$GdlParser$top-1)).xleft;
		Location lsxright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$GdlParser$stack.elementAt(CUP$GdlParser$top-1)).xright;
		List<Literal> ls = (List<Literal>)((java_cup.runtime.Symbol) CUP$GdlParser$stack.elementAt(CUP$GdlParser$top-1)).value;
		Location lxleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$GdlParser$stack.peek()).xleft;
		Location lxright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$GdlParser$stack.peek()).xright;
		Literal l = (Literal)((java_cup.runtime.Symbol) CUP$GdlParser$stack.peek()).value;
		 ls.add(l); RESULT = ls;
              CUP$GdlParser$result = parser.getSymbolFactory().newSymbol("literallist",4, ((java_cup.runtime.Symbol)CUP$GdlParser$stack.elementAt(CUP$GdlParser$top-1)), ((java_cup.runtime.Symbol)CUP$GdlParser$stack.peek()), RESULT);
            }
          return CUP$GdlParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // literallist ::=
            {
              List<Literal> RESULT =null;
		 RESULT = new LinkedList<Literal>();
              CUP$GdlParser$result = parser.getSymbolFactory().newSymbol("literallist",4, ((java_cup.runtime.Symbol)CUP$GdlParser$stack.peek()), RESULT);
            }
          return CUP$GdlParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // literal ::= sentence
            {
              Literal RESULT =null;
		Location sxleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$GdlParser$stack.peek()).xleft;
		Location sxright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$GdlParser$stack.peek()).xright;
		Sentence s = (Sentence)((java_cup.runtime.Symbol) CUP$GdlParser$stack.peek()).value;
		 RESULT = Literal.createSentence(s, sxleft, sxright);
              CUP$GdlParser$result = parser.getSymbolFactory().newSymbol("literal",5, ((java_cup.runtime.Symbol)CUP$GdlParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$GdlParser$stack.peek()), RESULT);
            }
          return CUP$GdlParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // literal ::= POPEN NOT literal PCLOSE
            {
              Literal RESULT =null;
		Location plxleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$GdlParser$stack.elementAt(CUP$GdlParser$top-3)).xleft;
		Location plxright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$GdlParser$stack.elementAt(CUP$GdlParser$top-3)).xright;
		Object pl = (Object)((java_cup.runtime.Symbol) CUP$GdlParser$stack.elementAt(CUP$GdlParser$top-3)).value;
		Location lxleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$GdlParser$stack.elementAt(CUP$GdlParser$top-1)).xleft;
		Location lxright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$GdlParser$stack.elementAt(CUP$GdlParser$top-1)).xright;
		Literal l = (Literal)((java_cup.runtime.Symbol) CUP$GdlParser$stack.elementAt(CUP$GdlParser$top-1)).value;
		Location prxleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$GdlParser$stack.peek()).xleft;
		Location prxright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$GdlParser$stack.peek()).xright;
		Object pr = (Object)((java_cup.runtime.Symbol) CUP$GdlParser$stack.peek()).value;
		 RESULT = Literal.createNot(l, plxleft, prxright);
              CUP$GdlParser$result = parser.getSymbolFactory().newSymbol("literal",5, ((java_cup.runtime.Symbol)CUP$GdlParser$stack.elementAt(CUP$GdlParser$top-3)), ((java_cup.runtime.Symbol)CUP$GdlParser$stack.peek()), RESULT);
            }
          return CUP$GdlParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // literal ::= POPEN DISTINCT term term PCLOSE
            {
              Literal RESULT =null;
		Location plxleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$GdlParser$stack.elementAt(CUP$GdlParser$top-4)).xleft;
		Location plxright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$GdlParser$stack.elementAt(CUP$GdlParser$top-4)).xright;
		Object pl = (Object)((java_cup.runtime.Symbol) CUP$GdlParser$stack.elementAt(CUP$GdlParser$top-4)).value;
		Location t1xleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$GdlParser$stack.elementAt(CUP$GdlParser$top-2)).xleft;
		Location t1xright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$GdlParser$stack.elementAt(CUP$GdlParser$top-2)).xright;
		Term t1 = (Term)((java_cup.runtime.Symbol) CUP$GdlParser$stack.elementAt(CUP$GdlParser$top-2)).value;
		Location t2xleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$GdlParser$stack.elementAt(CUP$GdlParser$top-1)).xleft;
		Location t2xright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$GdlParser$stack.elementAt(CUP$GdlParser$top-1)).xright;
		Term t2 = (Term)((java_cup.runtime.Symbol) CUP$GdlParser$stack.elementAt(CUP$GdlParser$top-1)).value;
		Location prxleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$GdlParser$stack.peek()).xleft;
		Location prxright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$GdlParser$stack.peek()).xright;
		Object pr = (Object)((java_cup.runtime.Symbol) CUP$GdlParser$stack.peek()).value;
		 RESULT = Literal.createDistinct(t1, t2, plxleft, prxright);
              CUP$GdlParser$result = parser.getSymbolFactory().newSymbol("literal",5, ((java_cup.runtime.Symbol)CUP$GdlParser$stack.elementAt(CUP$GdlParser$top-4)), ((java_cup.runtime.Symbol)CUP$GdlParser$stack.peek()), RESULT);
            }
          return CUP$GdlParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // literal ::= POPEN OR literallist PCLOSE
            {
              Literal RESULT =null;
		Location plxleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$GdlParser$stack.elementAt(CUP$GdlParser$top-3)).xleft;
		Location plxright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$GdlParser$stack.elementAt(CUP$GdlParser$top-3)).xright;
		Object pl = (Object)((java_cup.runtime.Symbol) CUP$GdlParser$stack.elementAt(CUP$GdlParser$top-3)).value;
		Location lsxleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$GdlParser$stack.elementAt(CUP$GdlParser$top-1)).xleft;
		Location lsxright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$GdlParser$stack.elementAt(CUP$GdlParser$top-1)).xright;
		List<Literal> ls = (List<Literal>)((java_cup.runtime.Symbol) CUP$GdlParser$stack.elementAt(CUP$GdlParser$top-1)).value;
		Location prxleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$GdlParser$stack.peek()).xleft;
		Location prxright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$GdlParser$stack.peek()).xright;
		Object pr = (Object)((java_cup.runtime.Symbol) CUP$GdlParser$stack.peek()).value;
		 RESULT = Literal.createOr(ls, plxleft, prxright);
              CUP$GdlParser$result = parser.getSymbolFactory().newSymbol("literal",5, ((java_cup.runtime.Symbol)CUP$GdlParser$stack.elementAt(CUP$GdlParser$top-3)), ((java_cup.runtime.Symbol)CUP$GdlParser$stack.peek()), RESULT);
            }
          return CUP$GdlParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // termlist ::= termlist term
            {
              List<Term> RESULT =null;
		Location tsxleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$GdlParser$stack.elementAt(CUP$GdlParser$top-1)).xleft;
		Location tsxright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$GdlParser$stack.elementAt(CUP$GdlParser$top-1)).xright;
		List<Term> ts = (List<Term>)((java_cup.runtime.Symbol) CUP$GdlParser$stack.elementAt(CUP$GdlParser$top-1)).value;
		Location txleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$GdlParser$stack.peek()).xleft;
		Location txright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$GdlParser$stack.peek()).xright;
		Term t = (Term)((java_cup.runtime.Symbol) CUP$GdlParser$stack.peek()).value;
		 ts.add(t); RESULT = ts;
              CUP$GdlParser$result = parser.getSymbolFactory().newSymbol("termlist",6, ((java_cup.runtime.Symbol)CUP$GdlParser$stack.elementAt(CUP$GdlParser$top-1)), ((java_cup.runtime.Symbol)CUP$GdlParser$stack.peek()), RESULT);
            }
          return CUP$GdlParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // termlist ::=
            {
              List<Term> RESULT =null;
		 RESULT = new LinkedList<Term>();
              CUP$GdlParser$result = parser.getSymbolFactory().newSymbol("termlist",6, ((java_cup.runtime.Symbol)CUP$GdlParser$stack.peek()), RESULT);
            }
          return CUP$GdlParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // term ::= CONSTANT
            {
              Term RESULT =null;
		Location cxleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$GdlParser$stack.peek()).xleft;
		Location cxright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$GdlParser$stack.peek()).xright;
		String c = (String)((java_cup.runtime.Symbol) CUP$GdlParser$stack.peek()).value;
		 RESULT = Term.createConstant(c, cxleft, cxright);
              CUP$GdlParser$result = parser.getSymbolFactory().newSymbol("term",7, ((java_cup.runtime.Symbol)CUP$GdlParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$GdlParser$stack.peek()), RESULT);
            }
          return CUP$GdlParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // term ::= VARIABLE
            {
              Term RESULT =null;
		Location vxleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$GdlParser$stack.peek()).xleft;
		Location vxright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$GdlParser$stack.peek()).xright;
		String v = (String)((java_cup.runtime.Symbol) CUP$GdlParser$stack.peek()).value;
		 RESULT = Term.createVariable(v, vxleft, vxright);
              CUP$GdlParser$result = parser.getSymbolFactory().newSymbol("term",7, ((java_cup.runtime.Symbol)CUP$GdlParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$GdlParser$stack.peek()), RESULT);
            }
          return CUP$GdlParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // term ::= function
            {
              Term RESULT =null;
		Location fxleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$GdlParser$stack.peek()).xleft;
		Location fxright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$GdlParser$stack.peek()).xright;
		Function f = (Function)((java_cup.runtime.Symbol) CUP$GdlParser$stack.peek()).value;
		 RESULT = Term.createFunction(f, fxleft, fxright);
              CUP$GdlParser$result = parser.getSymbolFactory().newSymbol("term",7, ((java_cup.runtime.Symbol)CUP$GdlParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$GdlParser$stack.peek()), RESULT);
            }
          return CUP$GdlParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // term ::= IMPLIES
            {
              Term RESULT =null;
		Location ixleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$GdlParser$stack.peek()).xleft;
		Location ixright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$GdlParser$stack.peek()).xright;
		Object i = (Object)((java_cup.runtime.Symbol) CUP$GdlParser$stack.peek()).value;
		 RESULT = Term.createConstant("<=", ixleft, ixright);
              CUP$GdlParser$result = parser.getSymbolFactory().newSymbol("term",7, ((java_cup.runtime.Symbol)CUP$GdlParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$GdlParser$stack.peek()), RESULT);
            }
          return CUP$GdlParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // term ::= DISTINCT
            {
              Term RESULT =null;
		Location dxleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$GdlParser$stack.peek()).xleft;
		Location dxright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$GdlParser$stack.peek()).xright;
		Object d = (Object)((java_cup.runtime.Symbol) CUP$GdlParser$stack.peek()).value;
		 RESULT = Term.createConstant("distinct", dxleft, dxright);
              CUP$GdlParser$result = parser.getSymbolFactory().newSymbol("term",7, ((java_cup.runtime.Symbol)CUP$GdlParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$GdlParser$stack.peek()), RESULT);
            }
          return CUP$GdlParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // term ::= OR
            {
              Term RESULT =null;
		Location oxleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$GdlParser$stack.peek()).xleft;
		Location oxright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$GdlParser$stack.peek()).xright;
		Object o = (Object)((java_cup.runtime.Symbol) CUP$GdlParser$stack.peek()).value;
		 RESULT = Term.createConstant("or", oxleft, oxright);
              CUP$GdlParser$result = parser.getSymbolFactory().newSymbol("term",7, ((java_cup.runtime.Symbol)CUP$GdlParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$GdlParser$stack.peek()), RESULT);
            }
          return CUP$GdlParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 22: // term ::= NOT
            {
              Term RESULT =null;
		Location nxleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$GdlParser$stack.peek()).xleft;
		Location nxright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$GdlParser$stack.peek()).xright;
		Object n = (Object)((java_cup.runtime.Symbol) CUP$GdlParser$stack.peek()).value;
		 RESULT = Term.createConstant("not", nxleft, nxright);
              CUP$GdlParser$result = parser.getSymbolFactory().newSymbol("term",7, ((java_cup.runtime.Symbol)CUP$GdlParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$GdlParser$stack.peek()), RESULT);
            }
          return CUP$GdlParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 23: // function ::= POPEN CONSTANT termlist PCLOSE
            {
              Function RESULT =null;
		Location plxleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$GdlParser$stack.elementAt(CUP$GdlParser$top-3)).xleft;
		Location plxright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$GdlParser$stack.elementAt(CUP$GdlParser$top-3)).xright;
		Object pl = (Object)((java_cup.runtime.Symbol) CUP$GdlParser$stack.elementAt(CUP$GdlParser$top-3)).value;
		Location cxleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$GdlParser$stack.elementAt(CUP$GdlParser$top-2)).xleft;
		Location cxright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$GdlParser$stack.elementAt(CUP$GdlParser$top-2)).xright;
		String c = (String)((java_cup.runtime.Symbol) CUP$GdlParser$stack.elementAt(CUP$GdlParser$top-2)).value;
		Location tsxleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$GdlParser$stack.elementAt(CUP$GdlParser$top-1)).xleft;
		Location tsxright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$GdlParser$stack.elementAt(CUP$GdlParser$top-1)).xright;
		List<Term> ts = (List<Term>)((java_cup.runtime.Symbol) CUP$GdlParser$stack.elementAt(CUP$GdlParser$top-1)).value;
		Location prxleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$GdlParser$stack.peek()).xleft;
		Location prxright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$GdlParser$stack.peek()).xright;
		Object pr = (Object)((java_cup.runtime.Symbol) CUP$GdlParser$stack.peek()).value;
		 RESULT = Function.create(c, cxleft, cxright, ts, plxleft, prxright);
              CUP$GdlParser$result = parser.getSymbolFactory().newSymbol("function",8, ((java_cup.runtime.Symbol)CUP$GdlParser$stack.elementAt(CUP$GdlParser$top-3)), ((java_cup.runtime.Symbol)CUP$GdlParser$stack.peek()), RESULT);
            }
          return CUP$GdlParser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$GdlParser$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$GdlParser$do_action(
    int                        CUP$GdlParser$act_num,
    java_cup.runtime.lr_parser CUP$GdlParser$parser,
    java.util.Stack            CUP$GdlParser$stack,
    int                        CUP$GdlParser$top)
    throws java.lang.Exception
    {
              return CUP$GdlParser$do_action_part00000000(
                               CUP$GdlParser$act_num,
                               CUP$GdlParser$parser,
                               CUP$GdlParser$stack,
                               CUP$GdlParser$top);
    }
}

}

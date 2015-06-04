package net.alloyggp.griddle.generated;

import java_cup.runtime.*;

//Still working on this!
%%

%class GdlScanner
%unicode
%cupsym Symbols
%cup
%line
%column
%caseless

%{
    private Symbol symbol(int type) {
        return new Symbol(type, yyline, yycolumn);
    }
%}

LineTerminator = \r|\n|\r\n
InputCharacter = [^\r\n]
WhiteSpace     = {LineTerminator} | [ \t\f]
ConstantChar   = [^ \r\n\t\f()]
ConstantCharStart = [^ \r\n\t\f()?]

Comment = ";" {InputCharacter}* {LineTerminator}?

//TODO: Remove or use these
//POpen = "("
//PClose = ")"

Variable = "?" {ConstantChar}+
Constant = {ConstantCharStart} {ConstantChar}*

%%

//TODO: I think I can put this in a category of sorts
<YYINITIAL> "("         { return symbol(Symbols.POPEN); }
<YYINITIAL> ")"         { return symbol(Symbols.PCLOSE); }

<YYINITIAL> "<="        { return symbol(Symbols.IMPLIES); }

//The %caseless option makes this work regardless of case
<YYINITIAL> "distinct"  { return symbol(Symbols.DISTINCT); }
<YYINITIAL> "or"        { return symbol(Symbols.OR); }
<YYINITIAL> "not"       { return symbol(Symbols.NOT); }

<YYINITIAL> {Variable}  { return symbol(Symbols.VARIABLE); }
<YYINITIAL> {Constant}  { return symbol(Symbols.CONSTANT); }

<YYINITIAL> {Comment}   { /* ignore */ }
<YYINITIAL> {WhiteSpace} { /* ignore */ }

package net.alloyggp.griddle.generated;

import java_cup.runtime.ComplexSymbolFactory;
import java_cup.runtime.ComplexSymbolFactory.Location;
import java_cup.runtime.Symbol;

//Still working on this!
%%

%class GdlScanner
%apiprivate
%unicode
%cupsym Symbols
%cup
%char
%line
%column
%caseless

%{
    /*private Symbol symbol(int type) {
        return new Symbol(type, zzStartRead, zzMarkedPos);
    }
    private Symbol symbol(int type, Object value) {
        return new Symbol(type, zzStartRead, zzMarkedPos, value);
    }*/
    
    private Symbol symbol(int type) {
    	int length = zzMarkedPos - zzStartRead;
        return new ComplexSymbolFactory.ComplexSymbol("", type,
        		new Location(yyline, yycolumn, zzStartRead),
        		new Location(yyline, yycolumn + length, zzMarkedPos));
    }
    private Symbol symbol(int type, Object value) {
    	int length = zzMarkedPos - zzStartRead;
        return new ComplexSymbolFactory.ComplexSymbol("", type,
        		new Location(yyline, yycolumn, zzStartRead),
        		new Location(yyline, yycolumn + length, zzMarkedPos), value);
    }
%}

%eofval{
	return new java_cup.runtime.ComplexSymbolFactory.ComplexSymbol("", Symbols.EOF);
%eofval}

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

<YYINITIAL> {Variable}  { return symbol(Symbols.VARIABLE, yytext()); }
<YYINITIAL> {Constant}  { return symbol(Symbols.CONSTANT, yytext()); }

<YYINITIAL> {Comment}   { /* ignore */ }
<YYINITIAL> {WhiteSpace} { /* ignore */ }

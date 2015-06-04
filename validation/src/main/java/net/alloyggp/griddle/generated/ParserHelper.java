package net.alloyggp.griddle.generated;

import java.io.Reader;
import java.util.List;

import java_cup.runtime.DefaultSymbolFactory;
import java_cup.runtime.Scanner;
import java_cup.runtime.Symbol;
import java_cup.runtime.SymbolFactory;
import net.alloyggp.griddle.grammar.TopLevelGdl;

/*
 * This class isn't generated, but mediates access to the generated code
 * (which is largely package-private) from other packages.
 */
public class ParserHelper {
	private ParserHelper() {
		//Not instantiable
	}

	@SuppressWarnings("unchecked")
	public static List<TopLevelGdl> parse(Reader input) throws Exception {
		Scanner lexer = new GdlScanner(input);
//		SymbolFactory symbolFactory = new ComplexSymbolFactory();
		SymbolFactory symbolFactory = new DefaultSymbolFactory();
		Symbol result = new GdlParser(lexer, symbolFactory).parse();
		input.close();
		return (List<TopLevelGdl>) result;
	}
}

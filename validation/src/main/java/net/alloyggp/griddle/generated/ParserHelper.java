package net.alloyggp.griddle.generated;

import java.io.Reader;

import java_cup.runtime.ComplexSymbolFactory;
import java_cup.runtime.Scanner;
import java_cup.runtime.Symbol;
import java_cup.runtime.SymbolFactory;

/*
 * This class isn't generated, but mediates access to the generated code
 * (which is largely package-private) from other packages.
 */
public class ParserHelper {
	private ParserHelper() {
		//Not instantiable
	}

	public static Symbol parse(Reader input) throws Exception {
		Scanner lexer = new GdlScanner(input);
		SymbolFactory symbolFactory = new ComplexSymbolFactory();
		return new GdlParser(lexer, symbolFactory).parse();
	}
}

package net.alloyggp.griddle.validator;

public class Validators {
	private Validators() {
		//Not instantiable
	}

	public static Validator getStandardValidator() {
		//TODO: Add configurable validator...
		return ParenthesesValidator.INSTANCE;
	}
}

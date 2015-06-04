package net.alloyggp.griddle.validator;

public class Validators {
	private Validators() {
		//Not instantiable
	}

	public static Validator getStandardValidator() {
		//TODO: Add configurable validator...
		return CascadingValidator.create(
				ParenthesesValidator.INSTANCE,
				ConfigurableValidator.create(getStandardConfiguration()));
	}

	public static ValidatorConfiguration getStandardConfiguration() {
		return ValidatorConfiguration.createStandard();
	}
}
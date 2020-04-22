package Validation;




public class MasterCardValidator extends AbstractValidator {

	public MasterCardValidator(CardValidator app, String firstName, String surname, String address, String town,
			String county, String cardNumber, int month, int year) {
		super(app, firstName, surname, address, town, county, cardNumber, month, year);
	}

	protected boolean validateCardNumberFormat() {
		boolean errorInFormat = false;
		if (cardNumber.charAt(0) == '5' && (cardNumber.charAt(1) >= '1' && cardNumber.charAt(1) <= '5')) {

		} else {
			System.out.println("master Card format incorrect");
			errorInFormat = true;
		}
		return !errorInFormat;

	}

}

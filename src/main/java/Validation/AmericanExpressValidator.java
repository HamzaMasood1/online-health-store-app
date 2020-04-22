package Validation;

import javax.swing.JOptionPane;

public class AmericanExpressValidator extends AbstractValidator {

	public AmericanExpressValidator(CardValidator app, String firstName, String surname, String address, String town,
			String county, String cardNumber, int month, int year) {

		super(app, firstName, surname, address, town, county, cardNumber, month, year);
	}
	protected boolean validateCardNumberLength() {
		boolean errorInNumber = false;
		if (cardNumber.length() != 15 || cardNumber.length() != 16) {
			System.out.println("Card format incorrect");
			errorInNumber = true;
		} else {
			for (int i = 0; i < cardNumber.length(); i++) {
				if (cardNumber.charAt(i) > '9' || cardNumber.charAt(i) < '0') {
					System.out.println("Card format incorrect");
					errorInNumber = true;
				}
			}
		}
		return !errorInNumber;
	}

	protected boolean validateCardNumberFormat() {
		boolean errorInFormat = false;
		if (cardNumber.charAt(0) == '3' && (cardNumber.charAt(1) == '4' || cardNumber.charAt(1) == '7')) {
		} else {
			System.out.println("american Card format incorrect");
			errorInFormat = true;
		}
		return !errorInFormat;
	}
}

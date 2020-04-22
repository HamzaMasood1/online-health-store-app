package Validation;

import javax.swing.JOptionPane;

public class VisaValidator extends AbstractValidator {

	public VisaValidator(CardValidator app, String firstName, String surname, String address, String town,
			String county, String cardNumber, int month, int year) {
		super(app, firstName, surname, address, town, county, cardNumber, month, year);
	}
	protected boolean validateCardNumberFormat() {
		boolean errorInFormat = false;
		if (cardNumber.charAt(0) != '4') {
			System.out.println(" VISA Card format incorrect");
			errorInFormat = true;
		}
		return !errorInFormat;
	}
}

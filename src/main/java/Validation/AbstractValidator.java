package Validation;

import java.util.Calendar;

import javax.swing.JOptionPane;

//creating abstract class for common methods among other classes

public abstract class AbstractValidator {

	protected CardValidator app;

	protected String firstName;
	protected String surname;
	protected String address;
	protected String town;
	protected String county;
	protected String cardNumber;
	protected int month;
	protected int year;

	public AbstractValidator(CardValidator app, String firstName, String surname, String address, String town,
			String county, String cardNumber, int month, int year) {

		this.app = app;
		this.firstName = firstName;
		this.surname = surname;
		this.address = address;
		this.town = town;
		this.county = county;
		this.cardNumber = cardNumber;
		this.month = month;
		this.year = year;

	}

	public boolean validate() {

		boolean nameAddressValidated = validateNameAddress();

		if (nameAddressValidated) {

			boolean expiryDateValidated = validateExpiryDate();

			if (expiryDateValidated) {

				boolean cardNumberLengthValidated = validateCardNumberLength();

				if (cardNumberLengthValidated) {

					boolean cardNumberFormatValidated = validateCardNumberFormat();

					if (nameAddressValidated && expiryDateValidated && cardNumberLengthValidated
							&& cardNumberFormatValidated)
						return true;
					else
						return false;

				}
			}
		}

		return false;

	}

	protected boolean validateNameAddress() {

		boolean errorInName = false;

		if (firstName.length() == 0) {
			System.out.println("First Name Missing");
			errorInName = true;
		}
		if (surname.length() == 0) {
			System.out.println("Surname Missing");
			errorInName = true;
		}
		if (address.length() == 0) {
			System.out.println("Address Missing");
			errorInName = true;
		}
		if (town.length() == 0) {
			System.out.println("Town Missing");
			errorInName = true;
		}
		if (county.length() == 0) {
			System.out.println("County Missing");
			errorInName = true;
		}

		return !errorInName;
	}

	protected boolean validateExpiryDate() {

		boolean errorInDate = false;

		Calendar rightNow = Calendar.getInstance();

		int thisMonth = rightNow.get(Calendar.MONTH) + 1;

		int thisYear = rightNow.get(Calendar.YEAR);

		if (year < thisYear || (year == thisYear && month < thisMonth)) {

			errorInDate = true;

		}

		return !errorInDate;

	}

	protected boolean validateCardNumberLength() {

		boolean errorInNumber = false;

		if (cardNumber.length() != 16) {

			errorInNumber = true;

		} else {

			for (int i = 0; i < 16; i++) {

				if (cardNumber.charAt(i) > '9' || cardNumber.charAt(i) < '0') {

					errorInNumber = true;

				}
			}
		}

		return !errorInNumber;

	}

	protected boolean validateCardNumberFormat() {

		return false;

	}

}

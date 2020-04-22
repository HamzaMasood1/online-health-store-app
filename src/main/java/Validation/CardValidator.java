package Validation;

import javax.swing.*;

import org.springframework.stereotype.Service;

import entities.Card;

import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import java.util.Date;

@Service
public class CardValidator {

	JButton validateSaveButton, cancelButton;
	JLabel firstNameLabel, surnameLabel, addressLabel, townLabel, countyLabel, cardNumberLabel, cardTypeLabel,
			expiryDateLabel;
	JTextField firstNameTextField, surnameTextField, addressTextField, townTextField, countyTextField,
			cardNumberTextField;
	JComboBox<String> cardTypeComboBox, monthComboBox, yearComboBox;
	String[] months = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" };
	String[] years = { "2019", "2020", "2021", "2022", "2023" };
	String[] cardTypes = { "Visa", "MasterCard", "AmericanExpress" };

	public CardValidator() {

	}

	public Card initComponents(Card card) {
		String firstName = card.getFirstName();
		String surname = card.getSurname();
		String address = card.getAddress();
		String town = card.getTown();
		String county = card.getCounty();
		String cardNumber = card.getCardNumber();
		int cardType = card.getCardType();
		int month = card.getExpiryMonth();
		int year = card.getExpiryYear();

		boolean result = false;

		AbstractValidator validator = null;

		if (cardType == 1) {

			validator = new VisaValidator(CardValidator.this, firstName, surname, address, town, county, cardNumber,
					month, year);

		} else if (cardType == 2) {

			validator = new MasterCardValidator(CardValidator.this, firstName, surname, address, town, county,
					cardNumber, month, year);

		} else if (cardType == 3) {

			validator = new AmericanExpressValidator(CardValidator.this, firstName, surname, address, town, county,
					cardNumber, month, year);

		}

		if (validator != null) {

			result = validator.validate();

			if (result) {

				Card validatedCard = new Card(firstName, surname, address, town, county, cardNumber, cardType, month,
						year);
				System.out.println("card successfully validated");
				return validatedCard;

			}
		}
		return null;

	}

	private void clearFields() {

		firstNameTextField.setText("");
		surnameTextField.setText("");
		addressTextField.setText("");
		townTextField.setText("");
		countyTextField.setText("");
		cardNumberTextField.setText("");
		cardTypeComboBox.setSelectedIndex(0);
		monthComboBox.setSelectedIndex(0);
		yearComboBox.setSelectedIndex(0);

	}

}

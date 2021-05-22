package eCommerceSystem.core;

import java.util.regex.Pattern;

import eCommerceSystem.entities.concretes.User;

public class UserValidationManager implements UserValidationService{
	
	private static final Pattern VALID_EMAIL_TYPE = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	private static final Pattern VALID_FIRSTNAME_TYPE = Pattern.compile("^[\\p{L}A-Z a-z]{2,}$", Pattern.CASE_INSENSITIVE);
	private static final Pattern VALID_LASTNAME_TYPE = Pattern.compile("^[\\p{L}A-Z a-z]{2,}$", Pattern.CASE_INSENSITIVE);
	private static final Pattern VALID_PASSWORD_TYPE = Pattern.compile("^(?=.[0-9A-Za-z@#$%*?^:;+-._,]).{6,}$", Pattern.CASE_INSENSITIVE);
	
	@Override
	public boolean registerValidate(User user) {
		boolean result = isEmailFormatValid(user.getEmail()) && isFirstNameFormatValid(user.getFirstName()) &&
				isLastNameFormatValid(user.getLastName()) && isPasswordFormatValid(user.getPassword()) ;
	
		return result;
	}

	@Override
	public boolean loginValidate(String email, String password) {
		boolean result = isEmailFormatValid(email) && isPasswordFormatValid(password);
		
		return result;
	}

	
	private boolean isEmailFormatValid(String email) {
		return VALID_EMAIL_TYPE.matcher(email).find();
	}
	
	private boolean isFirstNameFormatValid(String firstName) {
		return VALID_FIRSTNAME_TYPE.matcher(firstName).find();
	}
	
	private boolean isLastNameFormatValid(String lastName) {
		return VALID_LASTNAME_TYPE.matcher(lastName).find();
	}
	private boolean isPasswordFormatValid(String password) {
		return VALID_PASSWORD_TYPE.matcher(password).find();
	}
	
}

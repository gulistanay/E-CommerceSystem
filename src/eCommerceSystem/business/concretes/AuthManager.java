package eCommerceSystem.business.concretes;

import eCommerceSystem.business.abstracts.AuthService;
import eCommerceSystem.business.abstracts.UserService;
import eCommerceSystem.core.UserValidationService;
import eCommerceSystem.core.VerificationService;
import eCommerceSystem.entities.concretes.User;

public class AuthManager implements AuthService{
	UserService userService;
	UserValidationService userValidationService;
	VerificationService verificationService;
	
	public AuthManager() {}
	public AuthManager(UserService userService,UserValidationService userValidationService,VerificationService verificationService ) {
		this.userService = userService;
		this.userValidationService = userValidationService;
		this.verificationService = verificationService;
	}
	
	private boolean checkIfUserExists(String email) {
		return userService.getByMail(email) == null;
	}
	
	private boolean checkIfUserVerified(User user) {
		return verificationService.verificate(user);
	}
	
	
	@Override
	public boolean register(int id, String firstName, String lastName, String email, String password) {
		
		
		User toRegister = new User(id, firstName, lastName, email, password);
		if(!this.userValidationService.registerValidate(toRegister))
		{
			System.out.println("L�tfen bilgilerinizi kontrol ettikten sonra yeniden deneyin.");
			return false;
		}
		
		if(!checkIfUserExists(email))
		{
			System.out.println("Bu mail adresi sistemde mevcut. Giri� yapabilirsiniz.");
			return false;
		}
		if (!this.verificationService.verificate(toRegister)) {
			System.out.println("�yelik dogrulama i�lemi ba�ar�s�z!");
			return false;
		}

		userService.add(toRegister);
		return true;
		
	}
	@Override
	public void logIn(String email, String password) {
		
		if(!this.userValidationService.loginValidate(email, password))
		{
			System.out.println("Hatal� giri�! L�tfen bilgilerinizi kontrol edin.");
			return;
		}
		User userToLogin = userService.getByEmailAndPassword(email, password);
		
		if (userToLogin == null) {
			
			return;
		}
		if(!checkIfUserVerified(userToLogin)) 
		{
			System.out.println("Giri� yapabilmek i�in l�tfen mail kutunuza gelen aktivasyon linki ile hesab�n�z� do�rulay�n.");
			return;
		}
		System.out.println("Ba�ar�yla giri� yap�ld�: " + userToLogin.getEmail());
		
	}
	@Override
	public void logOut() {
		System.out.println("Ba�ar�yla ��k�� yap�ld�.");
		
	}
	
	
}

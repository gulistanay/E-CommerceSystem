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
			System.out.println("Lütfen bilgilerinizi kontrol ettikten sonra yeniden deneyin.");
			return false;
		}
		
		if(!checkIfUserExists(email))
		{
			System.out.println("Bu mail adresi sistemde mevcut. Giriþ yapabilirsiniz.");
			return false;
		}
		if (!this.verificationService.verificate(toRegister)) {
			System.out.println("Üyelik dogrulama iþlemi baþarýsýz!");
			return false;
		}

		userService.add(toRegister);
		return true;
		
	}
	@Override
	public void logIn(String email, String password) {
		
		if(!this.userValidationService.loginValidate(email, password))
		{
			System.out.println("Hatalý giriþ! Lütfen bilgilerinizi kontrol edin.");
			return;
		}
		User userToLogin = userService.getByEmailAndPassword(email, password);
		
		if (userToLogin == null) {
			
			return;
		}
		if(!checkIfUserVerified(userToLogin)) 
		{
			System.out.println("Giriþ yapabilmek için lütfen mail kutunuza gelen aktivasyon linki ile hesabýnýzý doðrulayýn.");
			return;
		}
		System.out.println("Baþarýyla giriþ yapýldý: " + userToLogin.getEmail());
		
	}
	@Override
	public void logOut() {
		System.out.println("Baþarýyla çýkýþ yapýldý.");
		
	}
	
	
}

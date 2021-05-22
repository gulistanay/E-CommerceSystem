package eCommerceSystem.core;

import eCommerceSystem.google.GoogleManager;

public class GoogleManagerAdapter implements GoogleService{

	@Override
	public void register(int id, String firstName, String lastName, String email, String password) {
		
		GoogleManager manager = new GoogleManager();
		//manager.signUp(2,"Buket" , "Ay", "buket@gmail.com", "123456");
		System.out.println("Google hesab� ile kay�t i�lemi ba�ar�yla ger�ekle�ti: " + email);
	}

	@Override
	public void logIn(String email, String password) {
		GoogleManager manager = new GoogleManager();
		//manager.login("buket@gmail.com", "123456");
		System.out.println("Google hesab� ile giri� yap�ld�: " + email);
		
	}

	@Override
	public void logOut() {
		GoogleService manager = new GoogleManagerAdapter();
		manager.logOut();
		System.out.println("Ba�ar�yla ��k�� yap�ld�.. ");
		
	}

}

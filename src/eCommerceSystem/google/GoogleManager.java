package eCommerceSystem.google;

public class GoogleManager {
	public boolean signUp(int id, String firstName, String lastName, String email, String password) {
		System.out.println("Google hesabý ile kayýt iþlemi gerçekleþti. Aktivasyon için lütfen mail kutunuzu kontrol edin.");
		return true;
	}
	public boolean login(String email, String password) {
		System.out.println("Google hesabý ile giriþ baþarýlý.");
		return true;
	}
}

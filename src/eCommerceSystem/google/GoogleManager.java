package eCommerceSystem.google;

public class GoogleManager {
	public boolean signUp(int id, String firstName, String lastName, String email, String password) {
		System.out.println("Google hesab� ile kay�t i�lemi ger�ekle�ti. Aktivasyon i�in l�tfen mail kutunuzu kontrol edin.");
		return true;
	}
	public boolean login(String email, String password) {
		System.out.println("Google hesab� ile giri� ba�ar�l�.");
		return true;
	}
}

package eCommerceSystem.business.abstracts;

public interface AuthService {
	boolean register(int id, String firstName, String lastName, String email, String password);
	void logIn(String email, String password);
	void logOut();
}

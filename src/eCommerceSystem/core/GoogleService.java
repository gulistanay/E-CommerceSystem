package eCommerceSystem.core;

public interface GoogleService {
	void register(int id, String firstName, String lastName, String email, String password);
	void logIn(String email, String password);
	void logOut();
}

package eCommerceSystem.business.abstracts;

import java.util.List;

import eCommerceSystem.entities.concretes.User;

public interface UserService {
	void add(User user);
	void update(User user);
	void delete(User user);
	
	User getByMail(String email);
	List<User> getAll();
	User getByEmailAndPassword(String email, String password);
}

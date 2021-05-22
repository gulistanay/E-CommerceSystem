package eCommerceSystem.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import eCommerceSystem.dataAccess.abstracts.UserDao;
import eCommerceSystem.entities.concretes.User;

public class HibernateUserDao implements UserDao{
	
	List<User> users = new ArrayList<User>();

	@Override
	public void add(User user) {
		users.add(user);
		System.out.println("Kullan�c� hibernate ile veritab�n�na eklendi: " + user.getEmail());
		
	}

	@Override
	public void update(User user) {
		System.out.println("Kullan�c� bilgileri g�ncellendi. " + user.getEmail());
		
	}

	@Override
	public void delete(User user) {
		System.out.println("Kullan�c� silindi.");
		
	}

	@Override
	public User getByMail(String email) {
		for (User user : users) {
			if (user.getEmail()==email) {
				return user;
			}
		}
		return null;
	}

	@Override
	public List<User> getAll() {
		return users;
	}
	
	
}

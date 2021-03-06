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
		System.out.println("Kullanıcı hibernate ile veritabınına eklendi: " + user.getEmail());
		
	}

	@Override
	public void update(User user) {
		System.out.println("Kullanıcı bilgileri güncellendi. " + user.getEmail());
		
	}

	@Override
	public void delete(User user) {
		System.out.println("Kullanıcı silindi.");
		
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

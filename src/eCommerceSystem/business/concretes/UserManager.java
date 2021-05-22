package eCommerceSystem.business.concretes;

import java.util.List;

import eCommerceSystem.business.abstracts.UserService;
import eCommerceSystem.dataAccess.abstracts.UserDao;
import eCommerceSystem.entities.concretes.User;

public class UserManager implements UserService{
	
	UserDao userDao;
	public UserManager(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void add(User user) {
		userDao.add(user);
		System.out.println("Kullanýcý eklendi: " + user.getEmail());
		
	}

	@Override
	public void update(User user) {
		userDao.update(user);
		System.out.println("Kullanýcý bilgileri baþarýyla güncellendi: " + user.getEmail());
		
	}

	@Override
	public void delete(User user) {
		userDao.delete(user);
		System.out.println("Kullanýcý silindi: " + user.getEmail());
		
	}

	@Override
	public User getByMail(String email) {
		return userDao.getByMail(email);
	}

	@Override
	public List<User> getAll() {
		return userDao.getAll();
	}

	@Override
	public User getByEmailAndPassword(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}

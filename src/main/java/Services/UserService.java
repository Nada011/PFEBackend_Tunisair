package Services;

import java.util.List;

import Entities.User;


public interface UserService {
	
	public User updateUser(User user);

	public User addUser(User user);

	public List<User> getAllUsers();
	
	public void deleletUser(Long id);

	
}

package Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import Repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import Entities.User;

@Service
public class UserServiceImpl implements UserService {

	
	private   UserRepository UserRepository ;
	
	
	

	
	
	
	
	@Override
	public List<User> getAllUsers() {
		
		return UserRepository.findAll();
	}

	
	@Override
	public User addUser(User user) {
		return UserRepository.save(user);
	}

	@Override
	public User updateUser(User user) {
	Optional <User> utOptional = UserRepository.findById(user.getId());
		
		if (utOptional.isEmpty()) {
			return null;
		}else {
			return UserRepository.save(user);
		}
	}

	@Override
	public void deleletUser(Long id) {
		UserRepository.deleteById(id);
		
	}







	

}

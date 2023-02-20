package Controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import Entities.User;
import Services.UserService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Admin")
public class UserController {
	@Autowired
	private final  UserService UserService;
	
	@GetMapping("/user")
	public ResponseEntity <List<User>> getAllUsers() {
		return ResponseEntity.ok().body(UserService.getAllUsers());
	}
	
	@PutMapping ("user/update")
	public ResponseEntity <User> updateUsers(@RequestBody User user) {
		return ResponseEntity.ok().body(UserService.updateUser(user));
	}
	
	@PostMapping ("user/add")
	public ResponseEntity <User> createUsers(@RequestBody User user) {
		URI uri=URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("Admin/user/add").toUriString());
		return ResponseEntity.created(uri).body(UserService.addUser(user));
	}
	
	@DeleteMapping("user/delete/{id}")
	public ResponseEntity <String> deleteUser(@PathVariable("id") Long id) {
		try {
			UserService.deleletUser(id);}
			catch(Exception e){
				return new ResponseEntity<String>("ERROR",HttpStatus.INTERNAL_SERVER_ERROR);
			}
			return new ResponseEntity<>("DELETED",HttpStatus.OK);
	}
	

}

package sv.mh.fe.controller;

import java.util.List;
import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sv.mh.fe.models.User;
import sv.mh.fe.repositories.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserRepository repository;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<User> getAll() {
		return repository.findAll();

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public User getById(@PathVariable("id") ObjectId id) {
		return repository.findBy_id(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void modifyById(@PathVariable("id") ObjectId id, @Valid @RequestBody User user) {
		user.set_id(id);
		repository.save(user);
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public User create(@Valid @RequestBody User user) {
		user.set_id(ObjectId.get());		
		repository.save(user);
		return user;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable ObjectId id) {
		repository.delete(repository.findBy_id(id));
	}	
}

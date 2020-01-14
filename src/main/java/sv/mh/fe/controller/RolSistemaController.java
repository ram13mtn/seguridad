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
import sv.mh.fe.models.RolSistema;
import sv.mh.fe.repositories.RolSistemaRepository;

@RestController
@RequestMapping("/rolsistema")
public class RolSistemaController {
	
	@Autowired
	private RolSistemaRepository repository;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<RolSistema> getAll() {
		return repository.findAll();

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public RolSistema getById(@PathVariable("id") ObjectId id) {
		return repository.findBy_id(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void modifyById(@PathVariable("id") ObjectId id, @Valid @RequestBody RolSistema user) {
		user.set_id(id);
		repository.save(user);
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public RolSistema create(@Valid @RequestBody RolSistema user) {
		user.set_id(ObjectId.get());		
		repository.save(user);
		return user;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable ObjectId id) {
		repository.delete(repository.findBy_id(id));
	}	
}

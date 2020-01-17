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
import sv.mh.fe.models.AccionSistema;
import sv.mh.fe.repositories.AccionSistemaRepository;

@RestController
@RequestMapping("/accionsistema")
public class AccionSistemaController {
	
	@Autowired
	private AccionSistemaRepository repository;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<AccionSistema> getAll() {
		return repository.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public AccionSistema getById(@PathVariable("id") ObjectId id) {
		return repository.findBy_id(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void modifyById(@PathVariable("id") ObjectId id, @Valid @RequestBody AccionSistema user) {
		user.set_id(id);
		repository.save(user);
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public AccionSistema create(@Valid @RequestBody AccionSistema user) {
		user.set_id(ObjectId.get());		
		repository.save(user);
		return user;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable ObjectId id) {
		repository.delete(repository.findBy_id(id));
	}	
}

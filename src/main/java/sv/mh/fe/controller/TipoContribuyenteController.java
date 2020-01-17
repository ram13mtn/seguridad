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
import sv.mh.fe.models.TipoContribuyente;
import sv.mh.fe.repositories.TipoContribuyenteRepository;

@RestController
@RequestMapping("/tipocontribuyente")
public class TipoContribuyenteController {
	
	@Autowired
	private TipoContribuyenteRepository repository;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<TipoContribuyente> getAll() {
		return repository.findAll();

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public TipoContribuyente getById(@PathVariable("id") ObjectId id) {
		return repository.findBy_id(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void modifyById(@PathVariable("id") ObjectId id, @Valid @RequestBody TipoContribuyente documento) {
		documento.set_id(id);
		repository.save(documento);
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public TipoContribuyente create(@Valid @RequestBody TipoContribuyente documento) {
		documento.set_id(ObjectId.get());		
		repository.save(documento);
		return documento;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable ObjectId id) {
		repository.delete(repository.findBy_id(id));
	}	
}

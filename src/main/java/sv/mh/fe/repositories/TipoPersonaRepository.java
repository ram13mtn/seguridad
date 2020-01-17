package sv.mh.fe.repositories;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import sv.mh.fe.models.TipoPersona;


public interface TipoPersonaRepository extends MongoRepository<TipoPersona, String>{
	  
	TipoPersona findBy_id(ObjectId _id);	
	List<TipoPersona> findByNombre(String nombre);
	
}
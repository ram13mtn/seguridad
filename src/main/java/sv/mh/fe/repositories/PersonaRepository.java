package sv.mh.fe.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import sv.mh.fe.models.Persona;


public interface PersonaRepository extends MongoRepository<Persona, String>{
	  
	Persona findBy_id(ObjectId _id);
	
}
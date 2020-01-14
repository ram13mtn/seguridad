package sv.mh.fe.repositories;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import sv.mh.fe.models.AccionSistema;
import sv.mh.fe.models.User;


public interface AccionSistemaRepository extends MongoRepository<AccionSistema, String>{
	  
	AccionSistema findBy_id(ObjectId _id);	
	List<AccionSistema> findByNombre(String nombre);
	
}
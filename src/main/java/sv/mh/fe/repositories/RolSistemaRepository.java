package sv.mh.fe.repositories;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import sv.mh.fe.models.RolSistema;


public interface RolSistemaRepository extends MongoRepository<RolSistema, String>{
	  
	RolSistema findBy_id(ObjectId _id);	
	List<RolSistema> findByNombre(String nombre);
	List<RolSistema> findByRolSuperior(RolSistema rolSuperior);
	
}
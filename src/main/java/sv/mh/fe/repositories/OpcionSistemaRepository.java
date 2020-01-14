package sv.mh.fe.repositories;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import sv.mh.fe.models.OpcionSistema;


public interface OpcionSistemaRepository extends MongoRepository<OpcionSistema, String>{
	  
	OpcionSistema findBy_id(ObjectId _id);	
	List<OpcionSistema> findByNombre(String nombre);
	List<OpcionSistema> findByOpcionSuperior(OpcionSistema opcionSuperior);
}
package sv.mh.fe.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import sv.mh.fe.models.TipoContribuyente;


public interface TipoContribuyenteRepository extends MongoRepository<TipoContribuyente, String>{
	  
	TipoContribuyente findBy_id(ObjectId _id);
	
}
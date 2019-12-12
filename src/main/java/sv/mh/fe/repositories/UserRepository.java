package sv.mh.fe.repositories;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import sv.mh.fe.models.User;


public interface UserRepository extends MongoRepository<User, String>{
	  
	User findBy_id(ObjectId _id);
	
	List<User> findByUserAndPwd(String user, String pwd);
	
}
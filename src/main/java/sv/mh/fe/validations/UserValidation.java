package sv.mh.fe.validations;

import sv.mh.fe.models.User;

public class UserValidation {
	
	public boolean mandatoryData(User user) {
		if(user.getNit().equals("")) {
			
		}
		return  true;
	}
	
}

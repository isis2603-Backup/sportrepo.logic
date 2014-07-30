
package co.edu.uniandes.csw.user.logic.ejb;
import java.util.List;
import javax.inject.Inject;

import co.edu.uniandes.csw.user.logic.dto.UserDTO;
import co.edu.uniandes.csw.user.logic.api._IUserLogicService;
import co.edu.uniandes.csw.user.persistence.api.IUserPersistence;

public abstract class _UserLogicService implements _IUserLogicService {

	@Inject
	protected IUserPersistence persistance;

	public UserDTO createUser(UserDTO user){
		return persistance.createUser( user); 
    }

	public List<UserDTO> getUsers(){
		return persistance.getUsers(); 
	}

	public UserDTO getUser(Long id){
		return persistance.getUser(id); 
	}

	public void deleteUser(Long id){
	    persistance.deleteUser(id); 
	}

	public void updateUser(UserDTO user){
	    persistance.updateUser(user); 
	}	
}
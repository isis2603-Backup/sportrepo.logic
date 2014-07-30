
package co.edu.uniandes.csw.role.logic.ejb;
import java.util.List;
import javax.inject.Inject;

import co.edu.uniandes.csw.role.logic.dto.RoleDTO;
import co.edu.uniandes.csw.role.logic.api._IRoleLogicService;
import co.edu.uniandes.csw.role.persistence.api.IRolePersistence;

public abstract class _RoleLogicService implements _IRoleLogicService {

	@Inject
	protected IRolePersistence persistance;

	public RoleDTO createRole(RoleDTO role){
		return persistance.createRole( role); 
    }

	public List<RoleDTO> getRoles(){
		return persistance.getRoles(); 
	}

	public RoleDTO getRole(Long id){
		return persistance.getRole(id); 
	}

	public void deleteRole(Long id){
	    persistance.deleteRole(id); 
	}

	public void updateRole(RoleDTO role){
	    persistance.updateRole(role); 
	}	
}
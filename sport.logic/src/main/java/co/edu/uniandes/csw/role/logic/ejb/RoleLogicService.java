
package co.edu.uniandes.csw.role.logic.ejb;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless; 
import javax.inject.Inject;

import javax.enterprise.inject.Default;

import co.edu.uniandes.csw.role.logic.api.IRoleLogicService;

@Default
@Stateless
@LocalBean
public class RoleLogicService extends _RoleLogicService implements IRoleLogicService {

}
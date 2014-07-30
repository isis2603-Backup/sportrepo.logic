
package co.edu.uniandes.csw.user.logic.ejb;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless; 
import javax.inject.Inject;

import javax.enterprise.inject.Default;

import co.edu.uniandes.csw.user.logic.api.IUserLogicService;

@Default
@Stateless
@LocalBean
public class UserLogicService extends _UserLogicService implements IUserLogicService {

}
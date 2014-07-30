package co.edu.uniandes.csw.user.master.persistence;

import javax.ejb.Stateless;

import co.edu.uniandes.csw.user.master.persistence.api.IUserMasterPersistence;
import javax.ejb.LocalBean;
import javax.enterprise.inject.Default;

@Default
@Stateless 
@LocalBean
public class UserMasterPersistence extends _UserMasterPersistence  implements IUserMasterPersistence {

}
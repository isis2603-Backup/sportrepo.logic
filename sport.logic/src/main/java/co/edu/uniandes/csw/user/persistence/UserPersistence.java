
package co.edu.uniandes.csw.user.persistence;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;

import co.edu.uniandes.csw.user.persistence.api.IUserPersistence;
import javax.ejb.LocalBean;

@Default
@Stateless 
@LocalBean
public class UserPersistence extends _UserPersistence  implements IUserPersistence {

}
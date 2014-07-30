
package co.edu.uniandes.csw.role.persistence;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;

import co.edu.uniandes.csw.role.persistence.api.IRolePersistence;
import javax.ejb.LocalBean;

@Default
@Stateless 
@LocalBean
public class RolePersistence extends _RolePersistence  implements IRolePersistence {

}
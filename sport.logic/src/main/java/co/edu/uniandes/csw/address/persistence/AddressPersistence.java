
package co.edu.uniandes.csw.address.persistence;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;

import co.edu.uniandes.csw.address.persistence.api.IAddressPersistence;
import javax.ejb.LocalBean;

@Default
@Stateless 
@LocalBean
public class AddressPersistence extends _AddressPersistence  implements IAddressPersistence {

}
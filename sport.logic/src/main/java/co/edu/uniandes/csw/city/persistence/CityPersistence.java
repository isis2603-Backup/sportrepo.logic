
package co.edu.uniandes.csw.city.persistence;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;

import co.edu.uniandes.csw.city.persistence.api.ICityPersistence;
import javax.ejb.LocalBean;

@Default
@Stateless 
@LocalBean
public class CityPersistence extends _CityPersistence  implements ICityPersistence {

}
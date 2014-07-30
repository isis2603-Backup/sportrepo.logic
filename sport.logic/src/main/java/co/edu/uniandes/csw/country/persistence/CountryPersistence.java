
package co.edu.uniandes.csw.country.persistence;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;

import co.edu.uniandes.csw.country.persistence.api.ICountryPersistence;
import javax.ejb.LocalBean;

@Default
@Stateless 
@LocalBean
public class CountryPersistence extends _CountryPersistence  implements ICountryPersistence {

}

package co.edu.uniandes.csw.country.logic.ejb;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless; 
import javax.inject.Inject;

import javax.enterprise.inject.Default;

import co.edu.uniandes.csw.country.logic.api.ICountryLogicService;

@Default
@Stateless
@LocalBean
public class CountryLogicService extends _CountryLogicService implements ICountryLogicService {

}
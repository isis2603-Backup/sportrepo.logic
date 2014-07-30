
package co.edu.uniandes.csw.city.logic.ejb;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless; 
import javax.inject.Inject;

import javax.enterprise.inject.Default;

import co.edu.uniandes.csw.city.logic.api.ICityLogicService;

@Default
@Stateless
@LocalBean
public class CityLogicService extends _CityLogicService implements ICityLogicService {

}
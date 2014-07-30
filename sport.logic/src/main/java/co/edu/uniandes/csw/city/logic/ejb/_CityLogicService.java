
package co.edu.uniandes.csw.city.logic.ejb;
import java.util.List;
import javax.inject.Inject;

import co.edu.uniandes.csw.city.logic.dto.CityDTO;
import co.edu.uniandes.csw.city.logic.api._ICityLogicService;
import co.edu.uniandes.csw.city.persistence.api.ICityPersistence;

public abstract class _CityLogicService implements _ICityLogicService {

	@Inject
	protected ICityPersistence persistance;

	public CityDTO createCity(CityDTO city){
		return persistance.createCity( city); 
    }

	public List<CityDTO> getCitys(){
		return persistance.getCitys(); 
	}

	public CityDTO getCity(Long id){
		return persistance.getCity(id); 
	}

	public void deleteCity(Long id){
	    persistance.deleteCity(id); 
	}

	public void updateCity(CityDTO city){
	    persistance.updateCity(city); 
	}	
}

package co.edu.uniandes.csw.country.logic.ejb;
import java.util.List;
import javax.inject.Inject;

import co.edu.uniandes.csw.country.logic.dto.CountryDTO;
import co.edu.uniandes.csw.country.logic.api._ICountryLogicService;
import co.edu.uniandes.csw.country.persistence.api.ICountryPersistence;

public abstract class _CountryLogicService implements _ICountryLogicService {

	@Inject
	protected ICountryPersistence persistance;

	public CountryDTO createCountry(CountryDTO country){
		return persistance.createCountry( country); 
    }

	public List<CountryDTO> getCountrys(){
		return persistance.getCountrys(); 
	}

	public CountryDTO getCountry(Long id){
		return persistance.getCountry(id); 
	}

	public void deleteCountry(Long id){
	    persistance.deleteCountry(id); 
	}

	public void updateCountry(CountryDTO country){
	    persistance.updateCountry(country); 
	}	
}
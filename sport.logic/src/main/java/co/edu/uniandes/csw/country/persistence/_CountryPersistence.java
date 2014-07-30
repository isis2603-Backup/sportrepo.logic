
package co.edu.uniandes.csw.country.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.edu.uniandes.csw.country.logic.dto.CountryDTO;
import co.edu.uniandes.csw.country.persistence.api._ICountryPersistence;
import co.edu.uniandes.csw.country.persistence.converter.CountryConverter;
import co.edu.uniandes.csw.country.persistence.entity.CountryEntity;

public abstract class _CountryPersistence implements _ICountryPersistence {

  	@PersistenceContext(unitName="sproyectoPU")
 
	protected EntityManager entityManager;
	
	public CountryDTO createCountry(CountryDTO country) {
		CountryEntity entity=CountryConverter.persistenceDTO2Entity(country);
		entityManager.persist(entity);
		return CountryConverter.entity2PersistenceDTO(entity);
	}

	@SuppressWarnings("unchecked")
	public List<CountryDTO> getCountrys() {
		Query q = entityManager.createQuery("select u from CountryEntity u");
		return CountryConverter.entity2PersistenceDTOList(q.getResultList());
	}

	public CountryDTO getCountry(Long id) {
		return CountryConverter.entity2PersistenceDTO(entityManager.find(CountryEntity.class, id));
	}

	public void deleteCountry(Long id) {
		CountryEntity entity=entityManager.find(CountryEntity.class, id);
		entityManager.remove(entity);
	}

	public void updateCountry(CountryDTO detail) {
		CountryEntity entity=entityManager.merge(CountryConverter.persistenceDTO2Entity(detail));
		CountryConverter.entity2PersistenceDTO(entity);
	}

}
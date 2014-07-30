
package co.edu.uniandes.csw.city.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.edu.uniandes.csw.city.logic.dto.CityDTO;
import co.edu.uniandes.csw.city.persistence.api._ICityPersistence;
import co.edu.uniandes.csw.city.persistence.converter.CityConverter;
import co.edu.uniandes.csw.city.persistence.entity.CityEntity;

public abstract class _CityPersistence implements _ICityPersistence {

  	@PersistenceContext(unitName="sproyectoPU")
 
	protected EntityManager entityManager;
	
	public CityDTO createCity(CityDTO city) {
		CityEntity entity=CityConverter.persistenceDTO2Entity(city);
		entityManager.persist(entity);
		return CityConverter.entity2PersistenceDTO(entity);
	}

	@SuppressWarnings("unchecked")
	public List<CityDTO> getCitys() {
		Query q = entityManager.createQuery("select u from CityEntity u");
		return CityConverter.entity2PersistenceDTOList(q.getResultList());
	}

	public CityDTO getCity(Long id) {
		return CityConverter.entity2PersistenceDTO(entityManager.find(CityEntity.class, id));
	}

	public void deleteCity(Long id) {
		CityEntity entity=entityManager.find(CityEntity.class, id);
		entityManager.remove(entity);
	}

	public void updateCity(CityDTO detail) {
		CityEntity entity=entityManager.merge(CityConverter.persistenceDTO2Entity(detail));
		CityConverter.entity2PersistenceDTO(entity);
	}

}
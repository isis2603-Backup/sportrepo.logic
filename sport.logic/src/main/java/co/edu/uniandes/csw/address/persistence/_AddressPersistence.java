
package co.edu.uniandes.csw.address.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.edu.uniandes.csw.address.logic.dto.AddressDTO;
import co.edu.uniandes.csw.address.persistence.api._IAddressPersistence;
import co.edu.uniandes.csw.address.persistence.converter.AddressConverter;
import co.edu.uniandes.csw.address.persistence.entity.AddressEntity;

public abstract class _AddressPersistence implements _IAddressPersistence {

  	@PersistenceContext(unitName="sproyectoPU")
 
	protected EntityManager entityManager;
	
	public AddressDTO createAddress(AddressDTO address) {
		AddressEntity entity=AddressConverter.persistenceDTO2Entity(address);
		entityManager.persist(entity);
		return AddressConverter.entity2PersistenceDTO(entity);
	}

	@SuppressWarnings("unchecked")
	public List<AddressDTO> getAddresss() {
		Query q = entityManager.createQuery("select u from AddressEntity u");
		return AddressConverter.entity2PersistenceDTOList(q.getResultList());
	}

	public AddressDTO getAddress(Long id) {
		return AddressConverter.entity2PersistenceDTO(entityManager.find(AddressEntity.class, id));
	}

	public void deleteAddress(Long id) {
		AddressEntity entity=entityManager.find(AddressEntity.class, id);
		entityManager.remove(entity);
	}

	public void updateAddress(AddressDTO detail) {
		AddressEntity entity=entityManager.merge(AddressConverter.persistenceDTO2Entity(detail));
		AddressConverter.entity2PersistenceDTO(entity);
	}

}
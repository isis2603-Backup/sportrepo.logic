
package co.edu.uniandes.csw.role.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.edu.uniandes.csw.role.logic.dto.RoleDTO;
import co.edu.uniandes.csw.role.persistence.api._IRolePersistence;
import co.edu.uniandes.csw.role.persistence.converter.RoleConverter;
import co.edu.uniandes.csw.role.persistence.entity.RoleEntity;

public abstract class _RolePersistence implements _IRolePersistence {

  	@PersistenceContext(unitName="sproyectoPU")
 
	protected EntityManager entityManager;
	
	public RoleDTO createRole(RoleDTO role) {
		RoleEntity entity=RoleConverter.persistenceDTO2Entity(role);
		entityManager.persist(entity);
		return RoleConverter.entity2PersistenceDTO(entity);
	}

	@SuppressWarnings("unchecked")
	public List<RoleDTO> getRoles() {
		Query q = entityManager.createQuery("select u from RoleEntity u");
		return RoleConverter.entity2PersistenceDTOList(q.getResultList());
	}

	public RoleDTO getRole(Long id) {
		return RoleConverter.entity2PersistenceDTO(entityManager.find(RoleEntity.class, id));
	}

	public void deleteRole(Long id) {
		RoleEntity entity=entityManager.find(RoleEntity.class, id);
		entityManager.remove(entity);
	}

	public void updateRole(RoleDTO detail) {
		RoleEntity entity=entityManager.merge(RoleConverter.persistenceDTO2Entity(detail));
		RoleConverter.entity2PersistenceDTO(entity);
	}

}
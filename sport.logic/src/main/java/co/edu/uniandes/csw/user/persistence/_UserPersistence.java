
package co.edu.uniandes.csw.user.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.edu.uniandes.csw.user.logic.dto.UserDTO;
import co.edu.uniandes.csw.user.persistence.api._IUserPersistence;
import co.edu.uniandes.csw.user.persistence.converter.UserConverter;
import co.edu.uniandes.csw.user.persistence.entity.UserEntity;

public abstract class _UserPersistence implements _IUserPersistence {

  	@PersistenceContext(unitName="sproyectoPU")
 
	protected EntityManager entityManager;
	
	public UserDTO createUser(UserDTO user) {
		UserEntity entity=UserConverter.persistenceDTO2Entity(user);
		entityManager.persist(entity);
		return UserConverter.entity2PersistenceDTO(entity);
	}

	@SuppressWarnings("unchecked")
	public List<UserDTO> getUsers() {
		Query q = entityManager.createQuery("select u from UserEntity u");
		return UserConverter.entity2PersistenceDTOList(q.getResultList());
	}

	public UserDTO getUser(Long id) {
		return UserConverter.entity2PersistenceDTO(entityManager.find(UserEntity.class, id));
	}

	public void deleteUser(Long id) {
		UserEntity entity=entityManager.find(UserEntity.class, id);
		entityManager.remove(entity);
	}

	public void updateUser(UserDTO detail) {
		UserEntity entity=entityManager.merge(UserConverter.persistenceDTO2Entity(detail));
		UserConverter.entity2PersistenceDTO(entity);
	}

}
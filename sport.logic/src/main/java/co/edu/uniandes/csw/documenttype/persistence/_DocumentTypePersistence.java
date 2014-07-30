
package co.edu.uniandes.csw.documenttype.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.edu.uniandes.csw.documenttype.logic.dto.DocumentTypeDTO;
import co.edu.uniandes.csw.documenttype.persistence.api._IDocumentTypePersistence;
import co.edu.uniandes.csw.documenttype.persistence.converter.DocumentTypeConverter;
import co.edu.uniandes.csw.documenttype.persistence.entity.DocumentTypeEntity;

public abstract class _DocumentTypePersistence implements _IDocumentTypePersistence {

  	@PersistenceContext(unitName="sproyectoPU")
 
	protected EntityManager entityManager;
	
	public DocumentTypeDTO createDocumentType(DocumentTypeDTO documentType) {
		DocumentTypeEntity entity=DocumentTypeConverter.persistenceDTO2Entity(documentType);
		entityManager.persist(entity);
		return DocumentTypeConverter.entity2PersistenceDTO(entity);
	}

	@SuppressWarnings("unchecked")
	public List<DocumentTypeDTO> getDocumentTypes() {
		Query q = entityManager.createQuery("select u from DocumentTypeEntity u");
		return DocumentTypeConverter.entity2PersistenceDTOList(q.getResultList());
	}

	public DocumentTypeDTO getDocumentType(Long id) {
		return DocumentTypeConverter.entity2PersistenceDTO(entityManager.find(DocumentTypeEntity.class, id));
	}

	public void deleteDocumentType(Long id) {
		DocumentTypeEntity entity=entityManager.find(DocumentTypeEntity.class, id);
		entityManager.remove(entity);
	}

	public void updateDocumentType(DocumentTypeDTO detail) {
		DocumentTypeEntity entity=entityManager.merge(DocumentTypeConverter.persistenceDTO2Entity(detail));
		DocumentTypeConverter.entity2PersistenceDTO(entity);
	}

}
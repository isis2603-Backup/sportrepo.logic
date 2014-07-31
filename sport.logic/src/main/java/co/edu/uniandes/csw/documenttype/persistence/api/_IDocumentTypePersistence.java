
package co.edu.uniandes.csw.documenttype.persistence.api;

import java.util.List; 

import co.edu.uniandes.csw.documenttype.logic.dto.DocumentTypeDTO;

public interface _IDocumentTypePersistence {

	public DocumentTypeDTO createDocumentType(DocumentTypeDTO detail);
	public List<DocumentTypeDTO> getDocumentTypes();
	public DocumentTypeDTO getDocumentType(Long id);
	public void deleteDocumentType(Long id);
	public void updateDocumentType(DocumentTypeDTO detail);
	
}
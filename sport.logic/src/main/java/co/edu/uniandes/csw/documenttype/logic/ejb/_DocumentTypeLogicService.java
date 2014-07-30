
package co.edu.uniandes.csw.documenttype.logic.ejb;
import java.util.List;
import javax.inject.Inject;

import co.edu.uniandes.csw.documenttype.logic.dto.DocumentTypeDTO;
import co.edu.uniandes.csw.documenttype.logic.api._IDocumentTypeLogicService;
import co.edu.uniandes.csw.documenttype.persistence.api.IDocumentTypePersistence;

public abstract class _DocumentTypeLogicService implements _IDocumentTypeLogicService {

	@Inject
	protected IDocumentTypePersistence persistance;

	public DocumentTypeDTO createDocumentType(DocumentTypeDTO documentType){
		return persistance.createDocumentType( documentType); 
    }

	public List<DocumentTypeDTO> getDocumentTypes(){
		return persistance.getDocumentTypes(); 
	}

	public DocumentTypeDTO getDocumentType(Long id){
		return persistance.getDocumentType(id); 
	}

	public void deleteDocumentType(Long id){
	    persistance.deleteDocumentType(id); 
	}

	public void updateDocumentType(DocumentTypeDTO documentType){
	    persistance.updateDocumentType(documentType); 
	}	
}
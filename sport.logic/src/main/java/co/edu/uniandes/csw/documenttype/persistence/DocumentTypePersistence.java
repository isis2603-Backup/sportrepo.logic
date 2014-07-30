
package co.edu.uniandes.csw.documenttype.persistence;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;

import co.edu.uniandes.csw.documenttype.persistence.api.IDocumentTypePersistence;
import javax.ejb.LocalBean;

@Default
@Stateless 
@LocalBean
public class DocumentTypePersistence extends _DocumentTypePersistence  implements IDocumentTypePersistence {

}
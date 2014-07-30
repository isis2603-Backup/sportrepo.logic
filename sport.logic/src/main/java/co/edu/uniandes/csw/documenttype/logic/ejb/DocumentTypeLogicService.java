
package co.edu.uniandes.csw.documenttype.logic.ejb;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless; 
import javax.inject.Inject;

import javax.enterprise.inject.Default;

import co.edu.uniandes.csw.documenttype.logic.api.IDocumentTypeLogicService;

@Default
@Stateless
@LocalBean
public class DocumentTypeLogicService extends _DocumentTypeLogicService implements IDocumentTypeLogicService {

}
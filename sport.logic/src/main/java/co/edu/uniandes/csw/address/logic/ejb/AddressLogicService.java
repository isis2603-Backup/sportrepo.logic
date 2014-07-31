package co.edu.uniandes.csw.address.logic.ejb;




import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless; 
import javax.inject.Inject;

import javax.enterprise.inject.Default;

import co.edu.uniandes.csw.address.logic.api.IAddressLogicService;

@Default
@Stateless
@LocalBean
public class AddressLogicService extends _AddressLogicService implements IAddressLogicService {

}
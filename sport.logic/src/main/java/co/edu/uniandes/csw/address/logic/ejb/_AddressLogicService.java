package co.edu.uniandes.csw.address.logic.ejb;



import java.util.List;
import javax.inject.Inject;

import co.edu.uniandes.csw.address.logic.dto.AddressDTO;
import co.edu.uniandes.csw.address.logic.api._IAddressLogicService;
import co.edu.uniandes.csw.address.persistence.api.IAddressPersistence;

public abstract class _AddressLogicService implements _IAddressLogicService {

	@Inject
	protected IAddressPersistence persistance;

	public AddressDTO createAddress(AddressDTO address){
		return persistance.createAddress( address); 
    }

	public List<AddressDTO> getAddresss(){
		return persistance.getAddresss(); 
	}

	public AddressDTO getAddress(Long id){
		return persistance.getAddress(id); 
	}

	public void deleteAddress(Long id){
	    persistance.deleteAddress(id); 
	}

	public void updateAddress(AddressDTO address){
	    persistance.updateAddress(address); 
	}	
}
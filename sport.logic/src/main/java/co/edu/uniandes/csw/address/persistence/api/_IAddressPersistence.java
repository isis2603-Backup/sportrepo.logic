
package co.edu.uniandes.csw.address.persistence.api;

import java.util.List; 

import co.edu.uniandes.csw.address.logic.dto.AddressDTO;

public interface _IAddressPersistence {

	public AddressDTO createAddress(AddressDTO detail);
	public List<AddressDTO> getAddresss();
	public AddressDTO getAddress(Long id);
	public void deleteAddress(Long id);
	public void updateAddress(AddressDTO detail);
	
}
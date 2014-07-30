
package co.edu.uniandes.csw.address.persistence.converter;

import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;


import co.edu.uniandes.csw.address.logic.dto.AddressDTO;
import co.edu.uniandes.csw.address.persistence.entity.AddressEntity;

public abstract class _AddressConverter {

	private final static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

	public static AddressDTO entity2PersistenceDTO(AddressEntity entity){
		if (entity != null) {
			AddressDTO dto = new AddressDTO();
					dto.setId(entity.getId());
					dto.setStreet(entity.getStreet());
					dto.setAveneu(entity.getAveneu());
					dto.setCityId(entity.getCityId());
			return dto;
		}else{
			return null;
		}
	}
	
	public static AddressEntity persistenceDTO2Entity(AddressDTO dto){
		if(dto!=null){
			AddressEntity entity=new AddressEntity();
					entity.setId(dto.getId());
			
					entity.setStreet(dto.getStreet());
			
					entity.setAveneu(dto.getAveneu());
			
					entity.setCityId(dto.getCityId());
			
			return entity;
		}else {
			return null;
		}
	}
	
	public static List<AddressDTO> entity2PersistenceDTOList(List<AddressEntity> entities){
		List<AddressDTO> dtos=new ArrayList<AddressDTO>();
		for(AddressEntity entity:entities){
			dtos.add(entity2PersistenceDTO(entity));
		}
		return dtos;
	}
	
	public static List<AddressEntity> persistenceDTO2EntityList(List<AddressDTO> dtos){
		List<AddressEntity> entities=new ArrayList<AddressEntity>();
		for(AddressDTO dto:dtos){
			entities.add(persistenceDTO2Entity(dto));
		}
		return entities;
	}
}

package co.edu.uniandes.csw.city.persistence.converter;

import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;


import co.edu.uniandes.csw.city.logic.dto.CityDTO;
import co.edu.uniandes.csw.city.persistence.entity.CityEntity;

public abstract class _CityConverter {

	private final static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

	public static CityDTO entity2PersistenceDTO(CityEntity entity){
		if (entity != null) {
			CityDTO dto = new CityDTO();
					dto.setId(entity.getId());
					dto.setName(entity.getName());
					dto.setPopulation(entity.getPopulation());
					dto.setCountryId(entity.getCountryId());
			return dto;
		}else{
			return null;
		}
	}
	
	public static CityEntity persistenceDTO2Entity(CityDTO dto){
		if(dto!=null){
			CityEntity entity=new CityEntity();
					entity.setId(dto.getId());
			
					entity.setName(dto.getName());
			
					entity.setPopulation(dto.getPopulation());
			
					entity.setCountryId(dto.getCountryId());
			
			return entity;
		}else {
			return null;
		}
	}
	
	public static List<CityDTO> entity2PersistenceDTOList(List<CityEntity> entities){
		List<CityDTO> dtos=new ArrayList<CityDTO>();
		for(CityEntity entity:entities){
			dtos.add(entity2PersistenceDTO(entity));
		}
		return dtos;
	}
	
	public static List<CityEntity> persistenceDTO2EntityList(List<CityDTO> dtos){
		List<CityEntity> entities=new ArrayList<CityEntity>();
		for(CityDTO dto:dtos){
			entities.add(persistenceDTO2Entity(dto));
		}
		return entities;
	}
}
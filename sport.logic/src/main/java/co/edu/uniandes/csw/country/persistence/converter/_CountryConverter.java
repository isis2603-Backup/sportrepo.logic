
package co.edu.uniandes.csw.country.persistence.converter;

import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;


import co.edu.uniandes.csw.country.logic.dto.CountryDTO;
import co.edu.uniandes.csw.country.persistence.entity.CountryEntity;

public abstract class _CountryConverter {

	private final static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

	public static CountryDTO entity2PersistenceDTO(CountryEntity entity){
		if (entity != null) {
			CountryDTO dto = new CountryDTO();
					dto.setId(entity.getId());
					dto.setName(entity.getName());
					dto.setPopulation(entity.getPopulation());
			return dto;
		}else{
			return null;
		}
	}
	
	public static CountryEntity persistenceDTO2Entity(CountryDTO dto){
		if(dto!=null){
			CountryEntity entity=new CountryEntity();
					entity.setId(dto.getId());
			
					entity.setName(dto.getName());
			
					entity.setPopulation(dto.getPopulation());
			
			return entity;
		}else {
			return null;
		}
	}
	
	public static List<CountryDTO> entity2PersistenceDTOList(List<CountryEntity> entities){
		List<CountryDTO> dtos=new ArrayList<CountryDTO>();
		for(CountryEntity entity:entities){
			dtos.add(entity2PersistenceDTO(entity));
		}
		return dtos;
	}
	
	public static List<CountryEntity> persistenceDTO2EntityList(List<CountryDTO> dtos){
		List<CountryEntity> entities=new ArrayList<CountryEntity>();
		for(CountryDTO dto:dtos){
			entities.add(persistenceDTO2Entity(dto));
		}
		return entities;
	}
}
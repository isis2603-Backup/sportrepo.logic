
package co.edu.uniandes.csw.role.persistence.converter;

import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;


import co.edu.uniandes.csw.role.logic.dto.RoleDTO;
import co.edu.uniandes.csw.role.persistence.entity.RoleEntity;

public abstract class _RoleConverter {

	private final static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

	public static RoleDTO entity2PersistenceDTO(RoleEntity entity){
		if (entity != null) {
			RoleDTO dto = new RoleDTO();
					dto.setId(entity.getId());
					dto.setName(entity.getName());
					dto.setDescription(entity.getDescription());
			return dto;
		}else{
			return null;
		}
	}
	
	public static RoleEntity persistenceDTO2Entity(RoleDTO dto){
		if(dto!=null){
			RoleEntity entity=new RoleEntity();
					entity.setId(dto.getId());
			
					entity.setName(dto.getName());
			
					entity.setDescription(dto.getDescription());
			
			return entity;
		}else {
			return null;
		}
	}
	
	public static List<RoleDTO> entity2PersistenceDTOList(List<RoleEntity> entities){
		List<RoleDTO> dtos=new ArrayList<RoleDTO>();
		for(RoleEntity entity:entities){
			dtos.add(entity2PersistenceDTO(entity));
		}
		return dtos;
	}
	
	public static List<RoleEntity> persistenceDTO2EntityList(List<RoleDTO> dtos){
		List<RoleEntity> entities=new ArrayList<RoleEntity>();
		for(RoleDTO dto:dtos){
			entities.add(persistenceDTO2Entity(dto));
		}
		return entities;
	}
}
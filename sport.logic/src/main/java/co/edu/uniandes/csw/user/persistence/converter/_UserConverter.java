
package co.edu.uniandes.csw.user.persistence.converter;

import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;


import co.edu.uniandes.csw.user.logic.dto.UserDTO;
import co.edu.uniandes.csw.user.persistence.entity.UserEntity;

public abstract class _UserConverter {

	private final static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

	public static UserDTO entity2PersistenceDTO(UserEntity entity){
		if (entity != null) {
			UserDTO dto = new UserDTO();
					dto.setId(entity.getId());
					dto.setUserName(entity.getUserName());
					dto.setFirstName(entity.getFirstName());
					dto.setLastName(entity.getLastName());
 
			    if(entity.getBirthDate() != null){
					dto.setBirthDate(DATE_FORMAT.format(entity.getBirthDate()));
				}	
					dto.setEnable(entity.getEnable());
					dto.setDocNumber(entity.getDocNumber());
					dto.setDocumenttypeId(entity.getDocumenttypeId());
					dto.setRoleId(entity.getRoleId());
			return dto;
		}else{
			return null;
		}
	}
	
	public static UserEntity persistenceDTO2Entity(UserDTO dto){
		if(dto!=null){
			UserEntity entity=new UserEntity();
					entity.setId(dto.getId());
			
					entity.setUserName(dto.getUserName());
			
					entity.setFirstName(dto.getFirstName());
			
					entity.setLastName(dto.getLastName());
			
 
			      try{ 
			        if(dto.getBirthDate() != null){
						entity.setBirthDate(DATE_FORMAT.parse(dto.getBirthDate()));
					}
				  } catch (Exception ex) {
                        Logger.getLogger(_UserConverter.class.getName()).log(Level.SEVERE, null, ex);
                  }	
			
					entity.setEnable(dto.getEnable());
			
					entity.setDocNumber(dto.getDocNumber());
			
					entity.setDocumenttypeId(dto.getDocumenttypeId());
			
					entity.setRoleId(dto.getRoleId());
			
			return entity;
		}else {
			return null;
		}
	}
	
	public static List<UserDTO> entity2PersistenceDTOList(List<UserEntity> entities){
		List<UserDTO> dtos=new ArrayList<UserDTO>();
		for(UserEntity entity:entities){
			dtos.add(entity2PersistenceDTO(entity));
		}
		return dtos;
	}
	
	public static List<UserEntity> persistenceDTO2EntityList(List<UserDTO> dtos){
		List<UserEntity> entities=new ArrayList<UserEntity>();
		for(UserDTO dto:dtos){
			entities.add(persistenceDTO2Entity(dto));
		}
		return entities;
	}
}
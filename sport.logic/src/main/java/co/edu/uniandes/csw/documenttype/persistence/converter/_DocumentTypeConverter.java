
package co.edu.uniandes.csw.documenttype.persistence.converter;

import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;


import co.edu.uniandes.csw.documenttype.logic.dto.DocumentTypeDTO;
import co.edu.uniandes.csw.documenttype.persistence.entity.DocumentTypeEntity;

public abstract class _DocumentTypeConverter {

	private final static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

	public static DocumentTypeDTO entity2PersistenceDTO(DocumentTypeEntity entity){
		if (entity != null) {
			DocumentTypeDTO dto = new DocumentTypeDTO();
					dto.setId(entity.getId());
					dto.setName(entity.getName());
					dto.setLength(entity.getLength());
			return dto;
		}else{
			return null;
		}
	}
	
	public static DocumentTypeEntity persistenceDTO2Entity(DocumentTypeDTO dto){
		if(dto!=null){
			DocumentTypeEntity entity=new DocumentTypeEntity();
					entity.setId(dto.getId());
			
					entity.setName(dto.getName());
			
					entity.setLength(dto.getLength());
			
			return entity;
		}else {
			return null;
		}
	}
	
	public static List<DocumentTypeDTO> entity2PersistenceDTOList(List<DocumentTypeEntity> entities){
		List<DocumentTypeDTO> dtos=new ArrayList<DocumentTypeDTO>();
		for(DocumentTypeEntity entity:entities){
			dtos.add(entity2PersistenceDTO(entity));
		}
		return dtos;
	}
	
	public static List<DocumentTypeEntity> persistenceDTO2EntityList(List<DocumentTypeDTO> dtos){
		List<DocumentTypeEntity> entities=new ArrayList<DocumentTypeEntity>();
		for(DocumentTypeDTO dto:dtos){
			entities.add(persistenceDTO2Entity(dto));
		}
		return entities;
	}
}

package co.edu.uniandes.csw.documenttype.persistence.entity;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class _DocumentTypeEntity {

	@Id
	@GeneratedValue(generator = "DocumentType")
	private Long id;
	private String name;
	private Integer length;

	public Long getId(){
		return id;
	}
	
	public void setId(Long id){
		this.id = id;
	}
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	public Integer getLength(){
		return length;
	}
	
	public void setLength(Integer length){
		this.length = length;
	}
}
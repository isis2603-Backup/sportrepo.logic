
package co.edu.uniandes.csw.address.persistence.entity;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class _AddressEntity {

	@Id
	@GeneratedValue(generator = "Address")
	private Long id;
	private String street;
	private String aveneu;
	private Long cityId;

	public Long getId(){
		return id;
	}
	
	public void setId(Long id){
		this.id = id;
	}
	public String getStreet(){
		return street;
	}
	
	public void setStreet(String street){
		this.street = street;
	}
	public String getAveneu(){
		return aveneu;
	}
	
	public void setAveneu(String aveneu){
		this.aveneu = aveneu;
	}
	public Long getCityId(){
		return cityId;
	}
	
	public void setCityId(Long cityId){
		this.cityId = cityId;
	}
}
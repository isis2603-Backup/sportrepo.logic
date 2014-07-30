
package co.edu.uniandes.csw.city.persistence.entity;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class _CityEntity {

	@Id
	@GeneratedValue(generator = "City")
	private Long id;
	private String name;
	private Integer population;
	private Long countryId;

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
	public Integer getPopulation(){
		return population;
	}
	
	public void setPopulation(Integer population){
		this.population = population;
	}
	public Long getCountryId(){
		return countryId;
	}
	
	public void setCountryId(Long countryId){
		this.countryId = countryId;
	}
}

package co.edu.uniandes.csw.user.persistence.entity;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class _UserEntity {

	@Id
	@GeneratedValue(generator = "User")
	private Long id;
	private String userName;
	private String firstName;
	private String lastName;
	@Temporal(TemporalType.DATE)
	private Date birthDate;
	private Boolean enable;
	private String docNumber;
	private Long documenttypeId;
	private Long roleId;

	public Long getId(){
		return id;
	}
	
	public void setId(Long id){
		this.id = id;
	}
	public String getUserName(){
		return userName;
	}
	
	public void setUserName(String userName){
		this.userName = userName;
	}
	public String getFirstName(){
		return firstName;
	}
	
	public void setFirstName(String firstName){
		this.firstName = firstName;
	}
	public String getLastName(){
		return lastName;
	}
	
	public void setLastName(String lastName){
		this.lastName = lastName;
	}
	public Date getBirthDate(){
		return birthDate;
	}
	
	public void setBirthDate(Date birthDate){
		this.birthDate = birthDate;
	}
	public Boolean getEnable(){
		return enable;
	}
	
	public void setEnable(Boolean enable){
		this.enable = enable;
	}
	public String getDocNumber(){
		return docNumber;
	}
	
	public void setDocNumber(String docNumber){
		this.docNumber = docNumber;
	}
	public Long getDocumenttypeId(){
		return documenttypeId;
	}
	
	public void setDocumenttypeId(Long documenttypeId){
		this.documenttypeId = documenttypeId;
	}
	public Long getRoleId(){
		return roleId;
	}
	
	public void setRoleId(Long roleId){
		this.roleId = roleId;
	}
}
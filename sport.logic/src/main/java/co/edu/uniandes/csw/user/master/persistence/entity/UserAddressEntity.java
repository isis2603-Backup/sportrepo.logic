package co.edu.uniandes.csw.user.master.persistence.entity;

import co.edu.uniandes.csw.address.persistence.entity.AddressEntity;
import co.edu.uniandes.csw.user.persistence.entity.UserEntity;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn; 
import org.eclipse.persistence.annotations.JoinFetch;

@Entity
@IdClass(UserAddressEntityId.class)
@NamedQueries({
    @NamedQuery(name = "UserAddressEntity.getAddressListForUser", query = "SELECT  u FROM UserAddressEntity u WHERE u.userId=:userId"),
    @NamedQuery(name = "UserAddressEntity.deleteUserAddress", query = "DELETE FROM UserAddressEntity u WHERE u.addressId=:addressId and  u.userId=:userId")
})
public class UserAddressEntity implements Serializable {

    @Id
    @Column(name = "userId")
    private Long userId;
    @Id
    @Column(name = "addressId")
    private Long addressId;
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "addressId", referencedColumnName = "id")
    @JoinFetch
    private AddressEntity addressEntity;
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "userId", referencedColumnName = "id")
    @JoinFetch
    private UserEntity userEntity;

    public UserAddressEntity() {
    }

    public UserAddressEntity(Long userId, Long addressId) {
        this.userId = userId;
        this.addressId = addressId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public AddressEntity getAddressEntity() {
        return addressEntity;
    }

    public void setAddressEntity(AddressEntity addressEntity) {
        this.addressEntity = addressEntity;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

}

package co.edu.uniandes.csw.user.master.persistence.entity;

import co.edu.uniandes.csw.sport.persistence.entity.SportEntity;
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
@IdClass(UserSportEntityId.class)
@NamedQueries({
    @NamedQuery(name = "UserSportEntity.getSportListForUser", query = "SELECT  u FROM UserSportEntity u WHERE u.userId=:userId"),
    @NamedQuery(name = "UserSportEntity.deleteUserSport", query = "DELETE FROM UserSportEntity u WHERE u.sportId=:sportId and  u.userId=:userId")
})
public class UserSportEntity implements Serializable {

    @Id
    @Column(name = "userId")
    private Long userId;
    @Id
    @Column(name = "sportId")
    private Long sportId;
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "sportId", referencedColumnName = "id")
    @JoinFetch
    private SportEntity sportEntity;
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "userId", referencedColumnName = "id")
    @JoinFetch
    private UserEntity userEntity;

    public UserSportEntity() {
    }

    public UserSportEntity(Long userId, Long sportId) {
        this.userId = userId;
        this.sportId = sportId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getSportId() {
        return sportId;
    }

    public void setSportId(Long sportId) {
        this.sportId = sportId;
    }

    public SportEntity getSportEntity() {
        return sportEntity;
    }

    public void setSportEntity(SportEntity sportEntity) {
        this.sportEntity = sportEntity;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

}

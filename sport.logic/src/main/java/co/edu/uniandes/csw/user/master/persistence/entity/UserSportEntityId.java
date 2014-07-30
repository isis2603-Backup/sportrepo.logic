package co.edu.uniandes.csw.user.master.persistence.entity;

import java.io.Serializable;

/**
 *
 * @author cadmilo
 */
public class UserSportEntityId implements Serializable{

    private Long userId;
    private Long sportId;

    @Override
    public int hashCode() {
        return (int) (userId + sportId);
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof UserSportEntityId) {
            UserSportEntityId otherId = (UserSportEntityId) object;
            return (otherId.userId == this.userId) && (otherId.sportId == this.sportId);
        }
        return false;
    }

}

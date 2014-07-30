package co.edu.uniandes.csw.user.master.persistence.entity;

import java.io.Serializable;

/**
 *
 * @author cadmilo
 */
public class UserAddressEntityId implements Serializable{

    private Long userId;
    private Long addressId;

    @Override
    public int hashCode() {
        return (int) (userId + addressId);
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof UserAddressEntityId) {
            UserAddressEntityId otherId = (UserAddressEntityId) object;
            return (otherId.userId == this.userId) && (otherId.addressId == this.addressId);
        }
        return false;
    }

}

package co.edu.uniandes.csw.user.master.persistence.api;

import co.edu.uniandes.csw.user.master.persistence.entity.UserAddressEntity;
import co.edu.uniandes.csw.address.logic.dto.AddressDTO;
import co.edu.uniandes.csw.user.master.persistence.entity.UserSportEntity;
import co.edu.uniandes.csw.sport.logic.dto.SportDTO;
import co.edu.uniandes.csw.user.master.logic.dto.UserMasterDTO;
import java.util.List;

public interface _IUserMasterPersistence {

    public UserAddressEntity createUserAddress(UserAddressEntity entity);

    public void deleteUserAddress(Long userId, Long addressId);
    
    public List<AddressDTO> getAddressListForUser(Long userId);
    public UserSportEntity createUserSport(UserSportEntity entity);

    public void deleteUserSport(Long userId, Long sportId);
    
    public List<SportDTO> getSportListForUser(Long userId);
    
    public UserMasterDTO getUser(Long userId);

}

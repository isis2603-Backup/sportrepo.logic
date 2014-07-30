package co.edu.uniandes.csw.user.master.persistence.converter;
import co.edu.uniandes.csw.user.master.persistence.entity.UserAddressEntity;
import co.edu.uniandes.csw.address.logic.dto.AddressDTO;
import co.edu.uniandes.csw.address.persistence.converter.AddressConverter;
import co.edu.uniandes.csw.user.master.persistence.entity.UserSportEntity;
import co.edu.uniandes.csw.sport.logic.dto.SportDTO;
import co.edu.uniandes.csw.sport.persistence.converter.SportConverter;
import co.edu.uniandes.csw.user.logic.dto.UserDTO;
import co.edu.uniandes.csw.user.master.logic.dto.UserMasterDTO;
import co.edu.uniandes.csw.user.persistence.converter.UserConverter;
import co.edu.uniandes.csw.user.persistence.entity.UserEntity;
import java.util.ArrayList;
import java.util.List;

public abstract class _UserMasterConverter {

    public static UserMasterDTO entity2PersistenceDTO(UserEntity userEntity 
    ,List<UserAddressEntity> userAddressEntity 
    ,List<UserSportEntity> userSportEntity 
    ) {
        UserDTO userDTO = UserConverter.entity2PersistenceDTO(userEntity);
        ArrayList<AddressDTO> addressEntities = new ArrayList<AddressDTO>(userAddressEntity.size());
        for (UserAddressEntity userAddress : userAddressEntity) {
            addressEntities.add(AddressConverter.entity2PersistenceDTO(userAddress.getAddressEntity()));
        }
        ArrayList<SportDTO> sportEntities = new ArrayList<SportDTO>(userSportEntity.size());
        for (UserSportEntity userSport : userSportEntity) {
            sportEntities.add(SportConverter.entity2PersistenceDTO(userSport.getSportEntity()));
        }
        UserMasterDTO respDTO  = new UserMasterDTO();
        respDTO.setUserEntity(userDTO);
        respDTO.setListAddress(addressEntities);
        respDTO.setListSport(sportEntities);
        return respDTO;
    }

}
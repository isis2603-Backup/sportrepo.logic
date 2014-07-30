package co.edu.uniandes.csw.user.master.persistence;
import co.edu.uniandes.csw.address.logic.dto.AddressDTO;
import co.edu.uniandes.csw.user.master.persistence.entity.UserAddressEntity;
import co.edu.uniandes.csw.address.persistence.converter.AddressConverter;
import co.edu.uniandes.csw.sport.logic.dto.SportDTO;
import co.edu.uniandes.csw.user.master.persistence.entity.UserSportEntity;
import co.edu.uniandes.csw.sport.persistence.converter.SportConverter;
import co.edu.uniandes.csw.user.logic.dto.UserDTO;
import co.edu.uniandes.csw.user.master.logic.dto.UserMasterDTO;
import co.edu.uniandes.csw.user.master.persistence.api._IUserMasterPersistence;
import co.edu.uniandes.csw.user.persistence.api.IUserPersistence;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class _UserMasterPersistence implements _IUserMasterPersistence {

  	@PersistenceContext(unitName="sproyectoPU")
 
    protected EntityManager entityManager;
    
    @Inject
    protected IUserPersistence userPersistence;  

    public UserMasterDTO getUser(Long userId) {
        UserMasterDTO userMasterDTO = new UserMasterDTO();
        UserDTO user = userPersistence.getUser(userId);
        userMasterDTO.setUserEntity(user);
        userMasterDTO.setListAddress(getAddressListForUser(userId));
        userMasterDTO.setListSport(getSportListForUser(userId));
        return userMasterDTO;
    }

    public UserAddressEntity createUserAddress(UserAddressEntity entity) {
        entityManager.persist(entity);
        return entity;
    }

    public void deleteUserAddress(Long userId, Long addressId) {
        Query q = entityManager.createNamedQuery("UserAddressEntity.deleteUserAddress");
        q.setParameter("userId", userId);
        q.setParameter("addressId", addressId);
        q.executeUpdate();
    }

    public List<AddressDTO> getAddressListForUser(Long userId) {
        ArrayList<AddressDTO> resp = new ArrayList<AddressDTO>();
        Query q = entityManager.createNamedQuery("UserAddressEntity.getAddressListForUser");
        q.setParameter("userId", userId);
        List<UserAddressEntity> qResult =  q.getResultList();
        for (UserAddressEntity userAddressEntity : qResult) { 
            if(userAddressEntity.getAddressEntity()==null){
                entityManager.refresh(userAddressEntity);
            }
            resp.add(AddressConverter.entity2PersistenceDTO(userAddressEntity.getAddressEntity()));
        }
        return resp;
    }
    public UserSportEntity createUserSport(UserSportEntity entity) {
        entityManager.persist(entity);
        return entity;
    }

    public void deleteUserSport(Long userId, Long sportId) {
        Query q = entityManager.createNamedQuery("UserSportEntity.deleteUserSport");
        q.setParameter("userId", userId);
        q.setParameter("sportId", sportId);
        q.executeUpdate();
    }

    public List<SportDTO> getSportListForUser(Long userId) {
        ArrayList<SportDTO> resp = new ArrayList<SportDTO>();
        Query q = entityManager.createNamedQuery("UserSportEntity.getSportListForUser");
        q.setParameter("userId", userId);
        List<UserSportEntity> qResult =  q.getResultList();
        for (UserSportEntity userSportEntity : qResult) { 
            if(userSportEntity.getSportEntity()==null){
                entityManager.refresh(userSportEntity);
            }
            resp.add(SportConverter.entity2PersistenceDTO(userSportEntity.getSportEntity()));
        }
        return resp;
    }

}

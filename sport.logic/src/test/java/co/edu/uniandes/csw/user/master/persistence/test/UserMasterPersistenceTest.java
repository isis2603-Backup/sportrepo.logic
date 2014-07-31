/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.uniandes.edu.csw.api.user.master.persistence.test;

import co.edu.uniandes.csw.address.logic.dto.AddressDTO;
import co.edu.uniandes.csw.address.persistence.converter.AddressConverter;
import co.edu.uniandes.csw.address.persistence.converter._AddressConverter;
import co.edu.uniandes.csw.address.persistence.entity.AddressEntity;
import co.edu.uniandes.csw.sport.logic.dto.SportDTO;
import co.edu.uniandes.csw.sport.persistence.converter.SportConverter;
import co.edu.uniandes.csw.sport.persistence.entity.SportEntity;
import co.edu.uniandes.csw.user.logic.dto.UserDTO;
import co.edu.uniandes.csw.user.master.logic.dto.UserMasterDTO;
import co.edu.uniandes.csw.user.master.persistence.*;
import co.edu.uniandes.csw.user.master.persistence.api.IUserMasterPersistence;
import co.edu.uniandes.csw.user.master.persistence.entity.UserAddressEntity;
import co.edu.uniandes.csw.user.master.persistence.entity.UserSportEntity;
import co.edu.uniandes.csw.user.persistence.UserPersistence;
import co.edu.uniandes.csw.user.persistence.converter.UserConverter;
import co.edu.uniandes.csw.user.persistence.entity.UserEntity;
import co.uniandes.edu.csw.api.user.master.persistence.rules.test.UserMasterPersistenceRules;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.UserTransaction;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author Jj.alarcon10
 */
@RunWith(Arquillian.class)
public class UserMasterPersistenceTest {

    public static final String DEPLOY = "Prueba";
    //Regla implementada para manejar múltiples escenarios de datos
    @Rule
    public UserMasterPersistenceRules rule = new UserMasterPersistenceRules("dataSample");
//Almacena el dato actual de la regla.
    private UserDTO dataSample;

    @Deployment
    public static WebArchive createDeployment() {

        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                //Añade el paquete en el que se encuentra la clase 'TestCPersistance.java'
                //.addPackage(TestCPersistence.class.getPackage())
                //.addPackage(TestBPersistence.class.getPackage())
                .addPackage(UserDTO.class.getPackage())
                .addPackage(AddressDTO.class.getPackage())
                .addPackage(SportDTO.class.getPackage())
                .addPackage(UserMasterDTO.class.getPackage())
                .addPackage(UserMasterPersistence.class.getPackage())
                .addPackage(IUserMasterPersistence.class.getPackage())
                .addPackage(UserPersistence.class.getPackage())
                //Añade el paquete en el que se encuentra la clase 'TestCEntity.java'
                .addPackage(UserEntity.class.getPackage())
                .addPackage(UserAddressEntity.class.getPackage())
                .addPackage(UserSportEntity.class.getPackage())
                .addPackage(AddressEntity.class.getPackage())
                .addPackage(SportEntity.class.getPackage())
                //Finalmente se añaden los archivos persistance.xml y beans.xml para laa Unidad de peristencia y CDI del paquete mínimo
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }
    //Atributo que contiene la referencia al componente que se va a probar (la persistencia)
    @Inject
    private IUserMasterPersistence testPersistence;

    //Atributo que obtiene el persistance unit especificado en persistance.xml
    @PersistenceContext(name = "sproyectoPU")
    private EntityManager em;
    //Atributo que contiene la referencia al manegador de transacciones de JPA (utilizado para inicializar las pruebas)
    @Inject
    UserTransaction utx;

    //Método que configura las pruebas antes de ejecutarlas
    @Before
    public void configTest() {

        System.out.println("em: " + em);

    }

    private ArrayList<AddressEntity> generateAddressDeatail(int cty) {
        PodamFactory factory = new PodamFactoryImpl();
        ArrayList<AddressEntity> tmp = new ArrayList<AddressEntity>();
        for (int i = 0; i < cty; i++) {
            AddressDTO entity = factory.manufacturePojo(AddressDTO.class);
            entity.setId((long) 0);
            tmp.add(AddressConverter.persistenceDTO2Entity(entity));
        }

        return tmp;
    }

    private ArrayList<SportEntity> generateSportDeatail(int cty) {
        PodamFactory factory = new PodamFactoryImpl();
        ArrayList<SportEntity> tmp = new ArrayList<SportEntity>();
        for (int i = 0; i < cty; i++) {
            SportDTO entity = factory.manufacturePojo(SportDTO.class);
            entity.setId((long) 0);
            tmp.add(SportConverter.persistenceDTO2Entity(entity));
        }

        return tmp;
    }

    @Test
    public void createUserAddressCompositeTest() {
        try {
            System.err.println("--> " + dataSample);
            System.err.println("--> delete");
            //BORRO DATOS BD
            System.err.println("--> load");

            ArrayList<AddressEntity> details = generateAddressDeatail(5);

            UserEntity m = UserConverter.persistenceDTO2Entity(dataSample);

            ArrayList<UserAddressEntity> oracle = new ArrayList<UserAddressEntity>();
            System.err.println("--> begin");
            for (AddressEntity detailsMaster : details) {

                UserAddressEntity tst = new UserAddressEntity();

                tst.setAddressEntity(detailsMaster);
                tst.setUserEntity(m);
                testPersistence.createUserAddress(tst);
                oracle.add(tst);
            }
            System.err.println("--> check");
            Query q = em.createNamedQuery("UserAddressEntity.getAddressListForUser");
            q.setParameter("userID", dataSample.getId());
            List<UserAddressEntity> qResult = q.getResultList();

            boolean invalid = true;
            if (qResult.size() != oracle.size()) {
                assertTrue(false);
            }

            for (UserAddressEntity validation : qResult) {
                boolean fnd = false;
                for (int i = 0; i < oracle.size() && !fnd; i++) {
                    System.err.println(validation.getAddressId() + "==" + oracle.get(i).getAddressId());
                    invalid = true;
                    if (oracle.get(i).getAddressId() == validation.getAddressId() && oracle.get(i).getAddressId() == validation.getAddressId()) {
                        fnd = true;
                        invalid = false;
                    }

                }
            }

            assertTrue(!invalid);

        } catch (Exception ex) {
            ex.printStackTrace();
            fail();
            try {
                utx.rollback();
            } catch (Exception ex1) {
                ex.printStackTrace();
            }
        }

    }

    @Test
    public void createUserSportCompositeTest() {
        try {
            System.err.println("--> " + dataSample);
            System.err.println("--> delete");
            //BORRO DATOS BD
            System.err.println("--> load");

            ArrayList<SportEntity> details = generateSportDeatail(5);

            UserEntity m = UserConverter.persistenceDTO2Entity(dataSample);

            ArrayList<UserSportEntity> oracle = new ArrayList<UserSportEntity>();
            System.err.println("--> begin");
            for (SportEntity detailsMaster : details) {

                UserSportEntity tst = new UserSportEntity();

                tst.setSportEntity(detailsMaster);
                tst.setUserEntity(m);
                testPersistence.createUserSport(tst);
                oracle.add(tst);
            }
            System.err.println("--> check");
            Query q = em.createNamedQuery("UserSportEntity.getSportListForUser");
            q.setParameter("userID", dataSample.getId());
            List<UserSportEntity> qResult = q.getResultList();

            boolean invalid = true;
            if (qResult.size() != oracle.size()) {
                assertTrue(false);
            }

            for (UserSportEntity validation : qResult) {
                boolean fnd = false;
                for (int i = 0; i < oracle.size() && !fnd; i++) {
                    System.err.println(validation.getSportId() + "==" + oracle.get(i).getSportId());
                    invalid = true;
                    if (oracle.get(i).getSportId() == validation.getSportId() && oracle.get(i).getSportId() == validation.getSportId()) {
                        fnd = true;
                        invalid = false;
                    }

                }
            }

            assertTrue(!invalid);

        } catch (Exception ex) {
            ex.printStackTrace();
            fail();
            try {
                utx.rollback();
            } catch (Exception ex1) {
                ex.printStackTrace();
            }
        }

    }

    @Test
    public void createUserAdressSharedTest() {
        try {
            System.err.println("--> delete");
            System.err.println("--> " + dataSample);
            //BORRO DATOS BD
            System.err.println("--> load");

            ArrayList<AddressEntity> details = new ArrayList<AddressEntity>(); //PErsistir y obtener datos de prueba

            UserEntity m = UserConverter.persistenceDTO2Entity(dataSample);

            ArrayList<UserAddressEntity> oracle = new ArrayList<UserAddressEntity>();
            System.err.println("--> begin");
            for (AddressEntity detailsMaster : details) {

                UserAddressEntity tst = new UserAddressEntity();

                tst.setAddressId(detailsMaster.getId());
                tst.setUserId(m.getId());
                testPersistence.createUserAddress(tst);
                oracle.add(tst);
            }
            System.err.println("--> check");
            Query q = em.createNamedQuery("UserAddressEntity.getAddressListForUser");
            q.setParameter("userID", dataSample.getId());
            List<UserAddressEntity> qResult = q.getResultList();

            boolean invalid = true;
            if (qResult.size() != oracle.size()) {
                assertTrue(false);
            }

            for (UserAddressEntity validation : qResult) {
                boolean fnd = false;
                for (int i = 0; i < oracle.size() && !fnd; i++) {
                    System.err.println(validation.getAddressId() + "==" + oracle.get(i).getAddressId());
                    invalid = true;
                    if (oracle.get(i).getAddressId() == validation.getAddressId() && oracle.get(i).getAddressId() == validation.getAddressId()) {
                        fnd = true;
                        invalid = false;
                    }

                }
            }

            assertTrue(!invalid);

        } catch (Exception ex) {
            ex.printStackTrace();
            fail();
            try {
                utx.rollback();
            } catch (Exception ex1) {
                ex.printStackTrace();
            }
        }

    }

    @Test
    public void createUserSportSharedTest() {
        try {
            System.err.println("--> delete");
            System.err.println("--> " + dataSample);
            //BORRO DATOS BD
            System.err.println("--> load");

            ArrayList<SportEntity> details = new ArrayList<SportEntity>(); //PErsistir y obtener datos de prueba

            UserEntity m = UserConverter.persistenceDTO2Entity(dataSample);

            ArrayList<UserSportEntity> oracle = new ArrayList<UserSportEntity>();
            System.err.println("--> begin");
            for (SportEntity detailsMaster : details) {

                UserSportEntity tst = new UserSportEntity();

                tst.setSportId(detailsMaster.getId());
                tst.setUserId(m.getId());
                testPersistence.createUserSport(tst);
                oracle.add(tst);
            }
            System.err.println("--> check");
            Query q = em.createNamedQuery("UserSportEntity.getSportListForUser");
            q.setParameter("userID", dataSample.getId());
            List<UserSportEntity> qResult = q.getResultList();

            boolean invalid = true;
            if (qResult.size() != oracle.size()) {
                assertTrue(false);
            }

            for (UserSportEntity validation : qResult) {
                boolean fnd = false;
                for (int i = 0; i < oracle.size() && !fnd; i++) {
                    System.err.println(validation.getSportId() + "==" + oracle.get(i).getSportId());
                    invalid = true;
                    if (oracle.get(i).getSportId() == validation.getSportId() && oracle.get(i).getSportId() == validation.getSportId()) {
                        fnd = true;
                        invalid = false;
                    }

                }
            }

            assertTrue(!invalid);

        } catch (Exception ex) {
            ex.printStackTrace();
            fail();
            try {
                utx.rollback();
            } catch (Exception ex1) {
                ex.printStackTrace();
            }
        }

    }

    @Test
    public void getAddressListForUserTest() {
        System.err.println("--> delete");
        System.err.println("--> " + dataSample);
        //BORRO DATOS BD
        System.err.println("--> load");

        UserEntity en = UserConverter.persistenceDTO2Entity(dataSample);
        try {
            utx.begin();
            em.persist(en);
            utx.commit();
        } catch (Exception e) {

        }
        //Cargo ejemplo en modelo Adress - User (con el id del user anterior)
        ArrayList<AddressEntity> oracle = new ArrayList<AddressEntity>();

        System.err.println("--> begin");

        List<AddressDTO> res = testPersistence.getAddressListForUser(en.getId());
        System.err.println("--> verify");
        if (res.isEmpty()) {
            fail();
        }
        boolean invalid = false;

        for (AddressDTO addressDTO : res) {
            boolean fnd = false;
            for (int i = 0; i < res.size() && !fnd; i++) {
                System.err.println(addressDTO.getId() + "==" + oracle.get(i).getId());
                invalid = true;
                if (oracle.get(i).getId() == addressDTO.getId() && oracle.get(i).getId() == addressDTO.getId()) {
                    fnd = true;
                    invalid = false;
                }
            }
        }

        assertTrue(!invalid);
    }

    @Test
    public void getSportListForUserTest() {
        System.err.println("--> delete");
        System.err.println("--> " + dataSample);
        //BORRO DATOS BD
        System.err.println("--> load");

        UserEntity en = UserConverter.persistenceDTO2Entity(dataSample);
        try {
            utx.begin();
            em.persist(en);
            utx.commit();
        } catch (Exception e) {

        }
        //Cargo ejemplo en modelo Adress - User (con el id del user anterior)
        ArrayList<SportEntity> oracle = new ArrayList<SportEntity>();

        System.err.println("--> begin");

        List<SportDTO> res = testPersistence.getSportListForUser(en.getId());
        System.err.println("--> verify");
        if (res.isEmpty()) {
            fail();
        }
        boolean invalid = false;

        for (SportDTO addressDTO : res) {
            boolean fnd = false;
            for (int i = 0; i < res.size() && !fnd; i++) {
                System.err.println(addressDTO.getId() + "==" + oracle.get(i).getId());
                invalid = true;
                if (oracle.get(i).getId() == addressDTO.getId() && oracle.get(i).getId() == addressDTO.getId()) {
                    fnd = true;
                    invalid = false;
                }
            }
        }

        assertTrue(!invalid);
    }

    @Test
    public void deleteUserAddressTest() {
        System.err.println("--> delete");
        System.err.println("--> " + dataSample);
        //BORRO DATOS BD
        System.err.println("--> load");

        UserEntity en = UserConverter.persistenceDTO2Entity(dataSample);
        try {
            utx.begin();
            em.persist(en);
            utx.commit();
        } catch (Exception e) {

        }
        //Cargo ejemplo en modelo Adress - User (con el id del user anterior)
        ArrayList<AddressEntity> oracle = new ArrayList<AddressEntity>();

        System.err.println("--> begin");

        for (AddressEntity addressEntity : oracle) {
            testPersistence.deleteUserAddress(en.getId(), addressEntity.getId());
        }

        System.err.println("--> verify");
        System.err.println("--> check");
        Query q = em.createNamedQuery("UserAddressEntity.getAddressListForUser");
        q.setParameter("userID", dataSample.getId());
        List<UserAddressEntity> qResult = q.getResultList();
        if (!qResult.isEmpty()) {
            fail();
        }
    }

    @Test
    public void deleteUserSportTest() {
        System.err.println("--> delete");
        System.err.println("--> " + dataSample);
        //BORRO DATOS BD
        System.err.println("--> load");

        UserEntity en = UserConverter.persistenceDTO2Entity(dataSample);
        try {
            utx.begin();
            em.persist(en);
            utx.commit();
        } catch (Exception e) {

        }
        //Cargo ejemplo en modelo Adress - User (con el id del user anterior)
        ArrayList<SportEntity> oracle = new ArrayList<SportEntity>();

        System.err.println("--> begin");

        for (SportEntity addressEntity : oracle) {
            testPersistence.deleteUserSport(en.getId(), addressEntity.getId());
        }

        System.err.println("--> verify");
        System.err.println("--> check");
        Query q = em.createNamedQuery("UserSportEntity.getSportListForUser");
        q.setParameter("userID", dataSample.getId());
        List<UserSportEntity> qResult = q.getResultList();
        if (!qResult.isEmpty()) {
            fail();
        }
    }
}

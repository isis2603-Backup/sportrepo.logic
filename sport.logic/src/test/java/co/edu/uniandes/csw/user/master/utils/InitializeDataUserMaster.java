/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.uniandes.csw.user.master.utils;

import co.edu.uniandes.csw.address.logic.dto.AddressDTO;
import co.edu.uniandes.csw.sport.logic.dto.SportDTO;
import co.edu.uniandes.csw.user.logic.dto.UserDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author Jj.alarcon10
 */

    public class InitializeDataUserMaster {
    
    public static String DB_URL= "jdbc:derby://localhost:1527/sun-appserv-samples;create=true;";
    
    public static void initDataShared(int number){
    
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            //Obtener conexion.
            Connection conn= DriverManager.getConnection(DB_URL);
            PodamFactory factory = new PodamFactoryImpl();
            
            for(int i=0; i< number; i++){
                AddressDTO entity = factory.manufacturePojo(AddressDTO.class);
                Statement stmt = conn.createStatement();
                String sql="INSERT INTO ADDRESSENTITY (ID,STREET,AVENEU,CITYID) " 
                            + "VALUES (" + i + ",'" + entity.getAveneu() + "','" + entity.getStreet()+ "'," + entity.getCityId() + ")";
            stmt.executeUpdate(sql);
            //Se almacenan en el arreglo de datos
            }
           conn.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    
    
    }
    
    /*
        insertDataAddress crea entidades de Address de acuerdo al número (number)
        y las relaciona al master de tipo UserDTO recibido como parámetro.
    
    */
    

    public static ArrayList<AddressDTO> insertDataAddress(int number, UserDTO master ){

        try{
           Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
           // Obtiene conexion jdbc
           Connection conn = DriverManager.getConnection(DB_URL);
           PodamFactory factory = new PodamFactoryImpl();
           
           Statement stmt = conn.createStatement();
           //Revisar atributo @Enable@, en la base de datos es de tipo smallint y en el dto es boolean
           String sql1= "INSERT INTO USERENTITY (ID,USERNAME,FIRSTNAME,LASTNAME,BIRTHDATE,ENABLE,DOCNUMBER,DOCUMENTTYPEID,ROLEID) "
                    + "VALUES ("+ master.getId()+ ",'"+master.getUserName()+"', '" +master.getFirstName()+"', '"+ master.getLastName()+"','"
                   + master.getBirthDate()+"'," + 3 +",'" + master.getDocNumber()+"',"      
                   + master.getDocumenttypeId()+ "," + master.getRoleId()+")";
           
           stmt.executeUpdate(sql1);
           ArrayList<AddressDTO> addresses = new ArrayList<AddressDTO>();
           for(int i=0; i<number; i++){
               AddressDTO entity = factory.manufacturePojo(AddressDTO.class);
               String sql="INSERT INTO ADDRESSENTITY (ID,STREET,AVENEU,CITYID) " 
                            + "VALUES (" + i + ",'" + entity.getAveneu() + "','" + entity.getStreet()+ "'," + entity.getCityId() + ")";
               stmt.executeUpdate(sql);
               
               sql="INSERT INTO USERADDRESSENTITY (USERID,ADDRESSID) " 
                            + "VALUES (" + master.getId() + "," + i + ")";
               stmt.executeUpdate(sql);
               addresses.add(entity);
           }
           conn.close();
           return addresses;
        }catch(Exception e){
                e.printStackTrace();
                 return null;

        }    
    }
    
    /*
        generateAddress crea entidades de Address 
        de acuerdo al número.
    
    */
    
    public static ArrayList<AddressDTO> generateAddress(int number) {
        try {
           

            PodamFactory factory = new PodamFactoryImpl();

            
            ArrayList<AddressDTO> addresses = new ArrayList<AddressDTO>();
            for (int i = 0; i < number; i++) {
                //Pobla los AddressDTO con datos aleatorios
                AddressDTO entity = factory.manufacturePojo(AddressDTO.class);

              
                addresses.add(entity);

            }
           
            return addresses;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
     /*
        insertDataSport crea entidades de Sport de acuerdo al número (number)
        y las relaciona al master de tipo UserDTO recibido como parámetro.
    
    */
    public static ArrayList<SportDTO> insertDataSport(int number, UserDTO master ){

        try{
           Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
           // Obtiene conexion jdbc
           Connection conn = DriverManager.getConnection(DB_URL);
           PodamFactory factory = new PodamFactoryImpl();
           
           Statement stmt = conn.createStatement();
           //Revisar atributo @Enable@, en la base de datos es de tipo smallint y en el dto es boolean
           String sql1= "INSERT INTO USERENTITY (ID,USERNAME,FIRSTNAME,LASTNAME,BIRTHDATE,ENABLE,DOCNUMBER,DOCUMENTTYPEID,ROLEID) "
                    + "VALUES ("+ master.getId()+ ",'"+master.getUserName()+"', '" +master.getFirstName()+"', '"+ master.getLastName()+"','"
                   + master.getBirthDate()+"'," + 3 +",'" + master.getDocNumber()+"',"      
                   + master.getDocumenttypeId()+ "," + master.getRoleId()+")";
           
           stmt.executeUpdate(sql1);
           ArrayList<SportDTO> sports = new ArrayList<SportDTO>();
           for(int i=0; i<number; i++){
               SportDTO entity = factory.manufacturePojo(SportDTO.class);
               String sql="INSERT INTO SPORTENTITY (ID,MAXAGE,MINAGE,NAME) " 
                            + "VALUES (" + i + "," + entity.getMaxAge() + "," + entity.getMinAge()+ ",'" + entity.getName() + "')";
               stmt.executeUpdate(sql);
               
               sql="INSERT INTO USERSPORTENTITY (SPORTID,USERID) " 
                            + "VALUES (" + i + "," + master.getId() + ")";
               stmt.executeUpdate(sql);
               sports.add(entity);
           }
           conn.close();
           return sports;
        }catch(Exception e){
                e.printStackTrace();
                 return null;

        }    
    }
  
    /*
        generateSport crea entidades de Sport 
        de acuerdo al número.
    
    */
    
    public static ArrayList<SportDTO> generateSport(int number) {
        try {
           

            PodamFactory factory = new PodamFactoryImpl();

            
            ArrayList<SportDTO> sports = new ArrayList<SportDTO>();
            for (int i = 0; i < number; i++) {
                //Pobla los AddressDTO con datos aleatorios
                SportDTO entity = factory.manufacturePojo(SportDTO.class);
                sports.add(entity);

            }
           
            return sports;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    /*
        deleteBd elimina los datos de las entidades de User, Sport, 
        UserAddress y UserSport 
      
    */
    
    public static void deleteBd(){
    
        try{
            //Obtiene la conexion jdbc
            Connection conn = DriverManager.getConnection(DB_URL);
            PodamFactory factory = new PodamFactoryImpl();
            Statement stmt = conn.createStatement();
            
            String sql = "DELETE FROM USERADDRESSENTITY";
            stmt.executeUpdate(sql);
            
            sql = "DELETE FROM USERSPORTENTITY";
            stmt.executeUpdate(sql);
        
            sql = "DELETE FROM USERENTITY";
            stmt.executeUpdate(sql);
            
            sql = "DELETE FROM SPORTENTITY";
            stmt.executeUpdate(sql);
            
            sql = "DELETE FROM ADDRESSENTITY";
            stmt.executeUpdate(sql);
            
            conn.close();
        }catch(Exception e){ 
            e.printStackTrace();
        
        }   
    }
   

}

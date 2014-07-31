/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.uniandes.edu.csw.api.user.master.persistence.utils.test;


import co.edu.uniandes.csw.address.logic.dto.AddressDTO;
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
    



    public static ArrayList<AddressDTO> insertData(int number, UserDTO master ){

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
    
    
    
    
  }  
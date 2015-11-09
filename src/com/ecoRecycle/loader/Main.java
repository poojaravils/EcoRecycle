package com.ecoRecycle.loader;

// TO be moved away from here

import org.hibernate.HibernateException;
import org.hibernate.Session; 
import org.hibernate.Transaction;

import com.ecoRecycle.helper.RcmStatus;
import com.ecoRecycle.model.Administrator;
import com.ecoRecycle.model.Location;
import com.ecoRecycle.model.Rcm;
import com.ecoRecycle.repository.AdministratorRepository;

public class Main
{
    public static void main(String[] args) {
    	
    	Main main = new Main();

        /* Add few employee records in database */
       //Integer locId = main.addLocation("Santa Clara");
        //System.out.println("Location created --- " + locId);
    	
    	//Integer rcmId = main.addRcm();
    	//System.out.println("RCM created --- " + rcmId);
       
       AdministratorRepository adminRepo = new AdministratorRepository();
       Integer adminId = adminRepo.addUser("Lakshitha" , "Lakshitha123");
       System.out.println("Admin Created --- " + adminId);
       adminRepo.getUser("lakshitha", "lakshitha123");
       adminRepo.getUser("lakshitha", "lakshitha");
    }
    
    
    
    public Integer addLocation(String city){
        Session session = HibernateLoader.getSessionFactory().openSession();
        Transaction tx = null;
        Integer locId = null;
        try{
           tx = session.beginTransaction();
           Location loc = new Location();
           loc.setCity(city);
           
           locId = (Integer) session.save(loc); 
           tx.commit();
        }catch (HibernateException e) {
           if (tx!=null) tx.rollback();
           e.printStackTrace(); 
        }finally {
           session.close(); 
        }
        return locId;
     }
    
    public Integer addRcm(){
        Session session = HibernateLoader.getSessionFactory().openSession();
        Transaction tx = null;
        Integer rcmId = null;
        try{
           tx = session.beginTransaction();
           Rcm rcm = new Rcm();
           rcm.setName("RCMTest7");
           
           //rcm.setCity("Sunnyvale");

           Location loc = (Location)session.load(Location.class, 1);
           rcm.setLocation(loc);
           
           rcm.setTotalCapacity(10);
           rcm.setTotalCashValue(1000);
           
           rcm.setStatus(RcmStatus.ACTIVE);
           
          
           
           rcmId = (Integer) session.save(rcm); 
           tx.commit();
        }catch (HibernateException e) {
           if (tx!=null) tx.rollback();
           e.printStackTrace(); 
        }finally {
           session.close(); 
        }
        return rcmId;
     }
}
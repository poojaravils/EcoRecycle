package com.ecoRecycle.repository;

import com.ecoRecycle.loader.HibernateLoader;
import com.ecoRecycle.model.Rmos;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class RmosRepository {
	

	// Get rmos by id
	
	public Rmos getRmos(int id)
	{
    	Session session = HibernateLoader.getSessionFactory().openSession();
    	Rmos retriveRmos = null;
        Transaction tx = null;
       
    	try
    	{
    		tx = session.beginTransaction();
    		Query query = session.createQuery("from Rmos where id = :id");
    		query.setInteger("id",id);
    		
    		java.util.List allUsers = query.list();
    		if(allUsers.isEmpty())
    		{
    			System.out.println("There is no rmos");
    		}
    		
    		for (int i = 0; i < allUsers.size(); i++) 
    		{
    			retriveRmos = (Rmos)allUsers.get(i);
    			System.out.println("Rmos-Name:" + retriveRmos.getName()); 
    		}
    		
            tx.commit();
    		
    	}
    	catch(Exception e){
    		if (tx!=null) tx.rollback();
            e.printStackTrace(); 
    	}
    	finally {
    		if (session!=null) 
            session.close(); 
         }
         return retriveRmos;
    }
	
	 //Add new Rmos
	
	public Integer addRmos(String name){
        Session session = HibernateLoader.getSessionFactory().openSession();
        Transaction tx = null;
        Integer rmosId = null;
        try{
           tx = session.beginTransaction();
           Rmos rmos = new Rmos();
           rmos.setName(name);
           
           rmosId = (Integer) session.save(rmos); 
           tx.commit();
        }catch (HibernateException e) {
           if (tx!=null) tx.rollback();
           e.printStackTrace(); 
        }finally {
           session.close(); 
        }
        return rmosId;
     }
		
	// Get all rmos

	// Update Rmos - add rcm mappings 
	
}

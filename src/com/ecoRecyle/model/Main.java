package com.ecoRecyle.model;

import java.util.logging.Level;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.Session; 
import org.hibernate.Transaction;

public class Main
{
    private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;

    static
    {
        try
        {
        	java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF); // Might want to redirect logging
            Configuration configuration = new Configuration().configure().addAnnotatedClass(Location.class);

            serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        }
        catch (HibernateException he)
        {
            System.err.println("Error creating Session: " + he);
            throw new ExceptionInInitializerError(he);
        }
    }

    public static SessionFactory getSessionFactory()
    {
        return sessionFactory;
    } 
    
    public static void main(String[] args) {
    	
    	Main main = new Main();

    	java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        /* Add few employee records in database */
        Integer locId = main.addLocation("Santa Clara");
        System.out.println("Location created --- " + locId);
       
    }
    
    public Integer addLocation(String city){
        Session session = getSessionFactory().openSession();
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
}
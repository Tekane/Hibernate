package com.hibernate.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.hibernate.hibernate.dto.UserDetails;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       UserDetails user  = new UserDetails();
       user.setUserName("Sandy");
       user.setAddress("Mogapeng");
       user.setJoinedDate(new Date());
       user.setDescription("Description of the user goes here");
       
       SessionFactory  sessionFactory  = new Configuration().configure().buildSessionFactory();
       Session session =  sessionFactory.openSession();
       session.beginTransaction();
       //session.save(user);
       session.getTransaction().commit();
       session.close();
       
       user = null;
       
       session = sessionFactory.openSession();
       session.beginTransaction();
       user = (UserDetails) session.get(UserDetails.class, 5);
       System.out.println("User name "+user.getUserName());
       
 
    }
}

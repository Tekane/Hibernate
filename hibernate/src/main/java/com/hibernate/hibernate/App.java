package com.hibernate.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
       user.setUserId(1);
       user.setUserName("Phasha");
       
       SessionFactory  sessionFactory  = new Configuration().configure().buildSessionFactory();
       Session session =  sessionFactory.openSession();
       session.beginTransaction();
       session.save(user);
       session.beginTransaction().commit();
    }
}

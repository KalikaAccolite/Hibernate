package Hibernate.HiberanteExercise1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

//import java.util.*;
import Entity.Enployee;
import Hibernate.HiberanteExercise1utils.HibernateUtils;


public class App 
{
    public static void main( String[] args )
    {
    	 System.out.println( "Hello World!" );

         Enployee employee = new Enployee();
         employee.setEmpName("Kalika");
         employee.setEmpEmail("Kalika@accolite.com");
         
         Enployee employee1 = new Enployee();
         employee1.setEmpName("Aman");
         employee1.setEmpEmail("Aman@accolite.com");

         SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
         Session session = sessionFactory.openSession();
         session.beginTransaction();
         session.persist(employee);
         session.persist(employee1);
         session.getTransaction().commit();
         Enployee savedEmployee = session.get(Enployee.class, 2L);
         System.out.println(savedEmployee);
         session.close();
         
         
//         RETRIVING OPERATION   
         Session sessionForRetriving=sessionFactory.openSession();       
         Enployee s=sessionForRetriving.get(Enployee.class, 1); 
         System.out.println("Name : "+s.getEmpName()); 
         System.out.println("Class : "+s.getEmpEmail()); 
         sessionForRetriving.close(); 
         
//          UPDATING OPERATION   
         Session sessionforUpdating = sessionFactory.openSession();
         Transaction tr=sessionforUpdating.beginTransaction();
         Enployee e=sessionforUpdating.get(Enployee.class, 1);
         e.setEmpName("Shivi");
         sessionforUpdating.merge(e);
         sessionforUpdating.getTransaction().commit();
         sessionforUpdating.close();
       
//      Checking the updated Data 
         Session sessionForRetrivin=sessionFactory.openSession();    
         Enployee s2=sessionForRetrivin.get(Enployee.class, 1); 
         System.out.println("Name : "+s2.getEmpName()); 
         System.out.println("Class : "+s2.getEmpEmail());          
         sessionForRetrivin.close(); 
       
//		Delete Operation
         Session sessionForDeleting=sessionFactory.openSession();  
         Transaction t=sessionForDeleting.beginTransaction(); 
         Enployee d=sessionForDeleting.get(Enployee.class, 2); 
         sessionForDeleting.remove(d); 
         sessionForDeleting.getTransaction().commit();
         sessionFactory.close(); 
         
         
    }
}

package Hibernate.OneToOneMapping;

/**
 * Hello world!
 *
 */
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import Utils.HibernateUtils;



public class App {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            // Create Country objects
            Country country2 = new Country();
            country2.setCountry_Name("USA");
            country2.setCounttry_Code(101);
            
            Country country3 = new Country();
            country3.setCountry_Name("India");
            country3.setCounttry_Code(102);
            
            Country country4 = new Country();
            country4.setCountry_Name("Pak");
            country4.setCounttry_Code(103);

            // Create PM objects associated with the countries
            PM pm2 = new PM();
            pm2.setPM_Nme("Joe Biden");
            
            PM pm3 = new PM();
            pm3.setPM_Nme("Jair Bolsonaro");
            
            PM pm4 = new PM();
            pm4.setPM_Nme("Angela Merkel");

         
            country2.setPm(pm2);
            pm2.setCountry(country2);
            country3.setPm(pm3);
            pm3.setCountry(country3);
            country4.setPm(pm4);
            pm4.setCountry(country4);


            session.persist(country2);
            session.persist(country3);
            session.persist(country4);
            
            session.getTransaction().commit();
            
            Country savedCountry = session.get(Country.class, 1L);
            System.out.println(savedCountry);
            
            PM savedPM = session.get(PM.class, 1L);
            System.out.println(savedPM);
            
            Country savedCountry2 = session.get(Country.class, 2L);
            System.out.println(savedCountry2);
            
            PM savedPM2 = session.get(PM.class, 2L);
            System.out.println(savedPM2);

            Country savedCountry3 = session.get(Country.class, 3L);
            System.out.println(savedCountry3);
            
            PM savedPM3 = session.get(PM.class, 3L);
            System.out.println(savedPM3);

            session.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessionFactory.close();
        }
    }
}
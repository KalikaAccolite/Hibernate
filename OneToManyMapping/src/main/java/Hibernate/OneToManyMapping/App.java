package Hibernate.OneToManyMapping;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import Utils.HibernateUtils;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        Country country1 = new Country();
        country1.setCountry_Name("India");
        country1.setCounttry_Code(101);
        

        List<State> list = new ArrayList<>();

        State state1 = new State();
        state1.setState_Name("Uttar Pardesh");
        state1.setNumberOfCities(50);
        list.add(state1);

        State state2 = new State();
        state2.setState_Name("Madhya Pradesh");
        state2.setNumberOfCities(51);
        list.add(state2);

        state1.setCountry(country1);
        state2.setCountry(country1);
        country1.setStateList(list);
        
        Country country2 = new Country();
        country2.setCountry_Name("USA");
        country2.setCounttry_Code(102);
        

        List<State> list1 = new ArrayList<>();

        State state3 = new State();
        state3.setState_Name("California");
        state3.setNumberOfCities(12);
        list1.add(state3);

        State state4 = new State();
        state4.setState_Name("Hawaii");
        state4.setNumberOfCities(11);
        list1.add(state4);

        state3.setCountry(country2);
        state4.setCountry(country2);
        country2.setStateList(list1);

        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.persist(country1);
        session.persist(country2);
        session.getTransaction().commit();
        

        System.out.println("Country 1 Details: ");
        Country savedCountry = session.get(Country.class, 1L);
        System.out.println(savedCountry);
        
        System.out.println("State details: ");
        State savedState = session.get(State.class, 1L);
        System.out.println(savedState);

        State savedstate2= session.get(State.class, 2L);
        System.out.println(savedstate2);
        
        System.out.println("Country 2 Details: ");
        Country savedCountry1 = session.get(Country.class, 2L);
        System.out.println(savedCountry1);

        System.out.println("State details: ");
        State savedState3 = session.get(State.class, 3L);
        System.out.println(savedState3);

        State savedstate4= session.get(State.class, 4L);
        System.out.println(savedstate4);

        session.close();
    }
}

package Hibernate.ManyToManyMapping;

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
        Student stu1 = new Student();
        stu1.setStudentfirstName("Kalika");
        stu1.setStudentlastName("Awasthi");
        stu1.setStudentemail("kalika.awasthi@accolitedigital.com");

        Student stu2 = new Student();
        stu2.setStudentfirstName("Aman");
        stu2.setStudentlastName("Bajpai");
        stu2.setStudentemail("aman.bajpai@accolitedigital.com");

        List<Student> student = new ArrayList<>();
        student.add(stu1);
        student.add(stu2);

        Teacher teacher1 = new Teacher();
        teacher1.setFirstName("Shubham");
        teacher1.setLastName("Trivedi");
        teacher1.setEmail("shubham.trivedi@accolitedigital.com");

        Teacher teacher2 = new Teacher();
        teacher2.setFirstName("Manoj");
        teacher2.setLastName("Arora");
        teacher2.setEmail("manoj.arora@accolitedigital.com");

        List<Teacher> teacher = new ArrayList<>();
        teacher.add(teacher1);
        teacher.add(teacher2);

        stu1.setTeacher(teacher);
        stu2.setTeacher(teacher);

        teacher1.setStudent(student);
        teacher2.setStudent(student);

        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.persist(stu1);
        session.persist(stu2);
        session.persist(teacher1);
        session.persist(teacher2);

        session.getTransaction().commit();

        System.out.println("Printing from Student -: ");
        Student savedStudent1 = session.get(Student.class, 1L);
        System.out.println(savedStudent1);

        Student savedStudent2 = session.get(Student.class, 2L);
        System.out.println(savedStudent2);

        System.out.println("Printing from Mentor -: ");
        Teacher savedTeacher1 = session.get(Teacher.class, 1L);
        System.out.println(savedTeacher1);

        Teacher savedTeacher2 = session.get(Teacher.class, 2L);
        System.out.println(savedTeacher2);

        session.close();
    }
}

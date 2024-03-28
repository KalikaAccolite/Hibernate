package Hibernate.ManyToManyMapping;

import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "teacher")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Teacher_ID;
    private String firstName;
    private String lastName;
    private String email;
    private int PhoneNo;

    @ManyToMany(mappedBy = "teacher")
    private List<Student> student;

    

    public int getTeacher_ID() {
		return Teacher_ID;
	}



	public void setTeacher_ID(int teacher_ID) {
		Teacher_ID = teacher_ID;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public int getPhoneNo() {
		return PhoneNo;
	}



	public void setPhoneNo(int phoneNo) {
		PhoneNo = phoneNo;
	}



	public List<Student> getStudent() {
		return student;
	}



	public void setStudent(List<Student> student) {
		this.student = student;
	}



	@Override
    public String toString() {
        StringBuilder res = new StringBuilder("Mentor{" +
                "id=" + Teacher_ID +
                ", fName='" + firstName + '\'' +
                ", lName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNo.='" + PhoneNo + '\'' +
                ", student=");

        for(Student s : getStudent()){
            res.append(s.getStudentfirstName()).append(" ").append(s.getStudentlastName()).append(", ");
        }

        res.append("}");

        return res.toString();
    }
}
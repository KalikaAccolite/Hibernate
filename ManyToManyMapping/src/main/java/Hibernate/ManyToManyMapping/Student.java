package Hibernate.ManyToManyMapping;

import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Student_id;
    private String StudentfirstName;
    private String StudentlastName;
    private String Studentemail;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Teacher> teacher;

   
    public int getStudent_id() {
		return Student_id;
	}


	public void setStudent_id(int student_id) {
		Student_id = student_id;
	}


	public String getStudentfirstName() {
		return StudentfirstName;
	}


	public void setStudentfirstName(String studentfirstName) {
		StudentfirstName = studentfirstName;
	}


	public String getStudentlastName() {
		return StudentlastName;
	}


	public void setStudentlastName(String studentlastName) {
		StudentlastName = studentlastName;
	}


	public String getStudentemail() {
		return Studentemail;
	}


	public void setStudentemail(String studentemail) {
		Studentemail = studentemail;
	}


	public List<Teacher> getTeacher() {
		return teacher;
	}


	public void setTeacher(List<Teacher> teacher) {
		this.teacher = teacher;
	}


	@Override
    public String toString() {
        StringBuilder res = new StringBuilder("Student{" +
                "id=" + Student_id +
                ", fName='" + StudentfirstName + '\'' +
                ", lName='" + StudentlastName + '\'' +
                ", email='" + Studentemail + '\'' +
                ", Teacher=");

        for(Teacher t : getTeacher()){
            res.append(t.getFirstName()).append(" ").append(t.getLastName()).append(", ");
        }

        res.append("}");

        return res.toString();
    }
}
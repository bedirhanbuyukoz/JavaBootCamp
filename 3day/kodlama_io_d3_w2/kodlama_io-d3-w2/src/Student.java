
public class Student extends User {
 String studentCourse;

public Student(int id, String name, String password) {
	super(id, name, password);

}

public String getStudentCourse() {
	return studentCourse;
}

public void setStudentCourse(String studentCourse) {
	this.studentCourse = studentCourse;
}
}
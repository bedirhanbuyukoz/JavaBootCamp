

public class Instructor extends User {
 String intructorCourse;



public Instructor(int id, String name, String password) {
	super(id, name, password);

}

public String getIntructorCourse() {
	return intructorCourse;
}

public void setIntructorCourse(String intructorCourse) {
	this.intructorCourse = intructorCourse;
}
 
}
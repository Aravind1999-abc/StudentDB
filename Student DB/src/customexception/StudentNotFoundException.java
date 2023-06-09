
package customexception;

public class StudentNotFoundException extends RuntimeException{
 private String msg;
 
 public StudentNotFoundException(String msg) {
	 this.msg=msg;
}
 public String getMessage() {
	 return msg;
 }
}
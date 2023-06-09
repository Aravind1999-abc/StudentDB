
package customexception;

public class InvalidChoiceException extends RuntimeException {
 private String msg;
  
  public InvalidChoiceException(String msg) {
	  this.msg=msg;
  }
  public String getMessage() {
	  return msg;
  }
}


package customsorting;
import java.util.Comparator;
import sdbms.Student;
public class SortStudentByMarks  implements Comparator<Student>{
public int compare(Student x,Student y) {
	return x.getMarks() -y.getMarks();
}
}

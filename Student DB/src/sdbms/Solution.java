
package sdbms;
import customexception.InvalidChoiceException;
import java.util.Scanner;

public class Solution {
public static void main(String[] args) {
	System.out.println("Welcome to sdbms System");
	System.out.println("-----------------------");
	Scanner sc=new Scanner(System.in);
	StudentManagementSystem sdbms=new SdbmsImpl();
	while(true) {
		System.out.println("1:add Student\n2:displayStudent");
		System.out.println(" 3:displayAllStudent\n4:removeStudent");
		System.out.println("5:removeAllStudent\n6:updateStudent");
		System.out.println("7:countStudent\n8:sortStudent");
		System.out.println("9:getStudentWithHighestMarks\n10:getStudentWithLowestMarks");
		System.out.println("Enter Choice");
		
		int choice=sc.nextInt();
		switch(choice) {
		case 1:sdbms.addStudent();
		break;
		case 2:sdbms.displayStudent();
		break;
		case 3:sdbms.displayAllStudent();
		break;
		case 4:sdbms.removeStudent();
		break;
		case 5:sdbms.removeAllStudent();
		break;
		case 6:sdbms.updateStudent();
		break;
		case 7:sdbms.countStudent();
		break;
		case 8:sdbms.sortStudent();
		break;
		case 9:sdbms.getStudentWithHighestMarks();
		break;
		case 10:sdbms.getStudentWithLowestMarks();
		break;
		case 11:System.out.println("thank you");
		System.exit(0);
		break;
		default:try {
			throw new InvalidChoiceException("invalid choice");
			}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		}
	}
	
}
}

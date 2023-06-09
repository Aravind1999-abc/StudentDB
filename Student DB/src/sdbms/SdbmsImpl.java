package sdbms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import customexception.InvalidChoiceException;
import customexception.StudentNotFoundException;
import customsorting.SortStudentByAge;
import customsorting.SortStudentById;
import customsorting.SortStudentByMarks;
import customsorting.SortStudentByName;

public class SdbmsImpl implements StudentManagementSystem {
	Scanner sc=new Scanner(System.in);
	Map<String,Student> DB=new LinkedHashMap<String,Student>();
	@Override
	public void addStudent() {
		System.out.println("Enter the student id");
		String id=sc.next().toUpperCase();
		System.out.println("Enter Student Age");
		int age=sc.nextInt();
		System.out.println("Enter Student Name");
		String name=sc.next();
		System.out.println("Enter Student Marks");
		int marks=sc.nextInt();
		Student std=new Student(id,age,name,marks);
		DB.put(std.getId(), std);
		System.out.println("Student Record Inserted Successfully");
		System.out.println("Student Id is:"+ std.getId());
	
		
	}

	@Override
	public void displayStudent() {
		System.out.println("Enter Student Id :");
		String id=sc.next().toUpperCase(); //String name=sc.next().toUpperCase();
		//id=id.toUpperCase();

		if(DB.containsKey(id)) { //checking if id is present or not
			Student std=DB.get(id); //getting the Student object
			System.out.println("Id: "+ std.getId());
			System.out.println("Age:"+std.getAge());
			System.out.println("Name:"+std.getName());
			System.out.println("Marks:"+std.getMarks());
			// System.out.println(std);
		}
		else {
			String message="Student with Id"+id+"is not Found";
			try {
				throw new StudentNotFoundException(message);
			}
			catch(Exception e) {
				System.err.println(e.getMessage());
			}
		}
		
	}

	@Override
	public void displayAllStudent() {
		if(DB.size()!=0) {
			Set<String> s=DB.keySet();
			for(String ele:s) {
				Student std=DB.get(ele); 
				 System.out.println("Id: " + ele);
		            System.out.println("Age: " + std.getAge());
		            System.out.println("Name: " + std.getName());
		            System.out.println("Marks: " + std.getMarks());
			}
		}
		else {
			String message="Student Record is not Found";
			try {
				throw new StudentNotFoundException(message);

			}
			catch(Exception e){
				System.err.println(message);

			}
		}
		
	}

	@Override
	public void removeStudent() {
		//Accept Id & toUppercase
		//if id is present ->db.remove(id);
		//else->SNFE ->Handle
		System.out.println("Enter student id:");
		String  id=sc.next().toUpperCase();

		if(DB.containsKey(id)) {
			System.out.println("Student Record Found!");
			Student std = DB.get(id);
	        System.out.println("ID: " + id);
			DB.remove(id);
			System.out.println("Student Record Deleted Successfully!");
		}
		else {
			try {
				String message="Student with the id "+id +"is not Found!";
				throw new StudentNotFoundException(message);
			}
			catch(Exception e){
				System.err.println(e.getMessage());
			}

		}
		
	}

	@Override
	public void removeAllStudent() {
		if(DB.size()!=0) {
			System.out.println("Student Records Available: "+DB.size());
			DB.clear();
			System.out.println("All Student Records Deleted Successfully!");
			System.out.println("Student Records Available:"+DB.size());
		}
		else {
			try {
				String message="Student Database is Empty,Nothing to Delete";
				throw new StudentNotFoundException(message);
			}
			catch(Exception e) {
				System.err.println(e.getMessage());
			}
		}
		
	}

	@Override
	public void updateStudent() {
		System.out.println("Enter student id:");
		String id=sc.next().toUpperCase();
		if(DB.containsKey(id)) {
			Student std=DB.get(id);
			System.out.println("1:Update Age\n2:Update Name \n3:Update Marks");
			System.out.println("Enter the choice:");
			int choice =sc.nextInt();

			switch(choice) {
			case 1:
				System.out.println("Enter Age");
				int age=sc.nextInt();
				std.setAge(age);//std.setAge(scan.nextInt());
				break;

			case 2:
				System.out.println("Enter Name :");
				String name=sc.next();
				std.setName(name);//std.setAge(scan.nextInt());
				break;

			case 3:
				System.out.println("Enter Marks");
				int marks=sc.nextInt();
				std.setMarks(marks);//std.setAge(scan.nextInt());
				break;

			default:
				try {
					String msg="Invalid choice, Kindly enter valid choice!";
					throw new InvalidChoiceException(msg);
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}

		else {
			try {
				String message="Student with the id"+id+"is not Found!";
				throw new StudentNotFoundException(message);
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
		
	}

	@Override
	public void countStudent() {
		System.out.println("No of student Records :"+ DB.size()); 
		
	}

	@Override
	public void sortStudent() {
		//Map into set -->keyset()--keys
		//list list=new al()-->Student object--->generics
		//for each loop --> traverse keys
		//display 1:sort by id 2:sort by name 3:sort by marks 4:sort by age
		//switch --> collection.sort(list,new sort StudentById());
		//traverse

		Set<String>key=DB.keySet();
		List<Student> list=new ArrayList<Student>();

		for(String keys:key) {
			list.add(DB.get(keys));
		}
		System.out.println("1.sort By Id\n2:sort By Age");
		System.out.println("3:sort By Name\n4:sort By Marks");
		System.out.println("Enter  choice:");
		int choice=sc.nextInt();

		switch(choice) {
		case 1:
			Collections.sort(list,new SortStudentById());
			display(list);
			break;

		case 2:
			Collections.sort(list,new SortStudentByAge());
			display(list);
			break;

		case 3:
			Collections.sort(list,new SortStudentByName());
			display(list);
			break;
		case 4:
			Collections.sort(list,new SortStudentByMarks());
			display(list);
			break;
		default:
			try {
				throw new InvalidChoiceException("Invalid Choice");
			}
		  catch(Exception e) {
			  System.err.println(e.getMessage());
			  updateStudent();
		  }
		
		} 
		
	}
	private static void display(List<Student> list) {
		for(Student s:list) {
			System.out.println(s);
		}
	}

	@Override
	public void getStudentWithHighestMarks() {
		if(DB.size()>=2) {
			Set<String>key=DB.keySet();
			List<Student> list=new ArrayList<Student>();

			for(String keys:key) {
				list.add(DB.get(keys));
			}
			Collections.sort(list,new SortStudentByMarks());
			//System.out.println(list.size()-1); 
			  Student studentWithHighestMarks = list.get(list.size() - 1);
		        System.out.println("Student with the highest marks:");
		        System.out.println("Id: " + studentWithHighestMarks.getId());
		        System.out.println("Age: " + studentWithHighestMarks.getAge());
		        System.out.println("Name: " + studentWithHighestMarks.getName());
		        System.out.println("Marks: " + studentWithHighestMarks.getMarks());//getting the  student object
		}
		else {
			try {
				String message="No sufficient Student Records to compare";
				throw new StudentNotFoundException(message);
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
		
	}

	@Override
	public void getStudentWithLowestMarks() {
		if(DB.size()>=2) {
			Set<String>key=DB.keySet();
			List<Student> list=new ArrayList<Student>();

			for(String keys:key) {
				list.add(DB.get(keys));
			}
			Collections.sort(list,new SortStudentByMarks());
			//System.out.println(list.get(0)); //getting the  student object
			   Student studentWithLowestMarks = list.get(0);
		        System.out.println("Student with the lowest marks:");
		        System.out.println("Id: " + studentWithLowestMarks.getId());
		        System.out.println("Age: " + studentWithLowestMarks.getAge());
		        System.out.println("Name: " + studentWithLowestMarks.getName());
		        System.out.println("Marks: " + studentWithLowestMarks.getMarks());
		}
		else {
			try {
				String message="No sufficient Student Records to compare";
				throw new StudentNotFoundException(message);
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
	}
		
	}



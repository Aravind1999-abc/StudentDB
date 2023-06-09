
package sdbms;

public class Student {
  private String id;
  private int age;
  private String name;
  private int marks;
  //static int count=101;
  public Student(String id,int age,String name,int marks) {
	  //this.id="s"+count;
	  this.id=id;
	 // count++;
	  this.age=age;
	  this.name=name;
	  this.marks=marks;
  }
  
  public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public int getAge() {
	  return age;
  }
  public  void setAge(int age) {
	  this.age=age;
  }
  public String getName() {
	  return name;
  }
  public void setName(String name) {
	  this.name=name;
	  }
  public int getMarks() {
	  return marks;
  }
  public void setMarks(int marks) {
	  this.marks=marks;
  }
//  public static int getCount() {
//	  return count;
//  }
//  public static void setCount(int count) {
//	  Student.
//	  count=count;
//  }

@Override
public String toString() {
	return "Student [id=" + id + ", age=" + age + ", name=" + name + ", marks=" + marks + "]";
}
  
}

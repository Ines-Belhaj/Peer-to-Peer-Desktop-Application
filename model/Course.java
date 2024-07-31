package peer_to_peer.model;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import peer_to_peer.textualInterface.CourseInterface;
import peer_to_peer.dao.CourseDao;

public class Course {
	
	private String title;
	private ArrayList<Student> students ;
	private int numberStudents;
	private Level level;
	private CourseDao t = new CourseDao();
	private CourseInterface textualInterface  = new CourseInterface();
	
	public Scanner s= new Scanner(System.in);

	public Course(String title)
	{
		this.title=title;
	}
	public Course (String title, Level level , int numberStudents) {
		this.level=level;
		this.numberStudents=numberStudents;
		this.title=title;
	}
	
	//////////////// Getters&Setters //////////////////////////////////////
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	
	////////////////////////// Calculate_Number_Students //////////////////
	
	/*public int CalculateNumberStudents(ArrayList<Student> students)
	{
		int s =0;
		for(int i =0; i<students.size(); i++)
		{
			students.get(i).
		}
	}*/
	
	////////////////////////// displayAllCourses /////////////////////////////
	public void displayAllCourses(ArrayList<Course> courses)
	{
		for (int i =0; i< courses.size(); i++)
		{
			System.out.println("Title:		"+ courses.get(i).getTitle());
			System.out.println("level:		"+ courses.get(i).getLevel());
			//System.out.println("Number of students: "+ courses[i].CalculateNumberStudents);
			System.out.println("------------------------------------");
		}
	
	}
	//////////////////////////displaySearchedCourse /////////////////////////////
	public void displaySearchedCourse(ArrayList<Course> courses)
	{
		int index = textualInterface.searchCourse(courses);
		System.out.println("Title:		"+ courses.get(index).getTitle());
		System.out.println("level:		"+ courses.get(index).getLevel());
		//System.out.println("Number of students: "+ courses[index].CalculateNumberStudents);
	
	}
	///////////////////////// add new Course //////////////////////////////////////
	public void add() {
		t.save(textualInterface.addCourse()); 
	}
	////////////////////////////// search Course //////////////////////////////////////
	public Course search(ArrayList<Course> courses) {
		return t.get(textualInterface.searchCourse(courses)); 
	}
	
	//////////////////////// delete Course //////////////////////////////////////
	public void delete(ArrayList<Course> courses) {
		t.delete(courses.get(textualInterface.searchCourse(courses))); 
		}
	/////////////////////modify Course ////////////////////////////
	public void modify(ArrayList<Course> courses)  
	{
		int index = textualInterface.searchCourse(courses);
		t.update(index, textualInterface.modifyCourse(courses, index));
	}
	
	
}

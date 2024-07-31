package peer_to_peer.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import peer_to_peer.textualInterface.StudentInterface;
import peer_to_peer.dao.StudentDao;


public class Student extends Person {

	private String id;
	private Level level;
	private HashMap<String, Double> courseGrade;
	private ArrayList<Availablity> availablities;
	private ArrayList<Meeting> tutoringMeetings;
	private ArrayList<Meeting> tutoredMeetings;
	private StudentDao tool = new StudentDao();
	private StudentInterface textualInterface  = new StudentInterface();



	public Student(String id, String firstName, String lastName) {
		super(firstName, lastName);
		this.id = id;
		/*
		this.courseGrade = new HashMap<>();
		this.availablities = new ArrayList<>();
		this.tutoringMeetings = new ArrayList<>();
		this.tutoredMeetings = new ArrayList<>();
		*/
	}
	////////////////////////// Getters&Setters /////////////////////////////////////

	public String getId() {
		return id;
	}

	public void setID(String id) {
		this.id = id;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public HashMap<String, Double> getCourseGrade() {
		return courseGrade;
	}

	public void setCourseGrade(HashMap<String, Double> courseGrade) {
		this.courseGrade = courseGrade;
	}

	public ArrayList<Availablity> getAvailablities() {
		return availablities;
	}

	public void setAvailablities(ArrayList<Availablity> availablities) {
		this.availablities = availablities;
	}

	public ArrayList<Meeting> getTutoringMeetings() {
		return tutoringMeetings;
	}

	public void setTutoringMeetings(ArrayList<Meeting> tutoringMeetings) {
		this.tutoringMeetings = tutoringMeetings;
	}

	public ArrayList<Meeting> getTutoredMeetings() {
		return tutoredMeetings;
	}

	public void setTutoredMeetings(ArrayList<Meeting> tutoredMeetings) {
		this.tutoredMeetings = tutoredMeetings;
	}

	///////////////////////// add new student //////////////////////////////////////
	public void add() {
		tool.save(textualInterface.addStudent()); ///textualInterface.addStudent() --> returns Student
	}
	////////////////////////////// search student
	public Student search(ArrayList<Student> students) {
		 return tool.get(textualInterface.searchStudent(students)); ///textualInterface.searchStudent(students) --> returns int(index)
	}

	//////////////////////// delete student ////////////////////////////////////////
	public void delete(ArrayList<Student> students) {
		tool.delete(students.get(textualInterface.searchStudent(students))); ///students.get(textualInterface.searchStudent(students)) --> returns Student 
	}
	/////////////////////modify student details ////////////////////////////
	public void modify(ArrayList<Student> students)  

	{
		int index = textualInterface.searchStudent(students);
		tool.update(index, textualInterface.modifyStudent(students, index));///textualInterface.modifyStudent(students, index) --> returns Student 

	}

	/////////////////////////////// display All Students /////////////////////////
	public void displayAllStudents(ArrayList<Student> students) {
		for (int i = 0; i < students.size(); i++) {
			System.out.println("ID:			" + students.get(i).getId());
			System.out.println("First Name:		" + students.get(i).getFirstName());
			System.out.println("Last Name:		" + students.get(i).getLastName());
			System.out.println("------------------------------------");
		}

	}

	/////////////////////////////// display Searched Students /////////////////////////////// /////////////////////////
	public void displaySearchedStudent(ArrayList<Student> students) {
		int index = textualInterface.searchStudent(students);    
		System.out.println("ID:			" + students.get(index).getId());
		System.out.println("First Name:		" + students.get(index).getFirstName());
		System.out.println("Last Name:		" + students.get(index).getLastName());
		System.out.println("------------------------------------");

	}

	/////////////////////////////// display Student information /////////////////////////////// /////////////////////////
	public void displayStudentInformation(ArrayList<Student> students) {
		int index = textualInterface.searchStudent(students);
		System.out.println("ID:			" + students.get(index).getId());
		System.out.println("First Name:		" + students.get(index).getFirstName());
		System.out.println("Last Name:		" + students.get(index).getLastName());
		System.out.println("------------------------------------");
		System.out.println("		Courses and Grades		");
		System.out.println(courseGrade); // we use switch for add modify and delete or we will implement it in the user
		// interface
		System.out.println("		Availibility		");
		System.out.println(availablities);

	}

	
}
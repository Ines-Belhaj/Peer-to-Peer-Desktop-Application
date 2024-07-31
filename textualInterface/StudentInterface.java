package peer_to_peer.textualInterface;

import java.util.ArrayList;
import java.util.Scanner;

import peer_to_peer.model.Level;
import peer_to_peer.model.Student;

public class StudentInterface {
	public Scanner s = new Scanner(System.in);

	public Student addStudent() {

		System.out.println("ID: ");
		String ID = s.next();
		System.out.println("First Name: ");
		String firstName = s.next();
		System.out.println("Last Name: ");
		String lastName = s.next();
		Student student= new Student(ID, firstName, lastName);
		Level level = selectLevel(student);
		
		return student;
	}
	
	
	public Level selectLevel(Student student) {
		int choice;
		Level level1 = null;
		do {
			do {
				System.out.println("Choose a level: ");
				System.out.println("0-freshman ");
				System.out.println("1-sophomore");
				System.out.println("2-junior");
				System.out.println("3-senior ");
				System.out.println("4-final");
				System.out.println("5-Exit");
				choice = s.nextInt();
			
				if ((choice < 0) && (choice > 5)) {
					System.out.println("ERROR");
					System.out.println("Please try again");
				}
			} while ((choice < 0) && (choice > 5));

			switch (choice) {
			case 0:
				level1 = student.getLevel().FRESHMAN;
				break;
			case 1:
				level1 = student.getLevel().SOPHOMORE;
				break;
			case 2:
				level1 = student.getLevel().JUNIOR;
				break;
			case 3:
				level1 = student.getLevel().SENIOR;
				break;
			case 4:
				level1 = student.getLevel().FINAL;
				break;

			}

		} while (choice != 5);
		return level1;
}
	public int searchStudent(ArrayList<Student> students) {
		System.out.println("Enter the ID of the student :");
		String id = s.next();
		int index = -1;
		do {
			for (int i = 0; i < students.size(); i++) {
				if ((students.get(i)).getId() == id) {
					index = i;
				}
			}
			if (index == students.size()) {
				System.out.println("The ID does not exist");
				System.out.println("Please try again");
			}
		} while (index == students.size());
		return index;
	}
	 /////////////////////// modify student  details//////////////////////
	public Student modifyStudent(ArrayList<Student> students,int index)
	{
		int choice;
		do {
			do {
				System.out.println("You want to modify:");
				System.out.println("1-Student ID");
				System.out.println("2-Student First Name");
				System.out.println("3-Student Last Name");
				System.out.println("4-Exit");
				choice = s.nextInt();

				if ((choice > 4) && (choice < 0)) {
					System.out.println("ERROR");
					System.out.println("Please try again");
				}

			} while ((choice > 4) && (choice < 0));

			switch (choice) {
			case 1:
				System.out.println("The old Id:		" + students.get(index).getId());
				System.out.println("Enter the course new Title");
				(students.get(index)).setID(s.next());
				break;
			case 2:
				System.out.println("The old first name:		" + students.get(index).getFirstName());
				System.out.println("Enter the new first name");
				(students.get(index)).setFirstName(s.next());
				break;
			case 3:
				System.out.println("The old last name:		" + students.get(index).getLastName());
				System.out.println("Enter the new last name");
				(students.get(index)).setLastName(s.next());
				break;
			

			}
		} while (choice != 4);
		return students.get(index);
	}
}

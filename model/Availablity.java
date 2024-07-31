package peer_to_peer.model;

import java.util.Scanner;
import peer_to_peer.textualInterface.StudentInterface;
import peer_to_peer.dao.StudentDao;

import java.util.ArrayList;
import java.util.Arrays;


public class Availablity {
	
private String day;
private float from,to;
private AvailabilityDao tool = new AvailabilityDao();
private AvailabilityInterface textualInterface  = new AvailabilityInterface();


public Availablity () 
{
	this.day= "";
	this.from=0;
	this.to = 0;
}

 public Availablity ( String day, float from,float to) 
 {
	this.day= day;
	this.from=from;
	this.to=to;
 }
 
 
 /////////////////////////////////// Getters&Setters ///////////////////////////
 
 public String getDay() {
		return day;
	}


	public void setDay(String day) {
		this.day = day;
	}


	public float getFrom() {
		return from;
	}


	public void setFrom(float from) {
		this.from = from;
	}


	public float getTo() {
		return to;
	}


	public void setTo(float to) {
		this.to = to;
	}


 

 
 ///////////////////////////////////add_availablity //////////////////////////////////////

public void add(ArrayList<Availablity> availablities) {
	 String day;
	 float from,to;
	 
	 System.out.println("Enter the day: ");
	 day= s.next();
	 System.out.println("From: ");
	 from= s.nextFloat();
	 System.out.println("To:");
	 to= s.nextFloat();
	 availablities.add(new Availablity(day,from,to));  
 }
 
 /////////////////////////////////// delete_availablity //////////////////////////////////////
 
 public void delete (ArrayList<Availablity> availablities ) {
	int  index = search( availablities );
	availablities.remove(index);
	    }
 
	 
 ///////////////////////////////////modify_availablity //////////////////////////////////////
 
 public void modify(ArrayList<Availablity> availablities) {
		int  index= search( availablities );
		int choice;
		 do
		 {
			 do 
			 {
				 System.out.println("You want to modify:");
				 System.out.println("1-Day");
				 System.out.println("2-From");
				 System.out.println("3-To");
				 System.out.println("4-Exit");
				  choice = s.nextInt();
				  
				  if ((choice > 4 ) && (choice < 0))
				  {
					  System.out.println("ERROR");
					  System.out.println("Please try again");
				  }

			 }while((choice > 4 ) && (choice < 0));
			 switch(choice) {
			 case 1:
				 System.out.println("The old day: ");
				 System.out.println((availablities.get(index)).getDay());
				 System.out.println("Enter the new day: ");
				 (availablities.get(index)).setDay(s.next());
				break;
			 case 2:
				 System.out.println("The old starting time: ");
				 System.out.println(availablities.get(index).getFrom());
				 System.out.println("Enter the new starting time (from): ");
				 availablities.get(index).setFrom(s.nextFloat());
				break;
			 case 3:
				 System.out.println("The old ending time: ");
				 System.out.println(availablities.get(index).getTo());
				 System.out.println("Enter the new ending time (to):");
				 availablities.get(index).setTo(s.nextFloat());;
				break;
			 }
			 
		 }while(choice != 4);
 } 
 
 ///////////////////////////////////display_Searched_availablity //////////////////////////////////////

 public void displaySearched(ArrayList<Availablity> availablities ) {
	 int  index= search( availablities );
		System.out.println("Day:		"+ availablities.get(index).getDay());
		System.out.println("From:		"+ availablities.get(index).getFrom());
		System.out.println("To:			"+ availablities.get(index).getTo());


 } 
 
 //////////////////////////////////// display_all_availibilites //////////////////////////////////////
 
 public void display(ArrayList<Availablity> availablities)
 {
	 for (int i =0; i< availablities.size(); i++)
		{
			System.out.println("Day:		"+ availablities.get(i).getDay());
			System.out.println("From:		"+ availablities.get(i).getFrom());
			System.out.println("To:			"+ availablities.get(i).getTo());
			System.out.println("------------------------------------");
		}
 }
 
 
 }
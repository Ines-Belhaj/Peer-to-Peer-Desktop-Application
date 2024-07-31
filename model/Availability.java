package peer_to_peer.model;

import peer_to_peer.textualInterface.AvailabilityInterface;
import peer_to_peer.dao.AvailabilityDao;

import java.util.ArrayList;


public class Availability {
	
private String day;
private float from,to;
private AvailabilityDao tool = new AvailabilityDao();
private AvailabilityInterface textualInterface  = new AvailabilityInterface();


public Availability () 
{
	this.day= "";
	this.from=0;
	this.to = 0;
}

 public Availability ( String day, float from,float to) 
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

public void add(ArrayList<Availability>availablities) {
	 tool.setAvailabilities(availablities);
	 tool.save(textualInterface.addAvailability());
}

 /////////////////////////////////// delete_availablity //////////////////////////////////////
 
 public void delete ( ArrayList<Availability>availablities) {
	 tool.setAvailabilities(availablities);
	 tool.delete(availablities.get(textualInterface.searchAvailability(availablities))); ///students.get(textualInterface.searchStudent(students)) --> returns Student 

	    }
 
	 
 ///////////////////////////////////modify_availablity //////////////////////////////////////
 
 public void modify(ArrayList<Availability>availablities,int index) {
	 	tool.setAvailabilities(availablities);
		tool.update(index,textualInterface.modifyAvailability( day,  from, to));///textualInterface.modifyStudent(students, index) --> returns Student 	
 } 
 
 ///////////////////////////////////display_Searched_availablity //////////////////////////////////////

 public void displayAvailability() {

		System.out.println("Day:		"+ this.day);
		System.out.println("From:		"+ this.from);
		System.out.println("To:			"+ this.to);


 } 
 
 //////////////////////////////////// display_all_availibilites //////////////////////////////////////
 
 public void displayAllAvailabilities(ArrayList<Availability> availablities)
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
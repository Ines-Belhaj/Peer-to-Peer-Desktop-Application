package peer_to_peer.textualInterface;

import java.util.ArrayList;
import java.util.Scanner;

import peer_to_peer.model.Availablity;

public class AvailabilityInterface {
	
	public Scanner s = new Scanner(System.in);
	
	 ///////////////////////////////////search_availablity //////////////////////////////////////
	
	public int searchAvailability (ArrayList<Availablity> availablities ) 
	 {
		 String day;
		 float from,to;
		 int index=-1;
		 do
		 {
			 System.out.println("Enter the day: ");
			 day= s.next();
			 System.out.println("From: ");
			 from= s.nextFloat();
			 System.out.println("To: ");
			 to= s.nextFloat();
			 
			 for(int i=0; i <availablities.size();i++)
			 {
				 if ( (((availablities.get(i)).getDay()).equals(day)) && ((availablities.get(i)).getFrom()== from) && ((availablities.get(i)).getTo()==to) )
				 {
					 index = i;
				 }
			 }
			 	if (index < 0)
			 	{
			 		System.out.println("The date entered does not exist");
			 		System.out.println("PLEASE TRY AGAIN");
			 	}
		 }while(index<0);
		 return index;
	 }
}

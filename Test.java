package peer_to_peer;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		
		
		//Creating list of Books  
	    ArrayList<Availablity> list=new ArrayList<Availablity>();   
	    //Adding Books to list  
	   // list.add(list);
	    Availablity availabilities = new Availablity();
		availabilities.add(list);
		availabilities.add(list);
		availabilities.add(list);
	    //Traversing list  
	    for(Availablity b:list){  
	        System.out.println(b.getDay()+" "+b.getFrom()+" "+b.getTo());  
	    }  
		
	
	}

}

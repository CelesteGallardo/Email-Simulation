package cus1156.project2;

import java.io.IOException;
/**
This program simulates a email messaging system.
*/
public class EmailSimulation {
	
	   public static void main(String[] args)
	         throws IOException
	   { 
	      MessagingSystem system = new MessagingSystem();
	      EmailMenu menu = new EmailMenu();
	      menu.run(system);
	   }
	}
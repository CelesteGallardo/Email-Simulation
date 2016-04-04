package cus1156.project2;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Scanner; 

/**
 * This class represents a user interface called email menu that allows the user to
 * pick commands for the messaging system to complete. 
 * @author CelesteG
 *
 */
public class EmailMenu {

	private String userName=null;
	private String recipient=null;
	private String txt;
	private Message message;
	private Mailbox mailbox;
	private MessagingSystem msgSystem;
	Scanner kb= new Scanner(System.in);
	/**
	 * This displays an email menu. Each letter represents a command on the email menu such as 
	 * login, send message, read unread message, logout, and display sorted messages and quit.
	 * @return option that the user decides to do.
	 */
	public String displayEmailMenu()
	{
		System.out.println("Please enter a comand");
		System.out.println("I: log in");
		System.out.println("S: send a message");
		System.out.println("R: read the next unread message");
		System.out.println("O: log out");
		System.out.println("D: Display All");
		System.out.println("Q: quit");
		System.out.println(">>>>>>");
		
		String option = kb.nextLine();
		return option;
	}
	/**
	 * This method runs the messaging system. 
	 * @param s messaging system
	 */
	public void run(MessagingSystem s)
    {
		msgSystem=s;
    	String command = displayEmailMenu();
    	while (!command.equals("Q"))
    	{
    		chooseCommand(command);
    		command = displayEmailMenu();
    	}
    	if(command.equals("Q"))
			quitProgram();
    }
	/**
	 * When a certain command is picked different methods are invoked
	 * depending on what the user decides to do.
	 * @param command what the user decides to pick
	 */
	private void chooseCommand(String command) {
		if (command.equals("I"))
				loginUser();
		
		if (command.equals("S"))
				sendMessage();
		
		if(command.equals("R"))
		{
			readMessage(message);
		}
		if(command.equals("O"))
		{
				logOut();
		}
		if(command.equals("D"))
		{
			displayAll(mailbox);
		}
}
	/**
	 * This method displays the messages either by sender or by timeSent.
	 * The user has the option to pick by either
	 * typing N or T
	 * @param m- the user's mailbox
	 */
	private void displayAll(Mailbox m) 
	{
		System.out.println("If you wish to sort your messages by recipient name, enter N");
		System.out.println("If you wish to sort your messages by time sent, enter T");
		String choice= kb.nextLine();
		if (choice.equalsIgnoreCase("N"))
			{
				System.out.println("Messages sorted by Sender");
				m= msgSystem.checkForBox(userName);
				if(m!= null)
				{	
				m.sortMessageBySender();
				Message msg=m.getMessage();	
				msg.displayMessage();
	            
				}
			}else
				if	(choice.equalsIgnoreCase("T"))
				{ 
					System.out.println("Messages sorted by sent time");
					m= msgSystem.checkForBox(userName);
					if(m!= null)
					{
						m.sortMessageByTime();
						Message msg=m.getMessage();
						msg.displayMessage();
					}
				}	
	}

	/**
	 * This method logs in a user. If the name entered 
	 * does not have a mailbox then one is created. 
	 */
	private void loginUser() 
	{
		System.out.print("Username: ");
		userName = kb.nextLine();
		if (msgSystem.checkForBox(userName)== null)
		{
		   msgSystem.addNewUser(userName);
		   System.out.println("New user: " + userName +  " added");
		}
		System.out.println("User has logged in");
	}	
	
	/**
	 * This method sends messages. It creates a message and then
	 * sends the message to a recipient.
	 * @return message that is sent
	 */
	
	private Message sendMessage(){
		if (userName== null)
			   System.out.println("Cannot send Message, must first log in");
			else
			{  
				System.out.print("Send Message to: ");
				String recipient = kb.nextLine();
			   if (!msgSystem.userHaveBox(recipient))
			   		{
				   		System.out.println("Entered recipient does not have a Mailbox");
				   		return null;
			   		}
			    txt = " ";
			    System.out.println("Enter message and then enter * to send Message");
			    String end = kb.nextLine();
			      while (!end.equalsIgnoreCase("*"))
			      {           
			         txt = txt + end + "\n";
			         end = kb.nextLine();
			      }
			      System.out.println("Message has been sent");
			     Message msg = new Message(userName, txt, recipient);
			     if (msg != null)
			     	{
			    	 int d = msgSystem.deliverToRecip(msg);
			    	 LocalDateTime time= msg.now();
			    	 if (d==0)
			    		 System.out.println("Message was successfully delivered!");
			    	 if(d==-1)
				   System.out.println("Sorry, message could not be delivered");
			   }
			   return msg;
		}
		return message;		
	
	}
	
	/**
	 * This method gets the unread messages from a mailbox.
	 * If there are no messages a message is printed stating there are no new messages.
	 * If there are messages then they are displayed.
	 * @param m- message
	 */
	private void readMessage(Message m)
	{
		if (userName == null)
            System.out.println("Cannot read message, must log in first");
         else
         {
            m = msgSystem.getUnreadMessage(userName);
            if (m == null)
         	   System.out.println("Sorry, you have no new unread messages");
            else
            System.out.println(m.displayMessage());
         }

	}
	/**
	 * This method logs a user out of the messaging system.
	 */
	private void logOut()
	{
		System.out.println(userName + " logged out");
		userName=null;
	}
	/**
	 * This method allows the user to quit the program once they 
	 * decide they are finished with the email simualation
	 */
	private void quitProgram()
	{
		System.out.println("End of Simulation");
	}	
}

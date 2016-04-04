package cus1156.project2;

import java.util.HashMap;
import java.util.Scanner; 

/**
 * This class is one Messaging System that stores and manages a collection of Mailboxes.
 * @author CelesteG
 *
 */
public class MessagingSystem {
	Scanner kb= new Scanner(System.in);
	private HashMap<String, Mailbox> mailboxCollection;
	
	
	/**
	 * contructs a messageSystem
	 */
	
	public  MessagingSystem()
    	{
			mailboxCollection = new HashMap<String, Mailbox>();
    	}
	/**
	 * This method gets the unreadMessages in a mailbox
	 * the mailbox is checked to see it it exists
	 * @param username
	 * @return the message 
	 */
	public Message getUnreadMessage(String username)
	{
		 Mailbox mailbox = checkForBox(username);
		   if (mailbox == null)
		   	{
			   return null;
		   	}
		   if (mailbox.checkMailbox())
		   	{
		       return null;
		   	}
		   return mailbox.getMessage();
	}
	/**
	 * This method adds new users who do not have a mailbox.
	 * @param username
	 */
	public void addNewUser(String username)
	 {
		
		 Mailbox mailbox= new Mailbox(username);
		 mailboxCollection.put(username, mailbox);
		 
	 }
	/**
	 * This method checks for someone's mailbox in 
	 * the messaging system.
	 * @param username
	 * @return the mailbox if user has a mailbox.
	 */

	public Mailbox checkForBox( String username) 
	{
		for (Mailbox m : mailboxCollection.values())
         if (m.getUser().equals(username))
            return m;
			return null;
	}
	/**
	 * This method delivers the message to the recipient by adding the 
	 * the message to their mailbox.
	 * @param message
	 * @return -1 if the box is empty and 0 when message is added.
	 */

	public int deliverToRecip(Message message)
	{
		Mailbox m = checkForBox(message.getRecipient());
	      if (m == null)
	    	  return -1;
	      	m.addMessage(message);
	      		return 0;
	}
	/**
	 * This method checks if the username entered has a mailbox.
	 * @param username
	 * @return true if mailbox username and name entered are the same
	 * and false if they are not the same.
	 */
	 public boolean userHaveBox(String username)
	 {
		 for (Mailbox mailbox: mailboxCollection.values())
		 {
			 if(mailbox.getUser().equals(username))
			 	{
				 return true;
				 }
		 }
		return false;
	 }
	 
	 
     }






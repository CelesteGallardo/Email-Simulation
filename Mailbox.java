package cus1156.project2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * This class represents one mailbox. An array of messages are stored in a Mailbox. 
 * The mailbox can add messages, gets unread messages, return the name of a user, check if a mailbox exists, and sort messages.
 * @author CelesteG
 *
 */
public class Mailbox {  
	
	private ArrayList<Message> messages= new ArrayList<Message>();
	private String username;
	
	/**
	 * Constructs a mailbox with a User.
	 * @param username
	 */
	public Mailbox(String username) 
	{
		this.username=username;
		
	}
	
	/**
	 * This method adds newMessages to the mailbox.
	 * @param newMessage
	 */
	
	public void addMessage(Message newMessage)
	{
		messages.add(newMessage);
	}
	
	/**
	 * This method returns a unread message. Once it is read it is removed from the mailbox.
	 * @return message
	 */
	
	public Message getMessage() 
	{
		Message message= messages.remove(0);
		return message;
	}	
	
	/**
	 * This method gets the name of the user
	 * @return username
	 */
	public String getUser()
	{
		return username;
	}
	
	/**
	 * This method checks to see if the mailbox is empty or if it has messages.
	 * @return true is mailbox has no messages and false if there are messages.
	 */
	
	public boolean checkMailbox()
	{
		if(messages.size()==0)
		{
			return true;
		}
			else
				return false;
		}
	
	/**
	 * This method sorts the messages in a mailbox by sender name.
	 * It then displays the sorted messages
	 */
	
	public void sortMessageBySender()
 		{
			Comparator<Message> comp= new MessageComparatorByRecip();
			Collections.sort(messages, comp);
			for (Message m : messages)
				System.out.println(m.displayMessage());
 		}
	/**
	 * This method sorts the messages in a mailbox by the time the message was sent
	 * It then displays the sorted messages
	 */
	public void sortMessageByTime()
 		{
		
		Collections.sort(messages);
			for(Message m : messages)
				System.out.println(m.displayMessage());
 		}
	
	}


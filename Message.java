package cus1156.project2;

import java.util.Comparator;

import java.time.LocalDateTime;


/**
 * This class represents one message. The message has message content, has a sender, a recipient, and is displayed.
 * @author CelesteG
 * @param <LocalDateTime>
 *
 */
public class Message implements Comparable<Message>{ 
	private String messageContent;
	private String sender;
	private String recipient;
	private LocalDateTime timeSent;
	
		/**
		 * This contructs a message.
		 * @param sender- Person who sent the message
		 * @param messageContent- message txt
		 * @param recipient- the recipient of the message
		 */
		public Message(String sender,String messageContent, String recipient) 
		{
			this.sender=sender;
			this.messageContent=messageContent;
			this.recipient=recipient;
		}
		
		/**
		 * This method displays message.
		 * @return the message with info regarding who sent it and the message txt.
		 */
		
		public String displayMessage()
		{
			return "New Message sent from: " + sender +"\n" + "Message Content: "+ messageContent ;
		}
		
		/**
		 * This method gets the recipient of the message
		 * @return the recipient
		 */
		
		public String getRecipient()
		{
			return recipient;
		}
		
		/**
		 * This method gets the sender of the message
		 * @return the sender
		 */
		
		public String getSender()
		{
			return sender;
		}
		
		/**
		 * This method is gets time now.
		 * @return the time at the moment now is called.
		 */
		public LocalDateTime now()
		{
			return timeSent;
		}
		
		/**
		 * This method compares the timeSent of messages.
		 */
		@Override
		public int compareTo(Message o) {
			if( timeSent == o.timeSent){
			return -1;}
			if(timeSent!=o.timeSent){
			return 1;}
			return 0;
		}

	}



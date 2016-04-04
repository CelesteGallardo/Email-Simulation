package cus1156.project2;



import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MailboxTest {
	private Mailbox testBox;
	@Before
	public void setUp() throws Exception {
			testBox = new Mailbox("Jess");

	}

	@Test
	public void testAddMessage() {
		testBox.addMessage(new Message("Max", "I like pie" , "Jess"));
		testBox.addMessage(new Message("Alex", "I love ice cream", "Jess"));
		assertEquals(testBox.checkMailbox(), false);
	}

	@Test
	public void testGetMessage() {
		testBox.addMessage(new Message("Sam", "Hello", "Jess"));
		Message m = testBox.getMessage();
		String test= m.displayMessage();
		String i="New Message sent from: " + "Sam"+ "\n" + "Message Content: "+ "Hello";
		assertEquals(test, i );

	}

	@Test
	public void testGetUser() {
		testBox.getUser();
		assertEquals(testBox.getUser(), "Jess");
		
	}

	@Test
	public void testCheckMailbox() {
		boolean mbox = testBox.checkMailbox();
		assertEquals(mbox, true );
	}

	@Test
	public void testSortMessageBySender() {
		testBox.addMessage(new Message("Alexa", "I like pie" , "Jess"));
		testBox.addMessage(new Message("Meg", "I love ice cream", "Jess"));
		testBox.sortMessageBySender();
		Message m= testBox.getMessage();
		String p= m.displayMessage();
		String l= "New Message sent from: " + "Alexa"+ "\n" + "Message Content: "+ "I like pie";
		assertEquals(p,l );

	}

	@Test
	public void testSortMessageByTime() {
		testBox.addMessage(new Message("Cara", "I like pie" , "Alex"));
		testBox.addMessage(new Message("Blake", "I love ice cream", "Alex"));
		testBox.addMessage(new Message("Jess", "I hate butter", "Alex"));
		testBox.sortMessageByTime();
		Message m= testBox.getMessage();
		String p= m.displayMessage();
		assertEquals(p, "New Message sent from: " + "Jess"+ "\n" + "Message Content: "+ "I hate butter");
	

	}

}

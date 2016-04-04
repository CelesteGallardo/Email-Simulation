package cus1156.project2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MessagingSystemTest {
	private MessagingSystem system;

	@Before
	public void setUp() throws Exception {
		system = new MessagingSystem();

	}

	@Test
	public void testGetUnreadMessage() {
		Mailbox m= new Mailbox("Jess");
		Message msg = new Message("Jess", "I love you", "Derek");
		system.getUnreadMessage("Jess");
		assertEquals(system.getUnreadMessage("Jess"), null);
	}

	@Test
	public void testAddNewUser() {
		system.addNewUser("Max");
		Mailbox m= new Mailbox("Max");
		boolean choice=system.userHaveBox("Max");
		assertEquals(true, choice);
	}

	@Test
	public void testCheckForBox() {
		Mailbox m= new Mailbox("Sam");
		assertEquals(null, system.checkForBox("Jake"));
	}

	@Test
	public void testDeliverToRecip() {
		Mailbox m= new Mailbox("Jess");
		Mailbox m2= new Mailbox("Sam");
		Message msg= new Message( "Jess", "Cookies are yummy", "Sam");
		system.deliverToRecip(msg);
		assertEquals(system.deliverToRecip(msg), -1);

	}

	@Test
	public void testUserHaveBox() {

		Mailbox m= new Mailbox("Jake");
		assertEquals(system.userHaveBox("Mike"), false);
	}

}

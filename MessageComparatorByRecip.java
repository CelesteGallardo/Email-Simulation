package cus1156.project2;

import java.util.Comparator;

public class MessageComparatorByRecip implements Comparator<Message>{

	@Override
	public int compare(Message o1, Message o2) {
		
		return o1.getSender().compareTo(o2.getSender());
	}

}

package homework_22_12_2018.phones;

import java.util.ArrayList;
import java.util.List;

public class Messages {

	private List<Message> messages = new ArrayList<Message>();

	public List<Message> getMessages() {
		return messages;
	}
	
	public void addMessage (Message message) {
		messages.add(message);
	}

}

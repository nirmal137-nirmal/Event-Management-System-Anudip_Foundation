package model;

import java.util.ArrayList;
import java.util.List;

public class Event {
	
	 private int event_id;
	    private String event_name;
	    private String event_date;
	    private String location;
	    private int organizer_id; // Links to User entity
	    
	    
	    // No-args constructor
	    public Event() {
	        super();
	    }
	    
	 // Parameterized constructor
		public Event(int event_id, String event_name, String event_date, String location, int organizer_id) {
			super();
			this.event_id = event_id;
			this.event_name = event_name;
			this.event_date = event_date;
			this.location = location;
			this.organizer_id = organizer_id;
		}
		
		
		// Getter and Setter methods
		public int getEvent_id() {
			return event_id;
		}
		public void setEvent_id(int event_id) {
			this.event_id = event_id;
		}
		public String getEvent_name() {
			return event_name;
		}
		public void setEvent_name(String event_name) {
			this.event_name = event_name;
		}
		public String getEvent_date() {
			return event_date;
		}
		public void setEvent_date(String event_date) {
			this.event_date = event_date;
		}
		public String getLocation() {
			return location;
		}
		public void setLocation(String location) {
			this.location = location;
		}
		public int getOrganizer_id() {
			return organizer_id;
		}
		public void setOrganizer_id(int organizer_id) {
			this.organizer_id = organizer_id;
		}
		@Override
		public String toString() {
			return "Event [event_id=" + event_id + ", event_name=" + event_name + ", event_date=" + event_date
					+ ", location=" + location + ", organizer_id=" + organizer_id + "]";
		}
	    
		
		public List<Event> displayEvents() {
		    List<Event> events = new ArrayList<>();
		    // Logic to retrieve events from the database
		    return events;
		}

	    

}

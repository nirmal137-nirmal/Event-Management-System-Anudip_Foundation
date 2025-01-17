package dao;

import java.util.List;

import model.Event;

public interface EventDAO {
	
	boolean saveEvent(Event e);
    List<Event> displayEvents();
    Event findEventById(int id);
    boolean updateEvent(Event e);
    boolean deleteEvent(int id);

//    boolean saveEvent(Event e);  // Save a new event
//    Event findEventById(int id);  // Find event by ID
//    List<Event> displayEvent();  // Display all events
//    boolean updateEvent(Event e);  // Update event details
//    boolean deleteEvent(int id);  // Delete an event by ID

}

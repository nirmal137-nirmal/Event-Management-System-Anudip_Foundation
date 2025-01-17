package daoimpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import dao.EventDAO;
import model.Event;
import utility.ConnectionProvider;

public class EventDAOImpl implements EventDAO {
	
	 @Override
	    public boolean saveEvent(Event e) {
	        String query = "INSERT INTO events (event_name, event_date, location, organizer_id) VALUES (?, ?, ?, ?)";
	        try (Connection conn = ConnectionProvider.getConnection();
	             PreparedStatement ps = conn.prepareStatement(query)) {
	            ps.setString(1, e.getEvent_name());
	            ps.setString(2, e.getEvent_date());
	            ps.setString(3, e.getLocation());
	            ps.setInt(4, e.getOrganizer_id());
	            return ps.executeUpdate() > 0;
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	        return false;
	    }

	    @Override
	    public List<Event> displayEvents() {
	        List<Event> eventList = new ArrayList<>();
	        String query = "SELECT * FROM events";
	        try (Connection conn = ConnectionProvider.getConnection();
	             PreparedStatement ps = conn.prepareStatement(query);
	             ResultSet rs = ps.executeQuery()) {
	            while (rs.next()) {
	                eventList.add(new Event(
	                        rs.getInt("event_id"),
	                        rs.getString("event_name"),
	                        rs.getString("event_date"),
	                        rs.getString("location"),
	                        rs.getInt("organizer_id")));
	            }
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	        return eventList;
	    }

	    @Override
	    public Event findEventById(int id) {
	        String query = "SELECT * FROM events WHERE event_id = ?";
	        try (Connection conn = ConnectionProvider.getConnection();
	             PreparedStatement ps = conn.prepareStatement(query)) {
	            ps.setInt(1, id);
	            ResultSet rs = ps.executeQuery();
	            if (rs.next()) {
	                return new Event(
	                        rs.getInt("event_id"),
	                        rs.getString("event_name"),
	                        rs.getString("event_date"),
	                        rs.getString("location"),
	                        rs.getInt("organizer_id"));
	            }
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	        return null;
	    }

	    @Override
	    public boolean updateEvent(Event e) {
	        String query = "UPDATE events SET event_name = ?, event_date = ?, location = ? WHERE event_id = ?";
	        try (Connection conn = ConnectionProvider.getConnection();
	             PreparedStatement ps = conn.prepareStatement(query)) {
	            ps.setString(1, e.getEvent_name());
	            ps.setString(2, e.getEvent_date());
	            ps.setString(3, e.getLocation());
	            ps.setInt(4, e.getEvent_id());
	            return ps.executeUpdate() > 0;
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	        return false;
	    }

	    @Override
	    public boolean deleteEvent(int id) {
	        String query = "DELETE FROM events WHERE event_id = ?";
	        try (Connection conn = ConnectionProvider.getConnection();
	             PreparedStatement ps = conn.prepareStatement(query)) {
	            ps.setInt(1, id);
	            return ps.executeUpdate() > 0;
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	        return false;
	    }
	}

//    @Override
//    public boolean saveEvent(Event e) {
//        String query = "INSERT INTO events (event_name, organizer_id, event_date, location) VALUES (?, ?, ?, ?)";
//        try (Connection conn = ConnectionProvider.getConnection();
//             PreparedStatement ps = conn.prepareStatement(query)) {
//            ps.setString(1, e.getEvent_name());
//            ps.setInt(2, e.getOrganizer_id());
//            ps.setString(3, e.getEvent_date());
//            ps.setString(4, e.getLocation());
//            return ps.executeUpdate() > 0;
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        return false;
//    }
//
//    @Override
//    public Event findEventById(int id) {
//        String query = "SELECT * FROM events WHERE event_id = ?";
//        try (Connection conn = ConnectionProvider.getConnection();
//             PreparedStatement ps = conn.prepareStatement(query)) {
//            ps.setInt(1, id);
//            ResultSet rs = ps.executeQuery();
//            if (rs.next()) {
//                return new Event(
//                        rs.getInt("event_id"),
//                        rs.getString("event_name"),
//                        rs.getString("event_date"),
//                        rs.getString("location"),
//                        rs.getInt("organizer_id"));
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        return null;
//    }
//
//    @Override
//    public List<Event> displayEvent() {
//        List<Event> eventList = new ArrayList<>();
//        String query = "SELECT * FROM events";
//        try (Connection conn = ConnectionProvider.getConnection();
//             PreparedStatement ps = conn.prepareStatement(query);
//             ResultSet rs = ps.executeQuery()) {
//            while (rs.next()) {
//                eventList.add(new Event(
//                        rs.getInt("event_id"),
//                        rs.getString("event_name"),
//                        rs.getString("event_date"),
//                        rs.getString("location"),
//                        rs.getInt("organizer_id")));
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        return eventList;
//    }
//
//    @Override
//    public boolean updateEvent(Event e) {
//        String query = "UPDATE events SET event_name = ?, organizer_id = ?, event_date = ?, location = ? WHERE event_id = ?";
//        try (Connection conn = ConnectionProvider.getConnection();
//             PreparedStatement ps = conn.prepareStatement(query)) {
//            ps.setString(1, e.getEvent_name());
//            ps.setInt(2, e.getOrganizer_id());
//            ps.setString(3, e.getEvent_date());
//            ps.setString(4, e.getLocation());
//            ps.setInt(5, e.getEvent_id());
//            return ps.executeUpdate() > 0;
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        return false;
//    }
//
//    @Override
//    public boolean deleteEvent(int id) {
//        String query = "DELETE FROM events WHERE event_id = ?";
//        try (Connection conn = ConnectionProvider.getConnection();
//             PreparedStatement ps = conn.prepareStatement(query)) {
//            ps.setInt(1, id);
//            return ps.executeUpdate() > 0;
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        return false;
//    }
//}

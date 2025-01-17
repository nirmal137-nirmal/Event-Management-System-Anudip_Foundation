package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.UserDAO;
import model.User;
import utility.ConnectionProvider;

public class UserDAOImpl implements UserDAO{
	
	
	 @Override
	    public boolean saveUser(User u) {
	        String query = "INSERT INTO users (name, email, contact) VALUES (?, ?, ?)";
	        try (Connection conn = ConnectionProvider.getConnection();
	             PreparedStatement ps = conn.prepareStatement(query)) {
	            ps.setString(1, u.getName());
	            ps.setString(2, u.getEmail());
	            ps.setLong(3, u.getContact());
	            return ps.executeUpdate() > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return false;
	    }

	    @Override
	    public User findUserById(int id) {
	        String query = "SELECT * FROM users WHERE user_id = ?";
	        try (Connection conn = ConnectionProvider.getConnection();
	             PreparedStatement ps = conn.prepareStatement(query)) {
	            ps.setInt(1, id);
	            ResultSet rs = ps.executeQuery();
	            if (rs.next()) {
	                return new User(rs.getInt("user_id"), rs.getString("name"), rs.getString("email"), rs.getLong("contact"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return null;
	    }

	    @Override
	    public List<User> displayUser() {
	        List<User> userList = new ArrayList<>();
	        String query = "SELECT * FROM users";
	        try (Connection conn = ConnectionProvider.getConnection();
	             PreparedStatement ps = conn.prepareStatement(query);
	             ResultSet rs = ps.executeQuery()) {
	            while (rs.next()) {
	                userList.add(new User(rs.getInt("user_id"), rs.getString("name"), rs.getString("email"), rs.getLong("contact")));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return userList;
	    }

	    @Override
	    public boolean updateUser(User u) {
	        String query = "UPDATE users SET name = ?, email = ?, contact = ? WHERE user_id = ?";
	        try (Connection conn = ConnectionProvider.getConnection();
	             PreparedStatement ps = conn.prepareStatement(query)) {
	            ps.setString(1, u.getName());
	            ps.setString(2, u.getEmail());
	            ps.setLong(3, u.getContact());
	            ps.setInt(4, u.getUser_id());
	            return ps.executeUpdate() > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return false;
	    }

	    @Override
	    public boolean deleteUser(int id) {
	        String query = "DELETE FROM users WHERE user_id = ?";
	        try (Connection conn = ConnectionProvider.getConnection();
	             PreparedStatement ps = conn.prepareStatement(query)) {
	            ps.setInt(1, id);
	            return ps.executeUpdate() > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return false;
	    }

	    public List<User> displayUsers() {
	        List<User> users = new ArrayList<>();
	        // Additional logic to retrieve users from the database can be added here
	        return users;
	    }
	}
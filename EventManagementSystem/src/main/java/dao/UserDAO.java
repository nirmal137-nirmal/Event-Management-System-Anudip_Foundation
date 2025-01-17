package dao;

import java.util.List;

import model.User;

public interface UserDAO {
	
	
	 boolean saveUser(User u);  // Save a new user
	    User findUserById(int id);  // Find user by ID
	    List<User> displayUser();  // Display all users
	    boolean updateUser(User u);  // Update user details
	    boolean deleteUser(int id);  // Delete a user by ID
	    
//	 boolean saveUser(User u);  // Save a new user
//	    User findUserById(int id);  // Find user by ID
//	    List<User> displayUser();  // Display all users
//	    boolean updateUser(User u);  // Update user details
//	    boolean deleteUser(int id);  // Delete a user by ID

}

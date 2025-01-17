package com.event.com.EventManagementSystem;


import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import daoimpl.AttendanceDAOImpl;
import daoimpl.EventDAOImpl;
import daoimpl.UserDAOImpl;
import model.*;

public class Menu {
		Scanner sc = new Scanner(System.in);

		public void displayMenu() {
			
        char choice = 'y';
        do {
            try {
                System.out.println("--------MAIN MENU--------");
                System.out.println("1. User Menu");
                System.out.println("2. Event Menu");
                System.out.println("3. Attendance Menu");
                System.out.println("9. Exit");
                System.out.println("-------------------------");
                System.out.println("Choose an option:");
                int ch = sc.nextInt();
                switch (ch) {
                    case 1:
                        userMenu();
                        break;
                    case 2:
                        eventMenu();
                        break;
                    case 3:
                        attendanceMenu();
                        break;
                    case 9:
                        System.out.println("Closing Application...");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid input, try again!");
                }
            } catch (InputMismatchException e) {
                System.err.println("Please enter a valid numeric option.");
                sc.nextLine(); // Clear invalid input
            } catch (Exception e) {
                System.err.println("An error occurred: " + e.getMessage());
            }
            System.out.println("Do you want to continue (y/n):");
            choice = sc.next().charAt(0);
        } while (choice == 'y' || choice == 'Y');
    }

    public void userMenu() {
        char choice = 'y';
        UserDAOImpl userDao = new UserDAOImpl();
        do {
            try {
                System.out.println("--------USER MENU--------");
                System.out.println("1. Register User");
                System.out.println("2. View Users");
                System.out.println("3. Search User by ID");
                System.out.println("4. Update User");
                System.out.println("5. Delete User");
                System.out.println("8. Return to Main Menu");
                System.out.println("9. Exit");
                System.out.println("-------------------------");
                System.out.println("Choose an option:");
                int ch = sc.nextInt();
                switch (ch) {
                    case 1:
                        System.out.println("Enter user details:");
                        sc.nextLine();
                        System.out.println("Enter name:");
                        String name = sc.nextLine();
                        System.out.println("Enter email:");
                        String email = sc.nextLine();
                        System.out.println("Enter contact:");
                        long contact = sc.nextLong();
                        User user = new User(0, name, email, contact);
                        if (userDao.saveUser(user))
                            System.out.println("User created successfully!");
                        else
                            System.out.println("Failed to create user, try again!");
                        break;
                    case 2:
                        List<User> users = userDao.displayUsers();
                        if (users.isEmpty()) {
                            System.out.println("No users found.");
                        } else {
                            System.out.println("Users List:");
                            for (User u : users)
                                System.out.println(u);
                        }
                        break;
                    case 3:
                        System.out.println("Enter user ID:");
                        int userId = sc.nextInt();
                        User foundUser = userDao.findUserById(userId);
                        if (foundUser != null) {
                            System.out.println("User found: " + foundUser);
                        } else {
                            System.out.println("User not found.");
                        }
                        break;
                    case 4:
                        System.out.println("Enter user ID to update:");
                        int updateUserId = sc.nextInt();
                        if (userDao.findUserById(updateUserId) != null) {
                            sc.nextLine();
                            System.out.println("Enter new name:");
                            String newName = sc.nextLine();
                            System.out.println("Enter new email:");
                            String newEmail = sc.nextLine();
                            System.out.println("Enter new contact:");
                            long newContact = sc.nextLong();
                            User updatedUser = new User(updateUserId, newName, newEmail, newContact);
                            if (userDao.updateUser(updatedUser))
                                System.out.println("User updated successfully!");
                        } else {
                            System.out.println("User not found.");
                        }
                        break;
                    case 5:
                        System.out.println("Enter user ID to delete:");
                        int deleteUserId = sc.nextInt();
                        if (userDao.deleteUser(deleteUserId)) {
                            System.out.println("User deleted successfully.");
                        } else {
                            System.out.println("Failed to delete user.");
                        }
                        break;
                    case 8:
                        displayMenu();
                        break;
                    case 9:
                        System.out.println("Closing Application...");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid input, try again!");
                }
            } catch (InputMismatchException e) {
                System.err.println("Please enter a valid numeric option.");
                sc.nextLine(); // Clear invalid input
            }
            System.out.println("Do you want to continue (y/n):");
            choice = sc.next().charAt(0);
        } while (choice == 'y' || choice == 'Y');
    }

    public void eventMenu() {
        char choice = 'y';
        EventDAOImpl eventDao = new EventDAOImpl();
        do {
            try {
                System.out.println("--------EVENT MENU--------");
                System.out.println("1. Create Event");
                System.out.println("2. View Events");
                System.out.println("3. Search Event by ID");
                System.out.println("4. Update Event");
                System.out.println("5. Delete Event");
                System.out.println("8. Return to Main Menu");
                System.out.println("9. Exit");
                System.out.println("-------------------------");
                System.out.println("Choose an option:");
                int ch = sc.nextInt();
                switch (ch) {
                    case 1:
                        sc.nextLine();
                        System.out.println("Enter event name:");
                        String eventName = sc.nextLine();
                        System.out.println("Enter event date:");
                        String eventDate = sc.nextLine();
                        System.out.println("Enter event location:"); // Add this line
                        String location = sc.nextLine(); // Add this line
                        System.out.println("Enter organizer ID:");
                        int organizerId = sc.nextInt();

                        // Pass the location to the constructor
                        Event event = new Event(0, eventName, eventDate, location, organizerId);
                        if (eventDao.saveEvent(event))
                            System.out.println("Event created successfully!");
                        else
                            System.out.println("Failed to create event, try again!");
                        break;
                    case 2:
                        List<Event> events = eventDao.displayEvents();
                        if (events.isEmpty()) {
                            System.out.println("No events found.");
                        } else {
                            System.out.println("Events List:");
                            for (Event e : events)
                                System.out.println(e);
                        }
                        break;
                    case 3:
                        System.out.println("Enter event ID:");
                        int eventId = sc.nextInt();
                        Event foundEvent = eventDao.findEventById(eventId);
                        if (foundEvent != null) {
                            System.out.println("Event found: " + foundEvent);
                        } else {
                            System.out.println("Event not found.");
                        }
                        break;
                    case 4:
                        System.out.println("Enter event ID to update:");
                        int updateEventId = sc.nextInt();
                        if (eventDao.findEventById(updateEventId) != null) {
                            sc.nextLine();
                            System.out.println("Enter new event name:");
                            String newEventName = sc.nextLine();
                            System.out.println("Enter new event date:");
                            String newEventDate = sc.nextLine();
                            System.out.println("Enter new event location:"); // Add this
                            String newLocation = sc.nextLine(); // Add this
                            
                            // Pass the location to the constructor
                            Event updatedEvent = new Event(updateEventId, newEventName, newEventDate, newLocation, 0);
                            
                            if (eventDao.updateEvent(updatedEvent))
                                System.out.println("Event updated successfully!");
                        } else {
                            System.out.println("Event not found.");
                        }
                        break;
                    case 5:
                        System.out.println("Enter event ID to delete:");
                        int deleteEventId = sc.nextInt();
                        if (eventDao.deleteEvent(deleteEventId)) {
                            System.out.println("Event deleted successfully.");
                        } else {
                            System.out.println("Failed to delete event.");
                        }
                        break;
                    case 8:
                        displayMenu();
                        break;
                    case 9:
                        System.out.println("Closing Application...");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid input, try again!");
                }
            } catch (InputMismatchException e) {
                System.err.println("Please enter a valid numeric option.");
                sc.nextLine(); // Clear invalid input
            }
            System.out.println("Do you want to continue (y/n):");
            choice = sc.next().charAt(0);
        } while (choice == 'y' || choice == 'Y');
    }

    public void attendanceMenu() {
        char choice = 'y';
        AttendanceDAOImpl attendanceDao = new AttendanceDAOImpl();
        do {
            try {
                System.out.println("------ATTENDANCE MENU------");
                System.out.println("1. Mark Attendance");
                System.out.println("2. View Attendance");
                System.out.println("3. Search Attendance by ID");
                System.out.println("4. Update Attendance");
                System.out.println("5. Delete Attendance");
                System.out.println("8. Return to Main Menu");
                System.out.println("9. Exit");
                System.out.println("---------------------------");
                System.out.println("Choose an option:");
                int ch = sc.nextInt();
                switch (ch) {
                    case 1:
                        System.out.println("Enter user ID:");
                        int userId = sc.nextInt();
                        System.out.println("Enter event ID:");
                        int eventId = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter status (present/absent):");
                        String status = sc.nextLine();
                        Attendance attendance = new Attendance(0, userId, eventId, status);
                        if (attendanceDao.saveAttendance(attendance))
                            System.out.println("Attendance marked successfully!");
                        else
                            System.out.println("Failed to mark attendance, try again!");
                        break;
                    case 2:
                        List<Attendance> attendances = attendanceDao.displayAttendances();
                        if (attendances.isEmpty()) {
                            System.out.println("No attendance records found.");
                        } else {
                            System.out.println("Attendance List:");
                            for (Attendance a : attendances)
                                System.out.println(a);
                        }
                        break;
                    case 3:
                        System.out.println("Enter attendance ID:");
                        int attendanceId = sc.nextInt();
                        Attendance foundAttendance = attendanceDao.findAttendanceById(attendanceId);
                        if (foundAttendance != null) {
                            System.out.println("Attendance found: " + foundAttendance);
                        } else {
                            System.out.println("Attendance not found.");
                        }
                        break;
                    case 4:
                        System.out.println("Enter attendance ID to update:");
                        int updateAttendanceId = sc.nextInt();
                        if (attendanceDao.findAttendanceById(updateAttendanceId) != null) {
                            sc.nextLine();
                            System.out.println("Enter new status (present/absent):");
                            String newStatus = sc.nextLine();
                            Attendance updatedAttendance = new Attendance(updateAttendanceId, 0, 0, newStatus);
                            if (attendanceDao.updateAttendance(updatedAttendance))
                                System.out.println("Attendance updated successfully!");
                        } else {
                            System.out.println("Attendance not found.");
                        }
                        break;
                    case 5:
                        System.out.println("Enter attendance ID to delete:");
                        int deleteAttendanceId = sc.nextInt();
                        if (attendanceDao.deleteAttendance(deleteAttendanceId)) {
                            System.out.println("Attendance deleted successfully.");
                        } else {
                            System.out.println("Failed to delete attendance.");
                        }
                        break;
                    case 8:
                        displayMenu();
                        break;
                    case 9:
                        System.out.println("Closing Application...");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid input, try again!");
                }
            } catch (InputMismatchException e) {
                System.err.println("Please enter a valid numeric option.");
                sc.nextLine(); // Clear invalid input
            }
            System.out.println("Do you want to continue (y/n):");
            choice = sc.next().charAt(0);
        } while (choice == 'y' || choice == 'Y');
    }
}

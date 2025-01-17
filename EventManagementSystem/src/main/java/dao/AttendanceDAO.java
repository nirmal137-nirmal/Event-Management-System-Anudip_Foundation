package dao;

import java.util.List;

import model.Attendance;

public interface AttendanceDAO {
	
	
	 boolean saveAttendance(Attendance attendance);
	    List<Attendance> displayAttendances();
	    Attendance findAttendanceById(int attendanceId);
	    boolean updateAttendance(Attendance attendance);
	    boolean deleteAttendance(int attendanceId);
	
	
//	boolean saveAttendance(Attendance a);  // Save attendance record
//    Attendance findAttendanceById(int id);  // Find attendance record by ID
//    List<Attendance> displayAttendance();  // Display all attendance records
//    boolean updateAttendance(Attendance a);  // Update attendance details
//    boolean deleteAttendance(int id);  // Delete attendance by ID

}





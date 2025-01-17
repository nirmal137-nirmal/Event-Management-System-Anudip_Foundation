package daoimpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import dao.AttendanceDAO;
import model.Attendance;
import utility.ConnectionProvider;

public class AttendanceDAOImpl  implements AttendanceDAO{
	
	@Override
    public boolean saveAttendance(Attendance attendance) {
        boolean isSuccess = false;
        try (Connection con = ConnectionProvider.getConnection();
             PreparedStatement ps = con.prepareStatement("INSERT INTO attendance (user_id, event_id, status) VALUES (?, ?, ?)")) {
            ps.setInt(1, attendance.getUser_id());
            ps.setInt(2, attendance.getEvent_id());
            ps.setString(3, attendance.getStatus());
            isSuccess = ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.err.println("Error saving attendance: " + e.getMessage());
        }
        return isSuccess;
    }

    @Override
    public List<Attendance> displayAttendances() {
        List<Attendance> attendanceList = new ArrayList<>();
        try (Connection con = ConnectionProvider.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM attendance");
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Attendance attendance = new Attendance(
                        rs.getInt("attendance_id"),
                        rs.getInt("user_id"),
                        rs.getInt("event_id"),
                        rs.getString("status"));
                attendanceList.add(attendance);
            }
        } catch (Exception e) {
            System.err.println("Error displaying attendances: " + e.getMessage());
        }
        return attendanceList;
    }

    @Override
    public Attendance findAttendanceById(int attendanceId) {
        Attendance attendance = null;
        try (Connection con = ConnectionProvider.getConnection();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM attendance WHERE attendance_id = ?")) {
            ps.setInt(1, attendanceId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    attendance = new Attendance(
                            rs.getInt("attendance_id"),
                            rs.getInt("user_id"),
                            rs.getInt("event_id"),
                            rs.getString("status"));
                }
            }
        } catch (Exception e) {
            System.err.println("Error finding attendance: " + e.getMessage());
        }
        return attendance;
    }

    @Override
    public boolean updateAttendance(Attendance attendance) {
        boolean isSuccess = false;
        try (Connection con = ConnectionProvider.getConnection();
             PreparedStatement ps = con.prepareStatement("UPDATE attendance SET status = ? WHERE attendance_id = ?")) {
            ps.setString(1, attendance.getStatus());
            ps.setInt(2, attendance.getAttendance_id());
            isSuccess = ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.err.println("Error updating attendance: " + e.getMessage());
        }
        return isSuccess;
    }

    @Override
    public boolean deleteAttendance(int attendanceId) {
        boolean isSuccess = false;
        try (Connection con = ConnectionProvider.getConnection();
             PreparedStatement ps = con.prepareStatement("DELETE FROM attendance WHERE attendance_id = ?")) {
            ps.setInt(1, attendanceId);
            isSuccess = ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.err.println("Error deleting attendance: " + e.getMessage());
        }
        return isSuccess;
    }
}
	
	
//
//	@Override
//	
//    public boolean saveAttendance(Attendance a) {
//        String query = "INSERT INTO attendance (user_id, event_id, status) VALUES (?, ?, ?)";
//        try (Connection conn = ConnectionProvider.getConnection();
//             PreparedStatement ps = conn.prepareStatement(query)) {
//            ps.setInt(1, a.getUser_id());
//            ps.setInt(2, a.getEvent_id());
//            ps.setString(3, a.getStatus());
//            return ps.executeUpdate() > 0;
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        return false;
//    }
//
//    @Override
//    public Attendance findAttendanceById(int id) {
//        String query = "SELECT * FROM attendance WHERE attendance_id = ?";
//        try (Connection conn = ConnectionProvider.getConnection();
//             PreparedStatement ps = conn.prepareStatement(query)) {
//            ps.setInt(1, id);
//            ResultSet rs = ps.executeQuery();
//            if (rs.next()) {
//                return new Attendance(rs.getInt("attendance_id"), rs.getInt("user_id"),
//                        rs.getInt("event_id"), rs.getString("status"));
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        return null;
//    }
//
//    @Override
//    public List<Attendance> displayAttendance() {
//        List<Attendance> attendanceList = new ArrayList<>();
//        String query = "SELECT * FROM attendance";
//        try (Connection conn = ConnectionProvider.getConnection();
//             PreparedStatement ps = conn.prepareStatement(query);
//             ResultSet rs = ps.executeQuery()) {
//            while (rs.next()) {
//                attendanceList.add(new Attendance(rs.getInt("attendance_id"), rs.getInt("user_id"),
//                        rs.getInt("event_id"), rs.getString("status")));
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        return attendanceList;
//    }
//
//    @Override
//    public boolean updateAttendance(Attendance a) {
//        String query = "UPDATE attendance SET user_id = ?, event_id = ?, status = ? WHERE attendance_id = ?";
//        try (Connection conn = ConnectionProvider.getConnection();
//             PreparedStatement ps = conn.prepareStatement(query)) {
//            ps.setInt(1, a.getUser_id());  // Use getUser_id()
//            ps.setInt(2, a.getEvent_id()); // Use getEvent_id()
//            ps.setString(3, a.getStatus()); // Use getStatus()
//            ps.setInt(4, a.getAttendance_id()); // Use getAttendance_id()
//            return ps.executeUpdate() > 0;
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        return false;
//    }
//    
//    
//    @Override
//    public boolean deleteAttendance(int id) {
//        String query = "DELETE FROM attendance WHERE attendance_id = ?";
//        try (Connection conn = ConnectionProvider.getConnection();
//             PreparedStatement ps = conn.prepareStatement(query)) {
//            ps.setInt(1, id);
//            return ps.executeUpdate() > 0;
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        return false;
//    }
//
//}

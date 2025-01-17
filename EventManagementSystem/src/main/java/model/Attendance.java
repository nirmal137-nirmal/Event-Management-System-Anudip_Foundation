package model;

public class Attendance {
	
	private int attendance_id;
    private int event_id;
    private int user_id;
    private String status;
    
    // No-args constructor
    public Attendance() {
        super();
    }

	public Attendance(int attendance_id, int event_id, int user_id, String status) {
		super();
		this.attendance_id = attendance_id;
		this.event_id = event_id;
		this.user_id = user_id;
		this.status = status;
	}
	
	
	// Parameterized constructor

	public int getAttendance_id() {
		return attendance_id;
	}

	public void setAttendance_id(int attendance_id) {
		this.attendance_id = attendance_id;
	}

	public int getEvent_id() {
		return event_id;
	}

	public void setEvent_id(int event_id) {
		this.event_id = event_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Attendance [attendance_id=" + attendance_id + ", event_id=" + event_id + ", user_id=" + user_id
				+ ", status=" + status + "]";
	}
    
	public boolean markAttendance(Attendance attendance) {
	    // Logic to mark attendance in the database
	    return true; // Return true if successful, false otherwise
	}

    
    

}

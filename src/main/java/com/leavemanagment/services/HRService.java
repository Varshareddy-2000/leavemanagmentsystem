package com.leavemanagment.services;
import java.util.List;

import com.leavemanagamentsystem.entities.LeaveDetailsEntity;
import com.leavemanagamentsystem.exceptions.LeaveNotFoundException;

public class HRService {
	public LeaveDetailsEntity addLeaveDetails(LeaveDetailsEntity leaveDetails);
	public List<LeaveDetailsEntity> viewAllLeaves();
	LeaveDetailsEntity checkLeaveRequest(long leaveId) throws LeaveNotFoundException;
	LeaveDetailsEntity updateLeaveStatus(LeaveDetailsEntity leaveDetails) throws LeaveNotFoundException;
	
}



package com.leavemanagment.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.leavemanagment.enumm.LeaveStatus;
import com.leavemanagment.enumm.LeaveType;

@Entity
@Table(name="LeaveDetails")
public class LeaveDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  long leaveId;
	private long employeeId;
	private LeaveType leaveType;
	private int noOfDays;
	private long Apprived;
	private LeaveStatus status;
	public LeaveDetails(long leaveId, long employeeId, LeaveType leaveType, int noOfDays, long apprived,
			LeaveStatus status) {
		super();
		this.leaveId = leaveId;
		this.employeeId = employeeId;
		this.leaveType = leaveType;
		this.noOfDays = noOfDays;
		Apprived = apprived;
		this.status = status;
	}
	public long getLeaveId() {
		return leaveId;
	}
	public void setLeaveId(long leaveId) {
		this.leaveId = leaveId;
	}
	public long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}
	public LeaveType getLeaveType() {
		return leaveType;
	}
	public void setLeaveType(LeaveType leaveType) {
		this.leaveType = leaveType;
	}
	public int getNoOfDays() {
		return noOfDays;
	}
	public void setNoOfDays(int noOfDays) {
		this.noOfDays = noOfDays;
	}
	public long getApprived() {
		return Apprived;
	}
	public void setApprived(long apprived) {
		Apprived = apprived;
	}
	public LeaveStatus getStatus() {
		return status;
	}
	public void setStatus(LeaveStatus status) {
		this.status = status;
	}
	
	
	
}
	

	
		
	
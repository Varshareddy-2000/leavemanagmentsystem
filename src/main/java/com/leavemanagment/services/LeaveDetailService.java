package com.leavemanagment.services;
import java.util.List;

import com.leavemanagementsystemhr.entities.Employee;

import com.leavemanagementsystemhr.entities.LeaveDetailEntity;

import com.leavemanagementsystemhr.enums.LeaveType;
public class LeaveDetailService {
	boolean medicalReport(long leaveId);

	 List<Employee> getAllEmployees();
}

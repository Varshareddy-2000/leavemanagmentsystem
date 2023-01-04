package com.leavemanagment.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.leavemanagment.entities.EmployeeDetails;
import com.leavemanagment.entities.LeaveDetails;
import com.leavemanagment.enumm.Employee;
import com.leavemanagment.enumm.LeaveStatus;
import com.leavemanagment.exception.EmployeeNotFoundException;
import com.leavemanagment.services.EmployeeDetailsService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
    private EmployeeDetailsService service;
	
	@GetMapping("/check/(leaveId)")
	public LeaveStatus checkLeaveStatus(@PathVariable("leaveId") long leaveId)throws  EmployeeNotFoundException{
		LeaveStatus check = this.service.checkLeaveStatus(leaveId);
		return check;
	}
	@GetMapping("/check2/(employeeId)")
	public int checkLeaveBalance(@PathVariable("employeeId") long employeeId)throws EmployeeNotFoundException{
		int check = this.service.checkLeaveBalance( employeeId);
		return check;
	}
	@PostMapping("/applyLeave")
	public LeaveDetails addLeaveDetails(@RequestBody LeaveDetails leaveDetails)
	{
		LeaveDetails addLeaveDetails = this.service.addLeaveDetails(leaveDetails);
		return addLeaveDetails;
		
		
	}
	@PostMapping("/addemployee")
	public EmployeeDetails addemployee(@RequestBody EmployeeDetails employeeDetails)
	{
		EmployeeDetails addEmployeeDetails = this.service.addemployee(employeeDetails);
		return addEmployeeDetails;
	}
	
	@GetMapping("/view")
	public List<EmployeeDetails> viewAllLeaves(){
		List<EmployeeDetails> viewAllLeaves = this.service.viewAllLeaves();
		return viewAllLeaves;
	}
	
}

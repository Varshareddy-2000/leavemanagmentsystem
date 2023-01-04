package com.leavemanagmentImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leavemanagment.entities.EmployeeDetails;
import com.leavemanagment.entities.LeaveDetails;
import com.leavemanagment.enumm.Employee;
import com.leavemanagment.enumm.LeaveStatus;
import com.leavemanagment.exception.EmployeeNotFoundException;
import com.leavemanagment.exception.InsufficientLeaveBalanceException;
import com.leavemanagment.repo.EmployeeDetailsRepo;
import com.leavemanagment.repo.LeaveDetailsRepo;
import com.leavemanagment.services.EmployeeDetailsService;

@Service

public class EmployeeServiceImpl implements EmployeeDetailsService {
	 @Autowired
	    private EmployeeDetailsRepo employeeRepository;
	 
@Autowired
private LeaveDetailsRepo leaveRepository;

	@Override
	public LeaveStatus checkLeaveStatus(long leaveId) throws EmployeeNotFoundException {
		 EmployeeDetails employee = employeeRepository.findById(leaveId).orElse(null);
	        if (employee == null) {
	            throw new EmployeeNotFoundException("Employee not found");
	        }
		
		 if (employee.getPaternityLeave() > 0 || employee.getMaternityLeave() > 0) {
		  return LeaveStatus.APPROVED;
		  } else 
		  {
			  return LeaveStatus.REJECTED; } 
		 }
		 
	
		
		
	

	@Override
	public int checkLeaveBalance(long employeeId) throws EmployeeNotFoundException{
		// TODO Auto-generated method stub
		 EmployeeDetails employee = employeeRepository.findById(employeeId).orElse(null);
		 int leaveBalance;
	        if (employee == null) {
	            throw new EmployeeNotFoundException("Employee Not Found");
	        }else {
	         leaveBalance = ((EmployeeDetails) employee).getPaternityLeave() + ((EmployeeDetails) employee).getMaternityLeave();
	        }  return leaveBalance;
	        
	}

	@Override
	public void applyLeave(long employeeId,  int numberOfDays) throws InsufficientLeaveBalanceException, EmployeeNotFoundException{ 

		// TODO Auto-generated method stub

		EmployeeDetails employee = employeeRepository.findById(employeeId).orElse(null);
        if (employee == null) {
            throw new EmployeeNotFoundException("Employee Not Found");
        }else {
        int leaveBalance = checkLeaveBalance( employeeId);
        if (numberOfDays > leaveBalance) {
            throw new InsufficientLeaveBalanceException("Insufficient Leaves");
        }
        if (employee.getGender() =='M') {
            employee.setPaternityLeave(employee.getPaternityLeave() - numberOfDays);
        } else {
            employee.setMaternityLeave(employee.getMaternityLeave() - numberOfDays);
        }
        employeeRepository.save(employee);
    }
	}

	@Override
	public EmployeeDetails addemployee(EmployeeDetails employeeId) {
		// TODO Auto-generated method stub
		EmployeeDetails save = employeeRepository.save(employeeId);
		return save;
		
	}






	@Override
	public LeaveDetails addLeaveDetails(LeaveDetails leaveDetails) {
		// TODO Auto-generated method stub
		LeaveDetails save=leaveRepository.save(leaveDetails);
		return save;
	}






	@Override
	public List<EmployeeDetails> viewAllLeaves() {
		// TODO Auto-generated method stub
		List<EmployeeDetails> findAll=this.employeeRepository.findAll();
		return findAll;
	}


	

}

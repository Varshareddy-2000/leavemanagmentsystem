package com.leavemanagmentImpl;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leavemanagamentsystem.entities.LeaveDetailsEntity;
import com.leavemanagamentsystem.exceptions.LeaveNotFoundException;
import com.leavemanagamentsystem.repo.HRServiceRepo;

public class HRServiceImpl implements IHRService{

	
	@Autowired
	private HRServiceRepo repo;
	
	@Override
	public LeaveDetailsEntity checkLeaveRequest(long leaveId) throws LeaveNotFoundException{
		
		Optional<LeaveDetailsEntity> leaveDetails = repo.findById(leaveId);
		if(leaveDetails.isPresent()) {
			return leaveDetails.get();
		}
		else {
			throw new LeaveNotFoundException("Leave Not Found");
		}
	}
	
	@Override
	public LeaveDetailsEntity updateLeaveStatus(LeaveDetailsEntity leaveDetails) throws LeaveNotFoundException {
		if(repo.existsById(leaveDetails.getLeaveId())) {
			return repo.save(leaveDetails);
		}
		else {
			throw new LeaveNotFoundException("Leave Not Found");
		}
	}
	
	@Override
	public LeaveDetailsEntity addLeaveDetails(LeaveDetailsEntity leaveDetails) {
		LeaveDetailsEntity save = this.repo.save(leaveDetails);
		return save;
		
	}
	
	@Override
	public List<LeaveDetailsEntity> viewAllLeaves() {
		List<LeaveDetailsEntity> findAll = this.repo.findAll();
		return findAll;
	}

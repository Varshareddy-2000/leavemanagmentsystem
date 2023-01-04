package com.leavemanagmentImpl;

public class LeaveServiceImpl [08:47] Priyanka, Kuppala
package com.leave.management.system.services;
 
import java.util.List;
import java.util.Optional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.leave.management.system.entities.LeaveDetailsEntity;
import com.leave.management.system.exception.LeaveNotFoundException;
import com.leave.management.system.repo.LeaveDetailRepo;
 
 

@Service
public class LeaveServiceImpl implements LeaveService{
    @Autowired
    private LeaveDetailRepo repo;
 
    @Override
    public LeaveDetailsEntity updateLeaveDetails(LeaveDetailsEntity leaveDetails) throws LeaveNotFoundException{
        if(repo.existsById(leaveDetails.getLeaveld())) {
            return repo.save(leaveDetails);
        }
        else {
            throw new LeaveNotFoundException("Leave Not Found");
        }
    }
    @Override
    public LeaveDetailsEntity checkLeaveDetails(long leaveId) throws LeaveNotFoundException{
    Optional<LeaveDetailsEntity> leaveDetails = repo.findById(leaveId);
        if(leaveDetails.isPresent()) {
            return leaveDetails.get();
        }
        else {
            throw new LeaveNotFoundException("Leave Not Found");
        }
    }
 
    @Override
    public LeaveDetailsEntity addLeaveDetails(LeaveDetailsEntity leaveDetails) {
        // TODO Auto-generated method stub
        LeaveDetailsEntity save = this.repo.save(leaveDetails);
        return save;
    }
 
    @Override
    public List<LeaveDetailsEntity> viewAllLeaves() {
        List<LeaveDetailsEntity> findAll = this.repo.findAll();
        // TODO Auto-generated method stub
        return findAll;
    }
return save;
}



@Override
public List<LeaveDetailsEntity> viewAllLeaves() {
   List<LeaveDetailsEntity> findAll = this.repo.findAll();
   // TODO Auto-generated method stub
   return findAll;
}

}
 


 



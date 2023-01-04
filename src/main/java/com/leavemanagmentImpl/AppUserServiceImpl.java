package com.leavemanagmentImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 
import com.leavemanagementsystem.entity.AppUserEntity;
import com.leavemanagementsystem.entity.Login;
import com.leavemanagementsystem.repo.AppUserRepo;


	@Service
	public class AppUserServiceImpl implements AppUserService{
	@Autowired
	private AppUserRepo repo;
	@Override
	    public AppUserEntity saveAppUserEntity(AppUserEntity userlogin2) {
	     AppUserEntity newuser=new AppUserEntity();
	    newuser.setEmployeeId(userlogin2.getEmployeeId());
	     newuser.setPassword(userlogin2.getPassword());
	     newuser.setRole(userlogin2.getRole());
	    newuser.setMobileNumber(userlogin2.getMobileNumber());
	    AppUserEntity user=this.repo.save(newuser);
	    return user;
	    }
	@Override
	    public AppUserEntity validateUserLoginEntity(Login login) {
	 
	AppUserEntity user=this.repo.findById(login.getEmployeeId()).orElse(null);
	 
	    if(user!=null && user.getPassword().equals(login.getPassword())) {
	                          return user;
	    }
	return null;
	}
	public String validateRole(AppUserEntity userlogin2) {
	     String str="";
	     if(userlogin2.getRole()==AppUserEntity.Role.EMPLOYEE){
	         str="EMPLOYEE logged in";
	     } else if(userlogin2.getRole()==AppUserEntity.Role.MANAGER){ 
	         str="MANAGER logged in";
	     }
	     else
	     {
	          str="HR logged in";
	     }
	    return str;
	}
	}
	 
	    




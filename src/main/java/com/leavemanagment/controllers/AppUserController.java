package com.leavemanagment.controllers;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

 

import com.leavemanagementsystem.entity.AppUserEntity;
import com.leavemanagementsystem.entity.Login;
import com.leavemanagementsystem.service.AppUserService;

 


@RestController
@RequestMapping("/userlogin2")
public class AppUserController {

	  @Autowired AppUserService userloginservice;

	  

	    @PostMapping("/saveUserLogin")
	    public AppUserEntity saveUserLogin(@RequestBody AppUserEntity userlogin)
	    {
	        AppUserEntity response=userloginservice.saveAppUserEntity(userlogin);
	        return response;
	    }
	    @PostMapping("/validateUserLogin")
	    public ResponseEntity validateUserLogin(@RequestBody Login login)
	    {   System.out.println(login);
	        AppUserEntity valid=userloginservice.validateUserLoginEntity(login);
	        if(valid==null)

	 

	        return ResponseEntity.badRequest().body("Incorrect credentials");
	        return ResponseEntity.ok(valid);
	    }

	 

	 
}

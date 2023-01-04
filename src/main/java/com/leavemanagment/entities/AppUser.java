package com.leavemanagment.entities;

import javax.management.relation.Role;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="AppUser")

public class AppUser {


		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private String employeeId;
		private String password;
		private Role  role;
		private long mobileNumber;
		public AppUser(String employeeId, String password, Role role, long mobileNumber) {
			super();
			this.employeeId = employeeId;
			this.password = password;
			this.role = role;
			this.mobileNumber = mobileNumber;
		}
		public String getEmployeeId() {
			return employeeId;
		}
		public void setEmployeeId(String employeeId) {
			this.employeeId = employeeId;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public Role getRole() {
			return role;
		}
		public void setRole(Role role) {
			this.role = role;
		}
		public long getMobileNumber() {
			return mobileNumber;
		}
		public void setMobileNumber(long mobileNumber) {
			this.mobileNumber = mobileNumber;
		}
		
	
		
		
	}



package com.leavemanagment.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EmployeeDetails")
public class EmployeeDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private  long employeeId;
	private String employeeName;
	private long managerId;
	private long hrld;
	private char gender;
	private int annualLeave;
	private int paternityLeave;
	private  int MaternityLeave;
	public EmployeeDetails(long employeeId, String employeeName, long manageId, long hrld, char gender, int annualLeave,
			int paternityLeave, int maternityLeave) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.managerId = manageId;
		this.hrld = hrld;
		this.gender = gender;
		this.annualLeave = annualLeave;
		this.paternityLeave = paternityLeave;
		MaternityLeave = maternityLeave;
	}
	public long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public long getManagerId() {
		return managerId;
	}
	public void setManageId(long manageId) {
		this.managerId = manageId;
	}
	public long getHrld() {
		return hrld;
	}
	public void setHrld(long hrld) {
		this.hrld = hrld;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public int getAnnualLeave() {
		return annualLeave;
	}
	public void setAnnualLeave(int annualLeave) {
		this.annualLeave = annualLeave;
	}
	public int getPaternityLeave() {
		return paternityLeave;
	}
	public void setPaternityLeave(int paternityLeave) {
		this.paternityLeave = paternityLeave;
	}
	public int getMaternityLeave() {
		return MaternityLeave;
	}
	public void setMaternityLeave(int maternityLeave) {
		MaternityLeave = maternityLeave;
	}
	

}

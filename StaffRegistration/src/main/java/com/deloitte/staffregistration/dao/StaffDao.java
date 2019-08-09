package com.deloitte.staffregistration.dao;

import com.deloitte.staffregistration.beans.Country_Info;
import com.deloitte.staffregistration.beans.Staff_Info;
import com.deloitte.staffregistration.beans.Staff_Salary;

public interface StaffDao {
	public String getMaxRegNumber();
	public boolean registerStaff(Staff_Info StaffVO);
	public double retrieveSalary(Staff_Salary SalaryVO);
	public boolean checkEmailID(String emailId);
	public String getCountryId(Country_Info ci);
}
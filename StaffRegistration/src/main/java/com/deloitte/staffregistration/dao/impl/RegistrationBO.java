package com.deloitte.staffregistration.dao.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.deloitte.staffregistration.beans.Staff_Info;
import com.deloitte.staffregistration.beans.Staff_Salary;


@Repository
public class RegistrationBO {
	@Autowired
	StaffDaoImpl dao;
	@Autowired
	Staff_Salary SalaryVO;
	public boolean registerStaff(Staff_Info StaffVO)
	{
		SalaryVO.setHighest_Qualification(StaffVO.getHighest_Qualification());
		SalaryVO.setYear_Of_Experience(StaffVO.getExperience());
		StaffVO.setSalary(dao.retrieveSalary(SalaryVO));
		if(dao.checkEmailID(StaffVO.getEmail_Id()))
			return false;
		dao.registerStaff(StaffVO);
		return true;
	}
}

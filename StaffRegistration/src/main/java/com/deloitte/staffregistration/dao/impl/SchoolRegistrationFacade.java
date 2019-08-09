package com.deloitte.staffregistration.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.deloitte.staffregistration.beans.Country_Info;
import com.deloitte.staffregistration.beans.Staff_Info;
import com.deloitte.staffregistration.beans.Staff_Salary;

@Repository
public class SchoolRegistrationFacade {
	@Autowired
	RegistrationBO rbo;
	@Autowired
	StaffDaoImpl dao;
	public Double getSalary(String highestqual,int yearsofexp)
	{
		Staff_Salary sf = new Staff_Salary();
		sf.setHighest_Qualification(highestqual);
		sf.setYear_Of_Experience(yearsofexp);
		return dao.retrieveSalary(sf);
	}
	public String getCountryCode(Country_Info ci)
	{
		return dao.getCountryId(ci);
	}
	public boolean registerStaff(Staff_Info StaffVO)
	{
		String currentmax = dao.getMaxRegNumber();
		int currentidnumber = Integer.parseInt(currentmax.substring(2));
		currentidnumber++;
		String integerid = Integer.toString(currentidnumber);
		String zeroes = "00000000";
		String nextId = "S-"+zeroes.substring(0, 3-integerid.length())+integerid;
		StaffVO.setStaff_Id(nextId);
		return rbo.registerStaff(StaffVO);
	}
}

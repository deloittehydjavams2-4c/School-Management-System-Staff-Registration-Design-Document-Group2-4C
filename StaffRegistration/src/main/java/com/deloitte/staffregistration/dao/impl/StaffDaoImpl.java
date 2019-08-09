package com.deloitte.staffregistration.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.deloitte.staffregistration.beans.Country_Info;
import com.deloitte.staffregistration.beans.Staff_Info;
import com.deloitte.staffregistration.beans.Staff_Salary;
import com.deloitte.staffregistration.dao.StaffDao;

@Repository
public class StaffDaoImpl implements StaffDao{
	@Autowired
	JdbcTemplate template;
	@Override
	public String getMaxRegNumber() 
	{
		
		String sql="select * from staff_info where staff_id=(select max(staff_id) from staff_info)";
		List<Staff_Info> maxreg = template.query(sql,new BeanPropertyRowMapper<Staff_Info>(Staff_Info.class));
		String maxregno="S-000";
		for(Staff_Info si:maxreg)
			maxregno=si.getStaff_Id();
		System.out.println(maxregno);
		return maxregno;
	}
	@Override
	public boolean registerStaff(Staff_Info StaffVO)
	{
		String sql="insert into staff_info values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		System.out.println(StaffVO.getStaff_Id()+" "+StaffVO.getStaff_Name()+" "+StaffVO.getDate_Of_Birth()+" "+StaffVO.getAddress()+" "+StaffVO.getCountry_Id()+" "+StaffVO.getGender()+" "+StaffVO.getSalary()+" "+StaffVO.getHighest_Qualification()+" "+StaffVO.getEmail_Id()+" "+StaffVO.getContact_Number()+" "+StaffVO.getDesignation()+" "+StaffVO.getYear_Passed_Out()+" "+StaffVO.getExperience()+" "+StaffVO.getDoj());
		Object args[]={StaffVO.getStaff_Id(),StaffVO.getStaff_Name(),new java.sql.Date(StaffVO.getDate_Of_Birth().getTime()),StaffVO.getAddress(),StaffVO.getCountry_Id(),Character.toString(StaffVO.getGender()),StaffVO.getSalary(),StaffVO.getHighest_Qualification(),StaffVO.getEmail_Id(),StaffVO.getContact_Number(),StaffVO.getDesignation(),StaffVO.getYear_Passed_Out(),StaffVO.getExperience(),new java.sql.Date(StaffVO.getDoj().getTime())};
//		Object args[]={13,"Manoj",new java.sql.Date(StaffVO.getDate_Of_Birth().getTime()),"jcdhchuc","IND","M",12000,"UG","ab@c","1234","ksjc",2015,5,new java.sql.Date(StaffVO.getDoj().getTime())};
		template.update(sql, args);
		return true;
	}
	@Override
	public double retrieveSalary(Staff_Salary SalaryVO) {
		Object args[]={SalaryVO.getYear_Of_Experience(),SalaryVO.getHighest_Qualification()};
		String sql = "select * from staff_salary where salary=(select max(salary) from (select * from staff_salary where year_of_experience<=? and highest_qualification=?))";
		List<Staff_Info> si = template.query(sql,args, new BeanPropertyRowMapper<Staff_Info>(Staff_Info.class));
		double salary=0;
		for(Staff_Info s:si)
			salary=s.getSalary();
		System.out.println("salary = "+salary);
		return salary;
	}
	@Override
	public boolean checkEmailID(String emailId) {
		String sql="select * from staff_info";
		List<Staff_Info> emailList = template.query(sql, new BeanPropertyRowMapper<Staff_Info>(Staff_Info.class));
		for(Staff_Info s: emailList)
			if(s.getEmail_Id().equals(emailId))
				return true;
		return false;
	}
	@Override
	public String getCountryId(Country_Info ci) {
		String sql = "select * from country_info where country_name=? and state_name=?";
		Object args[]={ci.getCountry_name(),ci.getState_name()};
		List<Country_Info> clist = template.query(sql, args, new BeanPropertyRowMapper<Country_Info>(Country_Info.class));
		String cid="";
		for(Country_Info c:clist)
			cid=c.getCountry_id();
		System.out.println("Country getting = "+cid);
		return cid;
	}
}
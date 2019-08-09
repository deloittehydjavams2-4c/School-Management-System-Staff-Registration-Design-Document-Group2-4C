package com.deloitte.staffregistration.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.deloitte.staffregistration.beans.Country_Info;
import com.deloitte.staffregistration.beans.Staff_Info;
import com.deloitte.staffregistration.dao.impl.SchoolRegistrationFacade;

@Controller
public class StaffRegistrationController {
	@Autowired
	SchoolRegistrationFacade srf;
	@Autowired
	Staff_Info StaffVO;
	@Autowired
	Country_Info ci;
	@RequestMapping("/Home")
	public String showform()
	{
		return "Registration";
	}
	@RequestMapping("/addStaff")
	public ModelAndView addStaff(HttpServletRequest req,HttpServletResponse res)
	{
		ModelAndView mav = new ModelAndView();
		StaffVO.setStaff_Name(req.getParameter("staff_Name"));
		StaffVO.setAddress(req.getParameter("address"));
		StaffVO.setContact_Number(req.getParameter("contact_Number"));
		
		
		try {
			StaffVO.setDate_Of_Birth(new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("date_Of_Birth")));
			StaffVO.setDoj(new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("doj")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		StaffVO.setDesignation(req.getParameter("designation"));
		StaffVO.setEmail_Id(req.getParameter("email_Id"));
		int exp = Integer.parseInt(req.getParameter("experience"));
		if(exp<5)
			exp=5;
		StaffVO.setExperience(exp);
		StaffVO.setGender(req.getParameter("gender").charAt(0));
		StaffVO.setHighest_Qualification(req.getParameter("highest_Qualification"));
		StaffVO.setYear_Passed_Out(Integer.parseInt(req.getParameter("yop")));
		ci.setCountry_name(req.getParameter("country_Name"));
		ci.setState_name(req.getParameter("state_Name"));
		StaffVO.setCountry_Id(srf.getCountryCode(ci));
		if(srf.registerStaff(StaffVO))
		{
			double salary = srf.getSalary(StaffVO.getHighest_Qualification(), StaffVO.getExperience());
			System.out.println("printing at mav "+Double.toString(salary));
			mav.addObject("salary",Double.toString(salary));
			//mav.addObject(salary);
			mav.setViewName("success");
		}
		else
		{
			String msg = "Email already exists";
			mav.addObject("Reason",msg);
			mav.setViewName("fail");
		}
		return mav;
	}
}

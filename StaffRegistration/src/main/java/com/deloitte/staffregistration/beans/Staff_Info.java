package com.deloitte.staffregistration.beans;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class Staff_Info {
private String staff_Id;
private String staff_Name;
private Date date_Of_Birth;
private String address;
private String country_Id;
private char gender;
private double salary;
private String highest_Qualification;
private String email_Id;
private String contact_Number;
private String designation;
private int year_Passed_Out;
private int experience;
private Date doj;
public Staff_Info(){
	
}
public Staff_Info(String staff_Id, String staff_Name, Date date_Of_Birth, String address, String country_Id,
		char gender, double salary, String highest_Qualification, String email_Id, String contact_Number,
		String designation, int year_Passed_Out, int experience, Date doj) {
	this.staff_Id = staff_Id;
	this.staff_Name = staff_Name;
	this.date_Of_Birth = date_Of_Birth;
	this.address = address;
	this.country_Id = country_Id;
	this.gender = gender;
	this.salary = salary;
	this.highest_Qualification = highest_Qualification;
	this.email_Id = email_Id;
	this.contact_Number = contact_Number;
	this.designation = designation;
	this.year_Passed_Out = year_Passed_Out;
	this.experience = experience;
	this.doj = doj;
}
public String getStaff_Id() {
	return staff_Id;
}
public void setStaff_Id(String staff_Id) {
	this.staff_Id = staff_Id;
}
public String getStaff_Name() {
	return staff_Name;
}
public void setStaff_Name(String staff_Name) {
	this.staff_Name = staff_Name;
}
public Date getDate_Of_Birth() {
	return date_Of_Birth;
}
public void setDate_Of_Birth(Date date_Of_Birth) {
	this.date_Of_Birth = date_Of_Birth;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getCountry_Id() {
	return country_Id;
}
public void setCountry_Id(String country_Id) {
	this.country_Id = country_Id;
}
public char getGender() {
	return gender;
}
public void setGender(char gender) {
	this.gender = gender;
}
public double getSalary() {
	return salary;
}
public void setSalary(double salary) {
	this.salary = salary;
}
public String getHighest_Qualification() {
	return highest_Qualification;
}
public void setHighest_Qualification(String highest_Qualification) {
	this.highest_Qualification = highest_Qualification;
}
public String getEmail_Id() {
	return email_Id;
}
public void setEmail_Id(String email_Id) {
	this.email_Id = email_Id;
}
public String getContact_Number() {
	return contact_Number;
}
public void setContact_Number(String contact_Number) {
	this.contact_Number = contact_Number;
}
public String getDesignation() {
	return designation;
}
public void setDesignation(String designation) {
	this.designation = designation;
}
public int getYear_Passed_Out() {
	return year_Passed_Out;
}
public void setYear_Passed_Out(int year_Passed_Out) {
	this.year_Passed_Out = year_Passed_Out;
}
public int getExperience() {
	return experience;
}
public void setExperience(int experience) {
	this.experience = experience;
}
public Date getDoj() {
	return doj;
}
public void setDoj(Date doj) {
	this.doj = doj;
}

}
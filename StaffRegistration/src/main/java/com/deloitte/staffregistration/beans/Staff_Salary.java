package com.deloitte.staffregistration.beans;

import org.springframework.stereotype.Component;

@Component
public class Staff_Salary {
private int year_Of_Experience;
private String highest_Qualification;
private double salary;
public Staff_Salary(){
	
}
public Staff_Salary(int year_Of_Experience, String highest_Qualification, double salary) {
	this.year_Of_Experience = year_Of_Experience;
	this.highest_Qualification = highest_Qualification;
	this.salary = salary;
}
public int getYear_Of_Experience() {
	return year_Of_Experience;
}
public void setYear_Of_Experience(int year_Of_Experience) {
	this.year_Of_Experience = year_Of_Experience;
}
public String getHighest_Qualification() {
	return highest_Qualification;
}
public void setHighest_Qualification(String highest_Qualification) {
	this.highest_Qualification = highest_Qualification;
}
public double getSalary() {
	return salary;
}
public void setSalary(double salary) {
	this.salary = salary;
}

}

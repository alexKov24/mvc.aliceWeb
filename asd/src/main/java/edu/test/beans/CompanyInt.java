package edu.test.beans;

import java.sql.Date;
import java.util.List;

import edu.test.beans.entities.Employee;
import edu.test.beans.entities.Job;

public interface CompanyInt {
	
	public void addEmployee(Employee e);
	public Employee getEmployeeById(Long id);
	public List<Employee> getEmployeesByName(String name);
	public List<Employee> getAllEmployees();
	public List<Job> getAllJobs();
	public List<Job> getJobsActiveAt(Date date);
	public List<Job> getJobThatEndBetweenDates(Date start, Date end);
	public int howManyWithName(String Name);
	

}

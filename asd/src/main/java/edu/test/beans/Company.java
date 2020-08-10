package edu.test.beans;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import edu.test.beans.entities.Employee;
import edu.test.beans.entities.Job;
import edu.test.beans.repositories.EmployeeRepository;
import edu.test.beans.repositories.JobRepository;

@Component
@Scope("singleton")
public class Company implements CompanyInt {

	private final EmployeeRepository empRep;
	private final JobRepository jobRep;

	private Company(@Autowired ApplicationContext context) {
		jobRep = context.getBean(JobRepository.class);
		empRep = context.getBean(EmployeeRepository.class);
	}

	@Override
	public void addEmployee(Employee e) {
		if (null != e) {
			empRep.save(e);
			return;
		}
		System.out.println("employee is null");
	}

	@Override
	public Employee getEmployeeById(Long id) {

		Optional<Employee> tempEmp = empRep.findById(id);
		if (tempEmp.isPresent()) {
			return tempEmp.get();
		}
		System.out.println("no employee with that id");
		return null;
	}

	@Override
	public List<Employee> getEmployeesByName(String name) {

		List<Employee> employees = (List<Employee>) empRep.findByName(name);

		if (null != employees) {
			return employees;
		}
		System.out.println("no employee with that name");
		return null;
	}

	@Override
	public List<Employee> getAllEmployees() {

		List<Employee> employees = (List<Employee>) empRep.findAll();

		if (null != employees) {
			return employees;
		}
		System.out.println("no employees");
		return null;
	}

	@Override
	public List<Job> getAllJobs() {
		List<Job> jobs = jobRep.findAll();

		if (null != jobs) {
			return jobs;
		}
		System.out.println("no jobs");
		return null;
	}

	@Override
	public List<Job> getJobsActiveAt(Date date) {

		List<Job> jobs = (List<Job>) jobRep.findByEndDateAfter(date);

		if (null != jobs) {
			return jobs;
		}
		System.out.println("no active jobs");
		return null;

	}

	@Override
	public List<Job> getJobThatEndBetweenDates(Date start, Date end) {
		List<Job> jobs = (List<Job>) jobRep.findByEndDateBetween(start, end);

		if (null != jobs) {
			return jobs;
		}
		System.out.println("no jobs that end between");
		return null;
	}

	@Override
	public int howManyWithName(String Name) {
		return empRep.findByNameContaining(Name).size();
	}

}

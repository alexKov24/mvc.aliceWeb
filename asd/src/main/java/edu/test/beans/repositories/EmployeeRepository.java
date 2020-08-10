package edu.test.beans.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.test.beans.entities.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	public List<Employee> findByName(String emplyeeName);
	public List<Employee> findByNameContaining(String emplyeeName);
	/* public List<Employee> findByempidContaining(Long emplyeeId); */
	

}

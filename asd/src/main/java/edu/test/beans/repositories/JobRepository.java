package edu.test.beans.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.test.beans.entities.Job;
@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
	
	public List<Job> findByEndDateAfter(Date Date);

	public List<Job> findByEndDateBetween(Date before, Date after);

}

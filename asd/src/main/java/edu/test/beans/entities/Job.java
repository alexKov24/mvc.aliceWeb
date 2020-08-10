package edu.test.beans.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Job")
public class Job {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String description;
	@Column(name = "end_date")
	private Date endDate;

	public Job() {
		super();
	}

	public Job(String description, Date endDate) {
		super();
		this.description = description;
		this.endDate = endDate;
	}

	public Job(Long id, String description, Date endDate) {
		super();
		this.id = id;
		this.description = description;
		this.endDate = endDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "\n\t- description = " + description + ", endDate = " + endDate;
	}

	
}

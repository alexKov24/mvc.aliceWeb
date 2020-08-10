package edu.test.beans.factory;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import edu.test.beans.entities.Employee;
import edu.test.beans.entities.Job;

@Component
public class Factory {
	
	private final String [] adjectives = {"beautiful", "boring", "pequliar","important","crazy","healthy","energizing"};
	private final String [] nouns = {"table","pony", "bridge", "wall", "bottle","code", "ship","scotland","rocket"};
	private final String [] verbs = {"droping","challanging","fighting", "construction", "design","annihilation","enheritance", "claming"};
	
	private final String [] names = {"Rudolf","Clare", "Santa", "Dasher", "Dancer", "Prancer", "Vixen", "Comet", "Cupid", "Dunder"};
	
	private final long year = 31556952000l;
	
	
	private Factory() {
		
	}
	
	public Employee getRandomEmp(int numOfJobs) {
		
		List <Job> jobs = new ArrayList<>();
		for( ; numOfJobs > 0 ; numOfJobs-- ) {
			jobs.add(getRandomJob());
		}
		
		String name = names[(int) (Math.random()*names.length)];
		
		double salary = (int)(Math.random()*10000000);
		
		return new Employee(name, salary/100, jobs);
		
	}
	
	private Job getRandomJob() {
		
		String description = adjectives[(int) (Math.random()*adjectives.length)]+" "+
							nouns[(int) (Math.random()*nouns.length)]+" "+
							verbs[(int) (Math.random()*verbs.length)];
		
		long yearAgo = System.currentTimeMillis()-year;
		Date endDate = new Date(yearAgo+((long)(Math.random()*5*year)));
		
		return new Job(description, endDate);
	}
}

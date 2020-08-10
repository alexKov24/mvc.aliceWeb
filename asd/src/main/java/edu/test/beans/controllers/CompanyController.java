package edu.test.beans.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import edu.test.beans.Company;
import edu.test.beans.entities.Employee;

@Controller
public class CompanyController implements ErrorController{

	@Autowired
	private Company c;

	@RequestMapping(value = "/")
	public String home() {
		return "index.html";
	}

	@RequestMapping(value = "/loadAllEmployees")
	@ResponseBody
	public String loadAll() {

		Gson formatter = new Gson();
		
		return formatter.toJson(c.getAllEmployees());//arr.toString();
		
	}

	@RequestMapping(value = "/save")
	@ResponseBody
	public String save(@RequestParam(value="jsonString") String emp) {
		
		Employee employee;
		
		try 
		{
			ObjectMapper mapper = new ObjectMapper();
			employee = mapper.readValue(emp, Employee.class);
		} catch(Exception e) {
			
			return "rescived data could not be converted to Employee.class";
		}
		
		c.addEmployee(employee);
		
		return null;
	}
	
	/**
	 *in future boolean value would serve as a better return here
	 *i.e. saving the value of employee in front as well
	 */
	
	@RequestMapping(value = "/searchById")
	@ResponseBody
	public String search(@RequestParam long id) {
		
		Gson gson = new Gson();
		
		List<Employee> arr = new ArrayList<>(1);
		arr.add(c.getEmployeeById(id));
		
		return gson.toJson(arr);

	}

	@RequestMapping(value = "/searchByName")
	@ResponseBody
	public String search(@RequestParam String name) {
		
		Gson gson = new Gson();
		
		return gson.toJson(c.getEmployeesByName(name));

	}
	
	@RequestMapping(value = "/connection")
	@ResponseBody
	public void checkConnection() {
	}
	
	@RequestMapping(value = "/howMainyId")
	@ResponseBody
	public int howMany(long id) {
		return 0;
	}
	
	@RequestMapping(value = "/howManyName")
	@ResponseBody
	public int howMany(String name) {
		return c.howManyWithName(name);
	}

	@RequestMapping("/error")
	public String handleError(HttpServletRequest request) {
	    Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
	     
	    if (status != null) {
	        Integer statusCode = Integer.valueOf(status.toString());
	     
	        if(statusCode == HttpStatus.NOT_FOUND.value()) {
	            return "error-404";
	        }
	        else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
	            return "error-500";
	        }
	    }
	    return "error";
	}

    @Override
    public String getErrorPath() {
        return "/error";
    }

}
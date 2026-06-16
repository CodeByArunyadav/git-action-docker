package com.codebyarunyadav.git_action_docker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.codebyarunyadav.git_action_docker.Employee;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Employee Management", description = "APIs for managing employees")
public class DemoController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping()
	@Operation(summary = "Welcome endpoint", description = "Returns a welcome message")
	String getString() {
		return "This is Git Action Docker Example";
	}

	@GetMapping("/employee")
	@Operation(summary = "Get sample employee", description = "Returns a hardcoded sample employee with id=1")
	public Employee getEmployee() {
		Employee e = new Employee();
		e.setId(1L);
		e.setName("John Doe");
		e.setEmail("john.doe@example.com");
		e.setDepartment("Engineering");
		return e;
	}

	@GetMapping("/employee/{id}")
	@Operation(summary = "Get employee by ID", description = "Retrieve an employee by their ID")
	public Employee getEmployeeById(@PathVariable Long id) {
		return employeeService.findById(id).orElse(null);
	}

	@GetMapping("/employees")
	@Operation(summary = "Get all employees", description = "Retrieve a list of all employees")
	public java.util.List<Employee> getAllEmployees() {
		return employeeService.findAll();
	}

	@PostMapping("/employee")
	@Operation(summary = "Create new employee", description = "Create a new employee record")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
		Employee saved = employeeService.save(employee);
		return new ResponseEntity<>(saved, HttpStatus.CREATED);
	}

	@DeleteMapping("/employee/{id}")
	@Operation(summary = "Delete employee by ID", description = "Delete an employee by their ID")
	public ResponseEntity<String> deleteEmployeeById(@PathVariable Long id) {
		if (employeeService.findById(id).isPresent()) {
			employeeService.deleteById(id);
			return new ResponseEntity<>("Employee with id " + id + " deleted successfully.", HttpStatus.OK);
		}
		return new ResponseEntity<>("Employee with id " + id + " not found.", HttpStatus.NOT_FOUND);
	}
}

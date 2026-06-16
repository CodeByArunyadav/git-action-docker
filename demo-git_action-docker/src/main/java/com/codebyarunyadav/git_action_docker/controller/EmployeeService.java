package com.codebyarunyadav.git_action_docker.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codebyarunyadav.git_action_docker.Employee;

@Service
public class EmployeeService {
	private final EmployeeRepository repository;

	public EmployeeService(EmployeeRepository repository) {
		this.repository = repository;
	}

	/** Save or update an employee. */
	public Employee save(Employee employee) {
		return repository.save(employee);
	}

	/** Find an employee by id. */
	public Optional<Employee> findById(Long id) {
		return repository.findById(id);
	}

	/** Return all employees. */
	public List<Employee> findAll() {
		return repository.findAll();
	}

	/** Delete an employee by id. */
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}

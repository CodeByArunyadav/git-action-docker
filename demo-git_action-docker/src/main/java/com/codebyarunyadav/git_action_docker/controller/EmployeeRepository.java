package com.codebyarunyadav.git_action_docker.controller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codebyarunyadav.git_action_docker.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}


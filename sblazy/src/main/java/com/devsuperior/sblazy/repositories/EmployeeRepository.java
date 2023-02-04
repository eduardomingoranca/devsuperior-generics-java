package com.devsuperior.sblazy.repositories;

import com.devsuperior.sblazy.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}

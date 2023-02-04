package com.devsuperior.sblazy.services;

import com.devsuperior.sblazy.dtos.EmployeeDTO;
import com.devsuperior.sblazy.entities.Employee;
import com.devsuperior.sblazy.generics.GenericsInterface;
import com.devsuperior.sblazy.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements GenericsInterface<Employee, EmployeeDTO, Long> {
    @Autowired
    private EmployeeRepository repository;

    @Override
    public JpaRepository<Employee, Long> getRepository() {
        return repository;
    }


}

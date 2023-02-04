package com.devsuperior.sblazy.services;

import com.devsuperior.sblazy.dtos.EmployeeDTO;
import com.devsuperior.sblazy.entities.Employee;
import com.devsuperior.sblazy.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repository;

    public EmployeeDTO findById(Long id) {
        Optional<Employee> result = repository.findById(id);

        if (result.isEmpty())
            throw new RuntimeException("Do not there employee!");

        return new EmployeeDTO(result.get());
    }

    public List<EmployeeDTO> findAll() {
        List<Employee> list = repository.findAll();
        return list.stream().map(EmployeeDTO::new).collect(toList());
    }
}

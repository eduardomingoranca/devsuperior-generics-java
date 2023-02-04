package com.devsuperior.sblazy.controllers;

import com.devsuperior.sblazy.dtos.EmployeeDTO;
import com.devsuperior.sblazy.entities.Employee;
import com.devsuperior.sblazy.services.GenericsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {
    @Autowired
    private GenericsService<Employee, EmployeeDTO, Long> service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<EmployeeDTO> findById(@PathVariable Long id) {
        EmployeeDTO obj = service.findById(id);
        return status(OK).body(obj);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> findAll() {
        List<EmployeeDTO> list = service.findAll();
        return status(OK).body(list);
    }

}

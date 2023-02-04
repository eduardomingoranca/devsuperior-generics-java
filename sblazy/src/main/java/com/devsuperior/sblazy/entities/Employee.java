package com.devsuperior.sblazy.entities;

import com.devsuperior.sblazy.dtos.EmployeeDTO;
import com.devsuperior.sblazy.utils.Convertible;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "tb_employee")
public class Employee implements Convertible<EmployeeDTO> {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String name;

    public Employee() {
    }

    public Employee(Long id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // retorna um DTO copiando os dados do objeto
    @Override
    public EmployeeDTO convert() {
        return new EmployeeDTO(this);
    }
}

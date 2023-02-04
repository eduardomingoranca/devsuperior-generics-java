package com.devsuperior.sblazy.services;

import com.devsuperior.sblazy.utils.Convertible;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

// T extends Convertible<DTO> -> tipo T eh possivel converter para DTO
@Service
public class GenericsService<T extends Convertible<DTO>, DTO, ID> {
    @Autowired
    private JpaRepository<T, ID> repository;

    public DTO findById(ID id) {
        Optional<T> result = repository.findById(id);

        if (result.isEmpty())
            throw new RuntimeException();

        // convertendo T para DTO
        return result.get().convert();
    }

    public List<DTO> findAll() {
        List<T> list = repository.findAll();
        return list.stream().map(Convertible::convert).collect(toList());
    }

}

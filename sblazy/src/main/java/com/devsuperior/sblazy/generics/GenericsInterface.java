package com.devsuperior.sblazy.generics;

import com.devsuperior.sblazy.utils.Convertible;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

// T extends Convertible<DTO> -> tipo T eh possivel converter para DTO
public interface GenericsInterface<T extends Convertible<DTO>, DTO, ID> {
    JpaRepository<T, ID> getRepository();

    default DTO findById(ID id) {
        Optional<T> result = getRepository().findById(id);

        if (result.isEmpty())
            throw new RuntimeException();

        // convertendo T para DTO
        return result.get().convert();
    }

    default List<DTO> findAll() {
        List<T> list = getRepository().findAll();
        return list.stream().map(Convertible::convert).collect(toList());
    }

}

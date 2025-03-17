package com.centroinformacion.repository;

import com.centroinformacion.entity.Editorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UtilEditorialRespository extends JpaRepository<Editorial, Integer>{

    @Query(value = """
                    select * from editorial;
                    """, nativeQuery = true)
    List<Editorial> listarEditorial();
    }
package com.example.cinimaserver.repositories;

import com.example.cinimaserver.entity.Hall;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface HallRepository extends CrudRepository<Hall, Integer>, JpaSpecificationExecutor<Hall> {
}

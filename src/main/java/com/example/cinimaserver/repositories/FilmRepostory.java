package com.example.cinimaserver.repositories;

import com.example.cinimaserver.entity.Film;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface FilmRepostory extends CrudRepository <Film, Integer>{
}

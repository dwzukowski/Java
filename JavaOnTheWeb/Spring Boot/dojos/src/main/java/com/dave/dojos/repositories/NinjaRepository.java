package com.dave.dojos.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dave.dojos.models.Ninja;

public interface NinjaRepository extends CrudRepository<Ninja, Long>{

	//List<Ninja> findByDojoEquals(long id);

}

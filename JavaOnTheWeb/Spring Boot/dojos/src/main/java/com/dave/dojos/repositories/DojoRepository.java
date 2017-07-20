package com.dave.dojos.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dave.dojos.models.Dojo;
import com.dave.dojos.models.Ninja;

@Repository
public interface DojoRepository extends CrudRepository<Dojo, Long> {


}

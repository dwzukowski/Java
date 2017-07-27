package com.dave.belt.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dave.belt.models.Pack;


@Repository
public interface PackRepository extends CrudRepository<Pack, Long> {
	Pack findByName(String name);
	Pack findByAvailable(boolean isAvailable);

	@Query(value="SELECT * FROM packs WHERE available = ?1", nativeQuery=true)
    List<Pack> getPacksWhereAvailable(boolean picked_up);
}

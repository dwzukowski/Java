package com.dave.review.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dave.review.models.Ring;

@Repository
public interface RingRepository extends CrudRepository<Ring, Long> {

@Query(value="SELECT * FROM rings WHERE picked_up = ?1", nativeQuery=true)
    List<Ring> getRingsWherePickedUp(boolean picked_up);
}

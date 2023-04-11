package com.datajpa.relationship.db.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.datajpa.relationship.db.model.City;

@Repository
public interface CityRepository extends CrudRepository<City, Long> {
}

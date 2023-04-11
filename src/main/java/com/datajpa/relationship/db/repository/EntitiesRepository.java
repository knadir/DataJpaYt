package com.datajpa.relationship.db.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.datajpa.relationship.db.model.Entities;

@Repository
public interface EntitiesRepository extends CrudRepository<Entities, Long> {
}

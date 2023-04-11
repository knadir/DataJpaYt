package com.datajpa.relationship.db.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.datajpa.relationship.db.model.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
}

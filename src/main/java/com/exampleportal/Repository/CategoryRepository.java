package com.exampleportal.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exampleportal.Entity.Category;

public interface CategoryRepository extends JpaRepository<Category,Integer> {

}

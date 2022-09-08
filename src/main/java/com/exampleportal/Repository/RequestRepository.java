package com.exampleportal.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exampleportal.Entity.Request;

public interface RequestRepository extends JpaRepository<Request,Integer>{

}

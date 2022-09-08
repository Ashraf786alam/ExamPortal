package com.exampleportal.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exampleportal.Entity.Attachment;

@Repository
public interface FileRepository extends JpaRepository<Attachment,String> {

}

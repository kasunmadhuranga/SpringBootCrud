package com.studentmark.studentmark.repo;

import com.studentmark.studentmark.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student,Integer> {

}

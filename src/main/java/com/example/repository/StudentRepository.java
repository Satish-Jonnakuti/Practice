package com.example.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.model.*;

@Repository

	
public interface StudentRepository extends JpaRepository<Student,Integer> {  
	    @Query(value = "SELECT s FROM Student s WHERE s.gender =:gender")
	    Optional<List<Student>> findStudentsByGender(@Param("gender") String gender);
	
	

}

package com.example.Sanjeevni.Repository;

import com.example.Sanjeevni.Model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepo extends JpaRepository<Doctor,Integer> {

    //3rd way to use jpa by using query
    @Query(value = "select * from doctor where age > :age ", nativeQuery = true)
    List<Doctor> getAgeGreaterThan(int age);


}

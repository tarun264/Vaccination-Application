package com.example.Sanjeevni.Repository;

import com.example.Sanjeevni.Model.Patient;
import jakarta.persistence.Persistence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepo extends JpaRepository<Patient,Integer> {

    //to find the email using  custom fingByX function
    // return type will depennd on attribute passed
    Patient findByEmailId(String emailId);



}

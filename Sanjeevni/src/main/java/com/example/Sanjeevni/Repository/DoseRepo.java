package com.example.Sanjeevni.Repository;

import com.example.Sanjeevni.Model.Dose;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoseRepo extends JpaRepository<Dose,Integer> {

}

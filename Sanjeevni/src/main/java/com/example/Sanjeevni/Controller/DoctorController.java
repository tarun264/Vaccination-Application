package com.example.Sanjeevni.Controller;

import com.example.Sanjeevni.Model.Doctor;
import com.example.Sanjeevni.Service.DoctorService;
import com.example.Sanjeevni.dto.RequestDTO.DoctorRequestDTO;
import com.example.Sanjeevni.dto.ResponseDTO.DoctorResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
@Autowired
    DoctorService doctorService;

@PostMapping("/add_doctor")
public ResponseEntity addDoctor(@RequestBody DoctorRequestDTO doctorRequestDTO){
    try{
        DoctorResponseDTO doctorResponseDTO=doctorService.addDoctor(doctorRequestDTO);
        return new ResponseEntity(doctorResponseDTO, HttpStatus.CREATED);
    }catch(Exception e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
@GetMapping("/age_Greater_Than")
    public List<String> getAgeGreaterThan(@RequestParam ("age") int age){
   return doctorService.getAgeGreaterThan(age);


}

}

package com.example.Sanjeevni.Controller;

import com.example.Sanjeevni.Service.PatientService;
import com.example.Sanjeevni.Model.Patient;
import com.example.Sanjeevni.dto.RequestDTO.AddPersonRequestDTO;
import com.example.Sanjeevni.dto.ResponseDTO.AddPersonResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    PatientService patientService;

    @PostMapping("/add_Patient")
    public ResponseEntity addPatient(@RequestBody AddPersonRequestDTO addPersonRequestDTO){
        try{
            AddPersonResponseDTO personResponse = patientService.addPatient(addPersonRequestDTO);
            return new ResponseEntity(personResponse,HttpStatus.ACCEPTED);
        }
        catch(Exception e){
            return new ResponseEntity<>("Email Already Exist",HttpStatus.BAD_REQUEST);
        }
    }

    //update old email to new email
    @PutMapping("/update_emailId")
    public ResponseEntity updateEmail(@RequestParam ("oldEmail") String oldEmail, @RequestParam("newEmail") String newEmail){
       try {
           String s = patientService.updateEmail(oldEmail, newEmail);
           return new ResponseEntity<>(s,HttpStatus.ACCEPTED);
       } catch(Exception e){
           return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
        }

    }
}

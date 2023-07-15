package com.example.Sanjeevni.Service;

import com.example.Sanjeevni.Exceptions.PatientNotFoundException;
import com.example.Sanjeevni.Model.Patient;
import com.example.Sanjeevni.Repository.PatientRepo;
import com.example.Sanjeevni.dto.RequestDTO.AddPersonRequestDTO;
import com.example.Sanjeevni.dto.ResponseDTO.AddPersonResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    PatientRepo patientRepo;


    public AddPersonResponseDTO addPatient(AddPersonRequestDTO addPersonRequestDTO) {
        //for the first time all will be null for the user
//        patient.setDose1Taken(false);
//        patient.setDose2Taken(false);

        //converting request dtos to entities
        Patient patient= new Patient();
        patient.setName(addPersonRequestDTO.getName());
        patient.setAge(addPersonRequestDTO.getAge());
        patient.setEmailId(addPersonRequestDTO.getEmailId());
        patient.setGender(addPersonRequestDTO.getGender());

        patient.setDose1Taken(false);
        patient.setDose2Taken(false);

        patient.setCertificate(null);
        // saving entity to database
        Patient patientAdded= patientRepo.save(patient);

        //saved entity to dto to return
        AddPersonResponseDTO addPersonResponseDTO= new AddPersonResponseDTO();
        addPersonResponseDTO.setName(patient.getName());
        addPersonResponseDTO.setMessage("Patient Added Succesfully");
        return addPersonResponseDTO;


    }

    public String updateEmail(String oldEmail,String newEmail) {
        Patient patient= patientRepo.findByEmailId(oldEmail);
        if(patient==null){
            throw new PatientNotFoundException("Email does not exist");
        }
            patient.setEmailId(newEmail);
        patientRepo.save(patient);
        return "Congrats,emailId updated";
        }


    }




package com.example.Sanjeevni.Service;

import com.example.Sanjeevni.Exceptions.VaccinationCenterException;
import com.example.Sanjeevni.Model.Doctor;
import com.example.Sanjeevni.Model.VaccinationCenter;
import com.example.Sanjeevni.Repository.DoctorRepo;
import com.example.Sanjeevni.Repository.VaccinationCenterRepo;
import com.example.Sanjeevni.dto.RequestDTO.DoctorRequestDTO;
import com.example.Sanjeevni.dto.ResponseDTO.CentreResponseDTO;
import com.example.Sanjeevni.dto.ResponseDTO.DoctorResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {
    @Autowired
    DoctorRepo doctorRepo;
    @Autowired
    VaccinationCenterRepo vaccinationCenterRepo;
    public DoctorResponseDTO addDoctor(DoctorRequestDTO doctorRequestDTO) {
        Optional<VaccinationCenter> vaccinationCenter= vaccinationCenterRepo.findById(doctorRequestDTO.getCenterId());
        if(vaccinationCenter.isEmpty()) {
            throw new VaccinationCenterException("Center Not Found");
        }
        //getting vaccination center object
        VaccinationCenter center= vaccinationCenter.get();

        //dto to entity
        Doctor doctor= new Doctor();
        doctor.setCenter(center);
        doctor.setName(doctorRequestDTO.getName());
        doctor.setAge(doctorRequestDTO.getAge());
        doctor.setGender(doctorRequestDTO.getGender());
        doctor.setEmailId(doctorRequestDTO.getEmailId());

        //adding list of doctors to center
        center.getDoctors().add(doctor);

        // saving the parent to repo and child will automatically be saved
        VaccinationCenter savedCenter= vaccinationCenterRepo.save(center);

        // entity to dto
        // getting latest doctor added from friend
        List<Doctor> doctors= savedCenter.getDoctors();
        Doctor latestSavedDoctor= doctors.get(doctors.size()-1);

        //To present centerResponseDTO make an object and set its variable
        CentreResponseDTO centreResponseDTO= new CentreResponseDTO();
        centreResponseDTO.setCenterName(savedCenter.getCenterName());
        centreResponseDTO.setCenterType(savedCenter.getCenterType());
        centreResponseDTO.setAddress(savedCenter.getAddress());

        DoctorResponseDTO doctorResponseDTO= new DoctorResponseDTO();
        doctorResponseDTO.setName(latestSavedDoctor.getName());
        doctorResponseDTO.setMessage("Congrats, You have been registered");
        doctorResponseDTO.setCentreResponseDTO(centreResponseDTO);


        return doctorResponseDTO;

        }

    public List<String> getAgeGreaterThan(int age) {
        //3rd way to use jpa by using query
        List<Doctor> doctorsList= doctorRepo.getAgeGreaterThan(age);
        List<String> doctorsName= new ArrayList<>();
        for(Doctor list: doctorsList){
            doctorsName.add(list.getName());
        }
        return doctorsName;

    }
}


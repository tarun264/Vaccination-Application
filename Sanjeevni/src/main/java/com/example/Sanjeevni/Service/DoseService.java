package com.example.Sanjeevni.Service;

import com.example.Sanjeevni.Enum.DoseType;
import com.example.Sanjeevni.Exceptions.DoseTakenException;
import com.example.Sanjeevni.Exceptions.PatientNotFoundException;
import com.example.Sanjeevni.Model.Dose;
import com.example.Sanjeevni.Model.Patient;
import com.example.Sanjeevni.Repository.DoseRepo;
import com.example.Sanjeevni.Repository.PatientRepo;
import com.example.Sanjeevni.dto.RequestDTO.BookDose1RequestDTO;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class DoseService {

    @Autowired
    DoseRepo doseRepo;
    @Autowired
    PatientRepo patientRepo;

    public Dose getDose1(BookDose1RequestDTO bookDose1RequestDTO) {
// check if patient id is present in patient repo so we ahve to autowire the patient repo
        Optional<Patient> optionalPatient = patientRepo.findById(bookDose1RequestDTO.getPatientId());

        if (!optionalPatient.isPresent()) {
            throw new PatientNotFoundException("PatientId not Found");
        }
//get the patient
        Patient patient = optionalPatient.get();

//check if dose 1 taken or not
        if (patient.isDose1Taken()) {
            throw new DoseTakenException("Dose 1 already Taken");
        }

        // create a dose
        Dose dose = new Dose();
        dose.setDoseId(String.valueOf(UUID.randomUUID()));
        dose.setDoseType(bookDose1RequestDTO.getDoseType());

        //assignning the dose to person
        dose.setPatient(patient);
        //setting the dose taken by person true
        patient.setDose1Taken(true);
        // add list of doses to patient
        patient.getDoseTaken().add(dose);
        //saving in dose repo
        patientRepo.save(patient);


//        Patient savedPatient= patientRepo.save(patient);
//        return patient.getDoseTaken().get(0);

        return doseRepo.save(dose);
    }
}

//WITHOUT DTOS
//        public Dose getDose1(int patientId, DoseType doseType) {
//// check if patient id is present in patient repo so we ahve to autowire the patient repo
//            Optional<Patient> optionalPatient= patientRepo.findById(patientId);
//
//            if(!optionalPatient.isPresent()){
//                throw new PatientNotFoundException("PatientId not Found");
//            }
////get the patient
//            Patient patient= optionalPatient.get();
//
////check if dose 1 taken or not
//            if(patient.isDose1Taken()){
//                throw new DoseTakenException("Dose 1 already Taken");
//            }
//
//            // create a dose
//            Dose dose= new Dose();
//            dose.setDoseId(String.valueOf(UUID.randomUUID()));
//            dose.setDoseType(doseType);
//
//            //assignning the dose to person
//            dose.setPatient(patient);
//            //setting the dose taken by person true
//            patient.setDose1Taken(true);
//            // add list of doses to patient
//            patient.getDoseTaken().add(dose);
//            //saving in dose repo
//            patientRepo.save(patient);
//
//
////        Patient savedPatient= patientRepo.save(patient);
////        return patient.getDoseTaken().get(0);
//
//            return doseRepo.save(dose);




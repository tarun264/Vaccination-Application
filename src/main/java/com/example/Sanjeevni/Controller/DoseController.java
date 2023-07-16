package com.example.Sanjeevni.Controller;

import com.example.Sanjeevni.Enum.DoseType;
import com.example.Sanjeevni.Model.Dose;
import com.example.Sanjeevni.Service.DoseService;
import com.example.Sanjeevni.dto.RequestDTO.BookDose1RequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.module.ResolutionException;

@RestController
@RequestMapping("/dose")
public class DoseController {

    @Autowired
    DoseService doseService;

    @PostMapping("/get_dose1")
    public ResponseEntity getPersonWithDose(@RequestParam BookDose1RequestDTO bookDose1RequestDTO) {

        try {
            Dose doseTaken = doseService.getDose1(bookDose1RequestDTO);
            return new ResponseEntity(doseTaken, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    // WITHOUT DTOs
//    public ResponseEntity getPersonWithDose(@RequestParam("id") int patientId, @RequestParam("doseType") DoseType doseType) {
//
//        try {
//            Dose doseTaken = doseService.getDose1(patientId, doseType);
//            return new ResponseEntity(doseTaken, HttpStatus.CREATED);
//        } catch (Exception e) {
//            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
//        }
//    }
}

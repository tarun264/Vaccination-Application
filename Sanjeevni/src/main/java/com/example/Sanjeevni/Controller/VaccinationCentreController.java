package com.example.Sanjeevni.Controller;

import com.example.Sanjeevni.Service.VaccinationCenterService;
import com.example.Sanjeevni.dto.RequestDTO.CenterRequestDTO;
import com.example.Sanjeevni.dto.ResponseDTO.CentreResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vaccination_centre")
public class VaccinationCentreController {
    @Autowired
    VaccinationCenterService vaccinationCenterService;

    @PostMapping("/adding_center")
    public CentreResponseDTO addCenter(@RequestBody CenterRequestDTO addVaccinationCenterRequest){

        CentreResponseDTO centreResponseDTO= vaccinationCenterService.addCenter(addVaccinationCenterRequest);
        return  centreResponseDTO;
    }
}

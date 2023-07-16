package com.example.Sanjeevni.Service;

import com.example.Sanjeevni.Enum.CenterType;
import com.example.Sanjeevni.Model.VaccinationCenter;
import com.example.Sanjeevni.Repository.VaccinationCenterRepo;
import com.example.Sanjeevni.dto.RequestDTO.CenterRequestDTO;
import com.example.Sanjeevni.dto.ResponseDTO.CentreResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VaccinationCenterService {
    @Autowired
    VaccinationCenterRepo vaccinationCenterRepo;
    public CentreResponseDTO addCenter(CenterRequestDTO centerRequestDTO) {

        //convert request dto to entity
        VaccinationCenter center=new VaccinationCenter();
        center.setCenterName(centerRequestDTO.getCenterName());
        center.setCenterType(centerRequestDTO.getCenterType());
        center.setAddress(centerRequestDTO.getAddress());

        //saved entity to db
       VaccinationCenter savedCenter= vaccinationCenterRepo.save(center);


        //converting response entity to dto
        CentreResponseDTO responseDTO=new CentreResponseDTO();
        responseDTO.setCenterName(savedCenter.getCenterName());
        responseDTO.setCenterType(savedCenter.getCenterType());
        responseDTO.setAddress(savedCenter.getAddress());

        return responseDTO;





    }
}

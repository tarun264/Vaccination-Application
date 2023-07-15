package com.example.Sanjeevni.dto.ResponseDTO;

import com.example.Sanjeevni.Model.VaccinationCenter;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DoctorResponseDTO {
    String name;
    String message;

    // we cannot return the object in response since it will result in stackOverFlow bcoz vaccination center has doctor obejct which will
    //lead to infinite recurrsion
    //VaccinationCenter vaccinationCenter;

    //so we will only return only dto since there is no mapping
    CentreResponseDTO centreResponseDTO;

}

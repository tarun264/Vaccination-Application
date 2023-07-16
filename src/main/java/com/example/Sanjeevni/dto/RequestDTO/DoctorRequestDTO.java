package com.example.Sanjeevni.dto.RequestDTO;

import com.example.Sanjeevni.Enum.Gender;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DoctorRequestDTO {
    //for mapping doctor with center
    Integer centerId;
    String name;
    int age;
    String emailId;

    Gender gender;
}

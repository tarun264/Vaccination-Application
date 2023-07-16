package com.example.Sanjeevni.dto.RequestDTO;

import com.example.Sanjeevni.Enum.DoseType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
// this DTO will all the request parameters that client can have
public class BookDose1RequestDTO {

    int patientId;
    DoseType doseType;
}

package com.example.Sanjeevni.dto.ResponseDTO;

import com.example.Sanjeevni.Enum.CenterType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CentreResponseDTO {
    String centerName;
    CenterType centerType;
    String address;
}

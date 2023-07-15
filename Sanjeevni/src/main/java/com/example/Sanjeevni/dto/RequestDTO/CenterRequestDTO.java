package com.example.Sanjeevni.dto.RequestDTO;

import com.example.Sanjeevni.Enum.CenterType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CenterRequestDTO {
    String centerName;
    CenterType centerType;
    String address;
}

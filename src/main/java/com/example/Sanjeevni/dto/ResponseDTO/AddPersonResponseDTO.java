package com.example.Sanjeevni.dto.ResponseDTO;

import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
// this dto will contain all the variables that are required to show to client
public class AddPersonResponseDTO {
    String name;
    String message;
}

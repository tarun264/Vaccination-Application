package com.example.Sanjeevni.Model;

import com.example.Sanjeevni.Enum.DoseType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Dose {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
            int id;

    String doseId;

    @Enumerated(EnumType.STRING)
   DoseType doseType;

    // Date util have date and time but Date SQL have  only date
    @CreationTimestamp
    Date VaccinationDate;


    //Patient parent , child many
    //dose to patient many to 1 relation
    //current class, connecting class
    @ManyToOne
    @JoinColumn //introduce the foreign key column and by default it joins based on the primary key of the parent
    Patient patient;



}

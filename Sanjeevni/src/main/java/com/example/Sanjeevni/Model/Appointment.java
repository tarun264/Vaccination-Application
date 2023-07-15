package com.example.Sanjeevni.Model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String appointmentId;

    Date appointmentDate;

    int doseNo;

    @ManyToOne
    @JoinColumn
    Patient patient;

    @ManyToOne
    @JoinColumn
    Doctor doctor;

}

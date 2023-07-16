package com.example.Sanjeevni.Model;

import com.example.Sanjeevni.Enum.Gender;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String Name;
    int age;

    @Enumerated(EnumType.STRING)
    Gender gender;

    // columun with unique value and does not contain null
    @Column(unique = true)
    String emailId;



    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    List<Appointment> appointmentList= new ArrayList<>();

    @ManyToOne
    @JoinColumn
    VaccinationCenter center;



}



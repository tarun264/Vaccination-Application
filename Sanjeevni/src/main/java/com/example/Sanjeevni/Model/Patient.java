package com.example.Sanjeevni.Model;

import com.example.Sanjeevni.Enum.Gender;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@FieldDefaults (level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
            int id;

    String Name;
    int age;

    @Column(unique = true)
    String emailId;

    @Enumerated(EnumType.STRING)
    Gender gender;

    boolean dose1Taken;
    boolean dose2Taken;

    // mapped by will map the variable of parent in child class, cascade will transfer all the crud operation of parent to child
    @OneToMany(mappedBy = "patient",cascade=CascadeType.ALL)
    List<Dose> doseTaken= new ArrayList<>();


    @OneToOne(mappedBy = "patient",cascade = CascadeType.ALL)
    Certificate certificate;

    //One patient can have patient
    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    List<Appointment> appointments= new ArrayList<>();



}

package com.example.Sanjeevni.Exceptions;

public class PatientNotFoundException  extends RuntimeException{
    public PatientNotFoundException(String message){
        super(message);
    }
}

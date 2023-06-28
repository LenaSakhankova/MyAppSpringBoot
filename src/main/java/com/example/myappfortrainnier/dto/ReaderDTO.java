package com.example.myappfortrainnier.dto;

import lombok.Getter;
import lombok.Setter;

public class ReaderDTO {
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String FIO;

    @Getter
    @Setter
    private int yearOfBirth;

    @Getter
    @Setter
    private String phoneNumber;
    @Getter
    @Setter
    private String address;
    @Getter
    @Setter
    private String profession;

    public ReaderDTO(){}

    public ReaderDTO(String FIO, int yearOfBirth, String phoneNumber, String address, String profession) {
        this.FIO = FIO;
        this.yearOfBirth = yearOfBirth;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.profession = profession;
    }
}

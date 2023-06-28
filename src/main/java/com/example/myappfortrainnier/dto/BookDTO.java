package com.example.myappfortrainnier.dto;

import lombok.Getter;
import lombok.Setter;

public class BookDTO {

    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String author;

    @Getter
    @Setter
    private int year;

    @Getter
    @Setter
    private String shortDescription;

    @Getter
    @Setter
    private int storageLocation;

    @Getter
    @Setter
    private int tom;

    @Getter
    @Setter
    private Long personId;

    public BookDTO(){};

    public BookDTO(String name, String author, int year, String shortDescription, int storageLocation, int tom, Long personId) {
        this.name = name;
        this.author = author;
        this.year = year;
        this.shortDescription = shortDescription;
        this.storageLocation = storageLocation;
        this.tom = tom;
        this.personId = personId;
    }
}

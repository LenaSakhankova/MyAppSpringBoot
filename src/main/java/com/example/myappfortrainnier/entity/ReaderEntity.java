package com.example.myappfortrainnier.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "reader")
public class ReaderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Getter
    @Setter
    private Long id;

    @Column(name = "FIO")
    @Getter
    @Setter
    @NotEmpty(message = "Full name should not be empty")
    @Size(min = 4, max = 500, message = "Full name should be between 4 and 500 characters")
    private String FIO;
    @Column(name = "year_of_birth")
    @Getter
    @Setter
    @Min(value = 1910, message = "Year of Birthday should be greater than 1910")
    private int yearOfBirth;
    @Column(name = "phone_number")
    @Getter
    @Setter
    @Size(min = 7, message = "Number should be more than 7 symbols")
    private String phoneNumber;
    @Setter
    @Getter
    @OneToMany(targetEntity = BookEntity.class, mappedBy = "reader")
    private List<BookEntity> books;

    @Column(name = "address")
    @Size(min = 7, message = "Address should be more than 7 symbols")
    @Getter
    @Setter
    private String address;

    @Column(name = "profession")
    @Getter
    @Setter
    private String profession;


    public ReaderEntity() {}

    public ReaderEntity(String FIO, int yearOfBirth, String phoneNumber, String address, String profession) {
        this.FIO = FIO;
        this.yearOfBirth = yearOfBirth;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.profession = profession;
    }

    public ReaderEntity(String FIO, int yearOfBirth, String phoneNumber, List<BookEntity> books, String address, String profession) {
        this.FIO = FIO;
        this.yearOfBirth = yearOfBirth;
        this.phoneNumber = phoneNumber;
        this.books = books;
        this.address = address;
        this.profession = profession;
    }

    @Override
    public String toString() {
        return "ReaderEntity{" +
                "FIO='" + FIO + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", profession='" + profession + '\'' +
                '}';
    }
}

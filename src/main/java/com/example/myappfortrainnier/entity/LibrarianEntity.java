package com.example.myappfortrainnier.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "librarian")
public class LibrarianEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Getter
    @Setter
    private Long id;

    @NotEmpty(message = "Name can't be empty")
    @Size(min=2, max=100, message = "Full name can have minimum 2 symbols and maximum 100")
    @Column(name = "FIO")
    @Getter
    @Setter
    private String FIO;

    @Min(value = 1900, message = "Year of birth must be more than 1900")
    @Column(name = "year_of_birth")
    @Getter
    @Setter
    private int yearOfBirth;

    @Column(name = "phone_number")
    @Size(min=7, max=25, message = "Number can have minimum 7 symbols and maximum 20")
    @Getter
    @Setter
    private String phoneNumber;
    public LibrarianEntity(){};

    public LibrarianEntity(String FIO, int yearOfBirth, String phoneNumber) {
        this.FIO = FIO;
        this.yearOfBirth = yearOfBirth;
        this.phoneNumber = phoneNumber;
    }
}

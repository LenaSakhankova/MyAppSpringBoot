package com.example.myappfortrainnier.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name = "book")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Getter
    @Setter
    private Long id;
    @NotEmpty(message = "Full name should not be empty")
    @Size(min = 4, max = 1000, message = "Full name should be between 1-1000 characters")
    @Column(name = "name")
    @Getter
    @Setter
    private String name;
    @NotEmpty(message = "Field author can't be empty")
    @Size(min=2, max=100, message = "Full name can have 2 - 100 symbols")
    @Column(name = "author")
    @Getter
    @Setter
    private String author;
    @Column(name = "year_of_creating")
    @Min(value = 1500, message = "Year more than 1500")
    @Getter
    @Setter
    private int year;
    @Column(name = "short_description")
    @Getter
    @Setter
    private String shortDescription;
    @Column(name = "storage_location")
    @Getter
    @Setter
    private int storageLocation;
    @Column(name = "tom")
    @Getter
    @Setter
    @Min(value = 1, message = "Min number of tom = 1")
    @Max(value = 20, message = "Max value of tom = 20")
    private int tom;

    @ManyToOne(targetEntity = ReaderEntity.class)
    @Setter
    @Getter
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private ReaderEntity reader;
    public BookEntity(){};

    public BookEntity(String name, int year, String shortDescription, int storageLocation, int tom) {
            this.name = name;
            this.author = author;
            this.year = year;
            this.shortDescription = shortDescription;
            this.storageLocation = storageLocation;
            this.tom = tom;
    }
}

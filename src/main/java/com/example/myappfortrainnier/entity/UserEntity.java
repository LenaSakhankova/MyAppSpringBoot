package com.example.myappfortrainnier.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Table(name="users")
@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Getter
    @Setter
    private Long id;

    @NotEmpty(message = "Name can't be empty")
    @Size(min=2, max=100, message = "Username can have minimum 2 symbols and maximum 100")
    @Column(name = "username")
    @Getter
    @Setter
    private String username;

    @Min(value = 1900, message = "Year of birth must be more than 1900")
    @Column(name = "year_of_birth")
    @Getter
    @Setter
    private int yearOfBirth;

    @Column(name = "password")
    @Getter
    @Setter
    private String password;

    @Column(name = "role")
    @Getter
    @Setter
    private String role;

    public UserEntity(){}

    public UserEntity(String username, int yearOfBirth, String password, String role) {
        this.username = username;
        this.yearOfBirth = yearOfBirth;
        this.password = password;
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}

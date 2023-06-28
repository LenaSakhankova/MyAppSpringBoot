package com.example.myappfortrainnier.dto;

import lombok.Getter;
import lombok.Setter;

public class LibrarianDTO {
        @Getter
        @Setter
        private Long id;
        @Getter
        @Setter
        private String FIO;
        @Getter
        @Setter
        private String phoneNumber;
        @Getter
        @Setter
        private int yearOfBirth;


        public LibrarianDTO(){};

        public LibrarianDTO(String FIO, String phoneNumber, int yearOfBirth) {
                this.FIO = FIO;
                this.phoneNumber = phoneNumber;
                this.yearOfBirth = yearOfBirth;
        }

        @Override
        public String toString() {
                return "LibrarianDTO{" +
                        "id=" + id +
                        ", FIO='" + FIO + '\'' +
                        ", phoneNumber='" + phoneNumber + '\'' +
                        ", yearOfBirth=" + yearOfBirth +
                        '}';
        }
}

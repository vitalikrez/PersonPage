package com.example.myapplicationofsocialpersonpage;

import java.util.UUID;

public class Person {
    UUID id;
    String firstName;
    String lastName;
    int age;
    String country;
    String city;
    String fileName;
    Person( String firstName, String lastName, int age, String country, String city, String fileName)
    {
        this.id = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.country = country;
        this.city = city;
        this.fileName = fileName;
}
}
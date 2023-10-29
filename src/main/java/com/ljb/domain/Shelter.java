package com.ljb.domain;

import java.util.Arrays;

public class Shelter {

    public Shelter(){
    }

    public Shelter(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    private Long id;
    private String name;
    private String phoneNumber;
    private String email;
    private Pet[] pets;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public Pet[] getPets() {
        return pets;
    }

    @Override
    public String toString() {
        return """
                "id":%s,"name":"%s","phoneNumber":"%s","email":"%s"
                """.formatted(this.id, this.name, this.phoneNumber, this.email);
    }
}

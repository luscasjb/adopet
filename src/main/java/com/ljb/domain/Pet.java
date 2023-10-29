package com.ljb.domain;

public class Pet {

    public Pet() {
    }

    public Pet(String type, String name, String breed, int age, String color, Float weight) {
        this.type = type;
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.color = color;
        this.weight = weight;
    }

    private Long id;
    private String type;
    private String name;
    private String breed;
    private int age;
    private String color;
    private Float weight;

    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    public int getAge() {
        return age;
    }

    public String getColor() {
        return color;
    }

    public Float getWeight() {
        return weight;
    }
}
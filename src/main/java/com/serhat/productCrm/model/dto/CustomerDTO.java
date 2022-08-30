package com.serhat.productCrm.model.dto;

public class CustomerDTO {
    private Long id;
    private String name;
    private String surname;
    private Integer age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public CustomerDTO(String name, String surname, Integer age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }
    public CustomerDTO(){
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }
}
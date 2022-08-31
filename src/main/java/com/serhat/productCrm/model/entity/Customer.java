package com.serhat.productCrm.model.entity;

import javax.persistence.*;

@Entity
@NamedQuery(name = "Customer.countCustomer",query = "select count  (c) from Customer  c")
@Table(name = "customer")
public class Customer extends BaseEntity {

    @Column(name="name")
    private String name;
    @Column(name="surname")
    private String surname;
    @Column(name="birth_date")
    private Integer age;

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
}
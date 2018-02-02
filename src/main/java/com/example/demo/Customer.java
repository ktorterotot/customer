package com.example.demo;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Integer age;
    private String address;
    private String gender;
    private String birthDate;
    private Long rewardPoints;


    public Customer(){
    }


    public Customer(Long id, String name, Integer age, String address, String gender, String birthDate, Long rewardPoints) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.gender = gender;
        this.birthDate = birthDate;
        this.rewardPoints = rewardPoints;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public Long getRewardPoints() {
        return rewardPoints;
    }

    public void setRewardPoints(Long rewardPoints) {
        this.rewardPoints = rewardPoints;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", gender='" + gender + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", rewardPoints=" + rewardPoints +
                '}';
    }
}

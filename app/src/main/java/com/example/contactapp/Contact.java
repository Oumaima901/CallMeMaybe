package com.example.contactapp;

public class Contact {
    String name, lastname, number;

    public Contact(String name, String lastname, String number) {
        this.name = name;
        this.lastname = lastname;
        this.number = number;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", number='" + number + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}

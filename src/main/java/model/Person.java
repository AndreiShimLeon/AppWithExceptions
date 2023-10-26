package model;

import java.math.BigInteger;

public class Person {

    String lastName;
    String middleName;
    String firstName;
    private String dateOfBirth;
    private BigInteger phoneNumber;
    private char sex;

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getFirstName() {
        return firstName;
    }

    /**
     *
     * @param lastName - Фамилия (строка)
     * @param middleName - Отчество (строка)
     * @param firstName - Имя (строка)
     * @param dateOfBirth - дата рождения (строка)
     * @param phoneNumber - номер телефона (целое число)
     * @param sex - пол (символ)
     */

    public Person(String lastName, String firstName, String middleName,
                  String dateOfBirth, BigInteger phoneNumber, char sex) {
        this.lastName = lastName;
        this.middleName = middleName;
        this.firstName = firstName;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.sex = sex;
    }



    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public BigInteger getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(BigInteger phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }


    @Override
    public String toString() {
        return '<' + lastName + '>' +
                '<' + firstName + '>' +
                '<' + middleName + '>' +
                '<' + dateOfBirth + '>' +
                '<' + phoneNumber +'>'+
                '<' + sex + '>';
    }
}

package model;

public class Person {

    String lastName;
    String middleName;
    String firstName;
    private String dateOfBirth;
    private int phoneNumber;
    private char sex;

    /**
     *
     * @param lastName - Фамилия (строка)
     * @param middleName - Отчество (строка)
     * @param firstName - Имя (строка)
     * @param dateOfBirth - дата рождения (строка)
     * @param phoneNumber - номер телефона (целое число)
     * @param sex - пол (символ)
     */

    public Person(String lastName, String middleName, String firstName, String dateOfBirth, int phoneNumber, char sex) {
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

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
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
                '<' + middleName + '>' +
                '<' + firstName + '>' +
                '<' + dateOfBirth + '>' +
                '<' + phoneNumber +'>'+
                '<' + sex + '>';
    }
}

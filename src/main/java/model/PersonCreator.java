package model;

public class PersonCreator {

    public PersonCreator() {
    }

    /**
     * Создаем экземпляр Person
     * @param lastName - Фамилия (строка)
     * @param middleName - Отчество (строка)
     * @param firstName - Имя (строка)
     * @param dateOfBirth - дата рождения (строка)
     * @param phoneNumber - номер телефона (целое число)
     * @param sex - пол (символ)
     * @return метод возвращает экземпляр Person
     */
    public Person create(String lastName, String middleName, String firstName, String dateOfBirth, int phoneNumber, char sex) {
        return new Person(lastName, middleName, firstName, dateOfBirth, phoneNumber, sex);
    }

}

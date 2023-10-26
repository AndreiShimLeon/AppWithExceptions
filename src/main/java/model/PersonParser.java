package model;

import java.math.BigInteger;

public class PersonParser {
    ErrorCatcher catcher;
    Checker checker;

    Person person;

    public Person getPerson() {
        return person;
    }

    private final int phoneNumberDigits = 11;
    private final char dateDivider = '.';

    public PersonParser() {
        this.checker = new Checker();
        this.catcher = new ErrorCatcher(checker);
    }

    public Person parseInput(String input) throws IncorrectInput,
            IllegalPhone, DateFormatException {
        // проверяем количество подстрок (6) в строке
        int check = checker.checkNumberOfElements(input, 6);
        if (check < 0) {
            catcher.processNumberOfElements(check);
        }
        // разбиваем строку по пробелам
        String[] data = input.split(" ");
        // Объявляем нужные параметры
        String lastName = "";
        String firstName = "";
        String middleName = "";
        String dateOfBirth = "";
        BigInteger phone = BigInteger.ZERO;
        Character sex = null;
        // проверка каждого элемента массива строк
        for (String string : data
        ) {
            boolean flagNoActions = true;
            // попытка вычленить дату по разделителю
            if (string.contains(Character.toString(dateDivider))) {
                dateOfBirth += string;
                checker.checkDate(dateOfBirth);
                flagNoActions = false;
            }
            // попытка вычленить пол по единственному символу в строке
            if (string.length() == 1) {
                if (string.equalsIgnoreCase("f") ||
                        string.equalsIgnoreCase("m")){
                    sex = string.charAt(0);
                    flagNoActions = false;
                }
                else throw new IncorrectInput("Используйте F/M для обозначения пола");
            } else {
                // попытка вычленить имя, отчество и фамилию из строки:
                boolean flagName = true;
                boolean flagPhone = true;
                for (char ch : string.toCharArray()
                ) {

                    if (!Character.isAlphabetic(ch)) flagName = false;
                    if (!Character.isDigit(ch)) flagPhone = false;
                }

                if (lastName.isBlank() && flagName) {
                    lastName += string;
                    flagNoActions = false;
                }
                else if (firstName.isBlank() && flagName) {
                    firstName += string;
                    flagNoActions = false;
                }
                else if (middleName.isBlank() && flagName){
                    middleName += string;
                    flagNoActions = false;
                }
                // попытка вычленить телефон из строки:
                if (phone.equals(BigInteger.ZERO) && flagPhone){
                    phone = new BigInteger(string);
                    flagNoActions = false;
                    checker.checkPhone(phone, phoneNumberDigits);
                }
            }
            // Если подстроку не удалось распознать, бросаем исключение
            if(flagNoActions) throw new IncorrectInput("Неверные данные: "+string);
        }
        // если все каждая строка помещена в переменную, то возвращаем new Person
        return new Person(lastName, firstName, middleName, dateOfBirth, phone, sex);
    }

    public static void main(String[] args) {
        PersonParser parser = new PersonParser();
//        String input = "FiIOdata.32.3243f";
//        String input = "Aa Bb Cc 861482 F 12/12/2021";
        String input = "Aa Bb Cc 89165341222 F 28.02.2021";
//        String input = "Aa Bb Cc 861482 F 12.12.2021";
//        String input = "Фамилия Имя Отчество 861482 f 12.12.1025";
        try {
            Person person = parser.parseInput(input);
            System.out.println(person);
        } catch (IncorrectInput e) {
            System.out.println(e.getMessage());
        } catch (DateFormatException e) {
            System.out.println(e.getMessage());
        } catch (IllegalPhone e){
            System.out.println(e.getMessage());
        }

    }
}

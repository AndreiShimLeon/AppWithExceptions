package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Checker {
    public Checker() {
    }

    /**
     * Метод проверки ввода на число параметров
     *
     * @param input            - строка с данными;
     * @param parametersNumber - должное число подстрок в строке
     * @return -1 - неверный разделитель в строке;
     * -2 - недостаточное количество подстрок в строке;
     * -3 - слишком большое количество подстрок в строке;
     * parametersNumber - количество подстрок в подстроке верное;
     */
    public int checkNumberOfElements(String input, int parametersNumber) {
        if (!input.contains(" ")) return -1;
        if (input.split(" ").length < parametersNumber) return -2;
        if (input.split(" ").length == parametersNumber) return parametersNumber;
        return -3;
    }

    public void checkPhone(BigInteger phone, int digitNumber) throws IllegalPhone {
        long highLimit = (long) Math.pow(10, digitNumber);
        long lowLimit = (long) Math.pow(10, digitNumber - 1);
        if (phone.compareTo(BigInteger.valueOf(highLimit)) >= 0 ||
                phone.compareTo(BigInteger.valueOf(lowLimit)) < 0) {
            throw new IllegalPhone(phone.toString());
        }
    }


    /**
     * Метод проверки даты.
     * Проверка на:
     * - количество элементов (д, м, г);
     * - присутствие отрицательных чисел в дате;
     * - актуальность года для даты рождения;
     * - проверка месяца;
     * - количество дней в месяце (вкл февраль в високосный год);
     * - проверка даты рождения на будущее;
     *
     * @param date - дата формата dd.mm.yyyy
     */
    public void checkDate(String date) throws DateFormatException {
        String[] dateSplit = date.split("\\.");
        // Проверка на длину массива после сплита
        if (dateSplit.length != 3) {
            throw new DateFormatException(date);
        }

        for (String element : dateSplit
        ) {
            try {
                int day = Integer.parseInt(dateSplit[0]);
                int month = Integer.parseInt(dateSplit[1]);
                if (dateSplit[0].length() != 2)
                    throw new DateFormatException(date + ". Правильный формат dd.mm.yyyy");
                if (dateSplit[1].length() != 2)
                    throw new DateFormatException(date + ". Правильный формат dd.mm.yyyy");
                int year = Integer.parseInt(dateSplit[2]);

                // проверка на отрицательные числа в дате, проверка года и месяца
                Calendar currentDate = Calendar.getInstance();
                if (day <= 0 ||
                        month <= 0 || month > 12 ||
                        year <= 0)
                    throw new DateFormatException("Неверный месяц " + date);

                // проверка дней в месяцах
                switch (month - 1) {
                    case 0, 2, 4, 6, 7, 9, 11:
                        if (day > 31) throw new DateFormatException("Неверный день " + date);
                        break;
                    case 3, 5, 8, 10:
                        if (day > 30) throw new DateFormatException("Неверный день " + date);
                        break;
                    case 1:
                        if (year % 4 == 0 && day > 29)
                            throw new DateFormatException("Превышено число дней в феврале " + year + " года. Не более 29 дней");
                        if (year % 4 != 0 && day > 28)
                            throw new DateFormatException("Превышено число дней в феврале " + year + " года. Не более 28 дней");
                        break;
                }
                // проверка даты рождения на будущее
                Calendar dateOfBirth = Calendar.getInstance();
                dateOfBirth.set(year, month - 1, day);
                if (dateOfBirth.after(currentDate))
                    throw new DateFormatException("Дата рождения не может быть в будущем");
                if (year < 1000) throw new DateFormatException("Необходимо ввести дату в формате dd.mm.yyyy");
                currentDate.set(1900, 0, 0);
                if (dateOfBirth.before(currentDate)) throw new DateFormatException("Дата рождения далеко в прошлом");

            } catch (NumberFormatException e) {
                throw new DateFormatException(date);
            }
        }
    }

    public <T extends Person> void checkRecord(String path, T person) throws RecordDuplicateException, IOException {
        FileReader fileReader = new FileReader(path);
            ArrayList<String> persons = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(fileReader)){
            while(br.ready()){
                persons.add(br.readLine());
            }
        }

        for (String personInArray: persons
        ) {
            if(personInArray.contains(person.getFirstName()) &&
            personInArray.contains(person.getMiddleName()) &&
            personInArray.contains(person.getLastName()) &&
            personInArray.contains(person.getDateOfBirth()) &&
            personInArray.contains(String.valueOf(person.getSex())) &&
            personInArray.contains(person.getPhoneNumber().toString())
            ) throw new RecordDuplicateException();
        }
    }
}

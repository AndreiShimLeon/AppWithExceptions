package model;

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

    /**
     * Метод проверки даты.
     * Проверка на:
     * - количество элементов (д, м, г);
     * - присутствие отрицательных чисел в дате;
     * - актуальность года для даты рождения;
     * - проверка месяца;
     * - количество дней в месяце (вкл февраль в високосный год);
     * - проверка даты рождения на будущее;
     * @param date - дата формата dd.mm.yyyy
     */
    public void checkDate(String date) throws DateFormatException{
        String[] dateSplit = date.split("\\.");
        // Проверка на длину массива после сплита
        if (dateSplit.length != 3) {
            throw new DateFormatException(date);
        }
        int day = Integer.parseInt(dateSplit[0]);
        int month = Integer.parseInt(dateSplit[1]);
        int year = Integer.parseInt(dateSplit[2]);
        // проверка на отрицательные числа в дате, проверка года и месяца
        Calendar currentDate = Calendar.getInstance();
        if (day <= 0 ||
                month <= 0 || month > 12 ||
                year < (currentDate.getWeekYear() - 100) ||
                year > currentDate.getWeekYear())
            throw new DateFormatException(date);

        // проверка дней в месяцах
        switch (month){
            case 0,2,4,6,7,9,11:
                if(day > 31) throw new DateFormatException("Много дней");
                break;
            case 3,5,8,10:
                if(day > 30) throw new DateFormatException("Много дней");
                break;
            case 1:
                if(year%4 == 0 && day > 29) throw new DateFormatException("В феврале " + year + " года 29 дней");
                if(year%4 != 0 && day > 28) throw new DateFormatException("В феврале " + year + " года 28 дней");
                break;
        }
        // проверка даты рождения на будущее
        Calendar dateOfBirth = Calendar.getInstance();
        dateOfBirth.set(year,month-1,day);
        if(dateOfBirth.after(currentDate)) throw new DateFormatException("Дата рождения не может быть в будущем");
    }

    }

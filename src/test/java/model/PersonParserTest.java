package model;

import model.ExceptionsAndErrors.DateFormatException;
import model.ExceptionsAndErrors.IllegalPhone;
import model.ExceptionsAndErrors.IncorrectInput;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonParserTest {
    PersonParser parser = new PersonParser();

    @Test
    void parseInputNormal1() {
        String input = "Andreev Andrei Andreevich 89076003212 M 12.12.2021";
        assertDoesNotThrow(() -> parser.parseInput(input));
    }

    @Test
    void parseInputNormal2() {
        String input = "Ivanov Ivan Ivanovich 89164360842 F 09.05.1925";
        assertDoesNotThrow(() -> parser.parseInput(input));
    }

    @Test
    void parseInputNormal3() {
        String input = "Petrov Petr Petrovich 89167021472 M 31.08.1995";
        assertDoesNotThrow(() -> parser.parseInput(input));
    }

    @Test
    void parseInputWrongInput1() {
        String input = "qwertuopasdfjkbzn23144123gaadm";
        assertThrows(IncorrectInput.class,
                () -> parser.parseInput(input),
                "Данные/Формат ввода неверны. " +
                        "Неверный разделитель в данных.");
    }

    @Test
    void parseInputWrongInput2() {
        String input = "Gsda.df3.dfa.g3e3.adgdf3.12.2023f";
        assertThrows(IncorrectInput.class,
                () -> parser.parseInput(input),
                "Данные/Формат ввода неверны. " +
                        "Неверный разделитель в данных.");
    }

    @Test
    void parseInputNotEnoughSubstrings1() {
        String input = "Andreev Andrei 12345678912 M 31.08.1995";
        assertThrows(IncorrectInput.class,
                () -> parser.parseInput(input),
                "Данные/Формат ввода неверны. " +
                        "Недостаточное количество данных для внесения.");
    }

    @Test
    void parseInputNotEnoughSubstrings2() {
        String input = "Ivanov IvanIvanovich 12345678912 M 09.05.1925";
        assertThrows(IncorrectInput.class,
                () -> parser.parseInput(input),
                "Данные/Формат ввода неверны. " +
                        "Недостаточное количество данных для внесения.");
    }

    @Test
    void parseInputTooManySubstrings1() {
        String input = "Andreev Andrei Andreevich 12345678912 male M 31.08.1995";
        assertThrows(IncorrectInput.class,
                () -> parser.parseInput(input),
                "Данные/Формат ввода неверны. " +
                        "Превышено допустимое количество данных для внесения.");
    }

    @Test
    void parseInputTooManySubstrings2() {
        String input = "Ivanov Ivan Ivanovich Single 12345678912 09.05.1925";
        assertThrows(IncorrectInput.class,
                () -> parser.parseInput(input),
                "Данные/Формат ввода неверны. " +
                        "Превышено допустимое количество данных для внесения.");
    }

    @Test
    void parseInputTooManySubstrings3() {
        String input = "Ivanov Ivan Ivanovich  +7 2345678912 09.05.1925";
        assertThrows(IncorrectInput.class,
                () -> parser.parseInput(input),
                "Данные/Формат ввода неверны. " +
                        "Превышено допустимое количество данных для внесения.");
    }


    @Test
    void parseInputWrongSex1() {
        String input = "Andreev Andrei Andreevich 89076003212 Male 12.12.2021";
        assertThrows(IncorrectInput.class,
                () -> parser.parseInput(input),
                "Данные/Формат ввода неверны. " +
                        "Неверные данные: Male");
    }

    @Test
    void parseInputWrongSex2() {
        String input = "Ivanov Ivan Ivanovich 89164360842 Female 09.05.1925";
        assertThrows(IncorrectInput.class,
                () -> parser.parseInput(input),
                "Данные/Формат ввода неверны. " +
                        "Неверные данные: Female");
    }

    @Test
    void parseInputWrongSex3() {
        String input = "Petrov Petr Petrovich 89167021472 М 31.08.1995";
        assertThrows(IncorrectInput.class,
                () -> parser.parseInput(input),
                "Данные/Формат ввода неверны. " +
                        "Указывайте ФИО полностью и используйте F/M для обозначения пола");
    }

    @Test
    void parseInputWrongSex4() {
        String input = "Petrov Petr Petrovich 89167021472 Ж 31.08.1995";
        assertThrows(IncorrectInput.class,
                () -> parser.parseInput(input),
                "Данные/Формат ввода неверны. " +
                        "Указывайте ФИО полностью и используйте F/M для обозначения пола");
    }

    @Test
    void parseInputWrongName1() {
        String input = "Andreev A A 89076003212 M 12.12.2021";
        assertThrows(IncorrectInput.class,
                () -> parser.parseInput(input),
                "Данные/Формат ввода неверны. " +
                        "Указывайте ФИО полностью и используйте F/M для обозначения пола");
    }

    @Test
    void parseInputWrongName2() {
        String input = "Ivan1 Ivan1 Ivan1 89164360842 F 09.05.1925";
        assertThrows(IncorrectInput.class,
                () -> parser.parseInput(input),
                "Данные/Формат ввода неверны. " +
                        "Неверные данные: Ivan1");
    }

    @Test
    void parseInputWrongName3() {
        String input = "Petrov, Petr, Petrovich 89167021472 M 31.08.1995";
        assertThrows(IncorrectInput.class,
                () -> parser.parseInput(input),
                "Данные/Формат ввода неверны. " +
                        "Неверные данные: Petrov,");
    }

    @Test
    void parseInputWrongPhone1() {
        String input = "Andreev Andrei Andreevich +7(907)6003212 M 12.12.2021";
        assertThrows(IncorrectInput.class,
                () -> parser.parseInput(input),
                "Данные/Формат ввода неверны. " +
                        "Неверные данные: +7(907)6003212");
    }

    @Test
    void parseInputWrongPhone2() {
        String input = "Ivanov Ivan Ivanovich 123456789 F 09.05.1925";
        assertThrows(IllegalPhone.class,
                () -> parser.parseInput(input),
                "Формат номера телефона неверный. " +
                        "123456789");
    }

    @Test
    void parseInputWrongPhone3() {
        String input = "Petrov Petr Petrovich 891670214721 M 31.08.1995";
        assertThrows(IllegalPhone.class,
                () -> parser.parseInput(input),
                "Формат номера телефона неверный. " +
                        "891670214721");
    }

    @Test
    void parseInputWrongPhone4() {
        String input = "Petrov Petr Petrovich 12 M 31.08.1995";
        assertThrows(IllegalPhone.class,
                () -> parser.parseInput(input),
                "Формат номера телефона неверный. " +
                        "12");
    }

    @Test
    void parseInputWrongDate1() {
        String input = "Andreev Andrei Andreevich 89076003212 M 12.12.2023";
        assertThrows(DateFormatException.class,
                () -> parser.parseInput(input),
                "Неверный формат даты. " +
                        "Дата рождения не может быть в будущем");
    }

    @Test
    void parseInputWrongDate2() {
    String input = "Ivanov Ivan Ivanovich 89164360842 F 09.05.1899";
        assertThrows(DateFormatException.class,
                () -> parser.parseInput(input),
                "Неверный формат даты. " +
                        "Дата рождения далеко в прошлом");
    }

    @Test
    void parseInputWrongDate3() {
    String input = "Petrov Petr Petrovich 89167021472 M 31.08.95";
        assertThrows(DateFormatException.class,
                () -> parser.parseInput(input),
                "Неверный формат даты. " +
                        "Необходимо ввести дату в формате dd.mm.yyyy");
    }

    @Test
    void parseInputWrongDate4() {
    String input = "Andreev Andrei Andreevich 89076003212 M 30.02.2021";
        assertThrows(DateFormatException.class,
                () -> parser.parseInput(input),
                "Неверный формат даты. " +
                        "Превышено число дней в феврале  2021 года. Не более 28 дней");
    }

    @Test
    void parseInputWrongDate5() {
    String input = "Andreev Andrei Andreevich 89076003212 M 30.02.2020";
        assertThrows(DateFormatException.class,
                () -> parser.parseInput(input),
                "Неверный формат даты. " +
                        "Превышено число дней в феврале  2020 года. Не более 29 дней");
    }

    @Test
    void parseInputWrongDate6() {
    String input = "Ivanov Ivan Ivanovich 89164360842 F 9.11.1955";
        assertThrows(DateFormatException.class,
                () -> parser.parseInput(input),
                "Неверный формат даты. " +
                        "9.5.1955. Правильный формат dd.mm.yyyy");
    }

    @Test
    void parseInputWrongDate7() {
    String input = "Ivanov Ivan Ivanovich 89164360842 F 19.1.1955";
        assertThrows(DateFormatException.class,
                () -> parser.parseInput(input),
                "Неверный формат даты. " +
                        "19.1.1955. Правильный формат dd.mm.yyyy");
    }

    @Test
    void parseInputWrongDate8() {
    String input = "Petrov Petr Petrovich 89167021472 M 31.06.1995";
        assertThrows(DateFormatException.class,
                () -> parser.parseInput(input),
                "Неверный формат даты. " +
                        "Неверный день 31.06.1995");
    }

    @Test
    void parseInputWrongDate9() {
    String input = "Petrov Petr Petrovich 89167021472 M 300.06.1995";
        assertThrows(DateFormatException.class,
                () -> parser.parseInput(input),
                "Неверный формат даты. " +
                        "Неверный день 300.06.1995");
    }

}
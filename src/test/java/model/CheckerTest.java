package model;

import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

class CheckerTest {
    Checker checker = new Checker();
    int elementNumber = 6;


    @org.junit.jupiter.api.Test
    void testLengthSpaceAbsence() {
        String test = "ИванИвановичИванов12.05.2012M89999999999";
        int result = checker.checkNumberOfElements(test, elementNumber);
        Assertions.assertEquals(-1, result);
    }

    @org.junit.jupiter.api.Test
    void testLengthLow() {
        String test = "Иван Иванович Иванов12.05.2012 M 89999999999";
        int result = checker.checkNumberOfElements(test, elementNumber);
        Assertions.assertEquals(-2, result);
    }

    @org.junit.jupiter.api.Test
    void testLengthHigh() {
        String test = "Иван Иванович Иванов Иванов 12. 05.2012 M 89999999999";
        int result = checker.checkNumberOfElements(test, elementNumber);
        Assertions.assertEquals(-3, result);
    }

    @org.junit.jupiter.api.Test
    void testLengthNormal() {
        String test = "Иван Иванович Иванов 12.05.2012 M 89999999999";
        int result = checker.checkNumberOfElements(test, elementNumber);
        Assertions.assertEquals(6, result);
    }

    @org.junit.jupiter.api.Test
    void dateNormalTest1(){
        String test = "12.12.2002";
        assertDoesNotThrow(() -> checker.checkDate(test));
    }
    @org.junit.jupiter.api.Test
    void dateNormalTest2(){
        String test = "28.02.2003";
        assertDoesNotThrow(() -> checker.checkDate(test));
    }
    @org.junit.jupiter.api.Test
    void dateNormalTest3(){
        String test = "26.10.2023";
        assertDoesNotThrow(() -> checker.checkDate(test));
    }

    @org.junit.jupiter.api.Test
    void dateYearAbsent(){
        String test = "29.02";
        assertThrows(DateFormatException.class,
                ()-> checker.checkDate(test));
    }
    @org.junit.jupiter.api.Test
    void dateDayAbsent(){
        String test = "11.2002";
        assertThrows(DateFormatException.class,
                ()-> checker.checkDate(test));
    }
    @org.junit.jupiter.api.Test
    void dateYearWrong(){
        String test = "29.02.223";
        assertThrows(DateFormatException.class,
                ()-> checker.checkDate(test));
    }
    @org.junit.jupiter.api.Test
    void dateMonthWrong(){
        String test = "29.13.2023";
        assertThrows(DateFormatException.class,
                ()-> checker.checkDate(test));
    }
    @org.junit.jupiter.api.Test
    void dateMonthWrong2(){
        String test = "29.-5.2023";
        assertThrows(DateFormatException.class,
                ()-> checker.checkDate(test));
    }
    @org.junit.jupiter.api.Test
    void dateDayWrong(){
        String test = "32.05.2024";
        assertThrows(DateFormatException.class,
                ()-> checker.checkDate(test));
    }
    @org.junit.jupiter.api.Test
    void dateDayWrong2(){
        String test = "31.06.2024";
        assertThrows(DateFormatException.class,
                ()-> checker.checkDate(test));
    }
    @org.junit.jupiter.api.Test
    void dateDayWrong3(){
        String test = "-30.06.2024";
        assertThrows(DateFormatException.class,
                ()-> checker.checkDate(test));
    }
    @org.junit.jupiter.api.Test
    void dateDayWrong4(){
        String test = "00.06.2024";
        assertThrows(DateFormatException.class,
                ()-> checker.checkDate(test));
    }
    @org.junit.jupiter.api.Test
    void dateFebWrong(){
        String test = "30.02.2024";
        assertThrows(DateFormatException.class,
                ()-> checker.checkDate(test));
    }

    @org.junit.jupiter.api.Test
    void dateFebWrong2(){
        String test = "29.02.2021";
        assertThrows(DateFormatException.class,
                ()-> checker.checkDate(test));
    }
    @org.junit.jupiter.api.Test
    void dateBirthDateInFuture(){
        String test = "29.02.2031";
        assertThrows(DateFormatException.class,
                ()-> checker.checkDate(test));
    }
    @org.junit.jupiter.api.Test
    void dateBirthDateInFuture2(){
        String test = "27.10.2023";
        assertThrows(DateFormatException.class,
                ()-> checker.checkDate(test));
    }


}
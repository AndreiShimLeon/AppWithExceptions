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
}
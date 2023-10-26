package model;

import model.ExceptionsAndErrors.ErrorCatcher;
import model.ExceptionsAndErrors.IncorrectInput;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ErrorCatcherTest {
    ErrorCatcher catcher = new ErrorCatcher(new Checker());
    private String defaultMessage = "Данные/Формат ввода неверны. ";


    @Test
    void processNumberOfElements1() {
        String expected = this.defaultMessage + "Неверный разделитель в данных.";
        String result = "";
        try {
            catcher.processNumberOfElements(-1);

        } catch (IncorrectInput e) {
            result = e.getMessage();
        }
        Assertions.assertEquals(expected, result);
    }
    @Test
    void processNumberOfElements2() {
        String expected = this.defaultMessage + "Недостаточное количество данных для внесения.";
        String result = "";
        try {
            catcher.processNumberOfElements(-2);

        } catch (IncorrectInput e) {
            result = e.getMessage();
        }
        Assertions.assertEquals(expected, result);
    }
    @Test
    void processNumberOfElements3() {
        String expected = this.defaultMessage + "Превышено допустимое количество данных для внесения.";
        String result = "";
        try {
            catcher.processNumberOfElements(-3);

        } catch (IncorrectInput e) {
            result = e.getMessage();
        }
        Assertions.assertEquals(expected, result);
    }

}

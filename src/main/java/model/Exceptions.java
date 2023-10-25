package model;

import java.io.IOException;

public class Exceptions {
}
class DateFormatException extends IOException {
    String message = "Неверный формат даты. ";
    public DateFormatException() {
        super();
    }

    @Override
    public String getMessage() {
        return message;
    }
    public DateFormatException(String message) {
        super();
        this.message += message;
    }
}
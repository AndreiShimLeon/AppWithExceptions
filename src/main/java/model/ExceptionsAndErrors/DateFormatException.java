package model.ExceptionsAndErrors;

import java.io.IOException;
import java.io.Serial;

public class DateFormatException extends IOException {
    private String message = "Неверный формат даты. ";

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


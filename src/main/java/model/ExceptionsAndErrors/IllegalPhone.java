package model.ExceptionsAndErrors;

import java.io.IOException;

public class IllegalPhone extends IOException {
    private String message = "Формат номера телефона неверный. ";

    public IllegalPhone() {
        super();
    }

    @Override
    public String getMessage() {
        return message;
    }

    public IllegalPhone(String message) {
        super();
        this.message += message;
    }
}

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

class IncorrectInput extends IOException{
    String message = "Данные/Формат ввода неверны. ";
    public IncorrectInput() {
        super();
    }

    @Override
    public String getMessage() {
        return message;
    }
    public IncorrectInput(String message) {
        super();
        this.message += message;
    }
}

class IllegalPhone extends IOException{
    String message = "Формат номера телефона неверный. ";
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
package model.ExceptionsAndErrors;

import java.io.IOException;

public class IncorrectInput extends IOException {
    private String message = "Данные/Формат ввода неверны. ";

    public IncorrectInput() {
        super();
    }

    public IncorrectInput(String message, boolean rewriteMessage) {
        super();
        if (rewriteMessage) {
            this.message = message;
        } else {
            this.message += message;
        }
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

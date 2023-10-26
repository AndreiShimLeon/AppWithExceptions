package model.ExceptionsAndErrors;

import java.io.IOException;

public class RecordDuplicateException extends IOException {
    private String message = "Такая запись уже существует. ";

    public RecordDuplicateException() {
        super();
    }

    @Override
    public String getMessage() {
        return message;
    }

    public RecordDuplicateException(String message) {
        super();
        this.message += message;
    }
}

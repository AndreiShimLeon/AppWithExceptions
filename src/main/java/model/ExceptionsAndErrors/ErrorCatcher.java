package model.ExceptionsAndErrors;

import model.Checker;

public class ErrorCatcher {
    public ErrorCatcher(Checker checker) {
        this.checker = checker;
    }

    Checker checker;
    /**
     * @param errorCode - код ошибки из метода checkNumberOfElements();
     *                  -1 - неверный разделитель в строке;
     *                  -2 - недостаточное количество подстрок в строке;
     *                  -3 - слишком большое количество подстрок в строке;
     *                  Целое положительное число означает штатную отработку метода
     */
    public void processNumberOfElements(int errorCode) throws IncorrectInput {
        if (errorCode == -1) {
            throw new IncorrectInput("Неверный разделитель в данных.");
        }
        if (errorCode == -2) {
            throw new IncorrectInput("Недостаточное количество данных для внесения.");
        }
        if (errorCode == -3) {
            throw new IncorrectInput("Превышено допустимое количество данных для внесения.");
        }
    }

}

package model;

public class EECatcher {
    /**
     * @param errorCode - код ошибки из метода checkNumberOfElements();
     *                  -1 - неверный разделитель в строке;
     *                  -2 - недостаточное количество подстрок в строке;
     *                  -3 - слишком большое количество подстрок в строке;
     *                  Целое положительное число означает штатную отработку метода
     */
    public void processNumberOfElements(int errorCode) {
        if (errorCode == -1) {
            System.out.println("Неверный разделитель в данных.");
        }
        if (errorCode == -2) {
            System.out.println("Недостаточное количество данных для внесения.");
        }
        if (errorCode == -3) {
            System.out.println("Превышено допустимое количество данных для внесения.");
        }
    }
}

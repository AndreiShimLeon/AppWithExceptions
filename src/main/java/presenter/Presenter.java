package presenter;

import model.*;
import model.ExceptionsAndErrors.DateFormatException;
import model.ExceptionsAndErrors.IllegalPhone;
import model.ExceptionsAndErrors.IncorrectInput;
import view.Viewer;

import java.io.IOException;


public class Presenter {

    Archiver<Person> archiver;
    Viewer viewer;
    PersonParser personParser;
    Checker checker;

    /**
     * Конструктор Презентера, принимаем экземпляры архивера, криэйтера и вьювера
     *
     * @param archiver
     * @param viewer
     */

    public Presenter(Archiver<Person> archiver, Viewer viewer, PersonParser personParser, Checker checker) {
        this.archiver = archiver;
        this.viewer = viewer;
        this.personParser = personParser;
        this.checker = checker;
    }

    public Presenter() {
        this.checker = new Checker();
        this.archiver = new Archiver<>(this.checker);
        this.viewer = new Viewer();
        this.personParser = new PersonParser();
    }

    /**
     * Запускаем логику презентера
     */

    public void start() {
        boolean flag = true;
        while (flag) {
            viewer.printInConsole("Выберите действие: \n" +
                    "1. Ввести новую запись\n" +
                    "2. Выйти\n");
            String choice = viewer.scanData();
            try {
                int choiceChecked = checker.checkChoice(choice, 1, 2);
                switch (choiceChecked) {
                    case 1:
                        viewer.printInConsole("Для сохранения данных введите (1) ФИО, (2)дату рождения, " +
                                "(3)номер телефона и (4)пол через пробел в произвольном порядке.\n" +
                                "Дата должна быть введена в формате dd.mm.yyyy.\n" +
                                "Номер телефона не должен содержать символов, отличных от цифр.\n");
                        String enteredData = viewer.scanData();
                        try {
                            archiver.createPersonFile(personParser.parseInput(enteredData));
                            break;
                        } catch (IllegalPhone e) {
                            viewer.printInConsole(e.getMessage());
                        } catch (DateFormatException e) {
                            viewer.printInConsole(e.getMessage());
                        } catch (IncorrectInput e){
                            viewer.printInConsole(e.getMessage());
                        } catch (IOException e) {
                            viewer.printInConsole(e.getMessage());
                        }

                        break;
                    case 2:
                        flag = false;
                        viewer.printInConsole("До свидания!");
                        break;
                }
            } catch (IncorrectInput e) {
                viewer.printInConsole(e.getMessage());
            } catch (NumberFormatException e) {
                viewer.printInConsole("Неверный выбор, повторите. ");
            }
        }
    }
}

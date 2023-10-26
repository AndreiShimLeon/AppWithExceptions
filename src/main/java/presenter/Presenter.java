package presenter;

import model.*;
import view.Viewer;


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
        while (true){
            String enteredData = viewer.scanData("Для сохранения данных введите (1) ФИО, (2)дату рождения, " +
                    "(3)номер телефона и (4)пол через пробел в произвольном порядке.\n" +
                    "Дата должна быть введена в формате dd.mm.yyyy.\n" +
                    "Номер телефона не должен содержать символов, отличных от цифр.\n");

        }
    }

    /**
     * Записываем юзера в отдельный файл
     *
     * @param person - экземпляр Юзера
     */

    private void archive(Person person) {
        //TODO: вызываем метод записи файл через проверку существования этого файла
    }


}

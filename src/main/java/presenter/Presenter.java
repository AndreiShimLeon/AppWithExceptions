package presenter;

import model.*;
import view.Viewer;


public class Presenter {


    Archiver<Person> archiver;
    PersonCreator personCreator;
    Viewer viewer;
    PersonParser personParser;
    Checker checker;

    /**
     * Конструктор Презентера, принимаем экземпляры архивера, криэйтера и вьювера
     *
     * @param archiver
     * @param personCreator
     * @param viewer
     */

    public Presenter(Archiver<Person> archiver, PersonCreator personCreator, Viewer viewer, PersonParser personParser, Checker checker) {
        this.archiver = archiver;
        this.personCreator = personCreator;
        this.viewer = viewer;
        this.personParser = personParser;
        this.checker = checker;
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

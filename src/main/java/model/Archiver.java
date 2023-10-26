package model;

import model.ExceptionsAndErrors.DateFormatException;
import model.ExceptionsAndErrors.IllegalPhone;
import model.ExceptionsAndErrors.IncorrectInput;
import model.ExceptionsAndErrors.RecordDuplicateException;

import java.io.*;

public class Archiver<T extends Person> {
    Checker checker;
    public Archiver(Checker checker) {
        this.checker = checker;
    }

    /**
     * Преобразуем экземпляр класса Person в строковый массив из его полей.
     * @param person - экземпляр класса Person
     * @return возвращаем строковый массив
     */

    private  String[] personToArray(T person){
        String[] personArray = new String[6];
        personArray[0] = "<" + person.getLastName() + ">";
        personArray[1] = "<" + person.getFirstName() + ">";
        personArray[2] = "<" + person.getMiddleName() + ">";
        personArray[3] = "<" + person.getDateOfBirth()+ ">";
        personArray[4] = "<" + person.getPhoneNumber() + ">";
        personArray[5] = "<" + person.getSex() + ">";
        return personArray;
    }

    /**
     * Если файл с фамилией Person существует, дописываем в этот файл новые данные,
     * иначе создаем новый файл и записываем в него.
     * Если в существующем файле данные полностью дублируются, сообщаем об ошибке
     * @param person - экземпляр класса Person
     */
    public void createPersonFile(T person) throws RecordDuplicateException, IOException{
        String path = person.getLastName() + ".txt";
        File file = new File(path);
        if (file.exists()) {
            checker.checkRecord(path, person);
            try (FileWriter fw = new FileWriter(path, true)) {
                fw.write("\n");
                for (String string : personToArray(person)
                     ) {
                    fw.write(string);
                }
            } catch (IOException e) {
                e.printStackTrace(System.out);
            }
        } else{
            try (FileWriter fw = new FileWriter(path)) {
                fw.write("\n");
                for (String string : personToArray(person)
                ) {
                    fw.write(string);
                }
            } catch (IOException e) {
                e.printStackTrace(System.out);
            }
        }
        System.out.println("Запись корректно завершена");
    }


    public static void main(String[] args) {
        String input = "Andreev Andreis Andreevich 89076003212 M 12.12.2021";
        Archiver archiver = new Archiver(new Checker());
        PersonParser parser = new PersonParser();
        try {
            archiver.createPersonFile(parser.parseInput(input));
        } catch (IncorrectInput e) {
            e.printStackTrace(System.out);
        } catch (IllegalPhone e) {
            e.printStackTrace(System.out);
        } catch (DateFormatException e) {
            e.printStackTrace(System.out);
        } catch (RecordDuplicateException e) {
            e.printStackTrace(System.out);
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }

}

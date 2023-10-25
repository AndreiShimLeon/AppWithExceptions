package model;

public class PersonParser {
    Checker checker;

    Person person;
    public PersonParser() {
        this.checker = new Checker();
    }

    public Person parse(String input, int parametersNumber){
        checker.checkNumberOfElements(input, parametersNumber);
        // TODO: парсинг строки по пробелам
        String[] data = input.split(" ");
        if(data.length != parametersNumber) throw new RuntimeException(); //TODO: исключение для неверного ввода


        // TODO: Выделение ФИО, даты, телефона, пола,
        // TODO:
        // TODO:
        // TODO:
        return null;
    }

    public static void main(String[] args) {

        String input = "FIOdata.32.3243f";
        String[] data = input.split(" ");
        for (String str: data
             ) {
            System.out.println(str);
        }
    }
}

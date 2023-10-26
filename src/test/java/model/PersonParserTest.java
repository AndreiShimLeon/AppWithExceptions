package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonParserTest {
/*
    String input = "Andreev Andrei Andreevich 12345678912 M 12.12.2021";
    String input = "qwertuopasdfjkbzn23144123gaad";
    String input = "Aa Bb Cc 89165341222 F 28.02.2021";
    String input = "Aa Bb Cc 861482 F 12.12.2021";
    String input = "Фамилия Имя Отчество 861482 f 12.12.1025";
*/
    @BeforeEach
    void setUp() {
        PersonParser parse = new PersonParser();
    }

    @Test
    void parseInput() {
    }
}
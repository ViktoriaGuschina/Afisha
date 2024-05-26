package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FilmManagerTest {
    FilmManager filmManager;

    @BeforeEach
    void setUp() {
        filmManager = new FilmManager();
        filmManager.save("Бладшот");
        filmManager.save("Вперед");
        filmManager.save("Отель Белград");
        filmManager.save("Джентельмены");
        filmManager.save("Человек-невидимка");
        filmManager.save("Тролли. Мировой тур");
        filmManager.save("Номер один");
    }

    @Test
    public void save() {
        String actual = filmManager.findAll()[1];
        String expected = "Вперед";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void findAll() {
        String[] expected = new String[]{
                "Бладшот", "Вперед", "Отель Белград", "Джентельмены", "Человек-невидимка", "Тролли. Мировой тур", "Номер один"
        };
        String[] actual = filmManager.findAll();
        assertArrayEquals(expected, actual);

    }

    @Test
    public void findLast() {
        String[] expected = new String[]{
                "Номер один", "Тролли. Мировой тур", "Человек-невидимка", "Джентельмены", "Отель Белград"
        };
        String[] actual = filmManager.findLast();
        assertArrayEquals(expected, actual);
    }
}
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
                "Бладшот", "Вперед", "Отель Белград", "Джентельмены", "Человек-невидимка"
        };
        String[] actual = filmManager.findAll();
        assertArrayEquals(expected, actual);

    }

    @Test
    public void findLastMoreThenLimit() {
        String[] expected = new String[]{
                "Номер один", "Тролли. Мировой тур", "Человек-невидимка", "Джентельмены", "Отель Белград"
        };
        filmManager.save("Тролли. Мировой тур");
        filmManager.save("Номер один");
        String[] actual = filmManager.findLast();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void findLast() {
        String[] expected = new String[]{
                "Человек-невидимка", "Джентельмены", "Отель Белград", "Вперед", "Бладшот"
        };

        String[] actual = filmManager.findLast();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void filmsLimitTwo() {

        FilmManager filmManager2 = new FilmManager(2);
        filmManager2.save("Тролли. Мировой тур");
        filmManager2.save("Номер один");
        String[] expected = new String[]{
                "Номер один", "Тролли. Мировой тур"
        };
        String[] actual = filmManager2.findLast();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void findLastLessThenLimit() {
        FilmManager filmManager1 = new FilmManager(2);
        filmManager1.save("Сумерки");
        String[] expected = new String[]{
                "Сумерки"
        };
        Assertions.assertArrayEquals(expected, filmManager1.findLast());
    }
}
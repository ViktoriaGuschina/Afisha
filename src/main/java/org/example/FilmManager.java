package org.example;

public class FilmManager {
    private int filmslength = 10;
    private String[] films = new String[filmslength];
    private int limit = 5;

    public FilmManager() {
    }

    public FilmManager(int limit) {
        this.limit = limit;
    }

    private int size() {
        for (int i = 0; i < filmslength; i++) {
            if (films[i] == null) {
                return i;
            }
        }
        return filmslength;
    }

    public void save(String nameFilm) {
        int size = size();
        if (size == filmslength) {
            this.filmslength = filmslength * 3 / 2;
            String[] copy = new String[filmslength];
            System.arraycopy(films, 0, copy, 0, size);
        }
        films[size] = nameFilm;
    }

    public String[] findAll() {
        int size = size();
        String[] result = new String[size];
        for (int i = 0; i < size; i++) {
            result[i] = films[i];
        }
        return result;
    }

    public String[] findLast() {
        int size = size();
        String[] last = new String[limit];
        int l = 0;
        for (int i = size - 1; i > size - limit - 1; i--) {
            last[l] = films[i];
            l++;
        }
        return last;
    }

}

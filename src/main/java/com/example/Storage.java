package com.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Storage {

    private final static ObjectMapper mapper = new ObjectMapper();
    private static final String path = "appdata/appdata.txt";
    private static File file;

    public Storage() {
        file = new File(path);
        if (!file.exists()) {
            System.out.println("ФАйЛ НЕ НАЙДЕН!");
            try {
                if (file.createNewFile()) {
                    System.out.println("СОЗДАН НОВЫЙ ФАЙЛ!");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Set<Animal> readFromFile() {
        Set<Animal> animalSet = new HashSet<>();
        try {
            animalSet = mapper.readValue(file, new TypeReference<>() {
            });
            System.out.println("УСПЕШНО ПРОЧИТАНО ИЗ ФАЙЛА!");
        } catch (Exception e) {
            System.out.println("ОШИБКА ЧТЕНИЯ ИЗ ФАЙЛА!");
        }
        return animalSet;
    }

    public void saveToFile(Set<Animal> set) {
        try {
            File file = new File(path);
            if (!file.exists()) {
                System.out.println("ФАйЛ НЕ НАЙДЕН!");
                if (file.createNewFile()) {
                    System.out.println("СОЗДАН НОВЫЙ ФАЙЛ!");
                    mapper.writeValue(file, set);
                    System.out.println("УСПЕШНО СОХРАНЕНО В ФАЙЛ!");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("ОШИБКА СОХРАНЕНИЯ В ФАЙЛ!");
        }
    }
}

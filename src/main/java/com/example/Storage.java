package com.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Storage {

    private final static ObjectMapper mapper = new ObjectMapper();
    private final static File fileParent = new File(System.getProperty("user.dir"));
    private final static File file = new File(fileParent, "appdata/appdata.txt");

    public static Set<Animal> readFromFile() {
        Set<Animal> animalSet = new HashSet<>();
        try {
            animalSet = mapper.readValue(file, new TypeReference<>() {
            });
            System.out.println("УСПЕШНО ПРОЧИТАНО ИЗ ФАЙЛА!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ОШИБКА ЧТЕНИЯ ИЗ ФАЙЛА!");
        }
        return animalSet;
    }

    public static void saveToFile(Set<Animal> set) {
        try {
            mapper.writeValue(file, set);
            System.out.println("УСПЕШНО СОХРАНЕНО В ФАЙЛ!");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("ОШИБКА СОХРАНЕНИЯ В ФАЙЛ!");
        }
    }
}

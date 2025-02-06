package com.example;

import com.example.Animal;
import com.example.Storage;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class ZooService {

    private HashSet<Animal> animals;

    public ZooService() {
        this.animals = (HashSet<Animal>) Storage.readFromFile();
    }

    public String getAll() {
        StringBuilder sb = new StringBuilder();
        sb.append("Список всех животных в зоопарке:");
        sb.append(System.lineSeparator());
        for (Animal a : animals) {
            sb.append(a.toString());
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

    public String getAllByType(Animal.Type type) {
        StringBuilder sb = new StringBuilder();
        sb.append("Список всех животных указанного типа:");
        sb.append(System.lineSeparator());
        Set<Animal> set = animals.stream()
                .filter(a -> a.getType() == type)
                .collect(Collectors.toSet());
        for (Animal a : set) {
            sb.append(a.toString());
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

    public String getAllByFeedType(Animal.FeedType type) {
        StringBuilder sb = new StringBuilder();
        sb.append("Список всех животных указанного типа корма:");
        sb.append(System.lineSeparator());
        Set<Animal> set = animals.stream()
                .filter(a -> a.getFeedType() == type)
                .collect(Collectors.toSet());
        for (Animal a : set) {
            sb.append(a.toString());
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

    public String getAllByColor(Animal.Color color) {
        StringBuilder sb = new StringBuilder();
        sb.append("Список всех животных указанного цвета:");
        sb.append(System.lineSeparator());
        Set<Animal> set = animals.stream()
                .filter(a -> a.getColor() == color)
                .collect(Collectors.toSet());
        for (Animal a : set) {
            sb.append(a.toString());
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

    public String getAllByHabitat(Animal.Habitat habitat) {
        StringBuilder sb = new StringBuilder();
        sb.append("Список всех животных указанного ареала обитания:");
        sb.append(System.lineSeparator());
        Set<Animal> set = animals.stream()
                .filter(a -> a.getHabitat() == habitat)
                .collect(Collectors.toSet());
        for (Animal a : set) {
            sb.append(a.toString());
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

    public String getAnyByType(Animal.Type type) {
        Optional<Animal> opt = animals.stream()
                .filter(a -> a.getType() == type)
                .findFirst();
        if (opt.isEmpty()) return "ОШИБКА!";
        return opt.get().toString();
    }

    public String add(Animal a) {
        if (animals.contains(a)) {
            return "ОШИБКА! Такое животное уже есть в зоопарке";
        }
        animals.add(a);
        Storage.saveToFile(animals);
        return "УСПЕШНО!";
    }

    public String get(String name) {
        Optional<Animal> opt = animals.stream()
                .filter(a -> a.getName().equals(name))
                .findFirst();
        if (opt.isEmpty()) return "ОШИБКА! Животное с именем " + name + " не найдено";
        return opt.get().toString();
    }

    public String delete(String name) {
        Optional<Animal> opt = animals.stream()
                .filter(a -> a.getName().equals(name))
                .findFirst();
        if (opt.isEmpty()) return "ОШИБКА! Животное с именем " + name + " не найдено";
        animals.remove(opt.get());

        Storage.saveToFile(animals);

        return "УСПЕШНО!";
    }

    public String updateName(String oldName, String newName) {
        Optional<Animal> optOld = animals.stream()
                .filter(a -> a.getName().equals(oldName))
                .findFirst();
        if (optOld.isEmpty()) return "ОШИБКА! Животное с именем " + oldName + " не найдено";

        Optional<Animal> optNew = animals.stream()
                .filter(a -> a.getName().equals(newName))
                .findFirst();
        if (optNew.isPresent()) return "ОШИБКА! Животное с именем " + newName + " уже есть";

        Animal a = optOld.get();
        a.setName(newName);
        animals.remove(optOld.get());
        animals.add(a);

        Storage.saveToFile(animals);

        return "УСПЕШНО!";
    }

    public String compare(String name1, String name2) {
        Optional<Animal> opt1 = animals.stream()
                .filter(a -> a.getName().equals(name1))
                .findFirst();
        if (opt1.isEmpty()) return "ОШИБКА! Животное с именем " + name1 + " не найдено";

        Optional<Animal> opt2 = animals.stream()
                .filter(a -> a.getName().equals(name2))
                .findFirst();
        if (opt2.isEmpty()) return "ОШИБКА! Животное с именем " + name2 + " не найдено";

        Animal a1 = opt1.get();
        Animal a2 = opt2.get();

        StringBuilder sb = new StringBuilder();
        sb.append("Результат сравнения животных " + name1 + " и " + name2 + ":");
        sb.append(System.lineSeparator());

        sb.append("тип=");
        if (a1.getType().equals(a2.getType())) sb.append("одинаковый");
        else sb.append("разный");
        sb.append(System.lineSeparator());

        sb.append("тип корма=");
        if (a1.getFeedType().equals(a2.getFeedType())) sb.append("одинаковый");
        else sb.append("разный");
        sb.append(System.lineSeparator());

        sb.append("цвет=");
        if (a1.getColor().equals(a2.getColor())) sb.append("одинаковый");
        else sb.append("разный");
        sb.append(System.lineSeparator());

        sb.append("ареал обитания=");
        if (a1.getHabitat().equals(a2.getHabitat())) sb.append("одинаковый");
        else sb.append("разный");
        sb.append(System.lineSeparator());

        sb.append("количество лап=");
        if (a1.getPawNumber() == a2.getPawNumber()) sb.append("одинаковое");
        else sb.append("разное");
        sb.append(System.lineSeparator());

        return sb.toString();
    }
}

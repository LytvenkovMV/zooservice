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
}

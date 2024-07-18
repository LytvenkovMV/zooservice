import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class ZooService {

    private Set<Animal> animals;

    public ZooService() {
        this.animals = Storage.readFromFile();
    }

    public String getAll() {
        StringBuilder sb = new StringBuilder();
        sb.append("Список всех животных в зоопарке:");
        sb.append(System.lineSeparator());
        for (Animal a : animals) {
            sb.append(a.toString());
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
        for (Animal a : set) sb.append(a.toString());
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

    public String delete(String name) {
        Optional<Animal> opt = animals.stream()
                .filter(a -> a.getName().equals(name))
                .findFirst();
        if (opt.isEmpty()) return "ОШИБКА!";
        animals.remove(opt.get());
        Storage.saveToFile(animals);
        return "УСПЕШНО!";
    }

    public String updateName (String oldName, String newName) {
        Optional<Animal> optOld = animals.stream()
                .filter(a -> a.getName().equals(oldName))
                .findFirst();
        if (optOld.isEmpty()) return "ОШИБКА!";
        animals.remove(optOld.get());
        Animal a = optOld.get();
        a.setName(newName);
        animals.add(a);
        Storage.saveToFile(animals);
        return "УСПЕШНО!";
    }
}

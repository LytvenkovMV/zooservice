import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Set;

public class ZooService {

    private Set<Animal> animals;

    public ZooService(Set<Animal> animals) {
        this.animals = animals;
    }

    public String getAll() {
        StringBuilder sb = new StringBuilder();
        sb.append("Список всех животных:");
        sb.append(System.lineSeparator());
        for (Animal a : animals) {
            sb.append(a.toString());
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

    public String getByType(Animal.Type type) {
        StringBuilder sb = new StringBuilder();
        sb.append("Список всех животных типа :");
        return sb.toString();
    }

    public String add(Animal a) {
        if (animals.contains(a)) {
            return "ОШИБКА! Такое животное уже есть в зоопарке";
        }
        animals.add(a);
        return saveToFile(animals);
    }

    private String saveToFile(Set<Animal> set) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File("/zooservice.txt"), set);
        } catch (IOException e) {
            e.printStackTrace();
            return "ОШИБКА!";
        }
        return "УСПЕШНО!";
    }
}

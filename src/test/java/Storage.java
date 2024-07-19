import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;

public class Storage {

    private final static ObjectMapper mapper = new ObjectMapper();
    private final static File fileParent = new File(System.getProperty("user.dir"));
    private final static File file = new File(fileParent, "appdata/appdata.txt");

    public static Set<Animal> readFromFile() {
        Set<LinkedHashMap> rawSet;
        Set<Animal> animalSet = new HashSet<>();
        try {
            rawSet = mapper.readValue(file, Set.class);
            for (LinkedHashMap map : rawSet) {
                String name = (String) map.get("name");
                Animal.Type type = Animal.Type.valueOf((String) map.get("type"));
                Animal.FeedType feedType = Animal.FeedType.valueOf((String) map.get("feedType"));
                Animal.Habitat habitat = Animal.Habitat.valueOf((String) map.get("habitat"));
                Animal.Color color = Animal.Color.valueOf((String) map.get("color"));
                int pawNumber = (int) map.get("pawNumber");
                Animal animal = new Animal(type, pawNumber, feedType, name, color, habitat);
                animalSet.add(animal);
            }
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

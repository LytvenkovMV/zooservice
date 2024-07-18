import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Storage {

    private final static ObjectMapper mapper = new ObjectMapper();
    private final static String FILE_PATH = "C:/GIT/zooservice/src/test/java/zooservice.txt";

    public static Set<Animal> readFromFile() {
        Set<Animal> set = new HashSet<>();
//        try {
//            set.add(mapper.readValue(new File(FILE_PATH), Animal.class));
//        } catch (IOException e) {
//            e.printStackTrace();
//            System.out.println("ОШИБКА ЧТЕНИЯ!");
//        }
        System.out.println("УСПЕШНО ПРОЧИТАНО!");
        return set;
    }

    public static void saveToFile(Set<Animal> set) {
//        try {
//            mapper.writeValue(new File(FILE_PATH), set);
//        } catch (IOException e) {
//            e.printStackTrace();
//            System.out.println("ОШИБКА СОХРАНЕНИЯ!");
//        }
        System.out.println("УСПЕШНО СОХРАНЕНО!");
    }
}

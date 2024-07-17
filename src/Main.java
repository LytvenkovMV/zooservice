import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Set<Animal> set = new HashSet<>();
        ZooService service = new ZooService(set);
        String cmd;

        do {
            System.out.println("Введите номер команды (S - список)");
            cmd = System.console().readLine();
            switch (cmd) {
                case "S":
                    System.out.println("1 - Получить список всех животных");
                    System.out.println("2 - Получить список животных по типу");
                    System.out.println("3 - Получить любое животное по типу");
                    System.out.println("4 - Удалить животное");
                    System.out.println("5 - Обновить имя животного");
                    break;
                case "1":
                    System.out.println(service.getAll());
                    break;
                case "2":
                    do {
                        System.out.println("Введите тип животного (S - список)");
                        cmd = System.console().readLine();
                        switch (cmd) {
                            case "S":
                                System.out.println("1 - Волк");
                                System.out.println("2 - Тигр");
                                System.out.println("3 - Медведь");
                                System.out.println("4 - Пингвин");
                                System.out.println("5 - Кенгуру");
                                System.out.println("R - ОТМЕНА");
                                break;
                            case "1":
                                System.out.println(service.getByType(Animal.Type.WOLF));
                                break;
                            case "2":
                                System.out.println(service.getByType(Animal.Type.TIGER));
                                break;
                            case "3":
                                System.out.println(service.getByType(Animal.Type.BEAR));
                                break;
                            case "4":
                                System.out.println(service.getByType(Animal.Type.PENGUIN));
                                break;
                            case "5":
                                System.out.println(service.getByType(Animal.Type.KANGAROO));
                                break;
                            case "R":
                                break;
                            default:
                                System.out.println("ОШИБКА!");
                        }
                    } while (!cmd.equals("R"));
                    break;
                default:
                    System.out.println("ОШИБКА!");
            }
        } while (true);
    }
}
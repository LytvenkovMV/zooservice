import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Set<Animal> set = new HashSet<>();
        ZooService service = new ZooService(set);
        String cmd;
        boolean isExit;

        do {
            System.out.println("Введите номер команды (S - список)");
            cmd = System.console().readLine();
            isExit = false;
            switch (cmd) {
                case "S":
                    System.out.println("1 - Получить список всех животных");
                    System.out.println("2 - Получить список животных по типу");
                    System.out.println("3 - Получить любое животное по типу");
                    System.out.println("4 - Добавить животное");
                    System.out.println("5 - Удалить животное");
                    System.out.println("6 - Обновить имя животного");
                    break;
                case "1":
                    System.out.println(service.getAll());
                    break;
                case "2":
                    do {
                        System.out.println("Введите тип животного (S - список)");
                        cmd = System.console().readLine();
                        isExit = false;
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
                                isExit = true;
                                break;
                            default:
                                System.out.println("ОШИБКА!");
                        }
                    } while (!isExit);
                    break;
                case "3":
                    break;
                case "4":
                    Animal.Type type = null;
                    Animal.FeedType feedType = null;
                    Animal.Habitat habitat = null;
                    Animal.Color color = null;
                    String name = null;
                    Integer pawNumber = null;

                    do {
                        /* GET TYPE */
                        System.out.println("Введите тип животного (S - список)");
                        cmd = System.console().readLine();
                        isExit = false;
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
                                type = Animal.Type.WOLF;
                                break;
                            case "2":
                                type = Animal.Type.TIGER;
                                break;
                            case "3":
                                type = Animal.Type.BEAR;
                                break;
                            case "4":
                                type = Animal.Type.PENGUIN;
                                break;
                            case "5":
                                type = Animal.Type.KANGAROO;
                                break;
                            case "R":
                                isExit = true;
                                break;
                            default:
                                System.out.println("ОШИБКА!");
                        }

                        /* GET HABITAT */
                        System.out.println("Введите ареол обитания (S - список)");
                        cmd = System.console().readLine();
                        isExit = false;
                        switch (cmd) {
                            case "S":
                                System.out.println("1 - Евразия");
                                System.out.println("2 - Северная Америка");
                                System.out.println("3 - Южная Америка");
                                System.out.println("4 - Африка");
                                System.out.println("5 - Австралия");
                                System.out.println("6 - Антарктида");
                                System.out.println("R - ОТМЕНА");
                                break;
                            case "1":
                                habitat = Animal.Habitat.EURASIA;
                                break;
                            case "2":
                                habitat = Animal.Habitat.NORTH_AMERICA;
                                break;
                            case "3":
                                habitat = Animal.Habitat.SOUTH_AMERICA;
                                break;
                            case "4":
                                habitat = Animal.Habitat.AFRICA;
                                break;
                            case "5":
                                habitat = Animal.Habitat.AUSTRALIA;
                                break;
                            case "6":
                                habitat = Animal.Habitat.ANTARCTICA;
                                break;
                            case "R":
                                isExit = true;
                                break;
                            default:
                                System.out.println("ОШИБКА!");
                        }

                        /* GET COLOR */
                        System.out.println("Введите цвет животного (S - список)");
                        cmd = System.console().readLine();
                        isExit = false;
                        switch (cmd) {
                            case "S":
                                System.out.println("1 - Черный");
                                System.out.println("2 - Серый");
                                System.out.println("3 - Желтый");
                                System.out.println("4 - Белый");
                                System.out.println("R - ОТМЕНА");
                                break;
                            case "1":
                                color = Animal.Color.BLACK;
                                break;
                            case "2":
                                color = Animal.Color.GRAY;
                                break;
                            case "3":
                                color = Animal.Color.YELLOW;
                                break;
                            case "4":
                                color = Animal.Color.WHITE;
                                break;
                            case "R":
                                isExit = true;
                                break;
                            default:
                                System.out.println("ОШИБКА!");
                        }

                        /* GET FEED TYPE */
                        System.out.println("Введите тип корма для животного (S - список)");
                        cmd = System.console().readLine();
                        isExit = false;
                        switch (cmd) {
                            case "S":
                                System.out.println("1 - Трава");
                                System.out.println("2 - Мясо");
                                System.out.println("R - ОТМЕНА");
                                break;
                            case "1":
                                feedType = Animal.FeedType.GRASS;
                                break;
                            case "2":
                                feedType = Animal.FeedType.MEAT;
                                break;
                            case "R":
                                isExit = true;
                                break;
                            default:
                                System.out.println("ОШИБКА!");
                        }

                        /* GET NAME */
                        System.out.println("Введите имя животного");
                        name = System.console().readLine();

                        /* GET PAW NUMBER */
                        System.out.println("Введите количество лап");
                        pawNumber = Integer.parseInt(System.console().readLine());

                        if (type == null || name == null || pawNumber == null || feedType == null) throw new RuntimeException();
                        Animal animal = new Animal(type, name, pawNumber, feedType);
                        System.out.println(service.add(animal));
                    } while (!isExit);
                    break;
                case "5":
                    break;
                case "6":
                    break;
                case "R":
                    isExit = true;
                    break;
                default:
                    System.out.println("ОШИБКА!");
            }
        } while (!isExit);
    }
}
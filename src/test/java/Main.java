import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Animal.Type type;
        Animal.FeedType feedType;
        Animal.Habitat habitat;
        Animal.Color color;
        String name;
        int pawNumber;
        ZooService service = new ZooService();
        Scanner scanner = new Scanner(System.in);
        String cmd;
        boolean isExit = false;

        do {
            System.out.println("Введите номер команды (0 - список)");
            cmd = scanner.nextLine();
            switch (cmd) {
                /* GET COMMAND LIST */
                case "0":
                    UIService.printCommandList();
                    break;

                /* GET ALL ANIMALS */
                case "1":
                    System.out.println(service.getAll());
                    break;

                /* GET ALL ANIMALS BY TYPE */
                case "2":
                    System.out.println("Введите тип животного (0 - список)");
                    type = UIService.getAnimalType();
                    System.out.println(service.getAllByType(type));
                    break;

                /* GET ANY ANIMAL BY TYPE */
                case "3":
                    System.out.println("Введите тип животного (0 - список)");
                    type = UIService.getAnimalType();
                    System.out.println(service.getAnyByType(type));
                    break;

                /* ADD ANIMAL */
                case "4":
                    System.out.println("Введите тип животного (0 - список)");
                    type = UIService.getAnimalType();
                    System.out.println("Введите тип корма для животного (0 - список)");
                    feedType = UIService.getAnimalFeedType();
                    System.out.println("Введите ареал обитания (0 - список)");
                    habitat = UIService.getAnimalHabitat();
                    System.out.println("Введите цвет животного (0 - список)");
                    color = UIService.getAnimalColor();
                    System.out.println("Введите имя животного не меннее 3-х символов");
                    name = UIService.getAnimalName();
                    System.out.println("Введите количество лап от 2 до 100");
                    pawNumber = UIService.getAnimalPawNumber();
                    Animal animal = new Animal(type, pawNumber, feedType, name, color, habitat);
                    System.out.println(service.add(animal));
                    break;

                /* GET ANIMAL BY NAME */
                case "5":
                    System.out.println("Введите имя животного");
                    name = UIService.getAnimalName();
                    System.out.println(service.get(name));
                    break;

                /* DELETE ANIMAL */
                case "6":
                    System.out.println("Введите имя животного");
                    name = UIService.getAnimalName();
                    System.out.println(service.delete(name));
                    break;

                /* UPDATE ANIMAL NAME */
                case "7":
                    System.out.println("Введите старое имя");
                    String oldName = UIService.getAnimalName();
                    System.out.println("Введите новое имя");
                    String newName = UIService.getAnimalName();
                    System.out.println(service.updateName(oldName, newName));
                    break;

                /* EXIT */
                case "R":
                    System.out.println("РАБОТА ЗАВЕРШЕНА!");
                    isExit = true;
                    break;

                default:
                    System.out.println("ОШИБКА!");
            }
        } while (!isExit);
    }
}
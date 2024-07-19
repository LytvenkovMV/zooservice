import java.util.Scanner;

public class UIService {

    private static Scanner scanner = new Scanner(System.in);

    public static Animal.Type getAnimalType() {
        while (true) {
            String cmd = scanner.nextLine();
            switch (cmd) {
                case "0":
                    System.out.println("1 - Волк");
                    System.out.println("2 - Тигр");
                    System.out.println("3 - Медведь");
                    System.out.println("4 - Пингвин");
                    System.out.println("5 - Кенгуру");
                    break;
                case "1":
                    return Animal.Type.WOLF;
                case "2":
                    return Animal.Type.TIGER;
                case "3":
                    return Animal.Type.BEAR;
                case "4":
                    return Animal.Type.PENGUIN;
                case "5":
                    return Animal.Type.KANGAROO;
                default:
                    System.out.println("ОШИБКА!");
            }
        }
    }

    public static Animal.FeedType getAnimalFeedType() {
        while (true) {
            String cmd = scanner.nextLine();
            switch (cmd) {
                case "0":
                    System.out.println("1 - Трава");
                    System.out.println("2 - Мясо");
                    break;
                case "1":
                    return Animal.FeedType.GRASS;
                case "2":
                    return Animal.FeedType.MEAT;
                default:
                    System.out.println("ОШИБКА!");
            }
        }
    }

    public static Animal.Habitat getAnimalHabitat() {
        while (true) {
            String cmd = scanner.nextLine();
            switch (cmd) {
                case "0":
                    System.out.println("1 - Евразия");
                    System.out.println("2 - Северная Америка");
                    System.out.println("3 - Южная Америка");
                    System.out.println("4 - Африка");
                    System.out.println("5 - Австралия");
                    System.out.println("6 - Антарктида");
                    break;
                case "1":
                    return Animal.Habitat.EURASIA;
                case "2":
                    return Animal.Habitat.NORTH_AMERICA;
                case "3":
                    return Animal.Habitat.SOUTH_AMERICA;
                case "4":
                    return Animal.Habitat.AFRICA;
                case "5":
                    return Animal.Habitat.AUSTRALIA;
                case "6":
                    return Animal.Habitat.ANTARCTICA;
                default:
                    System.out.println("ОШИБКА!");
            }
        }
    }

    public static Animal.Color getAnimalColor() {
        while (true) {
            String cmd = scanner.nextLine();
            switch (cmd) {
                case "0":
                    System.out.println("1 - Черный");
                    System.out.println("2 - Серый");
                    System.out.println("3 - Желтый");
                    System.out.println("4 - Белый");
                    break;
                case "1":
                    return Animal.Color.BLACK;
                case "2":
                    return Animal.Color.GRAY;
                case "3":
                    return Animal.Color.YELLOW;
                case "4":
                    return Animal.Color.WHITE;
                default:
                    System.out.println("ОШИБКА!");
            }
        }
    }

    public static String getAnimalName() {
        while (true) {
            String name = scanner.nextLine();
            if (name.length() >= 2) return name;
            else System.out.println("ОШИБКА!");
        }
    }

    public static int getAnimalPawNumber() {
        while (true) {
            int pawNumber = 0;
            try {
                pawNumber = Integer.parseInt(scanner.nextLine());
                if (pawNumber >= 2 && pawNumber <= 100) return pawNumber;
                else System.out.println("ОШИБКА!");
            } catch (NumberFormatException e) {
                e.printStackTrace();
                System.out.println("ОШИБКА!");
            }
        }
    }

    public static Animal.Property getProperty() {
        while (true) {
            String cmd = scanner.nextLine();
            switch (cmd) {
                case "0":
                    System.out.println("1 - Тип");
                    System.out.println("2 - Тип корма");
                    System.out.println("3 - Цвет");
                    System.out.println("4 - Ареал обитания");
                    break;
                case "1":
                    return Animal.Property.TYPE;
                case "2":
                    return Animal.Property.FEED_TYPE;
                case "3":
                    return Animal.Property.COLOR;
                case "4":
                    return Animal.Property.HABITAT;
                default:
                    System.out.println("ОШИБКА!");
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {

        ZooService service = new ZooService();

        while (true) {
            System.out.println("Введите команду от 1 до 5 (Получить список команд - 0)");
            String str = System.console().readLine();
            switch (str) {
                case "0":
                    System.out.println("1 - Получить список всех животных");
                    System.out.println("2 - Получить список животных по типу");
                    System.out.println("3 - Получить любое животное по типу");
                    System.out.println("4 - Удалить животное");
                    System.out.println("5 - Обновить имя животного");
                    break;
                case "1":
                    ////////////////System.out.println(service.getAll());
                    break;
                case "2":
                    System.out.println("УСПЕХ!!!");
                    break;
                default:
                    System.out.println("ОШИБКА! Нет такой команды.");
            }
        }
    }
}
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Database database = new Database();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите операцию:");
            System.out.println("1. Вставить запись");
            System.out.println("2. Обновить запись");
            System.out.println("3. Переместить запись");
            System.out.println("4. Удалить запись");
            System.out.println("5. Вывести все записи");
            System.out.println("6. Выйти");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.println("Введите данные:");
                    String data = scanner.nextLine();
                    database.insertRecord(data);
                }
                case 2 -> {
                    System.out.println("Введите ID записи для обновления:");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Введите новые данные:");
                    String newData = scanner.nextLine();
                    database.updateRecord(id, newData);
                }
                case 3 -> {
                    System.out.println("Введите индекс исходной записи:");
                    int sourceIndex = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Введите индекс целевой позиции:");
                    int destinationIndex = scanner.nextInt();
                    database.moveRecord(sourceIndex, destinationIndex);
                }
                case 4 -> {
                    System.out.println("Введите ID записи для удаления:");
                    int deleteId = scanner.nextInt();
                    database.deleteRecord(deleteId);
                }
                case 5 -> {
                    List<Record> records = database.getRecords();
                    for (Record record : records) {
                        System.out.println("ID: " + record.getId() + ", Data: " + record.getData());
                    }
                }
                case 6 -> System.exit(0);
                default -> System.out.println("Некорректный выбор операции. Попробуйте ещё раз.");
            }
        }
    }
}
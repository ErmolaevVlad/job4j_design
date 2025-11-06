package ru.job4j.cache.menu;

import ru.job4j.cache.DirFileCache;

import java.util.Scanner;

public class Emulator {

    private static DirFileCache cache;
    public static final String MENU = """
                Введите 1. Указать кэшируемую директорию
                Введите 2. Загрузить содержимое файла в кэш
                Введите 3. Получить содержимое файла из кэша
                Введите 4. Выход
                Выберите опцию:
            """;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        start(scanner);
    }

    private static void start(Scanner scanner) {
        boolean running = true;
        while (running) {
            System.out.println(MENU);
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Введите путь к кэшируемой директории: ");
                    String dir = scanner.nextLine();
                    cache = new DirFileCache(dir);
                    break;
                case 2:
                    System.out.print("Введите имя файла для загрузки в кэш: ");
                    String fileToLoad = scanner.nextLine();
                    if (cache != null) {
                        cache.get(fileToLoad);
                        System.out.println("Файл загружен в кэш.");
                    } else {
                        System.out.println("Сначала укажите кэшируемую директорию.");
                    }
                    break;
                case 3:
                    System.out.print("Введите имя файла для получения из кэша: ");
                    String fileToGet = scanner.nextLine();
                    if (cache != null) {
                        String content = cache.get(fileToGet);
                        System.out.println("Содержимое файла: " + content);
                    } else {
                        System.out.println("Сначала укажите кэшируемую директорию.");
                    }
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор, попробуйте снова.");
            }
        }
    }
}
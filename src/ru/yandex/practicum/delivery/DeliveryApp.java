package ru.yandex.practicum.delivery;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static List<Parcel> allParcels = new ArrayList<>();
    private static List<Trackable> trackableParcels = new ArrayList<>();
    private static ParcelBox<StandardParcel> standardParcelBox = new ParcelBox<>(5000);
    private static ParcelBox<FragileParcel> fragileParcelBox = new ParcelBox<>(5000);
    private static ParcelBox<PerishableParcel> perishableParcelBox = new ParcelBox<>(5000);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addParcel();
                    break;
                case 2:
                    sendParcels();
                    break;
                case 3:
                    calculateCosts();
                    break;
                case 4:
                    updateTrackableStatus();
                    break;
                case 5:
                    System.out.println("Стандартные посылки: ");
                    standardParcelBox.getAllParcels();
                    System.out.println("Хрупкие посылки: ");
                    fragileParcelBox.getAllParcels();
                    System.out.println("Скоропортящиеся посылки: ");
                    perishableParcelBox.getAllParcels();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 — Добавить посылку");
        System.out.println("2 — Отправить все посылки");
        System.out.println("3 — Посчитать стоимость доставки");
        System.out.println("4 — Обновить статус трекинговых посылок");
        System.out.println("5 — Показать содержимое коробки");
        System.out.println("0 — Завершить");
    }

    private static void addParcel() {
        System.out.println("Введите тип посылки: 1 - Стандартная посылка; 2 - Хрупкая посылка;" +
                " 3 - Скоропортящаяся посылка");
        int type = scanner.nextInt();
        System.out.println("Введите описание посылки: ");
        String description = scanner.next();
        System.out.println("Введите вес посылки: ");
        int weight = scanner.nextInt();
        System.out.println("Введите адрес доставки: ");
        String deliveryAddress = scanner.next();
        System.out.println("Введите день отправки: ");
        int sendDay = scanner.nextInt();
        scanner.nextLine();
        if (type == 1) {
            StandardParcel parcel = new StandardParcel(description, weight, deliveryAddress, sendDay);
            allParcels.add(parcel);
            standardParcelBox.addParcel(parcel);
        } else if (type == 2) {
            FragileParcel parcel = new FragileParcel(description, weight, deliveryAddress, sendDay);
            allParcels.add(parcel);
            trackableParcels.add(parcel);
            fragileParcelBox.addParcel(parcel);
        } else if (type == 3) {
            System.out.println("Введите время хранения посылки: ");
            int timeToLive = scanner.nextInt();
            scanner.nextLine();
            PerishableParcel parcel = new PerishableParcel(description, weight, deliveryAddress, sendDay, timeToLive);
            allParcels.add(parcel);
            perishableParcelBox.addParcel(parcel);
        } else {
            System.out.println("Такого типа посылок не существует!");
        }
    }

    private static void sendParcels() {
        for (Parcel parcel : allParcels) {
            parcel.packageItem();
            parcel.deliver();
        }
    }

    private static void calculateCosts() {
        int allCosts = 0;
        for (Parcel parcel : allParcels) {
            allCosts += parcel.calculateDeliveryCost();
        }
        System.out.println("Стоимость всех доставок: " + allCosts);
    }

    private static void updateTrackableStatus() {
        System.out.println("Введите новое местоположение:");
        String newLocation = scanner.nextLine();
        for (Trackable parcel : trackableParcels) {
            parcel.reportStatus(newLocation);
        }
    }
}

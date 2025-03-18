package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Grocery {
    public static ArrayList<String> groceryList = new ArrayList<>();

    public static void startGrocery() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n Menü: \n0: Çıkış \n1: Eleman Ekleme \n2: Eleman Çıkarma \nLütfen seçiminizi yapın (0, 1 veya 2): ");

            String input = scanner.nextLine();
            int choice;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Geçersiz giriş. Tekrar deneyin.");
                continue;
            }

            if (choice == 0) {
                System.out.println("Uygulamadan çıkılıyor...");
                break;
            } else if (choice == 1) {
                System.out.print("Eklemek istediğiniz elemanları giriniz (virgülle ayırabilirsiniz): ");
                String itemsInput = scanner.nextLine();
                addItems(itemsInput);
            } else if (choice == 2) {
                System.out.print("Çıkarmak istediğiniz elemanları giriniz (virgülle ayırabilirsiniz): ");
                String itemsInput = scanner.nextLine();
                removeItems(itemsInput);
            } else {
                System.out.println("Yanlış seçim! Lütfen 0, 1 veya 2 giriniz.");
            }
            printSorted();
        }
        scanner.close();
    }

    public static void addItems(String input) {
        String[] items = input.split(",");
        for (String item : items) {
            String trimmedItem = item.trim();
            if (!trimmedItem.isEmpty() && !checkItemIsInList(trimmedItem)) {
                groceryList.add(trimmedItem);
            }
        }
        Collections.sort(groceryList);
    }

    public static void removeItems(String input) {
        String[] items = input.split(",");
        for (String item : items) {
            String trimmedItem = item.trim();
            if (!trimmedItem.isEmpty() && checkItemIsInList(trimmedItem)) {
                groceryList.remove(trimmedItem);
            }
        }
        Collections.sort(groceryList);
    }

    public static boolean checkItemIsInList(String product) {
        return groceryList.contains(product);
    }

    public static void printSorted() {
        Collections.sort(groceryList);
        System.out.println("Grocery List: " + groceryList);
    }
}

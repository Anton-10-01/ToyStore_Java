package ToyStore_Java;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
    public void app() {
        ToyStore store = new ToyStore();
        boolean run = true;
        Scanner iScanner = new Scanner(System.in);
        while (run) {
            System.out.println("1. Добавить игрушку! ");
            System.out.println("2. Розыгрышь игрушки!");
            System.out.println("3. Изменить частоту выпадения игрушки!");
            System.out.println("4. Выход");
            String userChoice = iScanner.nextLine();
            switch (userChoice) {
                case "1":
                    System.out.println("Введи id игрушки");
                    int idToy = iScanner.nextInt();
                    iScanner.nextLine();
                    System.out.println("Введи имя грушки");
                    String nameToy = iScanner.nextLine();
                    System.out.println("Введи кол-во игрушек");
                    int quantityToys = iScanner.nextInt();
                    iScanner.nextLine();
                    System.out.println("Введи частоту выпадения игрушки");
                    String weight = iScanner.nextLine();
                    double weightToy = Double.parseDouble(weight);
                    store.addToy(idToy, nameToy, quantityToys, weightToy);
                    break;
                case "2":
                    store.play();
                    try {
                        store.getPrizeToy();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case "3":
                    System.out.println("Введи id игрушки");
                    int id = iScanner.nextInt();
                    iScanner.nextLine();
                    System.out.println("Введи частоту выпадения игрушки");
                    String toyWeight = iScanner.nextLine();
                    double toyWeight1 = Double.parseDouble(toyWeight);
                    store.setToyWeight(id, toyWeight1);
                    break;
                case "4":
                    run = false;
                    break;
                default:
                    System.out.println("Error!");
                    break;
            }
        }
        iScanner.close();
    }
}

import java.util.ArrayList;
import java.util.Scanner;

public class HitShop {

    static ArrayList<String> names = new ArrayList<>();
    static ArrayList<Double> prices = new ArrayList<>();
    static ArrayList<Integer> quantities = new ArrayList<>();

    public static void addItem(String name, double price, int quantity) {
        if (name.trim().isEmpty() || price <= 0 || quantity <= 0) {
            System.out.println("Invalid Data.");
            return;
        }

        names.add(name);
        prices.add(price);
        quantities.add(quantity);
        System.out.println("Add successful!");
    }

    public static void removeItem(int index) {
        if (index < 0 || index >= names.size()) {
            System.out.println("Not found item.");
            return;
        }

        names.remove(index);
        prices.remove(index);
        quantities.remove(index);
        System.out.println("Delete successful!");
    }

    public static void printItems() {
        if (names.isEmpty()) {
            System.out.println("Empty cart.");
            return;
        }

        for (int i = 0; i < names.size(); i++) {
            System.out.printf("%d. %s | %.0f VND | SL: %d%n",
                    i + 1, names.get(i), prices.get(i), quantities.get(i));
        }
    }

    public static double calculateTotal() {
        double total = 0;

        for (int i = 0; i < names.size(); i++)
            total += prices.get(i) * quantities.get(i);

        return total;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== HIT SHOP =====");
            System.out.println("1. Add product");
            System.out.println("2. Delete product");
            System.out.println("3. Show product");
            System.out.println("4. Total price");
            System.out.println("0. Exit");
            System.out.print("Choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: {
                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    System.out.print("Price: ");
                    double price = sc.nextDouble();

                    System.out.print("Quantity: ");
                    int quantity = sc.nextInt();

                    addItem(name, price, quantity);
                    break;
                }

                case 2:
                    printItems();
                    System.out.print("Enter order to delete: ");
                    removeItem(sc.nextInt() - 1);
                    break;

                case 3:
                    printItems();
                    break;

                case 4:
                    System.out.printf("Total price: %.0f VND%n", calculateTotal());
                    break;

                case 0:
                    System.out.println("Thank you for using HIT SHOP!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);

        sc.close();
    }
}

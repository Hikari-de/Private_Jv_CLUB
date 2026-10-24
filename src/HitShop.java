
import java.util.Scanner;

public class HitShop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final double SHIPPING_FEE = 20000;
        final double VAT_RATE = 0.10;
        System.out.print("Product Name: ");
        String productName = sc.nextLine();

        if (productName.trim().isEmpty()) {
            System.out.println("Error");
            sc.close();
            return;
        }

        System.out.print("Input Cost: ");
        double unitPrice = sc.nextDouble();

        if (unitPrice < 0) {
            System.out.println("Error");
            sc.close();
            return;
        }

        System.out.print("Quantity: ");
        int quantity = sc.nextInt();

        if (quantity < 0) {
            System.out.println("Error");
            sc.close();
            return;
        }

        double total = (unitPrice * quantity) + (unitPrice * quantity * VAT_RATE) + SHIPPING_FEE;

        System.out.println("\n--- Information Bill ---");
        System.out.println("Product Name: " + productName);
        System.out.println("Unit Price: " + unitPrice);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total: " + total);

        sc.close();
    }
}

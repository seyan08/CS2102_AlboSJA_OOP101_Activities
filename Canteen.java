import java.util.Scanner;

public class Canteen {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.println("===  M E N U ===");
    System.out.println("1. Burger       - $80.00");
    System.out.println("2. Pizza        - $120.00");
    System.out.println("3. Pasta        - $100.00");
    System.out.println("4. Sandwich     - $70.00");
    System.out.println("5. Milk Tea     - $90.00");
    
    double burger = 80;
    double pizza = 120;
    double pasta = 100;
    double sandwich = 70;
    double milktea = 90;

    int totalQuantity = 0;
    double totalDiscount = 0;
    double totalAmount = 0;
    double subtotal = 0;

    char orderAgain; 

    do {
      System.out.print("\nEnter item number: ");
      int choice = input.nextInt();
      System.out.print("Enter quantity: ");
      int quantity = input.nextInt();

      if (choice < 1 || choice > 5 || quantity < 1 || quantity > 10) {
          System.out.println("\nInvalid order! Please enter a valid item and quantity."); 
          
          do {
            System.out.print("\nDo you want to order again? (Y/N): ");
            orderAgain = Character.toUpperCase(input.next().charAt(0));

            if (orderAgain != 'Y' && orderAgain != 'N') {
              System.out.println("Invalid input! Please enter Y or N.");
            }

          } while (orderAgain != 'Y' && orderAgain != 'N');

          continue;
        }
      System.out.print("Are you a student? (Y/N): ");
      char studentYN = Character.toUpperCase(input.next().charAt(0));

      if (studentYN != 'Y' && studentYN != 'N') {
        System.out.println("Invalid input! Please enter Y or N.");
      
        do {
          System.out.print("\nDo you want to order again? (Y/N): ");
          orderAgain = Character.toUpperCase(input.next().charAt(0));

          if (orderAgain != 'Y' && orderAgain != 'N') {
            System.out.println("Invalid input! Please enter Y or N.");
          }

        } while (orderAgain != 'Y' && orderAgain != 'N');

        continue;
      }
      
      double price = 0;

      if (choice == 1) {
        price = burger;
      }

      else if (choice == 2) {
        price = pizza;
      }

      else if (choice == 3) {
        price = pasta;
      }

      else if (choice == 4) {
        price = sandwich;
      }

      else if (choice == 5) {
        price = milktea;
      }

      subtotal = price * quantity;

      double discount = 0;

      if (studentYN == 'Y' && subtotal >= 500) {
        discount = subtotal * 0.15;
      }

      else if (studentYN == 'Y') {
        discount = subtotal * 0.1;
      }

      else if (studentYN == 'N' && subtotal >= 500) {
        discount = subtotal * 0.05;
      }

      double orderTotal = subtotal - discount;

      totalQuantity += quantity;
      totalAmount += subtotal;
      totalDiscount += discount;

      System.out.printf("\nSubtotal: $%.2f%n", subtotal);
      System.out.printf("Discount: $%.2f%n", discount);
      System.out.printf("Order Total: $%.2f%n", orderTotal);

      do {
        System.out.print("\nDo you want to order again? (Y/N): ");
        orderAgain = Character.toUpperCase(input.next().charAt(0));

        if (orderAgain != 'Y' && orderAgain != 'N') {
          System.out.println("Invalid input! Please enter Y or N.");
        }

      } while (orderAgain != 'Y' && orderAgain != 'N');


    } while (orderAgain == 'Y');
    
      double finalAmount = totalAmount - totalDiscount;

      System.out.println("\n==== ORDER SUMMARY ====");
      System.out.println("Total items: " + totalQuantity);
      System.out.printf("Total before discount: $%.2f%n", totalAmount);
      System.out.printf("Total discount: $%.2f%n", totalDiscount);
      System.out.printf("Final Amount: $%.2f%n", finalAmount);
      System.out.println("Thank you for ordering!");

      input.close();
  }
}
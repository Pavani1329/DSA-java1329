import java.util.*;

class MenuItem {
    int id;
    String name;
    double price;

    MenuItem(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}

class Order {
    int tableNumber;
    List<MenuItem> items = new ArrayList<>();
    double total = 0.0;
    String feedback = "";
    boolean isPaid = false;
    String cardNumber = "";

    void addItem(MenuItem item) {
        items.add(item);
        total += item.price;
    }

    void printBill() {
        System.out.println("\n--- Bill for Table: " + tableNumber + " ---");
        for (MenuItem item : items) {
            System.out.println("- " + item.name + ": ₹" + item.price);
        }
        System.out.println("Total Bill: ₹" + total);
        System.out.println("Payment Status: " + (isPaid ? "Paid" : "Unpaid"));
        if (isPaid && !cardNumber.isEmpty()) {
            System.out.println("Paid using Card: **** **** **** " + cardNumber);
        }
        if (!feedback.isEmpty()) {
            System.out.println("Customer Feedback: " + feedback);
        }
    }
}

public class RestaurantManagementSystem {
    static Scanner sc = new Scanner(System.in);
    static List<MenuItem> menu = new ArrayList<>();
    static List<Integer> reservedTables = new ArrayList<>();
    static List<Order> orderHistory = new ArrayList<>();
    static int tableCapacity = 10;

    public static void main(String[] args) {
        initializeMenu();
        boolean runApp = true;

        while (runApp) {
            System.out.println("\n--- Welcome to Tech Titans Restaurant System ---");
            System.out.println("1. View Menu");
            System.out.println("2. Place Order");
            System.out.println("3. Reserve Table");
            System.out.println("4. Admin Panel");
            System.out.println("5. Pay Bill");
            System.out.println("6. Exit");
            System.out.print("Select Option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> displayMenu();
                case 2 -> placeOrder();
                case 3 -> reserveTable();
                case 4 -> adminPanel();
                case 5 -> payBill();
                case 6 -> {
                    List<Order> unpaidOrders = orderHistory.stream()
                            .filter(o -> !o.isPaid)
                            .toList();
                    if (!unpaidOrders.isEmpty()) {
                        System.out.println("\nYou have unpaid bills. Please pay before exiting.");
                        for (Order order : unpaidOrders) {
                            System.out.println("Table " + order.tableNumber + " has an unpaid bill of ₹" + order.total);
                        }
                    } else {
                        runApp = false;
                        System.out.println("Thank you and Visit Again.");
                    }
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    static void initializeMenu() {
        menu.add(new MenuItem(1, "Masala Dosa", 50));
        menu.add(new MenuItem(2, "Chilly Chicken", 150));
        menu.add(new MenuItem(3, "Chicken Biryani", 180));
        menu.add(new MenuItem(4, "Gobi Rice", 100));
        menu.add(new MenuItem(5, "Gulab Jamun", 40));
    }

    static void displayMenu() {
        System.out.println("\n--- Menu ---");
        for (MenuItem item : menu) {
            System.out.println(item.id + ". " + item.name + " - ₹" + item.price);
        }
    }

    static void placeOrder() {
        displayMenu();
        Order order = new Order();
        System.out.print("Enter Table Number (1-10): ");
        order.tableNumber = sc.nextInt();
        if (order.tableNumber < 1 || order.tableNumber > tableCapacity) {
            System.out.println("Invalid table number.");
            return;
        }

        boolean ordering = true;
        while (ordering) {
            System.out.print("Enter item number to add (0 to finish): ");
            int itemId = sc.nextInt();
            if (itemId == 0) {
                ordering = false;
            } else {
                MenuItem item = binarySearchMenu(itemId);
                if (item != null) {
                    order.addItem(item);
                    System.out.println(item.name + " added.");
                } else {
                    System.out.println("Item not found.");
                }
            }
        }

        sc.nextLine(); // clear buffer
        System.out.print("Would you like to give feedback? (Y/N): ");
        String feedbackChoice = sc.nextLine();
        if (feedbackChoice.equalsIgnoreCase("Y")) {
            System.out.print("Enter your feedback: ");
            order.feedback = sc.nextLine();
            System.out.println("Thank you for your feedback!");
        }

        order.printBill();

        // Immediate payment after order
        System.out.print("Proceed to payment? (Y/N): ");
        String confirm = sc.nextLine();
        if (confirm.equalsIgnoreCase("Y")) {
            System.out.print("Enter 4-digit Card Number: ");
            String card = sc.nextLine();
            if (card.length() == 4 && card.matches("\\d+")) {
                order.isPaid = true;
                order.cardNumber = card;
                System.out.println("Payment successful! Thank you.");
            } else {
                System.out.println("Invalid card number. Payment failed. You can pay later from main menu.");
            }
        } else {
            System.out.println("You can pay later using the 'Pay Bill' option in the main menu.");
        }

        orderHistory.add(order);
    }

    static MenuItem binarySearchMenu(int id) {
        int left = 0, right = menu.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (menu.get(mid).id == id) {
                return menu.get(mid);
            } else if (menu.get(mid).id < id) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    static void reserveTable() {
        System.out.print("Enter table number to reserve (1-10): ");
        int tableNo = sc.nextInt();
        if (tableNo < 1 || tableNo > tableCapacity) {
            System.out.println("Invalid table number.");
        } else if (reservedTables.contains(tableNo)) {
            System.out.println("Table already reserved.");
        } else {
            reservedTables.add(tableNo);
            System.out.println("Table " + tableNo + " reserved successfully.");
        }
    }

    static void adminPanel() {
        System.out.print("Enter Admin Password: ");
        String password = sc.next();
        if (!password.equals("admin123")) {
            System.out.println("Access Denied!");
            return;
        }

        System.out.println("\n--- Admin Panel ---");
        System.out.println("1. View Orders");
        System.out.println("2. View Reserved Tables");
        System.out.println("3. View Total Sales");
        System.out.println("4. View Feedback");
        System.out.print("Choose an option: ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1 -> {
                for (Order order : orderHistory) {
                    order.printBill();
                    System.out.println("---");
                }
            }
            case 2 -> System.out.println("Reserved Tables: " + reservedTables);
            case 3 -> {
                double totalSales = orderHistory.stream()
                        .filter(o -> o.isPaid)
                        .mapToDouble(o -> o.total)
                        .sum();
                System.out.println("Total Sales (Paid Only): ₹" + totalSales);
            }
            case 4 -> {
                System.out.println("\n--- Customer Feedback ---");
                for (Order order : orderHistory) {
                    if (!order.feedback.isEmpty()) {
                        System.out.println("Table " + order.tableNumber + ": " + order.feedback);
                    }
                }
            }
            default -> System.out.println("Invalid Option.");
        }
    }

    static void payBill() {
        System.out.print("Enter your Table Number to pay the bill: ");
        int tableNo = sc.nextInt();
        boolean found = false;

        for (Order order : orderHistory) {
            if (order.tableNumber == tableNo && !order.isPaid) {
                found = true;
                order.printBill();
                sc.nextLine(); // Clear newline
                System.out.print("Confirm payment? (Y/N): ");
                String confirm = sc.nextLine();

                if (confirm.equalsIgnoreCase("Y")) {
                    System.out.print("Enter 4-digit Card Number: ");
                    String card = sc.nextLine();
                    if (card.length() == 4 && card.matches("\\d+")) {
                        order.isPaid = true;
                        order.cardNumber = card;
                        System.out.println("Payment successful! Thank you.");
                    } else {
                        System.out.println("Invalid card number. Payment cancelled.");
                    }
                } else {
                    System.out.println("Payment cancelled.");
                }
                break;
            }
        }
    }
}
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
class Contact {
    private String name;
    private String phoneNumber;

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Phone: " + phoneNumber;
    }
}
class Main {
    private static Map<String, Contact> phoneBook = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("\n📞 Phone Book Menu");
            System.out.println("1. Add Contact");
            System.out.println("2. View All Contacts");
            System.out.println("3. Search Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            switch (scanner.nextLine()) {
                case "1":
                    addContact();
                    break;
                case "2":
                    viewContacts();
                    break;
                case "3":
                    searchContact();
                    break;
                case "4":
                    deleteContact();
                    break;
                case "5":
                    running = false;
                    System.out.println("Exiting Phone Book. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void addContact() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine().trim();
        System.out.print("Enter phone number: ");
        String phone = scanner.nextLine().trim();
        phoneBook.put(name.toLowerCase(), new Contact(name, phone));
        System.out.println("Contact added successfully!");
    }

    private static void viewContacts() {
        if (phoneBook.isEmpty()) {
            System.out.println("Phone book is empty.");
            return;
        }
        System.out.println("📋 All Contacts:");
        for (Contact contact : phoneBook.values()) {
            System.out.println(contact);
        }
    }

    private static void searchContact() {
        System.out.print("Enter name to search: ");
        String name = scanner.nextLine().trim().toLowerCase();
        Contact contact = phoneBook.get(name);
        if (contact != null) {
            System.out.println("🔍 Found: " + contact);
        } else {
            System.out.println("Contact not found.");
        }
    }

    private static void deleteContact() {
        System.out.print("Enter name to delete: ");
        String name = scanner.nextLine().trim().toLowerCase();
        if (phoneBook.remove(name) != null) {
            System.out.println("Contact deleted.");
        } else {
            System.out.println("Contact not found.");
        }
    }
}
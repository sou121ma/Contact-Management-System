package main;

import service.ContactService;
import java.util.Scanner;

public class ContactManagementSystem {
    public static void main(String[] args) {

        ContactService contactService = new ContactService();
        Scanner scanner = new Scanner(System.in);

        int choice;

        do {
            System.out.println("\nContact Management System");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Search Contact");
            System.out.println("4. Update Contact");
            System.out.println("5. Delete Contact");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            
            while (!scanner.hasNextInt()) {
                System.out.print("Wrong input! Please enter valid choice: ");
                scanner.nextLine(); // ignored new line character (consume new line)
            }            
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Phone Number: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();

                    contactService.addContact(name, phoneNumber, email);
                    break;
                case 2:
                    contactService.viewContacts();
                    break;
                case 3:
                    System.out.print("Enter Name to search: ");
                    String searchName = scanner.nextLine();
                    contactService.searchContact(searchName);
                    break;
                case 4:
                    System.out.print("Enter Name of the contact to update: ");
                    String updateName = scanner.nextLine();
                    System.out.print("Enter new Phone Number: ");
                    String newPhoneNumber = scanner.nextLine();
                    System.out.print("Enter new Email: ");
                    String newEmail = scanner.nextLine();
                    contactService.updateContact(updateName, newPhoneNumber, newEmail);
                    break;
                case 5:
                    System.out.print("Enter Name of the contact to delete: ");
                    String deleteName = scanner.nextLine();
                    contactService.deleteContact(deleteName);
                    break;
                case 6:
                    System.out.println("Exiting Contact Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);

        scanner.close();
    }
}

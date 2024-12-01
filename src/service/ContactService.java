package service;

import java.util.Map;
import java.util.TreeMap;

import model.Contact;

public class ContactService {

    private TreeMap<String, Contact> contactMap = new TreeMap<>(); // TreeMap to store contacts

    // Method to add a new contact
    public void addContact(String name, String phoneNumber, String email) {
        if (contactMap.containsKey(name)) {
            System.out.println("Contact with this name already exists.");
            return;
        }
        Contact newContact = new Contact(name, phoneNumber, email);
        contactMap.put(name, newContact); // Store the contact with the name as the key
        System.out.println("Contact added successfully!");
    }

    // Method to display all contacts
    public void viewContacts() {
        if (contactMap.isEmpty()) {
            System.out.println("No contacts found.");
        } else {
            System.out.println("\nContact List:");
            // Traversing in map
            for (Map.Entry<String, Contact> entry : contactMap.entrySet()) {
                System.out.println(entry.getValue());
            }
        }
    }

    // Method to search for a contact by name
    public void searchContact(String name) {
        Contact contact = contactMap.get(name);
        if (contact != null) {
            System.out.println("Contact Found: " + contact);
        } else {
            System.out.println("Contact not found.");
        }
    }

    // Method to update an existing contact
    public void updateContact(String name, String newPhoneNumber, String newEmail) {
        Contact contact = contactMap.get(name);
        if (contact != null) {
            contact.setPhoneNumber(newPhoneNumber);
            contact.setEmail(newEmail);
            System.out.println("Contact updated successfully!");
        } else {
            System.out.println("Contact not found.");
        }
    }

    // Method to delete a contact by name
    public void deleteContact(String name) {
        if (contactMap.remove(name) != null) {
            System.out.println("Contact deleted successfully!");
        } else {
            System.out.println("Contact not found.");
        }
    }
}

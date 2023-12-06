import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Manager {
    private phonebook_node head;

    public Manager() {
        head = null;
    }

    // Adding contact
    public void addEntry(String firstName, String lastName,
                         String address, String phoneNumber, String city) {
        phonebook_node newNode = new phonebook_node();
        newNode.setFirstName(firstName);
        newNode.setLastName(lastName);
        newNode.setAddress(address);
        newNode.setPhoneNumber(phoneNumber);
        newNode.setCity(city);

        if (head == null) {
            head = newNode;
        } else {
            phonebook_node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Sorting name by last name alphabetical order
    public void sortByName() {
        List<phonebook_node> phonebookList = new LinkedList<>();
        phonebook_node current = head;

        while (current != null) {
            phonebookList.add(current);
            current = current.next;
        }
        // Compare entries by last name
        Collections.sort(phonebookList, new Comparator<phonebook_node>() {
            @Override
            public int compare(phonebook_node o1, phonebook_node o2) {
                int lastNameComparison = o1.getLastName().compareTo(o2.getLastName());
                if (lastNameComparison != 0) {
                    return lastNameComparison;
                }
                return o1.getFirstName().compareTo(o2.getFirstName());
            }
        });

        phonebook_node sortedHead = phonebookList.get(0);
        current = sortedHead;
        for (int i = 1; i < phonebookList.size(); i++) {
            current.next = phonebookList.get(i);
            current = current.next;
        }
        current.next = null;

        head = sortedHead;
    }

    // Change contact information
    public void modifyEntry(String oldFirstName, String oldLastName, String newFirstName,
                            String newLastName, String newAddress, String newPhoneNumber, String newCity) {
        phonebook_node current = head;
        while (current != null) {
            if (current.getFirstName().equals(oldFirstName) && current.getLastName().equals(oldLastName)) {
                current.setFirstName(newFirstName);
                current.setLastName(newLastName);
                current.setAddress(newAddress);
                current.setPhoneNumber(newPhoneNumber);
                current.setCity(newCity);
                break;
            }
            current = current.next;
        }
    }

    // Delete the contact
    public void deleteEntry(String firstName, String lastName) {
        if (head == null) {
            return;
        }

        if (head.getFirstName().equals(firstName) && head.getLastName().equals(lastName)) {
            head = head.next;
            return;
        }

        phonebook_node current = head;
        while (current.next != null) {
            if (current.next.getFirstName().equals(firstName) && current.next.getLastName().equals(lastName)) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    // Change contact's city
    public void moveEntryToCity(String firstName, String lastName, String newCity) {
        phonebook_node current = head;
        while (current != null) {
            if (current.getFirstName().equals(firstName) && current.getLastName().equals(lastName)) {
                current.setCity(newCity);
                break;
            }
            current = current.next;
        }
    }

    // Display the phonebook
    public void displayPhonebook() {
        phonebook_node current = head;
        while (current != null) {
            System.out.println("First Name: " + current.getFirstName());
            System.out.println("Last Name: " + current.getLastName());
            System.out.println("Address: " + current.getAddress());
            System.out.println("Phone Number: " + current.getPhoneNumber());
            System.out.println("City: " + current.getCity());
            System.out.println();
            current = current.next;
        }
    }
}

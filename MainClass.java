import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        Manager phonebook = new Manager();
        Scanner scanner = new Scanner(System.in);

        // Menu
        boolean exit = false;
        while (!exit) {
            System.out.println("\nPhonebook Menu:");
            System.out.println("1. Add Entry");
            System.out.println("2. Sort by Last Name");
            System.out.println("3. Modify Entry");
            System.out.println("4. Delete Entry");
            System.out.println("5. Move Entry to a Different City");
            System.out.println("6. Display Phonebook");
            System.out.println("7. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter First Name: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Enter Last Name: ");
                    String lastName = scanner.nextLine();
                    System.out.print("Enter Address: ");
                    String address = scanner.nextLine();
                    System.out.print("Enter Phone Number: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Enter City: ");
                    String city = scanner.nextLine();
                    phonebook.addEntry(firstName, lastName, address, phoneNumber, city);
                    break;

                case 2:
                    phonebook.sortByName();
                    break;

                case 3:
                    System.out.print("Enter Old First Name: ");
                    String oldFirstName = scanner.nextLine();
                    System.out.print("Enter Old Last Name: ");
                    String oldLastName = scanner.nextLine();
                    System.out.print("Enter New First Name: ");
                    String newFirstName = scanner.nextLine();
                    System.out.print("Enter New Last Name: ");
                    String newLastName = scanner.nextLine();
                    System.out.print("Enter New Address: ");
                    String newAddress = scanner.nextLine();
                    System.out.print("Enter New Phone Number: ");
                    String newPhoneNumber = scanner.nextLine();
                    System.out.print("Enter New City: ");
                    String newCity = scanner.nextLine();
                    phonebook.modifyEntry(oldFirstName, oldLastName, newFirstName, newLastName, newAddress, newPhoneNumber, newCity);
                    break;

                case 4:
                    System.out.print("Enter First Name to Delete: ");
                    String deleteFirstName = scanner.nextLine();
                    System.out.print("Enter Last Name to Delete: ");
                    String deleteLastName = scanner.nextLine();
                    phonebook.deleteEntry(deleteFirstName, deleteLastName);
                    break;

                case 5:
                    System.out.print("Enter First Name to Move: ");
                    String moveFirstName = scanner.nextLine();
                    System.out.print("Enter Last Name to Move: ");
                    String moveLastName = scanner.nextLine();
                    System.out.print("Enter New City: ");
                    String moveCity = scanner.nextLine();
                    phonebook.moveEntryToCity(moveFirstName, moveLastName, moveCity);
                    break;

                case 6:
                    System.out.println("\nPhonebook Entries:");
                    phonebook.displayPhonebook();
                    break;

                case 7:
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid option. Please choose a valid menu item.");
            }
        }

        scanner.close();
    }
}

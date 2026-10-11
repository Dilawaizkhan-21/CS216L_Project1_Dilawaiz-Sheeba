package studentrecords;
import java.util.Scanner;
public class Main {
    static Scanner input = new Scanner(System.in);
    static StudentList list = new StudentList();
    static UndoStack undoStack = new UndoStack();
    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\nSTUDENT RECORD SYSTEM ");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Update Student GPA");
            System.out.println("6. Sort Students by GPA");
            System.out.println("7. Undo Last Delete/Update");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");
            choice = readInt();
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    list.displayAll();
                    break;
                case 3:
                    System.out.print("Enter student ID: ");
                    Student found = list.search(readInt());
                    if (found != null) {
                        found.display();
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter ID to delete: ");
                    Student deleted = list.delete(readInt());
                    if (deleted != null) {
                        undoStack.push(deleted, "DELETE");
                        System.out.println("Student deleted.");
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 5:
                    System.out.print("Enter student ID: ");
                    int id = readInt();
                    Student existing = list.search(id);
                    if (existing == null) {
                        System.out.println("Student not found.");
                        break;
                    }
                    System.out.print("Enter new GPA (0-4): ");
                    double newGpa = readDouble();
                    if (newGpa < 0 || newGpa > 4) {
                        System.out.println("GPA must be between 0 and 4.");
                        break;
                    }
                    Student oldStudent = new Student(
                        existing.id, existing.name, existing.gpa
                    );
                    if (list.updateGpa(id, newGpa)) {
                        undoStack.push(oldStudent, "UPDATE");
                        System.out.println("GPA updated.");
                    }
                    break;
                case 6:
                    list.sortByGpa();
                    System.out.println("Students sorted by GPA.");
                    list.displayAll();
                    break;
                case 7:
                    undoStack.popAndUndo(list);
                    break;
                case 8:
                    System.out.println("Program closed.");
                    break;
                default:
                    System.out.println("Invalid choice. Enter 1-8.");
            }
        } while (choice != 8);

        input.close();
    }
    static void addStudent() {
        System.out.print("Enter student ID: ");
        int id = readInt();
        if (id <= 0 || list.search(id) != null) {
            System.out.println("ID must be positive and unique.");
            return;
        }
        System.out.print("Enter student name: ");
        String name = input.nextLine().trim();
        if (name.isEmpty()) {
            System.out.println("Name cannot be empty.");
            return;
        }
        System.out.print("Enter GPA (0-4): ");
        double gpa = readDouble();
        if (gpa < 0 || gpa > 4) {
            System.out.println("GPA must be between 0 and 4.");
            return;
        }
        list.add(new Student(id, name, gpa));
        System.out.println("Student added successfully.");
    }
    static int readInt() {
        while (true) {
            String value = input.nextLine().trim();
            try {
                return Integer.parseInt(value);
            } catch (NumberFormatException e) {
                System.out.print("Enter a valid whole number: ");
            }
        }
    }
    static double readDouble() {
        while (true) {
            String value = input.nextLine().trim();
            try {
                double number = Double.parseDouble(value);
                if (Double.isFinite(number)) {
                    return number;
                }
            } catch (NumberFormatException e) {
                // Invalid input
            }
            System.out.print("Enter a valid number: ");
        }
    }
}
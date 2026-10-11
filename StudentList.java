package studentrecords;
class Node {
    Student data;
    Node next;
    Node(Student data) {
        this.data = data;
        this.next = null;
    }
}
public class StudentList {
    Node head;
    public void add(Student student) {
        Node newNode = new Node(student);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }
    public Student search(int id) {
        Node current = head;
        while (current != null) {
            if (current.data.id == id) {
                return current.data;
            }
            current = current.next;
        }
        return null;
    }
    public Student delete(int id) {
        Node current = head;
        Node previous = null;
        while (current != null) {
            if (current.data.id == id) {
                if (previous == null) {
                    head = current.next;
                } else {
                    previous.next = current.next;
                }
                current.next = null;
                return current.data;
            }
            previous = current;
            current = current.next;
        }
        return null;
    }
    public boolean updateGpa(int id, double newGpa) {
        Student student = search(id);
        if (student == null) {
            return false;
        }
        student.gpa = newGpa;
        return true;
    }
    public void displayAll() {
        if (head == null) {
            System.out.println("No student records found.");
            return;
        }
        System.out.printf("%-10s %-20s %s%n", "ID", "Name", "GPA");
        Node current = head;
        while (current != null) {
            current.data.display();
            current = current.next;
        }
    }
    public void sortByGpa() {
        if (head == null || head.next == null) {
            return;
        }
        boolean swapped;
        do {
            swapped = false;
            Node current = head;
            while (current.next != null) {
                if (current.data.gpa > current.next.data.gpa) {
                    Student temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
    }
}
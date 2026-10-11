
package studentrecords;
public class Student {
    int id;
    String name;
    double gpa;

    public Student(int id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }
    public void display() {
        System.out.printf("%-10d %-20s %.2f%n", id, name, gpa);
    }
}
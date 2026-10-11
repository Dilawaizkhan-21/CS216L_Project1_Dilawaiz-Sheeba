package studentrecords;
public class UndoStack {
    private static class Action {
        Student student;
        String type;
        Action next;
        Action(Student student, String type, Action next) {
            this.student = student;
            this.type = type;
            this.next = next;
        }
    }
    private Action top;
    public void push(Student student, String type) {
        top = new Action(student, type, top);
    }
    public boolean isEmpty() {
        return top == null;
    }
    public void popAndUndo(StudentList list) {
        if (isEmpty()) {
            System.out.println("Nothing to undo.");
            return;
        }
        Action action = top;
        top = top.next;
        if (action.type.equals("DELETE")) {
            list.add(action.student);
            System.out.println("Deleted student restored.");
        } else if (action.type.equals("UPDATE")) {
            Student current = list.search(action.student.id);
            if (current != null) {
                current.gpa = action.student.gpa;
                System.out.println("Previous GPA restored.");
            } else {
                System.out.println("Student not found; undo failed.");
            }
        }
    }
}
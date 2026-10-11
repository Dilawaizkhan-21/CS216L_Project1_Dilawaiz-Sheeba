# Student Record Management System

**Course:** Data Structures Lab (CS-216L)
**Project:** Lab Assignment 1
**Language:** Java
**IDE:** Eclipse

## 1. Introduction

This project is about managing student records using Java. It allows users to add, display, search, delete, and update student records. Users can also sort students according to their GPA.

In this project, we used a linked list to store student records and a stack to undo the last delete or GPA update operation. This project helped us understand how data structures work in Java.

## 2. Objectives

The main objectives of this project are:

* To learn how a linked list works.
* To understand the stack and its LIFO principle.
* To search for students by ID.
* To sort students according to GPA.
* To practice Java programming.
* To learn about time complexity.

## 3. Data Structures

### Linked List

We used a singly linked list to store student records. Each node contains the student's ID, name, GPA, and a link to the next node.

### Stack

We used a stack to save information about the last delete or GPA update operation. It helps us undo the last supported operation.

## 4. Algorithms

**Linear Search:** We used linear search to find a student by ID. It checks the records one by one. Its time complexity is `O(n)`.

**Bubble Sort:** We used bubble sort to arrange students by GPA in ascending order. Its worst-case time complexity is `O(n²)`.

## 5. Features

* Add a student.
* Display all students.
* Search for a student by ID.
* Delete a student.
* Update student GPA.
* Sort students by GPA.
* Undo the last supported delete or GPA update.
* Exit the program.

## 6. Input Validation

We added basic input validation to handle incorrect input. The program checks menu choices, student IDs, student names, and GPA values. GPA must be between 0 and 4.

## 7. Time Complexity

| Operation         | Time Complexity    |
| ----------------- | ------------------ |
| Insert at the end | `O(n)`             |
| Delete by ID      | `O(n)`             |
| Search by ID      | `O(n)`             |
| Bubble sort       | `O(n²)` worst case |
| Stack push        | `O(1)`             |
| Stack pop         | `O(1)`             |

## 8. Tools Used

* Java
* Eclipse IDE
* Singly Linked List
* Stack
* Linear Search
* Bubble Sort

## 9. How to Run

1. Open Eclipse IDE.
2. Open the Student Record Management System project.
3. Open `Main.java`.
4. Click Run.
5. Use the menu in the console to test the program.

## 10. Sample Records

| Student ID | Name | GPA  |
| ---------- | ---- | ---- |
| 7          | Ali  | 3.50 |
| 8          | Sara | 3.90 |

These are example records. Users can enter their own student information.

## 11. Group Members

* Sheeba Iqbal
* Dilaawaiz Khan

## 12. GitHub Repository

**Repository Name:** CS216L_Project1

## 13. Screenshots

Add screenshots of the program showing:

* Adding and displaying students.
* Searching and sorting students.
* Deleting a student and using the undo feature.

## 14. Conclusion

In this project, we learned how to use a linked list and a stack in Java. We also practiced linear search, bubble sort, and input validation. This project helped us understand how data structures can be used to manage student records.

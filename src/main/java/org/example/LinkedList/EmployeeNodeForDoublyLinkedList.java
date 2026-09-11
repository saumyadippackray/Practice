package org.example.LinkedList;

public class EmployeeNodeForDoublyLinkedList {
    Employee employee;
    EmployeeNodeForDoublyLinkedList before;
    EmployeeNodeForDoublyLinkedList next;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public EmployeeNodeForDoublyLinkedList getBefore() {
        return before;
    }

    public void setBefore(EmployeeNodeForDoublyLinkedList before) {
        this.before = before;
    }

    public EmployeeNodeForDoublyLinkedList getNext() {
        return next;
    }

    public void setNext(EmployeeNodeForDoublyLinkedList next) {
        this.next = next;
    }

    public EmployeeNodeForDoublyLinkedList(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "EmployeeNodeForDoublyLinkedList{" +
                "employee=" + employee +
                '}';
    }
}

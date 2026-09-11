package org.example.LinkedList;

public class SinglyLinkedList {
    static EmployeeNode head;
    public static void addElementtoStart(Employee employee){
        EmployeeNode employeeNode1=new EmployeeNode(employee);
        employeeNode1.setNext(head);
        head=employeeNode1;
    }
    public static void addElementtoLast(Employee employee){
        if(head==null) {
            EmployeeNode employeeNode1 = new EmployeeNode(employee);
            employeeNode1.setNext(head);
            head = employeeNode1;
        }
        else{
            EmployeeNode employeeNode1 = new EmployeeNode(employee);
            EmployeeNode node=head;
            while (node.getNext()!=null){
                node=node.getNext();
            }
            node.setNext(employeeNode1);
        }
    }
    public static void printSinglyLinkedList(){
        EmployeeNode current=head;
        while (current!=null){
            System.out.println(current);
            System.out.println(current.getNext());
            current=current.getNext();
        }
    }
    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList=new SinglyLinkedList();
        addElementtoStart(new Employee(1,"suman"));
        addElementtoStart(new Employee(2,"tuki"));
        printSinglyLinkedList();
    }


}

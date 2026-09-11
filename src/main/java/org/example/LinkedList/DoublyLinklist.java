package org.example.LinkedList;

public class DoublyLinklist {
    static EmployeeNodeForDoublyLinkedList firstNode;
    static EmployeeNodeForDoublyLinkedList lastNode;
    static int size;

    public static void addToFirst(Employee employee){
        EmployeeNodeForDoublyLinkedList employeeNodeForDoublyLinkedList=new EmployeeNodeForDoublyLinkedList(employee);
        if(firstNode==null){
            firstNode=employeeNodeForDoublyLinkedList;
            lastNode=employeeNodeForDoublyLinkedList;
        }
        else {
            EmployeeNodeForDoublyLinkedList tempNode=firstNode;
            firstNode=employeeNodeForDoublyLinkedList;
            firstNode.setNext(tempNode);
            tempNode.setBefore(firstNode);
        }
        size++;
    }

    public static void addToLast(Employee employee){
        if(lastNode==null){
            firstNode=new EmployeeNodeForDoublyLinkedList(employee);
            lastNode=new EmployeeNodeForDoublyLinkedList(employee);
        }
        else {
            EmployeeNodeForDoublyLinkedList tempLastNode=lastNode;
            lastNode=new EmployeeNodeForDoublyLinkedList(employee);
            tempLastNode.setNext(lastNode);
            lastNode.setBefore(tempLastNode);
        }
    }

    public static void removeFromFront(){
        if(firstNode!=null){
            EmployeeNodeForDoublyLinkedList removeNode=firstNode;
            firstNode=firstNode.getNext();
            firstNode.setBefore(null);
            removeNode.setNext(null);
            size--;
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList=new SinglyLinkedList();
        addToFirst(new Employee(1,"suman"));
        addToFirst(new Employee(2,"tuki"));
        addToLast(new Employee(2,"tuki2"));
        printSinglyLinkedList();
    }
    public static void printSinglyLinkedList(){
        EmployeeNodeForDoublyLinkedList current=firstNode;
        while (current!=null){
            System.out.println(current);
//            System.out.println(current.getNext());
//            System.out.println(current.getBefore());

            current=current.getNext();
        }
    }
}

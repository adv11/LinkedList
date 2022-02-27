package LinkedList;

import java.util.NoSuchElementException;

public class DoublyLinkedList {
    private DoubleListNode head;
    private DoubleListNode tail;
    private int length;

    private class DoubleListNode{
        private int data;
        private DoubleListNode prev;
        private DoubleListNode next;

        public DoubleListNode(int data){
            this.data = data;
        }
    }

    public DoublyLinkedList(){
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    // for checking if the doubly linked list is empty or not
    public boolean isEmpty(){
        return length == 0; // if the list is empty then the value of the length variable is 0.
    }

    // for getting length of the doubly linked list
    public int getLength(){
        return length;
    }

    // for printing doubly linked list from left to right
    public void displayForward(){
        if(head == null)
            return;

        DoubleListNode temp = head;
        while(temp != null){
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // for printing doubly linked list from right to left
    public void displayBackward(){
        if(tail == null)
            return;

        DoubleListNode temp = tail;
        while(temp != null){
            System.out.print(temp.data + " --> ");
            temp = temp.prev;
        }
        System.out.println("null");
    }

    // for inserting new node at the last of the doubly linked list
    public void insertAtLast(int data){
        DoubleListNode newNode = new DoubleListNode(data);
        if(isEmpty()){
            head = newNode;
        }else{
            tail.next = newNode;
            newNode.prev = tail;
        }
        tail = newNode;
        length++;
    }

    // for inserting new node at the beginning of the doubly linked list
    public void insertAtBeginning(int data){
        DoubleListNode newNode = new DoubleListNode(data);
        if(isEmpty()){
            tail = newNode;
        }else{
            head.prev = newNode;
        }
        newNode.next = head;
        head = newNode;
        length++;
    }

    // delete node from the beginning of the doubly linked list
    public DoubleListNode deleteFromBeginning(){
        if(isEmpty()) { // when there is no node
            throw new NoSuchElementException();
        }
        DoubleListNode temp = head;
        if(head == tail) { // when there is one node only
            tail = null;
        }
        else{   // for other cases
            head.next.prev = null;
        }
        head = head.next;
        temp.next = null;
        length--;
        return temp;
    }

    // deletion of node from the last of the doubly linked list
    public DoubleListNode deleteFromEnd(){
        if(isEmpty()) {
            throw new NoSuchElementException();
        }
        DoubleListNode temp = tail;
        if(head == tail){   // if there is only one node
            head = null;
        }else{  // for other cases
            tail.prev.next = null;
        }
        tail = tail.prev;
        temp.prev = null;
        length--;
        return temp;
    }
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insertAtLast(1);
        dll.insertAtLast(10);
        dll.insertAtLast(15);
        dll.insertAtLast(25);

        System.out.println("Forward Direction Printing");
        dll.displayForward();
        System.out.println("\nBackward Direction Printing");
        dll.displayBackward();

        System.out.println("Length of the DLL is : " + dll.getLength());

        dll.insertAtBeginning(28);
        dll.displayForward();

        System.out.println("\nDeleted value from beginning is : " + dll.deleteFromBeginning().data);

        dll.insertAtLast(30);
        System.out.println("\nDeleted value from the last is : " + dll.deleteFromEnd().data);
        dll.displayForward();
    }
}

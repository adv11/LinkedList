package LinkedList;
/*
* Insert a new node into the sorted linked list.
* Example :
* Input : [1, 8, 10, 16], val = 11
* Output : [1, 8, 10, 11, 16]
*/
import java.util.Scanner;

public class Insert_node_in_sorted_LinkedList extends Singly_Linked_List{
    public static SingleListNode head;
    // method for inserting the new node into the sorted linked list
    public static void insertIntoSortedLinkedList(SingleListNode newNode){
        SingleListNode current = head;
        SingleListNode prev = null;

        while(current != null && current.getData() < newNode.getData()){
            prev = current;
            current = current.getNext();
        }
        newNode.setNext(current);
        prev.setNext(newNode);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SingleListNode s1 = new SingleListNode(1);
        SingleListNode s2 = new SingleListNode(8);
        SingleListNode s3 = new SingleListNode(10);
        SingleListNode s4 = new SingleListNode(16);

        head = s1;
        s1.setNext(s2);
        s2.setNext(s3);
        s3.setNext(s4);

        System.out.println("Enter the value to be inserted into the LinkedList:");
        int data = sc.nextInt();

        System.out.println("Before inserting the newNode " + data + " into the LinkedList :");
        printLinkedList(head);

        SingleListNode newNode = new SingleListNode(data);
        newNode.setNext(null);

        System.out.println("\nAfter the newNode into the LinkedList :");
        insertIntoSortedLinkedList(newNode);
        printLinkedList(head);
    }
}

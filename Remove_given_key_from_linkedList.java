package LinkedList;
/*
* Delete the key element present in linked list.
* Input : [1, 8, 10, 11, 18], key = 11
* Output : [1, 8, 10, 18]
*/
import java.util.Scanner;

public class Remove_given_key_from_linkedList extends Singly_Linked_List{
    public static SingleListNode head;
    public static void deleteKey(int key){
        SingleListNode current = head;
        SingleListNode prev = head;

        // if the first node's value is equal to key
        if(current.getData() == key){
            head = current.getNext();
            return;
        }
        // else
        while(current != null && current.getData() != key){
            prev = current;
            current = current.getNext();
        }
        prev.setNext(current.getNext());
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the key to remove:");
        int key = sc.nextInt();

        SingleListNode sl1 = new SingleListNode(1);
        SingleListNode sl2 = new SingleListNode(8);
        SingleListNode sl3 = new SingleListNode(10);
        SingleListNode sl4 = new SingleListNode(11);
        SingleListNode sl5 = new SingleListNode(18);

        head = sl1;
        sl1.setNext(sl2);
        sl2.setNext(sl3);
        sl3.setNext(sl4);
        sl4.setNext(sl5);

        System.out.println("Before deleting the key value :");
        printLinkedList(head);

        System.out.println("\nAfter deleting the key value :");
        deleteKey(key);
        printLinkedList(head);
    }
}

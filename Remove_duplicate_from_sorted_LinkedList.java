package LinkedList;
/*
Remove the duplicate nodes from the given sorted linked list.
Example :
>> Input : [1, 1, 2, 3, 3]
>> Output : [1, 2, 3]
*/
public class Remove_duplicate_from_sorted_LinkedList extends Singly_Linked_List{
    public static SingleListNode head;
    public static void removeDuplicateNodeFromSortedLinkedList(){
        SingleListNode current = head;
        while(current != null && current.getNext() != null){
            // if the adjacent node values are equal
            if(current.getData() == current.getNext().getData()){
                current.setNext(current.getNext().getNext());
            }else{  // if values are not equal
                current = current.getNext();
            }
        }
    }
    public static void main(String[] args) {
        SingleListNode sl1 = new SingleListNode(1);
        SingleListNode sl2 = new SingleListNode(1);
        SingleListNode sl3 = new SingleListNode(2);
        SingleListNode sl4 = new SingleListNode(3);
        SingleListNode sl5 = new SingleListNode(3);

        head = sl1;
        sl1.setNext(sl2);
        sl2.setNext(sl3);
        sl3.setNext(sl4);
        sl4.setNext(sl5);

        System.out.println("Before deletion of duplicate nodes:");
        printLinkedList(head);
        System.out.println("\nAfter deletion of duplicate nodes:");
        removeDuplicateNodeFromSortedLinkedList();
        printLinkedList(head);
    }
}

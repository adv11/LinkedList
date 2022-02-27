package LinkedList;
/*
Given a linked list, we have to detect if there is any loop or not.
Input : [1, 2, 3, 4, 5, 6] , here 4.setNext(6) there is a loop given between node 4 and 6. We have to detect this loop.
Output : Loop is present in the given linked list.
*/
public class Detect_loop_int_LinkedList extends Singly_Linked_List{
    private static SingleListNode head;
    public static boolean isLoopPresent(){
        // declaring two pointers
        // slow pointer and fast pointer
        SingleListNode slowPointer = head;
        SingleListNode fastPointer = head;

        // while fast pointer is not null
        // and fastPointer.next is not null
        while(fastPointer != null && fastPointer.getNext() != null){
            fastPointer = fastPointer.getNext().getNext();
            slowPointer = slowPointer.getNext();

            if(fastPointer == slowPointer){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        SingleListNode sl1 = new SingleListNode(1);
        SingleListNode sl2 = new SingleListNode(2);
        SingleListNode sl3 = new SingleListNode(3);
        SingleListNode sl4 = new SingleListNode(4);
        SingleListNode sl5 = new SingleListNode(5);
        SingleListNode sl6 = new SingleListNode(6);

        head = sl1;
        sl1.setNext(sl2);
        sl2.setNext(sl3);
        sl3.setNext(sl4);
        sl4.setNext(sl5);
        sl5.setNext(sl6);
        sl6.setNext(sl3);

        // this will print elements infinite number of times because the linked list contains the loop.
        // printLinkedList(head);

        boolean checkLoop = isLoopPresent();
        if(checkLoop){
            System.out.println("Loop is present in the given linked list.");
        }else{
            System.out.println("Loop is not present in the given linked list.");
        }
    }
}

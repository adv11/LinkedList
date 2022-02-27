package LinkedList;
// Given a linked list, we have to delete the loop if it's present in the given linked list.

public class Remove_loop_from_LinkedList extends Singly_Linked_List{
    private static SingleListNode head;

    // function for removing the loop
    public static void removeCycle(SingleListNode sp){
        SingleListNode temp = head;
        while(temp.getNext() != sp.getNext()){
            temp = temp.getNext();
            sp = sp.getNext();
        }
        sp.setNext(null);   // this is last node of the linked list if we removed the loop
    }

    // function for checking if the loop is present or not
    public static void isCycle(){
        SingleListNode sp = head;
        SingleListNode fp = head;

        while(fp != null && fp.getNext() != null){
            sp = sp.getNext();
            fp = fp.getNext().getNext();

            // condition of presence of loop
            if(sp == fp){
                removeCycle(sp);    // if there is a loop call removeCycle function to remove cycle
            }
        }
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
        sl6.setNext(sl3);   // loop between sl3 and sl6

        // printLinkedList(head);  // this will run infinite time if loop is not removed.

        // after calling this function now our loop is removed
        isCycle();
        printLinkedList(head);  // output : 1, 2, 3, 4, 5, 6
    }
}

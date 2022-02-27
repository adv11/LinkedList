package LinkedList;
/*
Find the middle node value of the given linked list.
Example:
>> Input : [1, 2, 3, 4, 5]
>> Output : 3

>> Input : [1, 2, 3, 4]
>> Output : 3
*/
public class Middle_node_in_singly_linkedList extends Singly_Linked_List{
    public static SingleListNode head;
    public static SingleListNode getMiddle(){
        if(head == null)
            return null;

        // Creating two pointers slow and fast
        SingleListNode slowPointer = head;
        SingleListNode fastPointer = head;

        // while fastPointer is not null and
        // fastPointer.next.next is not null
        // run a loop and perform these steps.
        while (fastPointer != null && fastPointer.getNext() != null){
            slowPointer = slowPointer.getNext();
            fastPointer = fastPointer.getNext().getNext();
        }
        return slowPointer; // at last return slowPointer
    }
    public static void main(String[] args) {
        SingleListNode sl1 = new SingleListNode(10);
        SingleListNode sl2 = new SingleListNode(20);
        SingleListNode sl3 = new SingleListNode(30);
        SingleListNode sl4 = new SingleListNode(40);
        SingleListNode sl5 = new SingleListNode(50);
        SingleListNode sl6 = new SingleListNode(60);

        head = sl1;
        sl1.setNext(sl2);
        sl2.setNext(sl3);
        sl3.setNext(sl4);
        sl4.setNext(sl5);
        sl5.setNext(sl6);

        SingleListNode ans = getMiddle();
        System.out.println(ans.getData());
    }
}

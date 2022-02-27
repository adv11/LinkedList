package LinkedList;
/*
* We have given 2 sorted linked lists, and we have to merge these two linked list in a sorted manner.
* Example :
* l1 = [1, 4, 5]
* l2 = [2, 3, 10]
* Output : [1, 2, 3, 4, 5, 10]
*/
public class merge_two_sorted_linkedlist extends Singly_Linked_List{
    public static SingleListNode mergeLL_withExtraListNode(SingleListNode head1, SingleListNode head2){
        SingleListNode t1 = head1, t2 = head2;

        // we are using dummy ListNode for avoiding Null Pointer Exception.
        SingleListNode dummy = new SingleListNode(0);
        SingleListNode tail = dummy;

        while(t1 != null && t2 != null){
            if(t1.getData() <= t2.getData()){
                tail.setNext(t1);
                t1 = t1.getNext();
            }else{
                tail.setNext(t2);
                t2 = t2.getNext();
            }
            tail = tail.getNext();
        }
        if(t1 == null)
            tail.setNext(t2);
        else
            tail.setNext(t1);

        return dummy.getNext();
    }
    public static void main(String[] args) {
        SingleListNode s1 = new SingleListNode(1);
        SingleListNode s2 = new SingleListNode(4);
        SingleListNode s3 = new SingleListNode(8);
        SingleListNode head1;
        head1 = s1;
        s1.setNext(s2);
        s2.setNext(s3);
        s3.setNext(null);

        SingleListNode l1 = new SingleListNode(4);
        SingleListNode l2 = new SingleListNode(8);
        SingleListNode l3 = new SingleListNode(7);
        SingleListNode head2;
        head2 = l1;
        l1.setNext(l2);
        l2.setNext(l3);
        l3.setNext(null);

        printLinkedList(mergeLL_withExtraListNode(head1, head2));
    }
}

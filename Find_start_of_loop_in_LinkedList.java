package LinkedList;
/*
* Given a linked list where we have given a loop in it. We have to find the starting node of the loop
* from where the loop starts in the linked list.

* Input : [1, 2, 3, 4, 5, 6] , there is a loop between 3 and 6.
* Output : 3 because loop starts from 3.
*/
public class Find_start_of_loop_in_LinkedList extends Singly_Linked_List{
    private static SingleListNode head;
    // It is detecting the loop in the linked list
    // and sending slowPointer for achieving starting node's data
    public static int isCycle(){
        SingleListNode slowPointer = head;
        SingleListNode fastPointer = head;
        while(fastPointer != null && fastPointer.getNext() != null){
            slowPointer = slowPointer.getNext();
            fastPointer = fastPointer.getNext().getNext();

            if(slowPointer == fastPointer){
                return getStartNode(slowPointer).getData();
            }
        }
        return -1;
    }
    // it is outputting starting node's data
    public static SingleListNode getStartNode(SingleListNode slowPointer){
        SingleListNode temp = head;
        while(temp != slowPointer){
            temp = temp.getNext();
            slowPointer = slowPointer.getNext();
        }
        return temp;
    }
    public static void main(String[] args) {
        SingleListNode s1 = new SingleListNode(1);
        SingleListNode s2 = new SingleListNode(2);
        SingleListNode s3 = new SingleListNode(3);
        SingleListNode s4 = new SingleListNode(4);
        SingleListNode s5 = new SingleListNode(5);
        SingleListNode s6 = new SingleListNode(6);

        head = s1;
        s1.setNext(s2);
        s2.setNext(s3);
        s3.setNext(s4);
        s4.setNext(s5);
        s5.setNext(s6);
        s6.setNext(s3);     // here we have created a loop between s3 and s6

        System.out.println("Starting node of the loop in the linked list is : " + isCycle());
    }
}

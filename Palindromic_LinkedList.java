package LinkedList;

public class Palindromic_LinkedList extends Singly_Linked_List{
    public static SingleListNode head;
    public static boolean isPalindrome(){
        // finding middle node
        SingleListNode sp = head;
        SingleListNode fp = head;
        while(fp != null && fp.getNext() != null){
            sp = sp.getNext();
            fp = fp.getNext().getNext();
        }

        // reversing the half of linked list
        SingleListNode curr = sp;
        SingleListNode prev = null;
        SingleListNode next = null;
        while(curr != null){
            next = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = next;
        }   // here prev is our new node

        // now we will run a loop from old head pointer to null
        // and from new head(prev) to null
        // if all the values matched then it is palindrome otherwise not.
        SingleListNode start = head;
        while(head != null && head.getNext() != null){
            // checking for matched values
            if(start.getData() == prev.getData()){
                start = start.getNext();
                prev = prev.getNext();
                head = head.getNext();
            }else{
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        SingleListNode sl1 = new SingleListNode(1);
        SingleListNode sl2 = new SingleListNode(2);
        SingleListNode sl3 = new SingleListNode(2);
        SingleListNode sl4 = new SingleListNode(1);

        head = sl1;
        sl1.setNext(sl2);
        sl2.setNext(sl3);
        sl3.setNext(sl4);

        printLinkedList(head);
        System.out.println();
        System.out.println(isPalindrome());
    }
}

package LinkedList;
/*
Given a linked list, we have to find the length of the loop.

Input : [1, 2, 3, 4, 5, 6] , loop is between 3 and 6
Output : length of loop = 4
*/
public class Find_length_of_loop extends Singly_Linked_List{
    private static SingleListNode head;
    public static int lengthOfLoop(){
        SingleListNode sp = head;
        SingleListNode fp = head;

        boolean flag = false;
        int lengthOfLoop = 0;
        while(fp != null && fp.getNext() != null){
            sp = sp.getNext();
            fp = fp.getNext().getNext();

            // if loop then break the loop
            if(sp == fp){
                flag = true;
                break;
            }
        }
        // we are shifting slowPointer until it meets the fastPointer again at the same point.
        // taking a length variable and increasing it unit slowPointer reaches again to fastPointer
        if(flag){
            // because sp and fp are at same point, so we are using do while loop
            // first increasing sp then checking for the (sp != fp) condition
            // until we not this condition we increase the length variable
            do{
                sp = sp.getNext();
                lengthOfLoop++;
            }while(sp != fp);
        }
        return lengthOfLoop;
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

        System.out.println(lengthOfLoop());
    }
}

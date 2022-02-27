package LinkedList;

public class SingleListNode {
    private int data;
    private SingleListNode next;

    public SingleListNode(int data){
        this.data = data;
    }

    public void setData(int data){
        this.data = data;
    }

    public int getData(){
        return data;
    }

    public void setNext(SingleListNode next){
        this.next = next;
    }

    public SingleListNode getNext(){
        return this.next;
    }
}

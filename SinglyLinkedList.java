public class SinglyLinkedList {

    Node head;

    SinglyLinkedList() {
        this.head = null;
    }

    public int getLength() {
        int length=0;
        if(head==null) {
            return 0;
        }else {
            Node current = head;
            while(current!=null) {
                current=current.next;
                length++;
            }
        }
        return length;
    }

    void append(int data) {
        Node append = new Node (data);

        if(head==null) {
            head = append;
        }
        else {
            Node current = head;
            while(current.next!=null) {
                current=current.next;
            }
            current.next = append;
        }
    }

    public void prepend(int data) {
        Node prepend = new Node(data);
        prepend.next = head;
        head = prepend;
    }

    public void removeHead() {
        head = head.next;
    }

    public void removeTail() {
        Node current= head;
        while(current.next.next!=null) {
            current=current.next;
        }
        current.next = null;
    }

    public void insertAt(int index, int data) {
        Node insert = new Node(data);
        if(index==0){
            prepend(data);
        }else {
            Node current = head;

            for(int i = 0; i<index-1; i++) {
                current = current.next;
            }
            insert.next = current.next;
            current.next = insert;
        }
    }

    public void show () {
        Node show =head;

        while(show!=null) {
            System.out.print(show.data + ", ");
            show=show.next;
        }
        if(head==null) {
            System.out.print("Empty List");
        }
    }

    public void deleteAt(int index) {
        if(index==0) {
            head = head.next;
        }else {
            Node current=head;

            for(int i = 0; i<index-1; i++) {
                current=current.next;
            }
            current.next.next=current.next;
            current.next=current.next.next;
            current.next.next=null;
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        //list.append (10);
        //list.append(33);
        //list.append(199);
        list.prepend(1000);
        list.prepend(1111);
        //list.removeHead();
        //list.removeTail();

        list.show();

        System.out.println("\nLength "+list.getLength());
    }

    class Node{
        int data;
        Node next;

        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
}